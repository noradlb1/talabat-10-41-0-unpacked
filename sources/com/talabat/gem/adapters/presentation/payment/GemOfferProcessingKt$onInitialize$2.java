package com.talabat.gem.adapters.presentation.payment;

import com.talabat.gem.adapters.presentation.GemOfferProcessingConfigurations;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.usecases.GemPerRestaurantBusinessRulesKt;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.ReplaySubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferProcessingKt$onInitialize$2 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferProcessingViewModel f60254g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemOfferProcessingKt$onInitialize$2(GemOfferProcessingViewModel gemOfferProcessingViewModel) {
        super(0);
        this.f60254g = gemOfferProcessingViewModel;
    }

    @Nullable
    public final Disposable invoke() {
        ReplaySubject<GemOfferProcessingConfigurations> configurations$com_talabat_Components_gem_gem = this.f60254g.getConfigurations$com_talabat_Components_gem_gem();
        final GemOfferProcessingViewModel gemOfferProcessingViewModel = this.f60254g;
        return RxKt.invoke(configurations$com_talabat_Components_gem_gem, new Function1<ObserverCallbacks<GemOfferProcessingConfigurations, Observable<GemOfferProcessingConfigurations>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<GemOfferProcessingConfigurations, Observable<GemOfferProcessingConfigurations>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<GemOfferProcessingConfigurations, Observable<GemOfferProcessingConfigurations>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<GemOfferProcessingConfigurations, Observable<GemOfferProcessingConfigurations>> on2 = observerCallbacks.getOn();
                final GemOfferProcessingViewModel gemOfferProcessingViewModel = gemOfferProcessingViewModel;
                on2.next(new Function1<GemOfferProcessingConfigurations, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GemOfferProcessingConfigurations) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GemOfferProcessingConfigurations gemOfferProcessingConfigurations) {
                        Integer restaurantId$com_talabat_Components_gem_gem = gemOfferProcessingConfigurations.getWith().getRestaurantId$com_talabat_Components_gem_gem();
                        if (restaurantId$com_talabat_Components_gem_gem != null) {
                            GemPerRestaurantBusinessRulesKt.onUpdateRestaurantId(gemOfferProcessingViewModel, restaurantId$com_talabat_Components_gem_gem.intValue());
                        }
                        Function1<GemOfferAcceptance, Unit> onProcessed$com_talabat_Components_gem_gem = gemOfferProcessingConfigurations.getOn().getOnProcessed$com_talabat_Components_gem_gem();
                        if (onProcessed$com_talabat_Components_gem_gem != null) {
                            RxKt.plusAssign(gemOfferProcessingViewModel.getOnProcessed$com_talabat_Components_gem_gem(), onProcessed$com_talabat_Components_gem_gem);
                        }
                        Function1<Throwable, Unit> onError$com_talabat_Components_gem_gem = gemOfferProcessingConfigurations.getOn().getOnError$com_talabat_Components_gem_gem();
                        if (onError$com_talabat_Components_gem_gem != null) {
                            RxKt.plusAssign(gemOfferProcessingViewModel.getOnProcessingError$com_talabat_Components_gem_gem(), onError$com_talabat_Components_gem_gem);
                        }
                        Function1<Boolean, Unit> onProcessing$com_talabat_Components_gem_gem = gemOfferProcessingConfigurations.getOn().getOnProcessing$com_talabat_Components_gem_gem();
                        if (onProcessing$com_talabat_Components_gem_gem != null) {
                            RxKt.plusAssign(gemOfferProcessingViewModel.getOnProcessing$com_talabat_Components_gem_gem(), onProcessing$com_talabat_Components_gem_gem);
                        }
                    }
                });
            }
        });
    }
}
