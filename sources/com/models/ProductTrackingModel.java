package com.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/models/ProductTrackingModel;", "", "sku", "", "name", "price", "currency", "index", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getCurrency", "()Ljava/lang/String;", "getIndex", "()I", "getName", "getPrice", "getSku", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductTrackingModel {
    @NotNull
    private final String currency;
    private final int index;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f52755name;
    @NotNull
    private final String price;
    @NotNull
    private final String sku;

    public ProductTrackingModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11) {
        Intrinsics.checkNotNullParameter(str, "sku");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, FirebaseAnalytics.Param.PRICE);
        Intrinsics.checkNotNullParameter(str4, "currency");
        this.sku = str;
        this.f52755name = str2;
        this.price = str3;
        this.currency = str4;
        this.index = i11;
    }

    public static /* synthetic */ ProductTrackingModel copy$default(ProductTrackingModel productTrackingModel, String str, String str2, String str3, String str4, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = productTrackingModel.sku;
        }
        if ((i12 & 2) != 0) {
            str2 = productTrackingModel.f52755name;
        }
        String str5 = str2;
        if ((i12 & 4) != 0) {
            str3 = productTrackingModel.price;
        }
        String str6 = str3;
        if ((i12 & 8) != 0) {
            str4 = productTrackingModel.currency;
        }
        String str7 = str4;
        if ((i12 & 16) != 0) {
            i11 = productTrackingModel.index;
        }
        return productTrackingModel.copy(str, str5, str6, str7, i11);
    }

    @NotNull
    public final String component1() {
        return this.sku;
    }

    @NotNull
    public final String component2() {
        return this.f52755name;
    }

    @NotNull
    public final String component3() {
        return this.price;
    }

    @NotNull
    public final String component4() {
        return this.currency;
    }

    public final int component5() {
        return this.index;
    }

    @NotNull
    public final ProductTrackingModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11) {
        Intrinsics.checkNotNullParameter(str, "sku");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, FirebaseAnalytics.Param.PRICE);
        Intrinsics.checkNotNullParameter(str4, "currency");
        return new ProductTrackingModel(str, str2, str3, str4, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductTrackingModel)) {
            return false;
        }
        ProductTrackingModel productTrackingModel = (ProductTrackingModel) obj;
        return Intrinsics.areEqual((Object) this.sku, (Object) productTrackingModel.sku) && Intrinsics.areEqual((Object) this.f52755name, (Object) productTrackingModel.f52755name) && Intrinsics.areEqual((Object) this.price, (Object) productTrackingModel.price) && Intrinsics.areEqual((Object) this.currency, (Object) productTrackingModel.currency) && this.index == productTrackingModel.index;
    }

    @NotNull
    public final String getCurrency() {
        return this.currency;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final String getName() {
        return this.f52755name;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    public final String getSku() {
        return this.sku;
    }

    public int hashCode() {
        return (((((((this.sku.hashCode() * 31) + this.f52755name.hashCode()) * 31) + this.price.hashCode()) * 31) + this.currency.hashCode()) * 31) + this.index;
    }

    @NotNull
    public String toString() {
        String str = this.sku;
        String str2 = this.f52755name;
        String str3 = this.price;
        String str4 = this.currency;
        int i11 = this.index;
        return "ProductTrackingModel(sku=" + str + ", name=" + str2 + ", price=" + str3 + ", currency=" + str4 + ", index=" + i11 + ")";
    }
}
