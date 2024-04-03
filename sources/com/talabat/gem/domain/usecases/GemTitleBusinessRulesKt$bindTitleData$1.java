package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.presentation.GemOfferTitleViewPort;
import com.talabat.gem.ports.presentation.TitleData;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemTitleBusinessRulesKt$bindTitleData$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferTitleViewPort f60440g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemTitleBusinessRulesKt$bindTitleData$1(GemOfferTitleViewPort gemOfferTitleViewPort) {
        super(0);
        this.f60440g = gemOfferTitleViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observables observables = Observables.INSTANCE;
        Observable<String> share = this.f60440g.getUserName().share();
        Intrinsics.checkNotNullExpressionValue(share, "userName.share()");
        Observable<List<GemTier>> share2 = this.f60440g.getTiers().share();
        Intrinsics.checkNotNullExpressionValue(share2, "tiers.share()");
        Observable<GemOffer> share3 = this.f60440g.getOffer().share();
        Intrinsics.checkNotNullExpressionValue(share3, "offer.share()");
        Observable<Triple<T1, T2, T3>> observeOn = observables.combineLatest(share, share2, share3).observeOn(this.f60440g.getScheduler());
        Intrinsics.checkNotNullExpressionValue(observeOn, "Observables.combineLates…    .observeOn(scheduler)");
        AnonymousClass1 r32 = new Function1<Throwable, Unit>(this.f60440g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemOfferTitleViewPort gemOfferTitleViewPort = this.f60440g;
        return SubscribersKt.subscribeBy$default((Observable) observeOn, (Function1) r32, (Function0) null, (Function1) new Function1<Triple<? extends String, ? extends List<? extends GemTier>, ? extends GemOffer>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Triple<String, ? extends List<GemTier>, GemOffer>) (Triple) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Triple<String, ? extends List<GemTier>, GemOffer> triple) {
                String component1 = triple.component1();
                List list = (List) triple.component2();
                GemOffer component3 = triple.component3();
                BehaviorSubject<TitleData> titleData = gemOfferTitleViewPort.getTitleData();
                Intrinsics.checkNotNullExpressionValue(list, BasketDeliveryFeeTiersInfoKeys.KEY_BASKET_DELIVERY_FREE_TIERS);
                String access$currency = GemTitleBusinessRulesKt.currency(list);
                String access$formattedSavingsAmount = GemTitleBusinessRulesKt.formattedSavingsAmount(list);
                String format = BusinessRulesKt.getDecimalFormat().format(Float.valueOf(FloatKt.orZero(((GemTier) CollectionsKt___CollectionsKt.first(list)).getDiscountPercentage()) * ((float) 100)));
                String brandingMessage = component3 != null ? component3.getBrandingMessage() : null;
                String collectionTitle = component3 != null ? component3.getCollectionTitle() : null;
                String collectionSubtitle = component3 != null ? component3.getCollectionSubtitle() : null;
                Intrinsics.checkNotNullExpressionValue(component1, "name");
                Intrinsics.checkNotNullExpressionValue(access$formattedSavingsAmount, "formattedSavingsAmount(tiers)");
                RxKt.plusAssign(titleData, new TitleData(component1, access$formattedSavingsAmount, access$currency, format, brandingMessage, collectionTitle, collectionSubtitle));
            }
        }, 2, (Object) null);
    }
}
