package com.talabat.core.fwfprojectskeys.domain.projects.platform;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/platform/PlatformFeatureFlagsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "DISABLE_APPTIMIZE_SDK", "ADJUST_FLUTTER_SDK", "ANALYTICS_NEW_STRATEGY", "BRAZE_FLUTTER_SDK", "TRACKING_LIBRARY_MIGRATION", "NEW_SESSION_STORE_COUNTRY_MODEL", "NEW_SESSION_STORE_AREA_MODEL", "NEW_SESSION_STORE_CUSTOMER_MODEL", "NEW_SESSION_STORE_AUTHENTICATION_MODEL", "NEW_SESSION_STORE_ADDRESS_MODEL", "NEW_SESSION_STORE_LANGUAGE_MODEL", "NEW_SESSION_STORE_ENV_MODEL", "NEW_SESSION_STORE_PERSEUS_ID", "PERFORMANCE_PLUGIN_INTEGRATION", "PERFORMANCE_FWF_COUNT", "PERFORMANCE_FWF_LOCATION_CORE_FOOD_CART", "PERFORMANCE_FWF_LOCATION_CORE_FAVORITES", "NEWRELIC_FLUTTER_SDK", "NEWRELIC_FLUTTER_SDK_DUAL", "NEWRELIC_FLUTTER_SDK_FALLBACK", "HIANALYTICS_FLUTTER_ENABLEMENT", "FWF_SDK_IN_DART_ENABLED", "FWF_SDK_IN_DART_SOFT_VALIDATION", "FWF_SDK_IN_DART_TRACKING_FOR_GET_VARIATION", "FWF_SDK_IN_DART_TRACKING_FOR_INITIAL_FETCH", "ENABLE_MARSHMALLOW_3", "EXTEND_ENGINES_DESTRUCTION", "PERSEUS_ASYNC_INIT", "DESTROY_ENGINE_WITH_ACTIVITY", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum PlatformFeatureFlagsKeys implements FWFKey {
    DISABLE_APPTIMIZE_SDK("ff_platform_peet_disable_apptimize", (int) null, 2, (FWFProjectName) null),
    ADJUST_FLUTTER_SDK("ff_platform_adjust_flutter_sdk", (int) null, 2, (FWFProjectName) null),
    ANALYTICS_NEW_STRATEGY("ff_platform_tracking_analytitcs_use_new_strategy", (int) null, 2, (FWFProjectName) null),
    BRAZE_FLUTTER_SDK("ff_platform_braze_flutter_sdk", (int) null, 2, (FWFProjectName) null),
    TRACKING_LIBRARY_MIGRATION("ff_platform_tracking_library_migration", (int) null, 2, (FWFProjectName) null),
    NEW_SESSION_STORE_COUNTRY_MODEL("ff_platform_new_session_store_country", (int) null, 2, (FWFProjectName) null),
    NEW_SESSION_STORE_AREA_MODEL("ff_platform_new_session_store_area", (int) null, 2, (FWFProjectName) null),
    NEW_SESSION_STORE_CUSTOMER_MODEL("ff_platform_new_session_store_customer", (int) null, 2, (FWFProjectName) null),
    NEW_SESSION_STORE_AUTHENTICATION_MODEL("ff_platform_new_session_store_authentication", (int) null, 2, (FWFProjectName) null),
    NEW_SESSION_STORE_ADDRESS_MODEL("ff_platform_new_session_store_address", (int) null, 2, (FWFProjectName) null),
    NEW_SESSION_STORE_LANGUAGE_MODEL("ff_platform_new_session_store_language", (int) null, 2, (FWFProjectName) null),
    NEW_SESSION_STORE_ENV_MODEL("ff_platform_new_session_store_env", (int) null, 2, (FWFProjectName) null),
    NEW_SESSION_STORE_PERSEUS_ID("ff_platform_new_session_store_perseus", (int) null, 2, (FWFProjectName) null),
    PERFORMANCE_PLUGIN_INTEGRATION("ff_platform_is_performance_analytics_plugin_enabled", (int) null, 2, (FWFProjectName) null),
    PERFORMANCE_FWF_COUNT("ff_platform_fwf_count", (int) null, 2, (FWFProjectName) null),
    PERFORMANCE_FWF_LOCATION_CORE_FOOD_CART("ff_platform_fwf_location_core_food_cart", (int) null, 2, (FWFProjectName) null),
    PERFORMANCE_FWF_LOCATION_CORE_FAVORITES("ff_platform_fwf_location_core_favorites", (int) null, 2, (FWFProjectName) null),
    NEWRELIC_FLUTTER_SDK("ff_platform_newrelic_flutter_sdk", (int) null, 2, (FWFProjectName) null),
    NEWRELIC_FLUTTER_SDK_DUAL("ff_platform_newrelic_flutter_sdk_dual", (int) null, 2, (FWFProjectName) null),
    NEWRELIC_FLUTTER_SDK_FALLBACK("ff_platform_newrelic_flutter_sdk_fallback", (int) null, 2, (FWFProjectName) null),
    HIANALYTICS_FLUTTER_ENABLEMENT("ff_platform_enable_hianalytics", (int) null, 2, (FWFProjectName) null),
    FWF_SDK_IN_DART_ENABLED("ff_platform_peet_enable_new_fwf_sdk_for_talabat_flutter", (int) null, 2, (FWFProjectName) null),
    FWF_SDK_IN_DART_SOFT_VALIDATION("ff_platform_peet_enable_new_fwf_sdk_for_validation", (int) null, 2, (FWFProjectName) null),
    FWF_SDK_IN_DART_TRACKING_FOR_GET_VARIATION("ff_platform_peet_enable_new_fwf_sdk_get_variation_tracking", (int) null, 2, (FWFProjectName) null),
    FWF_SDK_IN_DART_TRACKING_FOR_INITIAL_FETCH("ff_platform_peet_enable_new_fwf_sdk_initial_fetch_tracking", (int) null, 2, (FWFProjectName) null),
    ENABLE_MARSHMALLOW_3("ff_platform_enable_marshmallow_3", (int) null, 2, (FWFProjectName) null),
    EXTEND_ENGINES_DESTRUCTION("ff_platform_onlynative_explicit_engines_destruction", (int) null, 2, (FWFProjectName) null),
    PERSEUS_ASYNC_INIT("ff_platform_nativeonly_perseus_async_config", (int) null, 2, (FWFProjectName) null),
    DESTROY_ENGINE_WITH_ACTIVITY("ff_platform_destroy_engine_with_activity", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private PlatformFeatureFlagsKeys(String str, FWFProjectName fWFProjectName) {
        this.value = str;
        this.projectName = fWFProjectName;
    }

    @NotNull
    public FWFProjectName getProjectName() {
        return this.projectName;
    }

    @NotNull
    public String getValue() {
        return this.value;
    }
}
