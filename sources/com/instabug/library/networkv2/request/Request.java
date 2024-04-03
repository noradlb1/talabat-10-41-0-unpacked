package com.instabug.library.networkv2.request;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.model.State;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.user.f;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class Request {
    private static final String APP_TOKEN = "application_token";
    public static final String BASIC_AUTH_VALUE_PREFIX = "Basic ";
    private static final String SHORTEN_APP_TOKEN = "at";
    private static final String SHORTEN_UUID = "uid";
    private static final String UUID = "uuid";
    @Nullable
    private final String appTokenValue = SettingsManager.getInstance().getAppToken();
    private final List<RequestParameter> bodyParameters;
    @Nullable
    private final File downloadedFile;
    @Nullable
    private final String endPoint;
    @Nullable
    private final FileToUpload fileToUpload;
    private boolean hasUuid;
    private final List<RequestParameter<String>> headers;
    private boolean noDefaultParameters;
    @Nullable
    private final String requestMethod;
    private final int requestType;
    private final String requestUrl;
    private final String sdkVersionValue = DeviceStateProvider.getSdkVersion();
    private final boolean shorten;
    private final List<RequestParameter> urlParameters;
    private final String uuidValue = f.k();

    public static class Builder {
        /* access modifiers changed from: private */
        @Nullable
        public ArrayList<RequestParameter> bodyParameters;
        /* access modifiers changed from: private */
        @Nullable
        public File downloadedFile;
        /* access modifiers changed from: private */
        @Nullable
        public String endpoint;
        /* access modifiers changed from: private */
        @Nullable
        public FileToUpload fileToUpload;
        /* access modifiers changed from: private */
        public boolean hasUuid = true;
        /* access modifiers changed from: private */
        @Nullable
        public ArrayList<RequestParameter<String>> headers;
        /* access modifiers changed from: private */
        @Nullable
        public String method;
        /* access modifiers changed from: private */
        public boolean noDefaultParameters = false;
        /* access modifiers changed from: private */
        @Nullable
        public String requestUrl;
        /* access modifiers changed from: private */
        public boolean shorten;
        /* access modifiers changed from: private */
        public int type = -1;
        /* access modifiers changed from: private */
        @Nullable
        public ArrayList<RequestParameter> urlParameters;

        public Builder() {
            addHeader(new RequestParameter(Header.SYSTEM_PLATFORM_OS, "android"));
            addHeader(new RequestParameter(Header.ANDROID_VERSION, Build.VERSION.RELEASE));
            addHeader(new RequestParameter(Header.SDK_VERSION, DeviceStateProvider.getSdkVersion()));
            String appToken = SettingsManager.getInstance().getAppToken();
            if (appToken != null) {
                addHeader(new RequestParameter(Header.APP_TOKEN, appToken));
            }
        }

        private Builder addBodyParameter(RequestParameter requestParameter) {
            if (this.bodyParameters == null) {
                this.bodyParameters = new ArrayList<>();
            }
            this.bodyParameters.add(requestParameter);
            return this;
        }

        private Builder addUrlParameter(RequestParameter requestParameter) {
            if (this.urlParameters == null) {
                this.urlParameters = new ArrayList<>();
            }
            this.urlParameters.add(requestParameter);
            return this;
        }

        /* access modifiers changed from: private */
        public Builder setBodyParameter(List<RequestParameter> list) {
            if (this.bodyParameters == null) {
                this.bodyParameters = new ArrayList<>();
            }
            this.bodyParameters = new ArrayList<>(list);
            return this;
        }

        /* access modifiers changed from: private */
        public Builder setUrlParameter(List<RequestParameter> list) {
            if (this.urlParameters == null) {
                this.urlParameters = new ArrayList<>();
            }
            this.urlParameters = new ArrayList<>(list);
            return this;
        }

        public Builder addHeader(RequestParameter<String> requestParameter) {
            if (this.headers == null) {
                this.headers = new ArrayList<>();
            }
            this.headers.add(requestParameter);
            return this;
        }

        public Builder addParameter(RequestParameter requestParameter) {
            String str = this.method;
            if (str != null) {
                if (str.equals("GET") || this.method.equals("DELETE")) {
                    addUrlParameter(requestParameter);
                } else {
                    addBodyParameter(requestParameter);
                }
            }
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder disableDefaultParameters(boolean z11) {
            this.noDefaultParameters = z11;
            return this;
        }

        public Builder endpoint(@Nullable String str) {
            this.endpoint = str;
            return this;
        }

        public Builder fileToDownload(@Nullable File file) {
            this.downloadedFile = file;
            return this;
        }

        public Builder fileToUpload(@Nullable FileToUpload fileToUpload2) {
            this.fileToUpload = fileToUpload2;
            return this;
        }

        public Builder hasUuid(boolean z11) {
            this.hasUuid = z11;
            return this;
        }

        public Builder method(@Nullable String str) {
            this.method = str;
            return this;
        }

        public Builder setHeaders(List<RequestParameter<String>> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.headers = new ArrayList<>(list);
            return this;
        }

        public Builder setParameter(List<RequestParameter> list) {
            String str = this.method;
            if (str != null) {
                if (str.equals("GET") || this.method.equals("DELETE")) {
                    setUrlParameter(list);
                } else {
                    setBodyParameter(list);
                }
            }
            return this;
        }

        public Builder shorten(boolean z11) {
            this.shorten = z11;
            return this;
        }

        public Builder type(int i11) {
            this.type = i11;
            return this;
        }

        public Builder url(String str) {
            this.requestUrl = str;
            return this;
        }
    }

    public interface Callbacks<T, K> {
        void onFailed(K k11);

        void onSucceeded(T t11);
    }

    public Request(Builder builder) {
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i11 = 1;
        this.hasUuid = true;
        this.noDefaultParameters = false;
        String a11 = builder.endpoint;
        this.endPoint = a11;
        if (builder.requestUrl != null) {
            str = builder.requestUrl;
        } else {
            str = Constants.BASE_URL + a11;
        }
        this.requestUrl = str;
        this.requestType = builder.type != -1 ? builder.type : i11;
        this.requestMethod = builder.method;
        this.fileToUpload = builder.fileToUpload;
        this.downloadedFile = builder.downloadedFile;
        boolean k11 = builder.shorten;
        this.shorten = k11;
        if (builder.urlParameters != null) {
            arrayList = builder.urlParameters;
        } else {
            arrayList = new ArrayList();
        }
        this.urlParameters = arrayList;
        if (builder.bodyParameters != null) {
            arrayList2 = builder.bodyParameters;
        } else {
            arrayList2 = new ArrayList();
        }
        this.bodyParameters = arrayList2;
        if (builder.headers != null) {
            arrayList3 = builder.headers;
        } else {
            arrayList3 = new ArrayList();
        }
        this.headers = arrayList3;
        this.hasUuid = builder.hasUuid;
        boolean d11 = builder.noDefaultParameters;
        this.noDefaultParameters = d11;
        handleBaseParams(k11, this.hasUuid, d11);
    }

    private void addBodyParameter(RequestParameter requestParameter) {
        this.bodyParameters.add(requestParameter);
    }

    private void addParameter(RequestParameter requestParameter) {
        String str = this.requestMethod;
        if (str == null) {
            return;
        }
        if (str.equals("GET") || this.requestMethod.equals("DELETE")) {
            addUrlParameter(requestParameter);
        } else {
            addBodyParameter(requestParameter);
        }
    }

    private void addUrlParameter(RequestParameter requestParameter) {
        this.urlParameters.add(requestParameter);
    }

    private String getUrlEncodedParameters() {
        a a11 = a.a();
        for (RequestParameter next : this.urlParameters) {
            a11.a(next.getKey(), next.getValue().toString());
        }
        return a11.toString();
    }

    private void handleBaseParams(boolean z11, boolean z12, boolean z13) {
        this.headers.add(new RequestParameter(Header.SDK_VERSION, this.sdkVersionValue));
        if (!z13) {
            if (!z11) {
                String str = this.appTokenValue;
                if (str != null) {
                    addParameter(new RequestParameter("application_token", str));
                }
                if (z12) {
                    addParameter(new RequestParameter("uuid", this.uuidValue));
                    return;
                }
                return;
            }
            String str2 = this.appTokenValue;
            if (str2 != null) {
                addParameter(new RequestParameter(SHORTEN_APP_TOKEN, str2));
            }
            if (z12) {
                addParameter(new RequestParameter("uid", this.uuidValue));
            }
        }
    }

    public Builder builder() {
        return new Builder().endpoint(this.endPoint).url(this.requestUrl).method(this.requestMethod).type(this.requestType).shorten(this.shorten).fileToUpload(this.fileToUpload).fileToDownload(this.downloadedFile).setBodyParameter(this.bodyParameters).setUrlParameter(this.urlParameters).setHeaders(this.headers);
    }

    @Nullable
    public File getDownloadedFile() {
        return this.downloadedFile;
    }

    @Nullable
    public String getEndpoint() {
        return this.endPoint;
    }

    @Nullable
    public FileToUpload getFileToUpload() {
        return this.fileToUpload;
    }

    public List<RequestParameter<String>> getHeaders() {
        return Collections.unmodifiableList(this.headers);
    }

    public String getRequestBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (RequestParameter next : getRequestBodyParameters()) {
                jSONObject.put(next.getKey(), next.getValue());
            }
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (OutOfMemoryError | JSONException e11) {
            System.gc();
            InstabugSDKLogger.e("IBG-Core", "OOM Exception trying to remove large logs...", e11);
            e11.printStackTrace();
            try {
                jSONObject.remove(State.KEY_CONSOLE_LOG);
                jSONObject.remove(State.KEY_INSTABUG_LOG);
                jSONObject.remove(State.KEY_NETWORK_LOGS);
                return JSONObjectInstrumentation.toString(jSONObject);
            } catch (OutOfMemoryError e12) {
                InstabugSDKLogger.e("IBG-Core", "Failed to resolve OOM, returning empty request body", e11);
                e12.printStackTrace();
                return "{}";
            }
        }
    }

    public List<RequestParameter> getRequestBodyParameters() {
        return Collections.unmodifiableList(this.bodyParameters);
    }

    public String getRequestMethod() {
        String str = this.requestMethod;
        return str == null ? "GET" : str;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public String getRequestUrl() {
        if (getUrlEncodedParameters().isEmpty()) {
            return this.requestUrl;
        }
        return this.requestUrl + getUrlEncodedParameters();
    }

    public String getRequestUrlForLogging() {
        if (!SettingsManager.shouldLogExtraRequestData() || getUrlEncodedParameters().isEmpty()) {
            return this.requestUrl;
        }
        return this.requestUrl + getUrlEncodedParameters();
    }

    public List<RequestParameter> getRequestUrlParameters() {
        return Collections.unmodifiableList(this.urlParameters);
    }

    public boolean isMultiPartRequest() {
        return this.fileToUpload != null;
    }

    @NonNull
    public String toString() {
        String str = this.requestMethod;
        if (str == null || !str.equals("GET")) {
            return "Url: " + getRequestUrl() + " | Method: " + this.requestMethod + " | Body: " + getRequestBody();
        }
        return "Url: " + getRequestUrl() + " | Method: " + this.requestMethod;
    }
}
