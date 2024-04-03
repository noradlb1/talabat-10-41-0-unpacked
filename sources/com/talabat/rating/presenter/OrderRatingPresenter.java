package com.talabat.rating.presenter;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.rating.domain.model.RateOrderEventModel;
import com.talabat.rating.domain.model.OrderRatingDetails;
import com.talabat.rating.domain.repository.OrderRatingRepository;
import com.talabat.rating.repo.impl.OrderRatingRepositoryImpl;
import com.talabat.rating.view.OrderRatingView;
import com.talabat.talabatcommon.helpers.RxProcessor;
import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import service.ApiHandler;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/rating/presenter/OrderRatingPresenter;", "", "view", "Lcom/talabat/rating/view/OrderRatingView;", "ratingRepository", "Lcom/talabat/rating/domain/repository/OrderRatingRepository;", "rxProcessor", "Lcom/talabat/talabatcommon/helpers/RxProcessor;", "(Lcom/talabat/rating/view/OrderRatingView;Lcom/talabat/rating/domain/repository/OrderRatingRepository;Lcom/talabat/talabatcommon/helpers/RxProcessor;)V", "getOrderRatingReasons", "", "encryptedOrderId", "", "orderRatingDetails", "Lcom/talabat/rating/domain/model/OrderRatingDetails;", "onRateOrderButtonClicked", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderRatingPresenter {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final OrderRatingRepository ratingRepository;
    @NotNull
    private final RxProcessor rxProcessor;
    /* access modifiers changed from: private */
    @NotNull
    public final OrderRatingView view;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/rating/presenter/OrderRatingPresenter$Companion;", "", "()V", "create", "Lcom/talabat/rating/presenter/OrderRatingPresenter;", "view", "Lcom/talabat/rating/view/OrderRatingView;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final OrderRatingPresenter create(@NotNull OrderRatingView orderRatingView, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
            Intrinsics.checkNotNullParameter(orderRatingView, "view");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
            return new OrderRatingPresenter(orderRatingView, new OrderRatingRepositoryImpl((ApiHandler.Services) null, iTalabatFeatureFlag, 1, (DefaultConstructorMarker) null), new RxProcessor((Scheduler) null, (Scheduler) null, 3, (DefaultConstructorMarker) null));
        }
    }

    public OrderRatingPresenter(@NotNull OrderRatingView orderRatingView, @NotNull OrderRatingRepository orderRatingRepository, @NotNull RxProcessor rxProcessor2) {
        Intrinsics.checkNotNullParameter(orderRatingView, "view");
        Intrinsics.checkNotNullParameter(orderRatingRepository, "ratingRepository");
        Intrinsics.checkNotNullParameter(rxProcessor2, "rxProcessor");
        this.view = orderRatingView;
        this.ratingRepository = orderRatingRepository;
        this.rxProcessor = rxProcessor2;
    }

    @JvmStatic
    @NotNull
    public static final OrderRatingPresenter create(@NotNull OrderRatingView orderRatingView, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        return Companion.create(orderRatingView, iTalabatFeatureFlag);
    }

    /* access modifiers changed from: private */
    public final void getOrderRatingReasons(String str, OrderRatingDetails orderRatingDetails) {
        this.rxProcessor.process(this.ratingRepository.getOrderRatingReasons(str), new OrderRatingPresenter$getOrderRatingReasons$observer$1(this, str, orderRatingDetails));
    }

    public final void onRateOrderButtonClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        this.view.rateOrderClicked(new RateOrderEventModel(str, (String) null, (String) null, (String) null, "checkoutScreen", (String) null, (String) null, 110, (DefaultConstructorMarker) null));
        this.view.showLoading();
        this.rxProcessor.process(this.ratingRepository.getRatingStatus(str), new OrderRatingPresenter$onRateOrderButtonClicked$observer$1(this, str));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderRatingPresenter(OrderRatingView orderRatingView, OrderRatingRepository orderRatingRepository, RxProcessor rxProcessor2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(orderRatingView, orderRatingRepository, (i11 & 4) != 0 ? new RxProcessor((Scheduler) null, (Scheduler) null, 3, (DefaultConstructorMarker) null) : rxProcessor2);
    }
}
