package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, d2 = {"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/internal/SystemPropsKt")
final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final boolean systemProp(@NotNull String str, boolean z11) {
        String systemProp = SystemPropsKt.systemProp(str);
        return systemProp != null ? Boolean.parseBoolean(systemProp) : z11;
    }

    public static /* synthetic */ int systemProp$default(String str, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i12 = 1;
        }
        if ((i14 & 8) != 0) {
            i13 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, i11, i12, i13);
    }

    public static final int systemProp(@NotNull String str, int i11, int i12, int i13) {
        return (int) SystemPropsKt.systemProp(str, (long) i11, (long) i12, (long) i13);
    }

    public static /* synthetic */ long systemProp$default(String str, long j11, long j12, long j13, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            j12 = 1;
        }
        long j14 = j12;
        if ((i11 & 8) != 0) {
            j13 = Long.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, j11, j14, j13);
    }

    public static final long systemProp(@NotNull String str, long j11, long j12, long j13) {
        String systemProp = SystemPropsKt.systemProp(str);
        if (systemProp == null) {
            return j11;
        }
        Long longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(systemProp);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            boolean z11 = false;
            if (j12 <= longValue && longValue <= j13) {
                z11 = true;
            }
            if (z11) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j12 + ".." + j13 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + systemProp + '\'').toString());
    }
}
