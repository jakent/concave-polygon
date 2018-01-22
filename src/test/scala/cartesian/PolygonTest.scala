package cartesian

import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.{FlatSpec, Matchers}

class PolygonTest extends FlatSpec with Matchers {

  implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.01)

  "cartesian.Polygon" should "compute vertices" in {
    Polygon(Seq(
      Point(0, 0),
      Point(2, 0),
      Point(2, 2),
      Point(0, 2)
    )) shouldBe Polygon(Seq(
      (Point(0, 2), Point(0, 0), Point(2, 0)),
      (Point(0, 0), Point(2, 0), Point(2, 2)),
      (Point(2, 0), Point(2, 2), Point(0, 2)),
      (Point(2, 2), Point(0, 2), Point(0, 0))
    ))
  }
}
