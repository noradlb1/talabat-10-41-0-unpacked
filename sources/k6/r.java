package k6;

import com.facebook.GraphRequestBatch;
import com.facebook.ProgressOutputStream;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GraphRequestBatch.Callback f34518b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ProgressOutputStream f34519c;

    public /* synthetic */ r(GraphRequestBatch.Callback callback, ProgressOutputStream progressOutputStream) {
        this.f34518b = callback;
        this.f34519c = progressOutputStream;
    }

    public final void run() {
        ProgressOutputStream.m8874reportBatchProgress$lambda0(this.f34518b, this.f34519c);
    }
}
