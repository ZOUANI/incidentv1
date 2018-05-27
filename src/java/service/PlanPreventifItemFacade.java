/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.PlanPreventif;
import bean.PlanPreventifItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YOUNES
 */
@Stateless
public class PlanPreventifItemFacade extends AbstractFacade<PlanPreventifItem> {

    public void save(PlanPreventif planPreventif, List<PlanPreventifItem> planPreventifItems) {
        for (PlanPreventifItem planPreventifItem : planPreventifItems) {
            planPreventifItem.setPlanPreventif(planPreventif);
            create(planPreventifItem);
        }
    }

    public List<PlanPreventifItem> findByPlanPreventif(PlanPreventif planPreventif) {
        return em.createQuery("SELECT item FROM PlanPreventifItem item WHERE item.planPreventif.id='" + planPreventif.getId() + "'").getResultList();
    }

    public void removeByPlanPreventif(PlanPreventif planPreventif) {
        em.createQuery("DELETE FROM  PlanPreventifItem item WHERE item.planPreventif.id='" + planPreventif.getId() + "'").executeUpdate();
    }

    public void add(PlanPreventifItem planPreventifItem, List<PlanPreventifItem> planPreventifItems) {
        planPreventifItems.add(clone(planPreventifItem));
    }

    public PlanPreventifItem clone(PlanPreventifItem planPreventifItem) {
        PlanPreventifItem myCLone = new PlanPreventifItem();
        myCLone.setCategorieEquipement(planPreventifItem.getCategorieEquipement());
        myCLone.setDateDepart(planPreventifItem.getDateDepart());
        myCLone.setDateFin(planPreventifItem.getDateFin());
        myCLone.setDescription(planPreventifItem.getDescription());
        myCLone.setResponsable(planPreventifItem.getResponsable());
        return myCLone;
    }
    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanPreventifItemFacade() {
        super(PlanPreventifItem.class);
    }

}
