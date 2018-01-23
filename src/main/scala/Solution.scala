import cartesian.{ConvexHull, Orderer, Point, Polygon}

import scala.io.Source

object Solution {

  def concavePolygon(points: Seq[Point]): String = {
    if (Polygon(Orderer.counterclockwise(points)).isConcave)
      "YES"
    else
      "NO"
  }

  def convexHull(points: Seq[Point]): String = {
    Polygon(ConvexHull(points)).perimeter.toString
  }

  def main(args: Array[String]) {
    val lines = Source.stdin.getLines
    val nPoints = lines.next.toInt

    val points = lines.take(nPoints).toList
      .map(_.split(" "))
      .map { case Array(x, y) => Point(x.toInt, y.toInt) }

    println(concavePolygon(points))
  }
}