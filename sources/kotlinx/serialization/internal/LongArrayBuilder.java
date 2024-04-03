package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\r\u0010\u0010\u001a\u00020\u0002H\u0010¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0010¢\u0006\u0002\b\u0014R\u000e\u0010\u0005\u001a\u00020\u0002X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/internal/LongArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([J)V", "buffer", "<set-?>", "", "position", "getPosition$kotlinx_serialization_core", "()I", "append", "", "c", "", "append$kotlinx_serialization_core", "build", "build$kotlinx_serialization_core", "ensureCapacity", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PublishedApi
public final class LongArrayBuilder extends PrimitiveArrayBuilder<long[]> {
    @NotNull
    private long[] buffer;
    private int position;

    public LongArrayBuilder(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "bufferWithData");
        this.buffer = jArr;
        this.position = jArr.length;
        ensureCapacity$kotlinx_serialization_core(10);
    }

    public final void append$kotlinx_serialization_core(long j11) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, (Object) null);
        long[] jArr = this.buffer;
        int position$kotlinx_serialization_core = getPosition$kotlinx_serialization_core();
        this.position = position$kotlinx_serialization_core + 1;
        jArr[position$kotlinx_serialization_core] = j11;
    }

    public void ensureCapacity$kotlinx_serialization_core(int i11) {
        long[] jArr = this.buffer;
        if (jArr.length < i11) {
            long[] copyOf = Arrays.copyOf(jArr, RangesKt___RangesKt.coerceAtLeast(i11, jArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.buffer = copyOf;
        }
    }

    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }

    @NotNull
    public long[] build$kotlinx_serialization_core() {
        long[] copyOf = Arrays.copyOf(this.buffer, getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
