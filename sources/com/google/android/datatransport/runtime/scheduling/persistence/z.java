package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class z implements SQLiteEventStore.Function {
    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordLogEventDropped$17((Cursor) obj);
    }
}
