package cobrascales.optimization.joptimizer

import com.joptimizer.functions.ConvexMultivariateRealFunction
import com.joptimizer.functions.LinearMultivariateRealFunction
import com.joptimizer.optimizers.JOptimizer
import com.joptimizer.optimizers.OptimizationRequest

import cobrascales.TestTry

object JOptimizerCS {

  def joptimizerTests(): Unit = {
    println("*** Running JOptimizer tests ***")

    TestTry(runSimpleLP)
    println("after runSimpleLP") //DEBUG

  }

  /**
    Makes a simple problem from https://stackoverflow.com/a/41445743/3096687

  **/

  def runSimpleLP: Unit = {
    // Objective function (plane)
    //minimize 3x+4y
    val objectiveFunction: LinearMultivariateRealFunction =
      new LinearMultivariateRealFunction(Array(3.0, 4.0), 0)

    //inequalities (polyhedral feasible set G.X<H )
    val inequalities: Array[ConvexMultivariateRealFunction] =
      Array.ofDim[ConvexMultivariateRealFunction](4)

    // x >= 0
    // focus: -x+0 <= 0
    inequalities(0) =
      new LinearMultivariateRealFunction(Array(-1.0, 0.00), 0.0)

    // y >= 0
    // focus: -y+0 <= 0
    inequalities(1) =
      new LinearMultivariateRealFunction(Array(0.0, -1.00), 0.0)

    // 2x+3y >= 8
    // focus: -2x-3y+8 <= 0
    inequalities(2) =
      new LinearMultivariateRealFunction(Array(-2.0, -3.00), 8.0)

    // 5x+2y >= 12
    // focus: -5x-2y+12 <= 0
    inequalities(3) =
      new LinearMultivariateRealFunction(Array(-5.0, -2.00), 12.0)

    //optimization problem
    val or: OptimizationRequest = new OptimizationRequest()
    or.setF0(objectiveFunction)
    or.setFi(inequalities)
    //or.setInitialPoint(new double[] {0.0, 0.0});//initial feasible point, not mandatory
    or.setToleranceFeas("1E-9".toDouble)
    or.setTolerance("1E-9".toDouble)
    //optimization
    val opt: JOptimizer = new JOptimizer()
    opt.setOptimizationRequest(or)
    opt.optimize()
    val sol: Array[Double] = opt.getOptimizationResponse.getSolution
    println("Length: " + sol.length)
    for (i <- 0 until sol.length / 2) {
      println(
        "X" + (i + 1) + ": " + Math.round(sol(i)) + "\ty" + (i + 1) +
          ": " + Math.round(sol(i + 1)))
    }
  }



}
