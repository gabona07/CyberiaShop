package com.codecool.cyberiashop.contract

import com.codecool.cyberiashop.model.Product

interface MainContract: BaseContract {

    interface MainView: BaseContract.BaseView {

    }

    interface MainPresenter: BaseContract.BasePresenter {
        fun databaseInit() : ArrayList<Product>
    }
}