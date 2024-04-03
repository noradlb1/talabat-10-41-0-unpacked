package com.talabat.darkstores.data.grocery.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/data/grocery/model/CampaignProgressResponse;", "", "transient", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgress;", "permanent", "(Lcom/talabat/darkstores/data/grocery/model/CampaignProgress;Lcom/talabat/darkstores/data/grocery/model/CampaignProgress;)V", "getPermanent", "()Lcom/talabat/darkstores/data/grocery/model/CampaignProgress;", "getTransient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressResponse {
    @NotNull
    private final CampaignProgress permanent;
    @Nullable

    /* renamed from: transient  reason: not valid java name */
    private final CampaignProgress f461transient;

    public CampaignProgressResponse(@Nullable CampaignProgress campaignProgress, @NotNull CampaignProgress campaignProgress2) {
        Intrinsics.checkNotNullParameter(campaignProgress2, "permanent");
        this.f461transient = campaignProgress;
        this.permanent = campaignProgress2;
    }

    public static /* synthetic */ CampaignProgressResponse copy$default(CampaignProgressResponse campaignProgressResponse, CampaignProgress campaignProgress, CampaignProgress campaignProgress2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            campaignProgress = campaignProgressResponse.f461transient;
        }
        if ((i11 & 2) != 0) {
            campaignProgress2 = campaignProgressResponse.permanent;
        }
        return campaignProgressResponse.copy(campaignProgress, campaignProgress2);
    }

    @Nullable
    public final CampaignProgress component1() {
        return this.f461transient;
    }

    @NotNull
    public final CampaignProgress component2() {
        return this.permanent;
    }

    @NotNull
    public final CampaignProgressResponse copy(@Nullable CampaignProgress campaignProgress, @NotNull CampaignProgress campaignProgress2) {
        Intrinsics.checkNotNullParameter(campaignProgress2, "permanent");
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
        return Intrinsics.areEqual((Object) this.f461transient, (Object) campaignProgressResponse.f461transient) && Intrinsics.areEqual((Object) this.permanent, (Object) campaignProgressResponse.permanent);
    }

    @NotNull
    public final CampaignProgress getPermanent() {
        return this.permanent;
    }

    @Nullable
    public final CampaignProgress getTransient() {
        return this.f461transient;
    }

    public int hashCode() {
        CampaignProgress campaignProgress = this.f461transient;
        return ((campaignProgress == null ? 0 : campaignProgress.hashCode()) * 31) + this.permanent.hashCode();
    }

    @NotNull
    public String toString() {
        CampaignProgress campaignProgress = this.f461transient;
        CampaignProgress campaignProgress2 = this.permanent;
        return "CampaignProgressResponse(transient=" + campaignProgress + ", permanent=" + campaignProgress2 + ")";
    }
}
