package de;

import com.instabug.terminations.z;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f56695b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function2 f56696c;

    public /* synthetic */ c(z zVar, Function2 function2) {
        this.f56695b = zVar;
        this.f56696c = function2;
    }

    public final void run() {
        z.a(this.f56695b, this.f56696c);
    }
}
