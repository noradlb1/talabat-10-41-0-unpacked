package org.koin.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Koin$createScope$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f62709g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62710h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Koin$createScope$1(String str, Qualifier qualifier) {
        super(0);
        this.f62709g = str;
        this.f62710h = qualifier;
    }

    @NotNull
    public final String invoke() {
        return "|- create scope - id:'" + this.f62709g + "' q:" + this.f62710h;
    }
}
