/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Employee;
import bean.PlanPreventif;
import bean.PlanPreventifItem;
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
public class PlanPreventifFacade extends AbstractFacade<PlanPreventif> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    @EJB
    PlanPreventifItemFacade planPreventifItemFacade;

    public List<Long> findByCriteria(int annee, Employee responsable) {
        List<Long> res = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            res.add(findByCriteria(i, annee, responsable));
        }
        return res;
    }

    public Long findByCriteria(int mois, int annee, Employee responsable) {
        String moisConversion = mois + "";
        if (mois < 10) {
            moisConversion = "0" + mois;
        }
        String query = "SELECT COUNT(item.id) FROM PlanPreventif item WHERE item.dateDepart LIKE '" + annee + "-" + moisConversion + "-%'";
        if (responsable != null) {
            query += SearchUtil.addConstraint("item", "responsable.id", "=", responsable.getId());
        }
        System.out.println(query);
        List<Long> res = em.createQuery(query).getResultList();
        if (res == null || res.isEmpty() || res.get(0) == null) {
            return 0L;
        }
        return res.get(0);
    }

    @Override
    public void create(PlanPreventif planPreventif
    ) {
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
