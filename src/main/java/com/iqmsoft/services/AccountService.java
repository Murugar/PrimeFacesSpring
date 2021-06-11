package com.iqmsoft.services;

import com.iqmsoft.domain.Account;
import com.iqmsoft.repositories.AccountRepository;
import com.iqmsoft.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service("accountService")
public class AccountService extends BaseService<Account> implements IAccountService {

    /** */
    private static final long serialVersionUID = 1L;
    
    /** Injected repository. */
    @Autowired
    private AccountRepository repository;

    /**
     * @see com.iqmsoft.services.base.BaseService#getRepository()
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    protected JpaRepository<Account, Long> getRepository() {
        return (JpaRepository) repository;
    }

}
