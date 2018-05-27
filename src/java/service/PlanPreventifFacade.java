/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.PlanPreventif;
import bean.PlanPreventifItem;
import bean.PlanPreventif;
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
public class PlanPreventifFacade extends AbstractFacade<PlanPreventif> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    @EJB
    PlanPreventifItemFacade planPreventifItemFacade;

    @Override
    public void create(PlanPreventif planPreventif) {
        planPreventif.setId(generateId("PlanPreventif", "id"));
        super.create(planPreventif);
    }

    public void save(PlanPreventif planPreventif, List<PlanPreventifItem> planPreventifItems) {
        create(planPreventif);
        planPreventifItemFacade.save(planPreventif, planPreventifItems);
    }

    @Override
    public void remove(PlanPreventif planPreventif) {
        planPreventifItemFacade.removeByPlanPreventif(planPreventif);
        super.remove(planPreventif);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanPreventifFacade() {
        super(PlanPreventif.class);
    }

}
