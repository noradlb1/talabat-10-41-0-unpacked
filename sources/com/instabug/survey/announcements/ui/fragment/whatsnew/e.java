package com.instabug.survey.announcements.ui.fragment.whatsnew;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.survey.announcements.models.c;
import com.instabug.survey.ui.gestures.a;
import com.instabug.survey.ui.gestures.b;
import com.instabug.survey.ui.gestures.d;

public class e extends BasePresenter implements d, a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private GestureDetector f52304a;

    public e(a aVar) {
        super(aVar);
    }

    private void a() {
        a aVar = (a) this.f34200f.get();
        if (aVar != null) {
            aVar.c();
        }
    }

    public void a(View view, MotionEvent motionEvent) {
        com.instabug.survey.ui.gestures.e.a(view, motionEvent, (d) this);
        if (this.f52304a == null) {
            this.f52304a = new GestureDetector(view.getContext(), new b(this));
        }
        this.f52304a.onTouchEvent(motionEvent);
    }

    public void a(c cVar) {
        a aVar = (a) this.f34200f.get();
        if (aVar != null) {
            cVar.k();
            aVar.a(cVar);
        }
    }

    public void b() {
    }

    public void c() {
        a();
    }

    public void d() {
    }

    public void e() {
        a aVar = (a) this.f34200f.get();
        if (aVar != null) {
            aVar.c();
        }
    }

    public void f() {
    }

    public void g() {
    }
}
