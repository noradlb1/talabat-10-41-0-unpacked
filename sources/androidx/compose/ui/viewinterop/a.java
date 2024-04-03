package androidx.compose.ui.viewinterop;

import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f10336b;

    public /* synthetic */ a(Function0 function0) {
        this.f10336b = function0;
    }

    public final void run() {
        AndroidViewHolder$onCommitAffectingUpdate$1.m5716invoke$lambda0(this.f10336b);
    }
}
