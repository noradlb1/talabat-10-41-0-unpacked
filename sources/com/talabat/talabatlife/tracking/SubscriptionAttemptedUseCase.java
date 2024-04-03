package com.talabat.talabatlife.tracking;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.wallet.ui.tracking.event.WalletTopUpCreditCardSelectionEventKt;
import com.tracking.Tracker;
import com.tracking.TrackerKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatlife/tracking/SubscriptionAttemptedUseCase;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/talabatcore/interactor/UseCase$None;", "Lcom/talabat/talabatlife/tracking/SubscriptionAttemptedUseCase$Params;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "tracker", "Lcom/tracking/Tracker;", "currencyFormatter", "Lkotlin/Function1;", "", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/tracking/Tracker;Lkotlin/jvm/functions/Function1;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/talabatlife/tracking/SubscriptionAttemptedUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionAttemptedUseCase extends UseCase<UseCase.None, Params> {
    @NotNull
    private final Function1<Float, String> currencyFormatter;
    @NotNull
    private final Tracker tracker;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatlife/tracking/SubscriptionAttemptedUseCase$Params;", "", "freeTrialEligible", "", "planAmount", "", "(ZF)V", "getFreeTrialEligible", "()Z", "getPlanAmount", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        private final boolean freeTrialEligible;
        private final float planAmount;

        public Params(boolean z11, float f11) {
            this.freeTrialEligible = z11;
            this.planAmount = f11;
        }

        public static /* synthetic */ Params copy$default(Params params, boolean z11, float f11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = params.freeTrialEligible;
            }
            if ((i11 & 2) != 0) {
                f11 = params.planAmount;
            }
            return params.copy(z11, f11);
        }

        public final boolean component1() {
            return this.freeTrialEligible;
        }

        public final float component2() {
            return this.planAmount;
        }

        @NotNull
        public final Params copy(boolean z11, float f11) {
            return new Params(z11, f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.freeTrialEligible == params.freeTrialEligible && Intrinsics.areEqual((Object) Float.valueOf(this.planAmount), (Object) Float.valueOf(params.planAmount));
        }

        public final boolean getFreeTrialEligible() {
            return this.freeTrialEligible;
        }

        public final float getPlanAmount() {
            return this.planAmount;
        }

        public int hashCode() {
            boolean z11 = this.freeTrialEligible;
            if (z11) {
                z11 = true;
            }
            return ((z11 ? 1 : 0) * true) + Float.floatToIntBits(this.planAmount);
        }

        @NotNull
        public String toString() {
            boolean z11 = this.freeTrialEligible;
            float f11 = this.planAmount;
            return "Params(freeTrialEligible=" + z11 + ", planAmount=" + f11 + ")";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionAttemptedUseCase(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Tracker tracker2, @NotNull Function1<? super Float, String> function1) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(tracker2, "tracker");
        Intrinsics.checkNotNullParameter(function1, "currencyFormatter");
        this.tracker = tracker2;
        this.currencyFormatter = function1;
    }

    @Nullable
    public Object run(@NotNull Params params, @NotNull Continuation<? super Either<? extends Failure, UseCase.None>> continuation) {
        Map<String, Object> createParameters = this.tracker.createParameters(ScreenNames.SUBSCRIPTION_BOTTOM_SHEET.getScreenName(), ScreenTypes.ON_BOARDING_SCREEN.getScreenType());
        String str = params.getFreeTrialEligible() ? "trial" : "paid";
        String invoke = this.currencyFormatter.invoke(Boxing.boxFloat(params.getPlanAmount()));
        TrackerKt.addParameter(createParameters, AttributeNames.SUBSCRIPTION_TYPE.getAttributeName(), "tDine: " + invoke);
        TrackerKt.addParameter(createParameters, AttributeNames.SUBSCRIPTION_TIER.getAttributeName(), str);
        TrackerKt.addParameter(createParameters, AttributeNames.ORDER_PAYMENT_METHOD.getAttributeName(), WalletTopUpCreditCardSelectionEventKt.ATTRIBUTE_VALUE_ORDER_PAYMENT_METHOD);
        TrackerKt.addParameter(createParameters, AttributeNames.TRANSACTION_TYPE.getAttributeName(), "acquisition");
        TrackerKt.addParameter(createParameters, AttributeNames.CART_VALUE.getAttributeName(), "N/A");
        TrackerKt.addParameter(createParameters, AttributeNames.PRODUCT_UNIT_SALE_PRICE.getAttributeName(), String.valueOf(params.getPlanAmount()));
        TrackerKt.addParameter(createParameters, AttributeNames.PRODUCT_NAME.getAttributeName(), "tlife_subscription_yearly");
        TrackerKt.addParameter(createParameters, AttributeNames.PRODUCT_CATEGORY.getAttributeName(), "subscription");
        this.tracker.sendEvent(EventNames.SUBSCRIPTION_ATTEMPTED.getEventName(), createParameters);
        return new Either.Right(new UseCase.None());
    }
}
