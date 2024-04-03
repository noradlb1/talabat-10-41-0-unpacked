package coil.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import coil.collection.LinkedMultimap;
import coil.util.Bitmaps;
import coil.util.Utils;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(19)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J$\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcoil/bitmap/SizeStrategy;", "Lcoil/bitmap/BitmapPoolStrategy;", "()V", "entries", "Lcoil/collection/LinkedMultimap;", "", "Landroid/graphics/Bitmap;", "sizes", "Ljava/util/TreeMap;", "decrementSize", "", "size", "get", "width", "height", "config", "Landroid/graphics/Bitmap$Config;", "put", "bitmap", "removeLast", "stringify", "", "toString", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@VisibleForTesting
public final class SizeStrategy implements BitmapPoolStrategy {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_SIZE_MULTIPLE = 4;
    @NotNull
    private final LinkedMultimap<Integer, Bitmap> entries = new LinkedMultimap<>();
    @NotNull
    private final TreeMap<Integer, Integer> sizes = new TreeMap<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/bitmap/SizeStrategy$Companion;", "", "()V", "MAX_SIZE_MULTIPLE", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void decrementSize(int i11) {
        int intValue = ((Number) MapsKt__MapsKt.getValue(this.sizes, Integer.valueOf(i11))).intValue();
        if (intValue == 1) {
            this.sizes.remove(Integer.valueOf(i11));
        } else {
            this.sizes.put(Integer.valueOf(i11), Integer.valueOf(intValue - 1));
        }
    }

    @Nullable
    public Bitmap get(@Px int i11, @Px int i12, @NotNull Bitmap.Config config) {
        boolean z11;
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        int calculateAllocationByteCount = Utils.INSTANCE.calculateAllocationByteCount(i11, i12, config);
        Integer ceilingKey = this.sizes.ceilingKey(Integer.valueOf(calculateAllocationByteCount));
        if (ceilingKey != null) {
            if (ceilingKey.intValue() <= calculateAllocationByteCount * 4) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                ceilingKey = null;
            }
            if (ceilingKey != null) {
                calculateAllocationByteCount = ceilingKey.intValue();
            }
        }
        Bitmap removeLast = this.entries.removeLast(Integer.valueOf(calculateAllocationByteCount));
        if (removeLast != null) {
            decrementSize(calculateAllocationByteCount);
            removeLast.reconfigure(i11, i12, config);
        }
        return removeLast;
    }

    public void put(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int allocationByteCountCompat = Bitmaps.getAllocationByteCountCompat(bitmap);
        this.entries.put(Integer.valueOf(allocationByteCountCompat), bitmap);
        Integer num = this.sizes.get(Integer.valueOf(allocationByteCountCompat));
        TreeMap<Integer, Integer> treeMap = this.sizes;
        Integer valueOf = Integer.valueOf(allocationByteCountCompat);
        int i11 = 1;
        if (num != null) {
            i11 = 1 + num.intValue();
        }
        treeMap.put(valueOf, Integer.valueOf(i11));
    }

    @Nullable
    public Bitmap removeLast() {
        Bitmap removeLast = this.entries.removeLast();
        if (removeLast != null) {
            decrementSize(removeLast.getAllocationByteCount());
        }
        return removeLast;
    }

    @NotNull
    public String stringify(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(Bitmaps.getAllocationByteCountCompat(bitmap));
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    @NotNull
    public String toString() {
        return "SizeStrategy: entries=" + this.entries + ", sizes=" + this.sizes;
    }

    @NotNull
    public String stringify(@Px int i11, @Px int i12, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(Utils.INSTANCE.calculateAllocationByteCount(i11, i12, config));
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }
}
