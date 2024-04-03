package org.koin.core.logger;

import java.io.PrintStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016¨\u0006\n"}, d2 = {"Lorg/koin/core/logger/PrintLogger;", "Lorg/koin/core/logger/Logger;", "level", "Lorg/koin/core/logger/Level;", "(Lorg/koin/core/logger/Level;)V", "log", "", "msg", "", "Lorg/koin/core/logger/MESSAGE;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PrintLogger extends Logger {
    public PrintLogger() {
        this((Level) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrintLogger(@NotNull Level level) {
        super(level);
        Intrinsics.checkNotNullParameter(level, "level");
    }

    public void log(@NotNull Level level, @NotNull String str) {
        PrintStream printStream;
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(str, "msg");
        if (getLevel().compareTo(level) <= 0) {
            if (level.compareTo(Level.ERROR) >= 0) {
                printStream = System.err;
            } else {
                printStream = System.out;
            }
            printStream.println('[' + level + "] [Koin] " + str);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PrintLogger(Level level, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Level.INFO : level);
    }
}
