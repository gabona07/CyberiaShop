package com.codecool.cyberiashop.presenter

import com.codecool.cyberiashop.contract.BaseContract
import com.codecool.cyberiashop.contract.MainContract
import com.codecool.cyberiashop.model.Product

class MainPresenter : MainContract.MainPresenter{

    var products = ArrayList<Product>()
    var view : MainContract.MainView? = null;

    override fun databaseInit() : ArrayList<Product> {
        products.add(Product("Reflex Stabilizer","Cyberware", "15$", "Move like a cat. Meow.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b8d4a-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("USB Finger", "Cyberware","5$", "Connect the world to your fingertip.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b90c4-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Bionic Eye Implant","Cyberware", "35$", "See more than you have ever seen.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b91d2-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Dialect Chip", "Cyberware","25$", "Be able to speak the 69420 languages of our world.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b92ae-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Horse B100-02", "Electric Animal","125$", "Impress your neighbours with this beautiful creature.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b9510-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Sheep AZ15-82", "Electric Animal","105$", "You can feel the warmth of his nose.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b95d8-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Dog LT54-62", "Electric Animal","155$", "Guards your house and cares for children, so you don''t need to.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b97ea-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Cat ZY85-32", "Electric Animal","115$", "An inseparable pair. Now comes in a bundle.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b98bc-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Proton Pants", "Clothing","15$", "Proton Pants are back! Adjustable at the sides, with gigantic pockets.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b997a-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Space Commander Bodysuit", "Clothing","20$", "Limited edition bodysuit with eye-catching translucent box and a hood with visor.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b9a42-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Trapper Dress", "Clothing","10$", "Part of the Electric Dreams collection by Terry Davy.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b9b00-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Black (K)night Wear Woman", "Clothing","25$", "Durable, feminine and black. Do you need more?","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b9bc8-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Black (K)night Wear Man", "Clothing","25$", "Durable, masculine and black. Do you need more?","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b9c90-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Urban Wear Woman", "Clothing","25$", "Comfortable, feminine and brown. Do you need more?","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b9eb6-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Urban Wear Man", "Clothing","25$", "Comfortable, masculine and brown. Do you need more?","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9b9f88-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Duo Goggles", "Clothing","5$", "Has a built-in microchip visor.","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9ba046-62b8-11ea-bc55-0242ac130003.jpg"))
        products.add(Product("Viral Glasses", "Clothing","5$", "Funky glasses which create a psychedelic experience!","https://raw.githubusercontent.com/CodecoolGlobal/webshop-java-jawashop/develop/src/main/webapp/static/img/uploads/3f9ba104-62b8-11ea-bc55-0242ac130003.jpg"))
        return products
    }

    override fun getAnimalItems(): List<Product> {
        return products.filter { product -> product.type == "Electric Animal"  }
    }

    fun getCyberwareItems(): List<Product> {
        return products.filter { product -> product.type == "Cyberware"  }
    }

    fun getClothingItems(): List<Product> {
        return products.filter { product -> product.type == "Clothing"  }
    }

    override fun onAttach(view: BaseContract.BaseView) {
        this.view = view as MainContract.MainView
    }

    override fun onDetach() {
        this.view = null
    }
}