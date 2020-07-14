package com.aa.socialmedia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inovoice_detail")
public class Inovoice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer inovoice_number;
	private String inovoice_total;
	private String bill_type;
	private Date bill_date;
	
	public Inovoice()
	{
		
	}
	public Inovoice(Integer inovoice_number, String inovoice_total, String bill_type, Date bill_date) {
		super();
		this.inovoice_number = inovoice_number;
		this.inovoice_total = inovoice_total;
		this.bill_type = bill_type;
		this.bill_date = bill_date;
	}
	public Integer getInovoice_number() {
		return inovoice_number;
	}
	public void setInovoice_number(Integer inovoice_number) {
		this.inovoice_number = inovoice_number;
	}
	public String getInovoice_total() {
		return inovoice_total;
	}
	public void setInovoice_total(String inovoice_total) {
		this.inovoice_total = inovoice_total;
	}
	public String getBill_type() {
		return bill_type;
	}
	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
	public Date getBill_date() {
		return bill_date;
	}
	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}
	@Override
	public String toString() {
		return "Inovoice [inovoice_number=" + inovoice_number + ", inovoice_total=" + inovoice_total + ", bill_type="
				+ bill_type + ", bill_date=" + bill_date + "]";
	}
	
	
}
