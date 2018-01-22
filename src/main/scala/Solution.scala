import cartesian.{Orderer, Point, Polygon}

import scala.io.Source

object Solution {
  def main(args: Array[String]) {
    val lines = Source.stdin.getLines
    val nPoints = lines.next.toInt

    val points1 = lines.take(nPoints).toList
      .map(_.split(" "))
      .map { case Array(x, y) => Point(x.toInt, y.toInt) }

    if (Polygon(Orderer.counterclockwise(points1)).isConcave)
      println("YES")
    else
      println("NO")
  }
}