package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class l implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f33652a;

    public /* synthetic */ l(Map map) {
        this.f33652a = map;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadMetadata$16(this.f33652a, (Cursor) obj);
    }
}
