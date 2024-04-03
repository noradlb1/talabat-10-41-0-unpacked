package com.adjust.sdk;

import android.content.Context;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.adjust.sdk.scheduler.TimerOnce;
import com.android.installreferrer.api.InstallReferrerStateListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicBoolean;

public class InstallReferrer implements InvocationHandler {
    private static final String PACKAGE_BASE_NAME = "com.android.installreferrer.";
    private static final int STATUS_DEVELOPER_ERROR = 3;
    private static final int STATUS_FEATURE_NOT_SUPPORTED = 2;
    private static final int STATUS_OK = 0;
    private static final int STATUS_SERVICE_DISCONNECTED = -1;
    private static final int STATUS_SERVICE_UNAVAILABLE = 1;
    private Context context;
    private ThreadExecutor executor;
    /* access modifiers changed from: private */
    public ILogger logger;
    private Object playInstallReferrer;
    private final InstallReferrerReadListener referrerCallback;
    private Object referrerClient;
    private int retries;
    private TimerOnce retryTimer;
    private int retryWaitTime = 3000;
    private final AtomicBoolean shouldTryToRead;

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            InstallReferrer.this.startConnection();
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f39929a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Method f39930b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object[] f39931c;

        public b(Object obj, Method method, Object[] objArr) {
            this.f39929a = obj;
            this.f39930b = method;
            this.f39931c = objArr;
        }

