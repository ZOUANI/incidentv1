/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Employee;
import bean.ExecutionPlanPreventif;
import bean.ExecutionPlanPreventifItem;
import bean.PlanPreventif;
import bean.TypeIncident;
import controller.util.SearchUtil;
import java.util.ArrayList;
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
    
    public List<Long> findByCriteria(int annee, Employee responsable) {
        List<Long> res = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            res.add(findByCriteria(i, annee, responsable));
        }
        return res;
    }

    public Long findByCriteria(int mois, int annee,  Employee responsable) {
        String query = "SELECT COUNT(item.id) FROM ExecutionPlanPreventif item WHERE dateDepart LIKE '" + annee + "-" + mois + "-%'";
        if (responsable != null) {
            query += SearchUtil.addConstraint("item", "responsable", "=", responsable.getId());
        }
        List<Long> res = em.createQuery(query).getResultList();
        if (res == null || res.isEmpty() || res.get(0) == null) {
            return 0L;
        }
        return res.get(0);
    }

    public List<ExecutionPlanPreventif> findByPlanPreventif(PlanPreventif planPreventif) {
        return em.createQuery("SELECT item FROM ExecutionPlanPreventif item WHERE item.planPreventif.id='" + planPreventif.getId() + "'").getResultList();
    }

    @Override
    public void create(ExecutionPlanPreventif executionPlanPreventif) {
        executionPlanPreventif.setId(generateId("ExecutionPlanPreventif", "id"));
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
