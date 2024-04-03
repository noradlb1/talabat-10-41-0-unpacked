package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class v implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f33660a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f33661b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f33662c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f33663d;

    public /* synthetic */ v(SQLiteEventStore sQLiteEventStore, String str, Map map, ClientMetrics.Builder builder) {
        this.f33660a = sQLiteEventStore;
        this.f33661b = str;
        this.f33662c = map;
        this.f33663d = builder;
    }

    public final Object apply(Object obj) {
        return this.f33660a.lambda$loadClientMetrics$20(this.f33661b, this.f33662c, this.f33663d, (SQLiteDatabase) obj);
    }
}
