package com.ocbc.view;

import java.util.Date;
import java.util.concurrent.SynchronousQueue;

import com.ocbc.dao.CutomerGenerator;
import com.ocbc.dao.NormalCustomerHandler;
import com.ocbc.dao.QuickCustomerHandler;
import com.ocbc.dao.VIPCustomerHandler;
import com.ocbc.model.Customer;

public class Operator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CutomerGenerator cg = new CutomerGenerator();
		VIPCustomerHandler vip_CH = new VIPCustomerHandler();
		QuickCustomerHandler quick_CH = new QuickCustomerHandler();
		NormalCustomerHandler normal_CH_1 = new NormalCustomerHandler(1);
		NormalCustomerHandler normal_CH_2 = new NormalCustomerHandler(2);
		NormalCustomerHandler normal_CH_3 = new NormalCustomerHandler(3);
		NormalCustomerHandler normal_CH_4 = new NormalCustomerHandler(4);
		
		cg.start();
		
		normal_CH_1.start();
		normal_CH_2.start();
		normal_CH_3.start();
		normal_CH_4.start();
		
		
		vip_CH.start();
		quick_CH.start();

	}

}
