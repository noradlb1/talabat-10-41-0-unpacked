package com.talabat.filters.navigation;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f59596b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f59597c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FiltersView f59598d;

    public /* synthetic */ a(Context context, AppCompatActivity appCompatActivity, FiltersView filtersView) {
        this.f59596b = context;
        this.f59597c = appCompatActivity;
        this.f59598d = filtersView;
    }

    public final void onClick(View view) {
        FiltersView$updateViews$2.m10434invokeSuspend$lambda0(this.f59596b, this.f59597c, this.f59598d, view);
    }
}
