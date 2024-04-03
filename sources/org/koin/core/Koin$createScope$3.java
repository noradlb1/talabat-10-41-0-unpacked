package org.koin.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.qualifier.TypeQualifier;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n"}, d2 = {"", "T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Koin$createScope$3 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f62713g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TypeQualifier f62714h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Koin$createScope$3(String str, TypeQualifier typeQualifier) {
        super(0);
        this.f62713g = str;
        this.f62714h = typeQualifier;
    }

    @NotNull
    public final String invoke() {
        return "|- create scope - id:'" + this.f62713g + "' q:" + this.f62714h;
    }
}
