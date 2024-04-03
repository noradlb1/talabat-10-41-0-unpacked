package com.instabug.survey;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.OnDiskCache;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.survey.announcements.b;
import com.instabug.survey.announcements.network.g;
import com.instabug.survey.cache.l;
import com.instabug.survey.configuration.d;
import com.instabug.survey.models.Survey;
import com.instabug.survey.settings.c;
import com.instabug.survey.utils.e;
import com.instabug.survey.utils.j;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import sd.f;

public class SurveyPlugin extends Plugin {
    @Nullable
    private b announcementManager;
    private final d configurationsProvider = com.instabug.survey.di.a.b();
    @Nullable
    private Disposable subscribe;
    @Nullable
    private Disposable userTypeDisposable;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (!c.k() && SurveyPlugin.this.contextWeakReference != null && SurveyPlugin.this.contextWeakReference.get() != null) {
                new OnDiskCache((Context) SurveyPlugin.this.contextWeakReference.get(), "surveys_disk_cache", "/surveys.cache", Survey.class).delete();
                c.p();
            }
        }
    }

    private void checkAppStatus() {
        Context context;
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference != null && (context = weakReference.get()) != null) {
            e.a(context);
        }
    }

    private static void clearUserActivities() {
        if (com.instabug.survey.settings.b.c() != null) {
            com.instabug.survey.settings.b.c().c(0);
            com.instabug.survey.settings.b.c().a(0);
        }
    }

    private String getLocaleResolved() {
        return getAppContext() == null ? "default" : LocaleUtils.getCurrentLocaleResolved(getAppContext());
    }

    private void initAnnouncementSettings(Context context) {
        this.announcementManager = b.a(context);
        com.instabug.survey.announcements.settings.b.a(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0(Context context) {
        com.instabug.survey.settings.b.a(context);
        initAnnouncementSettings(context);
        subscribeOnSDKEvents();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startFetchingRequests$3() {
        startFetchingSurveys(getLocaleResolved());
        startFetchingAnnouncements(getLocaleResolved());
        resolveCountryInfo(new com.instabug.survey.models.a());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$startSubmittingPendingAnnouncements$4() {
        if (!com.instabug.survey.announcements.cache.e.c().isEmpty()) {
            g.a().start();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startSubmittingPendingSurveys$5() {
        List a11 = l.a();
        if (this.contextWeakReference != null && !a11.isEmpty()) {
            com.instabug.survey.network.service.c.a().start();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$subscribeOnSDKEvents$2(SDKCoreEvent sDKCoreEvent) {
        if (sDKCoreEvent.getType().equals(SDKCoreEvent.Feature.TYPE_FEATURES_FETCHED)) {
            com.instabug.survey.di.a.a().a(sDKCoreEvent.getValue());
        }
        if (j.d()) {
            String type = sDKCoreEvent.getType();
            type.hashCode();
            char c11 = 65535;
            switch (type.hashCode()) {
                case -290659267:
                    if (type.equals("features")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3599307:
                    if (type.equals("user")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 28615825:
                    if (type.equals("cache_dump")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1843485230:
                    if (type.equals(SDKCoreEvent.Network.TYPE_NETWORK)) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    if (sDKCoreEvent.getValue().equals(SDKCoreEvent.Feature.VALUE_FETCHED)) {
                        startFetchingRequests();
                        return;
                    }
                    return;
                case 1:
                    if (sDKCoreEvent.getValue().equals(SDKCoreEvent.User.VALUE_LOGGED_OUT)) {
                        clearUserActivities();
                        return;
                    }
                    return;
                case 2:
                    if (sDKCoreEvent.getValue().equals("cache_dumped_successfully")) {
                        PoolProvider.postIOTask(new f());
                        return;
                    }
                    return;
                case 3:
                    if (sDKCoreEvent.getValue().equals(SDKCoreEvent.Network.VALUE_ACTIVATED)) {
                        startSubmittingPendingSurveys();
                        startSubmittingPendingAnnouncements();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$wake$1(SDKCoreEvent sDKCoreEvent) {
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference != null && weakReference.get() != null && h.e() != null) {
            if (sDKCoreEvent.getType().equals("user") && sDKCoreEvent.getValue().equals(SDKCoreEvent.User.VALUE_LOGGED_OUT)) {
                h.e().r();
                b.a(this.contextWeakReference.get()).h();
            } else if (sDKCoreEvent.getType().equals("user") && sDKCoreEvent.getValue().equals(SDKCoreEvent.User.VALUE_LOGGED_IN)) {
                h.e().s();
                b.a(this.contextWeakReference.get()).i();
            }
        }
    }

    private void removeOldSurveys() {
        PoolProvider.postIOTask(new a());
    }

    private void startFetchingRequests() {
        PoolProvider.postIOTask(new sd.b(this));
    }

    private void startSubmittingPendingAnnouncements() {
        if (InstabugCore.getFeatureState(Feature.ANNOUNCEMENTS) == Feature.State.ENABLED && this.configurationsProvider.b()) {
            WeakReference<Context> weakReference = this.contextWeakReference;
            if (weakReference == null || weakReference.get() == null) {
                InstabugSDKLogger.e("IBG-Surveys", "Couldn't submit announcements due to null context");
            } else {
                PoolProvider.postIOTask(new sd.c());
            }
        }
    }

    private void startSubmittingPendingSurveys() {
        if (InstabugCore.getFeatureState(Feature.SURVEYS) == Feature.State.ENABLED && this.configurationsProvider.c()) {
            WeakReference<Context> weakReference = this.contextWeakReference;
            if (weakReference == null || weakReference.get() == null) {
                InstabugSDKLogger.e("IBG-Surveys", "Couldn't submit surveys due to null context");
            } else {
                PoolProvider.postIOTask(new sd.d(this));
            }
        }
    }

    private void unSubscribeOnSDKEvents() {
        Disposable disposable = this.subscribe;
        if (disposable != null && !disposable.isDisposed()) {
            this.subscribe.dispose();
            this.subscribe = null;
        }
    }

    public void fetchSurveysImmediately(String str) {
        WeakReference<Context> weakReference;
        if (InstabugCore.isAppOnForeground() && InstabugCore.isFeaturesFetchedBefore() && j.d() && this.configurationsProvider.c() && !this.configurationsProvider.d() && (weakReference = this.contextWeakReference) != null && weakReference.get() != null && h.e() != null) {
            h.e().a(str);
        }
    }

    public long getLastActivityTime() {
        if (com.instabug.survey.settings.b.c() == null) {
            return -1;
        }
        return com.instabug.survey.settings.b.c().e();
    }

    public void init(Context context) {
        super.init(context);
    }

    public boolean isFeatureEnabled() {
        return InstabugCore.isFeatureEnabled(Feature.SURVEYS);
    }

    public void onLocaleChanged(Locale locale, Locale locale2) {
        super.onLocaleChanged(locale, locale2);
        c.b(0);
        com.instabug.survey.announcements.settings.a.b().b(0);
        if (shouldReFetch() && getAppContext() != null) {
            String resolveLocale = LocaleUtils.resolveLocale(getAppContext(), locale2);
            startFetchingAnnouncements(resolveLocale);
            fetchSurveysImmediately(resolveLocale);
        }
    }

    @VisibleForTesting
    public void resolveCountryInfo(com.instabug.survey.models.a aVar) {
        WeakReference<Context> weakReference;
        if (j.c() && (weakReference = this.contextWeakReference) != null && weakReference.get() != null && h.e() != null) {
            InstabugSDKLogger.d("IBG-Surveys", "Getting Country Code...");
            h.e().g(aVar);
        }
    }

    @VisibleForTesting
    public boolean shouldReFetch() {
        return !getLocaleResolved().equals(c.f());
    }

    public void sleep() {
        b bVar = this.announcementManager;
        if (bVar != null) {
            bVar.j();
        }
        if (h.e() != null) {
            h.e().t();
        }
        Disposable disposable = this.userTypeDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void start(Context context) {
        PoolProvider.postIOTaskWithCheck(new sd.a(this, context));
    }

    @VisibleForTesting
    public void startFetchingAnnouncements(String str) {
        WeakReference<Context> weakReference;
        try {
            if (InstabugCore.isAppOnForeground() && (weakReference = this.contextWeakReference) != null && weakReference.get() != null && InstabugCore.getFeatureState(Feature.ANNOUNCEMENTS) == Feature.State.ENABLED && this.configurationsProvider.b()) {
                b.a(this.contextWeakReference.get()).b(str);
            }
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "Error while fetching and processing announcements: " + e11.getMessage());
        }
    }

    @VisibleForTesting
    public void startFetchingSurveys(String str) {
        WeakReference<Context> weakReference;
        if (InstabugCore.isAppOnForeground() && InstabugCore.isFeaturesFetchedBefore() && j.d() && this.configurationsProvider.a() && (weakReference = this.contextWeakReference) != null && weakReference.get() != null && h.e() != null) {
            h.e().f(str);
        }
    }

    public void stop() {
        com.instabug.survey.settings.b.h();
        com.instabug.survey.settings.a.m();
        unSubscribeOnSDKEvents();
    }

    @VisibleForTesting
    public void subscribeOnSDKEvents() {
        if (this.subscribe == null) {
            this.subscribe = SDKCoreEventSubscriber.subscribe(new sd.e(this));
        }
    }

    public void wake() {
        removeOldSurveys();
        h.f();
        if (h.e() != null) {
            h.e().n();
        }
        checkAppStatus();
        this.userTypeDisposable = SDKCoreEventSubscriber.subscribe(new sd.g(this));
    }
}
