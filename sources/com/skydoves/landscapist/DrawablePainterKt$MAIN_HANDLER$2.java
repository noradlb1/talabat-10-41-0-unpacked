package com.skydoves.landscapist;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/os/Handler;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DrawablePainterKt$MAIN_HANDLER$2 extends Lambda implements Function0<Handler> {
    public static final DrawablePainterKt$MAIN_HANDLER$2 INSTANCE = new DrawablePainterKt$MAIN_HANDLER$2();

    public DrawablePainterKt$MAIN_HANDLER$2() {
        super(0);
    }

    @NotNull
    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
