package com.braze.ui.inappmessage;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BrazeInAppMessageManager$displayInAppMessage$15 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ IInAppMessage f44077g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazeInAppMessageManager$displayInAppMessage$15(IInAppMessage iInAppMessage) {
        super(0);
        this.f44077g = iInAppMessage;
    }

    @NotNull
    public final String invoke() {
        return Intrinsics.stringPlus("Could not display in-app message with payload: ", JsonUtils.getPrettyPrintedString((JSONObject) this.f44077g.forJsonPut()));
    }
}
