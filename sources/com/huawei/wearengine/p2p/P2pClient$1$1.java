package com.huawei.wearengine.p2p;

import com.huawei.wearengine.p2p.P2pClient;
import com.huawei.wearengine.p2p.P2pPingCallback;

class P2pClient$1$1 extends P2pPingCallback.Stub {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ P2pClient.f f44774b;

    public P2pClient$1$1(P2pClient.f fVar) {
        this.f44774b = fVar;
    }

    public void onResult(int i11) {
        this.f44774b.f44801c.onPingResult(i11);
    }
}
