package iu;

import android.view.View;
import com.talabat.sdsquad.ui.filters.adapters.viewholders.FilterViewHolder;
import com.talabat.sdsquad.ui.filters.displaymodels.FilterDisplayModel;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FilterDisplayModel f62176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FilterViewHolder f62177c;

    public /* synthetic */ a(FilterDisplayModel filterDisplayModel, FilterViewHolder filterViewHolder) {
        this.f62176b = filterDisplayModel;
        this.f62177c = filterViewHolder;
    }

    public final void onClick(View view) {
        FilterViewHolder.m10826bind$lambda0(this.f62176b, this.f62177c, view);
    }
}
