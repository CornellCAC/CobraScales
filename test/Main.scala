package cobrascales

import cobrascales.optimization._

object Main{
  def main( args: Array[String] ): Unit = {
    println("**** Running COBRAScales tests ****")

    // Verify basic language features are testable
    case class Foo(ii: Int = 5)
    assert(Foo().ii == 5)

    optimizationTests()


  }
}
