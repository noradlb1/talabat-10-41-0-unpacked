package com.braze.ui.inappmessage.listeners;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultInAppMessageWebViewClientListener$onOtherUrlAction$3 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f44140g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultInAppMessageWebViewClientListener$onOtherUrlAction$3(String str) {
        super(0);
        this.f44140g = str;
    }

    @NotNull
    public final String invoke() {
        return Intrinsics.stringPlus("HTML message action listener handled url in onOtherUrlAction. Doing nothing further. Url: ", this.f44140g);
    }
}
