package cobrascales.optimization

import optimus.optimization._


import cobrascales.TestTry

object OptimusCS {

  def optimusTests(): Unit = {
    println("*** Running Optimus tests ***")

    println("** Running ojalgo tests **")
    implicit var solver = SolverLib.ojalgo

    TestTry(() => { 
      implicit var problem = makeSimpleLP()
      start()
      println("objective: " + objectiveValue)
      //println("x = " + x.value + "y = " + y.value)
      release()
    })

  }

  def makeSimpleLP()(implicit solver: SolverLib.Value): LQProblem = {
    implicit val problem = LQProblem(solver)

    val x = MPFloatVar("x", 100, 200)
    val y = MPFloatVar("y", 80, 170)

    maximize(-2 * x + 5 * y)
    add(y >:= -x + 200)

    problem
  }

}