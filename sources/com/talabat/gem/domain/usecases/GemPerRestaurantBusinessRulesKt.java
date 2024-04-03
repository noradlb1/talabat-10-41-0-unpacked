package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.presentation.GemPerRestaurantViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.Observables;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wq.s;
import wq.t;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0007\u001a\f\u0010\b\u001a\u00020\u0006*\u00020\u0007H\u0007\u001a\f\u0010\t\u001a\u00020\u0006*\u00020\u0007H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H\u0007\u001a&\u0010\f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u00030\r*\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"isVisibleAndSameRestaurant", "", "data", "Lkotlin/Triple;", "", "bindSelectedGemRestaurant", "", "Lcom/talabat/gem/ports/presentation/GemPerRestaurantViewPort;", "bindSelectedRestaurantId", "bindVisibilityPerRestaurant", "onUpdateRestaurantId", "id", "visibilityObservables", "Lio/reactivex/Observable;", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemPerRestaurantBusinessRulesKt {
    @BusinessRules
    public static final void bindSelectedGemRestaurant(@NotNull GemPerRestaurantViewPort gemPerRestaurantViewPort) {
        Intrinsics.checkNotNullParameter(gemPerRestaurantViewPort, "<this>");
        gemPerRestaurantViewPort.autoDispose(new GemPerRestaurantBusinessRulesKt$bindSelectedGemRestaurant$1(gemPerRestaurantViewPort));
    }

    @BusinessRules
    public static final void bindSelectedRestaurantId(@NotNull GemPerRestaurantViewPort gemPerRestaurantViewPort) {
        Intrinsics.checkNotNullParameter(gemPerRestaurantViewPort, "<this>");
        gemPerRestaurantViewPort.autoDispose(new GemPerRestaurantBusinessRulesKt$bindSelectedRestaurantId$1(gemPerRestaurantViewPort));
    }

    @BusinessRules
    public static final void bindVisibilityPerRestaurant(@NotNull GemPerRestaurantViewPort gemPerRestaurantViewPort) {
        Intrinsics.checkNotNullParameter(gemPerRestaurantViewPort, "<this>");
        gemPerRestaurantViewPort.autoDispose(new GemPerRestaurantBusinessRulesKt$bindVisibilityPerRestaurant$1(gemPerRestaurantViewPort));
    }

    /* access modifiers changed from: private */
    public static final boolean isVisibleAndSameRestaurant(Triple<Boolean, Integer, Integer> triple) {
        if (triple.getFirst().booleanValue()) {
            Integer second = triple.getSecond();
            int intValue = triple.getThird().intValue();
            if (second != null && second.intValue() == intValue) {
                return true;
            }
        }
        return false;
    }

    @BusinessRules
    @Deprecated(message = "bindSelectedRestaurantId() updates this value on change")
    public static final void onUpdateRestaurantId(@NotNull GemPerRestaurantViewPort gemPerRestaurantViewPort, int i11) {
        Intrinsics.checkNotNullParameter(gemPerRestaurantViewPort, "<this>");
        RxKt.plusAssign(gemPerRestaurantViewPort.getSelectedRestaurantId(), Integer.valueOf(i11));
    }

    /* access modifiers changed from: private */
    public static final Observable<Triple<Boolean, Integer, Integer>> visibilityObservables(GemPerRestaurantViewPort gemPerRestaurantViewPort) {
        Observables observables = Observables.INSTANCE;
        Observable<Boolean> share = gemPerRestaurantViewPort.getVisibility().share();
        Intrinsics.checkNotNullExpressionValue(share, "visibility.share()");
        Observable<Integer> share2 = gemPerRestaurantViewPort.getSelectedRestaurantId().share();
        Intrinsics.checkNotNullExpressionValue(share2, "selectedRestaurantId.share()");
        Observable<R> withLatestFrom = observables.combineLatest(share, share2).withLatestFrom(gemPerRestaurantViewPort.getSelectedGemRestaurant().share().map(new s()), new t());
        Intrinsics.checkNotNullExpressionValue(withLatestFrom, "combineLatest(visibility…r.second, item)\n        }");
        return withLatestFrom;
    }

    /* access modifiers changed from: private */
    /* renamed from: visibilityObservables$lambda-0  reason: not valid java name */
    public static final Integer m10576visibilityObservables$lambda0(GemRestaurant gemRestaurant) {
        Intrinsics.checkNotNullParameter(gemRestaurant, "it");
        return gemRestaurant.getId();
    }

    /* access modifiers changed from: private */
    /* renamed from: visibilityObservables$lambda-1  reason: not valid java name */
    public static final Triple m10577visibilityObservables$lambda1(Pair pair, Integer num) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Intrinsics.checkNotNullParameter(num, "item");
        return new Triple(pair.getFirst(), pair.getSecond(), num);
    }
}
