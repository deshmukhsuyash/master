package com.aa.socialmedia.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inovoicedetail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InovoiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inovoiceNumber")
	private Integer inovoice_number;
	@Column(name = "inovoiceTotal")
	private String inovoice_total;
	@Column(name = "billType")
	private String bill_type;
	@Column(name = "billDate")
	private Date bill_date;

}
