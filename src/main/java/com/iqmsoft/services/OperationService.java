package com.iqmsoft.services;

import com.iqmsoft.domain.Operation;
import com.iqmsoft.repositories.OperationRepository;
import com.iqmsoft.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service("operationService")
public class OperationService extends BaseService<Operation> implements IOperationService {

    /** */
    private static final long serialVersionUID = 1L;

    /** Injected repository. */
    @Autowired
    private OperationRepository repository;
    
    /**
     * @see com.iqmsoft.services.base.BaseService#getRepository()
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    protected JpaRepository<Operation, Long> getRepository() {
        return (JpaRepository) repository;
    }
}
