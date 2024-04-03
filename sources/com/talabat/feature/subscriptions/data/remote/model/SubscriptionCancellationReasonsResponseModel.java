package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionCancellationReasonsResponseModel;", "", "title", "", "id", "displayOrder", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDisplayOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionCancellationReasonsResponseModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationReasonsResponseModel {
    @Nullable
    private final Integer displayOrder;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f58952id;
    @Nullable
    private final String title;

    public SubscriptionCancellationReasonsResponseModel() {
        this((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public SubscriptionCancellationReasonsResponseModel(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "id") String str2, @Nullable @Json(name = "displayOrder") Integer num) {
        this.title = str;
        this.f58952id = str2;
        this.displayOrder = num;
    }

    public static /* synthetic */ SubscriptionCancellationReasonsResponseModel copy$default(SubscriptionCancellationReasonsResponseModel subscriptionCancellationReasonsResponseModel, String str, String str2, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionCancellationReasonsResponseModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionCancellationReasonsResponseModel.f58952id;
        }
        if ((i11 & 4) != 0) {
            num = subscriptionCancellationReasonsResponseModel.displayOrder;
        }
        return subscriptionCancellationReasonsResponseModel.copy(str, str2, num);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.f58952id;
    }

    @Nullable
    public final Integer component3() {
        return this.displayOrder;
    }

    @NotNull
    public final SubscriptionCancellationReasonsResponseModel copy(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "id") String str2, @Nullable @Json(name = "displayOrder") Integer num) {
        return new SubscriptionCancellationReasonsResponseModel(str, str2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionCancellationReasonsResponseModel)) {
            return false;
        }
        SubscriptionCancellationReasonsResponseModel subscriptionCancellationReasonsResponseModel = (SubscriptionCancellationReasonsResponseModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) subscriptionCancellationReasonsResponseModel.title) && Intrinsics.areEqual((Object) this.f58952id, (Object) subscriptionCancellationReasonsResponseModel.f58952id) && Intrinsics.areEqual((Object) this.displayOrder, (Object) subscriptionCancellationReasonsResponseModel.displayOrder);
    }

    @Nullable
    public final Integer getDisplayOrder() {
        return this.displayOrder;
    }

    @Nullable
    public final String getId() {
        return this.f58952id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f58952id;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.displayOrder;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.f58952id;
        Integer num = this.displayOrder;
        return "SubscriptionCancellationReasonsResponseModel(title=" + str + ", id=" + str2 + ", displayOrder=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionCancellationReasonsResponseModel(String str, String str2, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : num);
    }
}
