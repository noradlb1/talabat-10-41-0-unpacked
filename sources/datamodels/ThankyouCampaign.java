package datamodels;

import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ThankyouCampaign {
    @SerializedName("msg")
    public String description;
    @SerializedName("hed")
    public String heading;
    @SerializedName("ico")
    public String icon;

    /* renamed from: id  reason: collision with root package name */
    public int f13875id;
    @SerializedName("title")
    public String title;
    public String url;
    @SerializedName("cd")
    public String voucherCode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ThankyouCampaign thankyouCampaign = (ThankyouCampaign) obj;
        if (this.f13875id != thankyouCampaign.f13875id) {
            return false;
        }
        String str = this.icon;
        if (str == null ? thankyouCampaign.icon != null : !str.equals(thankyouCampaign.icon)) {
            return false;
        }
        String str2 = this.heading;
        if (str2 == null ? thankyouCampaign.heading != null : !str2.equals(thankyouCampaign.heading)) {
            return false;
        }
        String str3 = this.description;
        if (str3 == null ? thankyouCampaign.description != null : !str3.equals(thankyouCampaign.description)) {
            return false;
        }
        String str4 = this.voucherCode;
        if (str4 == null ? thankyouCampaign.voucherCode != null : !str4.equals(thankyouCampaign.voucherCode)) {
            return false;
        }
        String str5 = this.url;
        if (str5 == null ? thankyouCampaign.url != null : !str5.equals(thankyouCampaign.url)) {
            return false;
        }
        String str6 = this.title;
        String str7 = thankyouCampaign.title;
        if (str6 != null) {
            return str6.equals(str7);
        }
        if (str7 == null) {
            return true;
        }
        return false;
    }

    public String getLogo() {
        return GlobalDataModel.imageBaseUrl + this.icon;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = this.f13875id * 31;
        String str = this.icon;
        int i17 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i18 = (i16 + i11) * 31;
        String str2 = this.heading;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i19 = (i18 + i12) * 31;
        String str3 = this.description;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i21 = (i19 + i13) * 31;
        String str4 = this.voucherCode;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i22 = (i21 + i14) * 31;
        String str5 = this.url;
        if (str5 != null) {
            i15 = str5.hashCode();
        } else {
            i15 = 0;
        }
        int i23 = (i22 + i15) * 31;
        String str6 = this.title;
        if (str6 != null) {
            i17 = str6.hashCode();
        }
        return i23 + i17;
    }

    public String toString() {
        return "ThankyouCampaign{id=" + this.f13875id + ", icon='" + this.icon + '\'' + ", heading='" + this.heading + '\'' + ", description='" + this.description + '\'' + ", voucherCode='" + this.voucherCode + '\'' + ", url='" + this.url + '\'' + ", title='" + this.title + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
