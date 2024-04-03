package com.talabat.feature.darkstorescampaignmessage.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;", "", "permanent", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgress;", "transient", "(Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgress;Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgress;)V", "getPermanent", "()Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgress;", "getTransient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkCampaignProgressResponse {
    @Nullable
    private final NetworkCampaignProgress permanent;
    @Nullable

    /* renamed from: transient  reason: not valid java name */
    private final NetworkCampaignProgress f463transient;

    public NetworkCampaignProgressResponse() {
        this((NetworkCampaignProgress) null, (NetworkCampaignProgress) null, 3, (DefaultConstructorMarker) null);
    }

    public NetworkCampaignProgressResponse(@Nullable @Json(name = "permanent") NetworkCampaignProgress networkCampaignProgress, @Nullable @Json(name = "transient") NetworkCampaignProgress networkCampaignProgress2) {
        this.permanent = networkCampaignProgress;
        this.f463transient = networkCampaignProgress2;
    }

    public static /* synthetic */ NetworkCampaignProgressResponse copy$default(NetworkCampaignProgressResponse networkCampaignProgressResponse, NetworkCampaignProgress networkCampaignProgress, NetworkCampaignProgress networkCampaignProgress2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            networkCampaignProgress = networkCampaignProgressResponse.permanent;
        }
        if ((i11 & 2) != 0) {
            networkCampaignProgress2 = networkCampaignProgressResponse.f463transient;
        }
        return networkCampaignProgressResponse.copy(networkCampaignProgress, networkCampaignProgress2);
    }

    @Nullable
    public final NetworkCampaignProgress component1() {
        return this.permanent;
    }

    @Nullable
    public final NetworkCampaignProgress component2() {
        return this.f463transient;
    }

    @NotNull
    public final NetworkCampaignProgressResponse copy(@Nullable @Json(name = "permanent") NetworkCampaignProgress networkCampaignProgress, @Nullable @Json(name = "transient") NetworkCampaignProgress networkCampaignProgress2) {
        return new NetworkCampaignProgressResponse(networkCampaignProgress, networkCampaignProgress2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkCampaignProgressResponse)) {
            return false;
        }
        NetworkCampaignProgressResponse networkCampaignProgressResponse = (NetworkCampaignProgressResponse) obj;
        return Intrinsics.areEqual((Object) this.permanent, (Object) networkCampaignProgressResponse.permanent) && Intrinsics.areEqual((Object) this.f463transient, (Object) networkCampaignProgressResponse.f463transient);
    }

    @Nullable
    public final NetworkCampaignProgress getPermanent() {
        return this.permanent;
    }

    @Nullable
    public final NetworkCampaignProgress getTransient() {
        return this.f463transient;
    }

    public int hashCode() {
        NetworkCampaignProgress networkCampaignProgress = this.permanent;
        int i11 = 0;
        int hashCode = (networkCampaignProgress == null ? 0 : networkCampaignProgress.hashCode()) * 31;
        NetworkCampaignProgress networkCampaignProgress2 = this.f463transient;
        if (networkCampaignProgress2 != null) {
            i11 = networkCampaignProgress2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        NetworkCampaignProgress networkCampaignProgress = this.permanent;
        NetworkCampaignProgress networkCampaignProgress2 = this.f463transient;
        return "NetworkCampaignProgressResponse(permanent=" + networkCampaignProgress + ", transient=" + networkCampaignProgress2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkCampaignProgressResponse(NetworkCampaignProgress networkCampaignProgress, NetworkCampaignProgress networkCampaignProgress2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : networkCampaignProgress, (i11 & 2) != 0 ? null : networkCampaignProgress2);
    }
}
