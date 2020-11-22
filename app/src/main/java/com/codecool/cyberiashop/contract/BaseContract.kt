package com.codecool.cyberiashop.contract

interface BaseContract {

    interface BaseView {
        fun showLoading()
        fun hideLoading()
        fun onError()
    }

    interface BasePresenter{
        fun onAttach(view: BaseView)
        fun onDetach()
    }
}