package mz;

import android.content.Context;
import com.uxcam.internals.hb;
import com.uxcam.internals.ib;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ hb f23951b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ib f23952c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f23953d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f23954e;

    public /* synthetic */ d0(hb hbVar, ib ibVar, Context context, CountDownLatch countDownLatch) {
        this.f23951b = hbVar;
        this.f23952c = ibVar;
        this.f23953d = context;
        this.f23954e = countDownLatch;
    }

    public final void run() {
        this.f23951b.a(this.f23952c, this.f23953d, this.f23954e);
    }
}
