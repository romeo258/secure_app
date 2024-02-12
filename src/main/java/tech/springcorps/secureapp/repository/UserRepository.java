package tech.springcorps.secureapp.repository;

import tech.springcorps.secureapp.domain.User;

import java.util.Collection;

/**
 * @author Spring Coprs (https://www.springcorps.tech)
 * @version 1.0
 * @since 01/02/2024
 */

public interface UserRepository<T extends User> {
    /*Basic CRUD Operation */
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    /* More Complex Operation */

}
