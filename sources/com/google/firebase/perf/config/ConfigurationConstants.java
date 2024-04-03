package com.google.firebase.perf.config;

import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.util.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class ConfigurationConstants {

    public static final class CollectionDeactivated extends ConfigurationFlag<Boolean> {
        private static CollectionDeactivated instance;

        private CollectionDeactivated() {
        }

        public static synchronized CollectionDeactivated getInstance() {
            CollectionDeactivated collectionDeactivated;
            synchronized (CollectionDeactivated.class) {
                if (instance == null) {
                    instance = new CollectionDeactivated();
                }
                collectionDeactivated = instance;
            }
            return collectionDeactivated;
        }

        public String getMetadataFlag() {
            return "firebase_performance_collection_deactivated";
        }

        public Boolean getDefault() {
            return Boolean.FALSE;
        }
    }

    public static final class CollectionEnabled extends ConfigurationFlag<Boolean> {
        private static CollectionEnabled instance;

        private CollectionEnabled() {
        }

        public static synchronized CollectionEnabled getInstance() {
            CollectionEnabled collectionEnabled;
            synchronized (CollectionEnabled.class) {
                if (instance == null) {
                    instance = new CollectionEnabled();
                }
                collectionEnabled = instance;
            }
            return collectionEnabled;
        }

        public String getDeviceCacheFlag() {
            return Constants.ENABLE_DISABLE;
        }

        public String getMetadataFlag() {
            return "firebase_performance_collection_enabled";
        }

        public Boolean getDefault() {
            return Boolean.TRUE;
        }
    }

    public static final class ExperimentTTID extends ConfigurationFlag<Boolean> {
        private static ExperimentTTID instance;

        private ExperimentTTID() {
        }

        public static synchronized ExperimentTTID getInstance() {
            ExperimentTTID experimentTTID;
            synchronized (ExperimentTTID.class) {
                if (instance == null) {
                    instance = new ExperimentTTID();
                }
                experimentTTID = instance;
            }
            return experimentTTID;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.ExperimentTTID";
        }

        public String getMetadataFlag() {
            return "experiment_app_start_ttid";
        }

        public String getRemoteConfigFlag() {
            return "fpr_experiment_app_start_ttid";
        }

        public Boolean getDefault() {
            return Boolean.FALSE;
        }
    }

    public static final class FragmentSamplingRate extends ConfigurationFlag<Double> {
        private static FragmentSamplingRate instance;

        private FragmentSamplingRate() {
        }

        public static synchronized FragmentSamplingRate getInstance() {
            FragmentSamplingRate fragmentSamplingRate;
            synchronized (FragmentSamplingRate.class) {
                if (instance == null) {
                    instance = new FragmentSamplingRate();
                }
                fragmentSamplingRate = instance;
            }
            return fragmentSamplingRate;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.FragmentSamplingRate";
        }

        public String getMetadataFlag() {
            return "fragment_sampling_percentage";
        }

        public String getRemoteConfigFlag() {
            return "fpr_vc_fragment_sampling_rate";
        }

        public Double getDefault() {
            return Double.valueOf(0.0d);
        }
    }

    public static final class LogSourceName extends ConfigurationFlag<String> {
        private static final Map<Long, String> LOG_SOURCE_MAP = Collections.unmodifiableMap(new HashMap<Long, String>() {
            {
                put(461L, "FIREPERF_AUTOPUSH");
                put(462L, "FIREPERF");
                put(675L, "FIREPERF_INTERNAL_LOW");
                put(676L, "FIREPERF_INTERNAL_HIGH");
            }
        });
        private static LogSourceName instance;

        private LogSourceName() {
        }

        public static synchronized LogSourceName getInstance() {
            LogSourceName logSourceName;
            synchronized (LogSourceName.class) {
                if (instance == null) {
                    instance = new LogSourceName();
                }
                logSourceName = instance;
            }
            return logSourceName;
        }

        public static String getLogSourceName(long j11) {
            return LOG_SOURCE_MAP.get(Long.valueOf(j11));
        }

        public static boolean isLogSourceKnown(long j11) {
            return LOG_SOURCE_MAP.containsKey(Long.valueOf(j11));
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.LogSourceName";
        }

        public String getRemoteConfigFlag() {
            return "fpr_log_source";
        }

        public String getDefault() {
            return BuildConfig.TRANSPORT_LOG_SRC;
        }
    }

    public static final class NetworkEventCountBackground extends ConfigurationFlag<Long> {
        private static NetworkEventCountBackground instance;

        private NetworkEventCountBackground() {
        }

        public static synchronized NetworkEventCountBackground getInstance() {
            NetworkEventCountBackground networkEventCountBackground;
            synchronized (NetworkEventCountBackground.class) {
                if (instance == null) {
                    instance = new NetworkEventCountBackground();
                }
                networkEventCountBackground = instance;
            }
            return networkEventCountBackground;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountBackground";
        }

        public String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_bg";
        }

        public Long getDefault() {
            return 70L;
        }
    }

    public static final class NetworkEventCountForeground extends ConfigurationFlag<Long> {
        private static NetworkEventCountForeground instance;

        private NetworkEventCountForeground() {
        }

        public static synchronized NetworkEventCountForeground getInstance() {
            NetworkEventCountForeground networkEventCountForeground;
            synchronized (NetworkEventCountForeground.class) {
                if (instance == null) {
                    instance = new NetworkEventCountForeground();
                }
                networkEventCountForeground = instance;
            }
            return networkEventCountForeground;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountForeground";
        }

        public String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_fg";
        }

        public Long getDefault() {
            return 700L;
        }
    }

    public static final class NetworkRequestSamplingRate extends ConfigurationFlag<Double> {
        private static NetworkRequestSamplingRate instance;

        private NetworkRequestSamplingRate() {
        }

        public static synchronized NetworkRequestSamplingRate getInstance() {
            NetworkRequestSamplingRate networkRequestSamplingRate;
            synchronized (NetworkRequestSamplingRate.class) {
                if (instance == null) {
                    instance = new NetworkRequestSamplingRate();
                }
                networkRequestSamplingRate = instance;
            }
            return networkRequestSamplingRate;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkRequestSamplingRate";
        }

        public String getRemoteConfigFlag() {
            return "fpr_vc_network_request_sampling_rate";
        }

        public Double getDefault() {
            return Double.valueOf(1.0d);
        }

        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }
    }

    public static final class RateLimitSec extends ConfigurationFlag<Long> {
        private static RateLimitSec instance;

        private RateLimitSec() {
        }

        public static synchronized RateLimitSec getInstance() {
            RateLimitSec rateLimitSec;
            synchronized (RateLimitSec.class) {
                if (instance == null) {
                    instance = new RateLimitSec();
                }
                rateLimitSec = instance;
            }
            return rateLimitSec;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TimeLimitSec";
        }

        public String getRemoteConfigFlag() {
            return "fpr_rl_time_limit_sec";
        }

        public Long getDefault() {
            return 600L;
        }
    }

    public static final class SdkDisabledVersions extends ConfigurationFlag<String> {
        private static SdkDisabledVersions instance;

        public static synchronized SdkDisabledVersions getInstance() {
            SdkDisabledVersions sdkDisabledVersions;
            synchronized (SdkDisabledVersions.class) {
                if (instance == null) {
                    instance = new SdkDisabledVersions();
                }
                sdkDisabledVersions = instance;
            }
            return sdkDisabledVersions;
        }

        public String getDefault() {
            return "";
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkDisabledVersions";
        }

        public String getRemoteConfigFlag() {
            return "fpr_disabled_android_versions";
        }
    }

    public static final class SdkEnabled extends ConfigurationFlag<Boolean> {
        private static SdkEnabled instance;

        public static synchronized SdkEnabled getInstance() {
            SdkEnabled sdkEnabled;
            synchronized (SdkEnabled.class) {
                if (instance == null) {
                    instance = new SdkEnabled();
                }
                sdkEnabled = instance;
            }
            return sdkEnabled;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkEnabled";
        }

        public String getRemoteConfigFlag() {
            return "fpr_enabled";
        }

        public Boolean getDefault() {
            return Boolean.TRUE;
        }
    }

    public static final class SessionsCpuCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyBackgroundMs instance;

        private SessionsCpuCaptureFrequencyBackgroundMs() {
        }

        public static synchronized SessionsCpuCaptureFrequencyBackgroundMs getInstance() {
            SessionsCpuCaptureFrequencyBackgroundMs sessionsCpuCaptureFrequencyBackgroundMs;
            synchronized (SessionsCpuCaptureFrequencyBackgroundMs.class) {
                if (instance == null) {
                    instance = new SessionsCpuCaptureFrequencyBackgroundMs();
                }
                sessionsCpuCaptureFrequencyBackgroundMs = instance;
            }
            return sessionsCpuCaptureFrequencyBackgroundMs;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
        }

        public String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_bg_ms";
        }

        public String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
        }

        public Long getDefault() {
            return 0L;
        }
    }

    public static final class SessionsCpuCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyForegroundMs instance;

        private SessionsCpuCaptureFrequencyForegroundMs() {
        }

        public static synchronized SessionsCpuCaptureFrequencyForegroundMs getInstance() {
            SessionsCpuCaptureFrequencyForegroundMs sessionsCpuCaptureFrequencyForegroundMs;
            synchronized (SessionsCpuCaptureFrequencyForegroundMs.class) {
                if (instance == null) {
                    instance = new SessionsCpuCaptureFrequencyForegroundMs();
                }
                sessionsCpuCaptureFrequencyForegroundMs = instance;
            }
            return sessionsCpuCaptureFrequencyForegroundMs;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
        }

        public String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_fg_ms";
        }

        public String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
        }

        public Long getDefault() {
            return 100L;
        }

        public Long getDefaultOnRcFetchFail() {
            return Long.valueOf(getDefault().longValue() * 3);
        }
    }

    public static final class SessionsMaxDurationMinutes extends ConfigurationFlag<Long> {
        private static SessionsMaxDurationMinutes instance;

        private SessionsMaxDurationMinutes() {
        }

        public static synchronized SessionsMaxDurationMinutes getInstance() {
            SessionsMaxDurationMinutes sessionsMaxDurationMinutes;
            synchronized (SessionsMaxDurationMinutes.class) {
                if (instance == null) {
                    instance = new SessionsMaxDurationMinutes();
                }
                sessionsMaxDurationMinutes = instance;
            }
            return sessionsMaxDurationMinutes;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMaxDurationMinutes";
        }

        public String getMetadataFlag() {
            return "sessions_max_length_minutes";
        }

        public String getRemoteConfigFlag() {
            return "fpr_session_max_duration_min";
        }

        public Long getDefault() {
            return 240L;
        }
    }

    public static final class SessionsMemoryCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyBackgroundMs instance;

        private SessionsMemoryCaptureFrequencyBackgroundMs() {
        }

        public static synchronized SessionsMemoryCaptureFrequencyBackgroundMs getInstance() {
            SessionsMemoryCaptureFrequencyBackgroundMs sessionsMemoryCaptureFrequencyBackgroundMs;
            synchronized (SessionsMemoryCaptureFrequencyBackgroundMs.class) {
                if (instance == null) {
                    instance = new SessionsMemoryCaptureFrequencyBackgroundMs();
                }
                sessionsMemoryCaptureFrequencyBackgroundMs = instance;
            }
            return sessionsMemoryCaptureFrequencyBackgroundMs;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
        }

        public String getMetadataFlag() {
            return "sessions_memory_capture_frequency_bg_ms";
        }

        public String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_bg_ms";
        }

        public Long getDefault() {
            return 0L;
        }
    }

    public static final class SessionsMemoryCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyForegroundMs instance;

        private SessionsMemoryCaptureFrequencyForegroundMs() {
        }

        public static synchronized SessionsMemoryCaptureFrequencyForegroundMs getInstance() {
            SessionsMemoryCaptureFrequencyForegroundMs sessionsMemoryCaptureFrequencyForegroundMs;
            synchronized (SessionsMemoryCaptureFrequencyForegroundMs.class) {
                if (instance == null) {
                    instance = new SessionsMemoryCaptureFrequencyForegroundMs();
                }
                sessionsMemoryCaptureFrequencyForegroundMs = instance;
            }
            return sessionsMemoryCaptureFrequencyForegroundMs;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
        }

        public String getMetadataFlag() {
            return "sessions_memory_capture_frequency_fg_ms";
        }

        public String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_fg_ms";
        }

        public Long getDefault() {
            return 100L;
        }

        public Long getDefaultOnRcFetchFail() {
            return Long.valueOf(getDefault().longValue() * 3);
        }
    }

    public static final class SessionsSamplingRate extends ConfigurationFlag<Double> {
        private static SessionsSamplingRate instance;

        private SessionsSamplingRate() {
        }

        public static synchronized SessionsSamplingRate getInstance() {
            SessionsSamplingRate sessionsSamplingRate;
            synchronized (SessionsSamplingRate.class) {
                if (instance == null) {
                    instance = new SessionsSamplingRate();
                }
                sessionsSamplingRate = instance;
            }
            return sessionsSamplingRate;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionSamplingRate";
        }

        public String getMetadataFlag() {
            return "sessions_sampling_percentage";
        }

        public String getRemoteConfigFlag() {
            return "fpr_vc_session_sampling_rate";
        }

        public Double getDefault() {
            return Double.valueOf(0.01d);
        }

        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }
    }

    public static final class TraceEventCountBackground extends ConfigurationFlag<Long> {
        private static TraceEventCountBackground instance;

        private TraceEventCountBackground() {
        }

        public static synchronized TraceEventCountBackground getInstance() {
            TraceEventCountBackground traceEventCountBackground;
            synchronized (TraceEventCountBackground.class) {
                if (instance == null) {
                    instance = new TraceEventCountBackground();
                }
                traceEventCountBackground = instance;
            }
            return traceEventCountBackground;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountBackground";
        }

        public String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_bg";
        }

        public Long getDefault() {
            return 30L;
        }
    }

    public static final class TraceEventCountForeground extends ConfigurationFlag<Long> {
        private static TraceEventCountForeground instance;

        private TraceEventCountForeground() {
        }

        public static synchronized TraceEventCountForeground getInstance() {
            TraceEventCountForeground traceEventCountForeground;
            synchronized (TraceEventCountForeground.class) {
                if (instance == null) {
                    instance = new TraceEventCountForeground();
                }
                traceEventCountForeground = instance;
            }
            return traceEventCountForeground;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountForeground";
        }

        public String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_fg";
        }

        public Long getDefault() {
            return 300L;
        }
    }

    public static final class TraceSamplingRate extends ConfigurationFlag<Double> {
        private static TraceSamplingRate instance;

        private TraceSamplingRate() {
        }

        public static synchronized TraceSamplingRate getInstance() {
            TraceSamplingRate traceSamplingRate;
            synchronized (TraceSamplingRate.class) {
                if (instance == null) {
                    instance = new TraceSamplingRate();
                }
                traceSamplingRate = instance;
            }
            return traceSamplingRate;
        }

        public String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceSamplingRate";
        }

        public String getRemoteConfigFlag() {
            return "fpr_vc_trace_sampling_rate";
        }

        public Double getDefault() {
            return Double.valueOf(1.0d);
        }

        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }
    }
}
