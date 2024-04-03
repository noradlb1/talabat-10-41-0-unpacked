package com.huawei.wisesecurity.ucs.credential;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.ha.message.BaseReportMsgBuilder;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.common.log.ILogUcs;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.report.ReportOption;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.GrsCapability;
import com.huawei.wisesecurity.ucs.credential.outer.HACapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.Selector;
import com.huawei.wisesecurity.ucs_credential.l;
import com.huawei.wisesecurity.ucs_credential.r;
import com.huawei.wisesecurity.ucs_credential.s;
import com.huawei.wisesecurity.ucs_credential.y;
import com.talabat.helpers.TalabatVolley;
import java.util.UUID;

public class CredentialClient {
    public static final String TAG = "CredentialClient";
    public String appId;
    public Context context;
    public y credentialManager;
    public HACapability haCapability;

    public static class Builder {
        public String appId;
        @KfsNotNull
        public Context context;
        public GrsCapability grsCapability;
        public HACapability haCapability;
        public NetworkCapability networkCapability;
        public int networkRetryTime = 2;
        public int networkTimeOut = TalabatVolley.DEFAULT_TIMEOUT_MS;
        public ReportOption reportOption = ReportOption.REPORT_NORMAL;
        public String serCountry;

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public CredentialClient build() throws UcsException {
            try {
                String str = this.appId;
                if (str != null) {
                    if (str.length() > 30) {
                        throw new UcsParamException("appId length is too long");
                    }
                }
                KfsValidator.validate(this);
                l selectGrsCapability = Selector.selectGrsCapability(this.grsCapability, this.context, this.serCountry);
                return new CredentialClient(this.context, this.appId, selectGrsCapability, Selector.selectNetWorkCapability(this.networkCapability, this.context, this.networkTimeOut, this.networkRetryTime), Selector.selectHACapability(this.haCapability, selectGrsCapability, this.reportOption));
            } catch (KfsValidationException e11) {
                throw new UcsParamException("CredentialClient check param error : " + e11.getMessage());
            } catch (UcsException e12) {
                LogUcs.e(CredentialClient.TAG, "CredentialClient build get UCS exception : errorCode : {0} errorMsg : {1}", Long.valueOf(e12.getErrorCode()), e12.getMessage());
                throw e12;
            } catch (Throwable th2) {
                String str2 = "CredentialClient build get exception : " + th2.getMessage();
                LogUcs.e(CredentialClient.TAG, str2, new Object[0]);
                throw new UcsException(2001, str2);
            }
        }

        public Builder context(Context context2) {
            this.context = context2;
            return this;
        }

        public Builder grsCapability(GrsCapability grsCapability2) {
            this.grsCapability = grsCapability2;
            return this;
        }

        public Builder haCapability(HACapability hACapability) {
            this.haCapability = hACapability;
            return this;
        }

        public Builder logInstance(ILogUcs iLogUcs) {
            LogUcs.init(iLogUcs);
            return this;
        }

        public Builder networkCapability(NetworkCapability networkCapability2) {
            this.networkCapability = networkCapability2;
            return this;
        }

        public Builder networkRetryTime(int i11) {
            this.networkRetryTime = i11;
            return this;
        }

        public Builder networkTimeOut(int i11) {
            this.networkTimeOut = i11;
            return this;
        }

        public Builder reportOption(ReportOption reportOption2) {
            this.reportOption = reportOption2;
            return this;
        }

        public Builder serCountry(String str) {
            this.serCountry = str;
            return this;
        }
    }

    public CredentialClient(Context context2, String str, l lVar, NetworkCapability networkCapability, HACapability hACapability) throws UcsException {
        this.context = context2;
        this.appId = str;
        this.haCapability = hACapability;
        this.credentialManager = new y(this, context2, networkCapability, lVar, str);
        UcsLib.checkNativeLibrary();
    }

    public Credential applyCredential(String str) throws UcsException {
        return applyCredential(str, UUID.randomUUID().toString());
    }

    public Credential applyCredential(String str, String str2) throws UcsException {
        if (TextUtils.isEmpty(str)) {
            throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "serviceName illegal...");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            r rVar = new r();
            rVar.linkedHashMap.put("flavor", "developers");
            rVar.linkedHashMap.put("credentialPackageName", str);
            r rVar2 = (r) rVar.setTransId(str2).setApiName("appAuth.applyCredential").setCallTime();
            try {
                LogUcs.i(TAG, "start apply credential for {0} , appId is {1}", str, this.appId);
                Credential a11 = this.credentialManager.a(str, str2);
                LogUcs.i(TAG, "finish apply credential for {0} , appId is {1}", str, this.appId);
                rVar2.linkedHashMap.put("cty", this.credentialManager.f44913g);
                rVar2.setStatusCode(0);
                reportLogs(rVar2);
                return a11;
            } catch (UcsException e11) {
                LogUcs.e(TAG, "get Credential get UcsException : " + e11.getMessage(), new Object[0]);
                rVar2.setStatusCode((int) e11.getErrorCode()).setErrorMsg(e11.getMessage());
                throw e11;
            } catch (Exception e12) {
                String str3 = "get Credential get exception : " + e12.getMessage();
                LogUcs.e(TAG, str3, new Object[0]);
                rVar2.setStatusCode(2001).setErrorMsg(str3);
                throw new UcsException(2001, str3);
            } catch (Throwable th2) {
                reportLogs(rVar2);
                throw th2;
            }
        } else {
            throw new UcsException(1015, "can not apply in main looper...");
        }
    }

    public Credential genCredentialFromString(String str) throws UcsException {
        s sVar = new s();
        sVar.linkedHashMap.put("flavor", "developers");
        s sVar2 = (s) sVar.setApiName("appAuth.credentialFromString").setCallTime();
        try {
            Credential fromString = Credential.fromString(this.context, str, sVar2);
            sVar2.setStatusCode(0);
            reportLogs(sVar2);
            return fromString;
        } catch (UcsException e11) {
            LogUcs.e(TAG, "credential from string get UcsException : {0}", e11.getMessage());
            sVar2.setStatusCode((int) e11.getErrorCode()).setErrorMsg(e11.getMessage());
            throw e11;
        } catch (Exception e12) {
            String str2 = "credential from string get exception : " + e12.getMessage();
            LogUcs.e(TAG, "{0}", str2);
            sVar2.setStatusCode(2001).setErrorMsg(str2);
            throw new UcsException(2001, str2);
        } catch (Throwable th2) {
            reportLogs(sVar2);
            throw th2;
        }
    }

    public void reportLogs(BaseReportMsgBuilder baseReportMsgBuilder) {
        baseReportMsgBuilder.setAppId(this.appId).setPackageName(this.context.getPackageName()).setVersion("1.0.3.313");
        Context context2 = this.context;
        try {
            this.haCapability.onEvent(context2, baseReportMsgBuilder.getEventId(), baseReportMsgBuilder.setCostTime());
        } catch (Throwable th2) {
            LogUcs.i("ReportUtil", "onEvent get exception : " + th2.getMessage(), new Object[0]);
        }
    }
}
