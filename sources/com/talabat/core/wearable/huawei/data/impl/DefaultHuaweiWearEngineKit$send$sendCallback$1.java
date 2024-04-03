package com.talabat.core.wearable.huawei.data.impl;

import com.huawei.wearengine.p2p.SendCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/talabat/core/wearable/huawei/data/impl/DefaultHuaweiWearEngineKit$send$sendCallback$1", "Lcom/huawei/wearengine/p2p/SendCallback;", "onSendProgress", "", "progress", "", "onSendResult", "resultCode", "", "com_talabat_core_wearable_huawei_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultHuaweiWearEngineKit$send$sendCallback$1 implements SendCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultHuaweiWearEngineKit f56022a;

    public DefaultHuaweiWearEngineKit$send$sendCallback$1(DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit) {
        this.f56022a = defaultHuaweiWearEngineKit;
    }

    public void onSendProgress(long j11) {
        DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit = this.f56022a;
        defaultHuaweiWearEngineKit.logInfo("onMessageSendProgress: " + j11);
    }

    public void onSendResult(int i11) {
        DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit = this.f56022a;
        defaultHuaweiWearEngineKit.logInfo("sendResultCode: " + i11);
        if (i11 == 207) {
            this.f56022a.logInfo("Message has been successfully");
            return;
        }
        DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit2 = this.f56022a;
        defaultHuaweiWearEngineKit2.logInfo("Couldn't send the message due to " + i11);
    }
}
