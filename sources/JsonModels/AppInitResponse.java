package JsonModels;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import com.talabat.domain.address.Address;
import datamodels.Area;
import datamodels.Country;

public class AppInitResponse {
    @SerializedName("addresses")
    @Json(name = "addresses")
    public Address[] addresses = null;
    @SerializedName("areas")
    @Json(name = "areas")
    public Area[] areas = null;
    @SerializedName("countries")
    @Json(name = "countries")
    public Country[] countries = null;
    @SerializedName("isAddressMicroServiceEnabled")
    @Json(name = "isAddressMicroServiceEnabled")
    public boolean isAddressMicroServiceEnabled = false;
    @SerializedName("publicKey")
    @Json(name = "publicKey")
    public String publicKey = null;
    @SerializedName("tokens")
    @Json(name = "tokens")
    public TokenisationCreditCard[] tokens = null;
    @SerializedName("url")
    @Json(name = "url")
    public String url = null;
}
