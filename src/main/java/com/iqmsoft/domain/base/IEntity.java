package com.iqmsoft.domain.base;

import java.io.Serializable;


public interface IEntity {
    
    /**
     * All entities must have an ID field.
     */
    Serializable getId();
    
    /**
     * Returns if entity is already saved in database.
     */
    boolean isTransient();

}