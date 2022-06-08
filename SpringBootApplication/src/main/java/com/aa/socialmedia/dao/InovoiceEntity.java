package com.aa.socialmedia.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inovoice_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InovoiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inovoice_number;
	private String inovoice_total;
	private String bill_type;
	private Date bill_date;

}
