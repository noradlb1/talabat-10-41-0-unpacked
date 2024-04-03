package k6;

import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import java.util.ArrayList;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f34514b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GraphRequestBatch f34515c;

    public /* synthetic */ o(ArrayList arrayList, GraphRequestBatch graphRequestBatch) {
        this.f34514b = arrayList;
        this.f34515c = graphRequestBatch;
    }

    public final void run() {
        GraphRequest.Companion.m8873runCallbacks$lambda2(this.f34514b, this.f34515c);
    }
}
