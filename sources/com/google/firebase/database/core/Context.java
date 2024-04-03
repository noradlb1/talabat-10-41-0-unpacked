package com.google.firebase.database.core;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.android.AndroidPlatform;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.ConnectionTokenProvider;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import z9.a;

public class Context {
    private static final long DEFAULT_CACHE_SIZE = 10485760;
    protected TokenProvider appCheckTokenProvider;
    protected TokenProvider authTokenProvider;
    protected long cacheSize = DEFAULT_CACHE_SIZE;
    protected EventTarget eventTarget;
    protected FirebaseApp firebaseApp;
    private PersistenceManager forcedPersistenceManager;
    private boolean frozen = false;
    protected Logger.Level logLevel = Logger.Level.INFO;
    protected List<String> loggedComponents;
    protected Logger logger;
    protected boolean persistenceEnabled;
    protected String persistenceKey;
    private Platform platform;
    protected RunLoop runLoop;
    private boolean stopped = false;
    protected String userAgent;

    private String buildUserAgent(String str) {
        return "Firebase/" + "5" + "/" + FirebaseDatabase.getSdkVersion() + "/" + str;
    }

    private void ensureAppTokenProvider() {
        Preconditions.checkNotNull(this.appCheckTokenProvider, "You must register an appCheckTokenProvider before initializing Context.");
    }

    private void ensureAuthTokenProvider() {
        Preconditions.checkNotNull(this.authTokenProvider, "You must register an authTokenProvider before initializing Context.");
    }

    private void ensureEventTarget() {
        if (this.eventTarget == null) {
            this.eventTarget = getPlatform().newEventTarget(this);
        }
    }

    private void ensureLogger() {
        if (this.logger == null) {
            this.logger = getPlatform().newLogger(this, this.logLevel, this.loggedComponents);
        }
    }

    private void ensureRunLoop() {
        if (this.runLoop == null) {
            this.runLoop = this.platform.newRunLoop(this);
        }
    }

    private void ensureSessionIdentifier() {
        if (this.persistenceKey == null) {
            this.persistenceKey = "default";
        }
    }

    private void ensureUserAgent() {
        if (this.userAgent == null) {
            this.userAgent = buildUserAgent(getPlatform().getUserAgent(this));
        }
    }

    private ScheduledExecutorService getExecutorService() {
        RunLoop runLoop2 = getRunLoop();
        if (runLoop2 instanceof DefaultRunLoop) {
            return ((DefaultRunLoop) runLoop2).getExecutorService();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private Platform getPlatform() {
        if (this.platform == null) {
            initializeAndroidPlatform();
        }
        return this.platform;
    }

    private void initServices() {
        ensureLogger();
        getPlatform();
        ensureUserAgent();
        ensureEventTarget();
        ensureRunLoop();
        ensureSessionIdentifier();
        ensureAuthTokenProvider();
        ensureAppTokenProvider();
    }

    private synchronized void initializeAndroidPlatform() {
        this.platform = new AndroidPlatform(this.firebaseApp);
    }

    private void restartServices() {
        this.eventTarget.restart();
        this.runLoop.restart();
    }

    private static ConnectionTokenProvider wrapTokenProvider(TokenProvider tokenProvider, ScheduledExecutorService scheduledExecutorService) {
        return new a(tokenProvider, scheduledExecutorService);
    }

    public void assertUnfrozen() {
        if (isFrozen()) {
            throw new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public void forcePersistenceManager(PersistenceManager persistenceManager) {
        this.forcedPersistenceManager = persistenceManager;
    }

    public synchronized void freeze() {
        if (!this.frozen) {
            this.frozen = true;
            initServices();
        }
    }

    public TokenProvider getAppCheckTokenProvider() {
        return this.appCheckTokenProvider;
    }

    public TokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public ConnectionContext getConnectionContext() {
        return new ConnectionContext(getLogger(), wrapTokenProvider(getAuthTokenProvider(), getExecutorService()), wrapTokenProvider(getAppCheckTokenProvider(), getExecutorService()), getExecutorService(), isPersistenceEnabled(), FirebaseDatabase.getSdkVersion(), getUserAgent(), this.firebaseApp.getOptions().getApplicationId(), getSSLCacheDirectory().getAbsolutePath());
    }

    public EventTarget getEventTarget() {
        return this.eventTarget;
    }

    public Logger.Level getLogLevel() {
        return this.logLevel;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public List<String> getOptDebugLogComponents() {
        return this.loggedComponents;
    }

    public long getPersistenceCacheSizeBytes() {
        return this.cacheSize;
    }

    public PersistenceManager getPersistenceManager(String str) {
        PersistenceManager persistenceManager = this.forcedPersistenceManager;
        if (persistenceManager != null) {
            return persistenceManager;
        }
        if (!this.persistenceEnabled) {
            return new NoopPersistenceManager();
        }
        PersistenceManager createPersistenceManager = this.platform.createPersistenceManager(this, str);
        if (createPersistenceManager != null) {
            return createPersistenceManager;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }

    public String getPlatformVersion() {
        return getPlatform().getPlatformVersion();
    }

    public RunLoop getRunLoop() {
        return this.runLoop;
    }

    public File getSSLCacheDirectory() {
        return getPlatform().getSSLCacheDirectory();
    }

    public String getSessionPersistenceKey() {
        return this.persistenceKey;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    public PersistentConnection newPersistentConnection(HostInfo hostInfo, PersistentConnection.Delegate delegate) {
        return getPlatform().newPersistentConnection(this, getConnectionContext(), hostInfo, delegate);
    }

    public void requireStarted() {
        if (this.stopped) {
            restartServices();
            this.stopped = false;
        }
    }

    public void stop() {
        this.stopped = true;
        this.eventTarget.shutdown();
        this.runLoop.shutdown();
    }

    public LogWrapper getLogger(String str) {
        return new LogWrapper(this.logger, str);
    }

    public LogWrapper getLogger(String str, String str2) {
        return new LogWrapper(this.logger, str, str2);
    }
}
