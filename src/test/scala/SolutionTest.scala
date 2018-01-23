import org.scalatest.{FlatSpec, Matchers}
import java.io.{ByteArrayInputStream, ByteArrayOutputStream, PrintStream}
import scala.io.Source

class SolutionTest extends FlatSpec with Matchers {

  val prefix = "concave-polygon/tricky"

  def readFileToString(fileName: String): String =
    Source.fromURL(getClass.getResource(fileName)).getLines().mkString("\n")

  // TODO: Add error margin of +/- 0.2 for convex-hull tests
  "Concave Polygon" should "work" in {
    val myOut = new ByteArrayOutputStream
    Console.withOut(new PrintStream(myOut)) {
      System.setIn(new ByteArrayInputStream(readFileToString(s"$prefix/test").getBytes()))

      Solution.main(Array.empty)
    }

    myOut.toString shouldEqual readFileToString(s"$prefix/expected")
  }

}
