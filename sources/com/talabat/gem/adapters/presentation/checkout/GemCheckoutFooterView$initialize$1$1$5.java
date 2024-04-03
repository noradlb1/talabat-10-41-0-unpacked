package com.talabat.gem.adapters.presentation.checkout;

import com.talabat.gem.adapters.presentation.GemCheckoutFooterConfigurations;
import com.talabat.gem.domain.usecases.GemPerRestaurantBusinessRulesKt;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
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
public final class GemCheckoutFooterView$initialize$1$1$5 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCheckoutFooterView f59968g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemCheckoutFooterViewModel f59969h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCheckoutFooterView$initialize$1$1$5(GemCheckoutFooterView gemCheckoutFooterView, GemCheckoutFooterViewModel gemCheckoutFooterViewModel) {
        super(0);
        this.f59968g = gemCheckoutFooterView;
        this.f59969h = gemCheckoutFooterViewModel;
    }

    @Nullable
    public final Disposable invoke() {
        ReplaySubject access$getConfigurations$p = this.f59968g.configurations;
        final GemCheckoutFooterViewModel gemCheckoutFooterViewModel = this.f59969h;
        final GemCheckoutFooterView gemCheckoutFooterView = this.f59968g;
        return RxKt.invoke(access$getConfigurations$p, new Function1<ObserverCallbacks<GemCheckoutFooterConfigurations, Observable<GemCheckoutFooterConfigurations>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<GemCheckoutFooterConfigurations, Observable<GemCheckoutFooterConfigurations>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<GemCheckoutFooterConfigurations, Observable<GemCheckoutFooterConfigurations>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<GemCheckoutFooterConfigurations, Observable<GemCheckoutFooterConfigurations>> on2 = observerCallbacks.getOn();
                final GemCheckoutFooterViewModel gemCheckoutFooterViewModel = gemCheckoutFooterViewModel;
                on2.error(new Function1<Throwable, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Throwable th2) {
                        Intrinsics.checkNotNullParameter(th2, "it");
                        RxKt.plusAssign(gemCheckoutFooterViewModel.getErrors(), th2);
                    }
                });
                ObserverCallbacks<GemCheckoutFooterConfigurations, Observable<GemCheckoutFooterConfigurations>> on3 = observerCallbacks.getOn();
                final GemCheckoutFooterViewModel gemCheckoutFooterViewModel2 = gemCheckoutFooterViewModel;
                final GemCheckoutFooterView gemCheckoutFooterView = gemCheckoutFooterView;
                on3.next(new Function1<GemCheckoutFooterConfigurations, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GemCheckoutFooterConfigurations) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GemCheckoutFooterConfigurations gemCheckoutFooterConfigurations) {
                        Integer restaurantId$com_talabat_Components_gem_gem = gemCheckoutFooterConfigurations.getWith().getRestaurantId$com_talabat_Components_gem_gem();
                        if (restaurantId$com_talabat_Components_gem_gem != null) {
                            GemPerRestaurantBusinessRulesKt.onUpdateRestaurantId(gemCheckoutFooterViewModel2, restaurantId$com_talabat_Components_gem_gem.intValue());
                        }
                        Function0<Unit> onEnabled$com_talabat_Components_gem_gem = gemCheckoutFooterConfigurations.getOn().getOnEnabled$com_talabat_Components_gem_gem();
                        if (onEnabled$com_talabat_Components_gem_gem != null) {
                            gemCheckoutFooterView.onEnabledAction = new SingleAccess(onEnabled$com_talabat_Components_gem_gem);
                        }
                        Function0<Unit> onDisabled$com_talabat_Components_gem_gem = gemCheckoutFooterConfigurations.getOn().getOnDisabled$com_talabat_Components_gem_gem();
                        if (onDisabled$com_talabat_Components_gem_gem != null) {
                            gemCheckoutFooterView.onDisabledAction = new SingleAccess(onDisabled$com_talabat_Components_gem_gem);
                        }
                    }
                });
            }
        });
    }
}
