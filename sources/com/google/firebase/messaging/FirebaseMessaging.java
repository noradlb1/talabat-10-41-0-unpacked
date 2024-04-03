package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import fa.f;
import fa.g;
import fa.h;
import fa.i;
import fa.j;
import fa.k;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseMessaging {
    private static final String EXTRA_DUMMY_P_INTENT = "app";
    static final String GMS_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static final long MIN_DELAY_SEC = 30;
    private static final String SEND_INTENT_ACTION = "com.google.android.gcm.intent.SEND";
    private static final String SUBTYPE_DEFAULT = "";
    static final String TAG = "FirebaseMessaging";
    @GuardedBy("FirebaseMessaging.class")
    private static Store store;
    @VisibleForTesting
    @GuardedBy("FirebaseMessaging.class")
    static ScheduledExecutorService syncExecutor;
    @VisibleForTesting
    @SuppressLint({"FirebaseUnknownNullness"})
    @Nullable
    static TransportFactory transportFactory;
    private final AutoInit autoInit;
    private final Context context;
    private final Executor fileExecutor;
    /* access modifiers changed from: private */
    public final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi fis;
    private final GmsRpc gmsRpc;
    @Nullable
    private final FirebaseInstanceIdInternal iid;
    private final Executor initExecutor;
    private final Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private final Metadata metadata;
    private final RequestDeduplicator requestDeduplicator;
    @GuardedBy("this")
    private boolean syncScheduledOrRunning;
    private final Executor taskExecutor;
    private final Task<TopicsSubscriber> topicsSubscriberTask;

    public class AutoInit {
        private static final String AUTO_INIT_PREF = "auto_init";
        private static final String FCM_PREFERENCES = "com.google.firebase.messaging";
        private static final String MANIFEST_METADATA_AUTO_INIT_ENABLED = "firebase_messaging_auto_init_enabled";
        @GuardedBy("this")
        @Nullable
        private Boolean autoInitEnabled;
        @GuardedBy("this")
        @Nullable
        private EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
        @GuardedBy("this")
        private boolean initialized;
        private final Subscriber subscriber;

        public AutoInit(Subscriber subscriber2) {
            this.subscriber = subscriber2;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$initialize$0(Event event) {
            if (isEnabled()) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
        }

        @Nullable
        private Boolean readEnabled() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context applicationContext = FirebaseMessaging.this.firebaseApp.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains(AUTO_INIT_PREF)) {
                return Boolean.valueOf(sharedPreferences.getBoolean(AUTO_INIT_PREF, false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(MANIFEST_METADATA_AUTO_INIT_ENABLED)) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(MANIFEST_METADATA_AUTO_INIT_ENABLED));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        public synchronized void initialize() {
            if (!this.initialized) {
                Boolean readEnabled = readEnabled();
                this.autoInitEnabled = readEnabled;
                if (readEnabled == null) {
                    g gVar = new g(this);
                    this.dataCollectionDefaultChangeEventHandler = gVar;
                    this.subscriber.subscribe(DataCollectionDefaultChange.class, gVar);
                }
                this.initialized = true;
            }
        }

        public synchronized boolean isEnabled() {
            boolean z11;
            initialize();
            Boolean bool = this.autoInitEnabled;
            if (bool != null) {
                z11 = bool.booleanValue();
            } else {
                z11 = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
            }
            return z11;
        }

        public synchronized void setEnabled(boolean z11) {
            initialize();
            EventHandler<DataCollectionDefaultChange> eventHandler = this.dataCollectionDefaultChangeEventHandler;
            if (eventHandler != null) {
                this.subscriber.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                this.dataCollectionDefaultChangeEventHandler = null;
            }
            SharedPreferences.Editor edit = FirebaseMessaging.this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean(AUTO_INIT_PREF, z11);
            edit.apply();
            if (z11) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
            this.autoInitEnabled = Boolean.valueOf(z11);
        }
    }

    public FirebaseMessaging(FirebaseApp firebaseApp2, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable TransportFactory transportFactory2, Subscriber subscriber) {
        this(firebaseApp2, firebaseInstanceIdInternal, provider, provider2, firebaseInstallationsApi, transportFactory2, subscriber, new Metadata(firebaseApp2.getApplicationContext()));
    }

    @VisibleForTesting
    public static synchronized void clearStoreForTest() {
        synchronized (FirebaseMessaging.class) {
            store = null;
        }
    }

    public static void clearTransportFactoryForTest() {
        transportFactory = null;
    }

    @NonNull
    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(FirebaseApp.getInstance());
        }
        return instance;
    }

    @NonNull
    private static synchronized Store getStore(Context context2) {
        Store store2;
        synchronized (FirebaseMessaging.class) {
            if (store == null) {
                store = new Store(context2);
            }
            store2 = store;
        }
        return store2;
    }

    private String getSubtype() {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName())) {
            return "";
        }
        return this.firebaseApp.getPersistenceKey();
    }

    @Nullable
    public static TransportFactory getTransportFactory() {
        return transportFactory;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeOnTokenRefresh */
    public void lambda$new$0(String str) {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invoking onNewToken for app: ");
                sb2.append(this.firebaseApp.getName());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra(LegacyTokenLocalDataSourceImpl.KEY, str);
            new FcmBroadcastProcessor(this.context).process(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$blockingGetToken$10(String str, Store.Token token) {
        return this.gmsRpc.getToken().onSuccessTask(this.fileExecutor, new c(this, str, token));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$blockingGetToken$9(String str, Store.Token token, String str2) throws Exception {
        getStore(this.context).saveToken(getSubtype(), str, str2, this.metadata.getAppVersionCode());
        if (token == null || !str2.equals(token.token)) {
            lambda$new$0(str2);
        }
        return Tasks.forResult(str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteToken$5(TaskCompletionSource taskCompletionSource) {
        try {
            this.iid.deleteToken(Metadata.getDefaultSenderId(this.firebaseApp), INSTANCE_ID_SCOPE);
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteToken$6(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(this.gmsRpc.deleteToken());
            getStore(this.context).deleteToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
            taskCompletionSource.setResult(null);
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getToken$4(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingGetToken());
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        if (isAutoInitEnabled()) {
            startSyncIfNecessary();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(TopicsSubscriber topicsSubscriber) {
        if (isAutoInitEnabled()) {
            topicsSubscriber.startTopicsSyncIfNecessary();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3() {
        ProxyNotificationInitializer.initialize(this.context);
    }

    private synchronized void startSync() {
        if (!this.syncScheduledOrRunning) {
            syncWithDelaySecondsInternal(0);
        }
    }

    /* access modifiers changed from: private */
    public void startSyncIfNecessary() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.getToken();
        } else if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            startSync();
        }
    }

    public String blockingGetToken() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.await(firebaseInstanceIdInternal.getTokenTask());
            } catch (InterruptedException | ExecutionException e11) {
                throw new IOException(e11);
            }
        } else {
            Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
            if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
                return tokenWithoutTriggeringSync.token;
            }
            String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
            try {
                return (String) Tasks.await(this.requestDeduplicator.getOrStartGetTokenRequest(defaultSenderId, new f(this, defaultSenderId, tokenWithoutTriggeringSync)));
            } catch (InterruptedException | ExecutionException e12) {
                throw new IOException(e12);
            }
        }
    }

    @NonNull
    public Task<Void> deleteToken() {
        if (this.iid != null) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.initExecutor.execute(new i(this, taskCompletionSource));
            return taskCompletionSource.getTask();
        } else if (getTokenWithoutTriggeringSync() == null) {
            return Tasks.forResult(null);
        } else {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            FcmExecutors.newNetworkIOExecutor().execute(new j(this, taskCompletionSource2));
            return taskCompletionSource2.getTask();
        }
    }

    @NonNull
    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
    }

    @SuppressLint({"ThreadPoolCreation"})
    public void enqueueTaskWithDelaySeconds(Runnable runnable, long j11) {
        synchronized (FirebaseMessaging.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
            }
            syncExecutor.schedule(runnable, j11, TimeUnit.SECONDS);
        }
    }

    public Context getApplicationContext() {
        return this.context;
    }

    @NonNull
    public Task<String> getToken() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.getTokenTask();
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.initExecutor.execute(new k(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @VisibleForTesting
    @Nullable
    public Store.Token getTokenWithoutTriggeringSync() {
        return getStore(this.context).getToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
    }

    public Task<TopicsSubscriber> getTopicsSubscriberTask() {
        return this.topicsSubscriberTask;
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.isEnabled();
    }

    @VisibleForTesting
    public boolean isGmsCorePresent() {
        return this.metadata.isGmscorePresent();
    }

    public boolean isNotificationDelegationEnabled() {
        return ProxyNotificationInitializer.isProxyNotificationEnabled(this.context);
    }

    @Deprecated
    public void send(@NonNull RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Intent intent = new Intent(SEND_INTENT_ACTION);
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            intent.putExtra(EXTRA_DUMMY_P_INTENT, PendingIntent.getBroadcast(this.context, 0, intent2, 67108864));
            intent.setPackage("com.google.android.gms");
            remoteMessage.populateSendMessageIntent(intent);
            this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void setAutoInitEnabled(boolean z11) {
        this.autoInit.setEnabled(z11);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z11) {
        MessagingAnalytics.setDeliveryMetricsExportToBigQuery(z11);
    }

    @NonNull
    public Task<Void> setNotificationDelegationEnabled(boolean z11) {
        return ProxyNotificationInitializer.setEnableProxyNotification(this.initExecutor, this.context, z11);
    }

    public synchronized void setSyncScheduledOrRunning(boolean z11) {
        this.syncScheduledOrRunning = z11;
    }

    @SuppressLint({"TaskMainThread"})
    @NonNull
    public Task<Void> subscribeToTopic(@NonNull String str) {
        return this.topicsSubscriberTask.onSuccessTask(new e(str));
    }

    public synchronized void syncWithDelaySecondsInternal(long j11) {
        enqueueTaskWithDelaySeconds(new SyncTask(this, Math.min(Math.max(MIN_DELAY_SEC, 2 * j11), MAX_DELAY_SEC)), j11);
        this.syncScheduledOrRunning = true;
    }

    @VisibleForTesting
    public boolean tokenNeedsRefresh(@Nullable Store.Token token) {
        return token == null || token.needsRefresh(this.metadata.getAppVersionCode());
    }

    @SuppressLint({"TaskMainThread"})
    @NonNull
    public Task<Void> unsubscribeFromTopic(@NonNull String str) {
        return this.topicsSubscriberTask.onSuccessTask(new b(str));
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp2) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp2.get(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FirebaseMessaging(com.google.firebase.FirebaseApp r12, @androidx.annotation.Nullable com.google.firebase.iid.internal.FirebaseInstanceIdInternal r13, com.google.firebase.inject.Provider<com.google.firebase.platforminfo.UserAgentPublisher> r14, com.google.firebase.inject.Provider<com.google.firebase.heartbeatinfo.HeartBeatInfo> r15, com.google.firebase.installations.FirebaseInstallationsApi r16, @androidx.annotation.Nullable com.google.android.datatransport.TransportFactory r17, com.google.firebase.events.Subscriber r18, com.google.firebase.messaging.Metadata r19) {
        /*
            r11 = this;
            com.google.firebase.messaging.GmsRpc r7 = new com.google.firebase.messaging.GmsRpc
            r0 = r7
            r1 = r12
            r2 = r19
            r3 = r14
            r4 = r15
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5)
            java.util.concurrent.ExecutorService r8 = com.google.firebase.messaging.FcmExecutors.newTaskExecutor()
            java.util.concurrent.ScheduledExecutorService r9 = com.google.firebase.messaging.FcmExecutors.newInitExecutor()
            java.util.concurrent.Executor r10 = com.google.firebase.messaging.FcmExecutors.newFileIOExecutor()
            r0 = r11
            r2 = r13
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessaging.<init>(com.google.firebase.FirebaseApp, com.google.firebase.iid.internal.FirebaseInstanceIdInternal, com.google.firebase.inject.Provider, com.google.firebase.inject.Provider, com.google.firebase.installations.FirebaseInstallationsApi, com.google.android.datatransport.TransportFactory, com.google.firebase.events.Subscriber, com.google.firebase.messaging.Metadata):void");
    }

    public FirebaseMessaging(FirebaseApp firebaseApp2, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable TransportFactory transportFactory2, Subscriber subscriber, Metadata metadata2, GmsRpc gmsRpc2, Executor executor, Executor executor2, Executor executor3) {
        this.syncScheduledOrRunning = false;
        transportFactory = transportFactory2;
        this.firebaseApp = firebaseApp2;
        this.iid = firebaseInstanceIdInternal;
        this.fis = firebaseInstallationsApi;
        this.autoInit = new AutoInit(subscriber);
        Context applicationContext = firebaseApp2.getApplicationContext();
        this.context = applicationContext;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.lifecycleCallbacks = fcmLifecycleCallbacks;
        this.metadata = metadata2;
        this.taskExecutor = executor;
        this.gmsRpc = gmsRpc2;
        this.requestDeduplicator = new RequestDeduplicator(executor);
        this.initExecutor = executor2;
        this.fileExecutor = executor3;
        Context applicationContext2 = firebaseApp2.getApplicationContext();
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            Log.w("FirebaseMessaging", "Context " + applicationContext2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.addNewTokenListener(new f(this));
        }
        executor2.execute(new g(this));
        Task<TopicsSubscriber> createInstance = TopicsSubscriber.createInstance(this, metadata2, gmsRpc2, applicationContext, FcmExecutors.newTopicsSyncExecutor());
        this.topicsSubscriberTask = createInstance;
        createInstance.addOnSuccessListener(executor2, (OnSuccessListener<? super TopicsSubscriber>) new d(this));
        executor2.execute(new h(this));
    }
}
