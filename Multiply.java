import java.util.Scanner;
public class Multiply {
	private static char newN1[];
	private static char newN2[];
	private static char newN3[];
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Please input a number.");
		String n1=input.next();
		int x=n1.length();
		while(x!=0) {
			newN1 = new char[n1.length()];
			for(int i=0;i<n1.length();i++)newN1[i] = n1.charAt(i);
			x=n1.length();
			for(int i=0;i<n1.length();i++) {
				if(Character.isDigit(newN1[i])) {
					x--;
				}
			}
			if(x!=0) {
				System.out.println("Please change another one,there must be something not belong to numbers.");
				n1=input.next();
			}
		}
		System.out.println("Please input another number.");
		String n2=input.next();
		x=n2.length();
		while(x!=0) {
			newN2 = new char[n2.length()];
			for(int i=0;i<n2.length();i++)newN2[i] = n2.charAt(i);
			x=n2.length();
			for(int i=0;i<n2.length();i++) {
				if(Character.isDigit(newN2[i])) {
					x--;
				}
			}
			if(x!=0) {
				System.out.println("Please change another one,there must be something not belong to numbers.");
				n2=input.next();
			}
		}//Integer Only
		if(n1.length()<n2.length()) {
			String n3=n1;
			n1=n2;
			n2=n3;
		}//位數大對位數小
		newN1 = new char[n1.length()];
		for(int i=0;i<n1.length();i++)newN1[i] = n1.charAt(i);
		newN2 = new char[n2.length()];
		for(int i=0;i<n2.length();i++)newN2[i] = n2.charAt(i);
		x=newN1.length;
		int y=newN2.length;
		newN3=new char[x+y];
		for(int i=0;i<x+y;i++) {
			newN3[i]="0".charAt(0);
		}
		for(int i=x-1;i>=0;i--) {
			for(int a=y-1;a>=0;a--) {
				if(Integer.parseInt(String.valueOf(newN3[i+a+1]))+
						(Integer.parseInt(String.valueOf(newN1[i]))*Integer.parseInt(String.valueOf(newN2[a])))%10>=10) {
					for(int b=i+a;b>=0;b--) {
						if(Integer.parseInt(String.valueOf(newN3[b]))+1>=10) {
							newN3[b]="0".charAt(0);
						}
						else {
							newN3[b]=Integer.toString(Integer.parseInt(String.valueOf(newN3[b]))+1).charAt(0);
							break;
						}
					}
				}//乘起來後,個位數和原本就在N3的數相加,大於10就往前丟1
				newN3[i+a+1]=Integer.toString((Integer.parseInt(String.valueOf(newN3[i+a+1]))+
					(Integer.parseInt(String.valueOf(newN1[i]))*Integer.parseInt(String.valueOf(newN2[a])))%10)%10).charAt(0);
				if(Integer.parseInt(String.valueOf(newN3[i+a]))+
						(Integer.parseInt(String.valueOf(newN1[i]))*Integer.parseInt(String.valueOf(newN2[a])))/10>=10) {
					for(int b=i+a-1;b>=0;b--) {
						if(Integer.parseInt(String.valueOf(newN3[b]))+1>=10) {
							newN3[b]="0".charAt(0);
						}
						else {
							newN3[b]=Integer.toString(Integer.parseInt(String.valueOf(newN3[b]))+1).charAt(0);
							break;
						}
					}
				}//乘起來後,十位數和原本就在N3的數相加,大於10就往前丟1
				newN3[i+a]=Integer.toString((Integer.parseInt(String.valueOf(newN3[i+a]))+
					(Integer.parseInt(String.valueOf(newN1[i]))*Integer.parseInt(String.valueOf(newN2[a])))/10)%10).charAt(0);
			}//我的想法:反正最多也就9*9=81，最多也就拆成兩個
		}
		for(int i=0;i<x;i++) {
			if(newN3[i]=="0".charAt(0)) {
				newN3[i]=" ".charAt(0);
			}
			else {
				break;
			}
		}
		System.out.println(String.valueOf(newN3));
	}
}
