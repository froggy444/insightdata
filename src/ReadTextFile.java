

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadTextFile {
    public long count = 0;

    public static void main(String[] args) throws IOException {
        AppendToFileExample wr = new AppendToFileExample();
        ReadTextFile rf = new ReadTextFile();
        try {

            File f = new File("./input/itcont.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";



            Map<CampaignByZip, CampaignValue> campaignByZipMap = new HashMap<>();
            Map<CampaignByDate, CampaignValue> campaignByDateMap = new HashMap<>();
            Map<CampaignByDate, CampaignValue> campaignByDateMap2 = new HashMap<>();


            while ((readLine = b.readLine()) != null) {

                String line = readLine;

                Campaign cp = new Campaign(line);
                PreProcessor preProcessor = new PreProcessor();
                if (preProcessor.acceptInput(cp)) {

                    RunningMedianProcessor runningMedianProcessor = new RunningMedianProcessor();
                    DateFileProcessor dateFileProcessor = new DateFileProcessor();
                    CampaignByZip campaignByZip = new CampaignByZip(cp.getzip(), cp.getCmpid());
                    Map<CampaignByZip, CampaignValue> campaignByZipMap2 = runningMedianProcessor.processZipCode(cp, campaignByZipMap);

                    CampaignByDate campaignByDate = new CampaignByDate(cp.getCmpid(), cp.getdate());
                    campaignByDateMap2 = dateFileProcessor.processDate(cp, campaignByDateMap);
                   



                    rf.count++;

                }

            }
            for (CampaignByDate key : campaignByDateMap2.keySet()) {
                String output = key.getCmpId() + "|" + key.getDate() + "|"+campaignByDateMap2.get(key).getRunningMedian()+"|"
                        + campaignByDateMap2.get(key).getRunningCount() + "|" +
                        campaignByDateMap2.get(key).getTotalContributionAmount();

                WriteDate writeDate = new WriteDate();
                writeDate.WriteFile1(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
