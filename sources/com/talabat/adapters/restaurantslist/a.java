package com.talabat.adapters.restaurantslist;

import android.view.View;
import datamodels.Restaurant;
import java.util.ArrayList;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRestaurantsAdapter f55351b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f55352c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f55353d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f55354e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ SearchDishViewHolder f55355f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f55356g;

    public /* synthetic */ a(SearchRestaurantsAdapter searchRestaurantsAdapter, Restaurant restaurant, ArrayList arrayList, int i11, SearchDishViewHolder searchDishViewHolder, int i12) {
        this.f55351b = searchRestaurantsAdapter;
        this.f55352c = restaurant;
        this.f55353d = arrayList;
        this.f55354e = i11;
        this.f55355f = searchDishViewHolder;
        this.f55356g = i12;
    }

    public final void onClick(View view) {
        this.f55351b.lambda$onBindViewHolder$1(this.f55352c, this.f55353d, this.f55354e, this.f55355f, this.f55356g, view);
    }
}
