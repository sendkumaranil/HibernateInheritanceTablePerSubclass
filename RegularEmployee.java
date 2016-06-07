package com.hibernate.inheritance.tabpersubclass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="regular_employee")
@PrimaryKeyJoinColumn(name="regempid")
public class RegularEmployee extends Employee {

	@Column
	private float salary;
	
	@Column
	private float bonus;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
	
}
