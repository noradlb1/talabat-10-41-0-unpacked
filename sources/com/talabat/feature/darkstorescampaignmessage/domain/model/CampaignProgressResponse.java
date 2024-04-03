package com.talabat.feature.darkstorescampaignmessage.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgressResponse;", "", "permanent", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgress;", "transient", "(Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgress;Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgress;)V", "getPermanent", "()Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgress;", "getTransient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-campaign-message_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressResponse {
    @NotNull
    private final CampaignProgress permanent;
    @Nullable

    /* renamed from: transient  reason: not valid java name */
    private final CampaignProgress f464transient;

    public CampaignProgressResponse(@NotNull CampaignProgress campaignProgress, @Nullable CampaignProgress campaignProgress2) {
        Intrinsics.checkNotNullParameter(campaignProgress, "permanent");
        this.permanent = campaignProgress;
        this.f464transient = campaignProgress2;
    }

    public static /* synthetic */ CampaignProgressResponse copy$default(CampaignProgressResponse campaignProgressResponse, CampaignProgress campaignProgress, CampaignProgress campaignProgress2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            campaignProgress = campaignProgressResponse.permanent;
        }
        if ((i11 & 2) != 0) {
            campaignProgress2 = campaignProgressResponse.f464transient;
        }
        return campaignProgressResponse.copy(campaignProgress, campaignProgress2);
    }

    @NotNull
    public final CampaignProgress component1() {
        return this.permanent;
    }

    @Nullable
    public final CampaignProgress component2() {
        return this.f464transient;
    }

    @NotNull
    public final CampaignProgressResponse copy(@NotNull CampaignProgress campaignProgress, @Nullable CampaignProgress campaignProgress2) {
        Intrinsics.checkNotNullParameter(campaignProgress, "permanent");
        return new CampaignProgressResponse(campaignProgress, campaignProgress2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignProgressResponse)) {
            return false;
        }
        CampaignProgressResponse campaignProgressResponse = (CampaignProgressResponse) obj;
        return Intrinsics.areEqual((Object) this.permanent, (Object) campaignProgressResponse.permanent) && Intrinsics.areEqual((Object) this.f464transient, (Object) campaignProgressResponse.f464transient);
    }

    @NotNull
    public final CampaignProgress getPermanent() {
        return this.permanent;
    }

    @Nullable
    public final CampaignProgress getTransient() {
        return this.f464transient;
    }

    public int hashCode() {
        int hashCode = this.permanent.hashCode() * 31;
        CampaignProgress campaignProgress = this.f464transient;
        return hashCode + (campaignProgress == null ? 0 : campaignProgress.hashCode());
    }

    @NotNull
    public String toString() {
        CampaignProgress campaignProgress = this.permanent;
        CampaignProgress campaignProgress2 = this.f464transient;
        return "CampaignProgressResponse(permanent=" + campaignProgress + ", transient=" + campaignProgress2 + ")";
    }
}
