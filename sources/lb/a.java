package lb;

import com.instabug.apm.APM;
import com.instabug.apm.model.e;
import com.instabug.library.apichecker.VoidRunnable;

public final /* synthetic */ class a implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f47134a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f47135b;

    public /* synthetic */ a(Class cls, e eVar) {
        this.f47134a = cls;
        this.f47135b = eVar;
    }

    public final void run() {
        APM.apmImplementation.a(this.f47134a, this.f47135b);
    }
}
