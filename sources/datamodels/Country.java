package datamodels;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Deprecated
public class Country {
    @SerializedName("cwa")
    @Json(name = "cwa")
    public boolean canShowCollectionWidget;
    @SerializedName("cities")
    @Json(name = "cities")
    public City[] cities;
    @SerializedName("cd")
    @Json(name = "cd")
    public String code;
    @SerializedName("irc")
    @Json(name = "irc")
    public boolean contactlessPaymentEnabled;
    @SerializedName("curs")
    @Json(name = "curs")
    public String currencySymbol;
    @SerializedName("tpay")
    @Json(name = "tpay")
    public boolean enableTalabatPay;
    @SerializedName("itce")
    @Json(name = "itce")
    public boolean enableTalabtCredit;
    @SerializedName("id")
    @Json(name = "id")

    /* renamed from: id  reason: collision with root package name */
    public int f13845id;
    @SerializedName("isNAcity")
    @Json(name = "isNAcity")
    public boolean isCityInAddress;
    @SerializedName("iscompliance")
    @Json(name = "iscompliance")
    public boolean isComplianceEnabled;
    @SerializedName("issel")
    @Json(name = "issel")
    public boolean isDefault;
    @SerializedName("im")
    @Json(name = "im")
    public boolean isMapEnabledCountry;
    @SerializedName("ht")
    @Json(name = "ht")
    public boolean isTokenisationEnabledCountry;
    @SerializedName("vca")
    @Json(name = "vca")
    public boolean isVisaCheckoutAvailable;
    @SerializedName("na")
    @Json(name = "na")

    /* renamed from: name  reason: collision with root package name */
    public String f13846name;
    @SerializedName("dno")
    @Json(name = "dno")
    public int numOfDecimalPlaces;
    @SerializedName("icc")
    @Json(name = "icc")
    public boolean supportsInternalization;
    @SerializedName("tp")
    @Json(name = "tp")
    public int tokenisationProvider;

    public String toString() {
        return "Country{id=" + this.f13845id + ", name='" + this.f13846name + '\'' + ", isCityInAddress=" + this.isCityInAddress + ", currencySymbol='" + this.currencySymbol + '\'' + ", numOfDecimalPlaces=" + this.numOfDecimalPlaces + ", cities=" + Arrays.toString(this.cities) + ", isDefault=" + this.isDefault + ", isTokenisationEnabledCountry=" + this.isTokenisationEnabledCountry + ", tokenisationProvider=" + this.tokenisationProvider + ", isVisaCheckoutAvailable=" + this.isVisaCheckoutAvailable + ", canShowCollectionWidget=" + this.canShowCollectionWidget + ", isMapEnabledCountry=" + this.isMapEnabledCountry + ", supportsInternalization=" + this.supportsInternalization + ", enableTalabtCredit=" + this.enableTalabtCredit + ", enableTalabatPay=" + this.enableTalabatPay + ", contactlessPaymentEnabled=" + this.contactlessPaymentEnabled + ", isComplianceEnabled=" + this.isComplianceEnabled + ", code='" + this.code + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
