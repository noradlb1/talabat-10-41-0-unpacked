package ro;

import com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders.GridItemViewHolder;
import java.util.List;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f62876b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GridItemViewHolder f62877c;

    public /* synthetic */ a(List list, GridItemViewHolder gridItemViewHolder) {
        this.f62876b = list;
        this.f62877c = gridItemViewHolder;
    }

    public final void run() {
        GridItemViewHolder.m10363bind$lambda4$lambda3(this.f62876b, this.f62877c);
    }
}
