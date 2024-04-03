package com.huawei.location;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.google.gson.Gson;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.req.BackgroundReq;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.service.BackGroundService;
import com.huawei.location.utils.yn;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class EnableGroundTaskCall extends BaseApiRequest {
    private static final String TAG = "EnableGroundTaskCall";

    @RequiresApi(api = 26)
    public void onRequest(String str) {
        LogConsole.i(TAG, "onRequest EnableGroundTaskCall");
        BackgroundReq backgroundReq = new BackgroundReq();
        yn.yn(str, (IMessageEntity) backgroundReq);
        Context context = ContextUtil.getContext();
        Intent intent = new Intent(context, BackGroundService.class);
        intent.putExtra("notificationId", backgroundReq.getNotificationId());
        intent.putExtra(RemoteMessageConst.NOTIFICATION, (Notification) getParcelable());
        if (Build.VERSION.SDK_INT >= 26) {
            ComponentName unused = context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
        Gson instance = GsonUtil.getInstance();
        RequestLocationUpdatesResponse requestLocationUpdatesResponse = new RequestLocationUpdatesResponse();
        onComplete(new RouterResponse(!(instance instanceof Gson) ? instance.toJson((Object) requestLocationUpdatesResponse) : GsonInstrumentation.toJson(instance, (Object) requestLocationUpdatesResponse), new StatusInfo(0, 0, "SUCCESS")));
    }
}
