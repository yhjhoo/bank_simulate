package com.ocbc.dao;

import java.util.Date;

import com.ocbc.data.NormalQueue;
import com.ocbc.data.QuickQueue;
import com.ocbc.data.VIPQueue;
import com.ocbc.model.Customer;

public class CutomerGenerator extends Thread{
	private final static int RATE_VIP =1;
	private final static int RATE_NORMAL =6;
	private final static int RATE_QUICK =3;
	
	private static int vip = 0;
	private static int normal = 0;
	private static int quick = 0;
	
	
	
	public static void main(String[] args) {
		CutomerGenerator gen = new CutomerGenerator();
		for(int i=0; i<1000; i++){
			gen.genCustomer();
		}
		System.out.println(vip + ":" + normal + ":" + quick);
		
		System.out.println(VIPQueue.queue.size() + ":" + NormalQueue.queue.size() + ":" + QuickQueue.queue.size());
	}

	@SuppressWarnings("unchecked")
	private void genCustomer(){
		int rate = (int) Math.ceil(Math.random()*10);
		Date d = new Date();
		System.out.print(d.getHours()+":"+d.getMinutes()+":"+d.getSeconds() + " ");
		
		if(rate <= RATE_VIP){
			vip++;
			System.out.println("VIP" + vip + " customer coming, welcome");
			Customer vip_C = new Customer();
			vip_C.setType(Customer.TYPE_VIP);
			vip_C.setTime(genTime() );
			vip_C.setId(vip);
			
			VIPQueue.queue.add(vip_C);
			
		}else if(rate <= (RATE_NORMAL+1)){
			normal++;
			System.out.println("NORMAL" + normal + " customer coming, welcome");
			Customer normal_C = new Customer();
			normal_C.setType(Customer.TYPE_NORMAL);
			normal_C.setTime(genTime() );
			normal_C.setId(normal);
			
			NormalQueue.queue.add(normal_C);
			
		}else{//quick
			quick++;
			System.out.println("QUICK" + quick+ " customer coming, welcome");
			Customer quick_C = new Customer();
			quick_C.setType(Customer.TYPE_QUICK);
			quick_C.setTime(genTime() );
			quick_C.setId(quick);
			
			QuickQueue.queue.add(quick_C);
			
		}
		if(rate>10 || rate <1){
			System.out.println("error");
			System.exit(0);
		}
//		System.out.println(vip + ":" + normal + ":" + quick);
	}
	
	
	private long genTime(){
		long minute = (long) Math.ceil(Math.random()*20);//1-20 minutes
		
		return minute; 
	}

	@Override
	public void run() {
		for(int i=0; i<20; i++){
			genCustomer();
			System.out.print(vip + ":" + normal + ":" + quick);
			System.out.println("\t" + VIPQueue.queue.size() + ":" + NormalQueue.queue.size() + ":" + QuickQueue.queue.size());
			try {
				sleep(10000);//10 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
