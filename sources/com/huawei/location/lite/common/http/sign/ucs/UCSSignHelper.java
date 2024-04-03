package com.huawei.location.lite.common.http.sign.ucs;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.http.exception.AuthException;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.http.sign.SignRequest;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.lite.common.util.country.CountryCodeUtil;
import com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder;
import com.huawei.wisesecurity.ucs.common.exception.UcsCryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.ILogUcs;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.crypto.signer.CredentialSignAlg;
import com.huawei.wisesecurity.ucs.credential.crypto.signer.CredentialSigner;
import com.huawei.wisesecurity.ucs.credential.outer.GrsCapability;
import com.huawei.wisesecurity.ucs.credential.outer.HACapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UCSSignHelper {
    private static final String APP_KEY_ID = "hmslocation";
    private static final String KEY_CREDENTIAL_CACHE = "credentialCache";
    private static final String KEY_CREDENTIAL_EXPIRED_TIME = "credentialExpiredTime";
    private static final long NEED_UPDATE_PERIOD = 3600000;
    private static final String PACKAGE_NAME = "com.huawei.hms.location";
    private static final String TAG = "UCSSignHelper";
    private Credential credential;
    private CredentialClient credentialClient;

    public static class GrsCapabilityImpl implements GrsCapability {
        private GrsCapabilityImpl() {
        }

        public String synGetGrsUrl(String str, String str2) {
            LogConsole.d(UCSSignHelper.TAG, "GrsCapabilityImpl synGetGrsUrl" + str);
            return LocationNlpGrsHelper.getGrsHostAddress(CountryCodeUtil.getLocationCountryCode(), str, str2);
        }
    }

    public static class HACapabilityImpl implements HACapability {
        private HACapabilityImpl() {
        }

        public void onEvent(Context context, String str, ReportMsgBuilder reportMsgBuilder) {
            Tracker.getInstance().onEvent(1, str, reportMsgBuilder.build());
        }
    }

    public static class LogUcsImpl implements ILogUcs {
        private LogUcsImpl() {
        }

        public void d(String str, String str2) {
            LogConsole.d(str, str2);
        }

        public void e(String str, String str2) {
            LogConsole.e(str, str2);
        }

        public void i(String str, String str2) {
            LogConsole.i(str, str2);
        }

        public void w(String str, String str2) {
            LogConsole.w(str, str2);
        }
    }

    @Instrumented
    public static class NetworkCapabilityImpl implements NetworkCapability {
        private NetworkCapabilityImpl() {
        }

        private NetworkResponse execute(Request request) throws IOException {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient build = builder.callTimeout(10000, timeUnit).connectTimeout(10000, timeUnit).retryOnConnectionFailure(false).build();
            try {
                Response execute = FirebasePerfOkHttpClient.execute(!(build instanceof OkHttpClient) ? build.newCall(request) : OkHttp3Instrumentation.newCall(build, request));
                NetworkResponse networkResponse = new NetworkResponse();
                networkResponse.setCode(execute.code());
                networkResponse.setHeaders(execute.headers().toMultimap());
                if (execute.body() != null) {
                    networkResponse.setBody(execute.body().string());
                }
                return networkResponse;
            } catch (IOException e11) {
                LogConsole.e(UCSSignHelper.TAG, "UCS http failed by exception");
                throw e11;
            }
        }

        public NetworkResponse get(NetworkRequest networkRequest) throws IOException {
            LogConsole.d(UCSSignHelper.TAG, "NetworkCapabilityImpl ucs http getUrl：" + networkRequest.getUrl());
            Request.Builder headers = new Request.Builder().url(networkRequest.getUrl()).headers(Headers.of(networkRequest.getHeaders()));
            return execute(!(headers instanceof Request.Builder) ? headers.build() : OkHttp3Instrumentation.build(headers));
        }

        public void initConfig(int i11, int i12) {
        }

        public NetworkResponse post(NetworkRequest networkRequest) throws IOException {
            LogConsole.d(UCSSignHelper.TAG, "NetworkCapabilityImpl ucs http postUrl：" + networkRequest.getUrl());
            Request.Builder post = new Request.Builder().url(networkRequest.getUrl()).headers(Headers.of(networkRequest.getHeaders())).post(RequestBody.create(MediaType.parse(RequestJsonBody.APPLICATION_JSON_UTF_8), networkRequest.getBody()));
            return execute(!(post instanceof Request.Builder) ? post.build() : OkHttp3Instrumentation.build(post));
        }
    }

    public static class UCSSignHelperHolder {
        /* access modifiers changed from: private */
        public static final UCSSignHelper INSTANCE = new UCSSignHelper();

        private UCSSignHelperHolder() {
        }
    }

    private UCSSignHelper() {
    }

    private boolean checkAndInitCredential(Context context) {
        Credential credential2 = this.credential;
        if (credential2 != null && !isNeedUpdate(Long.valueOf(credential2.getExpireTime()))) {
            return true;
        }
        LogConsole.i(TAG, "init credential from sp");
        PreferencesHelper preferencesHelper = new PreferencesHelper("location_credential");
        Credential initCredentialFromSp = initCredentialFromSp(context, preferencesHelper);
        this.credential = initCredentialFromSp;
        if (initCredentialFromSp != null) {
            return true;
        }
        LogConsole.i(TAG, "init credential from network");
        Credential initCredentialFromNetwork = initCredentialFromNetwork(context);
        this.credential = initCredentialFromNetwork;
        if (initCredentialFromNetwork == null) {
            return false;
        }
        AGCManager.getInstance().notifyAkChange();
        preferencesHelper.saveLong(KEY_CREDENTIAL_EXPIRED_TIME, this.credential.getExpireTime());
        preferencesHelper.saveString(KEY_CREDENTIAL_CACHE, this.credential.toString());
        LogConsole.i(TAG, "Credential init success, expire time is :" + this.credential.getExpireTime());
        return true;
    }

    public static UCSSignHelper getInstance() {
        return UCSSignHelperHolder.INSTANCE;
    }

    private synchronized Credential initCredentialFromNetwork(Context context) {
        CredentialClient build;
        try {
            build = new CredentialClient.Builder().context(context).serCountry(CountryCodeUtil.getLocationCountryCode()).networkRetryTime(1).networkTimeOut(10000).appId(AGCManager.getInstance().getAppId()).grsCapability(new GrsCapabilityImpl()).haCapability(new HACapabilityImpl()).networkCapability(new NetworkCapabilityImpl()).logInstance(new LogUcsImpl()).build();
            this.credentialClient = build;
        } catch (UcsException e11) {
            LogConsole.e(TAG, "init credential form network failed :" + e11.getErrorCode());
            return null;
        }
        return build.applyCredential("com.huawei.hms.location");
    }

    private Credential initCredentialFromSp(Context context, PreferencesHelper preferencesHelper) {
        String str;
        long j11 = preferencesHelper.getLong(KEY_CREDENTIAL_EXPIRED_TIME);
        if (j11 <= 0 || isNeedUpdate(Long.valueOf(j11))) {
            str = "sp credential is expired,credentialExpiredTime:" + j11;
        } else {
            String string = preferencesHelper.getString(KEY_CREDENTIAL_CACHE);
            if (TextUtils.isEmpty(string)) {
                str = "sp credential is null";
            } else {
                try {
                    CredentialClient build = new CredentialClient.Builder().context(context).build();
                    this.credentialClient = build;
                    return build.genCredentialFromString(string);
                } catch (UcsException e11) {
                    str = "init credential form sp failed :" + e11.getErrorCode();
                }
            }
        }
        LogConsole.e(TAG, str);
        return null;
    }

    private boolean isNeedUpdate(Long l11) {
        return System.currentTimeMillis() > l11.longValue() || l11.longValue() - System.currentTimeMillis() < 3600000;
    }

    private String realSign(SignRequest signRequest) throws UcsCryptoException, UcsException {
        Credential credential2 = this.credential;
        if (credential2 == null || isNeedUpdate(Long.valueOf(credential2.getExpireTime()))) {
            LogConsole.e(TAG, "credential is not ready");
            return "";
        }
        CredentialSigner build = new CredentialSigner.Builder().withCredential(this.credential).withAlg(CredentialSignAlg.HMAC_SHA256).withCredentialClient(this.credentialClient).build();
        String l11 = Long.toString(System.currentTimeMillis());
        Locale locale = Locale.ENGLISH;
        String format = String.format(locale, "%s&%s&%s&%s&ak=%s&timestamp=%s", new Object[]{signRequest.getMethod(), signRequest.getPath(), signRequest.getQuery(), signRequest.getPayload(), this.credential.getAccessKey(), l11});
        if (!TextUtils.isEmpty(signRequest.getHeadSigned()[0])) {
            format = String.format(locale, "%s&%s", new Object[]{format, signRequest.getHeadSigned()[0]});
        }
        LogConsole.d(TAG, "newStringToSign:" + format);
        String signBase64 = build.getSignHandler().from(format).signBase64();
        LogConsole.i(TAG, "sign successful");
        String format2 = String.format(locale, "EXT-AUTH-CLOUDSOA-HMAC-SHA256 appid=%s,timestamp=%s,signature=%s,ak=%s", new Object[]{APP_KEY_ID, l11, signBase64, this.credential.getAccessKey()});
        if (TextUtils.isEmpty(signRequest.getHeadSigned()[1])) {
            return format2;
        }
        return String.format(locale, "%s,signedHeaders=%s", new Object[]{format2, signRequest.getHeadSigned()[1]});
    }

    public void reApplyCredential() {
        LogConsole.i(TAG, "reApplyCredential");
        this.credential = null;
        PreferencesHelper preferencesHelper = new PreferencesHelper("location_credential");
        preferencesHelper.remove(KEY_CREDENTIAL_EXPIRED_TIME);
        preferencesHelper.remove(KEY_CREDENTIAL_CACHE);
        checkAndInitCredential(ContextUtil.getContext());
    }

    public String sign(Context context, SignRequest signRequest) throws UcsCryptoException, UcsException, AuthException {
        LogConsole.d(TAG, "begin to sign");
        if (checkAndInitCredential(context)) {
            return realSign(signRequest);
        }
        LogConsole.e(TAG, "Credential init fail,sign fail");
        throw new AuthException(ErrorCode.valueOf(41));
    }
}
