package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.presentation.GemExpiredViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.Observables;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq.j;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0002\u001a\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007\u001a\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0007\u001a\f\u0010\r\u001a\u00020\n*\u00020\u000bH\u0007\u001a<\u0010\u000e\u001a2\u0012.\u0012,\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\b0\b0\u00050\u000f*\u00020\u000bH\u0002\u001a\f\u0010\u0011\u001a\u00020\u0003*\u00020\u000bH\u0002\u001a!\u0010\u0012\u001a\u0004\u0018\u00010\n*\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0007¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"MAXIMUM_TRIGGER_THRESHOLD_SECONDS", "", "isSameRestaurant", "", "data", "Lkotlin/Triple;", "Lcom/talabat/gem/domain/entities/GemOffer;", "", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "bindCollectionTriggerExpirationAlert", "", "Lcom/talabat/gem/ports/presentation/GemExpiredViewPort;", "bindExpiredOffer", "bindTriggerExpirationAlert", "expiredOfferAndRestaurants", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "isExpired", "onTriggerExpirationAlert", "triggerAction", "Lkotlin/Function0;", "(Lcom/talabat/gem/ports/presentation/GemExpiredViewPort;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemExpiredBusinessRulesKt {
    public static final long MAXIMUM_TRIGGER_THRESHOLD_SECONDS = 2;

    @BusinessRules
    public static final void bindCollectionTriggerExpirationAlert(@NotNull GemExpiredViewPort gemExpiredViewPort) {
        Intrinsics.checkNotNullParameter(gemExpiredViewPort, "<this>");
        gemExpiredViewPort.autoDispose(new GemExpiredBusinessRulesKt$bindCollectionTriggerExpirationAlert$1(gemExpiredViewPort));
    }

    @BusinessRules
    public static final void bindExpiredOffer(@NotNull GemExpiredViewPort gemExpiredViewPort) {
        Intrinsics.checkNotNullParameter(gemExpiredViewPort, "<this>");
        gemExpiredViewPort.autoDispose(new GemExpiredBusinessRulesKt$bindExpiredOffer$1(gemExpiredViewPort));
    }

    @BusinessRules
    public static final void bindTriggerExpirationAlert(@NotNull GemExpiredViewPort gemExpiredViewPort) {
        Intrinsics.checkNotNullParameter(gemExpiredViewPort, "<this>");
        gemExpiredViewPort.autoDispose(new GemExpiredBusinessRulesKt$bindTriggerExpirationAlert$1(gemExpiredViewPort));
    }

    /* access modifiers changed from: private */
    public static final Observable<Triple<GemOffer, Integer, GemRestaurant>> expiredOfferAndRestaurants(GemExpiredViewPort gemExpiredViewPort) {
        Observables observables = Observables.INSTANCE;
        Observable<GemOffer> filter = gemExpiredViewPort.getExpiredOffer().share().filter(new j());
        Intrinsics.checkNotNullExpressionValue(filter, "expiredOffer.share().filter { it != NullGemOffer }");
        Observable<Integer> share = gemExpiredViewPort.getSelectedRestaurantId().share();
        Intrinsics.checkNotNullExpressionValue(share, "selectedRestaurantId.share()");
        Observable<GemRestaurant> share2 = gemExpiredViewPort.getSelectedGemRestaurant().share();
        Intrinsics.checkNotNullExpressionValue(share2, "selectedGemRestaurant.share()");
        return observables.combineLatest(filter, share, share2);
    }

    /* access modifiers changed from: private */
    /* renamed from: expiredOfferAndRestaurants$lambda-1  reason: not valid java name */
    public static final boolean m10563expiredOfferAndRestaurants$lambda1(GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "it");
        return !Intrinsics.areEqual((Object) gemOffer, (Object) BusinessRulesKt.getNullGemOffer());
    }

    /* access modifiers changed from: private */
    public static final boolean isExpired(GemExpiredViewPort gemExpiredViewPort) {
        Long l11 = (Long) RxKt.invoke(gemExpiredViewPort.getRemainingSeconds());
        return l11 == null || l11.longValue() < 2;
    }

    public static final boolean isSameRestaurant(@NotNull Triple<GemOffer, Integer, GemRestaurant> triple) {
        Intrinsics.checkNotNullParameter(triple, "data");
        GemRestaurant third = triple.getThird();
        if (third == null) {
            return false;
        }
        int intValue = triple.getSecond().intValue();
        Integer id2 = third.getId();
        if (id2 != null && intValue == id2.intValue()) {
            return true;
        }
        return false;
    }

    @BusinessRules
    @Nullable
    public static final Unit onTriggerExpirationAlert(@NotNull GemExpiredViewPort gemExpiredViewPort, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(gemExpiredViewPort, "<this>");
        Intrinsics.checkNotNullParameter(function0, "triggerAction");
        GemOffer gemOffer = (GemOffer) RxKt.invoke(gemExpiredViewPort.getExpiredOffer());
        if (gemOffer == null) {
            return null;
        }
        if (Intrinsics.areEqual((Object) gemOffer, (Object) BusinessRulesKt.getNullGemOffer())) {
            gemOffer = null;
        }
        if (gemOffer == null) {
            return null;
        }
        RxKt.plusAssign(gemExpiredViewPort.getExpiredOffer(), BusinessRulesKt.getNullGemOffer());
        function0.invoke();
        return Unit.INSTANCE;
    }
}
