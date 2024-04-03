package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Instrumented
final class SchemaManager extends SQLiteOpenHelper {
    private static final String CREATE_CONTEXTS_SQL_V1 = "CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)";
    private static final String CREATE_CONTEXT_BACKEND_PRIORITY_INDEX_V1 = "CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)";
    private static final String CREATE_EVENTS_SQL_V1 = "CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)";
    private static final String CREATE_EVENT_BACKEND_INDEX_V1 = "CREATE INDEX events_backend_id on events(context_id)";
    private static final String CREATE_EVENT_METADATA_SQL_V1 = "CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)";
    private static final String CREATE_GLOBAL_LOG_EVENT_STATE_TABLE = "CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)";
    private static final String CREATE_INITIAL_GLOBAL_LOG_EVENT_STATE_VALUE_SQL = ("INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")");
    private static final String CREATE_LOG_EVENT_DROPPED_TABLE = "CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))";
    private static final String CREATE_PAYLOADS_TABLE_V4 = "CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))";
    static final String DB_NAME = "com.google.android.datatransport.events";
    private static final String DROP_CONTEXTS_SQL = "DROP TABLE transport_contexts";
    private static final String DROP_EVENTS_SQL = "DROP TABLE events";
    private static final String DROP_EVENT_METADATA_SQL = "DROP TABLE event_metadata";
    private static final String DROP_GLOBAL_LOG_EVENT_STATE_SQL = "DROP TABLE IF EXISTS global_log_event_state";
    private static final String DROP_LOG_EVENT_DROPPED_SQL = "DROP TABLE IF EXISTS log_event_dropped";
    private static final String DROP_PAYLOADS_SQL = "DROP TABLE IF EXISTS event_payloads";
    private static final List<Migration> INCREMENTAL_MIGRATIONS;
    private static final Migration MIGRATE_TO_V1;
    private static final Migration MIGRATE_TO_V2;
    private static final Migration MIGRATE_TO_V3;
    private static final Migration MIGRATE_TO_V4;
    private static final Migration MIGRATION_TO_V5;
    static int SCHEMA_VERSION = 5;
    private boolean configured = false;
    private final int schemaVersion;

    public interface Migration {
        void upgrade(SQLiteDatabase sQLiteDatabase);
    }

    static {
        c0 c0Var = new c0();
        MIGRATE_TO_V1 = c0Var;
        d0 d0Var = new d0();
        MIGRATE_TO_V2 = d0Var;
        e0 e0Var = new e0();
        MIGRATE_TO_V3 = e0Var;
        f0 f0Var = new f0();
        MIGRATE_TO_V4 = f0Var;
        g0 g0Var = new g0();
        MIGRATION_TO_V5 = g0Var;
        INCREMENTAL_MIGRATIONS = Arrays.asList(new Migration[]{c0Var, d0Var, e0Var, f0Var, g0Var});
    }

    @Inject
    public SchemaManager(Context context, @Named("SQLITE_DB_NAME") String str, @Named("SCHEMA_VERSION") int i11) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i11);
        this.schemaVersion = i11;
    }

    private void ensureConfigured(SQLiteDatabase sQLiteDatabase) {
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(CREATE_EVENTS_SQL_V1);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, CREATE_EVENTS_SQL_V1);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(CREATE_EVENT_METADATA_SQL_V1);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, CREATE_EVENT_METADATA_SQL_V1);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(CREATE_CONTEXTS_SQL_V1);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, CREATE_CONTEXTS_SQL_V1);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(CREATE_EVENT_BACKEND_INDEX_V1);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, CREATE_EVENT_BACKEND_INDEX_V1);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(CREATE_CONTEXT_BACKEND_PRIORITY_INDEX_V1);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, CREATE_CONTEXT_BACKEND_PRIORITY_INDEX_V1);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP INDEX contexts_backend_priority");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$2(SQLiteDatabase sQLiteDatabase) {
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE events ADD COLUMN payload_encoding TEXT");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$3(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        }
        if (!z11) {
            sQLiteDatabase.execSQL(DROP_PAYLOADS_SQL);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, DROP_PAYLOADS_SQL);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(CREATE_PAYLOADS_TABLE_V4);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, CREATE_PAYLOADS_TABLE_V4);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$4(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(DROP_LOG_EVENT_DROPPED_SQL);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, DROP_LOG_EVENT_DROPPED_SQL);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(DROP_GLOBAL_LOG_EVENT_STATE_SQL);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, DROP_GLOBAL_LOG_EVENT_STATE_SQL);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(CREATE_LOG_EVENT_DROPPED_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, CREATE_LOG_EVENT_DROPPED_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(CREATE_GLOBAL_LOG_EVENT_STATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, CREATE_GLOBAL_LOG_EVENT_STATE_TABLE);
        }
        String str = CREATE_INITIAL_GLOBAL_LOG_EVENT_STATE_VALUE_SQL;
        if (!z11) {
            sQLiteDatabase.execSQL(str);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str);
        }
    }

    private void upgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        List<Migration> list = INCREMENTAL_MIGRATIONS;
        if (i12 <= list.size()) {
            while (i11 < i12) {
                INCREMENTAL_MIGRATIONS.get(i11).upgrade(sQLiteDatabase);
                i11++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i11 + " to " + i12 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        this.configured = true;
        String[] strArr = new String[0];
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "PRAGMA busy_timeout=0;", strArr);
        }
        cursor.close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreate(sQLiteDatabase, this.schemaVersion);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(DROP_EVENTS_SQL);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, DROP_EVENTS_SQL);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(DROP_EVENT_METADATA_SQL);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, DROP_EVENT_METADATA_SQL);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(DROP_CONTEXTS_SQL);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, DROP_CONTEXTS_SQL);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(DROP_PAYLOADS_SQL);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, DROP_PAYLOADS_SQL);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(DROP_LOG_EVENT_DROPPED_SQL);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, DROP_LOG_EVENT_DROPPED_SQL);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(DROP_GLOBAL_LOG_EVENT_STATE_SQL);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, DROP_GLOBAL_LOG_EVENT_STATE_SQL);
        }
        onCreate(sQLiteDatabase, i12);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        ensureConfigured(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        ensureConfigured(sQLiteDatabase);
        upgrade(sQLiteDatabase, i11, i12);
    }

    private void onCreate(SQLiteDatabase sQLiteDatabase, int i11) {
        ensureConfigured(sQLiteDatabase);
        upgrade(sQLiteDatabase, 0, i11);
    }
}
