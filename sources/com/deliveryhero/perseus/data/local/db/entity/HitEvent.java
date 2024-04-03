package com.deliveryhero.perseus.data.local.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 D2\u00020\u0001:\u0001DB\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003JÁ\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0006HÆ\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\t\u0010C\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006E"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "", "id", "", "timestamp", "payloadTimeStamp", "", "country", "advertisingId", "appId", "appName", "appVersionCode", "adjustId", "userId", "uaId", "clientId", "sessionId", "sdkVersionName", "globalEntityId", "consent", "sessionOffset", "eventVariables", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getAdjustId", "()Ljava/lang/String;", "getAdvertisingId", "getAppId", "getAppName", "getAppVersionCode", "getClientId", "getConsent", "getCountry", "getEventVariables", "getGlobalEntityId", "getId", "()J", "getPayloadTimeStamp", "getSdkVersionName", "getSessionId", "getSessionOffset", "getTimestamp", "getUaId", "getUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Entity(tableName = "tracking_perseus_events")
public final class HitEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TABLE_NAME = "tracking_perseus_events";
    @NotNull
    private final String adjustId;
    @NotNull
    private final String advertisingId;
    @NotNull
    private final String appId;
    @NotNull
    private final String appName;
    @NotNull
    private final String appVersionCode;
    @NotNull
    private final String clientId;
    @Nullable
    private final String consent;
    @NotNull
    private final String country;
    @NotNull
    private final String eventVariables;
    @Nullable
    private final String globalEntityId;
    @PrimaryKey(autoGenerate = true)

    /* renamed from: id  reason: collision with root package name */
    private final long f30397id;
    @NotNull
    private final String payloadTimeStamp;
    @NotNull
    private final String sdkVersionName;
    @NotNull
    private final String sessionId;
    private final long sessionOffset;
    private final long timestamp;
    @NotNull
    private final String uaId;
    @NotNull
    private final String userId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent$Companion;", "", "()V", "TABLE_NAME", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HitEvent(long j11, long j12, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @Nullable String str13, @Nullable String str14, long j13, @NotNull String str15) {
        String str16 = str;
        String str17 = str2;
        String str18 = str3;
        String str19 = str4;
        String str20 = str5;
        String str21 = str6;
        String str22 = str7;
        String str23 = str8;
        String str24 = str9;
        String str25 = str10;
        String str26 = str11;
        String str27 = str12;
        String str28 = str15;
        Intrinsics.checkNotNullParameter(str16, "payloadTimeStamp");
        Intrinsics.checkNotNullParameter(str17, "country");
        Intrinsics.checkNotNullParameter(str18, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str19, "appId");
        Intrinsics.checkNotNullParameter(str20, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str21, "appVersionCode");
        Intrinsics.checkNotNullParameter(str22, "adjustId");
        Intrinsics.checkNotNullParameter(str23, "userId");
        Intrinsics.checkNotNullParameter(str24, "uaId");
        Intrinsics.checkNotNullParameter(str25, Profile.CLIENT_ID);
        Intrinsics.checkNotNullParameter(str26, "sessionId");
        Intrinsics.checkNotNullParameter(str27, "sdkVersionName");
        Intrinsics.checkNotNullParameter(str28, "eventVariables");
        this.f30397id = j11;
        this.timestamp = j12;
        this.payloadTimeStamp = str16;
        this.country = str17;
        this.advertisingId = str18;
        this.appId = str19;
        this.appName = str20;
        this.appVersionCode = str21;
        this.adjustId = str22;
        this.userId = str23;
        this.uaId = str24;
        this.clientId = str25;
        this.sessionId = str26;
        this.sdkVersionName = str27;
        this.globalEntityId = str13;
        this.consent = str14;
        this.sessionOffset = j13;
        this.eventVariables = str28;
    }

    public static /* synthetic */ HitEvent copy$default(HitEvent hitEvent, long j11, long j12, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, long j13, String str15, int i11, Object obj) {
        HitEvent hitEvent2 = hitEvent;
        int i12 = i11;
        return hitEvent.copy((i12 & 1) != 0 ? hitEvent2.f30397id : j11, (i12 & 2) != 0 ? hitEvent2.timestamp : j12, (i12 & 4) != 0 ? hitEvent2.payloadTimeStamp : str, (i12 & 8) != 0 ? hitEvent2.country : str2, (i12 & 16) != 0 ? hitEvent2.advertisingId : str3, (i12 & 32) != 0 ? hitEvent2.appId : str4, (i12 & 64) != 0 ? hitEvent2.appName : str5, (i12 & 128) != 0 ? hitEvent2.appVersionCode : str6, (i12 & 256) != 0 ? hitEvent2.adjustId : str7, (i12 & 512) != 0 ? hitEvent2.userId : str8, (i12 & 1024) != 0 ? hitEvent2.uaId : str9, (i12 & 2048) != 0 ? hitEvent2.clientId : str10, (i12 & 4096) != 0 ? hitEvent2.sessionId : str11, (i12 & 8192) != 0 ? hitEvent2.sdkVersionName : str12, (i12 & 16384) != 0 ? hitEvent2.globalEntityId : str13, (i12 & 32768) != 0 ? hitEvent2.consent : str14, (i12 & 65536) != 0 ? hitEvent2.sessionOffset : j13, (i12 & 131072) != 0 ? hitEvent2.eventVariables : str15);
    }

    public final long component1() {
        return this.f30397id;
    }

    @NotNull
    public final String component10() {
        return this.userId;
    }

    @NotNull
    public final String component11() {
        return this.uaId;
    }

    @NotNull
    public final String component12() {
        return this.clientId;
    }

    @NotNull
    public final String component13() {
        return this.sessionId;
    }

    @NotNull
    public final String component14() {
        return this.sdkVersionName;
    }

    @Nullable
    public final String component15() {
        return this.globalEntityId;
    }

    @Nullable
    public final String component16() {
        return this.consent;
    }

    public final long component17() {
        return this.sessionOffset;
    }

    @NotNull
    public final String component18() {
        return this.eventVariables;
    }

    public final long component2() {
        return this.timestamp;
    }

    @NotNull
    public final String component3() {
        return this.payloadTimeStamp;
    }

    @NotNull
    public final String component4() {
        return this.country;
    }

    @NotNull
    public final String component5() {
        return this.advertisingId;
    }

    @NotNull
    public final String component6() {
        return this.appId;
    }

    @NotNull
    public final String component7() {
        return this.appName;
    }

    @NotNull
    public final String component8() {
        return this.appVersionCode;
    }

    @NotNull
    public final String component9() {
        return this.adjustId;
    }

    @NotNull
    public final HitEvent copy(long j11, long j12, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @Nullable String str13, @Nullable String str14, long j13, @NotNull String str15) {
        long j14 = j11;
        Intrinsics.checkNotNullParameter(str, "payloadTimeStamp");
        Intrinsics.checkNotNullParameter(str2, "country");
        Intrinsics.checkNotNullParameter(str3, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str4, "appId");
        Intrinsics.checkNotNullParameter(str5, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str6, "appVersionCode");
        Intrinsics.checkNotNullParameter(str7, "adjustId");
        Intrinsics.checkNotNullParameter(str8, "userId");
        Intrinsics.checkNotNullParameter(str9, "uaId");
        Intrinsics.checkNotNullParameter(str10, Profile.CLIENT_ID);
        Intrinsics.checkNotNullParameter(str11, "sessionId");
        Intrinsics.checkNotNullParameter(str12, "sdkVersionName");
        Intrinsics.checkNotNullParameter(str15, "eventVariables");
        return new HitEvent(j11, j12, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, j13, str15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HitEvent)) {
            return false;
        }
        HitEvent hitEvent = (HitEvent) obj;
        return this.f30397id == hitEvent.f30397id && this.timestamp == hitEvent.timestamp && Intrinsics.areEqual((Object) this.payloadTimeStamp, (Object) hitEvent.payloadTimeStamp) && Intrinsics.areEqual((Object) this.country, (Object) hitEvent.country) && Intrinsics.areEqual((Object) this.advertisingId, (Object) hitEvent.advertisingId) && Intrinsics.areEqual((Object) this.appId, (Object) hitEvent.appId) && Intrinsics.areEqual((Object) this.appName, (Object) hitEvent.appName) && Intrinsics.areEqual((Object) this.appVersionCode, (Object) hitEvent.appVersionCode) && Intrinsics.areEqual((Object) this.adjustId, (Object) hitEvent.adjustId) && Intrinsics.areEqual((Object) this.userId, (Object) hitEvent.userId) && Intrinsics.areEqual((Object) this.uaId, (Object) hitEvent.uaId) && Intrinsics.areEqual((Object) this.clientId, (Object) hitEvent.clientId) && Intrinsics.areEqual((Object) this.sessionId, (Object) hitEvent.sessionId) && Intrinsics.areEqual((Object) this.sdkVersionName, (Object) hitEvent.sdkVersionName) && Intrinsics.areEqual((Object) this.globalEntityId, (Object) hitEvent.globalEntityId) && Intrinsics.areEqual((Object) this.consent, (Object) hitEvent.consent) && this.sessionOffset == hitEvent.sessionOffset && Intrinsics.areEqual((Object) this.eventVariables, (Object) hitEvent.eventVariables);
    }

    @NotNull
    public final String getAdjustId() {
        return this.adjustId;
    }

    @NotNull
    public final String getAdvertisingId() {
        return this.advertisingId;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    public final String getAppVersionCode() {
        return this.appVersionCode;
    }

    @NotNull
    public final String getClientId() {
        return this.clientId;
    }

    @Nullable
    public final String getConsent() {
        return this.consent;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getEventVariables() {
        return this.eventVariables;
    }

    @Nullable
    public final String getGlobalEntityId() {
        return this.globalEntityId;
    }

    public final long getId() {
        return this.f30397id;
    }

    @NotNull
    public final String getPayloadTimeStamp() {
        return this.payloadTimeStamp;
    }

    @NotNull
    public final String getSdkVersionName() {
        return this.sdkVersionName;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getSessionOffset() {
        return this.sessionOffset;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String getUaId() {
        return this.uaId;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int a11 = ((((((((((((((((((((((((((a.a(this.f30397id) * 31) + a.a(this.timestamp)) * 31) + this.payloadTimeStamp.hashCode()) * 31) + this.country.hashCode()) * 31) + this.advertisingId.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.appVersionCode.hashCode()) * 31) + this.adjustId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.uaId.hashCode()) * 31) + this.clientId.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.sdkVersionName.hashCode()) * 31;
        String str = this.globalEntityId;
        int i11 = 0;
        int hashCode = (a11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.consent;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return ((((hashCode + i11) * 31) + a.a(this.sessionOffset)) * 31) + this.eventVariables.hashCode();
    }

    @NotNull
    public String toString() {
        return "HitEvent(id=" + this.f30397id + ", timestamp=" + this.timestamp + ", payloadTimeStamp=" + this.payloadTimeStamp + ", country=" + this.country + ", advertisingId=" + this.advertisingId + ", appId=" + this.appId + ", appName=" + this.appName + ", appVersionCode=" + this.appVersionCode + ", adjustId=" + this.adjustId + ", userId=" + this.userId + ", uaId=" + this.uaId + ", clientId=" + this.clientId + ", sessionId=" + this.sessionId + ", sdkVersionName=" + this.sdkVersionName + ", globalEntityId=" + this.globalEntityId + ", consent=" + this.consent + ", sessionOffset=" + this.sessionOffset + ", eventVariables=" + this.eventVariables + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HitEvent(long j11, long j12, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, long j13, String str15, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : j11, j12, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, (i11 & 65536) != 0 ? 0 : j13, str15);
    }
}
