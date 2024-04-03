package com.instabug.library.networkv2;

import android.content.Context;
import android.net.TrafficStats;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.Instabug;
import com.instabug.library.networkv2.connection.FileDownloadConnectionManager;
import com.instabug.library.networkv2.connection.MultipartConnectionManager;
import com.instabug.library.networkv2.connection.NormalConnectionManager;
import com.instabug.library.networkv2.connection.a;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import java.util.Random;

@Keep
public class NetworkManager implements INetworkManager {
    private static Random threadTagSeed = new SecureRandom(new byte[4]);
    @Nullable
    private OnDoRequestListener onDoRequestListener;

    public interface OnDoRequestListener {
        void onComplete();

        void onRequestStarted(Request request);

        void onStart();
    }

    public NetworkManager() {
    }

    @WorkerThread
    private void doRequest(@IBGNetworkWorker @NonNull String str, @NonNull a aVar, @NonNull Request request, Request.Callbacks<RequestResponse, Throwable> callbacks) {
        PoolProvider.getNetworkingSingleThreadExecutor(str).execute(new gd.a(this, request, aVar, callbacks));
    }

    @WorkerThread
    private void doRequestOnSameThread(@NonNull a aVar, @NonNull Request request, Request.Callbacks<RequestResponse, Throwable> callbacks) {
        lambda$doRequest$0(request, aVar, callbacks);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleRequest */
    public void lambda$doRequest$0(Request request, a aVar, Request.Callbacks<RequestResponse, Throwable> callbacks) {
        OnDoRequestListener onDoRequestListener2 = this.onDoRequestListener;
        if (onDoRequestListener2 != null) {
            onDoRequestListener2.onRequestStarted(request);
        }
        HttpURLConnection httpURLConnection = null;
        try {
            TrafficStats.setThreadStatsTag(threadTagSeed.nextInt());
            httpURLConnection = aVar.create(request);
            if (httpURLConnection == null) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (httpURLConnection != null) {
                    try {
                        if (httpURLConnection.getInputStream() != null) {
                            httpURLConnection.getInputStream().close();
                        }
                    } catch (Exception e11) {
                        try {
                            if (httpURLConnection.getErrorStream() != null) {
                                httpURLConnection.getErrorStream().close();
                            }
                        } catch (Exception unused) {
                            InstabugSDKLogger.e("IBG-Core", "failed to close connection input stream for url " + request.getRequestUrl(), e11);
                        }
                    }
                }
            } else if (httpURLConnection.getResponseCode() >= 400) {
                Throwable handleServerError = aVar.handleServerError(httpURLConnection);
                if (callbacks != null) {
                    callbacks.onFailed(handleServerError);
                }
                httpURLConnection.disconnect();
                try {
                    if (httpURLConnection.getInputStream() != null) {
                        httpURLConnection.getInputStream().close();
                    }
                } catch (Exception e12) {
                    try {
                        if (httpURLConnection.getErrorStream() != null) {
                            httpURLConnection.getErrorStream().close();
                        }
                    } catch (Exception unused2) {
                        InstabugSDKLogger.e("IBG-Core", "failed to close connection input stream for url " + request.getRequestUrl(), e12);
                    }
                }
            } else {
                RequestResponse handleResponse = aVar.handleResponse(httpURLConnection, request);
                if (callbacks != null) {
                    callbacks.onSucceeded(handleResponse);
                }
                OnDoRequestListener onDoRequestListener3 = this.onDoRequestListener;
                if (onDoRequestListener3 != null) {
                    onDoRequestListener3.onComplete();
                }
                httpURLConnection.disconnect();
                try {
                    if (httpURLConnection.getInputStream() != null) {
                        httpURLConnection.getInputStream().close();
                    }
                } catch (Exception e13) {
                    try {
                        if (httpURLConnection.getErrorStream() != null) {
                            httpURLConnection.getErrorStream().close();
                        }
                    } catch (Exception unused3) {
                        InstabugSDKLogger.e("IBG-Core", "failed to close connection input stream for url " + request.getRequestUrl(), e13);
                    }
                }
            }
        } catch (Exception e14) {
            if (callbacks != null) {
                callbacks.onFailed(e14);
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (httpURLConnection != null) {
                try {
                    if (httpURLConnection.getInputStream() != null) {
                        httpURLConnection.getInputStream().close();
                    }
                } catch (Exception e15) {
                    try {
                        if (httpURLConnection.getErrorStream() != null) {
                            httpURLConnection.getErrorStream().close();
                        }
                    } catch (Exception unused4) {
                        InstabugSDKLogger.e("IBG-Core", "failed to close connection input stream for url " + request.getRequestUrl(), e15);
                    }
                }
            }
        } catch (OutOfMemoryError e16) {
            if (callbacks != null) {
                callbacks.onFailed(e16);
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (httpURLConnection != null) {
                try {
                    if (httpURLConnection.getInputStream() != null) {
                        httpURLConnection.getInputStream().close();
                    }
                } catch (Exception e17) {
                    try {
                        if (httpURLConnection.getErrorStream() != null) {
                            httpURLConnection.getErrorStream().close();
                        }
                    } catch (Exception unused5) {
                        InstabugSDKLogger.e("IBG-Core", "failed to close connection input stream for url " + request.getRequestUrl(), e17);
                    }
                }
            }
        } catch (Throwable th2) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (httpURLConnection != null) {
                try {
                    if (httpURLConnection.getInputStream() != null) {
                        httpURLConnection.getInputStream().close();
                    }
                } catch (Exception e18) {
                    try {
                        if (httpURLConnection.getErrorStream() != null) {
                            httpURLConnection.getErrorStream().close();
                        }
                    } catch (Exception unused6) {
                        InstabugSDKLogger.e("IBG-Core", "failed to close connection input stream for url " + request.getRequestUrl(), e18);
                    }
                }
            }
            throw th2;
        }
    }

    public static boolean isOnline() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            return c.f51645a.a(applicationContext);
        }
        return false;
    }

    @Nullable
    public OnDoRequestListener getOnDoRequestListener() {
        return this.onDoRequestListener;
    }

    public void setOnDoRequestListener(@Nullable OnDoRequestListener onDoRequestListener2) {
        this.onDoRequestListener = onDoRequestListener2;
    }

    public NetworkManager(@Nullable OnDoRequestListener onDoRequestListener2) {
        this.onDoRequestListener = onDoRequestListener2;
    }

    @WorkerThread
    public void doRequest(@IBGNetworkWorker String str, int i11, @NonNull Request request, Request.Callbacks<RequestResponse, Throwable> callbacks) {
        if (!isOnline()) {
            InstabugSDKLogger.d("IBG-Core", "Device internet is disabled, can't make request: " + request.getEndpoint());
        } else if (i11 == 1) {
            doRequest(str, (a) new NormalConnectionManager(), request, callbacks);
        } else if (i11 == 2) {
            doRequest(str, (a) new MultipartConnectionManager(), request, callbacks);
        } else if (i11 != 3) {
            InstabugSDKLogger.e("IBG-Core", "undefined request type for " + request.getRequestUrlForLogging());
        } else {
            doRequest(str, (a) new FileDownloadConnectionManager(), request, callbacks);
        }
    }

    @WorkerThread
    public void doRequestOnSameThread(int i11, @NonNull Request request, Request.Callbacks<RequestResponse, Throwable> callbacks) {
        if (!isOnline()) {
            InstabugSDKLogger.d("IBG-Core", "Device internet is disabled, can't make request: " + request.getEndpoint());
        } else if (i11 == 1) {
            doRequestOnSameThread((a) new NormalConnectionManager(), request, callbacks);
        } else if (i11 == 2) {
            doRequestOnSameThread((a) new MultipartConnectionManager(), request, callbacks);
        } else if (i11 != 3) {
            InstabugSDKLogger.e("IBG-Core", "undefined request type for " + request.getRequestUrlForLogging());
        } else {
            doRequestOnSameThread((a) new FileDownloadConnectionManager(), request, callbacks);
        }
    }
}
