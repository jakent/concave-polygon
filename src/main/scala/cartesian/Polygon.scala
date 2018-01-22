package cartesian

case class Polygon(vertices: Seq[(Point, Point, Point)]) {
  def isConcave: Boolean = {
    val positiveCrossProducts = vertices.map(p => Polygon.crossProduct(p._1, p._2, p._3) >= 0)
    !positiveCrossProducts.forall(_ == positiveCrossProducts.head)
  }
}

object Polygon {
  def crossProduct(a: Point, b: Point, c: Point): Int = {
    val dx1 = b.x - a.x
    val dy1 = b.y - a.y
    val dx2 = c.x - b.x
    val dy2 = c.y - b.y
    (dx1 * dy2) - (dy1 * dx2)
  }

  def apply(points: => Seq[Point]): Polygon = {
    def loop(l: Seq[Point], acc: Seq[(Point, Point, Point)]): Seq[(Point, Point, Point)] = l match {
      case f :: s :: t :: tail => loop(s :: t :: tail, acc :+ (f, s, t))
      case _ => acc
    }

    new Polygon(loop(points.last +: points :+ points.head, Nil))
  }
}
