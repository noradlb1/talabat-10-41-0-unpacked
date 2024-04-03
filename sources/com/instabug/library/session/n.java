package com.instabug.library.session;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.internal.utils.PreferencesUtils;
import com.instabug.library.model.session.CoreSession;
import com.instabug.library.model.session.SessionMapper;
import com.instabug.library.model.session.SessionsBatchDTO;
import com.instabug.library.model.session.config.SessionsConfig;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.TimeUtils;
import id.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private SessionsConfig f51756a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final a f51757b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final PreferencesUtils f51758c;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final h f51759d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final k f51760e;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final c f51761f;

    public n(@NonNull SessionsConfig sessionsConfig, @NonNull a aVar, @NonNull PreferencesUtils preferencesUtils, @NonNull h hVar, @NonNull k kVar, @NonNull c cVar) {
        this.f51756a = sessionsConfig;
        this.f51757b = aVar;
        this.f51758c = preferencesUtils;
        this.f51759d = hVar;
        this.f51760e = kVar;
        this.f51761f = cVar;
    }

    public static n a(@NonNull Context context) {
        return new n(SettingsManager.getSessionsSyncConfigurations(context), new b(), l.a(context), l.b(), k.a(context), l.a());
    }

    private void c() {
        a(String.format(RateLimitedException.RATE_LIMIT_REACHED, new Object[]{"Sessions"}));
    }

    public boolean f() {
        if (b() >= ((long) this.f51756a.getSyncIntervalsInMinutes())) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public void g() {
        List list;
        if (this.f51756a.getSyncMode() == 0) {
            a("Sessions sync is not allowed. Sync mode = " + this.f51756a.getSyncMode());
            return;
        }
        a("Syncing local with remote. Sync configs = " + this.f51756a.toString());
        List b11 = this.f51759d.b();
        if (!b11.isEmpty()) {
            List<CoreSession> models = SessionMapper.toModels(b11);
            if (this.f51756a.getSyncMode() == 1) {
                list = this.f51757b.a(models, 1);
                a("Syncing " + list.size() + " batches of max 1 session per batch.");
            } else {
                int maxSessionsPerRequest = this.f51756a.getMaxSessionsPerRequest();
                list = this.f51757b.a(models, maxSessionsPerRequest);
                a("Syncing " + list.size() + " batches of max " + maxSessionsPerRequest + " sessions per batch.");
            }
            b(list);
            return;
        }
        a("No sessions ready for sync. Skipping...");
    }

    private void b(@NonNull List list) {
        l.a((Runnable) new a(this, list));
    }

    private void e() {
        a(TimeUtils.currentTimeMillis());
    }

    public n d() {
        a(TimeUtils.currentTimeMillis() - TimeUnit.MINUTES.toMillis((long) this.f51756a.getSyncIntervalsInMinutes()));
        return this;
    }

    private void b(@NonNull SessionsBatchDTO sessionsBatchDTO) {
        this.f51760e.a(sessionsBatchDTO, new m(this, sessionsBatchDTO, SessionMapper.toIDs(sessionsBatchDTO)));
    }

    private long b() {
        return TimeUnit.MILLISECONDS.toMinutes(TimeUtils.currentTimeMillis() - this.f51758c.getLong("key_last_batch_synced_at"));
    }

    public void a(@NonNull SessionsConfig sessionsConfig) {
        this.f51756a = sessionsConfig;
    }

    @WorkerThread
    public n a() {
        long b11 = b();
        if (this.f51756a.getSyncMode() == 0) {
            a("Invalidating cache. Sync mode = " + this.f51756a.getSyncMode());
            return this;
        }
        if (f() || this.f51756a.getSyncMode() == 1) {
            a("Evaluating cached sessions. Elapsed time since last sync = " + b11 + " mins. Sync configs = " + this.f51756a.toString());
            this.f51759d.a();
            e();
        } else if (InstabugDeviceProperties.getVersionCode().intValue() != SettingsManager.getInstance().getLastKnownVersionCode()) {
            SettingsManager.getInstance().setVersionCode(InstabugDeviceProperties.getVersionCode().intValue());
            SettingsManager.getInstance().setIsFirstSession(true);
            a("App version has changed. Marking cached sessions as ready for sync");
            this.f51759d.a();
        } else {
            a("Skipping sessions evaluation. Elapsed time since last sync = " + b11 + " mins. Sync configs = " + this.f51756a.toString());
        }
        return this;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SessionsBatchDTO sessionsBatchDTO = (SessionsBatchDTO) it.next();
            if (this.f51761f.a()) {
                a(sessionsBatchDTO);
            } else {
                this.f51761f.a(System.currentTimeMillis());
                b(sessionsBatchDTO);
            }
        }
    }

    private void a(@NonNull SessionsBatchDTO sessionsBatchDTO) {
        List<String> iDs = SessionMapper.toIDs(sessionsBatchDTO);
        this.f51759d.b((List) iDs).a((List) iDs);
        c();
    }

    /* access modifiers changed from: private */
    public void a(RateLimitedException rateLimitedException, @NonNull SessionsBatchDTO sessionsBatchDTO) {
        this.f51761f.a(rateLimitedException.getPeriod());
        a(sessionsBatchDTO);
    }

    public void a(long j11) {
        this.f51758c.saveOrUpdateLong("key_last_batch_synced_at", j11);
    }

    /* access modifiers changed from: private */
    public void a(@NonNull String str) {
        InstabugSDKLogger.d("IBG-Core", str);
    }
}
