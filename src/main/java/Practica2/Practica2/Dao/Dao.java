package Practica2.Practica2.Dao;

import java.util.List;

public interface Dao<T> {

    T get(long id);

    List<T> getAll() throws Exception;

    /** Recibe un objeto YA CREADO, y lo guarda en la base de datos */
    void save(T t) throws Exception;

    void update(T t, String[] params);

    void delete(T t);
    
}
