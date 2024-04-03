package com.huawei.hms.analytics.core.transport.net;

import android.content.Context;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.transport.CallbackListener;
import com.huawei.hms.analytics.core.transport.ITransportHandler;
import com.huawei.hms.analytics.core.transport.a.a;
import com.huawei.hms.analytics.instance.CallBack;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.talabat.helpers.TalabatVolley;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

@Instrumented
public class HttpTransportHandler implements ITransportHandler {
    private static final int RECONNECTION_TIMES = 3;
    private static final String TAG = "HttpTransportCommander";
    private String[] collectURLs;
    private HttpURLConnection connection;
    private Context context;
    private Map<String, String> headers;
    private byte[] reportData;
    private String requestMethod;

    private void closeConnection() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private void createConnection(String str) {
        this.connection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(str).openConnection())));
        setHttpsConn();
        this.connection.setRequestMethod(this.requestMethod);
        this.connection.setConnectTimeout(TalabatVolley.DEFAULT_TIMEOUT_MS);
        this.connection.setReadTimeout(TalabatVolley.DEFAULT_TIMEOUT_MS);
        if ("POST".equals(this.requestMethod)) {
            this.connection.setDoOutput(true);
        }
        this.connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        byte[] bArr = this.reportData;
        this.connection.setRequestProperty("Content-Length", String.valueOf(bArr == null ? 0 : bArr.length));
        this.connection.setRequestProperty("Connection", "close");
        Map<String, String> map = this.headers;
        if (map != null && map.size() > 0) {
            for (Map.Entry next : this.headers.entrySet()) {
                String str2 = (String) next.getKey();
                if (str2 != null && !str2.isEmpty()) {
                    this.connection.setRequestProperty(str2, URLEncoder.encode(next.getValue() == null ? "" : (String) next.getValue(), "UTF-8"));
                }
            }
        }
    }

    private Response handlerException(Exception exc) {
        String str;
        if (exc instanceof SecurityException) {
            HiLog.e(TAG, HiLog.ErrorCode.NE003, "No Permission：INTERNET.");
            return new Response(CallBack.INIT_FAILED, "");
        } else if (exc instanceof SSLPeerUnverifiedException) {
            HiLog.e(TAG, HiLog.ErrorCode.NE002, "Certificate has not been verified,Request is restricted!");
            return new Response(-106, "");
        } else if (exc instanceof SSLHandshakeException) {
            HiLog.e(TAG, HiLog.ErrorCode.NE002, "SSL Handshake Exception : " + exc.getMessage());
            return new Response(-109, "");
        } else if (exc instanceof ConnectException) {
            HiLog.e(TAG, HiLog.ErrorCode.NE005, "Network is unreachable or Connection refused");
            return new Response(-103, "");
        } else if (exc instanceof UnknownHostException) {
            HiLog.e(TAG, HiLog.ErrorCode.NE006, "Invalid URL.No address associated with hostname");
            return new Response(-104, "");
        } else if (exc instanceof IOException) {
            HiLog.e(TAG, HiLog.ErrorCode.NE004, "post request IO Exception.");
            return new Response(-102, "");
        } else if (exc instanceof a) {
            HiLog.e(TAG, HiLog.ErrorCode.NE001, "SSLConfigException:" + exc.getMessage());
            return new Response(-105, "");
        } else {
            if (exc instanceof IllegalAccessException) {
                str = exc.getMessage();
            } else {
                str = "other exception: " + exc.getMessage();
            }
            HiLog.e(TAG, str);
            return new Response(-108, "");
        }
    }

    private Response post(String str) {
        Throwable th2;
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream;
        createConnection(str);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            byte[] bArr = this.reportData;
            if (bArr == null || bArr.length <= 0) {
                HiLog.i(TAG, "report data is empty");
                outputStream = null;
            } else {
                outputStream = this.connection.getOutputStream();
                try {
                    bufferedOutputStream = new BufferedOutputStream(outputStream);
                    try {
                        bufferedOutputStream.write(this.reportData);
                        bufferedOutputStream.flush();
                        bufferedOutputStream2 = bufferedOutputStream;
                    } catch (Throwable th3) {
                        th2 = th3;
                        a.a(bufferedOutputStream);
                        a.a(outputStream);
                        closeConnection();
                        throw th2;
                    }
                } catch (Throwable th4) {
                    Throwable th5 = th4;
                    bufferedOutputStream = bufferedOutputStream2;
                    th2 = th5;
                    a.a(bufferedOutputStream);
                    a.a(outputStream);
                    closeConnection();
                    throw th2;
                }
            }
            Response response = new Response(this.connection.getResponseCode(), readResponse());
            a.a(bufferedOutputStream2);
            a.a(outputStream);
            closeConnection();
            return response;
        } catch (Throwable th6) {
            bufferedOutputStream = null;
            th2 = th6;
            outputStream = null;
            a.a(bufferedOutputStream);
            a.a(outputStream);
            closeConnection();
            throw th2;
        }
    }

    private String readResponse() {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStream = this.connection.getInputStream();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException unused) {
                try {
                    HiLog.e(TAG, "stream read IOException!");
                    a.a(byteArrayOutputStream2);
                    a.a(inputStream);
                    return "";
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th2 = th4;
                    a.a(byteArrayOutputStream);
                    a.a(inputStream);
                    throw th2;
                }
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String byteArrayOutputStream3 = byteArrayOutputStream.toString("UTF-8");
                        a.a(byteArrayOutputStream);
                        a.a(inputStream);
                        return byteArrayOutputStream3;
                    }
                }
            } catch (IOException unused2) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                HiLog.e(TAG, "stream read IOException!");
                a.a(byteArrayOutputStream2);
                a.a(inputStream);
                return "";
            } catch (Throwable th5) {
                th2 = th5;
                a.a(byteArrayOutputStream);
                a.a(inputStream);
                throw th2;
            }
        } catch (IOException unused3) {
            inputStream = null;
            HiLog.e(TAG, "stream read IOException!");
            a.a(byteArrayOutputStream2);
            a.a(inputStream);
            return "";
        } catch (Throwable th6) {
            byteArrayOutputStream = null;
            th2 = th6;
            inputStream = null;
            a.a(byteArrayOutputStream);
            a.a(inputStream);
            throw th2;
        }
    }

    private Response reconnection(String str) {
        Response response = new Response(-108, "");
        int i11 = 0;
        while (i11 < 3) {
            try {
                return post(str);
            } catch (Exception e11) {
                response = handlerException(e11);
                if (response.getHttpCode() != -104) {
                    return response;
                }
                i11++;
            }
        }
        return response;
    }

    private void setHttpsConn() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                httpsURLConnection.setSSLSocketFactory(SecureSSLSocketFactoryNew.getInstance(this.context));
                httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
            } catch (Exception unused) {
                throw new a("No ssl socket factory set");
            }
        }
    }

    public Response execute() {
        String[] strArr = this.collectURLs;
        if (strArr == null || strArr.length == 0) {
            HiLog.e(TAG, "collectUrls is empty");
            return new Response(-100, "");
        }
        int i11 = 0;
        Response response = null;
        while (true) {
            if (response == null || (response.getHttpCode() == -104 && i11 < this.collectURLs.length)) {
                response = reconnection(this.collectURLs[i11]);
                i11++;
                HiLog.d(TAG, "request times: ".concat(String.valueOf(i11)));
            }
        }
        return response;
    }

    public void execute(final CallbackListener callbackListener) {
        new Thread(new Runnable() {
            public final void run() {
                if (callbackListener != null) {
                    Response execute = HttpTransportHandler.this.execute();
                    if (200 != execute.getHttpCode()) {
                        callbackListener.onFailure(execute.getHttpCode());
                    } else {
                        callbackListener.onSuccess(execute);
                    }
                }
            }
        }).start();
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public void setHttpHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setReportData(String str) {
    }

    public void setReportData(byte[] bArr) {
        this.reportData = bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    public void setRequestMethod(String str) {
        this.requestMethod = str;
    }

    public void setUrls(String[] strArr) {
        this.collectURLs = strArr != null ? (String[]) strArr.clone() : null;
    }
}
