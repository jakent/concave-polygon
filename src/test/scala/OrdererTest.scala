import cartesian.{Orderer, Point}
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

}
