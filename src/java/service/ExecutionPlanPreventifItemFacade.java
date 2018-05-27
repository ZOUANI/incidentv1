/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ExecutionPlanPreventif;
import bean.ExecutionPlanPreventifItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YOUNES
 */
@Stateless
public class ExecutionPlanPreventifItemFacade extends AbstractFacade<ExecutionPlanPreventifItem> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    public void save(ExecutionPlanPreventif executionPlanPreventif, List<ExecutionPlanPreventifItem> executionPlanPreventifItems) {
        for (ExecutionPlanPreventifItem executionPlanPreventifItem : executionPlanPreventifItems) {
            executionPlanPreventifItem.setExecutionPlanPreventif(executionPlanPreventif);
            create(executionPlanPreventifItem);
        }
    }

    public List<ExecutionPlanPreventif> findByExecutionPlanPreventif(ExecutionPlanPreventif executionPlanPreventif) {
        return em.createQuery("SELECT item FROM ExecutionPlanPreventifItem item WHERE item.executionPlanPreventif.id='" + executionPlanPreventif.getId() + "'").getResultList();
    }

    public void add(ExecutionPlanPreventifItem executionPlanPreventifItem, List<ExecutionPlanPreventifItem> executionPlanPreventifItems) {
        executionPlanPreventifItems.add(clone(executionPlanPreventifItem));
    }

    public ExecutionPlanPreventifItem clone(ExecutionPlanPreventifItem executionPlanPreventifItem) {
        ExecutionPlanPreventifItem myCLone = new ExecutionPlanPreventifItem();
        myCLone.setDateDepart(executionPlanPreventifItem.getDateDepart());
        myCLone.setDateFin(executionPlanPreventifItem.getDateFin());
        myCLone.setDescription(executionPlanPreventifItem.getDescription());
        myCLone.setEquipement(executionPlanPreventifItem.getEquipement());
        myCLone.setResponsable(executionPlanPreventifItem.getResponsable());
        return myCLone;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExecutionPlanPreventifItemFacade() {
        super(ExecutionPlanPreventifItem.class);
    }

}
