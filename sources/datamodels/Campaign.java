package datamodels;

public class Campaign {
    public int campaignType;
    public String campaignUrl;
    public boolean isCampaignActive;

    public Campaign(boolean z11, int i11, String str) {
        this.campaignType = i11;
        this.campaignUrl = str;
        this.isCampaignActive = z11;
    }
}
