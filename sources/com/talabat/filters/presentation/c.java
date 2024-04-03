package com.talabat.filters.presentation;

import android.view.View;
import datamodels.filters.SelectablePopularFilter;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SelectablePopularFilter f59672c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f59673d;

    public /* synthetic */ c(FiltersViewModel filtersViewModel, SelectablePopularFilter selectablePopularFilter, FiltersFragment filtersFragment) {
        this.f59671b = filtersViewModel;
        this.f59672c = selectablePopularFilter;
        this.f59673d = filtersFragment;
    }

    public final void onClick(View view) {
        FiltersFragment$onActivityCreated$1$5.m10440invoke$lambda0(this.f59671b, this.f59672c, this.f59673d, view);
    }
}
