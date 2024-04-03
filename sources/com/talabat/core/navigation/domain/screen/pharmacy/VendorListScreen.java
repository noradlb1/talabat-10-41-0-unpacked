package com.talabat.core.navigation.domain.screen.pharmacy;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEventKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/pharmacy/VendorListScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Landroid/os/Parcelable;", "data", "Lcom/talabat/core/navigation/domain/screen/pharmacy/VendorListScreen$VendorListData;", "(Lcom/talabat/core/navigation/domain/screen/pharmacy/VendorListScreen$VendorListData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/pharmacy/VendorListScreen$VendorListData;", "link", "", "getLink", "()Ljava/lang/String;", "VendorListData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorListScreen implements Screen<Parcelable> {
    @NotNull
    private final VendorListData data;
    @NotNull
    private final String link = SdSquadActions.ACTION_SDSQUAD_LISTING_SCREEN;

    public VendorListScreen(@NotNull VendorListData vendorListData) {
        Intrinsics.checkNotNullParameter(vendorListData, "data");
        this.data = vendorListData;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/pharmacy/VendorListScreen$VendorListData;", "Landroid/os/Parcelable;", "vertical", "", "verticalId", "", "(Ljava/lang/String;I)V", "getVertical", "()Ljava/lang/String;", "getVerticalId", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class VendorListData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<VendorListData> CREATOR = new Creator();
        @NotNull
        private final String vertical;
        private final int verticalId;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<VendorListData> {
            @NotNull
            public final VendorListData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new VendorListData(parcel.readString(), parcel.readInt());
            }

            @NotNull
            public final VendorListData[] newArray(int i11) {
                return new VendorListData[i11];
            }
        }

        public VendorListData() {
            this((String) null, 0, 3, (DefaultConstructorMarker) null);
        }

        public VendorListData(@NotNull String str, int i11) {
            Intrinsics.checkNotNullParameter(str, BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL);
            this.vertical = str;
            this.verticalId = i11;
        }

        public static /* synthetic */ VendorListData copy$default(VendorListData vendorListData, String str, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = vendorListData.vertical;
            }
            if ((i12 & 2) != 0) {
                i11 = vendorListData.verticalId;
            }
            return vendorListData.copy(str, i11);
        }

        @NotNull
        public final String component1() {
            return this.vertical;
        }

        public final int component2() {
            return this.verticalId;
        }

        @NotNull
        public final VendorListData copy(@NotNull String str, int i11) {
            Intrinsics.checkNotNullParameter(str, BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL);
            return new VendorListData(str, i11);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VendorListData)) {
                return false;
            }
            VendorListData vendorListData = (VendorListData) obj;
            return Intrinsics.areEqual((Object) this.vertical, (Object) vendorListData.vertical) && this.verticalId == vendorListData.verticalId;
        }

        @NotNull
        public final String getVertical() {
            return this.vertical;
        }

        public final int getVerticalId() {
            return this.verticalId;
        }

        public int hashCode() {
            return (this.vertical.hashCode() * 31) + this.verticalId;
        }

        @NotNull
        public String toString() {
            String str = this.vertical;
            int i11 = this.verticalId;
            return "VendorListData(vertical=" + str + ", verticalId=" + i11 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.vertical);
            parcel.writeInt(this.verticalId);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ VendorListData(String str, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? -1 : i11);
        }
    }

    @NotNull
    public VendorListData getData() {
        return this.data;
    }
}
