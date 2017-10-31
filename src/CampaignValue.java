import java.util.List;

public class CampaignValue {
    private int runningCount;
    private long runningMedian;
    private long totalContributionAmount;
    private List<Long> amountList;

    public CampaignValue(int runningCount, long runningMedian, long totalContributionAmount) {
        this.runningCount = runningCount;
        this.runningMedian = runningMedian;
        this.totalContributionAmount = totalContributionAmount;
    }


    public long getTotalContributionAmount() {
        return totalContributionAmount;
    }

    public void setTotalContributionAmount(long totalContributionAmount) {
        this.totalContributionAmount = totalContributionAmount;
    }

    public List<Long> getAmountList() {
        return amountList;
    }

    public void setAmountList(List<Long> amountList) {
        this.amountList = amountList;
    }

    public int getRunningCount() {
        return runningCount;
    }

    public void setRunningCount(int runningCount) {
        this.runningCount = runningCount;
    }

    public long getRunningMedian() {
        return runningMedian;
    }

    public void setRunningMedian(long runningMedian) {
        this.runningMedian = runningMedian;
    }


}
