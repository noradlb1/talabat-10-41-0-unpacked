package com.talabat.gem.ports.analytics;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.talabatcommon.extentions.Nullable;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006R\u0016\u0010 \u001a\u00060\u0003j\u0002`\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0006¨\u0006\""}, d2 = {"Lcom/talabat/gem/ports/analytics/GemAnalyticsTriggersPort;", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "bindLastTierReached", "", "Lcom/talabat/gem/domain/usecases/BusinessRule;", "getBindLastTierReached", "()Lkotlin/Unit;", "bindOffer", "getBindOffer", "errors", "Lio/reactivex/subjects/Subject;", "", "getErrors", "()Lio/reactivex/subjects/Subject;", "lastTierReached", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/talabatcommon/extentions/Nullable;", "Lcom/talabat/gem/domain/entities/GemTier;", "getLastTierReached", "()Lio/reactivex/subjects/BehaviorSubject;", "offer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getOffer", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "subTotal", "", "getSubTotal", "triggerOfferExpired", "getTriggerOfferExpired", "triggerTierReached", "getTriggerTierReached", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemAnalyticsTriggersPort extends AutoDisposable {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @AutoDisposableDsl
        public static void autoDispose(@NotNull GemAnalyticsTriggersPort gemAnalyticsTriggersPort, @NotNull Function0<? extends Disposable> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            AutoDisposable.DefaultImpls.autoDispose(gemAnalyticsTriggersPort, function0);
        }

        public static void onCleared(@NotNull GemAnalyticsTriggersPort gemAnalyticsTriggersPort) {
            AutoDisposable.DefaultImpls.onCleared(gemAnalyticsTriggersPort);
        }

        @AutoDisposableDsl
        public static void onClearedImplementation(@NotNull GemAnalyticsTriggersPort gemAnalyticsTriggersPort) {
            AutoDisposable.DefaultImpls.onClearedImplementation(gemAnalyticsTriggersPort);
        }
    }

    @NotNull
    Unit getBindLastTierReached();

    @NotNull
    Unit getBindOffer();

    @NotNull
    Subject<Throwable> getErrors();

    @NotNull
    BehaviorSubject<Nullable<GemTier>> getLastTierReached();

    @NotNull
    BehaviorSubject<GemOffer> getOffer();

    @NotNull
    Scheduler getScheduler();

    @NotNull
    BehaviorSubject<Double> getSubTotal();

    @NotNull
    Unit getTriggerOfferExpired();

    @NotNull
    Unit getTriggerTierReached();
}
