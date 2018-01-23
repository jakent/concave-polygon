package cartesian

import cartesian.ConvexHull.Orientation
import org.scalatest.{FlatSpec, Matchers}

class ConvexHullTest extends FlatSpec with Matchers {

  "ConvexHull" should "compute collinear orientation" in {
    ConvexHull.orientation(Point(3, 3), Point(0, 0), Point(1, 1)) shouldBe Orientation.Collinear
  }

  it should "compute counterclockwise orientation" in {
    ConvexHull.orientation(Point(0, 0), Point(4, 4), Point(1, 2)) shouldBe Orientation.CounterClockwise
  }

  it should "compute clockwise orientation" in {
    ConvexHull.orientation(Point(1, 2), Point(4, 4), Point(0, 0)) shouldBe Orientation.Clockwise
  }

  it should "remove closest points with the same polar angle" in {
    val points = List(
      Point(0, 0),
      Point(1, 0),
      Point(2, 0),
      Point(1, 1),
      Point(2, 2),
      Point(0, 1),
      Point(0, 2)
    )

    ConvexHull.removePolarAngleDuplicates(points) shouldBe List(
      Point(0, 0),
      Point(2, 0),
      Point(2, 2),
      Point(0, 2)
    )
  }

//  // TODO: sorting is not using 0,0 as origin
//  ignore should "compute" in {
//    ConvexHull(List(
//      Point(0, 3),
//      Point(2, 3),
//      Point(1, 1),
//      Point(2, 1),
//      Point(3, 0),
//      Point(0, 0),
//      Point(3, 3))
//    ) shouldBe List(
//      Point(0, 0),
//      Point(3, 0),
//      Point(3, 3),
//      Point(0, 3)
//    )
//  }

  it should "do some more" in {
    ConvexHull(List(
      Point(1, 1),
      Point(2, 5),
      Point(3, 3),
      Point(5, 3),
      Point(3, 2),
      Point(2, 2)
    )) shouldBe List(
      Point(1, 1),
      Point(5, 3),
      Point(2, 5)
    )
  }

  it should "do some more again" in {
    ConvexHull(List(
      Point(732, 590),
      Point(415, 360),
      Point(276, 276),
      Point(229, 544),
      Point(299, 95)
    )) shouldBe List(
      Point(299, 95),
      Point(732, 590),
      Point(229, 544)
    )
  }

  it should "do some more again again" in {
    ConvexHull(List(
      Point(441, 932),
      Point(277, 526),
      Point(82, 860),
      Point(635, 382),
      Point(165, 142)
    )) shouldBe List(
      Point(165, 142),
      Point(635, 382),
      Point(441, 932),
      Point(82, 860)
    )
  }

  it should "do some more again again again" in {
    ConvexHull(List(
      Point(1, 1),
      Point(2, 5),
      Point(3, 3),
      Point(5, 3),
      Point(3, 2)
    )) shouldBe List(
      Point(1, 1),
      Point(5, 3),
      Point(2, 5)
    )
  }
}
