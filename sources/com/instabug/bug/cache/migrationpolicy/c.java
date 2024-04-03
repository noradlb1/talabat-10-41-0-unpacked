package com.instabug.bug.cache.migrationpolicy;

import androidx.annotation.NonNull;
import com.instabug.bug.settings.b;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.dbv2.migration.MigrationInterruptedException;
import com.instabug.library.util.InstabugSDKLogger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Exception f45627a;

    public c(Exception exc) {
        this.f45627a = exc;
    }

    public void a() {
        b.f().b(false);
        InstabugSDKLogger.e("IBG-BR", "Failed to migrate bugs encryption state", this.f45627a);
        IBGDiagnostics.reportNonFatal(new MigrationInterruptedException(this.f45627a.getMessage()), "Failed to migrate bugs encryption state");
    }

    @NonNull
    public String toString() {
        return "SelfMigrationInterruptionsPolicy{withException=" + this.f45627a.getMessage() + AbstractJsonLexerKt.END_OBJ;
    }
}
