package com.talabat.darkstores.feature.categories.subcategories;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragment$subcategoryItemsAdapter$2 extends Lambda implements Function0<ProductsItemsListAdapter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragment f56324g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesFragment$subcategoryItemsAdapter$2(SubcategoriesFragment subcategoriesFragment) {
        super(0);
        this.f56324g = subcategoriesFragment;
    }

    @NotNull
    public final ProductsItemsListAdapter invoke() {
        CartFragmentViewModel cartFragmentViewModel = this.f56324g.getCartFragmentViewModel();
        AnonymousClass1 r22 = new Function1<Product, Unit>(this.f56324g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Product) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Product product) {
                Intrinsics.checkNotNullParameter(product, "p0");
                ((SubcategoriesFragment) this.receiver).onProductClicked(product);
            }
        };
        SubcategoriesFragmentViewModel access$getViewModel = this.f56324g.getViewModel();
        String string = this.f56324g.requireArguments().getString("category_id", "");
        Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getString(CATEGORY_ID, \"\")");
        return new ProductsItemsListAdapter(cartFragmentViewModel, r22, access$getViewModel, new TrackingCategoryId.Category(string), (Function2) null, (Function1) null, 48, (DefaultConstructorMarker) null);
    }
}
