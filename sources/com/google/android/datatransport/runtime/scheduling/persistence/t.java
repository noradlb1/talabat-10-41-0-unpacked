package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class t implements SQLiteEventStore.Function {
    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$getTransportContextId$2((Cursor) obj);
    }
}
