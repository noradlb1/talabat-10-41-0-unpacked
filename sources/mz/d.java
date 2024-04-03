package mz;

import android.view.PixelCopy;
import com.uxcam.internals.cd;
import com.uxcam.internals.en;
import com.uxcam.internals.eo;

public final /* synthetic */ class d implements PixelCopy.OnPixelCopyFinishedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ eo f23948a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cd f23949b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ en f23950c;

    public /* synthetic */ d(eo eoVar, cd cdVar, en enVar) {
        this.f23948a = eoVar;
        this.f23949b = cdVar;
        this.f23950c = enVar;
    }

    public final void onPixelCopyFinished(int i11) {
        this.f23948a.a(this.f23949b, this.f23950c, i11);
    }
}
