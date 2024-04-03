package com.google.firebase.perf;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.concurrent.Executor;

public class FirebasePerfEarly {
    public FirebasePerfEarly(FirebaseApp firebaseApp, FirebaseSessions firebaseSessions, @Nullable StartupTime startupTime, Executor executor) {
        Context applicationContext = firebaseApp.getApplicationContext();
        ConfigResolver.getInstance().setApplicationContext(applicationContext);
        AppStateMonitor instance = AppStateMonitor.getInstance();
        instance.registerActivityLifecycleCallbacks(applicationContext);
        instance.registerForAppColdStart(new FirebasePerformanceInitializer());
        if (startupTime != null) {
            AppStartTrace instance2 = AppStartTrace.getInstance();
            instance2.registerActivityLifecycleCallbacks(applicationContext);
            executor.execute(new AppStartTrace.StartFromBackgroundRunnable(instance2));
        }
        firebaseSessions.register(new SessionSubscriber() {
            @NonNull
            public SessionSubscriber.Name getSessionSubscriberName() {
                return SessionSubscriber.Name.PERFORMANCE;
            }

            public boolean isDataCollectionEnabled() {
                return false;
            }

            public void onSessionChanged(@NonNull SessionSubscriber.SessionDetails sessionDetails) {
                SessionManager.getInstance().updatePerfSession(PerfSession.createWithId(sessionDetails.getSessionId()));
            }
        });
        SessionManager.getInstance().initializeGaugeCollection();
    }
}
