package datamodels;

import com.google.gson.annotations.SerializedName;
import com.talabat.domain.address.Address;
import com.talabat.helpers.TalabatUtils;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class TTransactionResponse {
    public ThankyouCampaign camp;
    @SerializedName("cl")
    public String charityLink;
    @SerializedName("chmsg")
    public String charityMessage;
    @SerializedName("ad")
    public Address deliveryAddress;
    @SerializedName("fom")
    public String firstOrderMessage;
    @SerializedName("isrealac")
    public boolean isRealAcquisition;
    @SerializedName("id")
    public int orderId;
    @SerializedName("pmsg")
    public String prayerTimeMessage;
    @SerializedName("srv")
    public Survey survey;
    @SerializedName("ord")
    public TOrderResponse[] tOrderResponses;
    @SerializedName("ms")
    public String thankyouMessage;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TTransactionResponse tTransactionResponse = (TTransactionResponse) obj;
        if (this.orderId != tTransactionResponse.orderId || this.isRealAcquisition != tTransactionResponse.isRealAcquisition || !Arrays.equals(this.tOrderResponses, tTransactionResponse.tOrderResponses)) {
            return false;
        }
        Address address = this.deliveryAddress;
        if (address == null ? tTransactionResponse.deliveryAddress != null : !address.equals(tTransactionResponse.deliveryAddress)) {
            return false;
        }
        String str = this.firstOrderMessage;
        if (str == null ? tTransactionResponse.firstOrderMessage != null : !str.equals(tTransactionResponse.firstOrderMessage)) {
            return false;
        }
        String str2 = this.prayerTimeMessage;
        if (str2 == null ? tTransactionResponse.prayerTimeMessage != null : !str2.equals(tTransactionResponse.prayerTimeMessage)) {
            return false;
        }
        String str3 = this.charityMessage;
        if (str3 == null ? tTransactionResponse.charityMessage != null : !str3.equals(tTransactionResponse.charityMessage)) {
            return false;
        }
        Survey survey2 = this.survey;
        if (survey2 == null ? tTransactionResponse.survey != null : !survey2.equals(tTransactionResponse.survey)) {
            return false;
        }
        String str4 = this.thankyouMessage;
        if (str4 == null ? tTransactionResponse.thankyouMessage != null : !str4.equals(tTransactionResponse.thankyouMessage)) {
            return false;
        }
        String str5 = this.charityLink;
        if (str5 == null ? tTransactionResponse.charityLink != null : !str5.equals(tTransactionResponse.charityLink)) {
            return false;
        }
        ThankyouCampaign thankyouCampaign = this.camp;
        ThankyouCampaign thankyouCampaign2 = tTransactionResponse.camp;
        if (thankyouCampaign != null) {
            return thankyouCampaign.equals(thankyouCampaign2);
        }
        if (thankyouCampaign2 == null) {
            return true;
        }
        return false;
    }

    public String getCharityMessage() {
        return this.charityMessage;
    }

    public String getFirstOrderMessage() {
        return this.firstOrderMessage;
    }

    public String getPrayerTimeMessage() {
        return this.prayerTimeMessage;
    }

    public Survey getSurvey() {
        return this.survey;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int hashCode = ((this.orderId * 31) + Arrays.hashCode(this.tOrderResponses)) * 31;
        Address address = this.deliveryAddress;
        int i18 = 0;
        if (address != null) {
            i11 = address.hashCode();
        } else {
            i11 = 0;
        }
        int i19 = (hashCode + i11) * 31;
        String str = this.firstOrderMessage;
        if (str != null) {
            i12 = str.hashCode();
        } else {
            i12 = 0;
        }
        int i21 = (i19 + i12) * 31;
        String str2 = this.prayerTimeMessage;
        if (str2 != null) {
            i13 = str2.hashCode();
        } else {
            i13 = 0;
        }
        int i22 = (i21 + i13) * 31;
        String str3 = this.charityMessage;
        if (str3 != null) {
            i14 = str3.hashCode();
        } else {
            i14 = 0;
        }
        int i23 = (i22 + i14) * 31;
        Survey survey2 = this.survey;
        if (survey2 != null) {
            i15 = survey2.hashCode();
        } else {
            i15 = 0;
        }
        int i24 = (i23 + i15) * 31;
        String str4 = this.thankyouMessage;
        if (str4 != null) {
            i16 = str4.hashCode();
        } else {
            i16 = 0;
        }
        int i25 = (i24 + i16) * 31;
        String str5 = this.charityLink;
        if (str5 != null) {
            i17 = str5.hashCode();
        } else {
            i17 = 0;
        }
        int i26 = (i25 + i17) * 31;
        ThankyouCampaign thankyouCampaign = this.camp;
        if (thankyouCampaign != null) {
            i18 = thankyouCampaign.hashCode();
        }
        return ((i26 + i18) * 31) + (this.isRealAcquisition ? 1 : 0);
    }

    public boolean isCharityMessageAvailable() {
        return !TalabatUtils.isNullOrEmpty(this.charityMessage);
    }

    public boolean isFirstOrderMessageAvailable() {
        return !TalabatUtils.isNullOrEmpty(this.firstOrderMessage);
    }

    public boolean isPrayerTimeMessageAvailable() {
        return !TalabatUtils.isNullOrEmpty(this.prayerTimeMessage);
    }

    public boolean isSurveyAvailable() {
        return this.survey != null;
    }

    public String toString() {
        return "TTransactionResponse{orderId=" + this.orderId + ", tOrderResponses=" + Arrays.toString(this.tOrderResponses) + ", deliveryAddress=" + this.deliveryAddress + ", firstOrderMessage='" + this.firstOrderMessage + '\'' + ", prayerTimeMessage='" + this.prayerTimeMessage + '\'' + ", charityMessage='" + this.charityMessage + '\'' + ", survey=" + this.survey + ", thankyouMessage='" + this.thankyouMessage + '\'' + ", charityLink='" + this.charityLink + '\'' + ", camp=" + this.camp + ", isRealAcquisition=" + this.isRealAcquisition + AbstractJsonLexerKt.END_OBJ;
    }
}
