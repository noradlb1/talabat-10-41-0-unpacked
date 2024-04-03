package com.talabat.darkstores.feature.product;

import android.content.res.Resources;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.SwimlaneView;
import com.talabat.darkstores.feature.product.models.SwimlaneLabel;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "label", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment$observeMoreData$2 extends Lambda implements Function1<SwimlaneLabel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56481g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragment$observeMoreData$2(ProductFragment productFragment) {
        super(1);
        this.f56481g = productFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SwimlaneLabel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SwimlaneLabel swimlaneLabel) {
        Intrinsics.checkNotNullParameter(swimlaneLabel, "label");
        Resources resources = this.f56481g.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        String asString = swimlaneLabel.asString(resources);
        this.f56481g.getProductListAdapter().setTrackingCategoryId(new TrackingCategoryId.CustomSwimlane(asString));
        this.f56481g.getProductListAdapter().setSwimlaneTitle(asString);
        ((SwimlaneView) this.f56481g._$_findCachedViewById(R.id.suggestedProductsSwimlane)).setTitle(asString);
    }
}
