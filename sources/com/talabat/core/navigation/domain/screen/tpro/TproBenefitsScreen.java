package com.talabat.core.navigation.domain.screen.tpro;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.tpro.TproNavigatorActionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/tpro/TproBenefitsScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/tpro/TproBenefitsScreen$TproBenefitsData;", "data", "(Lcom/talabat/core/navigation/domain/screen/tpro/TproBenefitsScreen$TproBenefitsData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/tpro/TproBenefitsScreen$TproBenefitsData;", "link", "", "getLink", "()Ljava/lang/String;", "TproBenefitsData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproBenefitsScreen implements Screen<TproBenefitsData> {
    @Nullable
    private final TproBenefitsData data;
    @NotNull
    private final String link = TproNavigatorActionsKt.OPEN_TPRO_BENEFITS_ACTIVITY;

    public TproBenefitsScreen(@Nullable TproBenefitsData tproBenefitsData) {
        this.data = tproBenefitsData;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @Nullable
    public TproBenefitsData getData() {
        return this.data;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/tpro/TproBenefitsScreen$TproBenefitsData;", "Landroid/os/Parcelable;", "deeplinkBundle", "Landroid/os/Bundle;", "isReactivate", "", "(Landroid/os/Bundle;Z)V", "getDeeplinkBundle", "()Landroid/os/Bundle;", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class TproBenefitsData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<TproBenefitsData> CREATOR = new Creator();
        @NotNull
        private final Bundle deeplinkBundle;
        private final boolean isReactivate;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<TproBenefitsData> {
            @NotNull
            public final TproBenefitsData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TproBenefitsData(parcel.readBundle(TproBenefitsData.class.getClassLoader()), parcel.readInt() != 0);
            }

            @NotNull
            public final TproBenefitsData[] newArray(int i11) {
                return new TproBenefitsData[i11];
            }
        }

        public TproBenefitsData() {
            this((Bundle) null, false, 3, (DefaultConstructorMarker) null);
        }

        public TproBenefitsData(@NotNull Bundle bundle, boolean z11) {
            Intrinsics.checkNotNullParameter(bundle, "deeplinkBundle");
            this.deeplinkBundle = bundle;
            this.isReactivate = z11;
        }

        public static /* synthetic */ TproBenefitsData copy$default(TproBenefitsData tproBenefitsData, Bundle bundle, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bundle = tproBenefitsData.deeplinkBundle;
            }
            if ((i11 & 2) != 0) {
                z11 = tproBenefitsData.isReactivate;
            }
            return tproBenefitsData.copy(bundle, z11);
        }

        @NotNull
        public final Bundle component1() {
            return this.deeplinkBundle;
        }

        public final boolean component2() {
            return this.isReactivate;
        }

        @NotNull
        public final TproBenefitsData copy(@NotNull Bundle bundle, boolean z11) {
            Intrinsics.checkNotNullParameter(bundle, "deeplinkBundle");
            return new TproBenefitsData(bundle, z11);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TproBenefitsData)) {
                return false;
            }
            TproBenefitsData tproBenefitsData = (TproBenefitsData) obj;
            return Intrinsics.areEqual((Object) this.deeplinkBundle, (Object) tproBenefitsData.deeplinkBundle) && this.isReactivate == tproBenefitsData.isReactivate;
        }

        @NotNull
        public final Bundle getDeeplinkBundle() {
            return this.deeplinkBundle;
        }

        public int hashCode() {
            int hashCode = this.deeplinkBundle.hashCode() * 31;
            boolean z11 = this.isReactivate;
            if (z11) {
                z11 = true;
            }
            return hashCode + (z11 ? 1 : 0);
        }

        public final boolean isReactivate() {
            return this.isReactivate;
        }

        @NotNull
        public String toString() {
            Bundle bundle = this.deeplinkBundle;
            boolean z11 = this.isReactivate;
            return "TproBenefitsData(deeplinkBundle=" + bundle + ", isReactivate=" + z11 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeBundle(this.deeplinkBundle);
            parcel.writeInt(this.isReactivate ? 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TproBenefitsData(Bundle bundle, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? new Bundle() : bundle, (i11 & 2) != 0 ? false : z11);
        }
    }
}
