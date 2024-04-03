package com.talabat.talabatcommon.extentions;

import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "logTag", "", "logMessage", "throwable", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ThrowablesKt$log$1 extends Lambda implements Function3<String, String, Throwable, Unit> {
    public static final ThrowablesKt$log$1 INSTANCE = new ThrowablesKt$log$1();

    public ThrowablesKt$log$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (String) obj2, (Throwable) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @Nullable String str2, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "logTag");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        LogManager.error(th2, str + ": " + str2);
    }
}
