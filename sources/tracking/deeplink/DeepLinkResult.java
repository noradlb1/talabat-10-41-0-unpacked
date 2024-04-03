package tracking.deeplink;

public class DeepLinkResult {
    public String adjust_adgroup = "";
    public String adjust_campaign = "";
    public String adjust_creative = "";
    public String adjust_label = "";
    public String adjust_tracker = "";
    public String campaign = "";
    public String campaignCode = "";
    private String content = "";
    private String gclId = "";

    /* renamed from: id  reason: collision with root package name */
    private String f63537id = "";
    public String medium = "";
    public String source = "";
    private String term = "";

    public String getContent() {
        return this.content;
    }

    public String getGclId() {
        return this.gclId;
    }

    public String getId() {
        return this.f63537id;
    }

    public String getTerm() {
        return this.term;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setGclId(String str) {
        this.gclId = str;
    }

    public void setId(String str) {
        this.f63537id = str;
    }

    public void setTerm(String str) {
        this.term = str;
    }
}
