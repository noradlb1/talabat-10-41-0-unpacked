package com.instabug.survey.utils;

import android.widget.TextView;

class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f52595b;

    public n(TextView textView) {
        this.f52595b = textView;
    }

    public void run() {
        TextView textView;
        float f11;
        if (this.f52595b.getLineCount() > 2) {
            textView = this.f52595b;
            f11 = 16.0f;
        } else if (this.f52595b.getLineCount() > 1) {
            textView = this.f52595b;
            f11 = 17.0f;
        } else {
            return;
        }
        textView.setTextSize(2, f11);
        this.f52595b.setLineSpacing(1.0f, 1.1f);
        this.f52595b.setMaxLines(2);
    }
}
