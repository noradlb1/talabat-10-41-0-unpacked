package com.instabug.library.internal.storage.cache.db;

import android.provider.BaseColumns;

public class InstabugDbContract {
    public static final String BLOB_TYPE = " BLOB";
    public static final String BOOLEAN_TYPE = " BOOLEAN";
    public static final String COMMA_SEP = ",";
    private static final String CONSTRAINT = " CONSTRAINT ";
    public static final String DEFAULT = " DEFAULT ";
    private static final String FOREIGN_KEY = " FOREIGN KEY ";
    public static final String INTEGER_TYPE = " INTEGER";
    public static final String TEXT_TYPE = " TEXT";
    public static final String UNIQUE = " UNIQUE ";

    public static class APMExperimentEntry {
        public static final String COLUMN_EXPERIMENT_ARRAY = "experiment_array";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SESSION_ID = "session_id";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS apm_experiment ( id INTEGER PRIMARY KEY AUTOINCREMENT,experiment_array BLOB,session_id INTEGER UNIQUE , CONSTRAINT session_id_foreign_key FOREIGN KEY (session_id) REFERENCES apm_session_table(session_id) ON DELETE CASCADE )";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS apm_experiment";
        public static final String SESSION_ID_FOREIGN_KEY_CONSTRAINT_NAME = "session_id_foreign_key";
        public static final String TABLE_NAME = "apm_experiment";
    }

    public static class APMFragmentEntry {
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "fragment_name";
        public static final String COLUMN_SESSION_ID = "session_id";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS apm_fragment_spans ( id INTEGER PRIMARY KEY AUTOINCREMENT,fragment_name TEXT,session_id INTEGER, CONSTRAINT session_id FOREIGN KEY (session_id) REFERENCES apm_session_table(session_id) ON DELETE CASCADE )";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS apm_fragment_spans";
        public static final String TABLE_NAME = "apm_fragment_spans";
    }

    public static class APMFragmentEventsEntry {
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_FRAGMENT_ID = "fragment_id";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "event_name";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS apm_fragment_spans_events ( id INTEGER PRIMARY KEY AUTOINCREMENT,event_name TEXT,start_time INTEGER,duration INTEGER,fragment_id INTEGER, CONSTRAINT fragment_id FOREIGN KEY (fragment_id) REFERENCES apm_fragment_spans(id) ON DELETE CASCADE )";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS apm_fragment_spans_events";
        public static final String TABLE_NAME = "apm_fragment_spans_events";
    }

