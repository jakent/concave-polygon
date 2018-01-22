package cartesian

case class Point(x: Int, y: Int) {
  def polarAngle(from: Point = Point(0, 0)): Double = {
    val relativeX = x - from.x.toDouble
    val relativeY = y - from.y.toDouble

    val angle = Math.toDegrees(Math.atan(relativeY / relativeX))

    if (relativeX >= 0 && relativeY >= 0) angle
    else if (relativeX >= 0) angle + 360
    else angle + 180
  }
}

object Point {
  def distance(p1: Point, p2: Point): Double = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2))
}
