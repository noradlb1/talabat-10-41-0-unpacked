package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class q implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f33655a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f33656b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f33657c;

    public /* synthetic */ q(SQLiteEventStore sQLiteEventStore, String str, String str2) {
        this.f33655a = sQLiteEventStore;
        this.f33656b = str;
        this.f33657c = str2;
    }

    public final Object apply(Object obj) {
        return this.f33655a.lambda$recordFailure$4(this.f33656b, this.f33657c, (SQLiteDatabase) obj);
    }
}
