package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f49694c = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");

    /* renamed from: a  reason: collision with root package name */
    private Context f49695a;

    /* renamed from: b  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f49696b;

    private HmsMessaging(Context context) {
        Preconditions.checkNotNull(context);
        this.f49695a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f49696b = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f49696b = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f49696b.setKitSdkVersion(60700300);
    }

    private Task<Void> a(String str, String str2) {
        String reportEntry = PushBiUtil.reportEntry(this.f49695a, PushNaming.SUBSCRIBE);
        if (str == null || !f49694c.matcher(str).matches()) {
            PushBiUtil.reportExit(this.f49695a, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
            throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        } else if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "use proxy subscribe.");
            if (TextUtils.equals(str2, "Sub")) {
                return ProxyCenter.getProxy().subscribe(this.f49695a, str, reportEntry);
            }
            return ProxyCenter.getProxy().unsubscribe(this.f49695a, str, reportEntry);
        } else {
            try {
                ErrorEnum a11 = t.a(this.f49695a);
                if (a11 != ErrorEnum.SUCCESS) {
                    throw a11.toApiException();
                } else if (NetWorkUtil.getNetworkType(this.f49695a) != 0) {
                    SubscribeReq subscribeReq = new SubscribeReq(this.f49695a, str2, str);
                    subscribeReq.setToken(BaseUtils.getLocalToken(this.f49695a, (String) null));
                    if (c.b()) {
                        return this.f49696b.doWrite(new BaseVoidTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                    }
                    return this.f49696b.doWrite(new SubscribeTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                } else {
                    HMSLog.e("HmsMessaging", "no network");
                    throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
                }
            } catch (ApiException e11) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setException(e11);
                PushBiUtil.reportExit(this.f49695a, PushNaming.SUBSCRIBE, reportEntry, e11.getStatusCode());
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
                taskCompletionSource2.setException(errorEnum.toApiException());
                PushBiUtil.reportExit(this.f49695a, PushNaming.SUBSCRIBE, reportEntry, errorEnum);
                return taskCompletionSource2.getTask();
            }
        }
    }

    public static synchronized HmsMessaging getInstance(Context context) {
        HmsMessaging hmsMessaging;
        synchronized (HmsMessaging.class) {
            hmsMessaging = new HmsMessaging(context);
        }
        return hmsMessaging;
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.f49695a);
    }

    public void send(RemoteMessage remoteMessage) {
        if (ProxyCenter.getProxy() == null) {
            HMSLog.i("HmsMessaging", "send upstream message");
            a(remoteMessage);
            return;
        }
        HMSLog.e("HmsMessaging", "Operation(send) unsupported");
        throw new UnsupportedOperationException("Operation(send) unsupported");
    }

    public void setAutoInitEnabled(boolean z11) {
        AutoInitHelper.setAutoInitEnabled(this.f49695a, z11);
    }

    public Task<Void> subscribe(String str) {
        HMSLog.i("HmsMessaging", "invoke subscribe");
        return a(str, "Sub");
    }

    public Task<Void> turnOffPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "turn off for proxy");
            return ProxyCenter.getProxy().turnOff(this.f49695a, (String) null);
        }
        HMSLog.i("HmsMessaging", "invoke turnOffPush");
        return a(false);
    }

    public Task<Void> turnOnPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "turn on for proxy");
            return ProxyCenter.getProxy().turnOn(this.f49695a, (String) null);
        }
        HMSLog.i("HmsMessaging", "invoke turnOnPush");
        return a(true);
    }

    public Task<Void> unsubscribe(String str) {
        HMSLog.i("HmsMessaging", "invoke unsubscribe");
        return a(str, "UnSub");
    }

    private void a(RemoteMessage remoteMessage) {
        String reportEntry = PushBiUtil.reportEntry(this.f49695a, PushNaming.UPSEND_MSG);
        ErrorEnum a11 = t.a(this.f49695a);
        if (a11 != ErrorEnum.SUCCESS) {
            HMSLog.e("HmsMessaging", "Message sent failed:" + a11.getExternalCode() + AbstractJsonLexerKt.COLON + a11.getMessage());
            PushBiUtil.reportExit(this.f49695a, PushNaming.UPSEND_MSG, reportEntry, a11);
            throw new UnsupportedOperationException(a11.getMessage());
        } else if (TextUtils.isEmpty(remoteMessage.getTo())) {
            HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
            PushBiUtil.reportExit(this.f49695a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'to' missing");
        } else if (TextUtils.isEmpty(remoteMessage.getMessageId())) {
            HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
            PushBiUtil.reportExit(this.f49695a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
        } else if (!TextUtils.isEmpty(remoteMessage.getData())) {
            UpSendMsgReq upSendMsgReq = new UpSendMsgReq();
            upSendMsgReq.setPackageName(this.f49695a.getPackageName());
            upSendMsgReq.setMessageId(remoteMessage.getMessageId());
            upSendMsgReq.setTo(remoteMessage.getTo());
            upSendMsgReq.setData(remoteMessage.getData());
            upSendMsgReq.setMessageType(remoteMessage.getMessageType());
            upSendMsgReq.setTtl(remoteMessage.getTtl());
            upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
            upSendMsgReq.setSendMode(remoteMessage.getSendMode());
            upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
            if (c.b()) {
                this.f49696b.doWrite(new BaseVoidTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), reportEntry));
            } else {
                a(upSendMsgReq, reportEntry);
            }
        } else {
            HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
            PushBiUtil.reportExit(this.f49695a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'data' missing");
        }
    }

    private Task<Void> a(boolean z11) {
        String reportEntry = PushBiUtil.reportEntry(this.f49695a, PushNaming.SET_NOTIFY_FLAG);
        if (!c.d(this.f49695a) || c.b()) {
            HMSLog.i("HmsMessaging", "turn on/off with AIDL");
            EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
            enableNotifyReq.setPackageName(this.f49695a.getPackageName());
            enableNotifyReq.setEnable(z11);
            return this.f49696b.doWrite(new BaseVoidTask(PushNaming.SET_NOTIFY_FLAG, JsonUtil.createJsonString(enableNotifyReq), reportEntry));
        } else if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
            HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            ErrorEnum errorEnum = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED;
            taskCompletionSource.setException(errorEnum.toApiException());
            PushBiUtil.reportExit(this.f49695a, PushNaming.SET_NOTIFY_FLAG, reportEntry, errorEnum);
            return taskCompletionSource.getTask();
        } else if (c.b(this.f49695a) < 90101310) {
            HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
            Context context = this.f49695a;
            Intent putExtra = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(context, this.f49695a.getPackageName() + "#" + z11));
            putExtra.setPackage("android");
            return Tasks.callInBackground(new IntentCallable(this.f49695a, putExtra, reportEntry));
        } else {
            HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
            new PushPreferences(this.f49695a, "push_notify_flag").saveBoolean("notify_msg_enable", !z11);
            Uri parse = Uri.parse("content://" + this.f49695a.getPackageName() + ".huawei.push.provider/" + "push_notify_flag" + ".xml");
            Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
            intent.putExtra("type", "enalbeFlag");
            intent.putExtra("pkgName", this.f49695a.getPackageName());
            intent.putExtra("url", parse);
            intent.setPackage("android");
            return Tasks.callInBackground(new IntentCallable(this.f49695a, intent, reportEntry));
        }
    }

    private void a(UpSendMsgReq upSendMsgReq, String str) {
        upSendMsgReq.setToken(BaseUtils.getLocalToken(this.f49695a, (String) null));
        try {
            this.f49696b.doWrite(new SendUpStreamTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
        } catch (Exception e11) {
            if (e11.getCause() instanceof ApiException) {
                PushBiUtil.reportExit(this.f49695a, PushNaming.UPSEND_MSG, str, ((ApiException) e11.getCause()).getStatusCode());
            } else {
                PushBiUtil.reportExit(this.f49695a, PushNaming.UPSEND_MSG, str, ErrorEnum.ERROR_INTERNAL_ERROR);
            }
        }
    }
}
