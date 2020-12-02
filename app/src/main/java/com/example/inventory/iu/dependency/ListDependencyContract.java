package com.example.inventory.iu.dependency;

import com.example.inventory.iu.base.BasePresenter;
import com.example.inventory.iu.base.BaseView;

public interface ListDependencyContract {

    interface View extends BaseView {

        //Método que muestra una barra de progreso en la interfaz
        //mientras se realiza una acción en el interactor
        void showProgress();

        //Método que oculta la barra de progreso en la interfaz
        void  hideProgress();

        //Activa la parte de la vista que indica que no hay datos
        void setNoData();



    }

    interface Presenter extends BasePresenter {
        void load();
    }
}
