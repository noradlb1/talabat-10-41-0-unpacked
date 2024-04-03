package com.deliveryhero.fluid.widgets.image;

import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageLocator;", "", "Companion", "Local", "Remote", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Remote;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public interface ImageLocator {
    @NotNull
    public static final Companion Companion = Companion.f30274a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Companion;", "", "()V", "NULL", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "getNULL", "()Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        private static final Local NULL = new Local((ImageAsset) null, 1, (DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f30274a = new Companion();

        private Companion() {
        }

        @NotNull
        public final Local getNULL() {
            return NULL;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Remote;", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    public static final class Remote implements ImageLocator {
        @NotNull
        private final String url;

        public Remote(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            this.url = str;
        }

        public static /* synthetic */ Remote copy$default(Remote remote, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = remote.url;
            }
            return remote.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.url;
        }

        @NotNull
        public final Remote copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new Remote(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Remote) && Intrinsics.areEqual((Object) this.url, (Object) ((Remote) obj).url);
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "Remote(url=" + this.url + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator;", "asset", "Lcom/deliveryhero/fluid/widgets/image/ImageAsset;", "(Lcom/deliveryhero/fluid/widgets/image/ImageAsset;)V", "getAsset", "()Lcom/deliveryhero/fluid/widgets/image/ImageAsset;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    public static final class Local implements ImageLocator {
        @Nullable
        private final ImageAsset asset;

        public Local() {
            this((ImageAsset) null, 1, (DefaultConstructorMarker) null);
        }

        public Local(@Nullable ImageAsset imageAsset) {
            this.asset = imageAsset;
        }

        public static /* synthetic */ Local copy$default(Local local, ImageAsset imageAsset, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                imageAsset = local.asset;
            }
            return local.copy(imageAsset);
        }

        @Nullable
        public final ImageAsset component1() {
            return this.asset;
        }

        @NotNull
        public final Local copy(@Nullable ImageAsset imageAsset) {
            return new Local(imageAsset);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Local) && Intrinsics.areEqual((Object) this.asset, (Object) ((Local) obj).asset);
        }

        @Nullable
        public final ImageAsset getAsset() {
            return this.asset;
        }

        public int hashCode() {
            ImageAsset imageAsset = this.asset;
            if (imageAsset == null) {
                return 0;
            }
            return imageAsset.hashCode();
        }

        @NotNull
        public String toString() {
            return "Local(asset=" + this.asset + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Local(ImageAsset imageAsset, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : imageAsset);
        }
    }
}
