package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/extentions/Nullable;", "T", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/talabat/talabatcommon/extentions/Nullable;", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Nullable<T> {
    @org.jetbrains.annotations.Nullable
    private final T value;

    public Nullable() {
        this((Object) null, 1, (DefaultConstructorMarker) null);
    }

    public Nullable(@org.jetbrains.annotations.Nullable T t11) {
        this.value = t11;
    }

    public static /* synthetic */ Nullable copy$default(Nullable nullable, T t11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            t11 = nullable.value;
        }
        return nullable.copy(t11);
    }

    @org.jetbrains.annotations.Nullable
    public final T component1() {
        return this.value;
    }

    @NotNull
    public final Nullable<T> copy(@org.jetbrains.annotations.Nullable T t11) {
        return new Nullable<>(t11);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Nullable) && Intrinsics.areEqual((Object) this.value, (Object) ((Nullable) obj).value);
    }

    @org.jetbrains.annotations.Nullable
    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t11 = this.value;
        if (t11 == null) {
            return 0;
        }
        return t11.hashCode();
    }

    @NotNull
    public String toString() {
        T t11 = this.value;
        return "Nullable(value=" + t11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Nullable(Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : obj);
    }
}
