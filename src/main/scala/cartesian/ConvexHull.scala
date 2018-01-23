package cartesian

object ConvexHull {

  object Orientation extends Enumeration {
    val Clockwise, CounterClockwise, Collinear = Value
  }

  def orientation(p1: Point, p2: Point, p3: Point): Orientation.Value = {
    val slope = (p2.y - p1.y) * (p3.x - p2.x) - (p2.x - p1.x) * (p3.y - p2.y)

    if (slope == 0) Orientation.Collinear
    else if (slope > 0) Orientation.Clockwise
    else Orientation.CounterClockwise
  }

  def removePolarAngleDuplicates(points: Seq[Point]): Seq[Point] = {
    def loop(origin: Point, blah: Seq[Point], acc: Seq[Point]): Seq[Point] = blah match {
      case f :: s :: tail => {
        if (f.polarAngle(origin) == s.polarAngle(origin)) loop(origin, s :: tail, acc)
        else loop(origin, s :: tail, acc :+ f)
      }
      case loo :: Nil => acc :+ loo
    }

    loop(points.head, points.tail, List(points.head))
  }

  def acceptOrReject(points: Seq[Point]): Seq[Point] = {
    def loop(blah: Seq[Point], acc: Seq[Point]): Seq[Point] = blah match {
      case p :: c :: n :: tail => orientation(p, c, n) match {
        case Orientation.CounterClockwise => loop(c :: n :: tail, acc :+ c)
        case _ => loop(p :: n :: tail, acc)
      }
      case _ => acc
    }

    loop(points :+ points.head, Seq(points.head))
  }

  def apply(points: Seq[Point]): Seq[Point] = {
    acceptOrReject(removePolarAngleDuplicates(Orderer.counterclockwise(points))) match {
      case l if l == points => points
      case e => ConvexHull(e)
    }
  }
}
