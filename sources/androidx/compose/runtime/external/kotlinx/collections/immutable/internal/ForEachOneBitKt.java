package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u000226\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0004H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"forEachOneBit", "", "", "body", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "mask", "index", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ForEachOneBitKt {
    public static final void forEachOneBit(int i11, @NotNull Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        int i12 = 0;
        while (i11 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i11);
            function2.invoke(Integer.valueOf(lowestOneBit), Integer.valueOf(i12));
            i12++;
            i11 ^= lowestOneBit;
        }
    }
}
