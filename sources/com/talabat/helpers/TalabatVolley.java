package com.talabat.helpers;

import android.content.Context;
import android.os.SystemClock;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.exoplayer2.C;
import com.instabug.library.okhttplogger.InstabugOkhttpInterceptor;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwf.domain.FunWithFlagsObservabilityPort;
import com.talabat.core.fwf.domain.FunWithFlagsTrackingPort;
import com.talabat.core.network.midas.MidasHttpInterceptor;
import com.talabat.core.network.network.interceptors.SafetyInterceptor;
import com.talabat.core.network.network.interceptors.TrackingInterceptor;
import com.talabat.helpers.GlobalDataModel;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class TalabatVolley {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 0;
    public static final int DEFAULT_TIMEOUT_MS = 15000;
    public static final int HTTP_ERROR_FORBIDDEN = 403;
    public static final long REQUEST_TIMEOUT = 60;
    public static Context mContext;
    private static FunWithFlagsObservabilityPort observabilityManager;
    public static DefaultRetryPolicy policy;
    private static RequestQueue requestQueue;
    private static TrackingInterceptor trackingInterceptor;
    private static FunWithFlagsTrackingPort trackingManager;

    public static void addPaymentRequestToQueue(GsonRequest gsonRequest) {
        gsonRequest.setRetryPolicy(new DefaultRetryPolicy((int) TimeUnit.SECONDS.toMillis((long) GlobalDataModel.CHECKOUT.timeOut), 0, 1.0f));
        if (System.currentTimeMillis() - GlobalConstants.lastPaymentRequestedTime < C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Call Cancelled ");
            sb2.append(System.currentTimeMillis() - GlobalConstants.lastPaymentRequestedTime);
            return;
        }
        GlobalConstants.lastPaymentRequestedTime = System.currentTimeMillis();
        requestQueue.add(gsonRequest);
    }

    public static void addToRequestQueue(GsonRequest gsonRequest) {
        gsonRequest.setRetryPolicy(new DefaultRetryPolicy((int) TimeUnit.SECONDS.toMillis(20), 1, 1.0f));
        if (requestQueue == null) {
            initializeRequestQeue(mContext);
        }
        requestQueue.add(gsonRequest);
    }

    public static void addToRequestQueueForPlaceOrder(GsonRequest gsonRequest) {
        configurePolicy(60);
        gsonRequest.setRetryPolicy(policy);
        if (System.currentTimeMillis() - GlobalConstants.lastRequestedTime >= 5000) {
            GlobalConstants.lastRequestedTime = System.currentTimeMillis();
            requestQueue.add(gsonRequest);
        } else if (GlobalConstants.isDuplicateOrder) {
            GlobalConstants.isDuplicateOrder = false;
            GlobalConstants.lastRequestedTime = System.currentTimeMillis();
            requestQueue.add(gsonRequest);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Added ");
            sb2.append(System.currentTimeMillis() - GlobalConstants.lastRequestedTime);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Call Cancelled ");
            sb3.append(System.currentTimeMillis() - GlobalConstants.lastRequestedTime);
        }
    }

    public static void addToRequestQueueForRefresh(GsonRequest gsonRequest) {
        gsonRequest.setRetryPolicy(new DefaultRetryPolicy((int) TimeUnit.SECONDS.toMillis(20), 1, 1.0f));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CURR:");
        sb2.append(SystemClock.elapsedRealtime());
        sb2.append("\nStart:");
        sb2.append(GlobalConstants.requestStartTImeinMilliSecond);
        sb2.append("\nRes:");
        sb2.append(SystemClock.elapsedRealtime() - GlobalConstants.requestStartTImeinMilliSecond);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = GlobalConstants.requestStartTImeinMilliSecond;
        if (elapsedRealtime - j11 >= 50000) {
            GlobalConstants.requestStartTImeinMilliSecond = SystemClock.elapsedRealtime();
            requestQueue.add(gsonRequest);
        } else if (j11 == 0) {
            GlobalConstants.requestStartTImeinMilliSecond = SystemClock.elapsedRealtime();
        }
    }

    public static void configurePolicy(long j11) {
        policy = new DefaultRetryPolicy((int) TimeUnit.SECONDS.toMillis(j11), 0, 1.0f);
    }

    public static RequestQueue getRequestQueue(Context context) {
        if (requestQueue == null) {
            initializeRequestQeue(context);
        }
        return requestQueue;
    }

    public static void initializeRequestQeue(Context context) {
        mContext = context;
        if (Boolean.valueOf(TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.VOLLEY_UPON_OK_HTTP, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)).booleanValue()) {
            OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            requestQueue = Volley.newRequestQueue(context, (BaseHttpStack) new OkHttpStack(newBuilder.connectTimeout(60, timeUnit).readTimeout(60, timeUnit).writeTimeout(60, timeUnit).addInterceptor(MidasHttpInterceptor.INSTANCE).addInterceptor(new SafetyInterceptor()).addInterceptor(new InstabugOkhttpInterceptor()).addInterceptor(trackingInterceptor).build()));
            return;
        }
        requestQueue = Volley.newRequestQueue(context);
    }

    public static void setTrackingAndObservability(FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, FunWithFlagsTrackingPort funWithFlagsTrackingPort) {
        observabilityManager = funWithFlagsObservabilityPort;
        trackingManager = funWithFlagsTrackingPort;
        trackingInterceptor = new TrackingInterceptor(observabilityManager, trackingManager);
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static void addToRequestQueue(Context context, JsonObjectRequest jsonObjectRequest) {
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy((int) TimeUnit.SECONDS.toMillis(15), 1, 1.0f));
        if (requestQueue == null && context != null) {
            initializeRequestQeue(context);
        }
        RequestQueue requestQueue2 = requestQueue;
        if (requestQueue2 != null) {
            requestQueue2.add(jsonObjectRequest);
        }
    }
}
