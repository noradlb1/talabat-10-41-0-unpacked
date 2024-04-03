package com.talabat.darkstores.feature.categories.subcategories.experiment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.feature.categories.subcategories.HeadlinesChipsListAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesListController$init$1 extends Lambda implements Function1<Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesListController f56352g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f56353h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesListController$init$1(SubcategoriesListController subcategoriesListController, RecyclerView recyclerView) {
        super(1);
        this.f56352g = subcategoriesListController;
        this.f56353h = recyclerView;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m9927invoke$lambda0(SubcategoriesListController subcategoriesListController, Integer num) {
        Intrinsics.checkNotNullParameter(subcategoriesListController, "this$0");
        HeadlinesChipsListAdapter access$getHeadlinesAdapter = subcategoriesListController.getHeadlinesAdapter();
        Intrinsics.checkNotNullExpressionValue(num, "position");
        access$getHeadlinesAdapter.setCurrentSelection(num.intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11) {
        this.f56352g.onHeadlineSelected.invoke();
        this.f56352g.getHeadlineIndexToSelect(i11).subscribe(new a(this.f56352g));
        RecyclerView.LayoutManager layoutManager = this.f56353h.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager != null) {
            gridLayoutManager.scrollToPositionWithOffset(i11, 0);
        }
    }
}
