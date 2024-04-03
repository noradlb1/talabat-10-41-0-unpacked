package com.talabat.talabatcommon.feature.subscriptionManagement.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionProduct;", "", "title", "", "id", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getId", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionProduct {
    @SerializedName("description")
    @Nullable
    private String description;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f61581id;
    @SerializedName("title")
    @Nullable
    private final String title;

    public SubscriptionProduct(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.title = str;
        this.f61581id = str2;
        this.description = str3;
    }

    public static /* synthetic */ SubscriptionProduct copy$default(SubscriptionProduct subscriptionProduct, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionProduct.title;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionProduct.f61581id;
        }
        if ((i11 & 4) != 0) {
            str3 = subscriptionProduct.description;
        }
        return subscriptionProduct.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.f61581id;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final SubscriptionProduct copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new SubscriptionProduct(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionProduct)) {
            return false;
        }
        SubscriptionProduct subscriptionProduct = (SubscriptionProduct) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) subscriptionProduct.title) && Intrinsics.areEqual((Object) this.f61581id, (Object) subscriptionProduct.f61581id) && Intrinsics.areEqual((Object) this.description, (Object) subscriptionProduct.description);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getId() {
        return this.f61581id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f61581id;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.f61581id;
        String str3 = this.description;
        return "SubscriptionProduct(title=" + str + ", id=" + str2 + ", description=" + str3 + ")";
    }
}
