package t5;

import androidx.fragment.app.Fragment;
import com.deliveryhero.performance.core.tapresponse.OnViewUpdateRunner;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f34682b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f34683c;

    public /* synthetic */ b(Fragment fragment, Function1 function1) {
        this.f34682b = fragment;
        this.f34683c = function1;
    }

    public final void run() {
        OnViewUpdateRunner.m8239runOnViewsUpdated$lambda0(this.f34682b, this.f34683c);
    }
}
