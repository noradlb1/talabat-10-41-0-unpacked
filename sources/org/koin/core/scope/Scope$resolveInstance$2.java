package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Scope$resolveInstance$2 extends Lambda implements Function0<String> {
    public static final Scope$resolveInstance$2 INSTANCE = new Scope$resolveInstance$2();

    public Scope$resolveInstance$2() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        return "| remove parameters from stack";
    }
}
