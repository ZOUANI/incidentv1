/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.TraitementIncident;
import bean.TraitementIncidentItem;
import bean.TraitementIncidentItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YOUNES
 */
@Stateless
public class TraitementIncidentItemFacade extends AbstractFacade<TraitementIncidentItem> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    
      public void save(TraitementIncident traitementIncident, List<TraitementIncidentItem> traitementIncidentItems) {
        for (TraitementIncidentItem traitementIncidentItem : traitementIncidentItems) {
            traitementIncidentItem.setTraitementIncident(traitementIncident);
            create(traitementIncidentItem);
        }
    }

    public List<TraitementIncident> findByTraitementIncident(TraitementIncident traitementIncident) {
        return em.createQuery("SELECT item FROM TraitementIncidentItem item WHERE item.traitementIncident.id='" + traitementIncident.getId() + "'").getResultList();
    }
    public void add(TraitementIncidentItem traitementIncidentItem, List<TraitementIncidentItem> traitementIncidentItems) {
        traitementIncidentItems.add(clone(traitementIncidentItem));
    }

    public TraitementIncidentItem clone(TraitementIncidentItem traitementIncidentItem) {
        TraitementIncidentItem myCLone = new TraitementIncidentItem();
        myCLone.setDateTraitement(traitementIncidentItem.getDateTraitement());
        myCLone.setEquipement(traitementIncidentItem.getEquipement());
        myCLone.setEtat(traitementIncidentItem.getEtat());
        myCLone.setTechnicien(traitementIncidentItem.getTechnicien());
        return myCLone;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TraitementIncidentItemFacade() {
        super(TraitementIncidentItem.class);
    }

}
