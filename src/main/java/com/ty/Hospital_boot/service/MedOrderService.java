package com.ty.Hospital_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital_boot.dao.MedOrderDao;
import com.ty.Hospital_boot.dto.MedItems;
import com.ty.Hospital_boot.dto.MedOrder;
import com.ty.Hospital_boot.util.ResponseStructure;

@Service
public class MedOrderService {

	@Autowired
	MedOrderDao dao;

	public ResponseEntity<ResponseStructure<MedOrder>> servicesaveMedOrder(MedOrder medOrder) {
		List<MedItems> list = medOrder.getMedItems();
		double totalcost = 0;
		for (MedItems medItems : list) {
			totalcost = totalcost + (medItems.getPrice() * medItems.getQty());
		}
		medOrder.setTotalprice(totalcost);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Medorder Created ");
		responseStructure.setData(dao.saveMedOrder(medOrder));
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<MedOrder>> serviceupdateMedOrder(MedOrder medOrder, int id) {
		List<MedItems> list = medOrder.getMedItems();
		double totalcost = 0;
		for (MedItems medItems : list) {
			totalcost = totalcost + (medItems.getPrice() * medItems.getQty());
		}
		medOrder.setTotalprice(totalcost);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		MedOrder medOrder2 = dao.findmedorderbyid(id);
		if (medOrder2 != null) {
			medOrder.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Medorder Updated ");
			responseStructure.setData(dao.saveMedOrder(medOrder));
			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.OK);
		} else
			return null;
	}

	public ResponseEntity<ResponseStructure<MedOrder>> servicefindbyid(int id) {
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage(" Found Medorder");
		responseStructure.setData(dao.findmedorderbyid(id));
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> servicedeletebyid(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted Medorder");
		responseStructure.setData(dao.deleteMedOrder(id));
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
	}
}
