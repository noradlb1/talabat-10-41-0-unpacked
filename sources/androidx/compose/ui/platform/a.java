package androidx.compose.ui.platform;

import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f10111b;

    public /* synthetic */ a(Function0 function0) {
        this.f10111b = function0;
    }

    public final void run() {
        AndroidComposeView$snapshotObserver$1.m4811invoke$lambda0(this.f10111b);
    }
}
