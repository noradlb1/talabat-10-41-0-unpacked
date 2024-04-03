package com.talabat.feature.rewards.domain.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jn\u0010*\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0017\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/talabat/feature/rewards/domain/model/Mission;", "", "id", "", "statusId", "name", "", "phase", "widget", "Lcom/talabat/feature/rewards/domain/model/MissionWidget;", "details", "Lcom/talabat/feature/rewards/domain/model/MissionDetails;", "progress", "Lcom/talabat/feature/rewards/domain/model/MissionProgress;", "scope", "Lcom/talabat/feature/rewards/domain/model/MissionScope;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/rewards/domain/model/MissionWidget;Lcom/talabat/feature/rewards/domain/model/MissionDetails;Lcom/talabat/feature/rewards/domain/model/MissionProgress;Lcom/talabat/feature/rewards/domain/model/MissionScope;)V", "getDetails", "()Lcom/talabat/feature/rewards/domain/model/MissionDetails;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getPhase", "setPhase", "(Ljava/lang/String;)V", "getProgress", "()Lcom/talabat/feature/rewards/domain/model/MissionProgress;", "getScope", "()Lcom/talabat/feature/rewards/domain/model/MissionScope;", "getStatusId", "getWidget", "()Lcom/talabat/feature/rewards/domain/model/MissionWidget;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/rewards/domain/model/MissionWidget;Lcom/talabat/feature/rewards/domain/model/MissionDetails;Lcom/talabat/feature/rewards/domain/model/MissionProgress;Lcom/talabat/feature/rewards/domain/model/MissionScope;)Lcom/talabat/feature/rewards/domain/model/Mission;", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Mission {
    @Nullable
    private final MissionDetails details;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f58752id;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58753name;
    @Nullable
    private String phase;
    @Nullable
    private final MissionProgress progress;
    @Nullable
    private final MissionScope scope;
    @Nullable
    private final Integer statusId;
    @Nullable
    private final MissionWidget widget;

    public Mission() {
        this((Integer) null, (Integer) null, (String) null, (String) null, (MissionWidget) null, (MissionDetails) null, (MissionProgress) null, (MissionScope) null, 255, (DefaultConstructorMarker) null);
    }

    public Mission(@Nullable @Json(name = "id") Integer num, @Nullable @Json(name = "statusId") Integer num2, @Nullable @Json(name = "name") String str, @Nullable @Json(name = "phase") String str2, @Nullable @Json(name = "widget") MissionWidget missionWidget, @Nullable @Json(name = "details") MissionDetails missionDetails, @Nullable @Json(name = "progress") MissionProgress missionProgress, @Nullable @Json(name = "scope") MissionScope missionScope) {
        this.f58752id = num;
        this.statusId = num2;
        this.f58753name = str;
        this.phase = str2;
        this.widget = missionWidget;
        this.details = missionDetails;
        this.progress = missionProgress;
        this.scope = missionScope;
    }

    public static /* synthetic */ Mission copy$default(Mission mission, Integer num, Integer num2, String str, String str2, MissionWidget missionWidget, MissionDetails missionDetails, MissionProgress missionProgress, MissionScope missionScope, int i11, Object obj) {
        Mission mission2 = mission;
        int i12 = i11;
        return mission.copy((i12 & 1) != 0 ? mission2.f58752id : num, (i12 & 2) != 0 ? mission2.statusId : num2, (i12 & 4) != 0 ? mission2.f58753name : str, (i12 & 8) != 0 ? mission2.phase : str2, (i12 & 16) != 0 ? mission2.widget : missionWidget, (i12 & 32) != 0 ? mission2.details : missionDetails, (i12 & 64) != 0 ? mission2.progress : missionProgress, (i12 & 128) != 0 ? mission2.scope : missionScope);
    }

    @Nullable
    public final Integer component1() {
        return this.f58752id;
    }

    @Nullable
    public final Integer component2() {
        return this.statusId;
    }

    @Nullable
    public final String component3() {
        return this.f58753name;
    }

    @Nullable
    public final String component4() {
        return this.phase;
    }

    @Nullable
    public final MissionWidget component5() {
        return this.widget;
    }

    @Nullable
    public final MissionDetails component6() {
        return this.details;
    }

    @Nullable
    public final MissionProgress component7() {
        return this.progress;
    }

    @Nullable
    public final MissionScope component8() {
        return this.scope;
    }

    @NotNull
    public final Mission copy(@Nullable @Json(name = "id") Integer num, @Nullable @Json(name = "statusId") Integer num2, @Nullable @Json(name = "name") String str, @Nullable @Json(name = "phase") String str2, @Nullable @Json(name = "widget") MissionWidget missionWidget, @Nullable @Json(name = "details") MissionDetails missionDetails, @Nullable @Json(name = "progress") MissionProgress missionProgress, @Nullable @Json(name = "scope") MissionScope missionScope) {
        return new Mission(num, num2, str, str2, missionWidget, missionDetails, missionProgress, missionScope);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mission)) {
            return false;
        }
        Mission mission = (Mission) obj;
        return Intrinsics.areEqual((Object) this.f58752id, (Object) mission.f58752id) && Intrinsics.areEqual((Object) this.statusId, (Object) mission.statusId) && Intrinsics.areEqual((Object) this.f58753name, (Object) mission.f58753name) && Intrinsics.areEqual((Object) this.phase, (Object) mission.phase) && Intrinsics.areEqual((Object) this.widget, (Object) mission.widget) && Intrinsics.areEqual((Object) this.details, (Object) mission.details) && Intrinsics.areEqual((Object) this.progress, (Object) mission.progress) && Intrinsics.areEqual((Object) this.scope, (Object) mission.scope);
    }

    @Nullable
    public final MissionDetails getDetails() {
        return this.details;
    }

    @Nullable
    public final Integer getId() {
        return this.f58752id;
    }

    @Nullable
    public final String getName() {
        return this.f58753name;
    }

    @Nullable
    public final String getPhase() {
        return this.phase;
    }

    @Nullable
    public final MissionProgress getProgress() {
        return this.progress;
    }

    @Nullable
    public final MissionScope getScope() {
        return this.scope;
    }

    @Nullable
    public final Integer getStatusId() {
        return this.statusId;
    }

    @Nullable
    public final MissionWidget getWidget() {
        return this.widget;
    }

    public int hashCode() {
        Integer num = this.f58752id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.statusId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.f58753name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.phase;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MissionWidget missionWidget = this.widget;
        int hashCode5 = (hashCode4 + (missionWidget == null ? 0 : missionWidget.hashCode())) * 31;
        MissionDetails missionDetails = this.details;
        int hashCode6 = (hashCode5 + (missionDetails == null ? 0 : missionDetails.hashCode())) * 31;
        MissionProgress missionProgress = this.progress;
        int hashCode7 = (hashCode6 + (missionProgress == null ? 0 : missionProgress.hashCode())) * 31;
        MissionScope missionScope = this.scope;
        if (missionScope != null) {
            i11 = missionScope.hashCode();
        }
        return hashCode7 + i11;
    }

    public final void setPhase(@Nullable String str) {
        this.phase = str;
    }

    @NotNull
    public String toString() {
        Integer num = this.f58752id;
        Integer num2 = this.statusId;
        String str = this.f58753name;
        String str2 = this.phase;
        MissionWidget missionWidget = this.widget;
        MissionDetails missionDetails = this.details;
        MissionProgress missionProgress = this.progress;
        MissionScope missionScope = this.scope;
        return "Mission(id=" + num + ", statusId=" + num2 + ", name=" + str + ", phase=" + str2 + ", widget=" + missionWidget + ", details=" + missionDetails + ", progress=" + missionProgress + ", scope=" + missionScope + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Mission(java.lang.Integer r10, java.lang.Integer r11, java.lang.String r12, java.lang.String r13, com.talabat.feature.rewards.domain.model.MissionWidget r14, com.talabat.feature.rewards.domain.model.MissionDetails r15, com.talabat.feature.rewards.domain.model.MissionProgress r16, com.talabat.feature.rewards.domain.model.MissionScope r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.domain.model.Mission.<init>(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, com.talabat.feature.rewards.domain.model.MissionWidget, com.talabat.feature.rewards.domain.model.MissionDetails, com.talabat.feature.rewards.domain.model.MissionProgress, com.talabat.feature.rewards.domain.model.MissionScope, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
