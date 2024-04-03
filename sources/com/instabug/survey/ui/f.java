package com.instabug.survey.ui;

import androidx.fragment.app.Fragment;
import com.instabug.survey.ui.gestures.a;
import com.instabug.survey.ui.survey.l;

class f implements a {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f52504b;

    public f(g gVar) {
        this.f52504b = gVar;
    }

    public void b() {
        for (Fragment next : this.f52504b.getSupportFragmentManager().getFragments()) {
            if (next instanceof com.instabug.survey.ui.survey.a) {
                com.instabug.survey.ui.survey.a aVar = (com.instabug.survey.ui.survey.a) next;
                if (aVar.h()) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
    }

    public void c() {
    }

    public void d() {
        for (Fragment next : this.f52504b.getSupportFragmentManager().getFragments()) {
            if (next instanceof l) {
                ((l) next).q();
                return;
            }
        }
    }

    public void f() {
    }

    public void g() {
        for (Fragment next : this.f52504b.getSupportFragmentManager().getFragments()) {
            if (next instanceof l) {
                if (this.f52504b.f34199i != null) {
                    ((l) this.f52504b.f34199i).a(n.PRIMARY, true);
                }
                ((l) next).p();
                return;
            }
        }
    }
}
