package com.talabat.feature.nfvinvendorsearch.presentation.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\u0010\u001a\u00020\fHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/CartRoute;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "branchId", "", "(Ljava/lang/String;)V", "buildArguments", "", "", "buildPath", "component1", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class CartRoute extends FlutterRoute {
    @NotNull
    public static final Parcelable.Creator<CartRoute> CREATOR = new Creator();
    @NotNull
    private final String branchId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CartRoute> {
        @NotNull
        public final CartRoute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CartRoute(parcel.readString());
        }

        @NotNull
        public final CartRoute[] newArray(int i11) {
            return new CartRoute[i11];
        }
    }

    public CartRoute(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        this.branchId = str;
    }

    private final String component1() {
        return this.branchId;
    }

    public static /* synthetic */ CartRoute copy$default(CartRoute cartRoute, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cartRoute.branchId;
        }
        return cartRoute.copy(str);
    }

    @NotNull
    public Map<String, Object> buildArguments() {
        return MapsKt__MapsKt.emptyMap();
    }

    @NotNull
    public String buildPath() {
        String str = this.branchId;
        return "qcommerce/branches/" + str + "/basket";
    }

    @NotNull
    public final CartRoute copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        return new CartRoute(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CartRoute) && Intrinsics.areEqual((Object) this.branchId, (Object) ((CartRoute) obj).branchId);
    }

    public int hashCode() {
        return this.branchId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.branchId;
        return "CartRoute(branchId=" + str + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.branchId);
    }
}
