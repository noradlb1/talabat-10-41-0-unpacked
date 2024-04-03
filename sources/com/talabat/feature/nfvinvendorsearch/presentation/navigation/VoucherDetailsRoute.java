package com.talabat.feature.nfvinvendorsearch.presentation.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0012\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/VoucherDetailsRoute;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "branchId", "", "voucherId", "(Ljava/lang/String;Ljava/lang/String;)V", "buildArguments", "", "", "buildPath", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class VoucherDetailsRoute extends FlutterRoute {
    @NotNull
    public static final Parcelable.Creator<VoucherDetailsRoute> CREATOR = new Creator();
    @NotNull
    private final String branchId;
    @NotNull
    private final String voucherId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VoucherDetailsRoute> {
        @NotNull
        public final VoucherDetailsRoute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VoucherDetailsRoute(parcel.readString(), parcel.readString());
        }

        @NotNull
        public final VoucherDetailsRoute[] newArray(int i11) {
            return new VoucherDetailsRoute[i11];
        }
    }

    public VoucherDetailsRoute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        this.branchId = str;
        this.voucherId = str2;
    }

    private final String component1() {
        return this.branchId;
    }

    private final String component2() {
        return this.voucherId;
    }

    public static /* synthetic */ VoucherDetailsRoute copy$default(VoucherDetailsRoute voucherDetailsRoute, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = voucherDetailsRoute.branchId;
        }
        if ((i11 & 2) != 0) {
            str2 = voucherDetailsRoute.voucherId;
        }
        return voucherDetailsRoute.copy(str, str2);
    }

    @NotNull
    public Map<String, Object> buildArguments() {
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to(VoucherUrlConstantsKt.PATH_VOUCHER_ID, this.voucherId));
    }

    @NotNull
    public String buildPath() {
        String str = this.branchId;
        return "qcommerce/branches/" + str + "/vouchers";
    }

    @NotNull
    public final VoucherDetailsRoute copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        return new VoucherDetailsRoute(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherDetailsRoute)) {
            return false;
        }
        VoucherDetailsRoute voucherDetailsRoute = (VoucherDetailsRoute) obj;
        return Intrinsics.areEqual((Object) this.branchId, (Object) voucherDetailsRoute.branchId) && Intrinsics.areEqual((Object) this.voucherId, (Object) voucherDetailsRoute.voucherId);
    }

    public int hashCode() {
        return (this.branchId.hashCode() * 31) + this.voucherId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.branchId;
        String str2 = this.voucherId;
        return "VoucherDetailsRoute(branchId=" + str + ", voucherId=" + str2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.branchId);
        parcel.writeString(this.voucherId);
    }
}
