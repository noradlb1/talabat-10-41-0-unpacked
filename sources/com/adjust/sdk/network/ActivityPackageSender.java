package com.adjust.sdk.network;

import android.net.Uri;
import com.adjust.sdk.ActivityKind;
import com.adjust.sdk.ActivityPackage;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.ResponseData;
import com.adjust.sdk.TrackingState;
import com.adjust.sdk.Util;
import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.network.UtilNetworking;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityPackageSender implements IActivityPackageSender {
    private String basePath;
    private String clientSdk;
    private UtilNetworking.IConnectionOptions connectionOptions;
    private ThreadExecutor executor = new SingleThreadCachedScheduler("ActivityPackageSender");
    private String gdprPath;
    private UtilNetworking.IHttpsURLConnectionProvider httpsURLConnectionProvider;
    private ILogger logger = AdjustFactory.getLogger();
    private String subscriptionPath;
    private UrlStrategy urlStrategy;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IActivityPackageSender.ResponseDataCallbackSubscriber f40006a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f40007b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f40008c;

        public a(IActivityPackageSender.ResponseDataCallbackSubscriber responseDataCallbackSubscriber, ActivityPackage activityPackage, Map map) {
            this.f40006a = responseDataCallbackSubscriber;
            this.f40007b = activityPackage;
            this.f40008c = map;
        }

        public final void run() {
            this.f40006a.onResponseDataCallback(ActivityPackageSender.this.sendActivityPackageSync(this.f40007b, this.f40008c));
        }
    }

    public ActivityPackageSender(String str, String str2, String str3, String str4, String str5) {
        this.basePath = str2;
        this.gdprPath = str3;
        this.subscriptionPath = str4;
        this.clientSdk = str5;
        this.urlStrategy = new UrlStrategy(AdjustFactory.getBaseUrl(), AdjustFactory.getGdprUrl(), AdjustFactory.getSubscriptionUrl(), str);
        this.httpsURLConnectionProvider = AdjustFactory.getHttpsURLConnectionProvider();
        this.connectionOptions = AdjustFactory.getConnectionOptions();
    }

    private String buildAndExtractAuthorizationHeader(Map<String, String> map, ActivityKind activityKind) {
        String activityKind2 = activityKind.toString();
        String extractSecretId = extractSecretId(map);
        String buildAuthorizationHeaderV2 = buildAuthorizationHeaderV2(extractSignature(map), extractSecretId, extractHeadersId(map), extractAlgorithm(map), extractNativeVersion(map));
        return buildAuthorizationHeaderV2 != null ? buildAuthorizationHeaderV2 : buildAuthorizationHeaderV1(map, extractAppSecret(map), extractSecretId, activityKind2);
    }

    private String buildAuthorizationHeaderV1(Map<String, String> map, String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Map<String, String> signature = getSignature(map, str3, str);
        String sha256 = Util.sha256(signature.get("clear_signature"));
        String formatString = Util.formatString("Signature %s,%s,%s,%s", Util.formatString("secret_id=\"%s\"", str2), Util.formatString("signature=\"%s\"", sha256), Util.formatString("algorithm=\"%s\"", "sha256"), Util.formatString("headers=\"%s\"", signature.get("fields")));
        this.logger.verbose("authorizationHeader: %s", formatString);
        return formatString;
    }

    private String buildAuthorizationHeaderV2(String str, String str2, String str3, String str4, String str5) {
        if (str2 == null || str == null || str3 == null) {
            return null;
        }
        String formatString = Util.formatString("signature=\"%s\"", str);
        String formatString2 = Util.formatString("secret_id=\"%s\"", str2);
        String formatString3 = Util.formatString("headers_id=\"%s\"", str3);
        Object[] objArr = new Object[1];
        if (str4 == null) {
            str4 = "adj1";
        }
        objArr[0] = str4;
        String formatString4 = Util.formatString("algorithm=\"%s\"", objArr);
        Object[] objArr2 = new Object[1];
        if (str5 == null) {
            str5 = "";
        }
        objArr2[0] = str5;
        String formatString5 = Util.formatString("Signature %s,%s,%s,%s,%s", formatString, formatString2, formatString4, formatString3, Util.formatString("native_version=\"%s\"", objArr2));
        this.logger.verbose("authorizationHeader: %s", formatString5);
        return formatString5;
    }

    private DataOutputStream configConnectionForGET(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestMethod("GET");
        return null;
    }

    private DataOutputStream configConnectionForPOST(HttpsURLConnection httpsURLConnection, Map<String, String> map, Map<String, String> map2) {
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        String generatePOSTBodyString = generatePOSTBodyString(map, map2);
        if (generatePOSTBodyString == null) {
            return null;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(generatePOSTBodyString);
        return dataOutputStream;
    }

    private String errorMessage(Throwable th2, String str, ActivityPackage activityPackage) {
        return Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th2));
    }

    private static String extractAlgorithm(Map<String, String> map) {
        return map.remove("algorithm");
    }

    private static String extractAppSecret(Map<String, String> map) {
        return map.remove("app_secret");
    }

    private static void extractEventCallbackId(Map<String, String> map) {
        map.remove("event_callback_id");
    }

    private static String extractHeadersId(Map<String, String> map) {
        return map.remove("headers_id");
    }

    private static String extractNativeVersion(Map<String, String> map) {
        return map.remove("native_version");
    }

    private static String extractSecretId(Map<String, String> map) {
        return map.remove("secret_id");
    }

    private static String extractSignature(Map<String, String> map) {
        return map.remove("signature");
    }

    private String generatePOSTBodyString(Map<String, String> map, Map<String, String> map2) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        injectParametersToPOSTStringBuilder(map, sb2);
        injectParametersToPOSTStringBuilder(map2, sb2);
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '&') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return sb2.toString();
    }

    private String generateUrlStringForGET(ActivityKind activityKind, String str, Map<String, String> map, Map<String, String> map2) {
        URL url = new URL(urlWithExtraPathByActivityKind(activityKind, this.urlStrategy.targetUrlByActivityKind(activityKind)));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(url.getProtocol());
        builder.encodedAuthority(url.getAuthority());
        builder.path(url.getPath());
        builder.appendPath(str);
        this.logger.debug("Making request to url: %s", builder.toString());
        for (Map.Entry next : map.entrySet()) {
            builder.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        if (map2 != null) {
            for (Map.Entry next2 : map2.entrySet()) {
                builder.appendQueryParameter((String) next2.getKey(), (String) next2.getValue());
            }
        }
        return builder.build().toString();
    }

    private String generateUrlStringForPOST(ActivityKind activityKind, String str) {
        String formatString = Util.formatString("%s%s", urlWithExtraPathByActivityKind(activityKind, this.urlStrategy.targetUrlByActivityKind(activityKind)), str);
        this.logger.debug("Making request to url : %s", formatString);
        return formatString;
    }

    private Map<String, String> getSignature(Map<String, String> map, String str, String str2) {
        String validIdentifier = getValidIdentifier(map);
        String str3 = map.get("source");
        String str4 = map.get("payload");
        HashMap hashMap = new HashMap();
        hashMap.put("app_secret", str2);
        hashMap.put("created_at", map.get("created_at"));
        hashMap.put("activity_kind", str);
        hashMap.put(validIdentifier, map.get(validIdentifier));
        if (str3 != null) {
            hashMap.put("source", str3);
        }
        if (str4 != null) {
            hashMap.put("payload", str4);
        }
        String str5 = "";
        String str6 = str5;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                str5 = str5 + ((String) entry.getKey()) + " ";
                str6 = str6 + ((String) entry.getValue());
            }
        }
        String substring = str5.substring(0, str5.length() - 1);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("clear_signature", str6);
        hashMap2.put("fields", substring);
        return hashMap2;
    }

    private String getValidIdentifier(Map<String, String> map) {
        if (map.get("gps_adid") != null) {
            return "gps_adid";
        }
        if (map.get("fire_adid") != null) {
            return "fire_adid";
        }
        if (map.get("android_id") != null) {
            return "android_id";
        }
        if (map.get("android_uuid") != null) {
            return "android_uuid";
        }
        return null;
    }

    private void injectParametersToPOSTStringBuilder(Map<String, String> map, StringBuilder sb2) {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                String encode = URLEncoder.encode((String) next.getKey(), "UTF-8");
                String str = (String) next.getValue();
                String encode2 = str != null ? URLEncoder.encode(str, "UTF-8") : "";
                sb2.append(encode);
                sb2.append("=");
                sb2.append(encode2);
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
    }

    private void localError(Throwable th2, String str, ResponseData responseData) {
        String errorMessage = errorMessage(th2, str, responseData.activityPackage);
        this.logger.error(errorMessage, new Object[0]);
        responseData.message = errorMessage;
        responseData.willRetry = false;
    }

    private void parseResponse(ResponseData responseData, String str) {
        JSONObject jSONObject;
        if (str.length() == 0) {
            this.logger.error("Empty response string", new Object[0]);
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e11) {
            this.logger.error(errorMessage(e11, "Failed to parse JSON response", responseData.activityPackage), new Object[0]);
            jSONObject = null;
        }
        if (jSONObject != null) {
            responseData.jsonResponse = jSONObject;
            responseData.message = UtilNetworking.extractJsonString(jSONObject, "message");
            responseData.adid = UtilNetworking.extractJsonString(jSONObject, "adid");
            responseData.timestamp = UtilNetworking.extractJsonString(jSONObject, "timestamp");
            String extractJsonString = UtilNetworking.extractJsonString(jSONObject, "tracking_state");
            if (extractJsonString != null && extractJsonString.equals("opted_out")) {
                responseData.trackingState = TrackingState.OPTED_OUT;
            }
            responseData.askIn = UtilNetworking.extractJsonLong(jSONObject, "ask_in");
            responseData.retryIn = UtilNetworking.extractJsonLong(jSONObject, "retry_in");
            responseData.continueIn = UtilNetworking.extractJsonLong(jSONObject, "continue_in");
            responseData.attribution = AdjustAttribution.fromJson(jSONObject.optJSONObject("attribution"), responseData.adid, Util.getSdkPrefixPlatform(this.clientSdk));
        }
    }

    private void remoteError(Throwable th2, String str, ResponseData responseData) {
        String str2 = errorMessage(th2, str, responseData.activityPackage) + " Will retry later";
        this.logger.error(str2, new Object[0]);
        responseData.message = str2;
        responseData.willRetry = true;
    }

    private boolean shouldRetryToSend(ResponseData responseData) {
        if (!responseData.willRetry) {
            this.logger.debug("Will not retry with current url strategy", new Object[0]);
            this.urlStrategy.resetAfterSuccess();
            return false;
        } else if (this.urlStrategy.shouldRetryAfterFailure(responseData.activityKind)) {
            this.logger.error("Failed with current url strategy, but it will retry with new", new Object[0]);
            return true;
        } else {
            this.logger.error("Failed with current url strategy and it will not retry", new Object[0]);
            return false;
        }
    }

    private void tryToGetResponse(ResponseData responseData) {
        String str;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            ActivityPackage activityPackage = responseData.activityPackage;
            HashMap hashMap = new HashMap(activityPackage.getParameters());
            Map<String, String> map = responseData.sendingParameters;
            String buildAndExtractAuthorizationHeader = buildAndExtractAuthorizationHeader(hashMap, activityPackage.getActivityKind());
            boolean z11 = true;
            boolean z12 = responseData.activityPackage.getActivityKind() == ActivityKind.ATTRIBUTION;
            if (z12) {
                extractEventCallbackId(hashMap);
                str = generateUrlStringForGET(activityPackage.getActivityKind(), activityPackage.getPath(), hashMap, map);
            } else {
                str = generateUrlStringForPOST(activityPackage.getActivityKind(), activityPackage.getPath());
            }
            HttpsURLConnection generateHttpsURLConnection = this.httpsURLConnectionProvider.generateHttpsURLConnection(new URL(str));
            this.connectionOptions.applyConnectionOptions(generateHttpsURLConnection, activityPackage.getClientSdk());
            if (buildAndExtractAuthorizationHeader != null) {
                generateHttpsURLConnection.setRequestProperty("Authorization", buildAndExtractAuthorizationHeader);
            }
            if (z12) {
                dataOutputStream = configConnectionForGET(generateHttpsURLConnection);
            } else {
                extractEventCallbackId(hashMap);
                dataOutputStream = configConnectionForPOST(generateHttpsURLConnection, hashMap, map);
            }
            Integer readConnectionResponse = readConnectionResponse(generateHttpsURLConnection, responseData);
            responseData.success = responseData.jsonResponse != null && responseData.retryIn == null && readConnectionResponse != null && readConnectionResponse.intValue() == 200;
            if (responseData.jsonResponse != null) {
                if (responseData.retryIn == null) {
                    z11 = false;
                }
            }
            responseData.willRetry = z11;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (IOException e11) {
                    this.logger.error(errorMessage(e11, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (UnsupportedEncodingException e12) {
            localError(e12, "Failed to encode parameters", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e13) {
                    this.logger.error(errorMessage(e13, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (MalformedURLException e14) {
            localError(e14, "Malformed URL", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e15) {
                    this.logger.error(errorMessage(e15, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (ProtocolException e16) {
            localError(e16, "Protocol Error", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e17) {
                    this.logger.error(errorMessage(e17, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (SocketTimeoutException e18) {
            remoteError(e18, "Request timed out", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e19) {
                    this.logger.error(errorMessage(e19, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (SSLHandshakeException e21) {
            remoteError(e21, "Certificate failed", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e22) {
                    this.logger.error(errorMessage(e22, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (IOException e23) {
            remoteError(e23, "Request failed", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e24) {
                    this.logger.error(errorMessage(e24, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (Throwable th2) {
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e25) {
                    this.logger.error(errorMessage(e25, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
            throw th2;
        }
    }

    private String urlWithExtraPathByActivityKind(ActivityKind activityKind, String str) {
        if (activityKind == ActivityKind.GDPR) {
            if (this.gdprPath == null) {
                return str;
            }
            return str + this.gdprPath;
        } else if (activityKind == ActivityKind.SUBSCRIPTION) {
            if (this.subscriptionPath == null) {
                return str;
            }
            return str + this.subscriptionPath;
        } else if (this.basePath == null) {
            return str;
        } else {
            return str + this.basePath;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (r7 == null) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Integer readConnectionResponse(javax.net.ssl.HttpsURLConnection r7, com.adjust.sdk.ResponseData r8) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = 0
            r7.connect()     // Catch:{ IOException -> 0x0039 }
            int r3 = r7.getResponseCode()     // Catch:{ IOException -> 0x0039 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x0039 }
            int r3 = r2.intValue()     // Catch:{ IOException -> 0x0039 }
            r4 = 400(0x190, float:5.6E-43)
            if (r3 < r4) goto L_0x001f
            java.io.InputStream r3 = r7.getErrorStream()     // Catch:{ IOException -> 0x0039 }
            goto L_0x0023
        L_0x001f:
            java.io.InputStream r3 = r7.getInputStream()     // Catch:{ IOException -> 0x0039 }
        L_0x0023:
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0039 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0039 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0039 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0039 }
        L_0x002d:
            java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x0039 }
            if (r4 == 0) goto L_0x004b
            r0.append(r4)     // Catch:{ IOException -> 0x0039 }
            goto L_0x002d
        L_0x0037:
            r8 = move-exception
            goto L_0x00a6
        L_0x0039:
            r3 = move-exception
            java.lang.String r4 = "Connecting and reading response"
            com.adjust.sdk.ActivityPackage r5 = r8.activityPackage     // Catch:{ all -> 0x0037 }
            java.lang.String r3 = r6.errorMessage(r3, r4, r5)     // Catch:{ all -> 0x0037 }
            com.adjust.sdk.ILogger r4 = r6.logger     // Catch:{ all -> 0x0037 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0037 }
            r4.error(r3, r5)     // Catch:{ all -> 0x0037 }
            if (r7 == 0) goto L_0x004e
        L_0x004b:
            r7.disconnect()
        L_0x004e:
            int r7 = r0.length()
            if (r7 != 0) goto L_0x005e
            com.adjust.sdk.ILogger r7 = r6.logger
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r0 = "Empty response string buffer"
            r7.error(r0, r8)
            return r2
        L_0x005e:
            int r7 = r2.intValue()
            r3 = 429(0x1ad, float:6.01E-43)
            if (r7 != r3) goto L_0x0070
            com.adjust.sdk.ILogger r7 = r6.logger
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r0 = "Too frequent requests to the endpoint (429)"
            r7.error(r0, r8)
            return r2
        L_0x0070:
            java.lang.String r7 = r0.toString()
            com.adjust.sdk.ILogger r0 = r6.logger
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r1] = r7
            java.lang.String r5 = "Response string: %s"
            r0.debug(r5, r4)
            r6.parseResponse(r8, r7)
            java.lang.String r7 = r8.message
            if (r7 != 0) goto L_0x0088
            return r2
        L_0x0088:
            int r8 = r2.intValue()
            r0 = 200(0xc8, float:2.8E-43)
            java.lang.String r4 = "Response message: %s"
            if (r8 != r0) goto L_0x009c
            com.adjust.sdk.ILogger r8 = r6.logger
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r1] = r7
            r8.info(r4, r0)
            goto L_0x00a5
        L_0x009c:
            com.adjust.sdk.ILogger r8 = r6.logger
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r1] = r7
            r8.error(r4, r0)
        L_0x00a5:
            return r2
        L_0x00a6:
            if (r7 == 0) goto L_0x00ab
            r7.disconnect()
        L_0x00ab:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.network.ActivityPackageSender.readConnectionResponse(javax.net.ssl.HttpsURLConnection, com.adjust.sdk.ResponseData):java.lang.Integer");
    }

    public void sendActivityPackage(ActivityPackage activityPackage, Map<String, String> map, IActivityPackageSender.ResponseDataCallbackSubscriber responseDataCallbackSubscriber) {
        this.executor.submit(new a(responseDataCallbackSubscriber, activityPackage, map));
    }

    public ResponseData sendActivityPackageSync(ActivityPackage activityPackage, Map<String, String> map) {
        ResponseData buildResponseData;
        do {
            buildResponseData = ResponseData.buildResponseData(activityPackage, map);
            tryToGetResponse(buildResponseData);
        } while (shouldRetryToSend(buildResponseData));
        return buildResponseData;
    }
}
