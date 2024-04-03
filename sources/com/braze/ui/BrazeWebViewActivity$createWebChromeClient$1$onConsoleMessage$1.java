package com.braze.ui;

import android.webkit.ConsoleMessage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BrazeWebViewActivity$createWebChromeClient$1$onConsoleMessage$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ConsoleMessage f44001g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazeWebViewActivity$createWebChromeClient$1$onConsoleMessage$1(ConsoleMessage consoleMessage) {
        super(0);
        this.f44001g = consoleMessage;
    }

    @NotNull
    public final String invoke() {
        return "Braze WebView Activity log. Line: " + this.f44001g.lineNumber() + ". SourceId: " + this.f44001g.sourceId() + ". Log Level: " + this.f44001g.messageLevel() + ". Message: " + this.f44001g.message();
    }
}
