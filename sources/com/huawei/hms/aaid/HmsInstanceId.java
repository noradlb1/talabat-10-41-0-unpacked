package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.d;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.h;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.support.log.HMSLog;

public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* renamed from: a  reason: collision with root package name */
    private Context f47726a;

    /* renamed from: b  reason: collision with root package name */
    private PushPreferences f47727b;

    /* renamed from: c  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f47728c;

    private HmsInstanceId(Context context) {
        this.f47726a = context.getApplicationContext();
        this.f47727b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f47728c = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f47728c = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f47728c.setKitSdkVersion(60700300);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (d.e(this.f47726a)) {
                String string = i.a(this.f47726a).getString("subjectId");
                if (TextUtils.isEmpty(string)) {
                    i.a(this.f47726a).saveString("subjectId", str);
                } else if (!string.contains(str)) {
                    i a11 = i.a(this.f47726a);
                    a11.saveString("subjectId", string + "," + str);
                }
            } else {
                i.a(this.f47726a).removeKey("subjectId");
            }
        }
    }

    private void b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        o.c(context);
        return new HmsInstanceId(context);
    }

    public void deleteAAID() throws ApiException {
        b();
        try {
            if (this.f47727b.containsKey("aaid")) {
                this.f47727b.removeKey("aaid");
                this.f47727b.removeKey("creationTime");
                if (b.e(this.f47726a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.f47726a);
                        return;
                    }
                    DeleteTokenReq b11 = b.b(this.f47726a);
                    b11.setDeleteType(1);
                    b11.setMultiSender(false);
                    a(b11, 1);
                    BaseUtils.deleteAllTokenCache(this.f47726a);
                }
            }
        } catch (ApiException e11) {
            throw e11;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        b();
        a();
        DeleteTokenReq a11 = b.a(this.f47726a, str, str2);
        a11.setMultiSender(false);
        a(a11, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.callInBackground(new a(this.f47726a.getApplicationContext()));
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.f47727b.containsKey("creationTime")) {
                getAAID();
            }
            return this.f47727b.getLong("creationTime");
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getId() {
        return b.c(this.f47726a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken((String) null, (String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        b();
        a();
        TokenReq b11 = b.b(this.f47726a, (String) null, str2);
        b11.setAaid(getId());
        b11.setMultiSender(false);
        i.a(this.f47726a).saveString(this.f47726a.getPackageName(), "1");
        return a(b11, 1);
    }

    public void deleteToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String d11 = b.d(this.f47726a);
            if (TextUtils.isEmpty(d11)) {
                throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
            } else if (str.equals(d11)) {
                deleteToken((String) null, (String) null);
            } else {
                DeleteTokenReq a11 = b.a(this.f47726a, str);
                a11.setMultiSender(true);
                a(a11, 2);
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public String getToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String d11 = b.d(this.f47726a);
            if (TextUtils.isEmpty(d11)) {
                throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
            } else if (str.equals(d11)) {
                return getToken((String) null, (String) null);
            } else {
                TokenReq b11 = b.b(this.f47726a, str);
                b11.setAaid(getId());
                b11.setMultiSender(true);
                return a(b11, 2);
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    private String a(TokenReq tokenReq, int i11) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.f47726a, tokenReq.getSubjectId(), (String) null);
            return null;
        }
        a(tokenReq.getSubjectId());
        String a11 = h.a(this.f47726a, "push.gettoken");
        try {
            String str = TAG;
            HMSLog.d(str, "getToken req :" + tokenReq.toString());
            f fVar = new f("push.gettoken", tokenReq, this.f47726a, a11);
            fVar.setApiLevel(i11);
            return ((TokenResult) Tasks.await(this.f47728c.doWrite(fVar))).getToken();
        } catch (Exception e11) {
            if (e11.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e11.getCause();
                h.a(this.f47726a, "push.gettoken", a11, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f47726a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            h.a(context, "push.gettoken", a11, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    private void a(DeleteTokenReq deleteTokenReq, int i11) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.f47726a, subjectId, (String) null);
            return;
        }
        String a11 = h.a(this.f47726a, "push.deletetoken");
        try {
            String b11 = i.a(this.f47726a).b(subjectId);
            if (!deleteTokenReq.isMultiSender() || (!TextUtils.isEmpty(b11) && !b11.equals(i.a(this.f47726a).b((String) null)))) {
                deleteTokenReq.setToken(b11);
                e eVar = new e("push.deletetoken", deleteTokenReq, a11);
                eVar.setApiLevel(i11);
                Tasks.await(this.f47728c.doWrite(eVar));
                i.a(this.f47726a).c(subjectId);
                return;
            }
            i.a(this.f47726a).removeKey(subjectId);
            HMSLog.i(TAG, "The local subject token is null");
        } catch (Exception e11) {
            if (e11.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e11.getCause();
                h.a(this.f47726a, "push.deletetoken", a11, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f47726a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            h.a(context, "push.deletetoken", a11, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    private void a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f47726a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.f47726a)) {
            HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}
