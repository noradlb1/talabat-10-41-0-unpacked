package com.instabug.library.invocation.invoker;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.instabug.library.R;
import com.instabug.library.internal.view.floatingactionbutton.i;

public class n extends i {
    public final /* synthetic */ p B;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private GestureDetector f51356q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private m f51357r;

    /* renamed from: s  reason: collision with root package name */
    private long f51358s;

    /* renamed from: t  reason: collision with root package name */
    private float f51359t;

    /* renamed from: u  reason: collision with root package name */
    private float f51360u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f51361v = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(p pVar, Activity activity) {
        super(activity);
        this.B = pVar;
        this.f51356q = new GestureDetector(activity, new o());
        this.f51357r = new m(this, (d) null);
        setId(R.id.instabug_floating_button);
    }

    /* access modifiers changed from: private */
    public void d() {
        int i11;
        int i12;
        if (this.B.f51364c >= this.B.f51366e / 2) {
            i11 = this.B.f51381t;
        } else {
            i11 = this.B.f51380s;
        }
        if (this.B.E && this.B.D != null && this.B.D.get() != null) {
            p pVar = this.B;
            i12 = pVar.a((Activity) pVar.D.get());
            if (this.B.f51365d < (this.B.f51367f - i12) / 2) {
                i12 = this.B.f51382u;
            }
        } else if (this.B.f51365d >= this.B.f51367f / 2) {
            i12 = this.B.f51383v;
        } else {
            i12 = this.B.f51382u;
        }
        m mVar = this.f51357r;
        if (mVar != null) {
            mVar.a((float) i11, (float) i12);
        }
    }

    public void l(float f11, float f12) {
        if (((float) this.B.f51365d) + f12 > 50.0f) {
            m((int) (((float) this.B.f51364c) + f11), (int) (((float) this.B.f51365d) + f12));
            this.B.m();
            if (this.B.f51373l && this.B.a(f11, f12)) {
                this.B.b();
            }
            this.B.j();
        }
        if (!this.f51361v && this.B.f51362a != null && Math.abs(this.B.f51362a.rightMargin) < 50 && Math.abs(this.B.f51362a.topMargin - (getContext().getResources().getDisplayMetrics().heightPixels / 2)) < 250) {
            d();
        }
    }

    public void m(int i11, int i12) {
        int unused = this.B.f51364c = i11;
        int unused2 = this.B.f51365d = i12;
        if (this.B.f51362a != null) {
            this.B.f51362a.leftMargin = this.B.f51364c;
            this.B.f51362a.rightMargin = this.B.f51366e - this.B.f51364c;
            if (this.B.f51369h == 2 && this.B.f51368g > this.B.f51366e) {
                this.B.f51362a.rightMargin = (int) (((float) this.B.f51362a.rightMargin) + (this.B.f51370i * 48.0f));
            }
            this.B.f51362a.topMargin = this.B.f51365d;
            this.B.f51362a.bottomMargin = this.B.f51367f - this.B.f51365d;
            setLayoutParams(this.B.f51362a);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        GestureDetector gestureDetector = this.f51356q;
        if (gestureDetector != null) {
            z11 = gestureDetector.onTouchEvent(motionEvent);
        } else {
            z11 = false;
        }
        if (z11) {
            d();
        } else {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f51358s = System.currentTimeMillis();
                m mVar = this.f51357r;
                if (mVar != null) {
                    mVar.a();
                }
                this.f51361v = true;
            } else if (action == 1) {
                if (System.currentTimeMillis() - this.f51358s < 200) {
                    performClick();
                }
                this.f51361v = false;
                d();
            } else if (action == 2 && this.f51361v) {
                l(rawX - this.f51359t, rawY - this.f51360u);
            }
            this.f51359t = rawX;
            this.f51360u = rawY;
        }
        return true;
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        FrameLayout.LayoutParams unused = this.B.f51362a = (FrameLayout.LayoutParams) layoutParams;
        super.setLayoutParams(layoutParams);
    }
}
