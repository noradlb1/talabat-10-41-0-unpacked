package ae;

import android.view.ViewTreeObserver;
import android.view.animation.Animation;

public final /* synthetic */ class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.instabug.survey.ui.survey.rateus.a f50813b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Animation f50814c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Animation f50815d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Animation f50816e;

    public /* synthetic */ a(com.instabug.survey.ui.survey.rateus.a aVar, Animation animation, Animation animation2, Animation animation3) {
        this.f50813b = aVar;
        this.f50814c = animation;
        this.f50815d = animation2;
        this.f50816e = animation3;
    }

    public final void onGlobalLayout() {
        this.f50813b.a(this.f50814c, this.f50815d, this.f50816e);
    }
}
