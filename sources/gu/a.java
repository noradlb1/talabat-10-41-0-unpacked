package gu;

import android.view.View;
import com.talabat.sdsquad.ui.cuisines.adapters.viewholders.CuisineViewHolder;
import com.talabat.sdsquad.ui.cuisines.displaymodels.CuisineDisplayModel;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CuisineViewHolder f62120b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CuisineDisplayModel f62121c;

    public /* synthetic */ a(CuisineViewHolder cuisineViewHolder, CuisineDisplayModel cuisineDisplayModel) {
        this.f62120b = cuisineViewHolder;
        this.f62121c = cuisineDisplayModel;
    }

    public final void onClick(View view) {
        CuisineViewHolder.m10817bind$lambda0(this.f62120b, this.f62121c, view);
    }
}
