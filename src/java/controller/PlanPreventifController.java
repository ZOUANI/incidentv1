package controller;

import bean.PlanPreventif;
import bean.PlanPreventifItem;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import service.PlanPreventifFacade;

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

@Named("planPreventifController")
@SessionScoped
public class PlanPreventifController implements Serializable {

    @EJB
    private service.PlanPreventifFacade ejbFacade;
    private List<PlanPreventif> items = null;
    private PlanPreventif selected;

    @EJB
    private service.PlanPreventifItemFacade planPreventifItemFacade;
    private PlanPreventifItem planPreventifItem;
    private List<PlanPreventifItem> planPreventifItems;

    public void findByPlanPreventif(PlanPreventif planPreventif) {
        planPreventifItems = (planPreventifItemFacade.findByPlanPreventif(planPreventif));
    }

    public void remove(PlanPreventif planPreventif) {
        ejbFacade.remove(planPreventif);
        planPreventifItems = null;
        int index = getItems().indexOf(planPreventif);
        if (index != -1) {
            getItems().remove(index);
        }
    }

    public void add() {
        planPreventifItemFacade.add(getPlanPreventifItem(), getPlanPreventifItems());
    }

    public void save() {
        ejbFacade.save(getSelected(), getPlanPreventifItems());
        initAttribute();
    }

    public void reset() {
        initAttribute();
    }

    private void initAttribute() {
        setSelected(null);
        setPlanPreventifItem(null);
        setPlanPreventifItems(null);
    }

    public PlanPreventifItem getPlanPreventifItem() {
        if (planPreventifItem == null) {
            planPreventifItem = new PlanPreventifItem();
        }
        return planPreventifItem;
    }

    public void setPlanPreventifItem(PlanPreventifItem planPreventifItem) {
        this.planPreventifItem = planPreventifItem;
    }

    public List<PlanPreventifItem> getPlanPreventifItems() {
        if (planPreventifItems == null) {
            planPreventifItems = new ArrayList();
        }
        return planPreventifItems;
    }

    public void setPlanPreventifItems(List<PlanPreventifItem> planPreventifItems) {
        this.planPreventifItems = planPreventifItems;
    }

    public PlanPreventifController() {
    }

    public PlanPreventif getSelected() {
        if (selected == null) {
            selected = new PlanPreventif();
        }
        return selected;
    }

    public void setSelected(PlanPreventif selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PlanPreventifFacade getFacade() {
        return ejbFacade;
    }

    public PlanPreventif prepareCreate() {
        selected = new PlanPreventif();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PlanPreventifCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PlanPreventifUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PlanPreventifDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PlanPreventif> getItems() {
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

    public PlanPreventif getPlanPreventif(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<PlanPreventif> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PlanPreventif> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PlanPreventif.class)
    public static class PlanPreventifControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PlanPreventifController controller = (PlanPreventifController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "planPreventifController");
            return controller.getPlanPreventif(getKey(value));
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
            if (object instanceof PlanPreventif) {
                PlanPreventif o = (PlanPreventif) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PlanPreventif.class.getName()});
                return null;
            }
        }

    }

    public PlanPreventifFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(PlanPreventifFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

}
