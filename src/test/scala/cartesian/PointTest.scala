package cartesian

import org.scalatest.{FlatSpec, Matchers}

class PointTest extends FlatSpec with Matchers {

  "Point" should "calculate polar angle from origin" in {
    Point(1, 1).polarAngle() shouldBe 45.0
  }

  it should "calculate polar angle from some point in quadrant 1" in {
    Point(1, 1).polarAngle(Point(1, 0)) shouldBe 90.0
  }

  it should "calculate polar angle from some point in quadrant 2" in {
    Point(1, 1).polarAngle(Point(2, 0)) shouldBe 135.0
  }
}
