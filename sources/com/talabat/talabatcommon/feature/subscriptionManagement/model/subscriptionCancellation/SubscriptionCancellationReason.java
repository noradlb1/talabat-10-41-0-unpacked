package com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationReason;", "", "id", "", "title", "displayOrder", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDisplayOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationReason;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationReason {
    @SerializedName("displayOrder")
    @Nullable
    private final Integer displayOrder;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f61582id;
    @SerializedName("title")
    @Nullable
    private final String title;

    public SubscriptionCancellationReason() {
        this((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public SubscriptionCancellationReason(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        this.f61582id = str;
        this.title = str2;
        this.displayOrder = num;
    }

    public static /* synthetic */ SubscriptionCancellationReason copy$default(SubscriptionCancellationReason subscriptionCancellationReason, String str, String str2, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionCancellationReason.f61582id;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionCancellationReason.title;
        }
        if ((i11 & 4) != 0) {
            num = subscriptionCancellationReason.displayOrder;
        }
        return subscriptionCancellationReason.copy(str, str2, num);
    }

    @Nullable
    public final String component1() {
        return this.f61582id;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Integer component3() {
        return this.displayOrder;
    }

    @NotNull
    public final SubscriptionCancellationReason copy(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        return new SubscriptionCancellationReason(str, str2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionCancellationReason)) {
            return false;
        }
        SubscriptionCancellationReason subscriptionCancellationReason = (SubscriptionCancellationReason) obj;
        return Intrinsics.areEqual((Object) this.f61582id, (Object) subscriptionCancellationReason.f61582id) && Intrinsics.areEqual((Object) this.title, (Object) subscriptionCancellationReason.title) && Intrinsics.areEqual((Object) this.displayOrder, (Object) subscriptionCancellationReason.displayOrder);
    }

    @Nullable
    public final Integer getDisplayOrder() {
        return this.displayOrder;
    }

    @Nullable
    public final String getId() {
        return this.f61582id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.f61582id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.displayOrder;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f61582id;
        String str2 = this.title;
        Integer num = this.displayOrder;
        return "SubscriptionCancellationReason(id=" + str + ", title=" + str2 + ", displayOrder=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionCancellationReason(String str, String str2, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : num);
    }
}
