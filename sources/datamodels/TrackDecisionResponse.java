package datamodels;

import com.google.gson.annotations.SerializedName;

public class TrackDecisionResponse {
    @SerializedName("rti")
    public int loadRequestInterval = 10;
    @SerializedName("9ci")
    public int nineCookieInterval = 5;
    @SerializedName("turl")
    public String trackURL;
    @SerializedName("u9c")
    public boolean useNineCookie = true;
}
