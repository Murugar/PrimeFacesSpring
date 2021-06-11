package com.iqmsoft.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.iqmsoft.beans.base.BaseBean;
import com.iqmsoft.domain.City;
import com.iqmsoft.services.ICityService;
import com.iqmsoft.services.base.IService;


@ManagedBean(name = "cityBean")
@ViewScoped
public class CityBean extends BaseBean<City> {

    /** */
    private static final long serialVersionUID = 1L;

    /** Injected service. */
    @ManagedProperty(value = "#{cityService}")
    private ICityService cityService;

    /**
     * Constructor.
     */
    public CityBean() {
        super(City.class);
    }

    /**
     * @see com.iqmsoft.beans.base.BaseBean#getPersistenceService()
     */
    @Override
    protected IService<City> getPersistenceService() {
        return cityService;
    }

    public void setCityService(ICityService cityService) {
        this.cityService = cityService;
    }

}
