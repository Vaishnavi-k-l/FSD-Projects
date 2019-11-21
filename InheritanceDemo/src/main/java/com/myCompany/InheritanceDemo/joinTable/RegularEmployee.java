package com.myCompany.InheritanceDemo.joinTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "RegularEmployee")
@PrimaryKeyJoinColumn(name = "ID")
@Data
@EqualsAndHashCode(callSuper = false)
public class RegularEmployee extends Employee
{
	@Column(name = "salary")
	private int salary;
	
	@Column(name = "bonus")
	private int bonus;
	
}
