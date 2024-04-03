package com.talabat.darkstores.feature.categories.subcategories.experiment;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.categories.subcategories.ProductsItemsListAdapter;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesListController$productsItemsListAdapter$2 extends Lambda implements Function0<ProductsItemsListAdapter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f56356g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Product, Unit> f56357h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesListController f56358i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesListController$productsItemsListAdapter$2(CartFragmentViewModel cartFragmentViewModel, Function1<? super Product, Unit> function1, SubcategoriesListController subcategoriesListController) {
        super(0);
        this.f56356g = cartFragmentViewModel;
        this.f56357h = function1;
        this.f56358i = subcategoriesListController;
    }

    @NotNull
    public final ProductsItemsListAdapter invoke() {
        return new ProductsItemsListAdapter(this.f56356g, this.f56357h, this.f56358i.subcategoriesFragmentViewModelNew, this.f56358i.trackingCategoryId, this.f56358i.onQuantityChange, this.f56358i.onSortOptionClicked);
    }
}
