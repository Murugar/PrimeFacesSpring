package com.iqmsoft.services;

import java.util.List;

import com.iqmsoft.domain.Customer;
import com.iqmsoft.domain.CustomerPerk;
import com.iqmsoft.services.base.IService;


public interface ICustomerService extends IService<Customer> {

    /**
     * Loads all customer perks.
     */
    List<CustomerPerk> getAllCustomerPerks();

}
