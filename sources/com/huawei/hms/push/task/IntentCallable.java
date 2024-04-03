package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

public class IntentCallable implements Callable<Void> {

    /* renamed from: a  reason: collision with root package name */
    private Context f49788a;

    /* renamed from: b  reason: collision with root package name */
    private Intent f49789b;

    /* renamed from: c  reason: collision with root package name */
    private String f49790c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.f49788a = context;
        this.f49789b = intent;
        this.f49790c = str;
    }

    public Void call() throws Exception {
        this.f49788a.sendBroadcast(this.f49789b);
        PushBiUtil.reportExit(this.f49788a, PushNaming.SET_NOTIFY_FLAG, this.f49790c, ErrorEnum.SUCCESS);
        return null;
    }
}
