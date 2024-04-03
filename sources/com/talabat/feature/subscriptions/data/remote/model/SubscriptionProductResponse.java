package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionProductResponse;", "", "title", "", "id", "description", "icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getId", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionProductResponse {
    @Nullable
    private String description;
    @Nullable
    private String icon;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f58954id;
    @Nullable
    private final String title;

    public SubscriptionProductResponse() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public SubscriptionProductResponse(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "id") String str2, @Nullable @Json(name = "description") String str3, @Nullable @Json(name = "icon") String str4) {
        this.title = str;
        this.f58954id = str2;
        this.description = str3;
        this.icon = str4;
    }

    public static /* synthetic */ SubscriptionProductResponse copy$default(SubscriptionProductResponse subscriptionProductResponse, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionProductResponse.title;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionProductResponse.f58954id;
        }
        if ((i11 & 4) != 0) {
            str3 = subscriptionProductResponse.description;
        }
        if ((i11 & 8) != 0) {
            str4 = subscriptionProductResponse.icon;
        }
        return subscriptionProductResponse.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.f58954id;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final String component4() {
        return this.icon;
    }

    @NotNull
    public final SubscriptionProductResponse copy(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "id") String str2, @Nullable @Json(name = "description") String str3, @Nullable @Json(name = "icon") String str4) {
        return new SubscriptionProductResponse(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionProductResponse)) {
            return false;
        }
        SubscriptionProductResponse subscriptionProductResponse = (SubscriptionProductResponse) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) subscriptionProductResponse.title) && Intrinsics.areEqual((Object) this.f58954id, (Object) subscriptionProductResponse.f58954id) && Intrinsics.areEqual((Object) this.description, (Object) subscriptionProductResponse.description) && Intrinsics.areEqual((Object) this.icon, (Object) subscriptionProductResponse.icon);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getId() {
        return this.f58954id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f58954id;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.icon;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode3 + i11;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.f58954id;
        String str3 = this.description;
        String str4 = this.icon;
        return "SubscriptionProductResponse(title=" + str + ", id=" + str2 + ", description=" + str3 + ", icon=" + str4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionProductResponse(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4);
    }
}
