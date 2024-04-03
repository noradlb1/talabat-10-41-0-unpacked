package com.deliveryhero.customerchat.telephony.survey;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006("}, d2 = {"Lcom/deliveryhero/customerchat/telephony/survey/VoipSurveyData;", "Landroid/os/Parcelable;", "callID", "", "userType", "globalEntityID", "orderID", "country", "language", "theme", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCallID", "()Ljava/lang/String;", "getCountry", "getGlobalEntityID", "getLanguage", "getOrderID", "getTheme", "getUserType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "telephony_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class VoipSurveyData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<VoipSurveyData> CREATOR = new Creator();
    @NotNull
    private final String callID;
    @Nullable
    private final String country;
    @NotNull
    private final String globalEntityID;
    @Nullable
    private final String language;
    @Nullable
    private final String orderID;
    @Nullable
    private final String theme;
    @NotNull
    private final String userType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VoipSurveyData> {
        @NotNull
        public final VoipSurveyData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VoipSurveyData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final VoipSurveyData[] newArray(int i11) {
            return new VoipSurveyData[i11];
        }
    }

    public VoipSurveyData(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, DeviceInfoUtil.DeviceProperty.USERTYPE);
        Intrinsics.checkNotNullParameter(str3, "globalEntityID");
        this.callID = str;
        this.userType = str2;
        this.globalEntityID = str3;
        this.orderID = str4;
        this.country = str5;
        this.language = str6;
        this.theme = str7;
    }

    public static /* synthetic */ VoipSurveyData copy$default(VoipSurveyData voipSurveyData, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = voipSurveyData.callID;
        }
        if ((i11 & 2) != 0) {
            str2 = voipSurveyData.userType;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = voipSurveyData.globalEntityID;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = voipSurveyData.orderID;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = voipSurveyData.country;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = voipSurveyData.language;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = voipSurveyData.theme;
        }
        return voipSurveyData.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    public final String component1() {
        return this.callID;
    }

    @NotNull
    public final String component2() {
        return this.userType;
    }

    @NotNull
    public final String component3() {
        return this.globalEntityID;
    }

    @Nullable
    public final String component4() {
        return this.orderID;
    }

    @Nullable
    public final String component5() {
        return this.country;
    }

    @Nullable
    public final String component6() {
        return this.language;
    }

    @Nullable
    public final String component7() {
        return this.theme;
    }

    @NotNull
    public final VoipSurveyData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, DeviceInfoUtil.DeviceProperty.USERTYPE);
        Intrinsics.checkNotNullParameter(str3, "globalEntityID");
        return new VoipSurveyData(str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoipSurveyData)) {
            return false;
        }
        VoipSurveyData voipSurveyData = (VoipSurveyData) obj;
        return Intrinsics.areEqual((Object) this.callID, (Object) voipSurveyData.callID) && Intrinsics.areEqual((Object) this.userType, (Object) voipSurveyData.userType) && Intrinsics.areEqual((Object) this.globalEntityID, (Object) voipSurveyData.globalEntityID) && Intrinsics.areEqual((Object) this.orderID, (Object) voipSurveyData.orderID) && Intrinsics.areEqual((Object) this.country, (Object) voipSurveyData.country) && Intrinsics.areEqual((Object) this.language, (Object) voipSurveyData.language) && Intrinsics.areEqual((Object) this.theme, (Object) voipSurveyData.theme);
    }

    @NotNull
    public final String getCallID() {
        return this.callID;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getGlobalEntityID() {
        return this.globalEntityID;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getOrderID() {
        return this.orderID;
    }

    @Nullable
    public final String getTheme() {
        return this.theme;
    }

    @NotNull
    public final String getUserType() {
        return this.userType;
    }

    public int hashCode() {
        int hashCode = ((((this.callID.hashCode() * 31) + this.userType.hashCode()) * 31) + this.globalEntityID.hashCode()) * 31;
        String str = this.orderID;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.country;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.language;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.theme;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        return "VoipSurveyData(callID=" + this.callID + ", userType=" + this.userType + ", globalEntityID=" + this.globalEntityID + ", orderID=" + this.orderID + ", country=" + this.country + ", language=" + this.language + ", theme=" + this.theme + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.callID);
        parcel.writeString(this.userType);
        parcel.writeString(this.globalEntityID);
        parcel.writeString(this.orderID);
        parcel.writeString(this.country);
        parcel.writeString(this.language);
        parcel.writeString(this.theme);
    }
}
