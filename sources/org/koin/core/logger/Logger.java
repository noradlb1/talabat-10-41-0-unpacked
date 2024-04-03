package org.koin.core.logger;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eJ\u001c\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0002J\u0012\u0010\u0010\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eJ\u0012\u0010\u0011\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003J\u001c\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0015J\u001c\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\f\u001a\u00060\rj\u0002`\u000eH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0016"}, d2 = {"Lorg/koin/core/logger/Logger;", "", "level", "Lorg/koin/core/logger/Level;", "(Lorg/koin/core/logger/Level;)V", "getLevel", "()Lorg/koin/core/logger/Level;", "setLevel", "canLog", "", "debug", "", "msg", "", "Lorg/koin/core/logger/MESSAGE;", "doLog", "error", "info", "isAt", "lvl", "log", "Lkotlin/Function0;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class Logger {
    @NotNull
    private Level level;

    public Logger() {
        this((Level) null, 1, (DefaultConstructorMarker) null);
    }

    public Logger(@NotNull Level level2) {
        Intrinsics.checkNotNullParameter(level2, "level");
        this.level = level2;
    }

    private final boolean canLog(Level level2) {
        return this.level.compareTo(level2) <= 0;
    }

    private final void doLog(Level level2, String str) {
        if (canLog(level2)) {
            log(level2, str);
        }
    }

    public final void debug(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        doLog(Level.DEBUG, str);
    }

    public final void error(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        doLog(Level.ERROR, str);
    }

    @NotNull
    public final Level getLevel() {
        return this.level;
    }

    public final void info(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        doLog(Level.INFO, str);
    }

    public final boolean isAt(@NotNull Level level2) {
        Intrinsics.checkNotNullParameter(level2, "lvl");
        if (this.level.compareTo(level2) <= 0) {
            return true;
        }
        return false;
    }

    public abstract void log(@NotNull Level level2, @NotNull String str);

    public final void log(@NotNull Level level2, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(level2, "lvl");
        Intrinsics.checkNotNullParameter(function0, "msg");
        if (isAt(level2)) {
            doLog(level2, function0.invoke());
        }
    }

    public final void setLevel(@NotNull Level level2) {
        Intrinsics.checkNotNullParameter(level2, "<set-?>");
        this.level = level2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Logger(Level level2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Level.INFO : level2);
    }
}
