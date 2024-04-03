package com.instabug.library.logging;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.UserEventsEventBus;
import com.instabug.library.e0;
import com.instabug.library.user.UserEvent;
import com.instabug.library.user.UserEventParam;
import com.instabug.library.user.f;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.memory.Action;
import com.instabug.library.util.memory.MemoryGuard;
import com.instabug.library.util.memory.MemoryUtils;
import com.instabug.library.util.memory.predicate.MemoryNotLowPredicate;
import com.instabug.library.util.threading.PoolProvider;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class InstabugUserEventLogger {
    private static final int USER_EVENT_COUNT_LIMIT = 1000;
    private static volatile InstabugUserEventLogger instabugUserEventLogger;
    /* access modifiers changed from: private */
    public List<UserEvent> userEvents = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Integer> userEventsCount = new ConcurrentHashMap<>();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51440b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UserEventParam[] f51441c;

        public a(String str, UserEventParam[] userEventParamArr) {
            this.f51440b = str;
            this.f51441c = userEventParamArr;
        }

        public void run() {
            if (e0.c().b((Object) Feature.USER_EVENTS) == Feature.State.ENABLED) {
                UserEvent date = new UserEvent().setEventIdentifier(this.f51440b).setDate(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds());
                for (UserEventParam addParam : this.f51441c) {
                    date.addParam(addParam);
                }
                if (InstabugUserEventLogger.this.userEvents.size() >= 1000) {
                    InstabugUserEventLogger.this.userEvents.remove(0);
                }
                InstabugUserEventLogger.this.userEvents.add(date);
                Integer num = (Integer) InstabugUserEventLogger.this.userEventsCount.get(this.f51440b);
                if (num != null) {
                    InstabugUserEventLogger.this.userEventsCount.put(this.f51440b, Integer.valueOf(num.intValue() + 1));
                } else {
                    InstabugUserEventLogger.this.userEventsCount.put(this.f51440b, 1);
                }
                InstabugUserEventLogger.this.runInsertionHandler(f.l(), true ^ f.p());
            }
        }
    }

    public class b implements Action {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51443a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f51444b;

        public b(String str, boolean z11) {
            this.f51443a = str;
            this.f51444b = z11;
        }

        public void onAffirmed() {
            try {
                for (Map.Entry entry : InstabugUserEventLogger.this.userEventsCount.entrySet()) {
                    InstabugUserEventLogger.this.incrementEventLoggingCount((String) entry.getKey(), ((Integer) entry.getValue()).intValue(), this.f51443a, this.f51444b);
                }
                InstabugUserEventLogger.this.userEventsCount.clear();
            } catch (OutOfMemoryError e11) {
                InstabugCore.reportError(e11, "Error: " + e11.getMessage() + "while inserting user events");
                if (e11.getMessage() != null) {
                    InstabugSDKLogger.e("IBG-Core", "Error: " + e11.getMessage() + "while inserting user events");
                }
            }
        }

        public void onDenied() throws Throwable {
            InstabugSDKLogger.e("IBG-Core", "Failed to update user events due to low memory");
        }
    }

    private InstabugUserEventLogger() {
    }

    public static synchronized InstabugUserEventLogger getInstance() {
        InstabugUserEventLogger instabugUserEventLogger2;
        synchronized (InstabugUserEventLogger.class) {
            if (instabugUserEventLogger == null) {
                instabugUserEventLogger = new InstabugUserEventLogger();
            }
            instabugUserEventLogger2 = instabugUserEventLogger;
        }
        return instabugUserEventLogger2;
    }

    /* access modifiers changed from: private */
    public void incrementEventLoggingCount(@NonNull String str, int i11, String str2, boolean z11) {
        e.a(str, e.b(str, f.k()) + i11, str2, z11);
        UserEventsEventBus.getInstance().post(new UserEvent().setEventIdentifier(str));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void runInsertionHandler(String str, boolean z11) {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null && !MemoryUtils.isLowMemory(applicationContext)) {
            MemoryGuard.from(applicationContext).withPredicate(new MemoryNotLowPredicate()).forOperation("updating user events").doAction(new b(str, z11));
        }
    }

    public void clearAll() throws IllegalStateException {
        this.userEvents.clear();
    }

    public void clearLoggingData() throws IllegalStateException {
        e.a(f.k());
    }

    @VisibleForTesting
    public int e(@NonNull String str) {
        return e.b(str, f.k());
    }

    public List<UserEvent> getUserEvents() throws IllegalStateException {
        return this.userEvents;
    }

    public synchronized void logUserEvent(@NonNull String str, UserEventParam... userEventParamArr) {
        PoolProvider.getUserActionsExecutor().execute(new a(str, userEventParamArr));
    }

    public List<UserEvent> getUserEvents(float f11) throws IllegalStateException {
        int round = Math.round(f11 * 1000.0f);
        if (this.userEvents.size() <= round) {
            return this.userEvents;
        }
        int size = this.userEvents.size() - round;
        List<UserEvent> list = this.userEvents;
        return list.subList(size, list.size());
    }
}
