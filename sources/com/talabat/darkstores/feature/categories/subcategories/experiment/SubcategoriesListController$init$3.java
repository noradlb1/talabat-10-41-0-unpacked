package com.talabat.darkstores.feature.categories.subcategories.experiment;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesListController$init$3 extends Lambda implements Function1<Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesListController f56354g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f56355h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesListController$init$3(SubcategoriesListController subcategoriesListController, RecyclerView recyclerView) {
        super(1);
        this.f56354g = subcategoriesListController;
        this.f56355h = recyclerView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        SubcategoriesListController subcategoriesListController = this.f56354g;
        RecyclerView recyclerView = this.f56355h;
        Intrinsics.checkNotNullExpressionValue(num, "it");
        subcategoriesListController.selectHeadline(recyclerView, num.intValue());
        this.f56354g.analyticsAction.invoke(num);
    }
}
