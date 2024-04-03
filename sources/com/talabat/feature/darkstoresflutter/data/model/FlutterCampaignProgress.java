package com.talabat.feature.darkstoresflutter.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\"\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\n\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000f¨\u0006)"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgress;", "", "icon", "", "message", "progressValue", "", "showForSeconds", "", "state", "isTPro", "", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage", "getProgressValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getShowForSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSource", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgress;", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCampaignProgress {
    @Nullable
    private final String icon;
    @Nullable
    private final Boolean isTPro;
    @Nullable
    private final String message;
    @Nullable
    private final Float progressValue;
    @Nullable
    private final Long showForSeconds;
    @Nullable
    private final String source;
    @Nullable
    private final String state;

    public FlutterCampaignProgress() {
        this((String) null, (String) null, (Float) null, (Long) null, (String) null, (Boolean) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public FlutterCampaignProgress(@Nullable @Json(name = "icon") String str, @Nullable @Json(name = "message") String str2, @Nullable @Json(name = "progress") Float f11, @Nullable @Json(name = "showForSeconds") Long l11, @Nullable @Json(name = "state") String str3, @Nullable @Json(name = "isTPro") Boolean bool, @Nullable @Json(name = "source") String str4) {
        this.icon = str;
        this.message = str2;
        this.progressValue = f11;
        this.showForSeconds = l11;
        this.state = str3;
        this.isTPro = bool;
        this.source = str4;
    }

    public static /* synthetic */ FlutterCampaignProgress copy$default(FlutterCampaignProgress flutterCampaignProgress, String str, String str2, Float f11, Long l11, String str3, Boolean bool, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = flutterCampaignProgress.icon;
        }
        if ((i11 & 2) != 0) {
            str2 = flutterCampaignProgress.message;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            f11 = flutterCampaignProgress.progressValue;
        }
        Float f12 = f11;
        if ((i11 & 8) != 0) {
            l11 = flutterCampaignProgress.showForSeconds;
        }
        Long l12 = l11;
        if ((i11 & 16) != 0) {
            str3 = flutterCampaignProgress.state;
        }
        String str6 = str3;
        if ((i11 & 32) != 0) {
            bool = flutterCampaignProgress.isTPro;
        }
        Boolean bool2 = bool;
        if ((i11 & 64) != 0) {
            str4 = flutterCampaignProgress.source;
        }
        return flutterCampaignProgress.copy(str, str5, f12, l12, str6, bool2, str4);
    }

    @Nullable
    public final String component1() {
        return this.icon;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final Float component3() {
        return this.progressValue;
    }

    @Nullable
    public final Long component4() {
        return this.showForSeconds;
    }

    @Nullable
    public final String component5() {
        return this.state;
    }

    @Nullable
    public final Boolean component6() {
        return this.isTPro;
    }

    @Nullable
    public final String component7() {
        return this.source;
    }

    @NotNull
    public final FlutterCampaignProgress copy(@Nullable @Json(name = "icon") String str, @Nullable @Json(name = "message") String str2, @Nullable @Json(name = "progress") Float f11, @Nullable @Json(name = "showForSeconds") Long l11, @Nullable @Json(name = "state") String str3, @Nullable @Json(name = "isTPro") Boolean bool, @Nullable @Json(name = "source") String str4) {
        return new FlutterCampaignProgress(str, str2, f11, l11, str3, bool, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterCampaignProgress)) {
            return false;
        }
        FlutterCampaignProgress flutterCampaignProgress = (FlutterCampaignProgress) obj;
        return Intrinsics.areEqual((Object) this.icon, (Object) flutterCampaignProgress.icon) && Intrinsics.areEqual((Object) this.message, (Object) flutterCampaignProgress.message) && Intrinsics.areEqual((Object) this.progressValue, (Object) flutterCampaignProgress.progressValue) && Intrinsics.areEqual((Object) this.showForSeconds, (Object) flutterCampaignProgress.showForSeconds) && Intrinsics.areEqual((Object) this.state, (Object) flutterCampaignProgress.state) && Intrinsics.areEqual((Object) this.isTPro, (Object) flutterCampaignProgress.isTPro) && Intrinsics.areEqual((Object) this.source, (Object) flutterCampaignProgress.source);
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Float getProgressValue() {
        return this.progressValue;
    }

    @Nullable
    public final Long getShowForSeconds() {
        return this.showForSeconds;
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        String str = this.icon;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f11 = this.progressValue;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Long l11 = this.showForSeconds;
        int hashCode4 = (hashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str3 = this.state;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isTPro;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.source;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode6 + i11;
    }

    @Nullable
    public final Boolean isTPro() {
        return this.isTPro;
    }

    @NotNull
    public String toString() {
        String str = this.icon;
        String str2 = this.message;
        Float f11 = this.progressValue;
        Long l11 = this.showForSeconds;
        String str3 = this.state;
        Boolean bool = this.isTPro;
        String str4 = this.source;
        return "FlutterCampaignProgress(icon=" + str + ", message=" + str2 + ", progressValue=" + f11 + ", showForSeconds=" + l11 + ", state=" + str3 + ", isTPro=" + bool + ", source=" + str4 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FlutterCampaignProgress(java.lang.String r7, java.lang.String r8, java.lang.Float r9, java.lang.Long r10, java.lang.String r11, java.lang.Boolean r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstoresflutter.data.model.FlutterCampaignProgress.<init>(java.lang.String, java.lang.String, java.lang.Float, java.lang.Long, java.lang.String, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
