package com.mrg.ecommerceapp.Adapters

import kotlin.properties.Delegates

class Mylist( private  var title : String,
              private  var decription : String,
              private var img :Int) {

    var etitle : String = this.title
    var edecription : String = this.decription
    var eimg : Int = this.img

}
