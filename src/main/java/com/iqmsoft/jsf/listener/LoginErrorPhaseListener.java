package com.iqmsoft.jsf.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.iqmsoft.utils.FacesUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;


public class LoginErrorPhaseListener implements PhaseListener {

    /** */
    private static final long serialVersionUID = 1L;

    /**
     * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
     */
    @Override
    public void beforePhase(final PhaseEvent arg0) {
        Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);

        if (e instanceof BadCredentialsException) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
            FacesUtils.error("login.failed");
        }
    }

    /**
     * @see javax.faces.event.PhaseListener#afterPhase(javax.faces.event.PhaseEvent)
     */
    @Override
    public void afterPhase(final PhaseEvent arg0) {
    }

    /**
     * @see javax.faces.event.PhaseListener#getPhaseId()
     */
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

}