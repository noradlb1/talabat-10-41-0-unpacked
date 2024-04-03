package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationReason;", "", "title", "", "id", "order", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getOrder", "()I", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationReason {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58981id;
    private final int order;
    @NotNull
    private final String title;

    public SubscriptionCancellationReason() {
        this((String) null, (String) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public SubscriptionCancellationReason(@NotNull String str, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "id");
        this.title = str;
        this.f58981id = str2;
        this.order = i11;
    }

    public static /* synthetic */ SubscriptionCancellationReason copy$default(SubscriptionCancellationReason subscriptionCancellationReason, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = subscriptionCancellationReason.title;
        }
        if ((i12 & 2) != 0) {
            str2 = subscriptionCancellationReason.f58981id;
        }
        if ((i12 & 4) != 0) {
            i11 = subscriptionCancellationReason.order;
        }
        return subscriptionCancellationReason.copy(str, str2, i11);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.f58981id;
    }

    public final int component3() {
        return this.order;
    }

    @NotNull
    public final SubscriptionCancellationReason copy(@NotNull String str, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "id");
        return new SubscriptionCancellationReason(str, str2, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionCancellationReason)) {
            return false;
        }
        SubscriptionCancellationReason subscriptionCancellationReason = (SubscriptionCancellationReason) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) subscriptionCancellationReason.title) && Intrinsics.areEqual((Object) this.f58981id, (Object) subscriptionCancellationReason.f58981id) && this.order == subscriptionCancellationReason.order;
    }

    @NotNull
    public final String getId() {
        return this.f58981id;
    }

    public final int getOrder() {
        return this.order;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.f58981id.hashCode()) * 31) + this.order;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.f58981id;
        int i11 = this.order;
        return "SubscriptionCancellationReason(title=" + str + ", id=" + str2 + ", order=" + i11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionCancellationReason(String str, String str2, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? "" : str2, (i12 & 4) != 0 ? 0 : i11);
    }
}
