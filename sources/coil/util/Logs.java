package coil.util;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\bø\u0001\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000b"}, d2 = {"log", "", "Lcoil/util/Logger;", "tag", "", "priority", "", "lazyMessage", "Lkotlin/Function0;", "throwable", "", "coil-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "-Logs")
/* renamed from: coil.util.-Logs  reason: invalid class name */
public final class Logs {
    public static final void log(@NotNull Logger logger, @NotNull String str, int i11, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (logger.getLevel() <= i11) {
            logger.log(str, i11, function0.invoke(), (Throwable) null);
        }
    }

    public static final void log(@NotNull Logger logger, @NotNull String str, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        if (logger.getLevel() <= 6) {
            logger.log(str, 6, (String) null, th2);
        }
    }
}
