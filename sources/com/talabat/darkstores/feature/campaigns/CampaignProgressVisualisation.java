package com.talabat.darkstores.feature.campaigns;

import com.talabat.darkstores.data.grocery.model.CampaignProgress;
import com.talabat.darkstores.data.grocery.model.CampaignProgressResponse;
import com.talabat.darkstores.feature.campaigns.CampaignProgressState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressVisualisation;", "", "transient", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "permanent", "(Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;)V", "getPermanent", "()Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "getTransient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressVisualisation {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final CampaignProgressState permanent;
    @Nullable

    /* renamed from: transient  reason: not valid java name */
    private final CampaignProgressState f462transient;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressVisualisation$Companion;", "", "()V", "fromResponse", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressVisualisation;", "campaignProgressResponse", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgressResponse;", "hidden", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CampaignProgressVisualisation fromResponse(@NotNull CampaignProgressResponse campaignProgressResponse) {
            CampaignProgressState campaignProgressState;
            Intrinsics.checkNotNullParameter(campaignProgressResponse, "campaignProgressResponse");
            CampaignProgress campaignProgress = campaignProgressResponse.getTransient();
            if (campaignProgress != null) {
                campaignProgressState = CampaignProgressState.Companion.fromResponse(campaignProgress);
            } else {
                campaignProgressState = null;
            }
            return new CampaignProgressVisualisation(campaignProgressState, CampaignProgressState.Companion.fromResponse(campaignProgressResponse.getPermanent()));
        }

        @NotNull
        public final CampaignProgressVisualisation hidden() {
            return new CampaignProgressVisualisation((CampaignProgressState) null, CampaignProgressState.Hidden.INSTANCE);
        }
    }

    public CampaignProgressVisualisation(@Nullable CampaignProgressState campaignProgressState, @NotNull CampaignProgressState campaignProgressState2) {
        Intrinsics.checkNotNullParameter(campaignProgressState2, "permanent");
        this.f462transient = campaignProgressState;
        this.permanent = campaignProgressState2;
    }

    public static /* synthetic */ CampaignProgressVisualisation copy$default(CampaignProgressVisualisation campaignProgressVisualisation, CampaignProgressState campaignProgressState, CampaignProgressState campaignProgressState2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            campaignProgressState = campaignProgressVisualisation.f462transient;
        }
        if ((i11 & 2) != 0) {
            campaignProgressState2 = campaignProgressVisualisation.permanent;
        }
        return campaignProgressVisualisation.copy(campaignProgressState, campaignProgressState2);
    }

    @Nullable
    public final CampaignProgressState component1() {
        return this.f462transient;
    }

    @NotNull
    public final CampaignProgressState component2() {
        return this.permanent;
    }

    @NotNull
    public final CampaignProgressVisualisation copy(@Nullable CampaignProgressState campaignProgressState, @NotNull CampaignProgressState campaignProgressState2) {
        Intrinsics.checkNotNullParameter(campaignProgressState2, "permanent");
        return new CampaignProgressVisualisation(campaignProgressState, campaignProgressState2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignProgressVisualisation)) {
            return false;
        }
        CampaignProgressVisualisation campaignProgressVisualisation = (CampaignProgressVisualisation) obj;
        return Intrinsics.areEqual((Object) this.f462transient, (Object) campaignProgressVisualisation.f462transient) && Intrinsics.areEqual((Object) this.permanent, (Object) campaignProgressVisualisation.permanent);
    }

    @NotNull
    public final CampaignProgressState getPermanent() {
        return this.permanent;
    }

    @Nullable
    public final CampaignProgressState getTransient() {
        return this.f462transient;
    }

    public int hashCode() {
        CampaignProgressState campaignProgressState = this.f462transient;
        return ((campaignProgressState == null ? 0 : campaignProgressState.hashCode()) * 31) + this.permanent.hashCode();
    }

    @NotNull
    public String toString() {
        CampaignProgressState campaignProgressState = this.f462transient;
        CampaignProgressState campaignProgressState2 = this.permanent;
        return "CampaignProgressVisualisation(transient=" + campaignProgressState + ", permanent=" + campaignProgressState2 + ")";
    }
}
