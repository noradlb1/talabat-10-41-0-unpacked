package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class w implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f33664a;

    public /* synthetic */ w(long j11) {
        this.f33664a = j11;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$getTimeWindow$22(this.f33664a, (SQLiteDatabase) obj);
    }
}
