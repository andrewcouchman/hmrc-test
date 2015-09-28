package com.hmrctest.checkout

import scala.collection.immutable.IndexedSeq

class CheckoutSystem() {
  def processProducts(productList: IndexedSeq[String]):BigDecimal = BigDecimal("0.6") * productList.size

}
