package com.instabug.featuresrequest.ui.base.featureslist;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import com.instabug.featuresrequest.models.d;
import com.instabug.featuresrequest.ui.custom.IbFrRippleView;
import com.rd.animation.type.ColorAnimation;

class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f46627b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f46628c;

    public c(e eVar, d dVar) {
        this.f46628c = eVar;
        this.f46627b = dVar;
    }

    @SuppressLint({"STARVATION"})
    public void onClick(View view) {
        if (this.f46627b.p()) {
            d dVar = this.f46627b;
            dVar.b(dVar.i() - 1);
            this.f46627b.a(false);
            this.f46628c.a(Boolean.valueOf(this.f46627b.p()));
            ((IbFrRippleView) view).setRippleColor(Color.parseColor("#888888"));
            this.f46628c.f46638i.a(this.f46627b);
            return;
        }
        this.f46627b.a(true);
        d dVar2 = this.f46627b;
        dVar2.b(dVar2.i() + 1);
        ((IbFrRippleView) view).setRippleColor(Color.parseColor(ColorAnimation.DEFAULT_SELECTED_COLOR));
        this.f46628c.a(Boolean.valueOf(this.f46627b.p()));
        this.f46628c.f46638i.c(this.f46627b);
    }
}
