package cd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.sharedpreferences.a;
import java.util.Set;

public final /* synthetic */ class g implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Set f50882a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f50883b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50884c;

    public /* synthetic */ g(Set set, a aVar, String str) {
        this.f50882a = set;
        this.f50883b = aVar;
        this.f50884c = str;
    }

    public final Object run() {
        return a.a(this.f50882a, this.f50883b, this.f50884c);
    }
}
