package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.data.DataSourcesPort;
import com.talabat.gem.ports.presentation.GemOfferProcessingViewPort;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.subjects.BehaviorSubject;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wq.k;
import wq.l;
import wq.m;
import wq.n;
import wq.o;
import wq.p;
import wq.q;
import wq.r;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\u0002\u001a\u001e\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u00050\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a,\u0010\b\u001a\u0012\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\t0\t0\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0002\u001a\u0016\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u00050\u0001H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0007\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0011H\u0007\u001a\u001a\u0010\b\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\t0\t0\u0001*\u00020\u0011H\u0007\u001a2\u0010\u0014\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r \u0003*\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b0\u000b0\u0001*\u00020\u0011H\u0002\u001a\f\u0010\u0015\u001a\u00020\r*\u00020\u0011H\u0002¨\u0006\u0016"}, d2 = {"accept", "Lio/reactivex/Single;", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Accepted;", "kotlin.jvm.PlatformType", "ignoreGemOffer", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Rejected;", "throwable", "", "processGemOffer", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "data", "Lkotlin/Pair;", "", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "reject", "hasGemOffer", "", "Lcom/talabat/gem/ports/presentation/GemOfferProcessingViewPort;", "onProcessOffer", "", "restaurantsData", "validSelectedRestaurant", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemOfferProcessingBusinessRulesKt {
    private static final Single<GemOfferAcceptance.Accepted> accept() {
        return KotlinResultKt.toSingle$default(IntegrationKt.getDataSources().requestGemOfferAcceptance(), (Function1) null, 1, (Object) null);
    }

    @BusinessRules
    public static final boolean hasGemOffer(@NotNull GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        Intrinsics.checkNotNullParameter(gemOfferProcessingViewPort, "<this>");
        return !Intrinsics.areEqual(RxKt.get(gemOfferProcessingViewPort.getOffer(), BusinessRulesKt.getNullGemOffer()), (Object) BusinessRulesKt.getNullGemOffer());
    }

    private static final Single<GemOfferAcceptance.Rejected> ignoreGemOffer(Throwable th2) {
        if (th2 instanceof NoSuchElementException) {
            return reject();
        }
        Single<GemOfferAcceptance.Rejected> error = Single.error(th2);
        Intrinsics.checkNotNullExpressionValue(error, "error(throwable)");
        return error;
    }

    @BusinessRules
    public static final void onProcessOffer(@NotNull GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        Intrinsics.checkNotNullParameter(gemOfferProcessingViewPort, "<this>");
        gemOfferProcessingViewPort.autoDispose(new GemOfferProcessingBusinessRulesKt$onProcessOffer$1(gemOfferProcessingViewPort));
    }

    @NotNull
    @BusinessRules
    public static final Single<GemOfferAcceptance> processGemOffer(@NotNull GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        Intrinsics.checkNotNullParameter(gemOfferProcessingViewPort, "<this>");
        Single<R> doOnEvent = restaurantsData(gemOfferProcessingViewPort).observeOn(gemOfferProcessingViewPort.getScheduler()).doOnEvent(new l(gemOfferProcessingViewPort)).flatMap(new m()).onErrorResumeNext(new n()).doOnSuccess(new o()).doOnError(new p()).doOnError(new q(gemOfferProcessingViewPort)).doOnEvent(new r(gemOfferProcessingViewPort));
        Intrinsics.checkNotNullExpressionValue(doOnEvent, "restaurantsData()\n    .o… -> processing += false }");
        return doOnEvent;
    }

    /* access modifiers changed from: private */
    /* renamed from: processGemOffer$lambda-0  reason: not valid java name */
    public static final void m10568processGemOffer$lambda0(GemOfferProcessingViewPort gemOfferProcessingViewPort, Pair pair, Throwable th2) {
        Intrinsics.checkNotNullParameter(gemOfferProcessingViewPort, "$this_processGemOffer");
        RxKt.plusAssign(gemOfferProcessingViewPort.getProcessing(), Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    /* renamed from: processGemOffer$lambda-1  reason: not valid java name */
    public static final SingleSource m10569processGemOffer$lambda1(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        return processGemOffer((Pair<Integer, GemRestaurant>) pair);
    }

    /* access modifiers changed from: private */
    /* renamed from: processGemOffer$lambda-2  reason: not valid java name */
    public static final SingleSource m10570processGemOffer$lambda2(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return ignoreGemOffer(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: processGemOffer$lambda-3  reason: not valid java name */
    public static final void m10571processGemOffer$lambda3(GemOfferAcceptance gemOfferAcceptance) {
        IntegrationKt.getDataSources().updateGemOfferAcceptance(gemOfferAcceptance);
    }

    /* access modifiers changed from: private */
    /* renamed from: processGemOffer$lambda-4  reason: not valid java name */
    public static final void m10572processGemOffer$lambda4(Throwable th2) {
        DataSourcesPort dataSources = IntegrationKt.getDataSources();
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        dataSources.updateGemOfferAcceptance(new GemOfferAcceptance.Failed(th2));
    }

    /* access modifiers changed from: private */
    /* renamed from: processGemOffer$lambda-5  reason: not valid java name */
    public static final void m10573processGemOffer$lambda5(GemOfferProcessingViewPort gemOfferProcessingViewPort, Throwable th2) {
        Intrinsics.checkNotNullParameter(gemOfferProcessingViewPort, "$this_processGemOffer");
        BehaviorSubject<SingleAccess<GemOfferAcceptance>> processingResult = gemOfferProcessingViewPort.getProcessingResult();
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        RxKt.plusAssign(processingResult, new GemOfferAcceptance.Failed(th2));
    }

    /* access modifiers changed from: private */
    /* renamed from: processGemOffer$lambda-6  reason: not valid java name */
    public static final void m10574processGemOffer$lambda6(GemOfferProcessingViewPort gemOfferProcessingViewPort, GemOfferAcceptance gemOfferAcceptance, Throwable th2) {
        Intrinsics.checkNotNullParameter(gemOfferProcessingViewPort, "$this_processGemOffer");
        RxKt.plusAssign(gemOfferProcessingViewPort.getProcessing(), Boolean.FALSE);
    }

    private static final Single<GemOfferAcceptance.Rejected> reject() {
        return KotlinResultKt.toSingle$default(IntegrationKt.getDataSources().requestGemOfferRejection(), (Function1) null, 1, (Object) null);
    }

    private static final Single<Pair<Integer, GemRestaurant>> restaurantsData(GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        Single<Pair<Integer, GemRestaurant>> fromCallable = Single.fromCallable(new k(gemOfferProcessingViewPort));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n    val r…d to selectedRestaurant\n}");
        return fromCallable;
    }

    /* access modifiers changed from: private */
    /* renamed from: restaurantsData$lambda-7  reason: not valid java name */
    public static final Pair m10575restaurantsData$lambda7(GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        Intrinsics.checkNotNullParameter(gemOfferProcessingViewPort, "$this_restaurantsData");
        Integer num = (Integer) RxKt.invoke(gemOfferProcessingViewPort.getSelectedRestaurantId());
        if (num != null) {
            int intValue = num.intValue();
            return TuplesKt.to(Integer.valueOf(intValue), validSelectedRestaurant(gemOfferProcessingViewPort));
        }
        throw new NoSuchElementException();
    }

    private static final GemRestaurant validSelectedRestaurant(GemOfferProcessingViewPort gemOfferProcessingViewPort) {
        GemRestaurant gemRestaurant = (GemRestaurant) RxKt.invoke(gemOfferProcessingViewPort.getSelectedGemRestaurant());
        if (gemRestaurant != null) {
            if (!(!Intrinsics.areEqual((Object) gemRestaurant, (Object) BusinessRulesKt.getNullGemRestaurant()))) {
                gemRestaurant = null;
            }
            if (gemRestaurant != null) {
                return gemRestaurant;
            }
        }
        throw new NoSuchElementException();
    }

    private static final Single<? extends GemOfferAcceptance> processGemOffer(Pair<Integer, GemRestaurant> pair) {
        int intValue = pair.getFirst().intValue();
        Integer id2 = pair.getSecond().getId();
        return (id2 != null && intValue == id2.intValue()) ? accept() : reject();
    }
}
