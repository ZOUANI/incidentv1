/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.TraitementIncident;
import bean.TraitementIncidentItem;
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
public class TraitementIncidentFacade extends AbstractFacade<TraitementIncident> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    @EJB
    TraitementIncidentItemFacade traitementIncidentItemFacade;

    @Override
    public void create(TraitementIncident traitementIncident) {
        traitementIncident.setId(generateId("TraitementIncident","id"));
        super.create(traitementIncident);
    }

    public void save(TraitementIncident traitementIncident, List<TraitementIncidentItem> traitementIncidentItems) {
        create(traitementIncident);
        traitementIncidentItemFacade.save(traitementIncident, traitementIncidentItems);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TraitementIncidentFacade() {
        super(TraitementIncident.class);
    }

}
