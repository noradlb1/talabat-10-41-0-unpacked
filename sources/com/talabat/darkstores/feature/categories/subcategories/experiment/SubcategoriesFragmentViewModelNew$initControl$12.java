package com.talabat.darkstores.feature.categories.subcategories.experiment;

import com.models.ProductTrackingModel;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.feature.tracking.data.CategoryLoadedEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012>\u0010\u0002\u001a:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0004 \u0007*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "", "Lcom/models/ProductTrackingModel;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentViewModelNew$initControl$12 extends Lambda implements Function1<Pair<? extends List<? extends String>, ? extends List<? extends ProductTrackingModel>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f56338g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesFragmentViewModelNew$initControl$12(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        super(1);
        this.f56338g = subcategoriesFragmentViewModelNew;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<? extends List<String>, ? extends List<ProductTrackingModel>>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<? extends List<String>, ? extends List<ProductTrackingModel>> pair) {
        List list = (List) pair.component1();
        List list2 = (List) pair.component2();
        this.f56338g.onReadyForInteractionTlbDefinition();
        DarkstoresEventTracker access$getDarkStoreEventTracker$p = this.f56338g.darkStoreEventTracker;
        String access$getCategoryName$p = this.f56338g.categoryName;
        String access$getTopLevelCategoryId$p = this.f56338g.topLevelCategoryId;
        boolean z11 = this.f56338g.productsSentCount > 5;
        EventOrigin access$getEventOrigin$p = this.f56338g.eventOrigin;
        access$getDarkStoreEventTracker$p.onCategoryLoaded(new CategoryLoadedEvent(access$getCategoryName$p, access$getTopLevelCategoryId$p, list, list2, z11, access$getEventOrigin$p != null ? access$getEventOrigin$p.getTrackingName() : null));
    }
}
