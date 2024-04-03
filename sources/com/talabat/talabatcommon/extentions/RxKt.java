package com.talabat.talabatcommon.extentions;

import av.l;
import av.m;
import av.n;
import av.o;
import av.p;
import av.q;
import av.r;
import av.s;
import av.t;
import av.u;
import av.v;
import av.w;
import av.x;
import av.y;
import av.z;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u0001H\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a&\u0010\u0006\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00072\u0006\u0010\u0004\u001a\u0002H\u0003H\u0002¢\u0006\u0002\u0010\b\u001a&\u0010\u0006\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010\u0004\u001a\u0002H\u0003H\u0002¢\u0006\u0002\u0010\t\u001a \u0010\n\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0007H\u0002¢\u0006\u0002\u0010\u000b\u001a2\u0010\n\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0003`\fH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001aD\u0010\n\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00102)\u0010\u0011\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00100\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0002\u001aD\u0010\n\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00162)\u0010\u0011\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00160\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0002\u001aD\u0010\n\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00172)\u0010\u0011\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00170\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0002\u001aD\u0010\n\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00182)\u0010\u0011\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00180\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0002\u001a \u0010\n\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0002¢\u0006\u0002\u0010\u000e\u001a\u0016\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0007\u001a\u001e\u0010\u001b\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u001e\u001a#\u0010\u001f\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u001c2\u0006\u0010 \u001a\u0002H\u0003¢\u0006\u0002\u0010!\u001a6\u0010\"\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0003*\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0003`\f2\u0006\u0010#\u001a\u0002H\u0003H\u0002¢\u0006\u0002\u0010$\u001a&\u0010\"\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030%2\u0006\u0010#\u001a\u0002H\u0003H\u0002¢\u0006\u0002\u0010&\u001a\u001f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0003*\u0004\u0018\u0001H\u0003H\u0007¢\u0006\u0002\u0010(*(\u0010\u0000\u001a\u0004\b\u0000\u0010\u0003\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001¨\u0006)"}, d2 = {"SingleAccessSubject", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/talabatcommon/extentions/SingleAccess;", "T", "defaultValue", "(Ljava/lang/Object;)Lio/reactivex/subjects/BehaviorSubject;", "get", "Lcom/talabat/talabatcommon/extentions/Nullable;", "(Lcom/talabat/talabatcommon/extentions/Nullable;Ljava/lang/Object;)Ljava/lang/Object;", "(Lio/reactivex/subjects/BehaviorSubject;Ljava/lang/Object;)Ljava/lang/Object;", "invoke", "(Lcom/talabat/talabatcommon/extentions/Nullable;)Ljava/lang/Object;", "Lcom/talabat/talabatcommon/extentions/SingleAccessSubject;", "invokeSingleAccess", "(Lio/reactivex/subjects/BehaviorSubject;)Ljava/lang/Object;", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/Flowable;", "observer", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/extentions/ObserverCallbacks;", "", "Lkotlin/ExtensionFunctionType;", "Lio/reactivex/Maybe;", "Lio/reactivex/Observable;", "Lio/reactivex/Single;", "isNotNull", "", "onErrorIfNotDisposed", "Lio/reactivex/SingleEmitter;", "throwable", "", "onSuccessIfNotDisposed", "t", "(Lio/reactivex/SingleEmitter;Ljava/lang/Object;)V", "plusAssign", "item", "(Lio/reactivex/subjects/BehaviorSubject;Ljava/lang/Object;)V", "Lio/reactivex/subjects/Subject;", "(Lio/reactivex/subjects/Subject;Ljava/lang/Object;)V", "toNullable", "(Ljava/lang/Object;)Lcom/talabat/talabatcommon/extentions/Nullable;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RxKt {
    @NotNull
    @RxDsl
    public static final <T> BehaviorSubject<SingleAccess<T>> SingleAccessSubject(@Nullable T t11) {
        if (t11 != null) {
            BehaviorSubject<SingleAccess<T>> createDefault = BehaviorSubject.createDefault(new SingleAccess(t11));
            Intrinsics.checkNotNullExpressionValue(createDefault, "createDefault(SingleAccess(defaultValue))");
            return createDefault;
        }
        BehaviorSubject<SingleAccess<T>> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        return create;
    }

    public static /* synthetic */ BehaviorSubject SingleAccessSubject$default(Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = null;
        }
        return SingleAccessSubject(obj);
    }

    @RxDsl
    public static final <T> T get(@NotNull BehaviorSubject<T> behaviorSubject, T t11) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "<this>");
        T value = behaviorSubject.getValue();
        return value == null ? t11 : value;
    }

    @NotNull
    @RxDsl
    public static final <T> Disposable invoke(@NotNull Observable<T> observable, @NotNull Function1<? super ObserverCallbacks<T, Observable<T>>, Unit> function1) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "observer");
        ObserverCallbacks observerCallbacks = new ObserverCallbacks();
        function1.invoke(observerCallbacks);
        Disposable subscribe = observable.share().compose(new l(observerCallbacks.getTransformer$com_talabat_NewArchi_TalabatCommon_TalabatCommon())).observeOn(observerCallbacks.getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon().getValue()).subscribe(new r(observerCallbacks.getOnNext$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new s(observerCallbacks.getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new t(observerCallbacks.getOnComplete$com_talabat_NewArchi_TalabatCommon_TalabatCommon()));
        Intrinsics.checkNotNullExpressionValue(subscribe, "share()\n        .compose…or, callbacks.onComplete)");
        return subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final ObservableSource m9361invoke$lambda0(Function1 function1, Observable observable) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        Intrinsics.checkNotNullParameter(observable, "p0");
        return (ObservableSource) function1.invoke(observable);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m9362invoke$lambda1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-10  reason: not valid java name */
    public static final void m9363invoke$lambda10(Function1 function1, Throwable th2) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-11  reason: not valid java name */
    public static final MaybeSource m9364invoke$lambda11(Function1 function1, Maybe maybe) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        Intrinsics.checkNotNullParameter(maybe, "p0");
        return (MaybeSource) function1.invoke(maybe);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-12  reason: not valid java name */
    public static final void m9365invoke$lambda12(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-13  reason: not valid java name */
    public static final void m9366invoke$lambda13(Function1 function1, Throwable th2) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-14  reason: not valid java name */
    public static final void m9367invoke$lambda14(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m9368invoke$lambda2(Function1 function1, Throwable th2) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final void m9369invoke$lambda3(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-4  reason: not valid java name */
    public static final Publisher m9370invoke$lambda4(Function1 function1, Flowable flowable) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        Intrinsics.checkNotNullParameter(flowable, "p0");
        return (Publisher) function1.invoke(flowable);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-5  reason: not valid java name */
    public static final void m9371invoke$lambda5(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-6  reason: not valid java name */
    public static final void m9372invoke$lambda6(Function1 function1, Throwable th2) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-7  reason: not valid java name */
    public static final void m9373invoke$lambda7(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-8  reason: not valid java name */
    public static final SingleSource m9374invoke$lambda8(Function1 function1, Single single) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        Intrinsics.checkNotNullParameter(single, "p0");
        return (SingleSource) function1.invoke(single);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-9  reason: not valid java name */
    public static final void m9375invoke$lambda9(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    @Nullable
    @RxDsl
    @JvmName(name = "invokeSingleAccess")
    public static final <T> T invokeSingleAccess(@NotNull BehaviorSubject<SingleAccess<T>> behaviorSubject) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "<this>");
        SingleAccess value = behaviorSubject.getValue();
        if (value != null) {
            return value.invoke();
        }
        return null;
    }

    public static final <T> boolean isNotNull(@NotNull Nullable<T> nullable) {
        Intrinsics.checkNotNullParameter(nullable, "<this>");
        if (nullable.getValue() != null) {
            return true;
        }
        return false;
    }

    public static final <T> void onErrorIfNotDisposed(@NotNull SingleEmitter<T> singleEmitter, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(singleEmitter, "<this>");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        if (!singleEmitter.isDisposed()) {
            singleEmitter.onError(th2);
        }
    }

    public static final <T> void onSuccessIfNotDisposed(@NotNull SingleEmitter<T> singleEmitter, T t11) {
        Intrinsics.checkNotNullParameter(singleEmitter, "<this>");
        if (!singleEmitter.isDisposed()) {
            singleEmitter.onSuccess(t11);
        }
    }

    @RxDsl
    public static final <T> void plusAssign(@NotNull Subject<T> subject, T t11) {
        Intrinsics.checkNotNullParameter(subject, "<this>");
        subject.onNext(t11);
    }

    @NotNull
    @RxDsl
    public static final <T> Nullable<T> toNullable(@Nullable T t11) {
        return new Nullable<>(t11);
    }

    @RxDsl
    public static final <T> T get(@NotNull Nullable<T> nullable, T t11) {
        Intrinsics.checkNotNullParameter(nullable, "<this>");
        T value = nullable.getValue();
        return value == null ? t11 : value;
    }

    @RxDsl
    public static final <T> void plusAssign(@NotNull BehaviorSubject<SingleAccess<T>> behaviorSubject, T t11) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "<this>");
        behaviorSubject.onNext(new SingleAccess(t11));
    }

    @NotNull
    @RxDsl
    public static final <T> Disposable invoke(@NotNull Flowable<T> flowable, @NotNull Function1<? super ObserverCallbacks<T, Flowable<T>>, Unit> function1) {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "observer");
        ObserverCallbacks observerCallbacks = new ObserverCallbacks();
        function1.invoke(observerCallbacks);
        Disposable subscribe = flowable.share().compose(new u(observerCallbacks.getTransformer$com_talabat_NewArchi_TalabatCommon_TalabatCommon())).observeOn(observerCallbacks.getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon().getValue()).subscribe(new v(observerCallbacks.getOnNext$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new w(observerCallbacks.getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new x(observerCallbacks.getOnComplete$com_talabat_NewArchi_TalabatCommon_TalabatCommon()));
        Intrinsics.checkNotNullExpressionValue(subscribe, "share()\n        .compose…or, callbacks.onComplete)");
        return subscribe;
    }

    @NotNull
    @RxDsl
    public static final <T> Disposable invoke(@NotNull Single<T> single, @NotNull Function1<? super ObserverCallbacks<T, Single<T>>, Unit> function1) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        Intrinsics.checkNotNullParameter(function1, "observer");
        ObserverCallbacks observerCallbacks = new ObserverCallbacks();
        function1.invoke(observerCallbacks);
        Disposable subscribe = single.compose(new o(observerCallbacks.getTransformer$com_talabat_NewArchi_TalabatCommon_TalabatCommon())).observeOn(observerCallbacks.getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon().getValue()).subscribe(new p(observerCallbacks.getOnNext$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new q(observerCallbacks.getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon()));
        Intrinsics.checkNotNullExpressionValue(subscribe, "compose(callbacks.transf…nNext, callbacks.onError)");
        return subscribe;
    }

    @NotNull
    @RxDsl
    public static final <T> Disposable invoke(@NotNull Maybe<T> maybe, @NotNull Function1<? super ObserverCallbacks<T, Maybe<T>>, Unit> function1) {
        Intrinsics.checkNotNullParameter(maybe, "<this>");
        Intrinsics.checkNotNullParameter(function1, "observer");
        ObserverCallbacks observerCallbacks = new ObserverCallbacks();
        function1.invoke(observerCallbacks);
        Disposable subscribe = maybe.compose(new y(observerCallbacks.getTransformer$com_talabat_NewArchi_TalabatCommon_TalabatCommon())).observeOn(observerCallbacks.getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon().getValue()).subscribe(new z(observerCallbacks.getOnNext$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new m(observerCallbacks.getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new n(observerCallbacks.getOnComplete$com_talabat_NewArchi_TalabatCommon_TalabatCommon()));
        Intrinsics.checkNotNullExpressionValue(subscribe, "compose(callbacks.transf…or, callbacks.onComplete)");
        return subscribe;
    }

    @RxDsl
    @Nullable
    public static final <T> T invoke(@NotNull BehaviorSubject<T> behaviorSubject) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "<this>");
        return behaviorSubject.getValue();
    }

    @RxDsl
    @Nullable
    public static final <T> T invoke(@NotNull Nullable<T> nullable) {
        Intrinsics.checkNotNullParameter(nullable, "<this>");
        return nullable.getValue();
    }
}
