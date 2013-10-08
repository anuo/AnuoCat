package com.anuo.java;

public class JavaBasic {
	public static void main(String[] args) {
		 
		int age= computeAge(8);
		String k=translate("蒋奎");
		System.out.println(k);
	}
	public static int computeAge(int n){
		if (n==1) {
			return 10;
		}
		return computeAge(n-1)+2;
	}
	//输出某种编码的字符串
	public static String translate(String str){
		String tsStr="";
		try{
			tsStr=new String(str.getBytes("UTF-8"),"UTF-8");
		}catch(Exception e){
			System.err.print(e.getMessage());
		}
		return tsStr;
	}
}
