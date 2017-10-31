



public class Contributions {

	

		public static void main(String[] args)  {
			
			
		
		 String sampleString = "Cs0017367|1 |2 |3 |4 |5 |6 |7 |8| 9|07304| | |01121989|50|Chg33434";
		 Campaign cp = new Campaign(sampleString);
		 System.out.println("Campaign id: "+cp.getCmpid());
		 System.out.println("zip: "+cp.getzip());
		 System.out.println("date: "+cp.getdate());
		 System.out.println("amount: "+cp.getamount());
		 System.out.println("Other id: "+cp.getOthrid()); 
		 

		}
		}

