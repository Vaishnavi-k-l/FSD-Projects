package com.myCompany.InheritanceDemo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@DiscriminatorValue("Current Account")
@EqualsAndHashCode(callSuper = false)
public class CurrentAccount extends Account
{
	private String email;
	
	public CurrentAccount()
	{
		
	}
	
	public CurrentAccount(String name, int acc_num, int balance,  String email )
	{
		super(name, acc_num, balance);
		this.email = email;
	}
	
}
