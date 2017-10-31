

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RunningMedianProcessor {


    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    private int total_count=1;

    public Map<CampaignByZip, CampaignValue> processZipCode(Campaign input, Map<CampaignByZip, CampaignValue> campaignByZipMap) {

        RunningMedianProcessor runningMedianProcessor = new RunningMedianProcessor();
        AppendToFileExample appendToFileExample = new AppendToFileExample();
        Median1 runningMedian = new Median1();
        if (input.getCmpid() != null && input.getzip() != null) {
            List<Long> amountList = new ArrayList<Long>();
            CampaignByZip campaignByZip = new CampaignByZip(input.getzip(), input.getCmpid());
            if (!campaignByZipMap.containsKey(campaignByZip)) {
                amountList.add(Long.parseLong(input.getamount()));
                CampaignValue campaignValue = new CampaignValue(1,
                        0,Integer.parseInt(input.getamount()));
                campaignValue.setAmountList(amountList);
                List<Long> runningMedianList = runningMedian.calculateMedian(
                        campaignValue.getAmountList(),campaignValue.getRunningCount());
                campaignValue.setRunningMedian(runningMedianList.get(0));
                campaignByZipMap.put(campaignByZip, campaignValue);
            } else {
                Integer newRunningCount = campaignByZipMap.get(campaignByZip).getRunningCount() + 1;
                Long newTotalContribution = Long.parseLong(input.getamount()) +
                        campaignByZipMap.get(campaignByZip).getTotalContributionAmount();
                CampaignValue campaignValue = new CampaignValue(newRunningCount,
                        0,newTotalContribution);
                if(campaignByZipMap.get(campaignByZip).getAmountList().size() == 1){
                    amountList.add(Long.parseLong(input.getamount()));
                    amountList.add(campaignByZipMap.get(campaignByZip).getTotalContributionAmount());
                    campaignValue.setAmountList(amountList);
                }
                else{
                    campaignValue.setAmountList(campaignByZipMap.get(campaignByZip).getAmountList());
                    campaignValue.getAmountList().add(Long.parseLong(input.getamount()));
                    campaignValue.setAmountList(campaignValue.getAmountList());
                }
                List<Long> runningMedianList = runningMedian.calculateMedian(
                        campaignValue.getAmountList(),campaignValue.getRunningCount());
                campaignValue.setRunningMedian(runningMedianList.get(campaignValue.getRunningCount()-1));

                campaignByZipMap.put(campaignByZip,campaignValue);


            }
            int runningCount = campaignByZipMap.get(campaignByZip).getRunningCount();
            long totalContribution = campaignByZipMap.get(campaignByZip).getTotalContributionAmount();
            runningMedianProcessor.setTotal_count(runningCount);
            long runningMed = campaignByZipMap.get(campaignByZip).getRunningMedian();
           /* System.out.println("Running Count is" +runningCount);
            System.out.println("Running Total Contribution is" +totalContribution);
*/
            String Output = input.getCmpid() + "|" +input.getzip()+"|"+runningMed+"|"+runningCount+"|"+
                    +totalContribution;
            appendToFileExample.WriteFile1(Output);

            return campaignByZipMap;
        }
        return null;
    }
}




