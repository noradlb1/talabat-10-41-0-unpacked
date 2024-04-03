package com.instabug.library.instacapture.screenshot.pixelcopy;

import android.os.Handler;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class i extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final i f34406a = new i();

    public i() {
        super(0);
    }

    @NotNull
    /* renamed from: a */
    public final Handler invoke() {
        return new Handler(k.f34408a.b().getLooper());
    }
}
