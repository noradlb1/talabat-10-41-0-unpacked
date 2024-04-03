package com.instabug.survey.ui.survey;

import androidx.viewpager.widget.ViewPager;
import com.instabug.survey.models.Survey;
import com.instabug.survey.ui.h;

class f implements ViewPager.OnPageChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Survey f52550b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f52551c;

    public f(l lVar, Survey survey) {
        this.f52551c = lVar;
        this.f52550b = survey;
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
    }

    public void onPageSelected(int i11) {
        l lVar = this.f52551c;
        lVar.J = i11;
        if (lVar.getActivity() != null && (this.f52551c.getActivity() instanceof h)) {
            ((h) this.f52551c.getActivity()).onPageSelected(i11);
        }
        this.f52551c.a(i11, this.f52550b);
        this.f52551c.e(i11);
        this.f52551c.g();
        this.f52551c.d(i11);
        this.f52551c.c(i11);
    }
}
