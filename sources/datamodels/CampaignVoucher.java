package datamodels;

public class CampaignVoucher {
    public boolean allowMixOffers;
    public String campaignIcon;
    public String campaignText;
    public float conditionAmount;
    public String endDate;

    /* renamed from: id  reason: collision with root package name */
    public int f13838id;
    public boolean isCustomvoucher;
    public boolean isVoucherAvailable;
    public String message;
    public boolean multipleUse;
    public boolean newaccusation;
    public boolean onlinePayment;
    public String startDate;
    public boolean talabatDiscount;
    public String url;

    public String getVoucherTypeForTracking() {
        if (!this.isCustomvoucher) {
            return "normal";
        }
        if (this.newaccusation) {
            return "newaccusation";
        }
        if (this.talabatDiscount) {
            return "talabatDiscount";
        }
        return "normal";
    }
}
