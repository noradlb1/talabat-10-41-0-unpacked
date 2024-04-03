package org.koin.core.registry;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PropertyRegistry$saveProperties$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f62735g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PropertyRegistry$saveProperties$1(Map<String, ? extends Object> map) {
        super(0);
        this.f62735g = map;
    }

    @NotNull
    public final String invoke() {
        return "load " + this.f62735g.size() + " properties";
    }
}
