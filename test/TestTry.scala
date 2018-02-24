package cobrascales

import scala.util.{Try, Success, Failure}

object TestTry {

  def apply(someFun: Unit): Unit = {
    val tryIt = Try( someFun )
    tryIt match {
      case Success(ss) => {}
      case Failure(fail) => fail.printStackTrace
    }

    ()
  }
}