package com.hmrctest.checkout

class CheckoutSystem() {
  def processProducts(productList: Seq[String]):BigDecimal = {
    productList.map {
      case "Apple" => BigDecimal("0.6")
      case _ => BigDecimal("0.25")
    }.sum
  }
}