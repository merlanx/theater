package com.merlan.theater.business.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * @author meilan_xie
 *
 * @param <T>
 *            DomainObject subclass
 */
public interface AbstractDomainObjectService<T> {

    /**
     * Saving new object to storage or updating existing one
     * 
     * @param object
     *            Object to save
     * @return saved object with assigned id
     */
    public T save(@Nonnull T object);

    /**
     * Removing object from storage
     * 
     * @param object
     *            Object to remove
     */
    public void remove(@Nonnull T object);

    /**
     * Getting object by id from storage
     * 
     * @param id
     *            id of the object
     * @return Found object or <code>null</code>
     */
    public @Nullable T getById(@Nonnull Long id);

    /**
     * Getting object by name from storage
     *
     * @param name
     *            name of the object
     * @return Found object or <code>null</code>
     */
    public @Nullable T getByName(@Nonnull String name);

    /**
     * Getting all objects from storage
     * 
     * @return collection of objects or <code>null</code>
     */
    public @Nullable Collection<T> getAll();
}
