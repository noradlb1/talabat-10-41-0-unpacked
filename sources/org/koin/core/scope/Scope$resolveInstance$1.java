package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Scope$resolveInstance$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ParametersHolder f62757g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Scope$resolveInstance$1(ParametersHolder parametersHolder) {
        super(0);
        this.f62757g = parametersHolder;
    }

    @NotNull
    public final String invoke() {
        return "| put parameters on stack " + this.f62757g + ' ';
    }
}
