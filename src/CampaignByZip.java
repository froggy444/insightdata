

import java.util.Objects;

public class CampaignByZip {


    private String zip;
    private String cmpid;
    private Integer totalContributionAmt=0;

    public CampaignByZip(String zip, String cmpid) {
        this.zip = zip;
        this.cmpid = cmpid;
    }


    public Integer getTotalContributionAmt() {
        return totalContributionAmt;
    }

    public void setTotalContributionAmt(Integer totalContributionAmt) {
        this.totalContributionAmt = totalContributionAmt;
    }
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCmpid() {
        return cmpid;
    }

    public void setCmpid(String cmpid) {
        this.cmpid = cmpid;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(zip,cmpid);
    }

    @Override
    public boolean equals(Object o)
    {
      /*  if(this == o){
            return true;
        }*/
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        CampaignByZip that = (CampaignByZip) o;
        return Objects.equals(zip, that.zip) && Objects.equals(cmpid, that.cmpid);
    }

}
