package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.koin.core.qualifier.Qualifier;
import org.koin.ext.KClassExtKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Scope$resolveValue$2$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KClass<?> f62760g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62761h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Scope$resolveValue$2$1(KClass<?> kClass, Qualifier qualifier) {
        super(0);
        this.f62760g = kClass;
        this.f62761h = qualifier;
    }

    @NotNull
    public final String invoke() {
        return "- lookup? t:'" + KClassExtKt.getFullName(this.f62760g) + "' - q:'" + this.f62761h + "' look at scope source";
    }
}
