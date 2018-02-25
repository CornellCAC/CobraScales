package cobrascales

/**
  * Created by Brandon Barker on 2/25/18.
  */
package object syntax {

  @specialized def discard[A](evaluateForSideEffectOnly: A): Unit = {
    val _: A = evaluateForSideEffectOnly
    () //Return unit to prevent warning due to discarding value
  }

}
