package a3;

import android.graphics.Bitmap;
import coil.bitmap.RealBitmapReferenceCounter;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RealBitmapReferenceCounter f35598b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f35599c;

    public /* synthetic */ b(RealBitmapReferenceCounter realBitmapReferenceCounter, Bitmap bitmap) {
        this.f35598b = realBitmapReferenceCounter;
        this.f35599c = bitmap;
    }

    public final void run() {
        RealBitmapReferenceCounter.m9132decrement$lambda4(this.f35598b, this.f35599c);
    }
}
