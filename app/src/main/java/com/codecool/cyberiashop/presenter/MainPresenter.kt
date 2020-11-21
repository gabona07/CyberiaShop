package com.codecool.cyberiashop.presenter

import com.codecool.cyberiashop.contract.BaseContract
import com.codecool.cyberiashop.contract.MainContract
import com.codecool.cyberiashop.model.Product

class MainPresenter : MainContract.MainPresenter{

    var products = ArrayList<Product>()
    var view : MainContract.MainView? = null;

    override fun databaseInit() : ArrayList<Product> {
        products.add(Product("Reflex Stabilizer", "15$", "Move like a cat. Meow.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b8d4a-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("USB Finger", "5$", "Connect the world to your fingertip.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b90c4-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Bionic Eye Implant", "35$", "See more than you have ever seen.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b91d2-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Dialect Chip", "25$", "Be able to speak the 69420 languages of our world.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b92ae-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Horse B100-02", "125$", "Impress your neighbours with this beautiful creature.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b9510-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Sheep AZ15-82", "105$", "You can feel the warmth of his nose.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b95d8-62b8-11ea-bc55-0242ac130003.jpg"))
        return products
    }

    override fun onAttach(view: BaseContract.BaseView) {
        this.view = view as MainContract.MainView
    }

    override fun onDetach() {
        this.view = null
    }
}