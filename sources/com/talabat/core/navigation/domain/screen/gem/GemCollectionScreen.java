package com.talabat.core.navigation.domain.screen.gem;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.gem.GemNavigatorAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionScreen$GemCollectionData;", "data", "(Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionScreen$GemCollectionData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionScreen$GemCollectionData;", "link", "", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "GemCollectionData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionScreen implements Screen<GemCollectionData> {
    @Nullable
    private final GemCollectionData data;
    @NotNull
    private final String link;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionScreen$GemCollectionData;", "Landroid/os/Parcelable;", "entrypoint", "Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionEntrypoint;", "(Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionEntrypoint;)V", "getEntrypoint", "()Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionEntrypoint;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class GemCollectionData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<GemCollectionData> CREATOR = new Creator();
        @NotNull
        private final GemCollectionEntrypoint entrypoint;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<GemCollectionData> {
            @NotNull
            public final GemCollectionData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new GemCollectionData(GemCollectionEntrypoint.valueOf(parcel.readString()));
            }

            @NotNull
            public final GemCollectionData[] newArray(int i11) {
                return new GemCollectionData[i11];
            }
        }

        public GemCollectionData(@NotNull GemCollectionEntrypoint gemCollectionEntrypoint) {
            Intrinsics.checkNotNullParameter(gemCollectionEntrypoint, "entrypoint");
            this.entrypoint = gemCollectionEntrypoint;
        }

        public static /* synthetic */ GemCollectionData copy$default(GemCollectionData gemCollectionData, GemCollectionEntrypoint gemCollectionEntrypoint, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                gemCollectionEntrypoint = gemCollectionData.entrypoint;
            }
            return gemCollectionData.copy(gemCollectionEntrypoint);
        }

        @NotNull
        public final GemCollectionEntrypoint component1() {
            return this.entrypoint;
        }

        @NotNull
        public final GemCollectionData copy(@NotNull GemCollectionEntrypoint gemCollectionEntrypoint) {
            Intrinsics.checkNotNullParameter(gemCollectionEntrypoint, "entrypoint");
            return new GemCollectionData(gemCollectionEntrypoint);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GemCollectionData) && this.entrypoint == ((GemCollectionData) obj).entrypoint;
        }

        @NotNull
        public final GemCollectionEntrypoint getEntrypoint() {
            return this.entrypoint;
        }

        public int hashCode() {
            return this.entrypoint.hashCode();
        }

        @NotNull
        public String toString() {
            GemCollectionEntrypoint gemCollectionEntrypoint = this.entrypoint;
            return "GemCollectionData(entrypoint=" + gemCollectionEntrypoint + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.entrypoint.name());
        }
    }

    public GemCollectionScreen() {
        this((GemCollectionData) null, 1, (DefaultConstructorMarker) null);
    }

    public GemCollectionScreen(@Nullable GemCollectionData gemCollectionData) {
        this.data = gemCollectionData;
        this.link = GemNavigatorAction.OPEN_GEM_COLLECTION_ACTIVITY;
    }

    public static /* synthetic */ GemCollectionScreen copy$default(GemCollectionScreen gemCollectionScreen, GemCollectionData gemCollectionData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gemCollectionData = gemCollectionScreen.getData();
        }
        return gemCollectionScreen.copy(gemCollectionData);
    }

    @Nullable
    public final GemCollectionData component1() {
        return getData();
    }

    @NotNull
    public final GemCollectionScreen copy(@Nullable GemCollectionData gemCollectionData) {
        return new GemCollectionScreen(gemCollectionData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GemCollectionScreen) && Intrinsics.areEqual((Object) getData(), (Object) ((GemCollectionScreen) obj).getData());
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    public int hashCode() {
        if (getData() == null) {
            return 0;
        }
        return getData().hashCode();
    }

    @NotNull
    public String toString() {
        GemCollectionData data2 = getData();
        return "GemCollectionScreen(data=" + data2 + ")";
    }

    @Nullable
    public GemCollectionData getData() {
        return this.data;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GemCollectionScreen(GemCollectionData gemCollectionData, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : gemCollectionData);
    }
}
