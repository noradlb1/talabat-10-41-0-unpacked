package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0006\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/ProVendorMovResponseModel;", "", "mov", "", "branchId", "", "isTalabatPro", "", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getBranchId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMov", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "copy", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/talabat/feature/subscriptions/data/remote/model/ProVendorMovResponseModel;", "equals", "other", "hashCode", "toString", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProVendorMovResponseModel {
    @Nullable
    private final Integer branchId;
    @Nullable
    private final Boolean isTalabatPro;
    @Nullable
    private final Float mov;

    public ProVendorMovResponseModel() {
        this((Float) null, (Integer) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    public ProVendorMovResponseModel(@Nullable @Json(name = "mov") Float f11, @Nullable @Json(name = "branchId") Integer num, @Nullable @Json(name = "isTalabatPro") Boolean bool) {
        this.mov = f11;
        this.branchId = num;
        this.isTalabatPro = bool;
    }

    public static /* synthetic */ ProVendorMovResponseModel copy$default(ProVendorMovResponseModel proVendorMovResponseModel, Float f11, Integer num, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = proVendorMovResponseModel.mov;
        }
        if ((i11 & 2) != 0) {
            num = proVendorMovResponseModel.branchId;
        }
        if ((i11 & 4) != 0) {
            bool = proVendorMovResponseModel.isTalabatPro;
        }
        return proVendorMovResponseModel.copy(f11, num, bool);
    }

    @Nullable
    public final Float component1() {
        return this.mov;
    }

    @Nullable
    public final Integer component2() {
        return this.branchId;
    }

    @Nullable
    public final Boolean component3() {
        return this.isTalabatPro;
    }

    @NotNull
    public final ProVendorMovResponseModel copy(@Nullable @Json(name = "mov") Float f11, @Nullable @Json(name = "branchId") Integer num, @Nullable @Json(name = "isTalabatPro") Boolean bool) {
        return new ProVendorMovResponseModel(f11, num, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProVendorMovResponseModel)) {
            return false;
        }
        ProVendorMovResponseModel proVendorMovResponseModel = (ProVendorMovResponseModel) obj;
        return Intrinsics.areEqual((Object) this.mov, (Object) proVendorMovResponseModel.mov) && Intrinsics.areEqual((Object) this.branchId, (Object) proVendorMovResponseModel.branchId) && Intrinsics.areEqual((Object) this.isTalabatPro, (Object) proVendorMovResponseModel.isTalabatPro);
    }

    @Nullable
    public final Integer getBranchId() {
        return this.branchId;
    }

    @Nullable
    public final Float getMov() {
        return this.mov;
    }

    public int hashCode() {
        Float f11 = this.mov;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Integer num = this.branchId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isTalabatPro;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isTalabatPro() {
        return this.isTalabatPro;
    }

    @NotNull
    public String toString() {
        Float f11 = this.mov;
        Integer num = this.branchId;
        Boolean bool = this.isTalabatPro;
        return "ProVendorMovResponseModel(mov=" + f11 + ", branchId=" + num + ", isTalabatPro=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProVendorMovResponseModel(Float f11, Integer num, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : f11, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : bool);
    }
}
