package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

public class a implements Callable<AAIDResult> {

    /* renamed from: a  reason: collision with root package name */
    private Context f49640a;

    public a(Context context) {
        this.f49640a = context;
    }

    /* renamed from: a */
    public AAIDResult call() throws Exception {
        Context context = this.f49640a;
        if (context != null) {
            String c11 = b.c(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(c11);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
