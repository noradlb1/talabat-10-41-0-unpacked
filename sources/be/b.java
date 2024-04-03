package be;

import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import com.instabug.survey.ui.survey.thankspage.a;

public final /* synthetic */ class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f50837b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Animation f50838c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Animation f50839d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Animation f50840e;

    public /* synthetic */ b(a aVar, Animation animation, Animation animation2, Animation animation3) {
        this.f50837b = aVar;
        this.f50838c = animation;
        this.f50839d = animation2;
        this.f50840e = animation3;
    }

    public final void onGlobalLayout() {
        this.f50837b.a(this.f50838c, this.f50839d, this.f50840e);
    }
}
