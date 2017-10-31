


public class Campaign {

	 private String zip;
	 private String amount;
	 private String date;
	 private String Othrid;
	 private String Cmpid;
	private int count;
	private Double Median;

	public Double getMedian() {
		return Median;
	}

	public void setMedian(Double median) {
		Median = median;
	}




	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	
	 
	 public Campaign(){
	
	 }
	 
 public Campaign(String information) {
	 super();

	 
	 String[] words= information.split("\\|");

	 this.setCmpid(words[0]);
	 this.setzip(words[10]);
	 this.setdate(words[13]);
	 this.setamount(words[14]);
	 this.setOthrid(words[15]);
	
	 }

	 
	 public String getCmpid() {
		 return Cmpid;
		 }

	public void setzip(String zip){
	 this.zip = (String) zip.subSequence(0, 5);
	 }
	 public String getzip(){
	 return this.zip;
	 }
	 public String getdate() {
	 return date;
	 }
	 public void setdate(String date) {
	 this.date = date;
	 }
	
	 public void setCmpid(String Cmpid) {
	 this.Cmpid = Cmpid;
	 }
	 public String getOthrid() {
	 return Othrid;
	 }
	 public void setOthrid(String Othrid) {
		if( Othrid.isEmpty()) {
			Othrid=null;
		}
		else 
		 this.Othrid = Othrid;
		 
		 
	 }
	 public String getamount() {
	 return amount;
	 }
	 public void setamount(String amount) {
	 this.amount = amount;
	 }

	}
	

