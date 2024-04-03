package xc;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.diagnostics.diagnostics_db.m;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f34831a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34832b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f34833c;

    public /* synthetic */ b(m mVar, String str, Function1 function1) {
        this.f34831a = mVar;
        this.f34832b = str;
        this.f34833c = function1;
    }

    public final Object run() {
        return m.b(this.f34831a, this.f34832b, this.f34833c);
    }
}
