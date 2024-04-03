package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class x implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f33665a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f33666b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f33667c;

    public /* synthetic */ x(SQLiteEventStore sQLiteEventStore, Map map, ClientMetrics.Builder builder) {
        this.f33665a = sQLiteEventStore;
        this.f33666b = map;
        this.f33667c = builder;
    }

    public final Object apply(Object obj) {
        return this.f33665a.lambda$loadClientMetrics$19(this.f33666b, this.f33667c, (Cursor) obj);
    }
}
