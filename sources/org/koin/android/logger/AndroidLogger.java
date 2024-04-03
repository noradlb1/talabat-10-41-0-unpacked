package org.koin.android.logger;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.logger.LoggerKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u001c\u0010\n\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u000b"}, d2 = {"Lorg/koin/android/logger/AndroidLogger;", "Lorg/koin/core/logger/Logger;", "level", "Lorg/koin/core/logger/Level;", "(Lorg/koin/core/logger/Level;)V", "log", "", "msg", "", "Lorg/koin/core/logger/MESSAGE;", "logOnLevel", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AndroidLogger extends Logger {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Level.values().length];
            iArr[Level.DEBUG.ordinal()] = 1;
            iArr[Level.INFO.ordinal()] = 2;
            iArr[Level.ERROR.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AndroidLogger() {
        this((Level) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidLogger(@NotNull Level level) {
        super(level);
        Intrinsics.checkNotNullParameter(level, "level");
    }

    private final void logOnLevel(String str, Level level) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
        if (i11 == 1) {
            return;
        }
        if (i11 == 2) {
            Log.i(LoggerKt.KOIN_TAG, str);
        } else if (i11 != 3) {
            Log.e(LoggerKt.KOIN_TAG, str);
        } else {
            Log.e(LoggerKt.KOIN_TAG, str);
        }
    }

    public void log(@NotNull Level level, @NotNull String str) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(str, "msg");
        if (getLevel().compareTo(level) <= 0) {
            logOnLevel(str, level);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidLogger(Level level, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Level.INFO : level);
    }
}
