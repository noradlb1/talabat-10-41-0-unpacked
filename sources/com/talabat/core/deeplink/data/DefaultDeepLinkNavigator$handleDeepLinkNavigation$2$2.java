package com.talabat.core.deeplink.data;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultDeepLinkNavigator$handleDeepLinkNavigation$2$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f55783g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultDeepLinkNavigator$handleDeepLinkNavigation$2$2(Function0<Unit> function0) {
        super(1);
        this.f55783g = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        Function0<Unit> function0 = this.f55783g;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
