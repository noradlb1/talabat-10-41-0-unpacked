package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/VendorFeedResponse;", "", "feed", "Lcom/talabat/darkstores/data/discovery/model/FeedResponse;", "(Lcom/talabat/darkstores/data/discovery/model/FeedResponse;)V", "getFeed", "()Lcom/talabat/darkstores/data/discovery/model/FeedResponse;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorFeedResponse {
    @Nullable
    private final FeedResponse feed;

    public VendorFeedResponse() {
        this((FeedResponse) null, 1, (DefaultConstructorMarker) null);
    }

    public VendorFeedResponse(@Nullable @Json(name = "feed") FeedResponse feedResponse) {
        this.feed = feedResponse;
    }

    public static /* synthetic */ VendorFeedResponse copy$default(VendorFeedResponse vendorFeedResponse, FeedResponse feedResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            feedResponse = vendorFeedResponse.feed;
        }
        return vendorFeedResponse.copy(feedResponse);
    }

    @Nullable
    public final FeedResponse component1() {
        return this.feed;
    }

    @NotNull
    public final VendorFeedResponse copy(@Nullable @Json(name = "feed") FeedResponse feedResponse) {
        return new VendorFeedResponse(feedResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VendorFeedResponse) && Intrinsics.areEqual((Object) this.feed, (Object) ((VendorFeedResponse) obj).feed);
    }

    @Nullable
    public final FeedResponse getFeed() {
        return this.feed;
    }

    public int hashCode() {
        FeedResponse feedResponse = this.feed;
        if (feedResponse == null) {
            return 0;
        }
        return feedResponse.hashCode();
    }

    @NotNull
    public String toString() {
        FeedResponse feedResponse = this.feed;
        return "VendorFeedResponse(feed=" + feedResponse + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorFeedResponse(FeedResponse feedResponse, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : feedResponse);
    }
}
