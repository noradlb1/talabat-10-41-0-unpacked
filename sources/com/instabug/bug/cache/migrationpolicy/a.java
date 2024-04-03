package com.instabug.bug.cache.migrationpolicy;

import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.dbv2.migration.MigrationInterruptedException;
import com.instabug.library.util.InstabugSDKLogger;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Exception f45625a;

    /* renamed from: b  reason: collision with root package name */
    private com.instabug.bug.cache.a f45626b = com.instabug.bug.di.a.c();

    public a(Exception exc) {
        this.f45625a = exc;
    }

    public void a() {
        this.f45626b.a();
        InstabugSDKLogger.e("IBG-BR", "Failed to migrate bugs to encrypted DB, dropping them.", this.f45625a);
        IBGDiagnostics.reportNonFatal(new MigrationInterruptedException(this.f45625a.getMessage()), "Failed to migrate bugs to encrypted DB, dropping them.");
    }
}
