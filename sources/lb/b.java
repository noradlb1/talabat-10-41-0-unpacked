package lb;

import com.instabug.apm.APM;
import com.instabug.library.apichecker.VoidRunnable;

public final /* synthetic */ class b implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f47136a;

    public /* synthetic */ b(boolean z11) {
        this.f47136a = z11;
    }

    public final void run() {
        APM.apmImplementation.e(this.f47136a);
    }
}
