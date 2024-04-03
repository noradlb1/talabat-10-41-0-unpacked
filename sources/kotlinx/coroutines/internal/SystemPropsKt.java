package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return SystemPropsKt__SystemPropsKt.getAVAILABLE_PROCESSORS();
    }

    public static final int systemProp(@NotNull String str, int i11, int i12, int i13) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, i11, i12, i13);
    }

    public static final long systemProp(@NotNull String str, long j11, long j12, long j13) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, j11, j12, j13);
    }

    @Nullable
    public static final String systemProp(@NotNull String str) {
        return SystemPropsKt__SystemPropsKt.systemProp(str);
    }

    public static final boolean systemProp(@NotNull String str, boolean z11) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, z11);
    }
}
