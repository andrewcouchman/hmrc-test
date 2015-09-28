package com.hmrctest.checkout

import scala.collection.immutable.IndexedSeq

class CheckoutSystem() {
  def processProducts(productList: IndexedSeq[String]):BigDecimal = {
    productList.map {
      case "Apple" => BigDecimal("0.6")
      case _ => BigDecimal("0.25")
    }.sum
  }
}