package com.instabug.library.internal.storage.cache.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.migrations.b;
import com.instabug.library.logging.InstabugLog;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static a f51031a;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private a(@Nullable Context context) {
        super(context, "instabug.db", (SQLiteDatabase.CursorFactory) null, 40);
    }

    public static synchronized SQLiteOpenHelper a(@Nullable Context context) {
        a aVar;
        synchronized (a.class) {
            if (f51031a == null) {
                f51031a = new a(context);
            }
            aVar = f51031a;
        }
        return aVar;
    }

    @Deprecated
    private void b(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        a(sQLiteDatabase, i11, i12);
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.InstabugLogEntry.DROP_QUERY_INSTABUG_LOG);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.InstabugLogEntry.DROP_QUERY_INSTABUG_LOG);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserEventEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserEventEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.SDKEventEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.SDKEventEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.SDKApiEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.SDKApiEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AttachmentEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AttachmentEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.FeatureRequestEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.FeatureRequestEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.ExecutionTracesEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.ExecutionTracesEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.ExecutionTracesAttributesEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.ExecutionTracesAttributesEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AppLaunchEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AppLaunchEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AppLaunchAttributesEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AppLaunchAttributesEntry.DROP_TABLE_QUERY);
        }
        onCreate(sQLiteDatabase);
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        new b().b(sQLiteDatabase);
    }

    @SuppressLint({"STRICT_MODE_VIOLATION"})
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        b(sQLiteDatabase, i11, i12);
        b.b(sQLiteDatabase, i11, i12);
        onCreate(sQLiteDatabase);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    @SuppressLint({"STRICT_MODE_VIOLATION"})
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        b(sQLiteDatabase, i11, i12);
        b.c(sQLiteDatabase, i11, i12);
        onCreate(sQLiteDatabase);
    }

    @Deprecated
    private void a(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i12 > i11) {
            if (i12 > 16 && i11 <= 16) {
                try {
                    String str = InstabugDbContract.AnnouncementEntry.f51030a;
                    if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                        sQLiteDatabase.execSQL(str);
                    } else {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, str);
                    }
                } catch (SQLException e11) {
                    a(sQLiteDatabase);
                    InstabugLog.e("Migration of schema v. 16 failed with the error: " + e11.getMessage());
                }
            }
            if (i12 < 15) {
                return;
            }
            if (i11 < 12) {
                b(sQLiteDatabase);
                a(sQLiteDatabase);
            } else if (i11 == 12) {
                try {
                    String str2 = InstabugDbContract.UserEntity.ALTER_TABLE_UPGRADE_12;
                    if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                        sQLiteDatabase.execSQL(str2);
                    } else {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, str2);
                    }
                    String str3 = InstabugDbContract.UserAttributesEntry.ALTER_TABLE_UPGRADE_14;
                    if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                        sQLiteDatabase.execSQL(str3);
                    } else {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, str3);
                    }
                } catch (SQLException e12) {
                    b(sQLiteDatabase);
                    a(sQLiteDatabase);
                    InstabugLog.e("Migration of schema v. 12 failed with the error: " + e12.getMessage());
                }
            } else if (i11 == 14) {
                try {
                    String str4 = InstabugDbContract.UserAttributesEntry.ALTER_TABLE_UPGRADE_14;
                    if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                        sQLiteDatabase.execSQL(str4);
                    } else {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, str4);
                    }
                } catch (SQLException e13) {
                    b(sQLiteDatabase);
                    a(sQLiteDatabase);
                    InstabugLog.e("Migration of schema v. 14 failed with the error: " + e13.getMessage());
                }
            }
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.SurveyEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.SurveyEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserInteractions.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserInteractions.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserAttributesEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserAttributesEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserEntity.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserEntity.DROP_TABLE);
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnnouncementEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnnouncementEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnnouncementAssetsEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnnouncementAssetsEntry.DROP_TABLE);
        }
    }
}
