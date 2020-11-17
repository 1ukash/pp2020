package ru.spbstu.iamm.telematics.parprog.lecture7;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private static int INITIAL_GOODS = 100000;
	private static final int INITIAL_ACC_VAL = 100000;
	private static final int NUM_OF_BUYERS = 3;
	private static int GOODS_PRICE = 3;
	private static Seller seller = new Seller();
	
	static class BankAccount {
		int value;

		public BankAccount(int value) {
			super();
			this.value = value;
		}
		
	}
	
	static abstract class Person {
		BankAccount account;
		int goodsNum;
		
		public Person(BankAccount account, int goodsNum) {
			super();
			this.account = account;
			this.goodsNum = goodsNum;
		}
		
	}
	
	static class Seller extends Person {

		public Seller() {
			super(new BankAccount(0), INITIAL_GOODS);
		}
		
		public BankAccount getAccount() {
			return account;
		}
		public void setAccount(BankAccount account) {
			this.account = account;
		}
		public int getGoodsNum() {
			return goodsNum;
		}
		public void setGoodsNum(int goodsNum) {
			this.goodsNum = goodsNum;
		}
		public  boolean trySell(BankAccount sellerMoney) {
			boolean canSell = false;
			synchronized (this) {
				canSell = goodsNum > 0 && sellerMoney.value > GOODS_PRICE;
				if (canSell) {
					goodsNum --;
					account.value += GOODS_PRICE;
				}
			}
			return canSell;
		}
	}
	
	static class Buyer extends Person implements Runnable {

		
		public Buyer() {
			super(new BankAccount(INITIAL_ACC_VAL), 0);
		}

		@Override
		public void run() {
			
			while (!Thread.currentThread().isInterrupted()) {
				
				if (seller.trySell(account)) {
				// if (seller.getGoodsNum() > 0 && account.value > GOODS_PRICE) {
				//	seller.setGoodsNum(seller.getGoodsNum() - 1);
				//	seller.getAccount().value = seller.getAccount().value + GOODS_PRICE;
					goodsNum ++;
					account.value -= GOODS_PRICE;
					/*try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				} else {
					break;
				}
			}
			
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		List<Buyer> buyers = new ArrayList<Buyer>();
		List<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < NUM_OF_BUYERS; i ++) {
			Buyer b = new Buyer();
			buyers.add(b);
			Thread t = new Thread(b);
			threads.add(t);
			t.start();
		}
		
		for (Thread t: threads) {
			t.join();
		}
		
		int moneyInSystem = 0;
		int goodsInSystem = 0;
		for (Buyer b: buyers) {
			moneyInSystem += b.account.value;
			goodsInSystem += b.goodsNum;
		}
		
		int deltaMoney = (moneyInSystem + seller.account.value)- INITIAL_ACC_VAL * NUM_OF_BUYERS;
		int deltaGoods = (goodsInSystem + seller.goodsNum) - INITIAL_GOODS;
		System.out.println("Delta money = " + deltaMoney + ", delta goods = " + deltaGoods);
		
	}

}
