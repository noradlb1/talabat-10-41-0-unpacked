package com.braze.brazeplugin;

import com.braze.brazeplugin.IntegrationInitializer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class IntegrationInitializer$BrazeInAppMessageManagerListener$beforeInAppMessageDisplayed$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ IntegrationInitializer.BrazeInAppMessageManagerListener f43651g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntegrationInitializer$BrazeInAppMessageManagerListener$beforeInAppMessageDisplayed$1(IntegrationInitializer.BrazeInAppMessageManagerListener brazeInAppMessageManagerListener) {
        super(0);
        this.f43651g = brazeInAppMessageManagerListener;
    }

    @NotNull
    public final String invoke() {
        return "Returning " + this.f43651g.getDefaultInAppMessageOperation() + " in Flutter automatic integration IInAppMessageManagerListener#beforeInAppMessageDisplayed()";
    }
}
