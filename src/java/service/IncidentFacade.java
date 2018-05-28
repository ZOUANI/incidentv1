/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Employee;
import bean.Incident;
import bean.IncidentItem;
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
public class IncidentFacade extends AbstractFacade<Incident> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    @EJB
    IncidentItemFacade incidentItemFacade;

    public List<Long> findByCriteria(int annee, Integer etat, TypeIncident typeIncident, Employee employeeDeclarant) {
        List<Long> res = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            res.add(findByCriteria(i, annee, etat, typeIncident, employeeDeclarant));
        }
        return res;
    }

    public Long findByCriteria(int mois, int annee, Integer etat, TypeIncident typeIncident, Employee employeeDeclarant) {
        String moisConversion = mois + "";
        if (mois < 10) {
            moisConversion = "0" + mois;
        }
        String query = "SELECT COUNT(item.id) FROM Incident item WHERE item.dateIncident LIKE '" + annee + "-" + moisConversion + "-%'";
        //query += SearchUtil.addConstraint("item", "etat", "=", etat);
        if (typeIncident != null) {
            query += SearchUtil.addConstraint("item", "typeIncident", "=", typeIncident.getId());
        }
        if (employeeDeclarant != null) {
            query += SearchUtil.addConstraint("item", "employeeDeclarant", "=", employeeDeclarant.getId());
        }
        System.out.println(query);
        List<Long> res = em.createQuery(query).getResultList();
        if (res == null || res.isEmpty() || res.get(0) == null) {
            return 0L;
        }
        return res.get(0);
    }

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
