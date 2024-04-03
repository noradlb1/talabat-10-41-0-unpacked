package com.instabug.survey.ui.popup;

import android.view.View;
import androidx.appcompat.app.AlertDialog;

class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AlertDialog f52528b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f52529c;

    public a(AlertDialog alertDialog, f fVar) {
        this.f52528b = alertDialog;
        this.f52529c = fVar;
    }

    public void onClick(View view) {
        this.f52528b.dismiss();
        f fVar = this.f52529c;
        if (fVar != null) {
            fVar.c();
        }
    }
}
