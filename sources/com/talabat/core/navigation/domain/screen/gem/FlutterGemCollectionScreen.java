package com.talabat.core.navigation.domain.screen.gem;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/gem/FlutterGemCollectionScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/gem/FlutterGemCollectionScreen$FlutterGemCollectionData;", "data", "(Lcom/talabat/core/navigation/domain/screen/gem/FlutterGemCollectionScreen$FlutterGemCollectionData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/gem/FlutterGemCollectionScreen$FlutterGemCollectionData;", "link", "", "getLink", "()Ljava/lang/String;", "FlutterGemCollectionData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterGemCollectionScreen implements Screen<FlutterGemCollectionData> {
    @Nullable
    private final FlutterGemCollectionData data;
    @NotNull
    private final String link;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/gem/FlutterGemCollectionScreen$FlutterGemCollectionData;", "Landroid/os/Parcelable;", "entrypoint", "Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionEntrypoint;", "(Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionEntrypoint;)V", "getEntrypoint", "()Lcom/talabat/core/navigation/domain/screen/gem/GemCollectionEntrypoint;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class FlutterGemCollectionData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<FlutterGemCollectionData> CREATOR = new Creator();
        @NotNull
        private final GemCollectionEntrypoint entrypoint;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FlutterGemCollectionData> {
            @NotNull
            public final FlutterGemCollectionData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FlutterGemCollectionData(GemCollectionEntrypoint.valueOf(parcel.readString()));
            }

            @NotNull
            public final FlutterGemCollectionData[] newArray(int i11) {
                return new FlutterGemCollectionData[i11];
            }
        }

        public FlutterGemCollectionData(@NotNull GemCollectionEntrypoint gemCollectionEntrypoint) {
            Intrinsics.checkNotNullParameter(gemCollectionEntrypoint, "entrypoint");
            this.entrypoint = gemCollectionEntrypoint;
        }

        public static /* synthetic */ FlutterGemCollectionData copy$default(FlutterGemCollectionData flutterGemCollectionData, GemCollectionEntrypoint gemCollectionEntrypoint, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                gemCollectionEntrypoint = flutterGemCollectionData.entrypoint;
            }
            return flutterGemCollectionData.copy(gemCollectionEntrypoint);
        }

        @NotNull
        public final GemCollectionEntrypoint component1() {
            return this.entrypoint;
        }

        @NotNull
        public final FlutterGemCollectionData copy(@NotNull GemCollectionEntrypoint gemCollectionEntrypoint) {
            Intrinsics.checkNotNullParameter(gemCollectionEntrypoint, "entrypoint");
            return new FlutterGemCollectionData(gemCollectionEntrypoint);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FlutterGemCollectionData) && this.entrypoint == ((FlutterGemCollectionData) obj).entrypoint;
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
            return "FlutterGemCollectionData(entrypoint=" + gemCollectionEntrypoint + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.entrypoint.name());
        }
    }

    public FlutterGemCollectionScreen() {
        this((FlutterGemCollectionData) null, 1, (DefaultConstructorMarker) null);
    }

    public FlutterGemCollectionScreen(@Nullable FlutterGemCollectionData flutterGemCollectionData) {
        this.data = flutterGemCollectionData;
        this.link = "com.talabat.GemCollectionFlutterActivity";
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @Nullable
    public FlutterGemCollectionData getData() {
        return this.data;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlutterGemCollectionScreen(FlutterGemCollectionData flutterGemCollectionData, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : flutterGemCollectionData);
    }
}
