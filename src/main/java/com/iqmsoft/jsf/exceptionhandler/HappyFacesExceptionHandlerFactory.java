package com.iqmsoft.jsf.exceptionhandler;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class HappyFacesExceptionHandlerFactory extends ExceptionHandlerFactory {

    /** Parent factory. */
    private ExceptionHandlerFactory parent;

    /**
     * Constructor.
     */
    public HappyFacesExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    /**
     * @see javax.faces.context.ExceptionHandlerFactory#getExceptionHandler()
     */
    @Override
    public ExceptionHandler getExceptionHandler() {
        return new HappyFacesExceptionHandler(parent.getExceptionHandler());
    }

}
