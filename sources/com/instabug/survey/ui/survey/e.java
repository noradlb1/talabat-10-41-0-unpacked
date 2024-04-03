package com.instabug.survey.ui.survey;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.instabug.survey.ui.survey.rateus.a;

class e extends ViewPager.SimpleOnPageChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f52549b;

    public e(l lVar) {
        this.f52549b = lVar;
    }

    public void onPageSelected(int i11) {
        Fragment fragment = (Fragment) this.f52549b.K.get(i11);
        if (fragment instanceof a) {
            ((a) fragment).k();
        }
        super.onPageSelected(i11);
    }
}
