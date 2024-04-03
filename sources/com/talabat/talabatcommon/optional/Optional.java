package com.talabat.talabatcommon.optional;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0002\u0010\u0011B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J6\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0000\"\b\b\u0001\u0010\u0005*\u00020\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00000\u0007H\bø\u0001\u0000J=\u0010\b\u001a\u0002H\u0005\"\b\b\u0001\u0010\u0005*\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00050\u0007H\bø\u0001\u0000¢\u0006\u0002\u0010\fJ2\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0000\"\b\b\u0001\u0010\u0005*\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0007H\bø\u0001\u0000J\r\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000f\u0001\u0002\u0012\u0013\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/optional/Optional;", "T", "", "()V", "flatMap", "U", "f", "Lkotlin/Function1;", "fold", "onEmpty", "Lkotlin/Function0;", "onDefined", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "map", "toNullable", "()Ljava/lang/Object;", "None", "Some", "Lcom/talabat/talabatcommon/optional/Optional$Some;", "Lcom/talabat/talabatcommon/optional/Optional$None;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Optional<T> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/optional/Optional$None;", "Lcom/talabat/talabatcommon/optional/Optional;", "", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class None extends Optional {
        @NotNull
        public static final None INSTANCE = new None();

        private None() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\n\b\u0001\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/optional/Optional$Some;", "T", "", "Lcom/talabat/talabatcommon/optional/Optional;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/talabat/talabatcommon/optional/Optional$Some;", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Some<T> extends Optional<T> {
        @NotNull
        private final T value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Some(@NotNull T t11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(t11, "value");
            this.value = t11;
        }

        public static /* synthetic */ Some copy$default(Some some, T t11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                t11 = some.value;
            }
            return some.copy(t11);
        }

        @NotNull
        public final T component1() {
            return this.value;
        }

        @NotNull
        public final Some<T> copy(@NotNull T t11) {
            Intrinsics.checkNotNullParameter(t11, "value");
            return new Some<>(t11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Some) && Intrinsics.areEqual((Object) this.value, (Object) ((Some) obj).value);
        }

        @NotNull
        public final T getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            T t11 = this.value;
            return "Some(value=" + t11 + ")";
        }
    }

    private Optional() {
    }

    public /* synthetic */ Optional(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final <U> Optional<U> flatMap(@NotNull Function1<? super T, ? extends Optional<? extends U>> function1) {
        Intrinsics.checkNotNullParameter(function1, "f");
        if (this instanceof Some) {
            return (Optional) function1.invoke(((Some) this).getValue());
        }
        None none = None.INSTANCE;
        if (Intrinsics.areEqual((Object) this, (Object) none)) {
            return none;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final <U> U fold(@NotNull Function0<? extends U> function0, @NotNull Function1<? super T, ? extends U> function1) {
        Intrinsics.checkNotNullParameter(function0, "onEmpty");
        Intrinsics.checkNotNullParameter(function1, "onDefined");
        if (this instanceof Some) {
            return function1.invoke(((Some) this).getValue());
        }
        if (Intrinsics.areEqual((Object) this, (Object) None.INSTANCE)) {
            return function0.invoke();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final <U> Optional<U> map(@NotNull Function1<? super T, ? extends U> function1) {
        Intrinsics.checkNotNullParameter(function1, "f");
        if (this instanceof Some) {
            return OptionalKt.toOptional(function1.invoke(((Some) this).getValue()));
        }
        None none = None.INSTANCE;
        if (Intrinsics.areEqual((Object) this, (Object) none)) {
            return none;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Nullable
    public final T toNullable() {
        if (this instanceof Some) {
            return ((Some) this).getValue();
        }
        if (this instanceof None) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
