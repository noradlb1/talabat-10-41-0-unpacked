package com.talabat.core.navigation.domain.screen.gem;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.gem.GemNavigatorAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/gem/GemOffersScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/gem/GemOffersScreen$GemOffersData;", "data", "(Lcom/talabat/core/navigation/domain/screen/gem/GemOffersScreen$GemOffersData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/gem/GemOffersScreen$GemOffersData;", "link", "", "getLink", "()Ljava/lang/String;", "GemOffersData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemOffersScreen implements Screen<GemOffersData> {
    @NotNull
    private final GemOffersData data;
    @NotNull
    private final String link = GemNavigatorAction.OPEN_GEM_OFFERING_ACTIVITY;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/gem/GemOffersScreen$GemOffersData;", "Landroid/os/Parcelable;", "isFromFlutterHoF", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class GemOffersData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<GemOffersData> CREATOR = new Creator();
        private final boolean isFromFlutterHoF;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<GemOffersData> {
            @NotNull
            public final GemOffersData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new GemOffersData(parcel.readInt() != 0);
            }

            @NotNull
            public final GemOffersData[] newArray(int i11) {
                return new GemOffersData[i11];
            }
        }

        public GemOffersData(boolean z11) {
            this.isFromFlutterHoF = z11;
        }

        public static /* synthetic */ GemOffersData copy$default(GemOffersData gemOffersData, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = gemOffersData.isFromFlutterHoF;
            }
            return gemOffersData.copy(z11);
        }

        public final boolean component1() {
            return this.isFromFlutterHoF;
        }

        @NotNull
        public final GemOffersData copy(boolean z11) {
            return new GemOffersData(z11);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GemOffersData) && this.isFromFlutterHoF == ((GemOffersData) obj).isFromFlutterHoF;
        }

        public int hashCode() {
            boolean z11 = this.isFromFlutterHoF;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public final boolean isFromFlutterHoF() {
            return this.isFromFlutterHoF;
        }

        @NotNull
        public String toString() {
            boolean z11 = this.isFromFlutterHoF;
            return "GemOffersData(isFromFlutterHoF=" + z11 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.isFromFlutterHoF ? 1 : 0);
        }
    }

    public GemOffersScreen(@NotNull GemOffersData gemOffersData) {
        Intrinsics.checkNotNullParameter(gemOffersData, "data");
        this.data = gemOffersData;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @NotNull
    public GemOffersData getData() {
        return this.data;
    }
}
