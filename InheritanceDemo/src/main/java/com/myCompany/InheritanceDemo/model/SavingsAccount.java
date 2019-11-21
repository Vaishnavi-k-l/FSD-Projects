package com.myCompany.InheritanceDemo.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Savings Account")

public class SavingsAccount extends Account
{
	private int interest;
	private Date joinDate;
	
	public SavingsAccount(String name, int acc_num, int interest , int balance, Date date)
	{
		super(name, acc_num, balance);
		this.interest = interest;
		this.joinDate = date;
	}
	
	
	
	
}
