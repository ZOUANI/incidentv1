package controller;

import bean.ExecutionPlanPreventif;
import bean.ExecutionPlanPreventifItem;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;

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
import service.ExecutionPlanPreventifFacade;
import service.ExecutionPlanPreventifItemFacade;

@Named("executionPlanPreventifController")
@SessionScoped
public class ExecutionPlanPreventifController implements Serializable {

    @EJB
    private service.ExecutionPlanPreventifFacade ejbFacade;
    private List<ExecutionPlanPreventif> items = null;
    private ExecutionPlanPreventif selected;

    @EJB
    private service.ExecutionPlanPreventifItemFacade executionPlanPreventifItemFacade;
    private ExecutionPlanPreventifItem executionPlanPreventifItem;
    private List<ExecutionPlanPreventifItem> executionPlanPreventifItems;

    public void findByExecutionPlanPreventif(ExecutionPlanPreventif executionPlanPreventif) {
        executionPlanPreventifItems = (executionPlanPreventifItemFacade.findByExecutionPlanPreventif(executionPlanPreventif));
    }

    public void remove(ExecutionPlanPreventif executionPlanPreventif) {
        ejbFacade.remove(executionPlanPreventif);
        executionPlanPreventifItems = null;
        int index = getItems().indexOf(executionPlanPreventif);
        if (index != -1) {
            getItems().remove(index);
        }
    }

    public void add() {
        executionPlanPreventifItemFacade.add(getExecutionPlanPreventifItem(), getExecutionPlanPreventifItems());
    }

    public void save() {
        ejbFacade.save(getSelected(), getExecutionPlanPreventifItems());
        initAttribute();
    }

    public void reset() {
        initAttribute();
    }

    private void initAttribute() {
        setSelected(null);
        setExecutionPlanPreventifItem(null);
        setExecutionPlanPreventifItems(null);
    }

    public ExecutionPlanPreventifItem getExecutionPlanPreventifItem() {
        if (executionPlanPreventifItem == null) {
            executionPlanPreventifItem = new ExecutionPlanPreventifItem();
        }
        return executionPlanPreventifItem;
    }

    public void setExecutionPlanPreventifItem(ExecutionPlanPreventifItem executionPlanPreventifItem) {
        this.executionPlanPreventifItem = executionPlanPreventifItem;
    }

    public List<ExecutionPlanPreventifItem> getExecutionPlanPreventifItems() {
        if (executionPlanPreventifItems == null) {
            executionPlanPreventifItems = new ArrayList();
        }
        return executionPlanPreventifItems;
    }

    public void setExecutionPlanPreventifItems(List<ExecutionPlanPreventifItem> executionPlanPreventifItems) {
        this.executionPlanPreventifItems = executionPlanPreventifItems;
    }

    public ExecutionPlanPreventifController() {
    }

    public ExecutionPlanPreventif getSelected() {
        if (selected == null) {
            selected = new ExecutionPlanPreventif();
        }
        return selected;
    }

    public void setSelected(ExecutionPlanPreventif selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    public ExecutionPlanPreventif prepareCreate() {
        selected = new ExecutionPlanPreventif();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ExecutionPlanPreventifCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ExecutionPlanPreventifUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ExecutionPlanPreventifDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ExecutionPlanPreventif> getItems() {
        items = getEjbFacade().findAll();
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getEjbFacade().edit(selected);
                } else {
                    getEjbFacade().remove(selected);
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

    public ExecutionPlanPreventif getExecutionPlanPreventif(java.lang.Long id) {
        return getEjbFacade().find(id);
    }

    public List<ExecutionPlanPreventif> getItemsAvailableSelectMany() {
        return getEjbFacade().findAll();
    }

    public List<ExecutionPlanPreventif> getItemsAvailableSelectOne() {
        return getEjbFacade().findAll();
    }

    @FacesConverter(forClass = ExecutionPlanPreventif.class)
    public static class ExecutionPlanPreventifControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ExecutionPlanPreventifController controller = (ExecutionPlanPreventifController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "executionPlanPreventifController");
            return controller.getExecutionPlanPreventif(getKey(value));
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
            if (object instanceof ExecutionPlanPreventif) {
                ExecutionPlanPreventif o = (ExecutionPlanPreventif) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ExecutionPlanPreventif.class.getName()});
                return null;
            }
        }

    }

    public ExecutionPlanPreventifFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(ExecutionPlanPreventifFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public ExecutionPlanPreventifItemFacade getExecutionPlanPreventifItemFacade() {
        return executionPlanPreventifItemFacade;
    }

    public void setExecutionPlanPreventifItemFacade(ExecutionPlanPreventifItemFacade executionPlanPreventifItemFacade) {
        this.executionPlanPreventifItemFacade = executionPlanPreventifItemFacade;
    }

}
