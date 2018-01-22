package cartesian

import org.scalatest.{FlatSpec, Matchers}

class OrdererTest extends FlatSpec with Matchers {

  "Orderer" should "order simple set of points counterclockwise" in {
    Orderer.counterclockwise(Seq(
      Point(6, 3),
      Point(2, 4),
      Point(6, 1)
    )) shouldBe Seq(
      Point(6, 1),
      Point(6, 3),
      Point(2, 4)
    )
  }

  it should "order a set of points counterclockwise with two of the points having the same polar angle" in {
    Orderer.counterclockwise(Seq(
      Point(0, 0),
      Point(2, 0),
      Point(0, 2),
      Point(2, 2),
      Point(1, 0)
    )) shouldBe Seq(
      Point(0, 0),
      Point(1, 0),
      Point(2, 0),
      Point(2, 2),
      Point(0, 2)
    )
  }

}
