package coil.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcoil/util/ImageLoaderOptions;", "", "addLastModifiedToFileCacheKey", "", "launchInterceptorChainOnMainThread", "networkObserverEnabled", "(ZZZ)V", "getAddLastModifiedToFileCacheKey", "()Z", "getLaunchInterceptorChainOnMainThread", "getNetworkObserverEnabled", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImageLoaderOptions {
    private final boolean addLastModifiedToFileCacheKey;
    private final boolean launchInterceptorChainOnMainThread;
    private final boolean networkObserverEnabled;

    public ImageLoaderOptions() {
        this(false, false, false, 7, (DefaultConstructorMarker) null);
    }

    public ImageLoaderOptions(boolean z11, boolean z12, boolean z13) {
        this.addLastModifiedToFileCacheKey = z11;
        this.launchInterceptorChainOnMainThread = z12;
        this.networkObserverEnabled = z13;
    }

    public static /* synthetic */ ImageLoaderOptions copy$default(ImageLoaderOptions imageLoaderOptions, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = imageLoaderOptions.addLastModifiedToFileCacheKey;
        }
        if ((i11 & 2) != 0) {
            z12 = imageLoaderOptions.launchInterceptorChainOnMainThread;
        }
        if ((i11 & 4) != 0) {
            z13 = imageLoaderOptions.networkObserverEnabled;
        }
        return imageLoaderOptions.copy(z11, z12, z13);
    }

    public final boolean component1() {
        return this.addLastModifiedToFileCacheKey;
    }

    public final boolean component2() {
        return this.launchInterceptorChainOnMainThread;
    }

    public final boolean component3() {
        return this.networkObserverEnabled;
    }

    @NotNull
    public final ImageLoaderOptions copy(boolean z11, boolean z12, boolean z13) {
        return new ImageLoaderOptions(z11, z12, z13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageLoaderOptions)) {
            return false;
        }
        ImageLoaderOptions imageLoaderOptions = (ImageLoaderOptions) obj;
        return this.addLastModifiedToFileCacheKey == imageLoaderOptions.addLastModifiedToFileCacheKey && this.launchInterceptorChainOnMainThread == imageLoaderOptions.launchInterceptorChainOnMainThread && this.networkObserverEnabled == imageLoaderOptions.networkObserverEnabled;
    }

    public final boolean getAddLastModifiedToFileCacheKey() {
        return this.addLastModifiedToFileCacheKey;
    }

    public final boolean getLaunchInterceptorChainOnMainThread() {
        return this.launchInterceptorChainOnMainThread;
    }

    public final boolean getNetworkObserverEnabled() {
        return this.networkObserverEnabled;
    }

    public int hashCode() {
        boolean z11 = this.addLastModifiedToFileCacheKey;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.launchInterceptorChainOnMainThread;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.networkObserverEnabled;
        if (!z14) {
            z12 = z14;
        }
        return i12 + (z12 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "ImageLoaderOptions(addLastModifiedToFileCacheKey=" + this.addLastModifiedToFileCacheKey + ", launchInterceptorChainOnMainThread=" + this.launchInterceptorChainOnMainThread + ", networkObserverEnabled=" + this.networkObserverEnabled + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageLoaderOptions(boolean z11, boolean z12, boolean z13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? true : z12, (i11 & 4) != 0 ? true : z13);
    }
}
