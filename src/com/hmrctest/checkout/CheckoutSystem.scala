package com.hmrctest.checkout

class CheckoutSystem() {
  val applePrice: BigDecimal = BigDecimal("0.3")

  def processProducts(productList: Seq[String]): BigDecimal = {
    val (apples, oranges) = productList.partition(_ == "Apple")

    apples.size * applePrice +
      (apples.size % 2 match {
        case 0 => 0
        case _ => applePrice
      }) +
      oranges.size * BigDecimal("0.25")
  }
}