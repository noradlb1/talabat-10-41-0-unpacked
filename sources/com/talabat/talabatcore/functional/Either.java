package com.talabat.talabatcore.functional;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003:\u0002\u0017\u0018B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J9\u0010\t\u001a\u0002H\n\"\u0004\b\u0002\u0010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\n0\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u0011\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0014\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0015\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007\u0001\u0002\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatcore/functional/Either;", "L", "R", "", "()V", "isLeft", "", "()Z", "isRight", "either", "OutputType", "fnL", "Lkotlin/Function1;", "fnR", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "left", "Lcom/talabat/talabatcore/functional/Either$Left;", "a", "(Ljava/lang/Object;)Lcom/talabat/talabatcore/functional/Either$Left;", "right", "Lcom/talabat/talabatcore/functional/Either$Right;", "b", "(Ljava/lang/Object;)Lcom/talabat/talabatcore/functional/Either$Right;", "Left", "Right", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Either<L, R> {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcore/functional/Either$Left;", "L", "Lcom/talabat/talabatcore/functional/Either;", "", "a", "(Ljava/lang/Object;)V", "getA", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/talabat/talabatcore/functional/Either$Left;", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Left<L> extends Either {

        /* renamed from: a  reason: collision with root package name */
        private final L f12018a;

        public Left(L l11) {
            super((DefaultConstructorMarker) null);
            this.f12018a = l11;
        }

        public static /* synthetic */ Left copy$default(Left left, L l11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                l11 = left.f12018a;
            }
            return left.copy(l11);
        }

        public final L component1() {
            return this.f12018a;
        }

        @NotNull
        public final Left<L> copy(L l11) {
            return new Left<>(l11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Left) && Intrinsics.areEqual((Object) this.f12018a, (Object) ((Left) obj).f12018a);
        }

        public final L getA() {
            return this.f12018a;
        }

        public int hashCode() {
            L l11 = this.f12018a;
            if (l11 == null) {
                return 0;
            }
            return l11.hashCode();
        }

        @NotNull
        public String toString() {
            L l11 = this.f12018a;
            return "Left(a=" + l11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcore/functional/Either$Right;", "R", "Lcom/talabat/talabatcore/functional/Either;", "", "b", "(Ljava/lang/Object;)V", "getB", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/talabat/talabatcore/functional/Either$Right;", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Right<R> extends Either {

        /* renamed from: b  reason: collision with root package name */
        private final R f12019b;

        public Right(R r11) {
            super((DefaultConstructorMarker) null);
            this.f12019b = r11;
        }

        public static /* synthetic */ Right copy$default(Right right, R r11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                r11 = right.f12019b;
            }
            return right.copy(r11);
        }

        public final R component1() {
            return this.f12019b;
        }

        @NotNull
        public final Right<R> copy(R r11) {
            return new Right<>(r11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Right) && Intrinsics.areEqual((Object) this.f12019b, (Object) ((Right) obj).f12019b);
        }

        public final R getB() {
            return this.f12019b;
        }

        public int hashCode() {
            R r11 = this.f12019b;
            if (r11 == null) {
                return 0;
            }
            return r11.hashCode();
        }

        @NotNull
        public String toString() {
            R r11 = this.f12019b;
            return "Right(b=" + r11 + ")";
        }
    }

    private Either() {
    }

    public /* synthetic */ Either(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final <OutputType> OutputType either(@NotNull Function1<? super L, ? extends OutputType> function1, @NotNull Function1<? super R, ? extends OutputType> function12) {
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
