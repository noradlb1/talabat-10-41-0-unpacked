package com.talabat.splash.presentation.ui;

import com.talabat.splash.domain.model.SplashCampaignType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/talabat/splash/presentation/ui/SplashPhaseOneViewEntity;", "", "splashUIType", "", "showCampaignLogo", "", "campaignType", "Lcom/talabat/splash/domain/model/SplashCampaignType;", "(IZLcom/talabat/splash/domain/model/SplashCampaignType;)V", "getCampaignType", "()Lcom/talabat/splash/domain/model/SplashCampaignType;", "setCampaignType", "(Lcom/talabat/splash/domain/model/SplashCampaignType;)V", "getShowCampaignLogo", "()Z", "getSplashUIType", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashPhaseOneViewEntity {
    @Nullable
    private SplashCampaignType campaignType;
    private final boolean showCampaignLogo;
    private final int splashUIType;

    public SplashPhaseOneViewEntity(int i11, boolean z11, @Nullable SplashCampaignType splashCampaignType) {
        this.splashUIType = i11;
        this.showCampaignLogo = z11;
        this.campaignType = splashCampaignType;
    }

    public static /* synthetic */ SplashPhaseOneViewEntity copy$default(SplashPhaseOneViewEntity splashPhaseOneViewEntity, int i11, boolean z11, SplashCampaignType splashCampaignType, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = splashPhaseOneViewEntity.splashUIType;
        }
        if ((i12 & 2) != 0) {
            z11 = splashPhaseOneViewEntity.showCampaignLogo;
        }
        if ((i12 & 4) != 0) {
            splashCampaignType = splashPhaseOneViewEntity.campaignType;
        }
        return splashPhaseOneViewEntity.copy(i11, z11, splashCampaignType);
    }

    public final int component1() {
        return this.splashUIType;
    }

    public final boolean component2() {
        return this.showCampaignLogo;
    }

    @Nullable
    public final SplashCampaignType component3() {
        return this.campaignType;
    }

    @NotNull
    public final SplashPhaseOneViewEntity copy(int i11, boolean z11, @Nullable SplashCampaignType splashCampaignType) {
        return new SplashPhaseOneViewEntity(i11, z11, splashCampaignType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplashPhaseOneViewEntity)) {
            return false;
        }
        SplashPhaseOneViewEntity splashPhaseOneViewEntity = (SplashPhaseOneViewEntity) obj;
        return this.splashUIType == splashPhaseOneViewEntity.splashUIType && this.showCampaignLogo == splashPhaseOneViewEntity.showCampaignLogo && this.campaignType == splashPhaseOneViewEntity.campaignType;
    }

    @Nullable
    public final SplashCampaignType getCampaignType() {
        return this.campaignType;
    }

    public final boolean getShowCampaignLogo() {
        return this.showCampaignLogo;
    }

    public final int getSplashUIType() {
        return this.splashUIType;
    }

    public int hashCode() {
        int i11 = this.splashUIType * 31;
        boolean z11 = this.showCampaignLogo;
        if (z11) {
            z11 = true;
        }
        int i12 = (i11 + (z11 ? 1 : 0)) * 31;
        SplashCampaignType splashCampaignType = this.campaignType;
        return i12 + (splashCampaignType == null ? 0 : splashCampaignType.hashCode());
    }

    public final void setCampaignType(@Nullable SplashCampaignType splashCampaignType) {
        this.campaignType = splashCampaignType;
    }

    @NotNull
    public String toString() {
        int i11 = this.splashUIType;
        boolean z11 = this.showCampaignLogo;
        SplashCampaignType splashCampaignType = this.campaignType;
        return "SplashPhaseOneViewEntity(splashUIType=" + i11 + ", showCampaignLogo=" + z11 + ", campaignType=" + splashCampaignType + ")";
    }
}
