package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/extentions/SingleAccess;", "T", "Lkotlin/Function0;", "singleAccessValue", "(Ljava/lang/Object;)V", "firstAccess", "Lcom/talabat/talabatcommon/extentions/Flag;", "Ljava/lang/Object;", "value", "getValue", "()Ljava/lang/Object;", "invoke", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SingleAccess<T> implements Function0<T> {
    @NotNull
    private final Flag firstAccess = new Flag(true);
    private final T singleAccessValue;

    public SingleAccess(T t11) {
        this.singleAccessValue = t11;
    }

    @Nullable
    public final T getValue() {
        if (this.firstAccess.getValue()) {
            return this.singleAccessValue;
        }
        return null;
    }

    @Nullable
    public T invoke() {
        return getValue();
    }
}
