package com.myCompany.InheritanceDemo.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Account_Type")
@DiscriminatorValue("Account")
public class Account
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int acc_num;
	private int balance;
	
	public Account()
	{
		
	}
	
	public Account(String name, int acc_num, int balance )
	{
		this.name = name;
		this.acc_num = acc_num;
		this.balance = balance;
	}
}
