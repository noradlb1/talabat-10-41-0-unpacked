package coil.request;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.memory.MemoryCache;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcoil/request/ImageResult;", "", "()V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "request", "Lcoil/request/ImageRequest;", "getRequest", "()Lcoil/request/ImageRequest;", "Metadata", "Lcoil/request/SuccessResult;", "Lcoil/request/ErrorResult;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ImageResult {

    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcoil/request/ImageResult$Metadata;", "", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "isPlaceholderMemoryCacheKeyPresent", "(Lcoil/memory/MemoryCache$Key;ZLcoil/decode/DataSource;Z)V", "getDataSource", "()Lcoil/decode/DataSource;", "()Z", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Metadata {
        @NotNull
        private final DataSource dataSource;
        private final boolean isPlaceholderMemoryCacheKeyPresent;
        private final boolean isSampled;
        @Nullable
        private final MemoryCache.Key memoryCacheKey;

        public Metadata(@Nullable MemoryCache.Key key, boolean z11, @NotNull DataSource dataSource2, boolean z12) {
            Intrinsics.checkNotNullParameter(dataSource2, "dataSource");
            this.memoryCacheKey = key;
            this.isSampled = z11;
            this.dataSource = dataSource2;
            this.isPlaceholderMemoryCacheKeyPresent = z12;
        }

        public static /* synthetic */ Metadata copy$default(Metadata metadata, MemoryCache.Key key, boolean z11, DataSource dataSource2, boolean z12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                key = metadata.memoryCacheKey;
            }
            if ((i11 & 2) != 0) {
                z11 = metadata.isSampled;
            }
            if ((i11 & 4) != 0) {
                dataSource2 = metadata.dataSource;
            }
            if ((i11 & 8) != 0) {
                z12 = metadata.isPlaceholderMemoryCacheKeyPresent;
            }
            return metadata.copy(key, z11, dataSource2, z12);
        }

        @Nullable
        public final MemoryCache.Key component1() {
            return this.memoryCacheKey;
        }

        public final boolean component2() {
            return this.isSampled;
        }

        @NotNull
        public final DataSource component3() {
            return this.dataSource;
        }

        public final boolean component4() {
            return this.isPlaceholderMemoryCacheKeyPresent;
        }

        @NotNull
        public final Metadata copy(@Nullable MemoryCache.Key key, boolean z11, @NotNull DataSource dataSource2, boolean z12) {
            Intrinsics.checkNotNullParameter(dataSource2, "dataSource");
            return new Metadata(key, z11, dataSource2, z12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Metadata)) {
                return false;
            }
            Metadata metadata = (Metadata) obj;
            return Intrinsics.areEqual((Object) this.memoryCacheKey, (Object) metadata.memoryCacheKey) && this.isSampled == metadata.isSampled && this.dataSource == metadata.dataSource && this.isPlaceholderMemoryCacheKeyPresent == metadata.isPlaceholderMemoryCacheKeyPresent;
        }

        @NotNull
        public final DataSource getDataSource() {
            return this.dataSource;
        }

        @Nullable
        public final MemoryCache.Key getMemoryCacheKey() {
            return this.memoryCacheKey;
        }

        public int hashCode() {
            MemoryCache.Key key = this.memoryCacheKey;
            int hashCode = (key == null ? 0 : key.hashCode()) * 31;
            boolean z11 = this.isSampled;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int hashCode2 = (((hashCode + (z11 ? 1 : 0)) * 31) + this.dataSource.hashCode()) * 31;
            boolean z13 = this.isPlaceholderMemoryCacheKeyPresent;
            if (!z13) {
                z12 = z13;
            }
            return hashCode2 + (z12 ? 1 : 0);
        }

        public final boolean isPlaceholderMemoryCacheKeyPresent() {
            return this.isPlaceholderMemoryCacheKeyPresent;
        }

        public final boolean isSampled() {
            return this.isSampled;
        }

        @NotNull
        public String toString() {
            return "Metadata(memoryCacheKey=" + this.memoryCacheKey + ", isSampled=" + this.isSampled + ", dataSource=" + this.dataSource + ", isPlaceholderMemoryCacheKeyPresent=" + this.isPlaceholderMemoryCacheKeyPresent + ')';
        }
    }

    private ImageResult() {
    }

    public /* synthetic */ ImageResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public abstract Drawable getDrawable();

    @NotNull
    public abstract ImageRequest getRequest();
}
