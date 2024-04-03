package com.instabug.survey.ui;

import androidx.fragment.app.Fragment;
import com.instabug.library.util.InstabugSDKLogger;

class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f52501b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f52502c;

    public d(g gVar, Fragment fragment) {
        this.f52502c = gVar;
        this.f52501b = fragment;
    }

    public void run() {
        try {
            this.f52502c.b(this.f52501b);
        } catch (Exception e11) {
            this.f52502c.getSupportFragmentManager().popBackStack();
            this.f52502c.finish();
            InstabugSDKLogger.e("IBG-Surveys", "Fragment couldn't save it's state due to: " + e11.getMessage());
        }
    }
}
