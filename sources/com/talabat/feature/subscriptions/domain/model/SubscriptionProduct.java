package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/SubscriptionProduct;", "", "title", "", "id", "description", "icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getIcon", "getId", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionProduct {
    @NotNull
    private final String description;
    @NotNull
    private final String icon;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58982id;
    @NotNull
    private final String title;

    public SubscriptionProduct() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public SubscriptionProduct(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "icon");
        this.title = str;
        this.f58982id = str2;
        this.description = str3;
        this.icon = str4;
    }

    public static /* synthetic */ SubscriptionProduct copy$default(SubscriptionProduct subscriptionProduct, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionProduct.title;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionProduct.f58982id;
        }
        if ((i11 & 4) != 0) {
            str3 = subscriptionProduct.description;
        }
        if ((i11 & 8) != 0) {
            str4 = subscriptionProduct.icon;
        }
        return subscriptionProduct.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.f58982id;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final String component4() {
        return this.icon;
    }

    @NotNull
    public final SubscriptionProduct copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "icon");
        return new SubscriptionProduct(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionProduct)) {
            return false;
        }
        SubscriptionProduct subscriptionProduct = (SubscriptionProduct) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) subscriptionProduct.title) && Intrinsics.areEqual((Object) this.f58982id, (Object) subscriptionProduct.f58982id) && Intrinsics.areEqual((Object) this.description, (Object) subscriptionProduct.description) && Intrinsics.areEqual((Object) this.icon, (Object) subscriptionProduct.icon);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getId() {
        return this.f58982id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.f58982id.hashCode()) * 31) + this.description.hashCode()) * 31) + this.icon.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.f58982id;
        String str3 = this.description;
        String str4 = this.icon;
        return "SubscriptionProduct(title=" + str + ", id=" + str2 + ", description=" + str3 + ", icon=" + str4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionProduct(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4);
    }
}
