package com.hibernate.inheritance.tabpersubclass.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.inheritance.tabpersubclass.model.ContractEmployee;
import com.hibernate.inheritance.tabpersubclass.model.Employee;
import com.hibernate.inheritance.tabpersubclass.model.RegularEmployee;
import com.hibernate.inheritance.tabpersubclass.util.HibernateUtil;

public class TestTablePerSubclass {

	public static void main(String[] args) {
		
		
		RegularEmployee regEmp=new RegularEmployee();
		regEmp.setName("Sumit Bajaj");
		regEmp.setOrg("SAP India Labs");
		regEmp.setSalary(35000);
		regEmp.setBonus(12000);
		
		ContractEmployee contEmp=new ContractEmployee();
		contEmp.setName("Akash Chopra");
		contEmp.setPay_per_hour(1200);
		contEmp.setContract_duration("6 months");
		contEmp.setOrg("SAP India Labs");
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try{
			sessionFactory=HibernateUtil.getSessionfactory();
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			
			session.save(regEmp);
			session.save(contEmp);
			
			session.flush();
			tx.commit();
			
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
			
		}finally{
			if(session!=null)session.close();
		}
	}
}