    public static class APMNetworkLogEntry {
        public static final String COLUMN_CARRIER = "carrier";
        public static final String COLUMN_CLIENT_SIDE_ERROR_CODE = "client_side_error_code";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_ERROR_MESSAGE = "error_message";
        public static final String COLUMN_EXECUTED_ON_BACKGROUND = "executed_on_background";
        public static final String COLUMN_GRAPH_QL_QUERY_NAME = "graph_ql_query_name";
        public static final String COLUMN_GRPC_METHOD_NAME = "grpc_method_name";
        public static final String COLUMN_ID = "log_id";
        public static final String COLUMN_METHOD = "method";
        public static final String COLUMN_RADIO = "radio";
        public static final String COLUMN_REQUEST_BODY_SIZE = "request_body_size";
        public static final String COLUMN_REQUEST_CONTENT_TYPE = "request_content_type";
        public static final String COLUMN_REQUEST_HEADERS = "request_headers";
        public static final String COLUMN_RESPONSE_BODY_SIZE = "response_body_size";
        public static final String COLUMN_RESPONSE_CODE = "response_code";
        public static final String COLUMN_RESPONSE_CONTENT_TYPE = "response_content_type";
        public static final String COLUMN_RESPONSE_HEADERS = "response_headers";
        public static final String COLUMN_SERVER_ERROR_MESSAGE = "server_side_error_message";
        public static final String COLUMN_SESSION_ID = "session_id";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String COLUMN_URL = "url";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS apm_network_log ( log_id INTEGER PRIMARY KEY AUTOINCREMENT,session_id INTEGER,start_time INTEGER,executed_on_background INTEGER,url TEXT,method TEXT,request_headers TEXT,response_headers TEXT,request_content_type TEXT,response_content_type TEXT,duration INTEGER,response_code INTEGER,request_body_size INTEGER,response_body_size INTEGER,radio TEXT,error_message TEXT,carrier TEXT,graph_ql_query_name TEXT,server_side_error_message TEXT,client_side_error_code INTEGER,grpc_method_name TEXT, CONSTRAINT session_id, FOREIGN KEY (session_id) REFERENCES apm_session_table(session_id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM apm_network_log";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS apm_network_log";
        public static final String TABLE_NAME = "apm_network_log";
    }

    public static class APMSessionEntry implements BaseColumns {
        public static final String COLUMN_APP_VERSION = "app_version";
        public static final String COLUMN_CORE_ID = "core_session_id";
        public static final String COLUMN_CORE_VERSION = "core_session_version";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_ID = "session_id";
        public static final String COLUMN_OS = "os";
        public static final String COLUMN_STARTED_AT = "started_at";
        public static final String COLUMN_SYNC_STATUS = "sync_status";
        public static final String COLUMN_TERMINATION_CODE = "termination_code";
        public static final String COLUMN_UUID = "uuid";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS apm_session_table ( session_id INTEGER PRIMARY KEY AUTOINCREMENT,core_session_id TEXT,core_session_version TEXT,os TEXT,uuid TEXT,app_version TEXT,started_at INTEGER,duration INTEGER,termination_code INTEGER,sync_status INTEGER default -1 )";
        public static final String DELETE_ALL = "DELETE FROM apm_session_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS apm_session_table";
        public static final String TABLE_NAME = "apm_session_table";
    }

    public static class APMSessionMetaDataEntry {
        public static final String COLUMN_APP_LAUNCH_DROPPED_COUNT = "app_launch_dropped_count";
        public static final String COLUMN_APP_LAUNCH_TOTAL_COUNT = "app_launch_total_count";
        public static final String COLUMN_EXECUTION_TRACES_DROPPED_COUNT = "traces_dropped_count";
        public static final String COLUMN_EXECUTION_TRACES_TOTAL_COUNT = "traces_total_count";
        public static final String COLUMN_EXPERIMENTS_COUNT = "experiments_total_count";
        public static final String COLUMN_FRAGMENT_SPANS_COUNT = "fragment_spans_total_count";
        public static final String COLUMN_FRAGMENT_SPANS_DROPPED_COUNT = "fragment_spans_dropped_count";
        public static final String COLUMN_NETWORK_LOGS_DROPPED_COUNT = "network_logs_dropped_count";
        public static final String COLUMN_NETWORK_LOGS_TOTAL_COUNT = "network_logs_total_count";
        public static final String COLUMN_SESSION_ID = "session_id";
        public static final String COLUMN_UI_TRACES_DROPPED_COUNT = "ui_traces_dropped_count";
        public static final String COLUMN_UI_TRACES_TOTAL_COUNT = "ui_traces_total_count";
        public static final int COUNT_DEFAULT_VALUE = 0;
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS apm_session_meta_data ( session_id INTEGER NOT NULL UNIQUE,traces_total_count INTEGER default 0,app_launch_total_count INTEGER default 0,network_logs_total_count INTEGER default 0,ui_traces_total_count INTEGER default 0,traces_dropped_count INTEGER default 0,app_launch_dropped_count INTEGER default 0,network_logs_dropped_count INTEGER default 0,ui_traces_dropped_count INTEGER default 0,experiments_total_count INTEGER default 0,fragment_spans_total_count INTEGER default 0,fragment_spans_dropped_count INTEGER default 0, CONSTRAINT session_id, FOREIGN KEY (session_id) REFERENCES apm_session_table(session_id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM apm_session_meta_data";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS apm_session_meta_data";
        public static final String TABLE_NAME = "apm_session_meta_data";
    }

    public static class APMUiLoadingMetricEntry {
        public static final String COLUMN_DURATION = "duration_micro";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_START_TIME = "start_timestamp";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_UI_TRACE_ID = "ui_trace_id";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS apm_ui_loading ( id INTEGER PRIMARY KEY AUTOINCREMENT,ui_trace_id INTEGER UNIQUE ,duration_micro INTEGER,start_timestamp INTEGER,type TEXT, FOREIGN KEY (ui_trace_id) REFERENCES apm_ui_traces(id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM apm_ui_loading";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS apm_ui_loading";
        public static final String TABLE_NAME = "apm_ui_loading";
    }

    public static class APMUiLoadingStageEntry {
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_STAGE_DURATION = "duration";
        public static final String COLUMN_STAGE_NAME = "stage";
        public static final String COLUMN_UI_LOADING_METRIC_ID = "ui_loading_metric_id";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS apm_ui_loading_stages ( id INTEGER PRIMARY KEY AUTOINCREMENT,ui_loading_metric_id INTEGER,stage TEXT,duration INTEGER, FOREIGN KEY (ui_loading_metric_id) REFERENCES apm_ui_loading(id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM apm_ui_loading_stages";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS apm_ui_loading_stages";
        public static final String TABLE_NAME = "apm_ui_loading_stages";
    }

    public static class APMUiTraceEntry {
        public static final String COLUMN_BATTERY_LEVEL = "batter_level";
        public static final String COLUMN_CONTAINER_NAME = "container_name";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LARGE_DROPS_DURATION = "large_drop_duration";
        public static final String COLUMN_MODULE_NAME = "module_name";
        public static final String COLUMN_NAME = "trace_name";
        public static final String COLUMN_ORIENTATION = "orientation";
        public static final String COLUMN_POWER_SAVE_MODE = "power_save_more_enabled";
        public static final String COLUMN_REFRESH_RATE = "display_refresh_rate";
        public static final String COLUMN_SCREEN_TITLE = "screen_title";
        public static final String COLUMN_SESSION_ID = "session_id";
        public static final String COLUMN_SMALL_DROPS_DURATION = "small_drops_duration";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String COLUMN_USER_DEFINED = "user_defined";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS apm_ui_traces (id INTEGER PRIMARY KEY AUTOINCREMENT,session_id INTEGER,trace_name TEXT,screen_title TEXT,duration INTEGER,small_drops_duration INTEGER,large_drop_duration INTEGER,batter_level INTEGER,power_save_more_enabled BOOLEAN,display_refresh_rate INTEGER,container_name TEXT,module_name TEXT,orientation TEXT,user_defined BOOLEAN,start_time INTEGER, CONSTRAINT session_id, FOREIGN KEY (session_id) REFERENCES apm_session_table(session_id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM apm_ui_traces";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS apm_ui_traces";
        public static final String TABLE_NAME = "apm_ui_traces";
    }

    public static class AnnouncementAssetsEntry implements BaseColumns {
        public static final String COLUMN_ANNOUNCE_ID = "announcement_item_id";
        public static final String COLUMN_FILE_PATH = "asset_path";
        public static final String COLUMN_ID = "asset_id";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS announcement_assets_table ( asset_id INTEGER PRIMARY KEY,announcement_item_id INTEGER,asset_path TEXT)";
        public static final String DELETE_ALL = "DELETE FROM announcement_assets_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS announcement_assets_table";
        public static final String TABLE_NAME = "announcement_assets_table";
    }

    public static class AnnouncementEntry implements BaseColumns {
        public static final String COLUMN_ANNOUNCEMENT = "announcement";
        public static final String COLUMN_ANNOUNCE_CURRENT_LOCALE = "currentLocale";
        public static final String COLUMN_ANNOUNCE_EVENTS = "surveyEvents";
        public static final String COLUMN_ANNOUNCE_IS_LOCALIZED = "isLocalized";
        public static final String COLUMN_ANNOUNCE_LOCALES = "supportedLocales";
        public static final String COLUMN_ANNOUNCE_STATE = "surveyState";
        public static final String COLUMN_ANSWERED = "answered";
        public static final String COLUMN_ASSETS_STATUS = "announceAssetsStatus";
        public static final String COLUMN_CONDITIONS_OPERATOR = "conditions_operator";
        public static final String COLUMN_DISMISSED_AT = "dismissed_at";
        public static final String COLUMN_EVENT_INDEX = "eventIndex";
        public static final String COLUMN_ID = "announcement_id";
        public static final String COLUMN_IS_CANCELLED = "isCancelled";
        public static final String COLUMN_IS_SHOWN = "isAlreadyShown";
        public static final String COLUMN_PAUSED = "paused";
        public static final String COLUMN_SESSIONS_COUNT = "sessionCounter";
        public static final String COLUMN_SHOULD_SHOW_AGAIN = "shouldShowAgain";
        public static final String COLUMN_SHOWN_AT = "shown_at";
        public static final String COLUMN_TARGET = "targetAudiences";
        public static final String COLUMN_TITLE = "announcement_title";
        public static final String COLUMN_TYPE = "announcement_type";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS announcement_table ( announcement_id INTEGER PRIMARY KEY,announcement_title TEXT,announcement_type INTEGER,conditions_operator TEXT,answered INTEGER,dismissed_at INTEGER,shown_at INTEGER,isCancelled INTEGER,eventIndex INTEGER,shouldShowAgain INTEGER,paused INTEGER,sessionCounter INTEGER,announcement TEXT,isAlreadyShown INTEGER,targetAudiences TEXT,surveyEvents TEXT,announceAssetsStatus INTEGER,surveyState TEXT,isLocalized BOOLEAN,supportedLocales TEXT,currentLocale TEXT)";
        public static final String DELETE_ALL = "DELETE FROM announcement_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS announcement_table";
        public static final String TABLE_NAME = "announcement_table";

        /* renamed from: a  reason: collision with root package name */
        public static final String f51030a = String.format("ALTER TABLE %s ADD COLUMN %s %s DEFAULT %s", new Object[]{TABLE_NAME, "shown_at", " INTEGER", "0"});
    }

    public static class AnrEntry implements BaseColumns {
        public static final String COLUMN_ANR_LONG_MESSAGE = "long_message";
        public static final String COLUMN_ANR_MAIN_THREAD_DATA = "anr_main_thread_data";
        public static final String COLUMN_ANR_REST_OF_THREADS_DATA = "anr_rest_of_threads_data";
        public static final String COLUMN_ANR_TEMPORARY_SERVER_TOKEN = "temporary_server_token";
        public static final String COLUMN_ANR_UPLOAD_STATE = "anr_upload_state";
        public static final String COLUMN_ID = "anr_id";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_UUID = "uuid";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS anrs_table ( anr_id TEXT, anr_main_thread_data TEXT, anr_rest_of_threads_data TEXT, anr_upload_state INTEGER, temporary_server_token TEXT, state TEXT, long_message TEXT DEFAULT \"\", uuid TEXT DEFAULT NULL)";
        public static final String DELETE_ALL = "DELETE FROM anrs_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS anrs_table";
        public static final String TABLE_NAME = "anrs_table";
    }

    public static class AppLaunchAttributesEntry {
        public static final String COLUMN_APP_LAUNCH_ID = "app_launch_id";
        public static final String COLUMN_ID = "attribute_id";
        public static final String COLUMN_KEY = "attribute_key";
        public static final String COLUMN_VALUE = "attribute_value";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS app_launch_attributes ( attribute_id INTEGER PRIMARY KEY AUTOINCREMENT,app_launch_id INTEGER,attribute_key TEXT,attribute_value TEXT,CONSTRAINT app_launch_id FOREIGN KEY (app_launch_id) REFERENCES app_launch (app_launch_id) ON DELETE CASCADE )";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS app_launch_attributes";
        public static final String TABLE_NAME = "app_launch_attributes";
    }

    public static class AppLaunchEntry {
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_ID = "app_launch_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SCREEN_NAME = "screen_name";
        public static final String COLUMN_SESSION_ID = "session_id";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS app_launch ( app_launch_id INTEGER PRIMARY KEY AUTOINCREMENT,session_id INTEGER,name TEXT,screen_name TEXT,start_time INTEGER,duration INTEGER default -1, CONSTRAINT session_id, FOREIGN KEY (session_id) REFERENCES apm_session_table(session_id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM app_launch";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS app_launch";
        public static final int DURATION_DEFAULT_VALUE = -1;
        public static final String TABLE_NAME = "app_launch";
    }

    public static class AttachmentEntry implements BaseColumns {
        public static final String COLUMN_ATTACHMENT_STATE = "attachment_state";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_ENCRYPTED = "encrypted";
        public static final String COLUMN_LOCALE_PATH = "local_path";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_REPORT_ID = "report_id";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_VIDEO_ENCODED = "video_encoded";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS attachments ( _id INTEGER PRIMARY KEY, name TEXT UNIQUE, local_path TEXT, url TEXT, type TEXT, attachment_state TEXT, video_encoded INTEGER, duration TEXT, encrypted INTEGER, report_id TEXT )";
        public static final String DELETE_ALL = "DELETE FROM attachments";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS attachments";
        public static final String TABLE_NAME = "attachments";
    }

    public static class BugEntry implements BaseColumns {
        public static final String COLUMN_BUG_STATE = "bug_state";
        public static final String COLUMN_CATEGORIES_LIST = "categories_list";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_MESSAGE = "message";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_TEMPORARY_SERVER_TOKEN = "temporary_server_token";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_VIEW_HIERARCHY = "view_hierarchy";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS bugs_table ( id TEXT,temporary_server_token TEXT,type TEXT,message TEXT,state TEXT,bug_state TEXT,view_hierarchy TEXT,categories_list TEXT )";
        public static final String DELETE_ALL = "DELETE FROM bugs_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS bugs_table";
        public static final String TABLE_NAME = "bugs_table";
    }

    public static class CrashEntry implements BaseColumns {
        public static final String COLUMN_CRASH_MESSAGE = "crash_message";
        public static final String COLUMN_CRASH_STATE = "crash_state";
        public static final String COLUMN_FINGERPRINT = "fingerprint";
        public static final String COLUMN_HANDLED = "handled";
        public static final String COLUMN_ID = "crash_id";
        public static final String COLUMN_LEVEL = "level";
        public static final String COLUMN_RETRY_COUNT = "retry_count";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_TEMPORARY_SERVER_TOKEN = "temporary_server_token";
        public static final String COLUMN_THREADS_DETAILS = "threads_details";
        public static final String COLUMN_UUID = "uuid";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS crashes_table ( crash_id TEXT, temporary_server_token TEXT, crash_message TEXT, crash_state TEXT, state TEXT, handled INTEGER, retry_count INTEGER,threads_details TEXT,fingerprint TEXT DEFAULT NULL,level INTEGER DEFAULT NULL,uuid TEXT DEFAULT NULL)";
        public static final String DELETE_ALL = "DELETE FROM crashes_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS crashes_table";
        public static final String TABLE_NAME = "crashes_table";
    }

    public static class DanglingAPMNetworkLogEntry {
        public static final String COLUMN_CARRIER = "carrier";
        public static final String COLUMN_CLIENT_SIDE_ERROR_CODE = "client_side_error_code";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_ERROR_MESSAGE = "error_message";
        public static final String COLUMN_EXECUTED_ON_BACKGROUND = "executed_on_background";
        public static final String COLUMN_GRAPH_QL_QUERY_NAME = "graph_ql_query_name";
        public static final String COLUMN_GRPC_METHOD_NAME = "grpc_method_name";
        public static final String COLUMN_ID = "log_id";
        public static final String COLUMN_METHOD = "method";
        public static final String COLUMN_RADIO = "radio";
        public static final String COLUMN_REQUEST_BODY_SIZE = "request_body_size";
        public static final String COLUMN_REQUEST_CONTENT_TYPE = "request_content_type";
        public static final String COLUMN_REQUEST_HEADERS = "request_headers";
        public static final String COLUMN_RESPONSE_BODY_SIZE = "response_body_size";
        public static final String COLUMN_RESPONSE_CODE = "response_code";
        public static final String COLUMN_RESPONSE_CONTENT_TYPE = "response_content_type";
        public static final String COLUMN_RESPONSE_HEADERS = "response_headers";
        public static final String COLUMN_SERVER_ERROR_MESSAGE = "server_side_error_message";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String COLUMN_URL = "url";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS dangling_apm_network_log ( log_id INTEGER PRIMARY KEY AUTOINCREMENT,start_time INTEGER,executed_on_background INTEGER,url TEXT,method TEXT,request_headers TEXT,response_headers TEXT,request_content_type TEXT,response_content_type TEXT,duration INTEGER,response_code INTEGER,request_body_size INTEGER,response_body_size INTEGER,radio TEXT,error_message TEXT,carrier TEXT,graph_ql_query_name TEXT,server_side_error_message TEXT,client_side_error_code INTEGER,grpc_method_name TEXT )";
        public static final String DELETE_ALL = "DELETE FROM dangling_apm_network_log";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS dangling_apm_network_log";
        public static final String TABLE_NAME = "dangling_apm_network_log";
    }

    public static class DanglingExecutionTracesAttributesEntry {
        public static final String COLUMN_EXECUTION_TRACE_ID = "trace_id";
        public static final String COLUMN_ID = "attribute_id";
        public static final String COLUMN_KEY = "attribute_key";
        public static final String COLUMN_VALUE = "attribute_value";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS dangling_execution_traces_attributes ( attribute_id INTEGER PRIMARY KEY AUTOINCREMENT,trace_id INTEGER,attribute_key TEXT,attribute_value TEXT,CONSTRAINT trace_id FOREIGN KEY (trace_id) REFERENCES dangling_execution_traces(trace_id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM dangling_execution_traces_attributes";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS dangling_execution_traces_attributes";
        public static final String TABLE_NAME = "dangling_execution_traces_attributes";
    }

    public static class DanglingExecutionTracesEntry {
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_ENDED_ON_BACKGROUND = "ended_on_background";
        public static final String COLUMN_ID = "trace_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_STARTED_ON_BACKGROUND = "started_on_background";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS dangling_execution_traces ( trace_id INTEGER PRIMARY KEY,name TEXT,start_time INTEGER,started_on_background INTEGER,ended_on_background INTEGER,duration INTEGER default -1 )";
        public static final String DELETE_ALL = "DELETE FROM dangling_execution_traces";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS dangling_execution_traces";
        public static final int DURATION_DEFAULT_VALUE = -1;
        public static final String TABLE_NAME = "dangling_execution_traces";
    }

    public static class DanglingNetworkTracesAttributesEntry {
        public static final String COLUMN_ID = "attribute_id";
        public static final String COLUMN_KEY = "attribute_key";
        public static final String COLUMN_TRACE_ID = "trace_id";
        public static final String COLUMN_VALUE = "attribute_value";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS dangling_apm_network_traces_attributes ( attribute_id INTEGER PRIMARY KEY AUTOINCREMENT,trace_id INTEGER,attribute_key TEXT,attribute_value TEXT,CONSTRAINT trace_id FOREIGN KEY (trace_id) REFERENCES dangling_apm_network_log(log_id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM dangling_apm_network_traces_attributes";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS dangling_apm_network_traces_attributes";
        public static final String TABLE_NAME = "dangling_apm_network_traces_attributes";
    }

    public static class ExecutionTracesAttributesEntry {
        public static final String COLUMN_EXECUTION_TRACE_ID = "trace_id";
        public static final String COLUMN_ID = "attribute_id";
        public static final String COLUMN_KEY = "attribute_key";
        public static final String COLUMN_VALUE = "attribute_value";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS execution_traces_attributes ( attribute_id INTEGER PRIMARY KEY AUTOINCREMENT,trace_id INTEGER,attribute_key TEXT,attribute_value TEXT,CONSTRAINT trace_id FOREIGN KEY (trace_id) REFERENCES execution_traces(trace_id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM execution_traces_attributes";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS execution_traces_attributes";
        public static final String TABLE_NAME = "execution_traces_attributes";
    }

    public static class ExecutionTracesEntry {
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_ENDED_ON_BACKGROUND = "ended_on_background";
        public static final String COLUMN_ID = "trace_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SESSION_ID = "session_id";
        public static final String COLUMN_STARTED_ON_BACKGROUND = "started_on_background";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS execution_traces ( trace_id INTEGER PRIMARY KEY,name TEXT,session_id INTEGER,start_time INTEGER,started_on_background INTEGER,ended_on_background INTEGER,duration INTEGER default -1, CONSTRAINT session_id, FOREIGN KEY (session_id) REFERENCES apm_session_table(session_id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM execution_traces";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS execution_traces";
        public static final int DURATION_DEFAULT_VALUE = -1;
        public static final String TABLE_NAME = "execution_traces";
    }

    public static class ExperimentsEntry implements BaseColumns {
        public static final String COLUMN_EXPERIMENT = "experiment";
        public static final String COLUMN_ID = "experiment_id";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS experiments_table ( experiment_id INTEGER PRIMARY KEY AUTOINCREMENT,experiment TEXT)";
        public static final String DELETE_ALL = "DELETE FROM experiments_table";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS experiments_table";
        public static final String TABLE_NAME = "experiments_table";
    }

    public static class FeatureRequestEntry implements BaseColumns {
        public static final String COLUMN_COLOR_CODE = "color_code";
        public static final String COLUMN_COMMENTS_COUNT = "comments_count";
        public static final String COLUMN_CREATOR_NAME = "creator_name";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_IS_LIKED = "liked";
        public static final String COLUMN_LIKES_COUNT = "likes_count";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_VOTE_UPDATED = "ib_user_vote_status";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS feature_requests_table ( _id INTEGER PRIMARY KEY,title TEXT,description TEXT,status TEXT,likes_count INTEGER,comments_count INTEGER,liked INTEGER,date INTEGER,color_code TEXT,creator_name TEXT,ib_user_vote_status TEXT )";
        public static final String DELETE_ALL = "DELETE FROM feature_requests_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS feature_requests_table";
        public static final String TABLE_NAME = "feature_requests_table";
    }

    public static class InstabugLogEntry implements BaseColumns {
        public static final String COLUMN_LOG_DATE = "log_date";
        public static final String COLUMN_LOG_LEVEL = "log_level";
        public static final String COLUMN_LOG_MESSAGE = "log_message";
        public static final String DELETE_ALL = "DELETE FROM instabug_logs";
        public static final String DELETE_ALL_EXCEPT_THE_LATEST_1000_ENTRY = "DELETE FROM instabug_logs WHERE log_date IN (SELECT log_date FROM instabug_logs ORDER BY log_date DESC LIMIT -1 OFFSET 1000)";
        public static final String DELETE_THE_OLDEST_INSERTED_ENTRY = "DELETE FROM instabug_logs WHERE log_date = (SELECT MAX(log_date) FROM instabug_logs);";
        public static final String DROP_QUERY_INSTABUG_LOG = "DROP TABLE IF EXISTS instabug_logs";
        public static final int INSTABUG_LOG_LIMIT = 1000;
        public static final String SELECT_LIMITED_INSTABUG_LOG = "SELECT * FROM instabug_logs ORDER  BY log_date DESC LIMIT %d";
        public static final String SQL_CREATE_INSTABUG_LOGS = "CREATE TABLE IF NOT EXISTS instabug_logs (log_message TEXT,log_level TEXT,log_date TEXT )";
        public static final String TABLE_NAME = "instabug_logs";
        public static final String TRIM_INSTABUG_LOG_SQL_QUERY = "DELETE FROM instabug_logs WHERE log_date NOT IN ( SELECT log_date FROM instabug_logs WHERE log_date ORDER BY log_date DESC LIMIT 1000 )";
    }

    public static class NDKCrashEntry implements BaseColumns {
        public static final String COLUMN_CRASH_STACK_TRACE = "crash_stack_trace";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SESSION_ID = "session_id";
        public static final String COLUMN_STATE_FILE = "state_file";
        public static final String COLUMN_SYNC_STATE = "sync_state";
        public static final String COLUMN_TEMP_SERVER_TOKEN = "temp_server_token";
        public static final String COLUMN_UUID = "uuid";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ndk_crashes_table ( session_id TEXT PRIMARY KEY,crash_stack_trace TEXT,temp_server_token TEXT,sync_state INTEGER default 0,state_file TEXT,uuid TEXT DEFAULT NULL)";
        public static final String DELETE_ALL = "DELETE FROM ndk_crashes_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS ndk_crashes_table";
        public static final String TABLE_NAME = "ndk_crashes_table";
    }

    public static class NetworkLogEntry implements BaseColumns {
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_HEADERS = "headers";
        public static final String COLUMN_METHOD = "method";
        public static final String COLUMN_NETWORK_TIME = "response_time";
        public static final String COLUMN_REQUEST = "request";
        public static final String COLUMN_RESPONSE = "response";
        public static final String COLUMN_RESPONSE_CODE = "status";
        public static final String COLUMN_RESPONSE_HEADERS = "response_headers";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_USER_MODIFIED = "user_modified";
        public static final String DELETE_ALL = "DELETE FROM network_logs";
        public static final String DELETE_ALL_EXCEPT_THE_LATEST_100_ENTRY = "DELETE FROM network_logs WHERE date IN (SELECT date FROM network_logs ORDER BY date DESC LIMIT -1 OFFSET 100)";
        public static final int NETWORK_LOG_LIMIT = 100;
        public static final String SQL_CREATE_NETWORK_LOGS = "CREATE TABLE IF NOT EXISTS network_logs (_id INTEGER PRIMARY KEY,url TEXT,request TEXT,method TEXT,response TEXT,status INTEGER,headers TEXT,response_headers TEXT,date TEXT,response_time INTEGER,user_modified BOOLEAN )";
        public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS network_logs";
        public static final String TABLE_NAME = "network_logs";
    }

    public static class NetworkTracesAttributesEntry {
        public static final String COLUMN_ID = "attribute_id";
        public static final String COLUMN_KEY = "attribute_key";
        public static final String COLUMN_TRACE_ID = "trace_id";
        public static final String COLUMN_VALUE = "attribute_value";
        public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS apm_network_traces_attributes ( attribute_id INTEGER PRIMARY KEY AUTOINCREMENT,trace_id INTEGER,attribute_key TEXT,attribute_value TEXT,CONSTRAINT trace_id FOREIGN KEY (trace_id) REFERENCES apm_network_log(log_id) ON DELETE CASCADE )";
        public static final String DELETE_ALL = "DELETE FROM apm_network_traces_attributes";
        public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS apm_network_traces_attributes";
        public static final String TABLE_NAME = "apm_network_traces_attributes";
    }

    public static class SDKApiEntry implements BaseColumns {
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS sdk_api";
        public static final String TABLE_NAME = "sdk_api";
    }

    public static class SDKEventEntry implements BaseColumns {
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS sdk_event";
        public static final String TABLE_NAME = "sdk_event";
    }

    public static class SessionEntry implements BaseColumns {
        public static final String COLUMN_APP_TOKEN = "app_token";
        public static final String COLUMN_APP_VERSION = "app_version";
        public static final String COLUMN_CRASH_REPORTING_ENABLED = "crash_reporting_enabled";
        public static final String COLUMN_DEVICE = "device";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_ID = "session_id";
        public static final String COLUMN_OS = "os";
        public static final String COLUMN_PRODUCTION_USAGE = "production_usage";
        public static final String COLUMN_SDK_VERSION = "sdk_version";
        public static final String COLUMN_STARTED_AT = "started_at";
        public static final String COLUMN_STITCHED_SESSION_LEAD = "stitched_session_lead";
        public static final String COLUMN_SYNC_STATUS = "sync_status";
        public static final String COLUMN_USERS_PAGE_ENABLED = "users_page_enabled";
        public static final String COLUMN_USER_ATTRIBUTES = "user_events";
        public static final String COLUMN_USER_ATTRIBUTES_KEYS = "user_events_keys";
        public static final String COLUMN_USER_EMAIL = "user_email";
        public static final String COLUMN_USER_EVENTS = "user_attributes";
        public static final String COLUMN_USER_EVENTS_KEYS = "user_attributes_keys";
        public static final String COLUMN_USER_NAME = "user_name";
        public static final String COLUMN_UUID = "uuid";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS session_table ( session_id TEXT,started_at INTEGER,duration INTEGER,user_events TEXT,user_attributes TEXT,user_events_keys TEXT,user_attributes_keys TEXT,user_email TEXT,uuid TEXT,user_name TEXT,os TEXT,app_token TEXT,device TEXT,sdk_version TEXT,app_version TEXT,crash_reporting_enabled INTEGER,users_page_enabled INTEGER,sync_status INTEGER,production_usage TEXT,stitched_session_lead INTEGER )";
        public static final String DELETE_ALL = "DELETE FROM session_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS session_table";
        public static final String TABLE_NAME = "session_table";
    }

    public static class SurveyEntry implements BaseColumns {
        public static final String COLUMN_ANSWERED = "answered";
        public static final String COLUMN_ATTEMPT_COUNT = "attemptCount";
        public static final String COLUMN_CONDITIONS_OPERATOR = "conditions_operator";
        public static final String COLUMN_CUSTOM_ATTRIBUTES = "customAttributes";
        public static final String COLUMN_DISMISSED_AT = "dismissed_at";
        public static final String COLUMN_EVENT_INDEX = "eventIndex";
        public static final String COLUMN_GOOGLE_PLAY_RATING = "in_app_rating";
        public static final String COLUMN_ID = "survey_id";
        public static final String COLUMN_IS_CANCELLED = "isCancelled";
        public static final String COLUMN_PAUSED = "paused";
        public static final String COLUMN_QUESTIONS = "questions";
        public static final String COLUMN_SESSIONS_COUNT = "sessionCounter";
        public static final String COLUMN_SHOULD_SHOW_AGAIN = "shouldShowAgain";
        public static final String COLUMN_SHOWN_AT = "shown_at";
        public static final String COLUMN_SURVEY_CURRENT_LOCALE = "currentLocale";
        public static final String COLUMN_SURVEY_IS_DISMISSIBLE = "isDismissible";
        public static final String COLUMN_SURVEY_IS_LOCALIZED = "isLocalized";
        public static final String COLUMN_SURVEY_LOCALES = "supportedLocales";
        public static final String COLUMN_SURVEY_STATE = "surveyState";
        public static final String COLUMN_SURVEY_TARGET = "surveyTargeting";
        public static final String COLUMN_SURVEY_TRIGGER_EVENT = "surveyTriggerEvent";
        public static final String COLUMN_TARGET_AUDIENCES = "targetAudiences";
        public static final String COLUMN_THANKS_LIST = "thanks_list";
        public static final String COLUMN_TITLE = "survey_title";
        public static final String COLUMN_TOKEN = "survey_token";
        public static final String COLUMN_TYPE = "survey_type";
        public static final String COLUMN_USER_EVENTS = "userEvents";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS surveys_table ( survey_id INTEGER PRIMARY KEY,survey_type INTEGER,in_app_rating INTEGER,survey_title TEXT,survey_token TEXT,conditions_operator TEXT,answered INTEGER,dismissed_at INTEGER,shown_at INTEGER,isCancelled INTEGER,attemptCount INTEGER,eventIndex INTEGER,shouldShowAgain INTEGER,paused INTEGER,sessionCounter INTEGER,questions TEXT,thanks_list TEXT,targetAudiences TEXT,customAttributes TEXT,userEvents TEXT,surveyState TEXT,surveyTargeting TEXT,surveyTriggerEvent TEXT,isLocalized BOOLEAN,currentLocale TEXT,supportedLocales TEXT,isDismissible BOOLEAN)";
        public static final String DELETE_ALL = "DELETE FROM surveys_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS surveys_table";
        public static final String TABLE_NAME = "surveys_table";
    }

    public static class UserAttributesEntry implements BaseColumns {
        public static final String ALTER_TABLE_UPGRADE_14 = String.format("ALTER TABLE %s ADD COLUMN %s %s DEFAULT %s", new Object[]{TABLE_NAME, "type", " INTEGER", "0"});
        public static final String COLUMN_IS_ANONYMOUS = "is_anonymous";
        public static final String COLUMN_KEY = "key";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_VALUE = "value";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS user_attributes_table ( uuid TEXT,key TEXT,value TEXT,type INTEGER,is_anonymous BOOLEAN,CONSTRAINT uuid     FOREIGN KEY (uuid)     REFERENCES user (uuid)     ON DELETE CASCADE, PRIMARY KEY (uuid,key ))";
        public static final String DELETE_ALL = "DELETE FROM user_attributes_table";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS user_attributes_table";
        public static final String TABLE_NAME = "user_attributes_table";
    }

    public static class UserEntity implements BaseColumns {
        public static final String ALTER_TABLE_UPGRADE_12 = String.format("ALTER TABLE %s ADD COLUMN %s %s DEFAULT %s", new Object[]{"user", COLUMN_LAST_SEEN, " INTEGER", "0"});
        public static final String COLUMN_LAST_SEEN = "last_seen";
        public static final String COLUMN_SESSION_COUNT = "session_count";
        public static final String COLUMN_UUID = "uuid";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS user ( uuid TEXT PRIMARY KEY,last_seen INTEGER,session_count INTEGER )";
        public static final String DELETE_ALL = "DELETE FROM user";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS user";
        public static final String TABLE_NAME = "user";
    }

    public static class UserEventEntry implements BaseColumns {
        public static final String COLUMN_EVENT_IDENTIFIER = "event_identifier";
        public static final String COLUMN_EVENT_LOGGING_COUNT = "event_logging_count";
        public static final String COLUMN_IS_ANONYMOUS = "is_anonymous";
        public static final String COLUMN_UUID = "uuid";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS user_events_logs ( uuid TEXT,is_anonymous BOOLEAN,event_identifier TEXT,event_logging_count INTEGER, CONSTRAINT uuid     FOREIGN KEY (uuid)     REFERENCES user (uuid)     ON DELETE CASCADE, PRIMARY KEY (uuid,event_identifier))";
        public static final String DELETE_ALL = "DELETE FROM user_events_logs";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS user_events_logs";
        public static final String TABLE_NAME = "user_events_logs";
    }

    public static class UserInteractions implements BaseColumns {
        public static final String COLUMN_ALREADY_SHOWN = "is_already_shown";
        public static final String COLUMN_ANSWERED = "answered";
        public static final String COLUMN_ATTEMPT_COUNT = "attemptCount";
        public static final String COLUMN_DISMISSED_AT = "dismissed_at";
        public static final String COLUMN_EVENT_INDEX = "eventIndex";
        public static final String COLUMN_IS_CANCELLED = "isCancelled";
        public static final String COLUMN_SESSIONS_COUNT = "sessionCounter";
        public static final String COLUMN_SHOULD_SHOW_AGAIN = "shouldShowAgain";
        public static final String COLUMN_SHOWN_AT = "shown_at";
        public static final String COLUMN_SURVEY_ID = "survey_id";
        public static final String COLUMN_SURVEY_TARGET = "surveyTargeting";
        public static final String COLUMN_USER_INTERACTION_ON_TYPE = "action_on_type";
        public static final String COLUMN_UUID_TYPE = "uuid";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS user_interaction ( survey_id INTEGER,uuid TEXT,surveyTargeting TEXT,action_on_type INTEGER,answered INTEGER,dismissed_at INTEGER,shown_at INTEGER,isCancelled INTEGER,attemptCount INTEGER,eventIndex INTEGER,shouldShowAgain INTEGER,sessionCounter INTEGER,is_already_shown INTEGER,CONSTRAINT uuid     FOREIGN KEY (uuid)     REFERENCES user (uuid)     ON DELETE CASCADE,  PRIMARY KEY (survey_id,uuid,action_on_type))";
        public static final String DELETE_ALL = "DELETE FROM user_interaction";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS user_interaction";
        public static final String TABLE_NAME = "user_interaction";
    }

    private InstabugDbContract() {
    }
}
