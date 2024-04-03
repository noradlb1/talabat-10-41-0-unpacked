package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class o implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f33653a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f33654b;

    public /* synthetic */ o(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f33653a = sQLiteEventStore;
        this.f33654b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f33653a.lambda$loadBatch$8(this.f33654b, (SQLiteDatabase) obj);
    }
}
