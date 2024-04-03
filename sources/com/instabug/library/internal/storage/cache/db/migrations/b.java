package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class b implements c {
    public void a(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
        b(sQLiteDatabase);
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnrEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnrEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserEntity.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserEntity.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.SurveyEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.SurveyEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.SessionEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.SessionEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserEventEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserEventEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AttachmentEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AttachmentEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserInteractions.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserInteractions.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnnouncementEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnnouncementEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserAttributesEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserAttributesEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.FeatureRequestEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.FeatureRequestEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnnouncementAssetsEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnnouncementAssetsEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NetworkLogEntry.SQL_CREATE_NETWORK_LOGS);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NetworkLogEntry.SQL_CREATE_NETWORK_LOGS);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.InstabugLogEntry.SQL_CREATE_INSTABUG_LOGS);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.InstabugLogEntry.SQL_CREATE_INSTABUG_LOGS);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.ExecutionTracesEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.ExecutionTracesEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.ExecutionTracesAttributesEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.ExecutionTracesAttributesEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AppLaunchEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AppLaunchEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AppLaunchAttributesEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AppLaunchAttributesEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMNetworkLogEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMNetworkLogEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NetworkTracesAttributesEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NetworkTracesAttributesEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.DanglingNetworkTracesAttributesEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.DanglingNetworkTracesAttributesEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMUiTraceEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMUiTraceEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMUiLoadingMetricEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMUiLoadingMetricEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMUiLoadingStageEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMUiLoadingStageEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMSessionEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMSessionEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMSessionMetaDataEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMSessionMetaDataEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.DanglingAPMNetworkLogEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.DanglingAPMNetworkLogEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.DanglingExecutionTracesEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.DanglingExecutionTracesEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.DanglingExecutionTracesAttributesEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.DanglingExecutionTracesAttributesEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.ExperimentsEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.ExperimentsEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NDKCrashEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NDKCrashEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMExperimentEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMExperimentEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMFragmentEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMFragmentEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMFragmentEventsEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMFragmentEventsEntry.CREATE_TABLE_QUERY);
        }
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.InstabugLogEntry.DROP_QUERY_INSTABUG_LOG);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.InstabugLogEntry.DROP_QUERY_INSTABUG_LOG);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NetworkLogEntry.SQL_DELETE_ENTRIES);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NetworkLogEntry.SQL_DELETE_ENTRIES);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnnouncementAssetsEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnnouncementAssetsEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.FeatureRequestEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.FeatureRequestEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserAttributesEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserAttributesEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnnouncementEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnnouncementEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserInteractions.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserInteractions.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AttachmentEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AttachmentEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserEventEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserEventEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.SessionEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.SessionEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.SurveyEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.SurveyEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.UserEntity.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.UserEntity.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnrEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnrEntry.DROP_TABLE);
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
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMNetworkLogEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMNetworkLogEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NetworkTracesAttributesEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NetworkTracesAttributesEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.DanglingNetworkTracesAttributesEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.DanglingNetworkTracesAttributesEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMSessionEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMSessionEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMSessionMetaDataEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMSessionMetaDataEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMUiLoadingMetricEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMUiLoadingMetricEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMUiLoadingStageEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMUiLoadingStageEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMUiTraceEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMUiTraceEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.DanglingAPMNetworkLogEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.DanglingAPMNetworkLogEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.DanglingExecutionTracesEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.DanglingExecutionTracesEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.DanglingExecutionTracesAttributesEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.DanglingExecutionTracesAttributesEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.ExperimentsEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.ExperimentsEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NDKCrashEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NDKCrashEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMExperimentEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMExperimentEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMFragmentEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMFragmentEntry.DROP_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMFragmentEventsEntry.DROP_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMFragmentEventsEntry.DROP_TABLE_QUERY);
        }
    }
}
