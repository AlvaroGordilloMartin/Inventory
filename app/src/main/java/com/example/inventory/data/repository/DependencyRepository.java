package com.example.inventory.data.repository;

import com.example.inventory.data.model.Dependency;

import java.util.ArrayList;
import java.util.List;

public class DependencyRepository {
    private List<Dependency> list;
    private static DependencyRepository repository;

    static {
        repository = new DependencyRepository();
    }

    public DependencyRepository() {
        this.list = new ArrayList<>();
        initialice();
    }

    private void initialice() {
        list.add(new Dependency("2 Ciclo Formativo DAM", "2DAM", "Aula del alumnado de 2DAM", ""));
        list.add(new Dependency("1 Ciclo Formativo DAM", "1DAM", "Aula del alumnado de 1DAM", ""));
        list.add(new Dependency("2 Ciclo Formativo SMR", "2SMR", "Aula del alumnado de 2SMR", ""));
        list.add(new Dependency("1 Ciclo Formativo SMR", "1SMR", "Aula del alumnado de 1SMR", ""));

    }

    public static DependencyRepository getInstance() {
        return repository;
    }

    public List<Dependency> getList() {
        return list;
    }
}
