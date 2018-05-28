package controller;

import bean.TraitementIncident;
import bean.TraitementIncidentItem;
import bean.Incident;
import bean.IncidentItem;
import bean.Incident;
import bean.IncidentItem;
import bean.Incident;
import bean.IncidentItem;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import service.IncidentFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("incidentController")
@SessionScoped
public class IncidentController implements Serializable {

    @EJB
    private service.IncidentFacade ejbFacade;
    private List<Incident> items = null;
    private Incident selected;

    @EJB
    private service.IncidentItemFacade incidentItemFacade;
    private IncidentItem incidentItem;
    private List<IncidentItem> incidentItems;

    @EJB
    private service.TraitementIncidentItemFacade traitementIncidentItemFacade;
    @EJB
    private service.TraitementIncidentFacade traitementIncidentFacade;
    private List<TraitementIncident> traitementIncidents;
    private List<TraitementIncidentItem> traitementIncidentItems;

    public void findByIncident(Incident incident) {
        incidentItems = (incidentItemFacade.findByIncident(incident));
        traitementIncidents = (traitementIncidentFacade.findByIncident(incident));
        traitementIncidentItems = null;
    }

    public void findByTraitementIncident(TraitementIncident traitementIncident) {
        traitementIncidentItems = (traitementIncidentItemFacade.findByTraitementIncident(traitementIncident));
    }

    public void removeByTraitementIncident(TraitementIncident traitementIncident) {
        traitementIncidentFacade.remove(traitementIncident);
        traitementIncidentItems = null;
        int index = getItems().indexOf(traitementIncident);
        if (index != -1) {
            getItems().remove(index);
        }
    }

    public void remove(Incident incident) {
        ejbFacade.remove(incident);
        incidentItems = null;
        traitementIncidents = null;
        traitementIncidentItems = null;
        int index = getItems().indexOf(incident);
        if (index != -1) {
            getItems().remove(index);
        }
    }

    public void add() {
        incidentItemFacade.add(getIncidentItem(), getIncidentItems());
    }

    public void save() {
        ejbFacade.save(getSelected(), getIncidentItems());
        initAttribute();
    }

    public void reset() {
        initAttribute();
    }

    private void initAttribute() {
        setSelected(null);
        setIncidentItem(null);
        setIncidentItems(null);
    }

    public IncidentItem getIncidentItem() {
        if (incidentItem == null) {
            incidentItem = new IncidentItem();
        }
        return incidentItem;
    }

    public void setIncidentItem(IncidentItem incidentItem) {
        this.incidentItem = incidentItem;
    }

    public List<IncidentItem> getIncidentItems() {
        if (incidentItems == null) {
            incidentItems = new ArrayList();
        }
        return incidentItems;
    }

    public void setIncidentItems(List<IncidentItem> incidentItems) {
        this.incidentItems = incidentItems;
    }

    public List<TraitementIncident> getTraitementIncidents() {
        if (traitementIncidents == null) {
            traitementIncidents = new ArrayList();
        }
        return traitementIncidents;
    }

    public void setTraitementIncidents(List<TraitementIncident> traitementIncidents) {
        this.traitementIncidents = traitementIncidents;
    }

    public List<TraitementIncidentItem> getTraitementIncidentItems() {
        if (traitementIncidentItems == null) {
            traitementIncidentItems = new ArrayList();
        }
        return traitementIncidentItems;
    }

    public void setTraitementIncidentItems(List<TraitementIncidentItem> traitementIncidentItems) {
        this.traitementIncidentItems = traitementIncidentItems;
    }

    public IncidentFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(IncidentFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public IncidentController() {
    }

    public Incident getSelected() {
        if (selected == null) {
            selected = new Incident();
        }
        return selected;
    }

    public void setSelected(Incident selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private IncidentFacade getFacade() {
        return ejbFacade;
    }

    public Incident prepareCreate() {
        selected = new Incident();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("IncidentCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("IncidentUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("IncidentDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Incident> getItems() {
        items = getFacade().findAll();
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Incident getIncident(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Incident> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Incident> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Incident.class)
    public static class IncidentControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            IncidentController controller = (IncidentController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "incidentController");
            return controller.getIncident(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Incident) {
                Incident o = (Incident) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Incident.class.getName()});
                return null;
            }
        }

    }

}
