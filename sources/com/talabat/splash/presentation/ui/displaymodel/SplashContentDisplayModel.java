package com.talabat.splash.presentation.ui.displaymodel;

import com.talabat.splash.presentation.ui.SplashPhaseOneViewEntity;
import com.talabat.splash.presentation.ui.displaymodel.Campaign;
import com.talabat.splash.presentation.ui.displaymodel.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/talabat/splash/presentation/ui/displaymodel/SplashContentDisplayModel;", "", "configuration", "Lcom/talabat/splash/presentation/ui/displaymodel/Content;", "campaign", "Lcom/talabat/splash/presentation/ui/displaymodel/Campaign;", "legacy", "Lcom/talabat/splash/presentation/ui/SplashPhaseOneViewEntity;", "(Lcom/talabat/splash/presentation/ui/displaymodel/Content;Lcom/talabat/splash/presentation/ui/displaymodel/Campaign;Lcom/talabat/splash/presentation/ui/SplashPhaseOneViewEntity;)V", "getCampaign", "()Lcom/talabat/splash/presentation/ui/displaymodel/Campaign;", "getConfiguration", "()Lcom/talabat/splash/presentation/ui/displaymodel/Content;", "getLegacy", "()Lcom/talabat/splash/presentation/ui/SplashPhaseOneViewEntity;", "component1", "component2", "component3", "copy", "equals", "", "other", "hasCampaign", "hasDynamicContent", "hashCode", "", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashContentDisplayModel {
    @NotNull
    private final Campaign campaign;
    @NotNull
    private final Content configuration;
    @Nullable
    private final SplashPhaseOneViewEntity legacy;

    public SplashContentDisplayModel(@NotNull Content content, @NotNull Campaign campaign2, @Nullable SplashPhaseOneViewEntity splashPhaseOneViewEntity) {
        Intrinsics.checkNotNullParameter(content, "configuration");
        Intrinsics.checkNotNullParameter(campaign2, "campaign");
        this.configuration = content;
        this.campaign = campaign2;
        this.legacy = splashPhaseOneViewEntity;
    }

    public static /* synthetic */ SplashContentDisplayModel copy$default(SplashContentDisplayModel splashContentDisplayModel, Content content, Campaign campaign2, SplashPhaseOneViewEntity splashPhaseOneViewEntity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            content = splashContentDisplayModel.configuration;
        }
        if ((i11 & 2) != 0) {
            campaign2 = splashContentDisplayModel.campaign;
        }
        if ((i11 & 4) != 0) {
            splashPhaseOneViewEntity = splashContentDisplayModel.legacy;
        }
        return splashContentDisplayModel.copy(content, campaign2, splashPhaseOneViewEntity);
    }

    @NotNull
    public final Content component1() {
        return this.configuration;
    }

    @NotNull
    public final Campaign component2() {
        return this.campaign;
    }

    @Nullable
    public final SplashPhaseOneViewEntity component3() {
        return this.legacy;
    }

    @NotNull
    public final SplashContentDisplayModel copy(@NotNull Content content, @NotNull Campaign campaign2, @Nullable SplashPhaseOneViewEntity splashPhaseOneViewEntity) {
        Intrinsics.checkNotNullParameter(content, "configuration");
        Intrinsics.checkNotNullParameter(campaign2, "campaign");
        return new SplashContentDisplayModel(content, campaign2, splashPhaseOneViewEntity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplashContentDisplayModel)) {
            return false;
        }
        SplashContentDisplayModel splashContentDisplayModel = (SplashContentDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.configuration, (Object) splashContentDisplayModel.configuration) && Intrinsics.areEqual((Object) this.campaign, (Object) splashContentDisplayModel.campaign) && Intrinsics.areEqual((Object) this.legacy, (Object) splashContentDisplayModel.legacy);
    }

    @NotNull
    public final Campaign getCampaign() {
        return this.campaign;
    }

    @NotNull
    public final Content getConfiguration() {
        return this.configuration;
    }

    @Nullable
    public final SplashPhaseOneViewEntity getLegacy() {
        return this.legacy;
    }

    public final boolean hasCampaign() {
        return this.campaign instanceof Campaign.Available;
    }

    public final boolean hasDynamicContent() {
        return this.configuration instanceof Content.Dynamic;
    }

    public int hashCode() {
        int hashCode = ((this.configuration.hashCode() * 31) + this.campaign.hashCode()) * 31;
        SplashPhaseOneViewEntity splashPhaseOneViewEntity = this.legacy;
        return hashCode + (splashPhaseOneViewEntity == null ? 0 : splashPhaseOneViewEntity.hashCode());
    }

    @NotNull
    public String toString() {
        Content content = this.configuration;
        Campaign campaign2 = this.campaign;
        SplashPhaseOneViewEntity splashPhaseOneViewEntity = this.legacy;
        return "SplashContentDisplayModel(configuration=" + content + ", campaign=" + campaign2 + ", legacy=" + splashPhaseOneViewEntity + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SplashContentDisplayModel(Content content, Campaign campaign2, SplashPhaseOneViewEntity splashPhaseOneViewEntity, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(content, campaign2, (i11 & 4) != 0 ? null : splashPhaseOneViewEntity);
    }
}
