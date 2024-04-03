package com.talabat.darkstores.common;

import com.talabat.darkstores.common.Result;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import xh.a;
import xh.b;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aH\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00040\u00012\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0007H\bø\u0001\u0000\u001a&\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00020\u0001\"\b\b\u0000\u0010\b*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\b0\u0001\u001aH\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00040\t2\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0007H\bø\u0001\u0000\u001a&\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00020\u0001\"\b\b\u0000\u0010\b*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\b0\t\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"toResult", "Lio/reactivex/Observable;", "Lcom/talabat/darkstores/common/Result;", "OutputType", "InputType", "", "mapper", "Lkotlin/Function1;", "Type", "Lio/reactivex/Single;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ResultKt {
    @NotNull
    public static final <Type> Observable<Result<Type>> toResult(@NotNull Observable<Type> observable) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Observable<R> startWith = observable.map(new a()).onErrorReturn(new b()).startWith(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(startWith, "map<Result<Type>> { Resu…artWith(Result.Loading())");
        return startWith;
    }

    /* access modifiers changed from: private */
    /* renamed from: toResult$lambda-0  reason: not valid java name */
    public static final Result m9629toResult$lambda0(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return new Result.Success(obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: toResult$lambda-1  reason: not valid java name */
    public static final Result m9630toResult$lambda1(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new Result.Error(th2, false, (Object) null, 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final <InputType, OutputType> Observable<Result<OutputType>> toResult(@NotNull Observable<InputType> observable, @NotNull Function1<? super InputType, ? extends OutputType> function1) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        Observable<R> startWith = observable.map(new ResultKt$toResult$3(function1)).onErrorReturn(ResultKt$toResult$4.INSTANCE).startWith(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(startWith, "crossinline mapper: (Inp…artWith(Result.Loading())");
        return startWith;
    }

    @NotNull
    public static final <Type> Observable<Result<Type>> toResult(@NotNull Single<Type> single) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        Observable<Type> observable = single.toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "toObservable()");
        return toResult(observable);
    }

    @NotNull
    public static final <InputType, OutputType> Observable<Result<OutputType>> toResult(@NotNull Single<InputType> single, @NotNull Function1<? super InputType, ? extends OutputType> function1) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        Observable<InputType> observable = single.toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "toObservable()");
        Observable<R> startWith = observable.map(new ResultKt$toResult$3(function1)).onErrorReturn(ResultKt$toResult$4.INSTANCE).startWith(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(startWith, "crossinline mapper: (Inp…artWith(Result.Loading())");
        return startWith;
    }
}