        public final void run() {
            try {
                Object unused = InstallReferrer.this.invokeI(this.f39929a, this.f39930b, this.f39931c);
            } catch (Throwable th2) {
                InstallReferrer.this.logger.error("invoke error (%s) thrown by (%s)", th2.getMessage(), th2.getClass().getCanonicalName());
            }
        }
    }

    public InstallReferrer(Context context2, InstallReferrerReadListener installReferrerReadListener) {
        ILogger logger2 = AdjustFactory.getLogger();
        this.logger = logger2;
        this.playInstallReferrer = createInstallReferrer(context2, installReferrerReadListener, logger2);
        this.context = context2;
        this.shouldTryToRead = new AtomicBoolean(true);
        this.retries = 0;
        this.retryTimer = new TimerOnce(new a(), "InstallReferrer");
        this.referrerCallback = installReferrerReadListener;
        this.executor = new SingleThreadCachedScheduler("InstallReferrer");
    }

    private void closeReferrerClient() {
        Object obj = this.referrerClient;
        if (obj != null) {
            try {
                Reflection.invokeInstanceMethod(obj, "endConnection", (Class[]) null, new Object[0]);
                this.logger.debug("Install Referrer API connection closed", new Object[0]);
            } catch (Exception e11) {
                this.logger.error("closeReferrerClient error (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            }
            this.referrerClient = null;
        }
    }

    private Object createInstallReferrer(Context context2, InstallReferrerReadListener installReferrerReadListener, ILogger iLogger) {
        return Reflection.createInstance("com.adjust.sdk.play.InstallReferrer", new Class[]{Context.class, InstallReferrerReadListener.class, ILogger.class}, context2, installReferrerReadListener, iLogger);
    }

    private Object createInstallReferrerClient(Context context2) {
        try {
            return Reflection.invokeInstanceMethod(Reflection.invokeStaticMethod("com.android.installreferrer.api.InstallReferrerClient", "newBuilder", new Class[]{Context.class}, context2), "build", (Class[]) null, new Object[0]);
        } catch (ClassNotFoundException e11) {
            this.logger.warn("InstallReferrer not integrated in project (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            return null;
        } catch (Exception e12) {
            this.logger.error("createInstallReferrerClient error (%s) from (%s)", e12.getMessage(), e12.getClass().getCanonicalName());
            return null;
        }
    }

    private Object createProxyInstallReferrerStateListener(Class cls) {
        try {
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
        } catch (IllegalArgumentException unused) {
            this.logger.error("InstallReferrer proxy violating parameter restrictions", new Object[0]);
            return null;
        } catch (NullPointerException unused2) {
            this.logger.error("Null argument passed to InstallReferrer proxy", new Object[0]);
            return null;
        }
    }

    private Boolean getBooleanGooglePlayInstantParam(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return Boolean.valueOf(((Boolean) Reflection.invokeInstanceMethod(obj, "getGooglePlayInstantParam", (Class[]) null, new Object[0])).booleanValue());
        } catch (Exception unused) {
            return null;
        }
    }

    private long getInstallBeginTimestampSeconds(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getInstallBeginTimestampSeconds", (Class[]) null, new Object[0])).longValue();
        } catch (Exception e11) {
            this.logger.error("getInstallBeginTimestampSeconds error (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            return -1;
        }
    }

    private long getInstallBeginTimestampServerSeconds(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getInstallBeginTimestampServerSeconds", (Class[]) null, new Object[0])).longValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    private Object getInstallReferrer() {
        Object obj = this.referrerClient;
        if (obj == null) {
            return null;
        }
        try {
            return Reflection.invokeInstanceMethod(obj, "getInstallReferrer", (Class[]) null, new Object[0]);
        } catch (Exception e11) {
            this.logger.error("getInstallReferrer error (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            return null;
        }
    }

    private Class getInstallReferrerStateListenerClass() {
        return InstallReferrerStateListener.class;
    }

    private long getReferrerClickTimestampSeconds(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getReferrerClickTimestampSeconds", (Class[]) null, new Object[0])).longValue();
        } catch (Exception e11) {
            this.logger.error("getReferrerClickTimestampSeconds error (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            return -1;
        }
    }

    private long getReferrerClickTimestampServerSeconds(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getReferrerClickTimestampServerSeconds", (Class[]) null, new Object[0])).longValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    private String getStringInstallReferrer(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (String) Reflection.invokeInstanceMethod(obj, "getInstallReferrer", (Class[]) null, new Object[0]);
        } catch (Exception e11) {
            this.logger.error("getStringInstallReferrer error (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            return null;
        }
    }

    private String getStringInstallVersion(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (String) Reflection.invokeInstanceMethod(obj, "getInstallVersion", (Class[]) null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public Object invokeI(Object obj, Method method, Object[] objArr) {
        if (method == null) {
            this.logger.error("InstallReferrer invoke method null", new Object[0]);
            return null;
        }
        String name2 = method.getName();
        if (name2 == null) {
            this.logger.error("InstallReferrer invoke method name null", new Object[0]);
            return null;
        }
        this.logger.debug("InstallReferrer invoke method name: %s", name2);
        if (objArr == null) {
            this.logger.warn("InstallReferrer invoke args null", new Object[0]);
            objArr = new Object[0];
        }
        for (Object obj2 : objArr) {
            this.logger.debug("InstallReferrer invoke arg: %s", obj2);
        }
        if (name2.equals("onInstallReferrerSetupFinished")) {
            if (objArr.length != 1) {
                this.logger.error("InstallReferrer invoke onInstallReferrerSetupFinished args lenght not 1: %d", Integer.valueOf(objArr.length));
                return null;
            }
            Object obj3 = objArr[0];
            if (!(obj3 instanceof Integer)) {
                this.logger.error("InstallReferrer invoke onInstallReferrerSetupFinished arg not int", new Object[0]);
                return null;
            }
            Integer num = (Integer) obj3;
            if (num == null) {
                this.logger.error("InstallReferrer invoke onInstallReferrerSetupFinished responseCode arg is null", new Object[0]);
                return null;
            }
            onInstallReferrerSetupFinishedIntI(num.intValue());
        } else if (name2.equals("onInstallReferrerServiceDisconnected")) {
            this.logger.debug("Connection to install referrer service was lost. Retrying ...", new Object[0]);
            retryI();
        }
        return null;
    }

    private void onInstallReferrerSetupFinishedIntI(int i11) {
        int i12 = i11;
        boolean z11 = true;
        if (i12 != -1) {
            if (i12 == 0) {
                try {
                    Object installReferrer = getInstallReferrer();
                    String stringInstallReferrer = getStringInstallReferrer(installReferrer);
                    long referrerClickTimestampSeconds = getReferrerClickTimestampSeconds(installReferrer);
                    long installBeginTimestampSeconds = getInstallBeginTimestampSeconds(installReferrer);
                    this.logger.debug("installReferrer: %s, clickTime: %d, installBeginTime: %d", stringInstallReferrer, Long.valueOf(referrerClickTimestampSeconds), Long.valueOf(installBeginTimestampSeconds));
                    String stringInstallVersion = getStringInstallVersion(installReferrer);
                    long referrerClickTimestampServerSeconds = getReferrerClickTimestampServerSeconds(installReferrer);
                    long installBeginTimestampServerSeconds = getInstallBeginTimestampServerSeconds(installReferrer);
                    Boolean booleanGooglePlayInstantParam = getBooleanGooglePlayInstantParam(installReferrer);
                    this.logger.debug("installVersion: %s, clickTimeServer: %d, installBeginServer: %d, googlePlayInstant: %b", stringInstallVersion, Long.valueOf(referrerClickTimestampServerSeconds), Long.valueOf(installBeginTimestampServerSeconds), booleanGooglePlayInstantParam);
                    this.logger.debug("Install Referrer read successfully. Closing connection", new Object[0]);
                    this.referrerCallback.onInstallReferrerRead(new ReferrerDetails(stringInstallReferrer, referrerClickTimestampSeconds, installBeginTimestampSeconds, referrerClickTimestampServerSeconds, installBeginTimestampServerSeconds, stringInstallVersion, booleanGooglePlayInstantParam), Constants.REFERRER_API_GOOGLE);
                } catch (Exception e11) {
                    this.logger.warn("Couldn't get install referrer from client (%s). Retrying...", e11.getMessage());
                }
            } else if (i12 == 1) {
                this.logger.debug("Could not initiate connection to the Install Referrer service. Retrying...", new Object[0]);
            } else if (i12 == 2) {
                this.logger.debug("Install Referrer API not supported by the installed Play Store app. Closing connection", new Object[0]);
            } else if (i12 != 3) {
                this.logger.debug("Unexpected response code of install referrer response: %d. Closing connection", Integer.valueOf(i11));
            } else {
                this.logger.debug("Install Referrer API general errors caused by incorrect usage. Retrying...", new Object[0]);
            }
            z11 = false;
        } else {
            this.logger.debug("Play Store service is not connected now. Retrying...", new Object[0]);
        }
        if (z11) {
            retryI();
            return;
        }
        this.shouldTryToRead.set(false);
        closeReferrerClient();
    }

    private void retryI() {
        if (!this.shouldTryToRead.get()) {
            this.logger.debug("Should not try to read Install referrer", new Object[0]);
            closeReferrerClient();
        } else if (this.retries + 1 > 2) {
            this.logger.debug("Limit number of retry of %d for install referrer surpassed", 2);
        } else {
            long fireIn = this.retryTimer.getFireIn();
            if (fireIn > 0) {
                this.logger.debug("Already waiting to retry to read install referrer in %d milliseconds", Long.valueOf(fireIn));
                return;
            }
            int i11 = this.retries + 1;
            this.retries = i11;
            this.logger.debug("Retry number %d to connect to install referrer API", Integer.valueOf(i11));
            this.retryTimer.startIn((long) this.retryWaitTime);
        }
    }

    private void startConnection(Class cls, Object obj) {
        try {
            Reflection.invokeInstanceMethod(this.referrerClient, "startConnection", new Class[]{cls}, obj);
        } catch (InvocationTargetException e11) {
            if (Util.hasRootCause(e11)) {
                this.logger.error("InstallReferrer encountered an InvocationTargetException %s", Util.getRootCause(e11));
            }
        } catch (Exception e12) {
            this.logger.error("startConnection error (%s) thrown by (%s)", e12.getMessage(), e12.getClass().getCanonicalName());
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.executor.submit(new b(obj, method, objArr));
        return null;
    }

    public void startConnection() {
        Class installReferrerStateListenerClass;
        Object createProxyInstallReferrerStateListener;
        Object obj = this.playInstallReferrer;
        if (obj != null) {
            try {
                Reflection.invokeInstanceMethod(obj, "startConnection", (Class[]) null, new Object[0]);
                return;
            } catch (Exception e11) {
                this.logger.error("Call to Play startConnection error: %s", e11.getMessage());
            }
        }
        if (AdjustFactory.getTryInstallReferrer()) {
            closeReferrerClient();
            if (!this.shouldTryToRead.get()) {
                this.logger.debug("Should not try to read Install referrer", new Object[0]);
                return;
            }
            Context context2 = this.context;
            if (context2 != null) {
                Object createInstallReferrerClient = createInstallReferrerClient(context2);
                this.referrerClient = createInstallReferrerClient;
                if (createInstallReferrerClient != null && (installReferrerStateListenerClass = getInstallReferrerStateListenerClass()) != null && (createProxyInstallReferrerStateListener = createProxyInstallReferrerStateListener(installReferrerStateListenerClass)) != null) {
                    startConnection(installReferrerStateListenerClass, createProxyInstallReferrerStateListener);
                }
            }
        }
    }
}
