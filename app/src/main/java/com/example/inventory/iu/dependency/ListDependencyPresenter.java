package com.example.inventory.iu.dependency;

import com.example.inventory.data.model.Dependency;

import java.util.List;

public class ListDependencyPresenter implements ListDependencyContract.Presenter, ListDependencyInteractorImpl.ListDependencyInteractor {

    private ListDependencyInteractorImpl interactor;
    private  ListDependencyContract.View view;

    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.interactor = new ListDependencyInteractorImpl(this);
        this.view = view;
    }

    /**
     * Este metodo viene del contrato con la vista
     */
    @Override
    public void load() {
        view.showProgress();
        interactor.load();

    }

    /**
     * Este metodo viene de la interfaz de BasePresenter
     */
    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }

    /**
     * Este metodo viene de la interfaz de ListDependencyInteractor
     */
    @Override
    public void OnNoData() {
        view.hideProgress();
        view.setNoData();
    }

    /**
     * Este metodo viene de la interfaz de ListDependencyInteractor
     */
    @Override
    public void OnSuccess(List<Dependency> list) {
        view.hideProgress();
        view.onSuccess(list);
    }
}
