package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;

public final /* synthetic */ class i implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f33646a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f33647b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f33648c;

    public /* synthetic */ i(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.f33646a = sQLiteEventStore;
        this.f33647b = list;
        this.f33648c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f33646a.lambda$loadEvents$14(this.f33647b, this.f33648c, (Cursor) obj);
    }
}
