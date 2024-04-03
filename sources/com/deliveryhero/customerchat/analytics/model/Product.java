package com.deliveryhero.customerchat.analytics.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/model/Product;", "", "name", "", "version", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Product {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f29804name;
    @Nullable
    private final String version;

    public Product(@NotNull @Json(name = "name") String str, @Nullable @Json(name = "version") String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f29804name = str;
        this.version = str2;
    }

    public static /* synthetic */ Product copy$default(Product product, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = product.f29804name;
        }
        if ((i11 & 2) != 0) {
            str2 = product.version;
        }
        return product.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f29804name;
    }

    @Nullable
    public final String component2() {
        return this.version;
    }

    @NotNull
    public final Product copy(@NotNull @Json(name = "name") String str, @Nullable @Json(name = "version") String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new Product(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return Intrinsics.areEqual((Object) this.f29804name, (Object) product.f29804name) && Intrinsics.areEqual((Object) this.version, (Object) product.version);
    }

    @NotNull
    public final String getName() {
        return this.f29804name;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = this.f29804name.hashCode() * 31;
        String str = this.version;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "Product(name=" + this.f29804name + ", version=" + this.version + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Product(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "p2pchat" : str, str2);
    }
}
