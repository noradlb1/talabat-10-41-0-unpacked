package com.talabat.gem.adapters.presentation.restaurants;

import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.domain.entities.GemRestaurant;
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
public final class GemFloatingView$initialize$1$1$7 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemFloatingView f60313g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemFloatingViewModel f60314h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFloatingView$initialize$1$1$7(GemFloatingView gemFloatingView, GemFloatingViewModel gemFloatingViewModel) {
        super(0);
        this.f60313g = gemFloatingView;
        this.f60314h = gemFloatingViewModel;
    }

    @Nullable
    public final Disposable invoke() {
        ReplaySubject access$getConfigurations$p = this.f60313g.configurations;
        final GemFloatingViewModel gemFloatingViewModel = this.f60314h;
        final GemFloatingView gemFloatingView = this.f60313g;
        return RxKt.invoke(access$getConfigurations$p, new Function1<ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>> on2 = observerCallbacks.getOn();
                final GemFloatingViewModel gemFloatingViewModel = gemFloatingViewModel;
                final GemFloatingView gemFloatingView = gemFloatingView;
                on2.next(new Function1<GemEntryViewConfigurations, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GemEntryViewConfigurations) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GemEntryViewConfigurations gemEntryViewConfigurations) {
                        GemMode mode$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getWith().getMode$com_talabat_Components_gem_gem();
                        if (mode$com_talabat_Components_gem_gem != null) {
                            RxKt.plusAssign(gemFloatingViewModel.getMode(), mode$com_talabat_Components_gem_gem);
                        }
                        Function1<GemRestaurant, Unit> onSelected$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnSelected$com_talabat_Components_gem_gem();
                        if (onSelected$com_talabat_Components_gem_gem != null) {
                            gemFloatingView.onSelectedAction = onSelected$com_talabat_Components_gem_gem;
                        }
                        Function0<Unit> onCancelled$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnCancelled$com_talabat_Components_gem_gem();
                        if (onCancelled$com_talabat_Components_gem_gem != null) {
                            gemFloatingView.onCancelledAction = onCancelled$com_talabat_Components_gem_gem;
                        }
                        Function0<Unit> onEnabled$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnEnabled$com_talabat_Components_gem_gem();
                        if (onEnabled$com_talabat_Components_gem_gem != null) {
                            gemFloatingView.onEnabledAction = new SingleAccess(onEnabled$com_talabat_Components_gem_gem);
                        }
                        Function0<Unit> onDisabled$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnDisabled$com_talabat_Components_gem_gem();
                        if (onDisabled$com_talabat_Components_gem_gem != null) {
                            gemFloatingView.onDisabledAction = new SingleAccess(onDisabled$com_talabat_Components_gem_gem);
                        }
                    }
                });
            }
        });
    }
}
