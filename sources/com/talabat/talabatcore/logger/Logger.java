package com.talabat.talabatcore.logger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcore/logger/Logger;", "", "debug", "", "message", "", "error", "throwable", "", "info", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Logger {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void debug(@NotNull Logger logger, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            System.out.println(str);
        }

        public static void error(@NotNull Logger logger, @Nullable Throwable th2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            System.out.println(th2 + " " + str);
        }

        public static /* synthetic */ void error$default(Logger logger, Throwable th2, String str, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    th2 = null;
                }
                if ((i11 & 2) != 0) {
                    str = "";
                }
                logger.error(th2, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }

        public static void info(@NotNull Logger logger, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            System.out.println(str);
        }
    }

    void debug(@NotNull String str);

    void error(@Nullable Throwable th2, @NotNull String str);

    void info(@NotNull String str);
}
