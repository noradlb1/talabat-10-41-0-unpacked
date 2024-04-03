package yi;

import android.view.View;
import com.talabat.darkstores.feature.categories.subcategories.ProductsItemsListAdapter;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryItem;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductsItemsListAdapter f58025b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SubcategoryItem f58026c;

    public /* synthetic */ b(ProductsItemsListAdapter productsItemsListAdapter, SubcategoryItem subcategoryItem) {
        this.f58025b = productsItemsListAdapter;
        this.f58026c = subcategoryItem;
    }

    public final void onClick(View view) {
        ProductsItemsListAdapter.m9864onBindViewHolder$lambda0(this.f58025b, this.f58026c, view);
    }
}
