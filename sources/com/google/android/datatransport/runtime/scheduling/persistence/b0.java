package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class b0 implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f33638a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EventInternal f33639b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f33640c;

    public /* synthetic */ b0(SQLiteEventStore sQLiteEventStore, EventInternal eventInternal, TransportContext transportContext) {
        this.f33638a = sQLiteEventStore;
        this.f33639b = eventInternal;
        this.f33640c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f33638a.lambda$persist$1(this.f33639b, this.f33640c, (SQLiteDatabase) obj);
    }
}
