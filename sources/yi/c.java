package yi;

import android.view.View;
import com.talabat.darkstores.feature.categories.subcategories.ProductsItemsListAdapter;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryHeadline;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductsItemsListAdapter f58027b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SubcategoryHeadline f58028c;

    public /* synthetic */ c(ProductsItemsListAdapter productsItemsListAdapter, SubcategoryHeadline subcategoryHeadline) {
        this.f58027b = productsItemsListAdapter;
        this.f58028c = subcategoryHeadline;
    }

    public final void onClick(View view) {
        ProductsItemsListAdapter.HeadlineViewHolder.m9865bind$lambda2$lambda1(this.f58027b, this.f58028c, view);
    }
}
