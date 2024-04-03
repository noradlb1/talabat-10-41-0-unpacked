package JsonModels.Request.Cashback;

public class CashBackRequest {
    public String amount;
    public String countryId;
    public String eventType = "1";

    public CashBackRequest(String str, String str2) {
        this.amount = str;
        this.countryId = str2;
    }
}
