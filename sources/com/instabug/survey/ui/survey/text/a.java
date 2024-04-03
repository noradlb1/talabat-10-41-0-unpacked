package com.instabug.survey.ui.survey.text;

import android.widget.EditText;

class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f52583b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f52584c;

    public a(b bVar, EditText editText) {
        this.f52584c = bVar;
        this.f52583b = editText;
    }

    public void run() {
        this.f52583b.addTextChangedListener(this.f52584c);
    }
}
