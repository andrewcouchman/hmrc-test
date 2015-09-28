package com.hmrctest.checkout

object CheckoutEndToEndTest extends App {
  runTest()

  def runTest(): Unit = {
    tenApplesShouldCostSixPounds()
  }
  def tenApplesShouldCostSixPounds(){
    val productList = (1 to 10).map(_ => "Apple")
    val totalPrice = new CheckoutSystem().processProducts(productList)
    assert(totalPrice == BigDecimal(6))
  }
}
