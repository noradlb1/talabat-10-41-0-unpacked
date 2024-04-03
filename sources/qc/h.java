package qc;

import android.graphics.Bitmap;
import com.instabug.library.Instabug;
import com.instabug.library.apichecker.VoidRunnable;

public final /* synthetic */ class h implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap f50754a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bitmap f50755b;

    public /* synthetic */ h(Bitmap bitmap, Bitmap bitmap2) {
        this.f50754a = bitmap;
        this.f50755b = bitmap2;
    }

    public final void run() {
        Instabug.lambda$setCustomBrandingImage$8(this.f50754a, this.f50755b);
    }
}
