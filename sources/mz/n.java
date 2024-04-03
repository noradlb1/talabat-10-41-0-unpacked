package mz;

import com.uxcam.internals.eh;
import com.uxcam.internals.ei;
import com.uxcam.internals.fu;
import com.uxcam.internals.fv;
import java.util.List;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ fu f23981b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f23982c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ fv f23983d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ eh f23984e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ei f23985f;

    public /* synthetic */ n(fu fuVar, List list, fv fvVar, eh ehVar, ei eiVar) {
        this.f23981b = fuVar;
        this.f23982c = list;
        this.f23983d = fvVar;
        this.f23984e = ehVar;
        this.f23985f = eiVar;
    }

    public final void run() {
        this.f23981b.a(this.f23982c, this.f23983d, this.f23984e, this.f23985f);
    }
}
