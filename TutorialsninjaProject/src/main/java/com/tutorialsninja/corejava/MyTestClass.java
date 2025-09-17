package com.tutorialsninja.corejava;

public class MyTestClass extends MyAbstractClass implements MyInterface {
	
	

	
	
	public static void main(String[] args) {
		
		MyTestClass mtc=new MyTestClass();
		String a=mtc.a();
		System.out.println(a);
		int num=mtc.b();
		System.out.println(num);
		boolean b=mtc.c();
		System.out.println(b);
		String r[]=mtc.d();
		for(String name:r) {
		System.out.println(name);	
		}
		
		
	}

	@Override
	public String a() {
		// TODO Auto-generated method stub
		return "mairaj";
	}

	@Override
	public int b() {
		// TODO Auto-generated method stub
		return 300;
	}

	@Override
	public boolean c() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] d() {
		// TODO Auto-generated method stub
		String asd[]={"a","b"};
		return asd;
	}

}
