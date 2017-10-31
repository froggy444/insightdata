

public class PreProcessor {

    public boolean acceptInput (Campaign campaign){
        if(campaign.getOthrid() != null){
            return false;
        }
        if(!isTransactionAmountValid(campaign.getamount())){
            return false;
        }
        if(!isCmtIdValid(campaign.getCmpid())){
            return false;
        }

        else {
            return true;
        }
    }

    public boolean isTransactionAmountValid(String amount) {

            if(!isInteger(amount)){
                return false;
            }

            Integer transactionAmt = Integer.parseInt(amount);
            //amount is null
            if(transactionAmt == null){
                return false;
            }
            if(transactionAmt <= 0){
                return false;
            }
            return true;

    }

    public boolean isCmtIdValid(String cmpid){
        if(cmpid ==null){
            return false;
        }
        if(cmpid.length()>9){
            return false;
        }
        return true;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
