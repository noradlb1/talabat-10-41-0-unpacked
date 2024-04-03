package com.talabat.talabatcommon.extentions;

import android.content.Intent;
import com.talabat.talabatcommon.TalabatCommonIntegrationKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BroadcastsKt$sendBroadcast$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Intent f46920g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastsKt$sendBroadcast$2(Intent intent) {
        super(0);
        this.f46920g = intent;
    }

    public final void invoke() {
        TalabatCommonIntegrationKt.getAppContext().sendBroadcast(this.f46920g);
    }
}
