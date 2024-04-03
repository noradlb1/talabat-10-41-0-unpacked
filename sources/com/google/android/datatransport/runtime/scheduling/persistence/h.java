package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class h implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f33645a;

    public /* synthetic */ h(SQLiteEventStore sQLiteEventStore) {
        this.f33645a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f33645a.lambda$resetClientMetrics$23((SQLiteDatabase) obj);
    }
}
