package com.hmrctest.checkout

class CheckoutSystem() {
  val appleCalculator: OnOfferProductCalculator = new OnOfferProductCalculator(2, BigDecimal("0.6"))
  val orangeCalculator: OnOfferProductCalculator = new OnOfferProductCalculator(3, BigDecimal("0.25"))

  def processProducts(productList: Seq[String]): BigDecimal = {
    val (apples, oranges) = productList.partition(_ == "Apple")

    appleCalculator.calculateFor(apples.size) +
      orangeCalculator.calculateFor(oranges.size)
  }
}

case class OnOfferProductCalculator(freeProductIncrement: Int, normalPrice: BigDecimal) {
  def calculateFor(numberOfProducts: Int): BigDecimal = {
    val discountedProductCost = (numberOfProducts / freeProductIncrement) * (normalPrice * (freeProductIncrement - 1))
    val standardRateProductCost = (numberOfProducts % freeProductIncrement) * normalPrice
    discountedProductCost + standardRateProductCost
  }
}