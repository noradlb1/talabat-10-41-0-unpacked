package com.deliveryhero.perseus.data.remote.api.model;

import androidx.annotation.Keep;
import com.deliveryhero.perseus.Consent;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.visa.checkout.Profile;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001Bå\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001e¢\u0006\u0002\u0010\u001fR*\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/api/model/HitDetails;", "Lcom/deliveryhero/perseus/data/remote/api/model/BaseHitDetails;", "platform", "", "payloadTimestamp", "clientSentTimestamp", "country", "advertisingId", "appId", "appName", "appVersionCode", "adjustId", "userAgent", "userId", "uaId", "clientId", "sessionId", "sdkVersion", "globalEntityId", "consent", "Lcom/deliveryhero/perseus/Consent;", "hitNumber", "", "deviceInfo", "operatingSystemVersion", "screenResolution", "marketingName", "deviceModel", "deviceBrand", "eventVariables", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/perseus/Consent;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getEventVariables", "()Ljava/util/Map;", "setEventVariables", "(Ljava/util/Map;)V", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class HitDetails extends BaseHitDetails {
    @SerializedName("eventVariables")
    @NotNull
    private Map<String, String> eventVariables;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HitDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Consent consent, Long l11, String str17, String str18, String str19, String str20, String str21, String str22, Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, (i11 & 32768) != 0 ? null : str16, (i11 & 65536) != 0 ? null : consent, (i11 & 131072) != 0 ? null : l11, str17, str18, str19, str20, str21, str22, map);
    }

    @NotNull
    public final Map<String, String> getEventVariables() {
        return this.eventVariables;
    }

    public final void setEventVariables(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.eventVariables = map;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HitDetails(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @Nullable String str16, @Nullable Consent consent, @Nullable Long l11, @NotNull String str17, @NotNull String str18, @NotNull String str19, @NotNull String str20, @NotNull String str21, @NotNull String str22, @NotNull Map<String, String> map) {
        super(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str16, consent != null ? consent.getStringRepresentation() : null, str15, l11, str17, str18, str19, str20, str21, str22);
        Map<String, String> map2 = map;
        Intrinsics.checkNotNullParameter(str, "platform");
        Intrinsics.checkNotNullParameter(str2, "payloadTimestamp");
        Intrinsics.checkNotNullParameter(str3, "clientSentTimestamp");
        Intrinsics.checkNotNullParameter(str4, "country");
        Intrinsics.checkNotNullParameter(str5, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str6, "appId");
        Intrinsics.checkNotNullParameter(str7, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str8, "appVersionCode");
        Intrinsics.checkNotNullParameter(str9, "adjustId");
        Intrinsics.checkNotNullParameter(str10, "userAgent");
        Intrinsics.checkNotNullParameter(str11, "userId");
        Intrinsics.checkNotNullParameter(str12, "uaId");
        Intrinsics.checkNotNullParameter(str13, Profile.CLIENT_ID);
        Intrinsics.checkNotNullParameter(str14, "sessionId");
        Intrinsics.checkNotNullParameter(str15, RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
        Intrinsics.checkNotNullParameter(str17, "deviceInfo");
        Intrinsics.checkNotNullParameter(str18, "operatingSystemVersion");
        Intrinsics.checkNotNullParameter(str19, "screenResolution");
        Intrinsics.checkNotNullParameter(str20, "marketingName");
        Intrinsics.checkNotNullParameter(str21, AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str22, "deviceBrand");
        Intrinsics.checkNotNullParameter(map2, "eventVariables");
        this.eventVariables = map2;
    }
}
