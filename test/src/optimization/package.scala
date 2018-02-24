package cobrascales

import cobrascales.optimization.joptimizer.JOptimizerCS._

package object optimization {
  def optimizationTests(): Unit = {
    println("*** Running optimization tests ***")

    joptimizerTests()

  }
}
