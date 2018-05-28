/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YOUNES
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> {

    @PersistenceContext(unitName = "incidentv1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    public int seConnnecter(Employee employee) {
        if (employee == null || employee.getLogin() == null) {
            return -5;
        } else {
            Employee loadedEmployee = findByLogin(employee.getLogin());
            if (loadedEmployee == null) {
                return -4;
            } else if (!loadedEmployee.getPassword().equals((employee.getPassword()))) {
                return -3;
            } else if (loadedEmployee.getBlocked() == 1) {
                return -2;
            } else {
                return 1;
            }
        }
    }

    private Employee findByLogin(String login) {
        List<Employee> res = em.createQuery("SELECT item FROM Employee item WHERE item.login='" + login + "'").getResultList();
        if (res == null || res.isEmpty() || res.get(0) == null) {
            return null;
        }
        return res.get(0);
    }

}
