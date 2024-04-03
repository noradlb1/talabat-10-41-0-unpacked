package com.instabug.survey.ui.popup;

import android.view.View;
import androidx.appcompat.app.AlertDialog;

class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AlertDialog f52530b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f52531c;

    public b(AlertDialog alertDialog, f fVar) {
        this.f52530b = alertDialog;
        this.f52531c = fVar;
    }

    public void onClick(View view) {
        this.f52530b.dismiss();
        f fVar = this.f52531c;
        if (fVar != null) {
            fVar.a();
        }
    }
}
