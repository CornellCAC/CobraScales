package cobrascales

import cobrascales.optimization.JOptimizerCS._
import cobrascales.optimization.OptimusCS._

package object optimization {
  def optimizationTests(): Unit = {
    println("*** Running optimization tests ***")

    joptimizerTests()

    optimusTests()

  }
}
