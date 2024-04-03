package com.braze.ui.inappmessage.jsinterface;

import com.braze.BrazeUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/braze/BrazeUser;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class InAppMessageUserJavascriptInterface$setFirstName$1 extends Lambda implements Function1<BrazeUser, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f44129g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageUserJavascriptInterface$setFirstName$1(String str) {
        super(1);
        this.f44129g = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BrazeUser) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "it");
        brazeUser.setFirstName(this.f44129g);
    }
}
