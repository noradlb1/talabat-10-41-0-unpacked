package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class b implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f33635a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LogEventDropped.Reason f33636b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f33637c;

    public /* synthetic */ b(String str, LogEventDropped.Reason reason, long j11) {
        this.f33635a = str;
        this.f33636b = reason;
        this.f33637c = j11;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordLogEventDropped$18(this.f33635a, this.f33636b, this.f33637c, (SQLiteDatabase) obj);
    }
}
