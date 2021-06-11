package com.iqmsoft.domain.base;


public interface IdentifiableEnum {

    /**
     * Enum id that is saved in database.
     */
    Integer getId();
    
    /**
     * Enum label.
     */
    String getLabel();

}
