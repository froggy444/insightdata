

import java.util.Objects;

public class CampaignByDate {

    private String cmpId;
    private String date;
    private Integer totalContributionAmt=0;

    public Integer getTotalContributionAmt() {
        return totalContributionAmt;
    }

    public void setTotalContributionAmt(Integer totalContributionAmt) {
        this.totalContributionAmt = totalContributionAmt;
    }


    public CampaignByDate(String cmpId, String date) {
        this.cmpId = cmpId;
        this.date = date;
    }

    public String getCmpId() {
        return cmpId;
    }

    public void setCmpId(String cmpId) {
        this.cmpId = cmpId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(date,cmpId);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        CampaignByDate that = (CampaignByDate) o;
        return Objects.equals(date, that.date) && Objects.equals(cmpId, that.cmpId);
    }

}
