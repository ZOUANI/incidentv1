/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ExecutionPlanPreventif;
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExecutionPlanPreventifFacade() {
        super(ExecutionPlanPreventif.class);
    }
    
}
