package ai;

import android.view.View;
import com.talabat.darkstores.common.lists.adapters.ProductsListAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductsListAdapter f50828b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f50829c;

    public /* synthetic */ a(ProductsListAdapter productsListAdapter, int i11) {
        this.f50828b = productsListAdapter;
        this.f50829c = i11;
    }

    public final void onClick(View view) {
        ProductsListAdapter.m9635onBindViewHolder$lambda0(this.f50828b, this.f50829c, view);
    }
}
