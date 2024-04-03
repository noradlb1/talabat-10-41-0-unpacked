package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class f implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f33642a;

    public /* synthetic */ f(SQLiteEventStore sQLiteEventStore) {
        this.f33642a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f33642a.lambda$recordFailure$3((Cursor) obj);
    }
}
