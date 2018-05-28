/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Incident;
import bean.Incident;
import bean.IncidentItem;
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
public class IncidentFacade extends AbstractFacade<Incident> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    @EJB
    IncidentItemFacade incidentItemFacade;

    @Override
    public void create(Incident incident) {
        incident.setId(generateId("Incident", "id"));
        super.create(incident);
    }

    public void save(Incident incident, List<IncidentItem> incidentItems) {
        create(incident);
        incidentItemFacade.save(incident, incidentItems);
    }

    @Override
    public void remove(Incident incident) {
        incidentItemFacade.removeByIncident(incident);
        super.remove(incident);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncidentFacade() {
        super(Incident.class);
    }

}
