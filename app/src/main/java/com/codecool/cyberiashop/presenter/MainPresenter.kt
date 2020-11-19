package com.codecool.cyberiashop.presenter

import com.codecool.cyberiashop.contract.BaseContract
import com.codecool.cyberiashop.contract.MainContract
import com.codecool.cyberiashop.model.Product

class MainPresenter : MainContract.MainPresenter{

    var products = ArrayList<Product>()
    var view : MainContract.MainView? = null;

    override fun databaseInit() : ArrayList<Product> {
        products.add(Product("Red Pepper", "5$", "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.pngpix.com%2Fwp-content%2Fuploads%2F2016%2F10%2FPNGPIX-COM-Cactus-PNG-Transparent-Image-5-250x357.png&f=1&nofb=1"))
        products.add(Product("Bolyhocska", "5$","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.yGZui0hAEtgRZVeXQwMRpQHaHK%26pid%3DApi&f=1"))
        products.add(Product("Cactus", "5$","https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.transparentpng.com%2Fthumb%2Fcactus%2Fp9FUrP-cactus-transparent-background.png&f=1&nofb=1"))
        products.add(Product("Flowery", "5$","https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.florafinder.com%2FSpecies%2FPics%2FEchinocereus_maritimus.png&f=1&nofb=1"))


        return products
    }

    override fun onAttach(view: BaseContract.BaseView) {
        this.view = view as MainContract.MainView
    }


    override fun onDetach() {
        this.view = null
    }
}