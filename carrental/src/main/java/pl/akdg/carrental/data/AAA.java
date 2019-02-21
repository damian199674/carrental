package pl.akdg.carrental.data;

public class AAA {
		public static void main(String[] args) {
			String a="rent_return=2019-02-22&payment=cash&rent_start=2019-02-21";
			String[] parts=a.split("&");
			String part=parts[1];
			System.out.println(part);
			part=part.substring(8);
			System.out.println(part);


	}
}
