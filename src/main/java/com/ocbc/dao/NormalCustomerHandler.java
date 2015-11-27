package com.ocbc.dao;

import java.util.Date;

import com.ocbc.data.NormalQueue;
import com.ocbc.data.QuickQueue;
import com.ocbc.data.VIPQueue;
import com.ocbc.model.Customer;

public class NormalCustomerHandler extends Thread{
	private int tableNo = 1;
	
	public NormalCustomerHandler(int i) {
		tableNo = i;
	}



	private void HandleNormal(){
		if(NormalQueue.queue.size() != 0){
			Customer c = (Customer) NormalQueue.queue.poll();
			System.out.println("handle" + VIPQueue.queue.size() + ":" + NormalQueue.queue.size() + ":" + QuickQueue.queue.size());
			
			Date d = new Date();
			System.out.print(d.getHours()+":"+d.getMinutes()+":"+d.getSeconds() + " ");
			System.out.println("Sitting down at table " + tableNo + " " + c.getType() + c.getId() + " " + c.getTime() + "minutes");
			try {
				Thread.sleep(c.getTime() * 60 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			d = new Date();
			System.out.print(d.getHours()+":"+d.getMinutes()+":"+d.getSeconds() + " ");
			System.out.println("Normal " + c.getType() + c.getId() + " customer leaving...");
		}
	}
	


	@Override
	public void run() {
		while(true){
			HandleNormal();
		}
	}
}
