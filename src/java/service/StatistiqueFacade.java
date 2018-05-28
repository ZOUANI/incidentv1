/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Employee;
import bean.Equipement;
import bean.TypeIncident;
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
public class StatistiqueFacade extends AbstractFacade<Equipement> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    @EJB
    private IncidentFacade incidentFacade;
    @EJB
    private TraitementIncidentFacade traitementIncidentFacade;
    @EJB
    private PlanPreventifFacade planPreventifFacade;
    @EJB
    private ExecutionPlanPreventifFacade executionPlanPreventifFacade;

    public Object[] findPlanAndExecutionByCriteria(int annee, Employee responsable) {
        Object[] res = new Object[2];
        res[0] = planPreventifFacade.findByCriteria(annee, responsable);
        res[1] = executionPlanPreventifFacade.findByCriteria(annee, responsable);
        return res;
    }

    public Object[] findIncidentAndTraitementByCriteria(int annee, Integer etatTraitement, Integer etatIncident, TypeIncident typeIncident, Employee employeeDeclarant) {
        Object[] res = new Object[2];
        res[0] = incidentFacade.findByCriteria(annee, etatIncident, typeIncident, employeeDeclarant);
        res[1] = traitementIncidentFacade.findByCriteria(annee, etatTraitement);
        return res;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatistiqueFacade() {
        super(Equipement.class);
    }

}
