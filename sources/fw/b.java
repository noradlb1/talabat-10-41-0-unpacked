package fw;

import android.view.View;
import com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel;
import com.talabat.talabatlife.ui.cuisine.CuisineViewHolder;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CuisineViewHolder f14055b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CuisineDisplayModel f14056c;

    public /* synthetic */ b(CuisineViewHolder cuisineViewHolder, CuisineDisplayModel cuisineDisplayModel) {
        this.f14055b = cuisineViewHolder;
        this.f14056c = cuisineDisplayModel;
    }

    public final void onClick(View view) {
        CuisineViewHolder.m5830bind$lambda0(this.f14055b, this.f14056c, view);
    }
}
