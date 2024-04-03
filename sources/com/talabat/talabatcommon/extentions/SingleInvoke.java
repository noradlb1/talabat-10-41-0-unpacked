package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/extentions/SingleInvoke;", "T", "Lkotlin/Function0;", "singleInvokeValue", "(Lkotlin/jvm/functions/Function0;)V", "value", "Lcom/talabat/talabatcommon/extentions/SingleAccess;", "invoke", "()Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SingleInvoke<T> implements Function0<T> {
    @NotNull
    private final SingleAccess<Function0<T>> value;

    public SingleInvoke(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "singleInvokeValue");
        this.value = new SingleAccess<>(function0);
    }

    @Nullable
    public T invoke() {
        Function0 invoke = this.value.invoke();
        if (invoke != null) {
            return invoke.invoke();
        }
        return null;
    }
}
