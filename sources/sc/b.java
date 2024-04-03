package sc;

import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.ReturnableRunnable;

public final /* synthetic */ class b implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReturnableRunnable f34670a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f34672c;

    public /* synthetic */ b(ReturnableRunnable returnableRunnable, String str, Object obj) {
        this.f34670a = returnableRunnable;
        this.f34671b = str;
        this.f34672c = obj;
    }

    public final Object run() {
        return APIChecker.lambda$checkAndGet$0(this.f34670a, this.f34671b, this.f34672c);
    }
}
