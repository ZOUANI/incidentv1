/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Employee;
import bean.TraitementIncident;
import bean.TraitementIncidentItem;
import bean.Incident;
import bean.IncidentItem;
import bean.Incident;
import bean.TraitementIncident;
import bean.TraitementIncidentItem;
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
public class TraitementIncidentFacade extends AbstractFacade<TraitementIncident> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    @EJB
    TraitementIncidentItemFacade traitementIncidentItemFacade;

    public List<Long> findByCriteria(int annee, Integer etat) {
        List<Long> res = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            res.add(findByCriteria(i, annee, etat));
        }
        return res;
    }

    public Long findByCriteria(int mois, int annee, Integer etat) {
         String moisConversion = mois + "";
        if (mois < 10) {
            moisConversion = "0" + mois;
        }
        String query = "SELECT COUNT(item.id) FROM TraitementIncident item WHERE dateTraitement LIKE '" + annee + "-" + moisConversion + "-%'";
        query += SearchUtil.addConstraint("item", "etat", "=", etat);
        List<Long> res = em.createQuery(query).getResultList();
        if (res == null || res.isEmpty() || res.get(0) == null) {
            return 0L;
        }
        return res.get(0);
    }

    public List<TraitementIncident> findByIncident(Incident incident) {
        return em.createQuery("SELECT item FROM TraitementIncident item WHERE item.incident.id='" + incident.getId() + "'").getResultList();
    }

    @Override
    public void create(TraitementIncident traitementIncident) {
        traitementIncident.setId(generateId("TraitementIncident", "id"));
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
