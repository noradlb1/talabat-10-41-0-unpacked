package bi;

import android.view.View;
import com.talabat.darkstores.common.lists.adapters.compact.CompactSwimlaneAdapter;
import com.talabat.feature.darkstorescart.data.model.Product;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CompactSwimlaneAdapter f50859b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Product f50860c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CompactSwimlaneAdapter.ViewHolder f50861d;

    public /* synthetic */ b(CompactSwimlaneAdapter compactSwimlaneAdapter, Product product, CompactSwimlaneAdapter.ViewHolder viewHolder) {
        this.f50859b = compactSwimlaneAdapter;
        this.f50860c = product;
        this.f50861d = viewHolder;
    }

    public final void onClick(View view) {
        CompactSwimlaneAdapter.ViewHolder.m9637bind$lambda0(this.f50859b, this.f50860c, this.f50861d, view);
    }
}
