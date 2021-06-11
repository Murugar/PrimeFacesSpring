package com.iqmsoft.beans;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.iqmsoft.beans.base.BaseBean;
import com.iqmsoft.domain.Operation;
import com.iqmsoft.services.IOperationService;
import com.iqmsoft.services.base.IService;


@ManagedBean(name = "operationBean")
@ViewScoped
public class OperationBean extends BaseBean<Operation> {

    /** */
    private static final long serialVersionUID = 1L;
    
    /** Injected service. */
    @ManagedProperty(value = "#{operationService}")
    private IOperationService operationService;

    /**
     * Constructor.
     */
    public OperationBean() {
        super(Operation.class);
    }

    /**
     * @see com.iqmsoft.beans.base.BaseBean#getPersistenceService()
     */
    @Override
    protected IService<Operation> getPersistenceService() {
        return operationService;
    }

    public void setOperationService(IOperationService operationService) {
        this.operationService = operationService;
    }
    
    /**
     * Fetch account field so no LazyInitialize exception is thrown when
     * we access it from account list view.
     * 
     * @see com.iqmsoft.beans.base.BaseBean#getListFieldsToFetch()
     */
    @Override
    protected List<String> getListFieldsToFetch() {
        return Arrays.asList("account");
    }
    
    /**
     * Fetch customer field so no LazyInitialize exception is thrown when
     * we access it from account edit view.
     * 
     * @see com.iqmsoft.beans.base.BaseBean#getFormFieldsToFetch()
     */
    @Override
    protected List<String> getFormFieldsToFetch() {
        return Arrays.asList("account");
    }
}
