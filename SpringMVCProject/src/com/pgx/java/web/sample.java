package com.pgx.java.web;

class numerException extends Exception{
	public numerException() {
		super();
	}
}
class factorial {
	int fact(int n) {
		int result;
		if ( n ==1)
		return 1;
		result = fact (n-1) * n;
		return result;
	}
}
public class sample {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		factorial kdSample = new factorial();
		int pInteger = kdSample.fact(4);
		System.out.println("-->"+pInteger);

		String tString = "people go outside";
		char[] kj = tString.toCharArray();
		StringBuilder ng = new StringBuilder();
		System.out.println("--->"+ kj.length);
		for(int i=kj.length-1; i>=0 ;i--) {
			ng.append(String.valueOf(kj[i]));  
		}
		System.out.println(ng.toString());

		int count = 0;
		ng.delete(0, kj.length);
		int length = 0;
		try {
			for (int i = 0; i < kj.length; i++) {
				if((!(ng.toString().contains(String.valueOf(kj[i])))) &&
						!(Character.isSpace(kj[i]))) {
					ng.append(kj[i]);
					for (int j = i+1; j < kj.length; j++) {
						if(String.valueOf(kj[i]).equalsIgnoreCase(String.valueOf(kj[j]))
								&& !(Character.isSpace(kj[j]))) {
							count++ ;	
							length++;
						}
					}
					count++;
					System.out.println(" -> "+kj[i]+" "+count); 
				}
				count = 0;
				if(length>0) {
					throw new numerException();
				}
			}  
		} 
		catch (numerException e) {
			System.out.println("sdsd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			String kjh = "safhiwe";
			char[] po = kjh.toCharArray();
			int lengthde = kjh.length() - 1;
			boolean ju = false;
			StringBuilder uhuillder = new StringBuilder();
			for (int i=lengthde; i>=0; i--) {
				uhuillder.append(String.valueOf(po[i]));
			}
			System.out.println(uhuillder.toString());
			try {
				for(int i=0; i<Math.ceil(kjh.length()/2); i++) {
					if(!(String.valueOf(po[i]).equalsIgnoreCase(String.valueOf(po[lengthde])))) {
						ju = true;
						break;
					}
					lengthde--;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("the array has enalrged");
			} finally {
				if(ju) {
					System.out.println("not");
				}else {
					System.out.println("yes");
				} 
			}

			String po2 = "ADGDJ";
			String po1 = "GDADJ";
			char[] po1har = po1.toCharArray();
			boolean ll = false;
			if(po1.length() == po2.length()) {
				for (int i = 0; i < po1.length(); i++) {
					if(!po2.contains(String.valueOf(po1har[i]))) {
						ll = true;
					}}
				if(ll) 	 
					System.out.println("not");
				else 
					System.out.println("yes");
			}
			

		}
	}
}
