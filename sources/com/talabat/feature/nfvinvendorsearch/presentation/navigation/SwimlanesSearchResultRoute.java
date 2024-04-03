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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÂ\u0003J1\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/SwimlanesSearchResultRoute;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "branchId", "", "id", "swimlaneName", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "buildArguments", "", "", "buildPath", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class SwimlanesSearchResultRoute extends FlutterRoute {
    @NotNull
    public static final Parcelable.Creator<SwimlanesSearchResultRoute> CREATOR = new Creator();
    @NotNull
    private final String branchId;
    @NotNull
    private final String eventOrigin;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58629id;
    @NotNull
    private final String swimlaneName;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SwimlanesSearchResultRoute> {
        @NotNull
        public final SwimlanesSearchResultRoute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SwimlanesSearchResultRoute(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final SwimlanesSearchResultRoute[] newArray(int i11) {
            return new SwimlanesSearchResultRoute[i11];
        }
    }

    public SwimlanesSearchResultRoute(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "swimlaneName");
        Intrinsics.checkNotNullParameter(str4, "eventOrigin");
        this.branchId = str;
        this.f58629id = str2;
        this.swimlaneName = str3;
        this.eventOrigin = str4;
    }

    private final String component1() {
        return this.branchId;
    }

    private final String component2() {
        return this.f58629id;
    }

    private final String component3() {
        return this.swimlaneName;
    }

    private final String component4() {
        return this.eventOrigin;
    }

    public static /* synthetic */ SwimlanesSearchResultRoute copy$default(SwimlanesSearchResultRoute swimlanesSearchResultRoute, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swimlanesSearchResultRoute.branchId;
        }
        if ((i11 & 2) != 0) {
            str2 = swimlanesSearchResultRoute.f58629id;
        }
        if ((i11 & 4) != 0) {
            str3 = swimlanesSearchResultRoute.swimlaneName;
        }
        if ((i11 & 8) != 0) {
            str4 = swimlanesSearchResultRoute.eventOrigin;
        }
        return swimlanesSearchResultRoute.copy(str, str2, str3, str4);
    }

    @NotNull
    public Map<String, Object> buildArguments() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("id", this.f58629id), TuplesKt.to("name", this.swimlaneName), TuplesKt.to("eventOrigin", this.eventOrigin));
    }

    @NotNull
    public String buildPath() {
        String str = this.branchId;
        return "qcommerce/branches/" + str + "/products/swimlane";
    }

    @NotNull
    public final SwimlanesSearchResultRoute copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "swimlaneName");
        Intrinsics.checkNotNullParameter(str4, "eventOrigin");
        return new SwimlanesSearchResultRoute(str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesSearchResultRoute)) {
            return false;
        }
        SwimlanesSearchResultRoute swimlanesSearchResultRoute = (SwimlanesSearchResultRoute) obj;
        return Intrinsics.areEqual((Object) this.branchId, (Object) swimlanesSearchResultRoute.branchId) && Intrinsics.areEqual((Object) this.f58629id, (Object) swimlanesSearchResultRoute.f58629id) && Intrinsics.areEqual((Object) this.swimlaneName, (Object) swimlanesSearchResultRoute.swimlaneName) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) swimlanesSearchResultRoute.eventOrigin);
    }

    public int hashCode() {
        return (((((this.branchId.hashCode() * 31) + this.f58629id.hashCode()) * 31) + this.swimlaneName.hashCode()) * 31) + this.eventOrigin.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.branchId;
        String str2 = this.f58629id;
        String str3 = this.swimlaneName;
        String str4 = this.eventOrigin;
        return "SwimlanesSearchResultRoute(branchId=" + str + ", id=" + str2 + ", swimlaneName=" + str3 + ", eventOrigin=" + str4 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.branchId);
        parcel.writeString(this.f58629id);
        parcel.writeString(this.swimlaneName);
        parcel.writeString(this.eventOrigin);
    }
}
