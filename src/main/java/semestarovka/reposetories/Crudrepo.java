package semestarovka.reposetories;

import java.util.List;

public interface Crudrepo<T> {
    void save(T model);
    List<T> findAll();
}
