package com.talabat.darkstores.feature.categories.subcategories.experiment;

import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesListController;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentNew$subcategoriesListController$2 extends Lambda implements Function0<SubcategoriesListController> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentNew f56335g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesFragmentNew$subcategoriesListController$2(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        super(0);
        this.f56335g = subcategoriesFragmentNew;
    }

    @NotNull
    public final SubcategoriesListController invoke() {
        return new SubcategoriesListController(this.f56335g.getCartFragmentViewModel(), new TrackingCategoryId.Category(this.f56335g.getArgs().getCategoryId()), new Function1<Product, Unit>(this.f56335g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Product) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Product product) {
                Intrinsics.checkNotNullParameter(product, "p0");
                ((SubcategoriesFragmentNew) this.receiver).onProductClicked(product);
            }
        }, this.f56335g.getViewModel(), new Function0<Unit>(this.f56335g) {
            public final void invoke() {
                ((SubcategoriesFragmentNew) this.receiver).clearShelfViewSelection();
            }
        }, new Function1<Integer, Unit>(this.f56335g.getViewModel()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i11) {
                ((SubcategoriesFragmentViewModelNew) this.receiver).updateScrollPosition(i11);
            }
        }, new Function2<Product, Integer, Unit>(this.f56335g.getViewModel()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Product) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Product product, int i11) {
                Intrinsics.checkNotNullParameter(product, "p0");
                ((SubcategoriesFragmentViewModelNew) this.receiver).onQuantityChange(product, i11);
            }
        }, new Function1<List<? extends SortOption>, Unit>(this.f56335g.getViewModel()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<SortOption>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull List<SortOption> list) {
                Intrinsics.checkNotNullParameter(list, "p0");
                ((SubcategoriesFragmentViewModelNew) this.receiver).onSortButtonClicked(list);
            }
        });
    }
}
