package com.iqmsoft.services.base;

import com.iqmsoft.domain.base.BaseEntity;
import com.iqmsoft.domain.base.IEntity;


public interface IVariableTypeService {
    
    /**
     * Loads entity by its id.
     * 
     * @param entityClass
     *            Concrete Entity class.
     * @param id
     *            Entity ID
     * @return Loaded Entity.
     */
    BaseEntity findById(Class<? extends IEntity> entityClass, Long id);

}
