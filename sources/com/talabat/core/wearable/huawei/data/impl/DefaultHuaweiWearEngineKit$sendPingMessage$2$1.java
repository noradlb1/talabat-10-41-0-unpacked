package com.talabat.core.wearable.huawei.data.impl;

import com.huawei.wearengine.p2p.PingCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pingResult", "", "onPingResult"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultHuaweiWearEngineKit$sendPingMessage$2$1 implements PingCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultHuaweiWearEngineKit f56023a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation<Integer> f56024b;

    public DefaultHuaweiWearEngineKit$sendPingMessage$2$1(DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit, Continuation<? super Integer> continuation) {
        this.f56023a = defaultHuaweiWearEngineKit;
        this.f56024b = continuation;
    }

    public final void onPingResult(int i11) {
        DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit = this.f56023a;
        defaultHuaweiWearEngineKit.logInfo("PingResult " + i11);
        this.f56024b.resumeWith(Result.m6329constructorimpl(Integer.valueOf(i11)));
    }
}
