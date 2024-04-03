package org.junit.platform.engine;

import j$.util.Optional;
import j$.util.function.Supplier;
import m30.k;
import m30.l;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "1.0", status = API.Status.STABLE)
public class FilterResult {
    private final boolean included;
    private final Optional<String> reason;

    private FilterResult(boolean z11, String str) {
        this.included = z11;
        this.reason = Optional.ofNullable(str);
    }

    public static FilterResult excluded(String str) {
        return new FilterResult(false, str);
    }

    public static FilterResult included(String str) {
        return new FilterResult(true, str);
    }

    public static FilterResult includedIf(boolean z11) {
        return includedIf(z11, new k(), new l());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$includedIf$0() {
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$includedIf$1() {
        return null;
    }

    public Optional<String> getReason() {
        return this.reason;
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("included", Boolean.valueOf(this.included)).append("reason", this.reason.orElse("<unknown>")).toString();
    }

    public static FilterResult includedIf(boolean z11, Supplier<String> supplier, Supplier<String> supplier2) {
        return z11 ? included(supplier.get()) : excluded(supplier2.get());
    }

    public boolean excluded() {
        return !included();
    }

    public boolean included() {
        return this.included;
    }
}
