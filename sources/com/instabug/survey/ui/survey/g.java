package com.instabug.survey.ui.survey;

import com.instabug.library.util.AccessibilityUtils;
import com.instabug.survey.ui.survey.text.b;
import com.instabug.survey.utils.c;

class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f52552b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f52553c;

    public g(l lVar, int i11) {
        this.f52553c = lVar;
        this.f52552b = i11;
    }

    public void run() {
        if (this.f52553c.f52560d != null) {
            l lVar = this.f52553c;
            if (lVar.G != null && lVar.f52560d.getCount() > this.f52552b) {
                boolean isAccessibilityServiceEnabled = AccessibilityUtils.isAccessibilityServiceEnabled();
                a a11 = this.f52553c.f52560d.getItem(this.f52552b);
                if ((a11 instanceof b) && !isAccessibilityServiceEnabled) {
                    ((b) a11).i();
                } else if (this.f52553c.G.isStoreRatingSurvey() && this.f52553c.G.getQuestions().size() > this.f52552b && this.f52553c.G.getQuestions().get(this.f52552b).f() == 0 && this.f52553c.f52563h && !isAccessibilityServiceEnabled) {
                    ((b) this.f52553c.f52560d.getItem(this.f52552b)).i();
                    boolean unused = this.f52553c.f52563h = false;
                } else if (this.f52553c.getActivity() != null) {
                    c.a(this.f52553c.getActivity());
                }
            }
        }
    }
}
