package mz;

import android.graphics.Bitmap;
import com.uxcam.internals.cj;
import com.uxcam.internals.cl;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f23940b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f23941c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ cj f23942d;

    public /* synthetic */ a(float f11, Bitmap bitmap, cj cjVar) {
        this.f23940b = f11;
        this.f23941c = bitmap;
        this.f23942d = cjVar;
    }

    public final void run() {
        cl.a(this.f23940b, this.f23941c, this.f23942d);
    }
}
