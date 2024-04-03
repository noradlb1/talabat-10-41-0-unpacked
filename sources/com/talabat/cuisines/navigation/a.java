package com.talabat.cuisines.navigation;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f56054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CuisineView f56055c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f56056d;

    public /* synthetic */ a(Context context, CuisineView cuisineView, AppCompatActivity appCompatActivity) {
        this.f56054b = context;
        this.f56055c = cuisineView;
        this.f56056d = appCompatActivity;
    }

    public final void onClick(View view) {
        CuisineView$updateViews$1.m9615invoke$lambda2(this.f56054b, this.f56055c, this.f56056d, view);
    }
}
