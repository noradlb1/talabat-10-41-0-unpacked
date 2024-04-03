package com.talabat.feature.darkstorescart.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J:\u0010\u0018\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "", "discountType", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "discountValue", "", "id", "", "qty", "", "(Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;Ljava/lang/Float;Ljava/lang/String;I)V", "getDiscountType", "()Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "getDiscountValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getId", "()Ljava/lang/String;", "getQty", "()I", "component1", "component2", "component3", "component4", "copy", "(Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;Ljava/lang/Float;Ljava/lang/String;I)Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Benefit {
    @Nullable
    private final Campaign.Type discountType;
    @Nullable
    private final Float discountValue;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58487id;
    private final int qty;

    public Benefit(@Nullable @Json(name = "discount_type") Campaign.Type type, @Nullable @Json(name = "discount_value") Float f11, @NotNull @Json(name = "product_id") String str, @Json(name = "qty") int i11) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.discountType = type;
        this.discountValue = f11;
        this.f58487id = str;
        this.qty = i11;
    }

    public static /* synthetic */ Benefit copy$default(Benefit benefit, Campaign.Type type, Float f11, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            type = benefit.discountType;
        }
        if ((i12 & 2) != 0) {
            f11 = benefit.discountValue;
        }
        if ((i12 & 4) != 0) {
            str = benefit.f58487id;
        }
        if ((i12 & 8) != 0) {
            i11 = benefit.qty;
        }
        return benefit.copy(type, f11, str, i11);
    }

    @Nullable
    public final Campaign.Type component1() {
        return this.discountType;
    }

    @Nullable
    public final Float component2() {
        return this.discountValue;
    }

    @NotNull
    public final String component3() {
        return this.f58487id;
    }

    public final int component4() {
        return this.qty;
    }

    @NotNull
    public final Benefit copy(@Nullable @Json(name = "discount_type") Campaign.Type type, @Nullable @Json(name = "discount_value") Float f11, @NotNull @Json(name = "product_id") String str, @Json(name = "qty") int i11) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new Benefit(type, f11, str, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Benefit)) {
            return false;
        }
        Benefit benefit = (Benefit) obj;
        return this.discountType == benefit.discountType && Intrinsics.areEqual((Object) this.discountValue, (Object) benefit.discountValue) && Intrinsics.areEqual((Object) this.f58487id, (Object) benefit.f58487id) && this.qty == benefit.qty;
    }

    @Nullable
    public final Campaign.Type getDiscountType() {
        return this.discountType;
    }

    @Nullable
    public final Float getDiscountValue() {
        return this.discountValue;
    }

    @NotNull
    public final String getId() {
        return this.f58487id;
    }

    public final int getQty() {
        return this.qty;
    }

    public int hashCode() {
        Campaign.Type type = this.discountType;
        int i11 = 0;
        int hashCode = (type == null ? 0 : type.hashCode()) * 31;
        Float f11 = this.discountValue;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        return ((((hashCode + i11) * 31) + this.f58487id.hashCode()) * 31) + this.qty;
    }

    @NotNull
    public String toString() {
        Campaign.Type type = this.discountType;
        Float f11 = this.discountValue;
        String str = this.f58487id;
        int i11 = this.qty;
        return "Benefit(discountType=" + type + ", discountValue=" + f11 + ", id=" + str + ", qty=" + i11 + ")";
    }
}
