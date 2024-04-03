package xc;

import com.instabug.library.diagnostics.diagnostics_db.m;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f34828b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34829c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function1 f34830d;

    public /* synthetic */ a(m mVar, String str, Function1 function1) {
        this.f34828b = mVar;
        this.f34829c = str;
        this.f34830d = function1;
    }

    public final void run() {
        m.a(this.f34828b, this.f34829c, this.f34830d);
    }
}
