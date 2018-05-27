/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.IncidentItem;
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
public class IncidentItemFacade extends AbstractFacade<IncidentItem> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    public void add(IncidentItem incidentItem, List<IncidentItem> incidentItems) {
        incidentItems.add(clone(incidentItem));
    }

    public IncidentItem clone(IncidentItem incidentItem) {
        IncidentItem myCLone = new IncidentItem();
        myCLone.setDateTraitement(incidentItem.getDateTraitement());
        myCLone.setCategorieDelai(incidentItem.getCategorieDelai());
        myCLone.setDegreUrgence(incidentItem.getDegreUrgence());
        myCLone.setEquipement(incidentItem.getEquipement());
        return myCLone;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncidentItemFacade() {
        super(IncidentItem.class);
    }

}
