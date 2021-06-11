package com.iqmsoft.jsf.datatable;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;


// TODO primefaces 5.0 should accept EL as sort by, but for some reason it doesn't work in column.xhtml if I try #{entity[field]}
@FacesComponent(value = "ExtendedPrimefacesDatatable")
public class ExtendedPrimefacesDatatable extends DataTable {

    @Override
    public String resolveStaticField(ValueExpression expression) {
        if (expression != null) {
            FacesContext context = getFacesContext();
            ELContext eLContext = context.getELContext();

            return (String) expression.getValue(eLContext);
        } else {
            return null;
        }
    }

}
