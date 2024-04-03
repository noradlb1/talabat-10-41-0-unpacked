package com.talabat.feature.nfvinvendorsearch.presentation.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\""}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/CategoryProductsRoute;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "branchId", "", "categoryId", "categoryName", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBranchId", "()Ljava/lang/String;", "getCategoryId", "getCategoryName", "getEventOrigin", "buildArguments", "", "", "buildPath", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class CategoryProductsRoute extends FlutterRoute {
    @NotNull
    public static final Parcelable.Creator<CategoryProductsRoute> CREATOR = new Creator();
    @NotNull
    private final String branchId;
    @NotNull
    private final String categoryId;
    @NotNull
    private final String categoryName;
    @NotNull
    private final String eventOrigin;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CategoryProductsRoute> {
        @NotNull
        public final CategoryProductsRoute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CategoryProductsRoute(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final CategoryProductsRoute[] newArray(int i11) {
            return new CategoryProductsRoute[i11];
        }
    }

    public CategoryProductsRoute(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, "categoryId");
        Intrinsics.checkNotNullParameter(str3, "categoryName");
        Intrinsics.checkNotNullParameter(str4, "eventOrigin");
        this.branchId = str;
        this.categoryId = str2;
        this.categoryName = str3;
        this.eventOrigin = str4;
    }

    public static /* synthetic */ CategoryProductsRoute copy$default(CategoryProductsRoute categoryProductsRoute, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = categoryProductsRoute.branchId;
        }
        if ((i11 & 2) != 0) {
            str2 = categoryProductsRoute.categoryId;
        }
        if ((i11 & 4) != 0) {
            str3 = categoryProductsRoute.categoryName;
        }
        if ((i11 & 8) != 0) {
            str4 = categoryProductsRoute.eventOrigin;
        }
        return categoryProductsRoute.copy(str, str2, str3, str4);
    }

    @NotNull
    public Map<String, Object> buildArguments() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("id", this.categoryId), TuplesKt.to("name", this.categoryName), TuplesKt.to("eventOrigin", this.eventOrigin));
    }

    @NotNull
    public String buildPath() {
        String str = this.branchId;
        return "qcommerce/branches/" + str + "/products/category";
    }

    @NotNull
    public final String component1() {
        return this.branchId;
    }

    @NotNull
    public final String component2() {
        return this.categoryId;
    }

    @NotNull
    public final String component3() {
        return this.categoryName;
    }

    @NotNull
    public final String component4() {
        return this.eventOrigin;
    }

    @NotNull
    public final CategoryProductsRoute copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, "categoryId");
        Intrinsics.checkNotNullParameter(str3, "categoryName");
        Intrinsics.checkNotNullParameter(str4, "eventOrigin");
        return new CategoryProductsRoute(str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryProductsRoute)) {
            return false;
        }
        CategoryProductsRoute categoryProductsRoute = (CategoryProductsRoute) obj;
        return Intrinsics.areEqual((Object) this.branchId, (Object) categoryProductsRoute.branchId) && Intrinsics.areEqual((Object) this.categoryId, (Object) categoryProductsRoute.categoryId) && Intrinsics.areEqual((Object) this.categoryName, (Object) categoryProductsRoute.categoryName) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) categoryProductsRoute.eventOrigin);
    }

    @NotNull
    public final String getBranchId() {
        return this.branchId;
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    public int hashCode() {
        return (((((this.branchId.hashCode() * 31) + this.categoryId.hashCode()) * 31) + this.categoryName.hashCode()) * 31) + this.eventOrigin.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.branchId;
        String str2 = this.categoryId;
        String str3 = this.categoryName;
        String str4 = this.eventOrigin;
        return "CategoryProductsRoute(branchId=" + str + ", categoryId=" + str2 + ", categoryName=" + str3 + ", eventOrigin=" + str4 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.branchId);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.categoryName);
        parcel.writeString(this.eventOrigin);
    }
}
