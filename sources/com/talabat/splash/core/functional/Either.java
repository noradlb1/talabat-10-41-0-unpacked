package com.talabat.splash.core.functional;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003:\u0002\u0015\u0016B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J.\u0010\t\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00030\u000bJ\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000e\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u000f\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0013\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007\u0001\u0002\u000e\u0012¨\u0006\u0017"}, d2 = {"Lcom/talabat/splash/core/functional/Either;", "L", "R", "", "()V", "isLeft", "", "()Z", "isRight", "either", "fnL", "Lkotlin/Function1;", "fnR", "left", "Lcom/talabat/splash/core/functional/Either$Left;", "a", "(Ljava/lang/Object;)Lcom/talabat/splash/core/functional/Either$Left;", "right", "Lcom/talabat/splash/core/functional/Either$Right;", "b", "(Ljava/lang/Object;)Lcom/talabat/splash/core/functional/Either$Right;", "Left", "Right", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Either<L, R> {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/splash/core/functional/Either$Left;", "L", "Lcom/talabat/splash/core/functional/Either;", "", "a", "(Ljava/lang/Object;)V", "getA", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/talabat/splash/core/functional/Either$Left;", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Left<L> extends Either {

        /* renamed from: a  reason: collision with root package name */
        private final L f61424a;

        public Left(L l11) {
            super((DefaultConstructorMarker) null);
            this.f61424a = l11;
        }

        public static /* synthetic */ Left copy$default(Left left, L l11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                l11 = left.f61424a;
            }
            return left.copy(l11);
        }

        public final L component1() {
            return this.f61424a;
        }

        @NotNull
        public final Left<L> copy(L l11) {
            return new Left<>(l11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Left) && Intrinsics.areEqual((Object) this.f61424a, (Object) ((Left) obj).f61424a);
        }

        public final L getA() {
            return this.f61424a;
        }

        public int hashCode() {
            L l11 = this.f61424a;
            if (l11 == null) {
                return 0;
            }
            return l11.hashCode();
        }

        @NotNull
        public String toString() {
            L l11 = this.f61424a;
            return "Left(a=" + l11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/splash/core/functional/Either$Right;", "R", "Lcom/talabat/splash/core/functional/Either;", "", "b", "(Ljava/lang/Object;)V", "getB", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/talabat/splash/core/functional/Either$Right;", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Right<R> extends Either {

        /* renamed from: b  reason: collision with root package name */
        private final R f61425b;

        public Right(R r11) {
            super((DefaultConstructorMarker) null);
            this.f61425b = r11;
        }

        public static /* synthetic */ Right copy$default(Right right, R r11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                r11 = right.f61425b;
            }
            return right.copy(r11);
        }

        public final R component1() {
            return this.f61425b;
        }

        @NotNull
        public final Right<R> copy(R r11) {
            return new Right<>(r11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Right) && Intrinsics.areEqual((Object) this.f61425b, (Object) ((Right) obj).f61425b);
        }

        public final R getB() {
            return this.f61425b;
        }

        public int hashCode() {
            R r11 = this.f61425b;
            if (r11 == null) {
                return 0;
            }
            return r11.hashCode();
        }

        @NotNull
        public String toString() {
            R r11 = this.f61425b;
            return "Right(b=" + r11 + ")";
        }
    }

    private Either() {
    }

    public /* synthetic */ Either(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final Object either(@NotNull Function1<? super L, ? extends Object> function1, @NotNull Function1<? super R, ? extends Object> function12) {
        Intrinsics.checkNotNullParameter(function1, "fnL");
        Intrinsics.checkNotNullParameter(function12, "fnR");
        if (this instanceof Left) {
            return function1.invoke(((Left) this).getA());
        }
        if (this instanceof Right) {
            return function12.invoke(((Right) this).getB());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isLeft() {
        return this instanceof Left;
    }

    public final boolean isRight() {
        return this instanceof Right;
    }

    @NotNull
    public final <L> Left<L> left(L l11) {
        return new Left<>(l11);
    }

    @NotNull
    public final <R> Right<R> right(R r11) {
        return new Right<>(r11);
    }
}
