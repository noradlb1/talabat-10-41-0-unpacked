package com.talabat.talabatcore.extensions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\"\u0010\u0003\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u00002\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0002\u0010\u000bJ*\u0010\u0005\u001a\u00020\f2\u0006\u0010\b\u001a\u00028\u00002\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0002\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\rR\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"com/talabat/talabatcore/extensions/DelegatesKt$guardNotNull$2", "Lkotlin/properties/ReadWriteProperty;", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DelegatesKt$guardNotNull$2 implements ReadWriteProperty<Any, T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Boolean> f12016a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Throwable f12017b;
    @Nullable
    private T value;

    public DelegatesKt$guardNotNull$2(T t11, Function1<? super T, Boolean> function1, Throwable th2) {
        this.f12016a = function1;
        this.f12017b = th2;
        this.value = t11;
    }

    @Nullable
    public final T getValue() {
        return this.value;
    }

    public final void setValue(@Nullable T t11) {
        this.value = t11;
    }

    public T getValue(Any any, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        T t11 = this.value;
        if (t11 != null && !this.f12016a.invoke(t11).booleanValue()) {
            return t11;
        }
        throw this.f12017b;
    }

    public void setValue(Any any, @NotNull KProperty<?> kProperty, T t11) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        this.value = t11;
    }
}
