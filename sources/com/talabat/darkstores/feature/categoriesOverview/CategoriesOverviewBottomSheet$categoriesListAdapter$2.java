package com.talabat.darkstores.feature.categoriesOverview;

import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.feature.home.CategoriesListAdapter;
import com.talabat.darkstores.model.Category;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/feature/home/CategoriesListAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CategoriesOverviewBottomSheet$categoriesListAdapter$2 extends Lambda implements Function0<CategoriesListAdapter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CategoriesOverviewBottomSheet f56368g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoriesOverviewBottomSheet$categoriesListAdapter$2(CategoriesOverviewBottomSheet categoriesOverviewBottomSheet) {
        super(0);
        this.f56368g = categoriesOverviewBottomSheet;
    }

    @NotNull
    public final CategoriesListAdapter invoke() {
        final CategoriesOverviewBottomSheet categoriesOverviewBottomSheet = this.f56368g;
        CategoriesListAdapter categoriesListAdapter = new CategoriesListAdapter(new Function2<Category, Integer, Unit>() {
            public final void invoke(@NotNull Category category, int i11) {
                Intrinsics.checkNotNullParameter(category, "category");
                categoriesOverviewBottomSheet.getViewModel().onCategoryClicked(category, i11, EventOrigin.ALL_CATEGORIES, categoriesOverviewBottomSheet.getCategoriesListAdapter().isSearchCategory());
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Category) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }
        }, (Function0) null, false, 0, 14, (DefaultConstructorMarker) null);
        categoriesListAdapter.submitCategories(ArraysKt___ArraysKt.toList((T[]) this.f56368g.getArgs().getCategories()));
        return categoriesListAdapter;
    }
}
