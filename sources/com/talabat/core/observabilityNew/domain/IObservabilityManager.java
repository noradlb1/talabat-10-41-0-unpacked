package com.talabat.core.observabilityNew.domain;

import com.talabat.core.observabilityNew.domain.common.ApiStatus;
import com.talabat.core.observabilityNew.domain.common.AuthenticationStatus;
import com.talabat.core.observabilityNew.domain.common.BackgroundAction;
import com.talabat.core.observabilityNew.domain.common.RegistrationStatus;
import com.talabat.core.observabilityNew.domain.common.UserAction;
import com.talabat.core.observabilityNew.domain.common.ViewStatus;
import com.talabat.core.observabilityNew.domain.common.VoucherCampaignStatus;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J.\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&J$\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H&J.\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&J&\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&J.\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&J6\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&J6\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&J.\u0010\u0019\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&J\u0018\u0010&\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020'2\u0006\u0010\r\u001a\u00020\u0003H&J.\u0010&\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020'2\u0006\u0010\r\u001a\u00020\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&J&\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00032\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&J\u0010\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0003H&J&\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020.2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006/"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "", "nullCountryTraceId", "", "getNullCountryTraceId", "()Ljava/lang/String;", "setNullCountryTraceId", "(Ljava/lang/String;)V", "disableObservability", "", "disable", "", "track", "eventName", "featureName", "attributes", "", "trackAdExEvent", "map", "trackAttribute", "name", "value", "trackAuthenticationEvents", "registrationStatus", "Lcom/talabat/core/observabilityNew/domain/common/AuthenticationStatus;", "trackEvent", "backgroundAction", "Lcom/talabat/core/observabilityNew/domain/common/BackgroundAction;", "apiName", "apiStatus", "Lcom/talabat/core/observabilityNew/domain/common/ApiStatus;", "screenName", "viewName", "userAction", "Lcom/talabat/core/observabilityNew/domain/common/UserAction;", "viewStatus", "Lcom/talabat/core/observabilityNew/domain/common/ViewStatus;", "eventType", "trackRegistration", "Lcom/talabat/core/observabilityNew/domain/common/RegistrationStatus;", "trackUnExpectedScenario", "explanation", "trackUserId", "userId", "trackVoucherCampaign", "voucherCampaignStatus", "Lcom/talabat/core/observabilityNew/domain/common/VoucherCampaignStatus;", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IObservabilityManager {
    void disableObservability(boolean z11);

    @Nullable
    String getNullCountryTraceId();

    void setNullCountryTraceId(@Nullable String str);

    void track(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

    void trackAdExEvent(@NotNull String str, @NotNull Map<String, String> map);

    void trackAttribute(@NotNull String str, @NotNull String str2);

    void trackAuthenticationEvents(@NotNull AuthenticationStatus authenticationStatus, @NotNull String str, @NotNull Map<String, String> map);

    void trackEvent(@NotNull BackgroundAction backgroundAction, @NotNull Map<String, String> map);

    void trackEvent(@NotNull String str, @NotNull ApiStatus apiStatus, @NotNull Map<String, String> map);

    void trackEvent(@NotNull String str, @NotNull String str2, @NotNull UserAction userAction, @NotNull Map<String, String> map);

    void trackEvent(@NotNull String str, @NotNull String str2, @NotNull ViewStatus viewStatus, @NotNull Map<String, String> map);

    void trackEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

    void trackRegistration(@NotNull RegistrationStatus registrationStatus, @NotNull String str);

    void trackRegistration(@NotNull RegistrationStatus registrationStatus, @NotNull String str, @NotNull Map<String, String> map);

    void trackUnExpectedScenario(@NotNull String str, @NotNull Map<String, String> map);

    void trackUserId(@NotNull String str);

    void trackVoucherCampaign(@NotNull VoucherCampaignStatus voucherCampaignStatus, @NotNull Map<String, String> map);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void track$default(IObservabilityManager iObservabilityManager, String str, String str2, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityManager.track(str, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }

        public static /* synthetic */ void trackAuthenticationEvents$default(IObservabilityManager iObservabilityManager, AuthenticationStatus authenticationStatus, String str, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityManager.trackAuthenticationEvents(authenticationStatus, str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackAuthenticationEvents");
        }

        public static /* synthetic */ void trackEvent$default(IObservabilityManager iObservabilityManager, String str, ApiStatus apiStatus, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityManager.trackEvent(str, apiStatus, (Map<String, String>) map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackEvent");
        }

        public static /* synthetic */ void trackRegistration$default(IObservabilityManager iObservabilityManager, RegistrationStatus registrationStatus, String str, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityManager.trackRegistration(registrationStatus, str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackRegistration");
        }

        public static /* synthetic */ void trackUnExpectedScenario$default(IObservabilityManager iObservabilityManager, String str, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityManager.trackUnExpectedScenario(str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackUnExpectedScenario");
        }

        public static /* synthetic */ void trackVoucherCampaign$default(IObservabilityManager iObservabilityManager, VoucherCampaignStatus voucherCampaignStatus, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityManager.trackVoucherCampaign(voucherCampaignStatus, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackVoucherCampaign");
        }

        public static /* synthetic */ void trackEvent$default(IObservabilityManager iObservabilityManager, String str, String str2, ViewStatus viewStatus, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 8) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityManager.trackEvent(str, str2, viewStatus, (Map<String, String>) map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackEvent");
        }

        public static /* synthetic */ void trackEvent$default(IObservabilityManager iObservabilityManager, String str, String str2, UserAction userAction, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 8) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityManager.trackEvent(str, str2, userAction, (Map<String, String>) map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackEvent");
        }

        public static /* synthetic */ void trackEvent$default(IObservabilityManager iObservabilityManager, BackgroundAction backgroundAction, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityManager.trackEvent(backgroundAction, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackEvent");
        }

        public static /* synthetic */ void trackEvent$default(IObservabilityManager iObservabilityManager, String str, String str2, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityManager.trackEvent(str, str2, (Map<String, String>) map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackEvent");
        }
    }
}
