package com.talabat.gem.adapters.analytics;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\b\b\u0018\u0000 )2\u00020\u0001:\u0001)Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÂ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÂ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÂ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÂ\u0003Jv\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130'H\u0016J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006*"}, d2 = {"Lcom/talabat/gem/adapters/analytics/GemApiCallEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "apiRequestUrl", "", "status", "offerId", "offerCount", "", "tierCount", "reservationCode", "responseCode", "message", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Integer;", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "()Ljava/lang/Integer;", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/gem/adapters/analytics/GemApiCallEvent;", "equals", "", "other", "featureName", "hashCode", "name", "platforms", "", "toString", "Companion", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemApiCallEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "gem_api_call";
    @NotNull
    public static final String FEATURE_NAME = "Android_AdsExpo_Events";
    @NotNull
    private final String apiRequestUrl;
    @Nullable
    private final String message;
    @Nullable
    private final Integer offerCount;
    @Nullable
    private final String offerId;
    @Nullable
    private final String reservationCode;
    @Nullable
    private final Integer responseCode;
    @Nullable
    private final String source;
    @NotNull
    private final String status;
    @Nullable
    private final Integer tierCount;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/gem/adapters/analytics/GemApiCallEvent$Companion;", "", "()V", "EVENT_NAME", "", "FEATURE_NAME", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GemApiCallEvent(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Integer r17, java.lang.Integer r18, java.lang.String r19, java.lang.Integer r20, java.lang.String r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r16
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0011
            r7 = r2
            goto L_0x0013
        L_0x0011:
            r7 = r17
        L_0x0013:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0019
            r8 = r2
            goto L_0x001b
        L_0x0019:
            r8 = r18
        L_0x001b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0021
            r9 = r2
            goto L_0x0023
        L_0x0021:
            r9 = r19
        L_0x0023:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0029
            r10 = r2
            goto L_0x002b
        L_0x0029:
            r10 = r20
        L_0x002b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0031
            r11 = r2
            goto L_0x0033
        L_0x0031:
            r11 = r21
        L_0x0033:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0039
            r12 = r2
            goto L_0x003b
        L_0x0039:
            r12 = r22
        L_0x003b:
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.adapters.analytics.GemApiCallEvent.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final String component1() {
        return this.apiRequestUrl;
    }

    private final String component2() {
        return this.status;
    }

    private final String component3() {
        return this.offerId;
    }

    private final Integer component4() {
        return this.offerCount;
    }

    private final Integer component5() {
        return this.tierCount;
    }

    private final String component6() {
        return this.reservationCode;
    }

    private final Integer component7() {
        return this.responseCode;
    }

    private final String component8() {
        return this.message;
    }

    private final String component9() {
        return this.source;
    }

    public static /* synthetic */ GemApiCallEvent copy$default(GemApiCallEvent gemApiCallEvent, String str, String str2, String str3, Integer num, Integer num2, String str4, Integer num3, String str5, String str6, int i11, Object obj) {
        GemApiCallEvent gemApiCallEvent2 = gemApiCallEvent;
        int i12 = i11;
        return gemApiCallEvent.copy((i12 & 1) != 0 ? gemApiCallEvent2.apiRequestUrl : str, (i12 & 2) != 0 ? gemApiCallEvent2.status : str2, (i12 & 4) != 0 ? gemApiCallEvent2.offerId : str3, (i12 & 8) != 0 ? gemApiCallEvent2.offerCount : num, (i12 & 16) != 0 ? gemApiCallEvent2.tierCount : num2, (i12 & 32) != 0 ? gemApiCallEvent2.reservationCode : str4, (i12 & 64) != 0 ? gemApiCallEvent2.responseCode : num3, (i12 & 128) != 0 ? gemApiCallEvent2.message : str5, (i12 & 256) != 0 ? gemApiCallEvent2.source : str6);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("api_request_url", this.apiRequestUrl);
        linkedHashMap.put("status", this.status);
        String str = this.offerId;
        if (str != null) {
            linkedHashMap.put("offer_id", str);
        }
        Integer num = this.offerCount;
        if (num != null) {
            linkedHashMap.put("offer_count", Integer.valueOf(num.intValue()));
        }
        Integer num2 = this.tierCount;
        if (num2 != null) {
            linkedHashMap.put("tier_count", Integer.valueOf(num2.intValue()));
        }
        String str2 = this.reservationCode;
        if (str2 != null) {
            linkedHashMap.put("reservation_code", str2);
        }
        Integer num3 = this.responseCode;
        if (num3 != null) {
            linkedHashMap.put("api_response_code", Integer.valueOf(num3.intValue()));
        }
        String str3 = this.message;
        if (str3 != null) {
            linkedHashMap.put("api_response_message", str3);
        }
        String str4 = this.source;
        if (str4 != null) {
            linkedHashMap.put("source", str4);
        }
        return linkedHashMap;
    }

    @NotNull
    public final GemApiCallEvent copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Integer num, @Nullable Integer num2, @Nullable String str4, @Nullable Integer num3, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(str, "apiRequestUrl");
        Intrinsics.checkNotNullParameter(str2, "status");
        return new GemApiCallEvent(str, str2, str3, num, num2, str4, num3, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GemApiCallEvent)) {
            return false;
        }
        GemApiCallEvent gemApiCallEvent = (GemApiCallEvent) obj;
        return Intrinsics.areEqual((Object) this.apiRequestUrl, (Object) gemApiCallEvent.apiRequestUrl) && Intrinsics.areEqual((Object) this.status, (Object) gemApiCallEvent.status) && Intrinsics.areEqual((Object) this.offerId, (Object) gemApiCallEvent.offerId) && Intrinsics.areEqual((Object) this.offerCount, (Object) gemApiCallEvent.offerCount) && Intrinsics.areEqual((Object) this.tierCount, (Object) gemApiCallEvent.tierCount) && Intrinsics.areEqual((Object) this.reservationCode, (Object) gemApiCallEvent.reservationCode) && Intrinsics.areEqual((Object) this.responseCode, (Object) gemApiCallEvent.responseCode) && Intrinsics.areEqual((Object) this.message, (Object) gemApiCallEvent.message) && Intrinsics.areEqual((Object) this.source, (Object) gemApiCallEvent.source);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return FEATURE_NAME;
    }

    public int hashCode() {
        int hashCode = ((this.apiRequestUrl.hashCode() * 31) + this.status.hashCode()) * 31;
        String str = this.offerId;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.offerCount;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.tierCount;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.reservationCode;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.responseCode;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.message;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.source;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode7 + i11;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.NEW_RELIC);
    }

    @NotNull
    public String toString() {
        String str = this.apiRequestUrl;
        String str2 = this.status;
        String str3 = this.offerId;
        Integer num = this.offerCount;
        Integer num2 = this.tierCount;
        String str4 = this.reservationCode;
        Integer num3 = this.responseCode;
        String str5 = this.message;
        String str6 = this.source;
        return "GemApiCallEvent(apiRequestUrl=" + str + ", status=" + str2 + ", offerId=" + str3 + ", offerCount=" + num + ", tierCount=" + num2 + ", reservationCode=" + str4 + ", responseCode=" + num3 + ", message=" + str5 + ", source=" + str6 + ")";
    }

    public GemApiCallEvent(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Integer num, @Nullable Integer num2, @Nullable String str4, @Nullable Integer num3, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(str, "apiRequestUrl");
        Intrinsics.checkNotNullParameter(str2, "status");
        this.apiRequestUrl = str;
        this.status = str2;
        this.offerId = str3;
        this.offerCount = num;
        this.tierCount = num2;
        this.reservationCode = str4;
        this.responseCode = num3;
        this.message = str5;
        this.source = str6;
    }
}
