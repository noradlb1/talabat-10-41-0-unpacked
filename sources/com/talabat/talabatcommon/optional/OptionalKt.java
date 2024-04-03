package com.talabat.talabatcommon.optional;

import com.talabat.talabatcommon.optional.Optional;
import fv.a;
import fv.b;
import fv.c;
import fv.d;
import fv.e;
import fv.f;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0001\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0005\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0006\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"filterOptionalNone", "Lio/reactivex/Maybe;", "T", "", "Lcom/talabat/talabatcommon/optional/Optional;", "Lio/reactivex/Observable;", "Lio/reactivex/Single;", "toOptional", "(Ljava/lang/Object;)Lcom/talabat/talabatcommon/optional/Optional;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OptionalKt {
    @NotNull
    public static final <T> Observable<T> filterOptionalNone(@NotNull Observable<Optional<T>> observable) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Observable<R> map = observable.filter(new e()).map(new f());
        Intrinsics.checkNotNullExpressionValue(map, "this.filter { it is Opti… .map { it.toNullable() }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: filterOptionalNone$lambda-0  reason: not valid java name */
    public static final boolean m10935filterOptionalNone$lambda0(Optional optional) {
        Intrinsics.checkNotNullParameter(optional, "it");
        return optional instanceof Optional.Some;
    }

    /* access modifiers changed from: private */
    /* renamed from: filterOptionalNone$lambda-1  reason: not valid java name */
    public static final Object m10936filterOptionalNone$lambda1(Optional optional) {
        Intrinsics.checkNotNullParameter(optional, "it");
        return optional.toNullable();
    }

    /* access modifiers changed from: private */
    /* renamed from: filterOptionalNone$lambda-2  reason: not valid java name */
    public static final boolean m10937filterOptionalNone$lambda2(Optional optional) {
        Intrinsics.checkNotNullParameter(optional, "it");
        return optional instanceof Optional.Some;
    }

    /* access modifiers changed from: private */
    /* renamed from: filterOptionalNone$lambda-3  reason: not valid java name */
    public static final Object m10938filterOptionalNone$lambda3(Optional optional) {
        Intrinsics.checkNotNullParameter(optional, "it");
        return optional.toNullable();
    }

    /* access modifiers changed from: private */
    /* renamed from: filterOptionalNone$lambda-4  reason: not valid java name */
    public static final boolean m10939filterOptionalNone$lambda4(Optional optional) {
        Intrinsics.checkNotNullParameter(optional, "it");
        return optional instanceof Optional.Some;
    }

    /* access modifiers changed from: private */
    /* renamed from: filterOptionalNone$lambda-5  reason: not valid java name */
    public static final Object m10940filterOptionalNone$lambda5(Optional optional) {
        Intrinsics.checkNotNullParameter(optional, "it");
        return optional.toNullable();
    }

    @NotNull
    public static final <T> Optional<T> toOptional(@Nullable T t11) {
        return t11 == null ? Optional.None.INSTANCE : new Optional.Some(t11);
    }

    @NotNull
    public static final <T> Maybe<T> filterOptionalNone(@NotNull Single<Optional<T>> single) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        Maybe<R> map = single.filter(new c()).map(new d());
        Intrinsics.checkNotNullExpressionValue(map, "this.filter { it is Opti… .map { it.toNullable() }");
        return map;
    }

    @NotNull
    public static final <T> Maybe<T> filterOptionalNone(@NotNull Maybe<Optional<T>> maybe) {
        Intrinsics.checkNotNullParameter(maybe, "<this>");
        Maybe<R> map = maybe.filter(new a()).map(new b());
        Intrinsics.checkNotNullExpressionValue(map, "this.filter { it is Opti… .map { it.toNullable() }");
        return map;
    }
}
