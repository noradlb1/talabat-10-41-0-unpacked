package com.talabat.rating.view;

import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.rating.domain.RatingDataManager;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/feature/rating/domain/RatingDataManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderRatingViewImpl$ratingReasonsDataManager$2 extends Lambda implements Function0<RatingDataManager> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OrderRatingViewImpl f61192g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderRatingViewImpl$ratingReasonsDataManager$2(OrderRatingViewImpl orderRatingViewImpl) {
        super(0);
        this.f61192g = orderRatingViewImpl;
    }

    @NotNull
    public final RatingDataManager invoke() {
        return ((RatingFeatureApi) AndroidComponentsKt.apiContainer(this.f61192g.activity).getFeature(RatingFeatureApi.class)).getRatingDataManager();
    }
}
