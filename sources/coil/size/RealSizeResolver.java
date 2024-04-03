package coil.size;

import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0011\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcoil/size/RealSizeResolver;", "Lcoil/size/SizeResolver;", "size", "Lcoil/size/Size;", "(Lcoil/size/Size;)V", "equals", "", "other", "", "hashCode", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealSizeResolver implements SizeResolver {
    @NotNull
    private final Size size;

    public RealSizeResolver(@NotNull Size size2) {
        Intrinsics.checkNotNullParameter(size2, BindingAdaptersKt.QUERY_SIZE);
        this.size = size2;
    }

    public boolean equals(@Nullable Object obj) {
        return this == obj || ((obj instanceof RealSizeResolver) && Intrinsics.areEqual((Object) this.size, (Object) ((RealSizeResolver) obj).size));
    }

    public int hashCode() {
        return this.size.hashCode();
    }

    @Nullable
    public Object size(@NotNull Continuation<? super Size> continuation) {
        return this.size;
    }

    @NotNull
    public String toString() {
        return "RealSizeResolver(size=" + this.size + ')';
    }
}
