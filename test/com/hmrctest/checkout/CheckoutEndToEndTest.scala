package com.hmrctest.checkout

object CheckoutEndToEndTest extends App {
  runTest()

  def runTest(): Unit = {
    tenApplesShouldCostSixPounds()
    fiveApplesShouldCostThreePounds()
  }
  def tenApplesShouldCostSixPounds(){
    val productList = (1 to 10).map(_ => "Apple")
    val totalPrice = new CheckoutSystem().processProducts(productList)
    assert(totalPrice == BigDecimal(6))
  }

  def fiveApplesShouldCostThreePounds(): Unit = {
    val productList = (1 to 5).map(_ => "Apple")
    val totalPrice = new CheckoutSystem().processProducts(productList)
    assert(totalPrice == BigDecimal(3))

  }
}
