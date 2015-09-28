package com.hmrctest.checkout

object CheckoutEndToEndTest extends App {
  runTest()

  def runTest(): Unit = {
    oneAppleShouldCostSixtyPence()
    twoApplesShouldCostSixtyPence()
    tenApplesShouldCostThreePounds()

    fiveOrangesShouldCostOnePound()
    aMixOfThreeOrangesAndFourApplesCostsOnePoundSeventy()
  }

  def oneAppleShouldCostSixtyPence(): Unit = {
    val productList = List("Apple")
    val totalPrice = new CheckoutSystem().processProducts(productList)
    assertEquals(totalPrice, BigDecimal(0.6))
  }

  def twoApplesShouldCostSixtyPence(): Unit = {
    val productList = (1 to 2).map(_ => "Apple")
    val totalPrice = new CheckoutSystem().processProducts(productList)
    assertEquals(totalPrice, BigDecimal(0.6))
  }

  def tenApplesShouldCostThreePounds() {
    val productList = (1 to 10).map(_ => "Apple")
    val totalPrice = new CheckoutSystem().processProducts(productList)
    assertEquals(totalPrice, BigDecimal(3))
  }

  def fiveOrangesShouldCostOnePound(): Unit = {
    val productList = (1 to 5).map(_ => "Orange")
    val totalPrice = new CheckoutSystem().processProducts(productList)
    assertEquals(totalPrice, BigDecimal(1))
  }

  def aMixOfThreeOrangesAndFourApplesCostsOnePoundSeventy(): Unit = {
    val productList = (1 to 3).map(_ => "Orange") ++ (1 to 4).map(_ => "Apple")
    val totalPrice = new CheckoutSystem().processProducts(productList)
    assertEquals(totalPrice, BigDecimal(1.7))
  }

  def assertEquals(first: Any, second: Any) = {
    if (first != second) {
      throw new AssertionError(first + " != " + second)
    }
  }
}
