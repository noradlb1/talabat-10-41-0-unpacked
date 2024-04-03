package com.talabat.filters.presentation;

import android.view.View;
import datamodels.filters.SelectableFilter;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59668b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SelectableFilter f59669c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f59670d;

    public /* synthetic */ b(FiltersViewModel filtersViewModel, SelectableFilter selectableFilter, FiltersFragment filtersFragment) {
        this.f59668b = filtersViewModel;
        this.f59669c = selectableFilter;
        this.f59670d = filtersFragment;
    }

    public final void onClick(View view) {
        FiltersFragment$onActivityCreated$1$4.m10439invoke$lambda0(this.f59668b, this.f59669c, this.f59670d, view);
    }
}
