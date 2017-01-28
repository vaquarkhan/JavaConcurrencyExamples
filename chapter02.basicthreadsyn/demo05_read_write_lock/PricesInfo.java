package demo05_read_write_lock;

import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {

	//
	private double price1;
	private double price2;

	//
	private ReadWriteLock lock;

	public PricesInfo() {
		price1 = 1.0;
		price2 = 2.0;
		
		lock = new ReentrantReadWriteLock();
	}
	
	// 
	public double getPrice1() {
		//
		lock.readLock().lock();
		
		// 
		System.out.println("price1 获得read锁   =====>");	
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double value = price1;
		System.out.println("price1 获得read锁   <=====");
		
		lock.readLock().unlock();
		
		return value;
	}
	
	//
	public double getPrice2() {
		// 
		lock.readLock().lock();
		
		System.out.println("price2 read  =====>");	// 
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double value = price2;
		System.out.println("price2  read  <=====");
		
		lock.readLock().unlock();
		
		return value;
	}
	
	// 
	public void setPrices(double price1, double price2) {
		// 
		lock.writeLock().lock();
		System.out.println(" at " + new Date());
		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.price1 = price1;
		this.price2 = price2;
		
		System.out.println("         at " + new Date());
		lock.writeLock().unlock();
	}
}
