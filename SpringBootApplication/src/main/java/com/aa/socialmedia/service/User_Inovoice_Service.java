package com.aa.socialmedia.service;

import java.util.List;

import com.aa.socialmedia.model.Inovoice;

public interface User_Inovoice_Service {

	public List<Inovoice> getInovoices();
	public void saveInovoices(Inovoice inovoice);
	public void deleteInovoices(Inovoice inovoice);
	public void updateInovoices(Inovoice inovoice);

}
