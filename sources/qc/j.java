package qc;

import androidx.core.content.ContextCompat;
import com.instabug.library.Instabug;
import com.instabug.library.annotation.utility.b;
import com.instabug.library.apichecker.VoidRunnable;

public final /* synthetic */ class j implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50758a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f50759b;

    public /* synthetic */ j(int i11, int i12) {
        this.f50758a = i11;
        this.f50759b = i12;
    }

    public final void run() {
        Instabug.setCustomBrandingImage(b.a(ContextCompat.getDrawable(Instabug.appContext, this.f50758a)), b.a(ContextCompat.getDrawable(Instabug.appContext, this.f50759b)));
    }
}
