package com.talabat.darkstores.feature;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.darkstores.data.Environment;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/Darkstores;", "", "()V", "Config", "DarkstoresTrackingData", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Darkstores {
    @NotNull
    public static final Darkstores INSTANCE = new Darkstores();

    @Parcelize
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/feature/Darkstores$DarkstoresTrackingData;", "Landroid/os/Parcelable;", "loadingStartTime", "", "(J)V", "getLoadingStartTime", "()J", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DarkstoresTrackingData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<DarkstoresTrackingData> CREATOR = new Creator();
        private final long loadingStartTime;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DarkstoresTrackingData> {
            @NotNull
            public final DarkstoresTrackingData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DarkstoresTrackingData(parcel.readLong());
            }

            @NotNull
            public final DarkstoresTrackingData[] newArray(int i11) {
                return new DarkstoresTrackingData[i11];
            }
        }

        public DarkstoresTrackingData(long j11) {
            this.loadingStartTime = j11;
        }

        public static /* synthetic */ DarkstoresTrackingData copy$default(DarkstoresTrackingData darkstoresTrackingData, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j11 = darkstoresTrackingData.loadingStartTime;
            }
            return darkstoresTrackingData.copy(j11);
        }

        public final long component1() {
            return this.loadingStartTime;
        }

        @NotNull
        public final DarkstoresTrackingData copy(long j11) {
            return new DarkstoresTrackingData(j11);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DarkstoresTrackingData) && this.loadingStartTime == ((DarkstoresTrackingData) obj).loadingStartTime;
        }

        public final long getLoadingStartTime() {
            return this.loadingStartTime;
        }

        public int hashCode() {
            return a.a(this.loadingStartTime);
        }

        @NotNull
        public String toString() {
            long j11 = this.loadingStartTime;
            return "DarkstoresTrackingData(loadingStartTime=" + j11 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeLong(this.loadingStartTime);
        }
    }

    private Darkstores() {
    }

    @Parcelize
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B±\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u0012HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\rHÆ\u0003J\t\u0010K\u001a\u00020\u000fHÆ\u0003JÓ\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÆ\u0001J\t\u0010M\u001a\u00020\u0012HÖ\u0001J\u0013\u0010N\u001a\u00020\u000f2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0012HÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001J\u0019\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010-R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010-¨\u0006X"}, d2 = {"Lcom/talabat/darkstores/feature/Darkstores$Config;", "Landroid/os/Parcelable;", "restaurantJson", "", "countryCode", "language", "Lcom/talabat/darkstores/feature/main/DarkstoresMainActivity$Language;", "locale", "latitude", "", "longitude", "customerId", "environment", "Lcom/talabat/darkstores/data/Environment;", "shouldClearCart", "", "isFromDeepLink", "deeplinkType", "", "deeplinkInfo", "deeplinkUri", "screenTitle", "currencyCode", "djiniGlobalEntityId", "searchTerm", "eventOrigin", "experimentKey", "darkstoresTrackingData", "Lcom/talabat/darkstores/feature/Darkstores$DarkstoresTrackingData;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/feature/main/DarkstoresMainActivity$Language;Ljava/lang/String;DDLjava/lang/String;Lcom/talabat/darkstores/data/Environment;ZZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/feature/Darkstores$DarkstoresTrackingData;)V", "getCountryCode", "()Ljava/lang/String;", "getCurrencyCode", "getCustomerId", "getDarkstoresTrackingData", "()Lcom/talabat/darkstores/feature/Darkstores$DarkstoresTrackingData;", "getDeeplinkInfo", "getDeeplinkType", "()I", "getDeeplinkUri", "getDjiniGlobalEntityId", "getEnvironment", "()Lcom/talabat/darkstores/data/Environment;", "getEventOrigin", "getExperimentKey", "()Z", "getLanguage", "()Lcom/talabat/darkstores/feature/main/DarkstoresMainActivity$Language;", "getLatitude", "()D", "getLocale", "getLongitude", "getRestaurantJson", "getScreenTitle", "getSearchTerm", "getShouldClearCart", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Config implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<Config> CREATOR = new Creator();
        @NotNull
        private final String countryCode;
        @NotNull
        private final String currencyCode;
        @NotNull
        private final String customerId;
        @Nullable
        private final DarkstoresTrackingData darkstoresTrackingData;
        @NotNull
        private final String deeplinkInfo;
        private final int deeplinkType;
        @NotNull
        private final String deeplinkUri;
        @NotNull
        private final String djiniGlobalEntityId;
        @NotNull
        private final Environment environment;
        @NotNull
        private final String eventOrigin;
        @NotNull
        private final String experimentKey;
        private final boolean isFromDeepLink;
        @NotNull
        private final DarkstoresMainActivity.Language language;
        private final double latitude;
        @NotNull
        private final String locale;
        private final double longitude;
        @NotNull
        private final String restaurantJson;
        @NotNull
        private final String screenTitle;
        @NotNull
        private final String searchTerm;
        private final boolean shouldClearCart;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Config> {
            @NotNull
            public final Config createFromParcel(@NotNull Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                DarkstoresMainActivity.Language valueOf = DarkstoresMainActivity.Language.valueOf(parcel.readString());
                String readString3 = parcel.readString();
                double readDouble = parcel.readDouble();
                double readDouble2 = parcel.readDouble();
                String readString4 = parcel.readString();
                Environment valueOf2 = Environment.valueOf(parcel.readString());
                boolean z11 = false;
                boolean z12 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    z11 = true;
                }
                return new Config(readString, readString2, valueOf, readString3, readDouble, readDouble2, readString4, valueOf2, z12, z11, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : DarkstoresTrackingData.CREATOR.createFromParcel(parcel2));
            }

            @NotNull
            public final Config[] newArray(int i11) {
                return new Config[i11];
            }
        }

        public Config(@NotNull String str, @NotNull String str2, @NotNull DarkstoresMainActivity.Language language2, @NotNull String str3, double d11, double d12, @NotNull String str4, @NotNull Environment environment2, boolean z11, boolean z12, int i11, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @Nullable DarkstoresTrackingData darkstoresTrackingData2) {
            String str13 = str;
            String str14 = str2;
            DarkstoresMainActivity.Language language3 = language2;
            String str15 = str3;
            String str16 = str4;
            Environment environment3 = environment2;
            String str17 = str5;
            String str18 = str6;
            String str19 = str7;
            String str20 = str8;
            String str21 = str9;
            String str22 = str10;
            String str23 = str11;
            String str24 = str12;
            Intrinsics.checkNotNullParameter(str13, "restaurantJson");
            Intrinsics.checkNotNullParameter(str14, "countryCode");
            Intrinsics.checkNotNullParameter(language3, ConstantsKt.ADJUST_LANGUAGE);
            Intrinsics.checkNotNullParameter(str15, "locale");
            Intrinsics.checkNotNullParameter(str16, "customerId");
            Intrinsics.checkNotNullParameter(environment3, Profile.ENVIRONMENT);
            Intrinsics.checkNotNullParameter(str17, "deeplinkInfo");
            Intrinsics.checkNotNullParameter(str18, "deeplinkUri");
            Intrinsics.checkNotNullParameter(str19, "screenTitle");
            Intrinsics.checkNotNullParameter(str20, "currencyCode");
            Intrinsics.checkNotNullParameter(str21, "djiniGlobalEntityId");
            Intrinsics.checkNotNullParameter(str22, "searchTerm");
            Intrinsics.checkNotNullParameter(str23, "eventOrigin");
            Intrinsics.checkNotNullParameter(str24, "experimentKey");
            this.restaurantJson = str13;
            this.countryCode = str14;
            this.language = language3;
            this.locale = str15;
            this.latitude = d11;
            this.longitude = d12;
            this.customerId = str16;
            this.environment = environment3;
            this.shouldClearCart = z11;
            this.isFromDeepLink = z12;
            this.deeplinkType = i11;
            this.deeplinkInfo = str17;
            this.deeplinkUri = str18;
            this.screenTitle = str19;
            this.currencyCode = str20;
            this.djiniGlobalEntityId = str21;
            this.searchTerm = str22;
            this.eventOrigin = str23;
            this.experimentKey = str24;
            this.darkstoresTrackingData = darkstoresTrackingData2;
        }

        public static /* synthetic */ Config copy$default(Config config, String str, String str2, DarkstoresMainActivity.Language language2, String str3, double d11, double d12, String str4, Environment environment2, boolean z11, boolean z12, int i11, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, DarkstoresTrackingData darkstoresTrackingData2, int i12, Object obj) {
            Config config2 = config;
            int i13 = i12;
            return config.copy((i13 & 1) != 0 ? config2.restaurantJson : str, (i13 & 2) != 0 ? config2.countryCode : str2, (i13 & 4) != 0 ? config2.language : language2, (i13 & 8) != 0 ? config2.locale : str3, (i13 & 16) != 0 ? config2.latitude : d11, (i13 & 32) != 0 ? config2.longitude : d12, (i13 & 64) != 0 ? config2.customerId : str4, (i13 & 128) != 0 ? config2.environment : environment2, (i13 & 256) != 0 ? config2.shouldClearCart : z11, (i13 & 512) != 0 ? config2.isFromDeepLink : z12, (i13 & 1024) != 0 ? config2.deeplinkType : i11, (i13 & 2048) != 0 ? config2.deeplinkInfo : str5, (i13 & 4096) != 0 ? config2.deeplinkUri : str6, (i13 & 8192) != 0 ? config2.screenTitle : str7, (i13 & 16384) != 0 ? config2.currencyCode : str8, (i13 & 32768) != 0 ? config2.djiniGlobalEntityId : str9, (i13 & 65536) != 0 ? config2.searchTerm : str10, (i13 & 131072) != 0 ? config2.eventOrigin : str11, (i13 & 262144) != 0 ? config2.experimentKey : str12, (i13 & 524288) != 0 ? config2.darkstoresTrackingData : darkstoresTrackingData2);
        }

        @NotNull
        public final String component1() {
            return this.restaurantJson;
        }

        public final boolean component10() {
            return this.isFromDeepLink;
        }

        public final int component11() {
            return this.deeplinkType;
        }

        @NotNull
        public final String component12() {
            return this.deeplinkInfo;
        }

        @NotNull
        public final String component13() {
            return this.deeplinkUri;
        }

        @NotNull
        public final String component14() {
            return this.screenTitle;
        }

        @NotNull
        public final String component15() {
            return this.currencyCode;
        }

        @NotNull
        public final String component16() {
            return this.djiniGlobalEntityId;
        }

        @NotNull
        public final String component17() {
            return this.searchTerm;
        }

        @NotNull
        public final String component18() {
            return this.eventOrigin;
        }

        @NotNull
        public final String component19() {
            return this.experimentKey;
        }

        @NotNull
        public final String component2() {
            return this.countryCode;
        }

        @Nullable
        public final DarkstoresTrackingData component20() {
            return this.darkstoresTrackingData;
        }

        @NotNull
        public final DarkstoresMainActivity.Language component3() {
            return this.language;
        }

        @NotNull
        public final String component4() {
            return this.locale;
        }

        public final double component5() {
            return this.latitude;
        }

        public final double component6() {
            return this.longitude;
        }

        @NotNull
        public final String component7() {
            return this.customerId;
        }

        @NotNull
        public final Environment component8() {
            return this.environment;
        }

        public final boolean component9() {
            return this.shouldClearCart;
        }

        @NotNull
        public final Config copy(@NotNull String str, @NotNull String str2, @NotNull DarkstoresMainActivity.Language language2, @NotNull String str3, double d11, double d12, @NotNull String str4, @NotNull Environment environment2, boolean z11, boolean z12, int i11, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @Nullable DarkstoresTrackingData darkstoresTrackingData2) {
            String str13 = str;
            Intrinsics.checkNotNullParameter(str13, "restaurantJson");
            Intrinsics.checkNotNullParameter(str2, "countryCode");
            Intrinsics.checkNotNullParameter(language2, ConstantsKt.ADJUST_LANGUAGE);
            Intrinsics.checkNotNullParameter(str3, "locale");
            Intrinsics.checkNotNullParameter(str4, "customerId");
            Intrinsics.checkNotNullParameter(environment2, Profile.ENVIRONMENT);
            Intrinsics.checkNotNullParameter(str5, "deeplinkInfo");
            Intrinsics.checkNotNullParameter(str6, "deeplinkUri");
            Intrinsics.checkNotNullParameter(str7, "screenTitle");
            Intrinsics.checkNotNullParameter(str8, "currencyCode");
            Intrinsics.checkNotNullParameter(str9, "djiniGlobalEntityId");
            Intrinsics.checkNotNullParameter(str10, "searchTerm");
            Intrinsics.checkNotNullParameter(str11, "eventOrigin");
            Intrinsics.checkNotNullParameter(str12, "experimentKey");
            return new Config(str13, str2, language2, str3, d11, d12, str4, environment2, z11, z12, i11, str5, str6, str7, str8, str9, str10, str11, str12, darkstoresTrackingData2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.areEqual((Object) this.restaurantJson, (Object) config.restaurantJson) && Intrinsics.areEqual((Object) this.countryCode, (Object) config.countryCode) && this.language == config.language && Intrinsics.areEqual((Object) this.locale, (Object) config.locale) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(config.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(config.longitude)) && Intrinsics.areEqual((Object) this.customerId, (Object) config.customerId) && this.environment == config.environment && this.shouldClearCart == config.shouldClearCart && this.isFromDeepLink == config.isFromDeepLink && this.deeplinkType == config.deeplinkType && Intrinsics.areEqual((Object) this.deeplinkInfo, (Object) config.deeplinkInfo) && Intrinsics.areEqual((Object) this.deeplinkUri, (Object) config.deeplinkUri) && Intrinsics.areEqual((Object) this.screenTitle, (Object) config.screenTitle) && Intrinsics.areEqual((Object) this.currencyCode, (Object) config.currencyCode) && Intrinsics.areEqual((Object) this.djiniGlobalEntityId, (Object) config.djiniGlobalEntityId) && Intrinsics.areEqual((Object) this.searchTerm, (Object) config.searchTerm) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) config.eventOrigin) && Intrinsics.areEqual((Object) this.experimentKey, (Object) config.experimentKey) && Intrinsics.areEqual((Object) this.darkstoresTrackingData, (Object) config.darkstoresTrackingData);
        }

        @NotNull
        public final String getCountryCode() {
            return this.countryCode;
        }

        @NotNull
        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        @NotNull
        public final String getCustomerId() {
            return this.customerId;
        }

        @Nullable
        public final DarkstoresTrackingData getDarkstoresTrackingData() {
            return this.darkstoresTrackingData;
        }

        @NotNull
        public final String getDeeplinkInfo() {
            return this.deeplinkInfo;
        }

        public final int getDeeplinkType() {
            return this.deeplinkType;
        }

        @NotNull
        public final String getDeeplinkUri() {
            return this.deeplinkUri;
        }

        @NotNull
        public final String getDjiniGlobalEntityId() {
            return this.djiniGlobalEntityId;
        }

        @NotNull
        public final Environment getEnvironment() {
            return this.environment;
        }

        @NotNull
        public final String getEventOrigin() {
            return this.eventOrigin;
        }

        @NotNull
        public final String getExperimentKey() {
            return this.experimentKey;
        }

        @NotNull
        public final DarkstoresMainActivity.Language getLanguage() {
            return this.language;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        @NotNull
        public final String getLocale() {
            return this.locale;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        @NotNull
        public final String getRestaurantJson() {
            return this.restaurantJson;
        }

        @NotNull
        public final String getScreenTitle() {
            return this.screenTitle;
        }

        @NotNull
        public final String getSearchTerm() {
            return this.searchTerm;
        }

        public final boolean getShouldClearCart() {
            return this.shouldClearCart;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((this.restaurantJson.hashCode() * 31) + this.countryCode.hashCode()) * 31) + this.language.hashCode()) * 31) + this.locale.hashCode()) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.customerId.hashCode()) * 31) + this.environment.hashCode()) * 31;
            boolean z11 = this.shouldClearCart;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.isFromDeepLink;
            if (!z13) {
                z12 = z13;
            }
            int hashCode2 = (((((((((((((((((((i11 + (z12 ? 1 : 0)) * 31) + this.deeplinkType) * 31) + this.deeplinkInfo.hashCode()) * 31) + this.deeplinkUri.hashCode()) * 31) + this.screenTitle.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.djiniGlobalEntityId.hashCode()) * 31) + this.searchTerm.hashCode()) * 31) + this.eventOrigin.hashCode()) * 31) + this.experimentKey.hashCode()) * 31;
            DarkstoresTrackingData darkstoresTrackingData2 = this.darkstoresTrackingData;
            return hashCode2 + (darkstoresTrackingData2 == null ? 0 : darkstoresTrackingData2.hashCode());
        }

        public final boolean isFromDeepLink() {
            return this.isFromDeepLink;
        }

        @NotNull
        public String toString() {
            String str = this.restaurantJson;
            String str2 = this.countryCode;
            DarkstoresMainActivity.Language language2 = this.language;
            String str3 = this.locale;
            double d11 = this.latitude;
            double d12 = this.longitude;
            String str4 = this.customerId;
            Environment environment2 = this.environment;
            boolean z11 = this.shouldClearCart;
            boolean z12 = this.isFromDeepLink;
            int i11 = this.deeplinkType;
            String str5 = this.deeplinkInfo;
            String str6 = this.deeplinkUri;
            String str7 = this.screenTitle;
            String str8 = this.currencyCode;
            String str9 = this.djiniGlobalEntityId;
            String str10 = this.searchTerm;
            String str11 = this.eventOrigin;
            String str12 = this.experimentKey;
            DarkstoresTrackingData darkstoresTrackingData2 = this.darkstoresTrackingData;
            return "Config(restaurantJson=" + str + ", countryCode=" + str2 + ", language=" + language2 + ", locale=" + str3 + ", latitude=" + d11 + ", longitude=" + d12 + ", customerId=" + str4 + ", environment=" + environment2 + ", shouldClearCart=" + z11 + ", isFromDeepLink=" + z12 + ", deeplinkType=" + i11 + ", deeplinkInfo=" + str5 + ", deeplinkUri=" + str6 + ", screenTitle=" + str7 + ", currencyCode=" + str8 + ", djiniGlobalEntityId=" + str9 + ", searchTerm=" + str10 + ", eventOrigin=" + str11 + ", experimentKey=" + str12 + ", darkstoresTrackingData=" + darkstoresTrackingData2 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.restaurantJson);
            parcel.writeString(this.countryCode);
            parcel.writeString(this.language.name());
            parcel.writeString(this.locale);
            parcel.writeDouble(this.latitude);
            parcel.writeDouble(this.longitude);
            parcel.writeString(this.customerId);
            parcel.writeString(this.environment.name());
            parcel.writeInt(this.shouldClearCart ? 1 : 0);
            parcel.writeInt(this.isFromDeepLink ? 1 : 0);
            parcel.writeInt(this.deeplinkType);
            parcel.writeString(this.deeplinkInfo);
            parcel.writeString(this.deeplinkUri);
            parcel.writeString(this.screenTitle);
            parcel.writeString(this.currencyCode);
            parcel.writeString(this.djiniGlobalEntityId);
            parcel.writeString(this.searchTerm);
            parcel.writeString(this.eventOrigin);
            parcel.writeString(this.experimentKey);
            DarkstoresTrackingData darkstoresTrackingData2 = this.darkstoresTrackingData;
            if (darkstoresTrackingData2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            darkstoresTrackingData2.writeToParcel(parcel, i11);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Config(java.lang.String r27, java.lang.String r28, com.talabat.darkstores.feature.main.DarkstoresMainActivity.Language r29, java.lang.String r30, double r31, double r33, java.lang.String r35, com.talabat.darkstores.data.Environment r36, boolean r37, boolean r38, int r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, com.talabat.darkstores.feature.Darkstores.DarkstoresTrackingData r48, int r49, kotlin.jvm.internal.DefaultConstructorMarker r50) {
            /*
                r26 = this;
                r0 = r49
                r1 = r0 & 4096(0x1000, float:5.74E-42)
                java.lang.String r2 = ""
                if (r1 == 0) goto L_0x000b
                r18 = r2
                goto L_0x000d
            L_0x000b:
                r18 = r41
            L_0x000d:
                r1 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r1 == 0) goto L_0x0014
                r19 = r2
                goto L_0x0016
            L_0x0014:
                r19 = r42
            L_0x0016:
                r1 = 65536(0x10000, float:9.18355E-41)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x0020
                java.lang.String r1 = "N/A"
                r22 = r1
                goto L_0x0022
            L_0x0020:
                r22 = r45
            L_0x0022:
                r1 = 131072(0x20000, float:1.83671E-40)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x002a
                r23 = r2
                goto L_0x002c
            L_0x002a:
                r23 = r46
            L_0x002c:
                r1 = 262144(0x40000, float:3.67342E-40)
                r0 = r0 & r1
                if (r0 == 0) goto L_0x0034
                r24 = r2
                goto L_0x0036
            L_0x0034:
                r24 = r47
            L_0x0036:
                r3 = r26
                r4 = r27
                r5 = r28
                r6 = r29
                r7 = r30
                r8 = r31
                r10 = r33
                r12 = r35
                r13 = r36
                r14 = r37
                r15 = r38
                r16 = r39
                r17 = r40
                r20 = r43
                r21 = r44
                r25 = r48
                r3.<init>(r4, r5, r6, r7, r8, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.Darkstores.Config.<init>(java.lang.String, java.lang.String, com.talabat.darkstores.feature.main.DarkstoresMainActivity$Language, java.lang.String, double, double, java.lang.String, com.talabat.darkstores.data.Environment, boolean, boolean, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.talabat.darkstores.feature.Darkstores$DarkstoresTrackingData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
