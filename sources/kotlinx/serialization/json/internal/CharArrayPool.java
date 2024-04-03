package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/serialization/json/internal/CharArrayPool;", "", "()V", "MAX_CHARS_IN_POOL", "", "arrays", "Lkotlin/collections/ArrayDeque;", "", "charsTotal", "release", "", "array", "take", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CharArrayPool {
    @NotNull
    public static final CharArrayPool INSTANCE = new CharArrayPool();
    private static final int MAX_CHARS_IN_POOL;
    @NotNull
    private static final ArrayDeque<char[]> arrays = new ArrayDeque<>();
    private static int charsTotal;

    static {
        Object obj;
        int i11;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            obj = Result.m6329constructorimpl(StringsKt__StringNumberConversionsKt.toIntOrNull(property));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = 1048576;
        }
        MAX_CHARS_IN_POOL = i11;
    }

    private CharArrayPool() {
    }

    public final void release(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "array");
        synchronized (this) {
            int i11 = charsTotal;
            if (cArr.length + i11 < MAX_CHARS_IN_POOL) {
                charsTotal = i11 + cArr.length;
                arrays.addLast(cArr);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final char[] take() {
        char[] removeLastOrNull;
        synchronized (this) {
            removeLastOrNull = arrays.removeLastOrNull();
            if (removeLastOrNull != null) {
                charsTotal -= removeLastOrNull.length;
            } else {
                removeLastOrNull = null;
            }
        }
        if (removeLastOrNull == null) {
            return new char[128];
        }
        return removeLastOrNull;
    }
}
