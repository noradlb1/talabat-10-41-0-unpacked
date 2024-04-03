package com.talabat.splash.core.functional;

import com.facebook.appevents.UserDataStore;
import com.talabat.splash.core.functional.Either;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aH\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0001\u001aT\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\n*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\n0\u00072\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u00070\u0001\u001aH\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\n*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\n0\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\t0\u0001¨\u0006\r"}, d2 = {"c", "Lkotlin/Function1;", "A", "C", "B", "f", "flatMap", "Lcom/talabat/splash/core/functional/Either;", "L", "T", "R", "fn", "map", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class EitherKt {
    @NotNull
    public static final <A, B, C> Function1<A, C> c(@NotNull Function1<? super A, ? extends B> function1, @NotNull Function1<? super B, ? extends C> function12) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function12, "f");
        return new EitherKt$c$1(function12, function1);
    }

    @NotNull
    public static final <T, L, R> Either<L, T> flatMap(@NotNull Either<? extends L, ? extends R> either, @NotNull Function1<? super R, ? extends Either<? extends L, ? extends T>> function1) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(function1, UserDataStore.FIRST_NAME);
        if (either instanceof Either.Left) {
            return new Either.Left(((Either.Left) either).getA());
        }
        if (either instanceof Either.Right) {
            return (Either) function1.invoke(((Either.Right) either).getB());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <T, L, R> Either<L, T> map(@NotNull Either<? extends L, ? extends R> either, @NotNull Function1<? super R, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(function1, UserDataStore.FIRST_NAME);
        return flatMap(either, c(function1, new EitherKt$map$1(either)));
    }
}
