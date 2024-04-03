package com.talabat.observabilityNew;

import com.huawei.hms.flutter.map.constants.Param;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.ApiStatus;
import com.talabat.core.observabilityNew.domain.common.AuthenticationStatus;
import com.talabat.core.observabilityNew.domain.common.BackgroundAction;
import com.talabat.core.observabilityNew.domain.common.EventType;
import com.talabat.core.observabilityNew.domain.common.RegistrationStatus;
import com.talabat.core.observabilityNew.domain.common.UserAction;
import com.talabat.core.observabilityNew.domain.common.ViewStatus;
import com.talabat.core.observabilityNew.domain.common.VoucherCampaignStatus;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.observabilityNew.tracker.IObservabilityTracker;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J,\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J$\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J,\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J$\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J,\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J4\u0010\u001c\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J4\u0010\u001c\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J,\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J\u0018\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\bH\u0016J,\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J$\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\bH\u0016J$\u00100\u001a\u00020\r2\u0006\u00101\u001a\u0002022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/talabat/observabilityNew/ObservabilityManager;", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "observabilityTracker", "Lcom/talabat/observabilityNew/tracker/IObservabilityTracker;", "(Lcom/talabat/observabilityNew/tracker/IObservabilityTracker;)V", "disableObservability", "", "nullCountryTraceId", "", "getNullCountryTraceId", "()Ljava/lang/String;", "setNullCountryTraceId", "(Ljava/lang/String;)V", "", "disable", "track", "eventName", "featureName", "attributes", "", "trackAdExEvent", "map", "trackAttribute", "name", "value", "trackAuthenticationEvents", "authenticationStatus", "Lcom/talabat/core/observabilityNew/domain/common/AuthenticationStatus;", "trackEvent", "backgroundAction", "Lcom/talabat/core/observabilityNew/domain/common/BackgroundAction;", "apiName", "apiStatus", "Lcom/talabat/core/observabilityNew/domain/common/ApiStatus;", "screenName", "viewName", "userAction", "Lcom/talabat/core/observabilityNew/domain/common/UserAction;", "viewStatus", "Lcom/talabat/core/observabilityNew/domain/common/ViewStatus;", "eventType", "trackRegistration", "registrationStatus", "Lcom/talabat/core/observabilityNew/domain/common/RegistrationStatus;", "trackUnExpectedScenario", "explanation", "trackUserId", "userId", "trackVoucherCampaign", "voucherCampaignStatus", "Lcom/talabat/core/observabilityNew/domain/common/VoucherCampaignStatus;", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservabilityManager implements IObservabilityManager {
    private boolean disableObservability;
    @Nullable
    private String nullCountryTraceId;
    @NotNull
    private final IObservabilityTracker observabilityTracker;

    @Inject
    public ObservabilityManager(@NotNull IObservabilityTracker iObservabilityTracker) {
        Intrinsics.checkNotNullParameter(iObservabilityTracker, "observabilityTracker");
        this.observabilityTracker = iObservabilityTracker;
    }

    public void disableObservability(boolean z11) {
        this.disableObservability = z11;
    }

    @Nullable
    public String getNullCountryTraceId() {
        return this.nullCountryTraceId;
    }

    public void setNullCountryTraceId(@Nullable String str) {
        this.nullCountryTraceId = str;
    }

    public void track(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!this.disableObservability) {
            this.observabilityTracker.trackEvent(str2, str, map);
        }
    }

    public void trackAdExEvent(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        if (!this.disableObservability) {
            this.observabilityTracker.trackEvent(EventType.Android_AdsExpo_Events.name(), str, map);
        }
    }

    public void trackAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        if (!this.disableObservability) {
            this.observabilityTracker.trackAttribute(str, str2);
        }
    }

    public void trackAuthenticationEvents(@NotNull AuthenticationStatus authenticationStatus, @NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(authenticationStatus, "authenticationStatus");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!this.disableObservability) {
            IObservabilityTracker iObservabilityTracker = this.observabilityTracker;
            String name2 = EventType.AuthEvent.name();
            Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiStatus", authenticationStatus.name()));
            mutableMapOf.putAll(map);
            Unit unit = Unit.INSTANCE;
            iObservabilityTracker.trackEvent(name2, str, mutableMapOf);
        }
    }

    public void trackEvent(@NotNull String str, @NotNull ApiStatus apiStatus, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "apiName");
        Intrinsics.checkNotNullParameter(apiStatus, "apiStatus");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!this.disableObservability) {
            IObservabilityTracker iObservabilityTracker = this.observabilityTracker;
            String name2 = EventType.ApiStatus.name();
            String value = apiStatus.getValue();
            iObservabilityTracker.trackEvent(name2, str + JavaConstant.Dynamic.DEFAULT_NAME + value, map);
        }
    }

    public void trackRegistration(@NotNull RegistrationStatus registrationStatus, @NotNull String str) {
        Intrinsics.checkNotNullParameter(registrationStatus, "registrationStatus");
        Intrinsics.checkNotNullParameter(str, "eventName");
        trackRegistration(registrationStatus, str, MapsKt__MapsKt.emptyMap());
    }

    public void trackUnExpectedScenario(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "explanation");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!this.disableObservability) {
            this.observabilityTracker.trackEvent(EventType.UnExpectedScenario.name(), str, map);
        }
    }

    public void trackUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        this.observabilityTracker.trackUserId(str);
    }

    public void trackVoucherCampaign(@NotNull VoucherCampaignStatus voucherCampaignStatus, @NotNull Map<String, String> map) {
        IObservabilityTracker iObservabilityTracker;
        Intrinsics.checkNotNullParameter(voucherCampaignStatus, "voucherCampaignStatus");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!this.disableObservability && (iObservabilityTracker = this.observabilityTracker) != null) {
            iObservabilityTracker.trackEvent(EventType.VoucherCampaign.name(), voucherCampaignStatus.name(), map);
        }
    }

    public void trackRegistration(@NotNull RegistrationStatus registrationStatus, @NotNull String str, @NotNull Map<String, String> map) {
        IObservabilityTracker iObservabilityTracker;
        Intrinsics.checkNotNullParameter(registrationStatus, "registrationStatus");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!this.disableObservability && (iObservabilityTracker = this.observabilityTracker) != null) {
            String name2 = EventType.Registration.name();
            String name3 = registrationStatus.name();
            iObservabilityTracker.trackEvent(name2, name3 + JavaConstant.Dynamic.DEFAULT_NAME + str, map);
        }
    }

    public void trackEvent(@NotNull String str, @NotNull String str2, @NotNull ViewStatus viewStatus, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "viewName");
        Intrinsics.checkNotNullParameter(viewStatus, "viewStatus");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!this.disableObservability) {
            IObservabilityTracker iObservabilityTracker = this.observabilityTracker;
            String name2 = EventType.ViewStatus.name();
            String value = viewStatus.getValue();
            iObservabilityTracker.trackEvent(name2, str + JavaConstant.Dynamic.DEFAULT_NAME + str2 + JavaConstant.Dynamic.DEFAULT_NAME + value, map);
        }
    }

    public void trackEvent(@NotNull String str, @NotNull String str2, @NotNull UserAction userAction, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "viewName");
        Intrinsics.checkNotNullParameter(userAction, "userAction");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!this.disableObservability) {
            IObservabilityTracker iObservabilityTracker = this.observabilityTracker;
            String name2 = EventType.UserAction.name();
            String value = userAction.getValue();
            iObservabilityTracker.trackEvent(name2, str + JavaConstant.Dynamic.DEFAULT_NAME + str2 + JavaConstant.Dynamic.DEFAULT_NAME + value, map);
        }
    }

    public void trackEvent(@NotNull BackgroundAction backgroundAction, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(backgroundAction, "backgroundAction");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!this.disableObservability) {
            this.observabilityTracker.trackEvent(EventType.BackgroundAction.name(), backgroundAction.getValue(), map);
        }
    }

    public void trackEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!this.disableObservability) {
            this.observabilityTracker.trackEvent(str2, str, map);
        }
    }
}
