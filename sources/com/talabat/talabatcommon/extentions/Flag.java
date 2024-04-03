package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0000J\u000e\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/extentions/Flag;", "Lkotlin/Function0;", "", "state", "(Z)V", "accessCount", "", "value", "getValue", "()Z", "copy", "invoke", "()Ljava/lang/Boolean;", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Flag implements Function0<Boolean> {
    private int accessCount;
    private final boolean state;

    public Flag(boolean z11) {
        this.state = z11;
    }

    @NotNull
    public final Flag copy() {
        return new Flag(this.accessCount > 0 ? !this.state : this.state);
    }

    public final boolean getValue() {
        int i11 = this.accessCount;
        this.accessCount = i11 + 1;
        return i11 > 0 ? !this.state : this.state;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.state;
        int i11 = this.accessCount;
        return "state: " + z11 + ", accessCount: " + i11;
    }

    @NotNull
    public Boolean invoke() {
        return Boolean.valueOf(getValue());
    }
}
