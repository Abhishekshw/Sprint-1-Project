package com.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="seller")
public class Seller {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int sellerid;
	@Column
	private long sPhone;
	@Column
	private String sname;
	@Column
	private long pin;
	@Column
	private String sAddress;
}
