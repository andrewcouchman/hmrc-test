package com.hmrctest.checkout

import scala.collection.immutable.IndexedSeq

class CheckoutSystem() {
  def processProducts(productList: IndexedSeq[String]):BigDecimal = {
    productList.head match{
      case "Apple" => BigDecimal("0.6") * productList.size
      case _ => BigDecimal("0.25") * productList.size
    }
  }
}