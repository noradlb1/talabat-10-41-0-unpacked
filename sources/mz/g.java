package mz;

import android.app.Activity;
import android.graphics.Bitmap;
import com.uxcam.internals.eh;
import com.uxcam.internals.fm;
import com.uxcam.internals.fu;

public final /* synthetic */ class g implements eh {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f23962a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ fu f23963b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ eh f23964c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f23965d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f23966e;

    public /* synthetic */ g(Activity activity, fu fuVar, eh ehVar, int i11, boolean z11) {
        this.f23962a = activity;
        this.f23963b = fuVar;
        this.f23964c = ehVar;
        this.f23965d = i11;
        this.f23966e = z11;
    }

    public final void a(Bitmap bitmap) {
        fm.a(this.f23962a, this.f23963b, this.f23964c, this.f23965d, this.f23966e, bitmap);
    }
}
