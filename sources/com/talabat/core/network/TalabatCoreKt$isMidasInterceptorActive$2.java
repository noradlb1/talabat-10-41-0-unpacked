package com.talabat.core.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatCoreKt$isMidasInterceptorActive$2 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatCore f55955g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Boolean> f55956h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatCoreKt$isMidasInterceptorActive$2(TalabatCore talabatCore, Function0<Boolean> function0) {
        super(0);
        this.f55955g = talabatCore;
        this.f55956h = function0;
    }

    @NotNull
    public final Boolean invoke() {
        Boolean bool;
        Function0<Boolean> function0 = this.f55956h;
        try {
            Result.Companion companion = Result.Companion;
            bool = Result.m6329constructorimpl(Boolean.valueOf(function0.invoke().booleanValue()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            bool = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.m6335isFailureimpl(bool)) {
            bool = bool2;
        }
        return (Boolean) bool;
    }
}
