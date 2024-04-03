package com.talabat.filters.presentation;

import android.view.View;
import datamodels.filters.SelectableSortType;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59665b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SelectableSortType f59666c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f59667d;

    public /* synthetic */ a(FiltersViewModel filtersViewModel, SelectableSortType selectableSortType, FiltersFragment filtersFragment) {
        this.f59665b = filtersViewModel;
        this.f59666c = selectableSortType;
        this.f59667d = filtersFragment;
    }

    public final void onClick(View view) {
        FiltersFragment$onActivityCreated$1$3.m10438invoke$lambda0(this.f59665b, this.f59666c, this.f59667d, view);
    }
}
