package com.gaurav.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.core.dao.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	private PaymentDAO dao;
	
	@Autowired
	public PaymentDAO getDao() {
		return dao;
	}

	public void setDao(PaymentDAO dao) {
		this.dao = dao;
	}
	

}
