package com.iqmsoft.services;

import java.util.List;

import com.iqmsoft.domain.Customer;
import com.iqmsoft.domain.CustomerPerk;
import com.iqmsoft.repositories.CustomerRepository;
import com.iqmsoft.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service("customerService")
public class CustomerService extends BaseService<Customer> implements ICustomerService {

    /** */
    private static final long serialVersionUID = 1L;
    
    /** Injected repository. */
    @Autowired
    private CustomerRepository repository;
    
    /**
     * @see com.iqmsoft.services.base.BaseService#getRepository()
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    protected JpaRepository<Customer, Long> getRepository() {
        return (JpaRepository) repository;
    }

    /**
     * @see com.iqmsoft.services.ICustomerService#getAllCustomerPerks()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<CustomerPerk> getAllCustomerPerks() {
        return em.createQuery("from CustomerPerk").getResultList();
    }

}
