/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Employee;
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
            Employee loadedEmployee = find(employee.getLogin());
            if (loadedEmployee == null) {
                return -4;
            } else if (!loadedEmployee.getPassword().equals((employee.getPassword()))) {
                if (loadedEmployee.getNbrCnx() < 3) {
                    loadedEmployee.setNbrCnx(loadedEmployee.getNbrCnx() + 1);
                } else if (loadedEmployee.getNbrCnx() >= 3) {
                    loadedEmployee.setBlocked(1);
                }
                return -3;
            } else if (loadedEmployee.getBlocked() == 1) {
                return -2;
            } else {
                loadedEmployee.setNbrCnx(0);
                employee.setPassword(null);
                return 1;
            }
        }
    }

}
