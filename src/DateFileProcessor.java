

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DateFileProcessor {


    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
public String Output;
    private int total_count=1;

    public Map<CampaignByDate, CampaignValue> processDate(Campaign input, Map<CampaignByDate, CampaignValue> CampaignByDateMap) {
        DateFileProcessor DateFileProcessor = new DateFileProcessor();
        CampaignByDate CampaignByDate = new CampaignByDate(input.getCmpid(),input.getdate() );
        Median1 runningMedian = new Median1();

        WriteDate writeDate=new WriteDate();
        if (input.getCmpid() != null && input.getdate() != null) {
            List<Long> amountList = new ArrayList<Long>();
            if (!CampaignByDateMap.containsKey(CampaignByDate)) {
                amountList.add(Long.parseLong(input.getamount()));
                CampaignValue campaignValue = new CampaignValue(1,
                        0,Integer.parseInt(input.getamount()));
                campaignValue.setAmountList(amountList);
                List<Long> runningMedianList = runningMedian.calculateMedian(
                        campaignValue.getAmountList(),campaignValue.getRunningCount());
                campaignValue.setRunningMedian(runningMedianList.get(0));

                CampaignByDateMap.put(CampaignByDate, campaignValue);
            } else {
                Integer newRunningCount = CampaignByDateMap.get(CampaignByDate).getRunningCount() + 1;
                Long newTotalContribution = Long.parseLong(input.getamount()) +
                        CampaignByDateMap.get(CampaignByDate).getTotalContributionAmount();
                CampaignValue campaignValue = new CampaignValue(newRunningCount,
                        0,newTotalContribution);
                if(CampaignByDateMap.get(CampaignByDate).getAmountList().size() == 1){
                    amountList.add(Long.parseLong(input.getamount()));
                    amountList.add(CampaignByDateMap.get(CampaignByDate).getTotalContributionAmount());
                    campaignValue.setAmountList(amountList);
                }
                else{
                    campaignValue.setAmountList(CampaignByDateMap.get(CampaignByDate).getAmountList());
                    campaignValue.getAmountList().add(Long.parseLong(input.getamount()));
                    campaignValue.setAmountList(campaignValue.getAmountList());
                }
                List<Long> runningMedianList = runningMedian.calculateMedian(
                        campaignValue.getAmountList(),campaignValue.getRunningCount());
                campaignValue.setRunningMedian(runningMedianList.get(campaignValue.getRunningCount()-1));

                CampaignByDateMap.put(CampaignByDate,campaignValue);
                //CampaignByDate.setTotalContributionAmt(CampaignByDate.getTotalContributionAmt() +
                //Integer.parseInt(input.getamount()));

            }
            int runningCount = CampaignByDateMap.get(CampaignByDate).getRunningCount();
            long totalContribution = CampaignByDateMap.get(CampaignByDate).getTotalContributionAmount();
            long runningMed = CampaignByDateMap.get(CampaignByDate).getRunningMedian();

            DateFileProcessor.setTotal_count(runningCount);

           /* System.out.println("Running Count is" +runningCount);
            System.out.println("Running Total Contribution is" +totalContribution);
*/

            return CampaignByDateMap;

        }


        return null;
    }

}