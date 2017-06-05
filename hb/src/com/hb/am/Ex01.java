package com.hb.am;
// 제어의 역전 
interface fun{
	void print();
}

class Ex01_1_1 implements fun{ //setter
	public void print(){
		System.out.println("기능 호출 1");
	}
}
class Ex01_1_2 implements fun{ //setter
	public void print(){
		System.out.println("기능 호출 2");
	}
}
class Ex01_1{
	private fun ex;
	
	public void setEx(fun ex) {
		this.ex = ex;
	}
	public void func(){
//		Ex01_1_1 ex = new Ex01_1_1();
		this.ex.print();
	}
}

public class Ex01 {
	public static void main(String[] args){
		Ex01_1 ex = new Ex01_1();
//		Ex01_1_1 ex2 = new Ex01_1_1();
		ex.setEx(new Ex01_1_2()); //getter
		ex.func();
	}
}
