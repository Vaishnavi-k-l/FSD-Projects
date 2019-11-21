package com.myCompany.InheritanceDemo.joinTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "ID")
@EqualsAndHashCode(callSuper = false)
@Table(name = "ContractEmployee")
public class ContractEmployee extends Employee
{
	@Column(name = "pay_per_hour")
	private int pay_per_hour;
	
	@Column(name = "contract_duration")
	private String contract_duration;
}
