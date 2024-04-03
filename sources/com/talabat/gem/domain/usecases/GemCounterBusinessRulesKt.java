package com.talabat.gem.domain.usecases;

import com.facebook.internal.security.CertificateUtil;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import com.talabat.talabatcommon.extentions.BroadcastsKt;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq.a;
import wq.b;
import wq.c;
import wq.d;
import wq.e;
import wq.f;
import wq.g;
import wq.h;
import wq.i;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aC\u0010\u0007\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a²\u0001\u0010\u0010\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00010\u0001 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00110\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\bH\u0001\u001aG\u0010\u001d\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006 \u0012*\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001f0\u001f0\u001e2\u0006\u0010 \u001a\u00020\r2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\"\u001a,\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u001f*\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u001fH\u0002\u001a\u001d\u0010&\u001a\u00020\u001c*\u00020$2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010'\u001a\f\u0010(\u001a\u00020\u001c*\u00020$H\u0007\u001a%\u0010)\u001a\u00020**\u00020$2\u0006\u0010 \u001a\u00020\r2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010+\u001a\u0014\u0010,\u001a\u00020\u001c*\u00020$2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010-\u001a\u00020\u001c*\u00020$2\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a\u0001\u0010/\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001 \u0012*\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f0\u001f \u0012**\u0012$\u0012\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001 \u0012*\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f0\u001f\u0018\u00010\u00110\u0011*\u00020$2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u001f2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"ACTION_GEM_STATUS", "", "COUNTER_LAST_TICK", "COUNTER_TWO_DIGITS_FORMAT", "KEY_GEM_ENABLED", "TICK_INTERVAL_IN_SECONDS", "", "calculateRemainingMillis", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "", "gemOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "nowTimeStamp", "(Lcom/talabat/gem/domain/entities/GemOffer;Ljava/lang/Long;)Lkotlin/jvm/functions/Function1;", "countDownTimer", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "remainingMillis", "scheduler", "Lio/reactivex/Scheduler;", "tickSeconds", "millisToSeconds", "secondsToMinutes", "secondsRemainder", "format", "onRemainingSecondsChanged", "", "toRemainingMillis", "Lio/reactivex/Single;", "Lkotlin/Pair;", "offer", "now", "(Lcom/talabat/gem/domain/entities/GemOffer;Ljava/lang/Long;)Lio/reactivex/Single;", "assertCounterNotExpired", "Lcom/talabat/gem/ports/presentation/GemCounterViewPort;", "it", "bindCounterAndVisibility", "(Lcom/talabat/gem/ports/presentation/GemCounterViewPort;Ljava/lang/Long;)V", "bindCounterExpired", "countdownTimerSubscription", "Lio/reactivex/disposables/Disposable;", "(Lcom/talabat/gem/ports/presentation/GemCounterViewPort;Lcom/talabat/gem/domain/entities/GemOffer;Ljava/lang/Long;)Lio/reactivex/disposables/Disposable;", "hideAndExpire", "showAndUpdateCounter", "counterTick", "toCountdownTimer", "pair", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemCounterBusinessRulesKt {
    @NotNull
    public static final String ACTION_GEM_STATUS = "com.talabat.gem.domain.usecases.ACTION_GEM_STATUS";
    @NotNull
    private static final String COUNTER_LAST_TICK = "00:00";
    @NotNull
    private static final String COUNTER_TWO_DIGITS_FORMAT = "%02d";
    @NotNull
    public static final String KEY_GEM_ENABLED = "com.talabat.gem.domain.usecases.KEY_GEM_ENABLED";
    private static final long TICK_INTERVAL_IN_SECONDS = 1;

    private static final Pair<GemOffer, String> assertCounterNotExpired(GemCounterViewPort gemCounterViewPort, Pair<GemOffer, String> pair) {
        return !Intrinsics.areEqual(RxKt.invoke(gemCounterViewPort.getCounterExpired()), (Object) Boolean.TRUE) ? pair : Pair.copy$default(pair, (Object) null, COUNTER_LAST_TICK, 1, (Object) null);
    }

    @BusinessRules
    public static final void bindCounterAndVisibility(@NotNull GemCounterViewPort gemCounterViewPort, @Nullable Long l11) {
        Intrinsics.checkNotNullParameter(gemCounterViewPort, "<this>");
        gemCounterViewPort.autoDispose(new GemCounterBusinessRulesKt$bindCounterAndVisibility$1(gemCounterViewPort, l11));
    }

    public static /* synthetic */ void bindCounterAndVisibility$default(GemCounterViewPort gemCounterViewPort, Long l11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = null;
        }
        bindCounterAndVisibility(gemCounterViewPort, l11);
    }

    @BusinessRules
    public static final void bindCounterExpired(@NotNull GemCounterViewPort gemCounterViewPort) {
        Intrinsics.checkNotNullParameter(gemCounterViewPort, "<this>");
        gemCounterViewPort.autoDispose(new GemCounterBusinessRulesKt$bindCounterExpired$1(gemCounterViewPort));
    }

    @NotNull
    @BusinessRules
    public static final Function1<Continuation<? super Result<Long>>, Object> calculateRemainingMillis(@NotNull GemOffer gemOffer, @Nullable Long l11) {
        Intrinsics.checkNotNullParameter(gemOffer, "gemOffer");
        return KotlinResultKt.takeIf(KotlinResultKt.mapNonNull(KotlinResultKt.mapNonNull(KotlinResultKt.Either(new GemCounterBusinessRulesKt$calculateRemainingMillis$1(gemOffer, (Continuation<? super GemCounterBusinessRulesKt$calculateRemainingMillis$1>) null)), new GemCounterBusinessRulesKt$calculateRemainingMillis$2((Continuation<? super GemCounterBusinessRulesKt$calculateRemainingMillis$2>) null)), new GemCounterBusinessRulesKt$calculateRemainingMillis$3(l11, (Continuation<? super GemCounterBusinessRulesKt$calculateRemainingMillis$3>) null)), new GemCounterBusinessRulesKt$calculateRemainingMillis$4((Continuation<? super GemCounterBusinessRulesKt$calculateRemainingMillis$4>) null));
    }

    public static /* synthetic */ Function1 calculateRemainingMillis$default(GemOffer gemOffer, Long l11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            l11 = null;
        }
        return calculateRemainingMillis(gemOffer, l11);
    }

    @BusinessRules
    public static final Observable<String> countDownTimer(long j11, @NotNull Scheduler scheduler, long j12, @NotNull Function1<? super Long, Long> function1, @NotNull Function1<? super Long, Long> function12, @NotNull Function1<? super Long, Long> function13, @NotNull Function1<? super Long, String> function14, @NotNull Function1<? super Long, Unit> function15) {
        Function1<? super Long, Long> function16 = function1;
        Function1<? super Long, Long> function17 = function12;
        Function1<? super Long, Long> function18 = function13;
        Function1<? super Long, String> function19 = function14;
        Function1<? super Long, Unit> function110 = function15;
        Scheduler scheduler2 = scheduler;
        Intrinsics.checkNotNullParameter(scheduler2, "scheduler");
        Intrinsics.checkNotNullParameter(function16, "millisToSeconds");
        Intrinsics.checkNotNullParameter(function17, "secondsToMinutes");
        Intrinsics.checkNotNullParameter(function18, "secondsRemainder");
        Intrinsics.checkNotNullParameter(function19, "format");
        Intrinsics.checkNotNullParameter(function110, "onRemainingSecondsChanged");
        return Observable.intervalRange(0, function16.invoke(Long.valueOf(j11)).longValue() + 1, 0, j12, TimeUnit.SECONDS, scheduler2).map(new b(function16, j11)).doOnNext(new c(function110)).map(new d(function19, function17, function18));
    }

    public static /* synthetic */ Observable countDownTimer$default(long j11, Scheduler scheduler, long j12, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i11, Object obj) {
        long j13;
        GemCounterBusinessRulesKt$countDownTimer$1 gemCounterBusinessRulesKt$countDownTimer$1;
        GemCounterBusinessRulesKt$countDownTimer$2 gemCounterBusinessRulesKt$countDownTimer$2;
        GemCounterBusinessRulesKt$countDownTimer$3 gemCounterBusinessRulesKt$countDownTimer$3;
        GemCounterBusinessRulesKt$countDownTimer$4 gemCounterBusinessRulesKt$countDownTimer$4;
        if ((i11 & 4) != 0) {
            j13 = 1;
        } else {
            j13 = j12;
        }
        if ((i11 & 8) != 0) {
            gemCounterBusinessRulesKt$countDownTimer$1 = GemCounterBusinessRulesKt$countDownTimer$1.INSTANCE;
        } else {
            gemCounterBusinessRulesKt$countDownTimer$1 = function1;
        }
        if ((i11 & 16) != 0) {
            gemCounterBusinessRulesKt$countDownTimer$2 = GemCounterBusinessRulesKt$countDownTimer$2.INSTANCE;
        } else {
            gemCounterBusinessRulesKt$countDownTimer$2 = function12;
        }
        if ((i11 & 32) != 0) {
            gemCounterBusinessRulesKt$countDownTimer$3 = GemCounterBusinessRulesKt$countDownTimer$3.INSTANCE;
        } else {
            gemCounterBusinessRulesKt$countDownTimer$3 = function13;
        }
        if ((i11 & 64) != 0) {
            gemCounterBusinessRulesKt$countDownTimer$4 = GemCounterBusinessRulesKt$countDownTimer$4.INSTANCE;
        } else {
            gemCounterBusinessRulesKt$countDownTimer$4 = function14;
        }
        return countDownTimer(j11, scheduler, j13, gemCounterBusinessRulesKt$countDownTimer$1, gemCounterBusinessRulesKt$countDownTimer$2, gemCounterBusinessRulesKt$countDownTimer$3, gemCounterBusinessRulesKt$countDownTimer$4, function15);
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTimer$lambda-6  reason: not valid java name */
    public static final Long m10549countDownTimer$lambda6(Function1 function1, long j11, Long l11) {
        Intrinsics.checkNotNullParameter(function1, "$millisToSeconds");
        Intrinsics.checkNotNullParameter(l11, "it");
        return Long.valueOf(((Number) function1.invoke(Long.valueOf(j11))).longValue() - l11.longValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTimer$lambda-7  reason: not valid java name */
    public static final void m10550countDownTimer$lambda7(Function1 function1, Long l11) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(l11);
    }

    /* access modifiers changed from: private */
    /* renamed from: countDownTimer$lambda-8  reason: not valid java name */
    public static final String m10551countDownTimer$lambda8(Function1 function1, Function1 function12, Function1 function13, Long l11) {
        Intrinsics.checkNotNullParameter(function1, "$format");
        Intrinsics.checkNotNullParameter(function12, "$secondsToMinutes");
        Intrinsics.checkNotNullParameter(function13, "$secondsRemainder");
        Intrinsics.checkNotNullParameter(l11, "it");
        Object invoke = function1.invoke(function12.invoke(l11));
        Object invoke2 = function1.invoke(function13.invoke(l11));
        return invoke + CertificateUtil.DELIMITER + invoke2;
    }

    /* access modifiers changed from: private */
    public static final Disposable countdownTimerSubscription(GemCounterViewPort gemCounterViewPort, GemOffer gemOffer, Long l11) {
        Observable<R> doOnComplete = toRemainingMillis(gemOffer, l11).toObservable().subscribeOn(gemCounterViewPort.getScheduler()).observeOn(gemCounterViewPort.getScheduler()).flatMap(new e(gemCounterViewPort)).map(new f(gemCounterViewPort)).doOnError(new g(gemCounterViewPort)).doOnComplete(new h(gemCounterViewPort));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "toRemainingMillis(offer,…e { visibility += false }");
        return SubscribersKt.subscribeBy$default((Observable) doOnComplete, (Function1) new GemCounterBusinessRulesKt$countdownTimerSubscription$5(gemCounterViewPort.getErrors()), (Function0) null, (Function1) new GemCounterBusinessRulesKt$countdownTimerSubscription$6(gemCounterViewPort), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: countdownTimerSubscription$lambda-0  reason: not valid java name */
    public static final ObservableSource m10552countdownTimerSubscription$lambda0(GemCounterViewPort gemCounterViewPort, Pair pair) {
        Intrinsics.checkNotNullParameter(gemCounterViewPort, "$this_countdownTimerSubscription");
        Intrinsics.checkNotNullParameter(pair, "it");
        return toCountdownTimer(gemCounterViewPort, pair, new GemCounterBusinessRulesKt$countdownTimerSubscription$1$1(gemCounterViewPort.getRemainingSeconds()));
    }

    /* access modifiers changed from: private */
    /* renamed from: countdownTimerSubscription$lambda-1  reason: not valid java name */
    public static final Pair m10553countdownTimerSubscription$lambda1(GemCounterViewPort gemCounterViewPort, Pair pair) {
        Intrinsics.checkNotNullParameter(gemCounterViewPort, "$this_countdownTimerSubscription");
        Intrinsics.checkNotNullParameter(pair, "it");
        return assertCounterNotExpired(gemCounterViewPort, pair);
    }

    /* access modifiers changed from: private */
    /* renamed from: countdownTimerSubscription$lambda-2  reason: not valid java name */
    public static final void m10554countdownTimerSubscription$lambda2(GemCounterViewPort gemCounterViewPort, Throwable th2) {
        Intrinsics.checkNotNullParameter(gemCounterViewPort, "$this_countdownTimerSubscription");
        RxKt.plusAssign(gemCounterViewPort.getVisibility(), Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    /* renamed from: countdownTimerSubscription$lambda-3  reason: not valid java name */
    public static final void m10555countdownTimerSubscription$lambda3(GemCounterViewPort gemCounterViewPort) {
        Intrinsics.checkNotNullParameter(gemCounterViewPort, "$this_countdownTimerSubscription");
        RxKt.plusAssign(gemCounterViewPort.getVisibility(), Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public static final void hideAndExpire(GemCounterViewPort gemCounterViewPort, GemOffer gemOffer) {
        BehaviorSubject<Boolean> visibility = gemCounterViewPort.getVisibility();
        Boolean bool = Boolean.FALSE;
        RxKt.plusAssign(visibility, bool);
        IntegrationKt.getDataSources().updateExpiredOffer(gemOffer);
        BroadcastsKt.sendBroadcast("com.talabat.gem.domain.usecases.ACTION_GEM_STATUS", TuplesKt.to("com.talabat.gem.domain.usecases.KEY_GEM_ENABLED", bool));
        RxKt.plusAssign(gemCounterViewPort.getCounterExpired(), bool);
    }

    /* access modifiers changed from: private */
    public static final void showAndUpdateCounter(GemCounterViewPort gemCounterViewPort, String str) {
        RxKt.plusAssign(gemCounterViewPort.getVisibility(), Boolean.TRUE);
        RxKt.plusAssign(gemCounterViewPort.getCounter(), str);
    }

    private static final Observable<Pair<GemOffer, String>> toCountdownTimer(GemCounterViewPort gemCounterViewPort, Pair<GemOffer, Long> pair, Function1<? super Long, Unit> function1) {
        return countDownTimer$default(pair.getSecond().longValue(), gemCounterViewPort.getScheduler(), 0, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function1, 124, (Object) null).map(new a(pair));
    }

    /* access modifiers changed from: private */
    /* renamed from: toCountdownTimer$lambda-4  reason: not valid java name */
    public static final Pair m10556toCountdownTimer$lambda4(Pair pair, String str) {
        Intrinsics.checkNotNullParameter(pair, "$pair");
        Intrinsics.checkNotNullParameter(str, "it");
        return TuplesKt.to(pair.getFirst(), str);
    }

    private static final Single<Pair<GemOffer, Long>> toRemainingMillis(GemOffer gemOffer, Long l11) {
        Single<Pair<GemOffer, Long>> map = KotlinResultKt.toSingle$default(calculateRemainingMillis(gemOffer, l11), (Function1) null, 1, (Object) null).map(new i(gemOffer));
        Intrinsics.checkNotNullExpressionValue(map, "calculateRemainingMillis…\n    .map { offer to it }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: toRemainingMillis$lambda-5  reason: not valid java name */
    public static final Pair m10557toRemainingMillis$lambda5(GemOffer gemOffer, Long l11) {
        Intrinsics.checkNotNullParameter(gemOffer, "$offer");
        Intrinsics.checkNotNullParameter(l11, "it");
        return TuplesKt.to(gemOffer, l11);
    }
}
