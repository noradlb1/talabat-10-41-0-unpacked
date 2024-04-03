package androidx.paging;

import androidx.annotation.IntRange;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bBA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/paging/PagingConfig;", "", "pageSize", "", "prefetchDistance", "enablePlaceholders", "", "initialLoadSize", "maxSize", "jumpThreshold", "(IIZIII)V", "Companion", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PagingConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_INITIAL_PAGE_MULTIPLIER = 3;
    public static final int MAX_SIZE_UNBOUNDED = Integer.MAX_VALUE;
    @JvmField
    public final boolean enablePlaceholders;
    @JvmField
    public final int initialLoadSize;
    @JvmField
    public final int jumpThreshold;
    @JvmField
    public final int maxSize;
    @JvmField
    public final int pageSize;
    @JvmField
    public final int prefetchDistance;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XT¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\u0007"}, d2 = {"Landroidx/paging/PagingConfig$Companion;", "", "()V", "DEFAULT_INITIAL_PAGE_MULTIPLIER", "", "MAX_SIZE_UNBOUNDED", "getMAX_SIZE_UNBOUNDED$annotations", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getMAX_SIZE_UNBOUNDED$annotations() {
        }
    }

    @JvmOverloads
    public PagingConfig(int i11) {
        this(i11, 0, false, 0, 0, 0, 62, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PagingConfig(int i11, @IntRange(from = 0) int i12) {
        this(i11, i12, false, 0, 0, 0, 60, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PagingConfig(int i11, @IntRange(from = 0) int i12, boolean z11) {
        this(i11, i12, z11, 0, 0, 0, 56, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PagingConfig(int i11, @IntRange(from = 0) int i12, boolean z11, @IntRange(from = 1) int i13) {
        this(i11, i12, z11, i13, 0, 0, 48, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PagingConfig(int i11, @IntRange(from = 0) int i12, boolean z11, @IntRange(from = 1) int i13, @IntRange(from = 2) int i14) {
        this(i11, i12, z11, i13, i14, 0, 32, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PagingConfig(int i11, @IntRange(from = 0) int i12, boolean z11, @IntRange(from = 1) int i13, @IntRange(from = 2) int i14, int i15) {
        this.pageSize = i11;
        this.prefetchDistance = i12;
        this.enablePlaceholders = z11;
        this.initialLoadSize = i13;
        this.maxSize = i14;
        this.jumpThreshold = i15;
        if (!z11 && i12 == 0) {
            throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in PagingData, so either placeholders must be enabled, or prefetch distance must be > 0.");
        } else if (i14 == Integer.MAX_VALUE || i14 >= (i12 * 2) + i11) {
            if (!(i15 == Integer.MIN_VALUE || i15 > 0)) {
                throw new IllegalArgumentException("jumpThreshold must be positive to enable jumps or COUNT_UNDEFINED to disable jumping.".toString());
            }
        } else {
            throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist" + ", pageSize=" + i11 + ", prefetchDist=" + i12 + ", maxSize=" + i14);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagingConfig(int i11, int i12, boolean z11, int i13, int i14, int i15, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i16 & 2) != 0 ? i11 : i12, (i16 & 4) != 0 ? true : z11, (i16 & 8) != 0 ? i11 * 3 : i13, (i16 & 16) != 0 ? Integer.MAX_VALUE : i14, (i16 & 32) != 0 ? Integer.MIN_VALUE : i15);
    }
}
