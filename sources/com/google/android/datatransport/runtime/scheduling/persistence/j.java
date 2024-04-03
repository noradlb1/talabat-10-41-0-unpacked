package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class j implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f33649a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f33650b;

    public /* synthetic */ j(SQLiteEventStore sQLiteEventStore, long j11) {
        this.f33649a = sQLiteEventStore;
        this.f33650b = j11;
    }

    public final Object apply(Object obj) {
        return this.f33649a.lambda$cleanUp$12(this.f33650b, (SQLiteDatabase) obj);
    }
}
