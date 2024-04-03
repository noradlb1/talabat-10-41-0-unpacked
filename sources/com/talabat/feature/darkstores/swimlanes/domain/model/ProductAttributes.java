package com.talabat.feature.darkstores.swimlanes.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/domain/model/ProductAttributes;", "", "type", "", "id", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-swimlanes_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductAttributes {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58409id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58410name;
    @NotNull
    private final String type;

    public ProductAttributes(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "name");
        this.type = str;
        this.f58409id = str2;
        this.f58410name = str3;
    }

    public static /* synthetic */ ProductAttributes copy$default(ProductAttributes productAttributes, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = productAttributes.type;
        }
        if ((i11 & 2) != 0) {
            str2 = productAttributes.f58409id;
        }
        if ((i11 & 4) != 0) {
            str3 = productAttributes.f58410name;
        }
        return productAttributes.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.f58409id;
    }

    @NotNull
    public final String component3() {
        return this.f58410name;
    }

    @NotNull
    public final ProductAttributes copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "name");
        return new ProductAttributes(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductAttributes)) {
            return false;
        }
        ProductAttributes productAttributes = (ProductAttributes) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) productAttributes.type) && Intrinsics.areEqual((Object) this.f58409id, (Object) productAttributes.f58409id) && Intrinsics.areEqual((Object) this.f58410name, (Object) productAttributes.f58410name);
    }

    @NotNull
    public final String getId() {
        return this.f58409id;
    }

    @NotNull
    public final String getName() {
        return this.f58410name;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.f58409id.hashCode()) * 31) + this.f58410name.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.type;
        String str2 = this.f58409id;
        String str3 = this.f58410name;
        return "ProductAttributes(type=" + str + ", id=" + str2 + ", name=" + str3 + ")";
    }
}
