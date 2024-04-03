package iu;

import android.view.View;
import com.talabat.sdsquad.data.vendorslist.response.Sort;
import com.talabat.sdsquad.ui.filters.adapters.viewholders.SortViewHolder;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SortViewHolder f62178b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Sort f62179c;

    public /* synthetic */ b(SortViewHolder sortViewHolder, Sort sort) {
        this.f62178b = sortViewHolder;
        this.f62179c = sort;
    }

    public final void onClick(View view) {
        SortViewHolder.m10827bind$lambda0(this.f62178b, this.f62179c, view);
    }
}
