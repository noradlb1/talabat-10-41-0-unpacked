package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class g implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f33643a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f33644b;

    public /* synthetic */ g(long j11, TransportContext transportContext) {
        this.f33643a = j11;
        this.f33644b = transportContext;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordNextCallTime$7(this.f33643a, this.f33644b, (SQLiteDatabase) obj);
    }
}
