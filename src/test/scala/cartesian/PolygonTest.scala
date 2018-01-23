package cartesian

import org.scalatest.{FlatSpec, Matchers}

class PolygonTest extends FlatSpec with Matchers {

  "Polygon" should "compute vertices" in {
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

  it should "compute perimeter" in {
    Polygon(Seq(
      Point(0, 0),
      Point(2, 0),
      Point(2, 2),
      Point(0, 2)
    )).perimeter shouldBe 8.0
  }

}
