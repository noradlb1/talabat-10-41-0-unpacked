package com.instabug.library.instacapture.screenshot.pixelcopy;

import android.os.HandlerThread;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class j extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final j f34407a = new j();

    public j() {
        super(0);
    }

    @NotNull
    /* renamed from: a */
    public final HandlerThread invoke() {
        HandlerThread handlerThread = new HandlerThread("PixelCopy");
        handlerThread.start();
        return handlerThread;
    }
}
