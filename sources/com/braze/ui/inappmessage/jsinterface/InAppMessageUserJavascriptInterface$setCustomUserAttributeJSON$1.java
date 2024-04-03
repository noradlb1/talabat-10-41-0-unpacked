package com.braze.ui.inappmessage.jsinterface;

import com.braze.BrazeUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/braze/BrazeUser;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class InAppMessageUserJavascriptInterface$setCustomUserAttributeJSON$1 extends Lambda implements Function1<BrazeUser, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ InAppMessageUserJavascriptInterface f44119g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f44120h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f44121i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageUserJavascriptInterface$setCustomUserAttributeJSON$1(InAppMessageUserJavascriptInterface inAppMessageUserJavascriptInterface, String str, String str2) {
        super(1);
        this.f44119g = inAppMessageUserJavascriptInterface;
        this.f44120h = str;
        this.f44121i = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BrazeUser) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "it");
        this.f44119g.setCustomAttribute(brazeUser, this.f44120h, this.f44121i);
    }
}
