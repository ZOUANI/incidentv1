/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ExecutionPlanPreventif;
import bean.ExecutionPlanPreventifItem;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YOUNES
 */
@Stateless
public class ExecutionPlanPreventifFacade extends AbstractFacade<ExecutionPlanPreventif> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    @EJB
    ExecutionPlanPreventifItemFacade executionPlanPreventifItemFacade;

    @Override
    public void create(ExecutionPlanPreventif executionPlanPreventif) {
        executionPlanPreventif.setId(generateId("ExecutionPlanPreventif","id"));
        super.create(executionPlanPreventif);
    }

    public void save(ExecutionPlanPreventif executionPlanPreventif, List<ExecutionPlanPreventifItem> executionPlanPreventifItems) {
        create(executionPlanPreventif);
        executionPlanPreventifItemFacade.save(executionPlanPreventif, executionPlanPreventifItems);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExecutionPlanPreventifFacade() {
        super(ExecutionPlanPreventif.class);
    }

}
