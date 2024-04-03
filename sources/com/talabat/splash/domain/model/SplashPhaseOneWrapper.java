package com.talabat.splash.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003JH\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0004HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0006\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/talabat/splash/domain/model/SplashPhaseOneWrapper;", "", "()V", "viewType", "", "SplashUIType", "isAnimateSplashImage", "", "showCampaignLogo", "campaignType", "Lcom/talabat/splash/domain/model/SplashCampaignType;", "(ILjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/talabat/splash/domain/model/SplashCampaignType;)V", "getSplashUIType", "()Ljava/lang/Integer;", "setSplashUIType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCampaignType", "()Lcom/talabat/splash/domain/model/SplashCampaignType;", "setCampaignType", "(Lcom/talabat/splash/domain/model/SplashCampaignType;)V", "()Ljava/lang/Boolean;", "setAnimateSplashImage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getShowCampaignLogo", "setShowCampaignLogo", "getViewType", "()I", "setViewType", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/talabat/splash/domain/model/SplashCampaignType;)Lcom/talabat/splash/domain/model/SplashPhaseOneWrapper;", "equals", "other", "hashCode", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashPhaseOneWrapper {
    @Nullable
    private Integer SplashUIType;
    @Nullable
    private SplashCampaignType campaignType;
    @Nullable
    private Boolean isAnimateSplashImage;
    @Nullable
    private Boolean showCampaignLogo;
    private int viewType;

    public SplashPhaseOneWrapper(int i11, @Nullable Integer num, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable SplashCampaignType splashCampaignType) {
        this.viewType = i11;
        this.SplashUIType = num;
        this.isAnimateSplashImage = bool;
        this.showCampaignLogo = bool2;
        this.campaignType = splashCampaignType;
    }

    public static /* synthetic */ SplashPhaseOneWrapper copy$default(SplashPhaseOneWrapper splashPhaseOneWrapper, int i11, Integer num, Boolean bool, Boolean bool2, SplashCampaignType splashCampaignType, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = splashPhaseOneWrapper.viewType;
        }
        if ((i12 & 2) != 0) {
            num = splashPhaseOneWrapper.SplashUIType;
        }
        Integer num2 = num;
        if ((i12 & 4) != 0) {
            bool = splashPhaseOneWrapper.isAnimateSplashImage;
        }
        Boolean bool3 = bool;
        if ((i12 & 8) != 0) {
            bool2 = splashPhaseOneWrapper.showCampaignLogo;
        }
        Boolean bool4 = bool2;
        if ((i12 & 16) != 0) {
            splashCampaignType = splashPhaseOneWrapper.campaignType;
        }
        return splashPhaseOneWrapper.copy(i11, num2, bool3, bool4, splashCampaignType);
    }

    public final int component1() {
        return this.viewType;
    }

    @Nullable
    public final Integer component2() {
        return this.SplashUIType;
    }

    @Nullable
    public final Boolean component3() {
        return this.isAnimateSplashImage;
    }

    @Nullable
    public final Boolean component4() {
        return this.showCampaignLogo;
    }

    @Nullable
    public final SplashCampaignType component5() {
        return this.campaignType;
    }

    @NotNull
    public final SplashPhaseOneWrapper copy(int i11, @Nullable Integer num, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable SplashCampaignType splashCampaignType) {
        return new SplashPhaseOneWrapper(i11, num, bool, bool2, splashCampaignType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplashPhaseOneWrapper)) {
            return false;
        }
        SplashPhaseOneWrapper splashPhaseOneWrapper = (SplashPhaseOneWrapper) obj;
        return this.viewType == splashPhaseOneWrapper.viewType && Intrinsics.areEqual((Object) this.SplashUIType, (Object) splashPhaseOneWrapper.SplashUIType) && Intrinsics.areEqual((Object) this.isAnimateSplashImage, (Object) splashPhaseOneWrapper.isAnimateSplashImage) && Intrinsics.areEqual((Object) this.showCampaignLogo, (Object) splashPhaseOneWrapper.showCampaignLogo) && this.campaignType == splashPhaseOneWrapper.campaignType;
    }

    @Nullable
    public final SplashCampaignType getCampaignType() {
        return this.campaignType;
    }

    @Nullable
    public final Boolean getShowCampaignLogo() {
        return this.showCampaignLogo;
    }

    @Nullable
    public final Integer getSplashUIType() {
        return this.SplashUIType;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public int hashCode() {
        int i11 = this.viewType * 31;
        Integer num = this.SplashUIType;
        int i12 = 0;
        int hashCode = (i11 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isAnimateSplashImage;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.showCampaignLogo;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        SplashCampaignType splashCampaignType = this.campaignType;
        if (splashCampaignType != null) {
            i12 = splashCampaignType.hashCode();
        }
        return hashCode3 + i12;
    }

    @Nullable
    public final Boolean isAnimateSplashImage() {
        return this.isAnimateSplashImage;
    }

    public final void setAnimateSplashImage(@Nullable Boolean bool) {
        this.isAnimateSplashImage = bool;
    }

    public final void setCampaignType(@Nullable SplashCampaignType splashCampaignType) {
        this.campaignType = splashCampaignType;
    }

    public final void setShowCampaignLogo(@Nullable Boolean bool) {
        this.showCampaignLogo = bool;
    }

    public final void setSplashUIType(@Nullable Integer num) {
        this.SplashUIType = num;
    }

    public final void setViewType(int i11) {
        this.viewType = i11;
    }

    @NotNull
    public String toString() {
        int i11 = this.viewType;
        Integer num = this.SplashUIType;
        Boolean bool = this.isAnimateSplashImage;
        Boolean bool2 = this.showCampaignLogo;
        SplashCampaignType splashCampaignType = this.campaignType;
        return "SplashPhaseOneWrapper(viewType=" + i11 + ", SplashUIType=" + num + ", isAnimateSplashImage=" + bool + ", showCampaignLogo=" + bool2 + ", campaignType=" + splashCampaignType + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SplashPhaseOneWrapper(int i11, Integer num, Boolean bool, Boolean bool2, SplashCampaignType splashCampaignType, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, num, bool, bool2, (i12 & 16) != 0 ? null : splashCampaignType);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SplashPhaseOneWrapper() {
        /*
            r8 = this;
            r1 = 0
            com.talabat.splash.domain.model.SplashDataUtils r0 = com.talabat.splash.domain.model.SplashDataUtils.INSTANCE
            int r0 = r0.getSPLASH_UI_IMAGE()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r5 = 0
            r6 = 16
            r7 = 0
            r0 = r8
            r3 = r4
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.domain.model.SplashPhaseOneWrapper.<init>():void");
    }
}
