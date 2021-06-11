package com.iqmsoft.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.iqmsoft.beans.base.BaseBean;
import com.iqmsoft.domain.Customer;
import com.iqmsoft.domain.CustomerPerk;
import com.iqmsoft.services.ICustomerService;
import com.iqmsoft.services.base.IService;
import org.primefaces.model.DualListModel;


@ManagedBean(name = "customerBean")
@ViewScoped
public class CustomerBean extends BaseBean<Customer> {

    /** */
    private static final long serialVersionUID = 1L;
    
    /** Injected service. */
    @ManagedProperty(value = "#{customerService}")
    private ICustomerService customerService;

    /** Customer perks list model for primefaces pick list component. */
    private DualListModel<CustomerPerk> perks;
    
    /**
     * Constructor.
     */
    public CustomerBean() {
        super(Customer.class);
    }

    @Override
    public IService<Customer> getPersistenceService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }
    
    public List<Customer> getCustomers() {
        return customerService.list();
    }
    
    /**
     * Standard method for custom component with listType="pickList".
     */
    public DualListModel<CustomerPerk> getDualListModel() {
        if (perks == null) {
            List<CustomerPerk> perksSource = customerService.getAllCustomerPerks();
            List<CustomerPerk> perksTarget = new ArrayList<CustomerPerk>();
            if (getEntity().getPerks() != null) {
                perksTarget.addAll(getEntity().getPerks());
            }
            perksSource.removeAll(perksTarget);
            perks = new DualListModel<CustomerPerk>(perksSource, perksTarget);
        }
        return perks;
    }
    
    /**
     * Sets dual list model.
     */
    public void setDualListModel(DualListModel<CustomerPerk> perks) {
        getEntity().setPerks(perks.getTarget());
    }
    
    /**
     * Fetch city field so when not LazyInitialize exception is thrown when
     * we access it from account list view.
     * 
     * @see com.iqmsoft.beans.base.BaseBean#getListFieldsToFetch()
     */
    @Override
    protected List<String> getListFieldsToFetch() {
        return Arrays.asList("city", "perks");
    }

    /**
     * Fetch city field so when not LazyInitialize exception is thrown when
     * we access it from account edit view.
     * 
     * @see com.iqmsoft.beans.base.BaseBean#getFormFieldsToFetch()
     */
    @Override
    protected List<String> getFormFieldsToFetch() {
        return Arrays.asList("city", "perks");
    }

}
