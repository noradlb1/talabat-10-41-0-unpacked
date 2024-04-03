package com.checkout.logging;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.checkout.base.model.Environment;
import com.checkout.eventlogger.CheckoutEventLogger;
import com.checkout.eventlogger.CheckoutEventLoggerKt;
import com.checkout.eventlogger.domain.model.RemoteProcessorMetadata;
import com.checkout.logging.model.LoggingEvent;
import com.checkout.logging.utils.EnvironmentExtensionKt;
import com.visa.checkout.Profile;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashSet;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0016H\u0016J(\u0010\"\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR,\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/checkout/logging/EventLogger;", "Lcom/checkout/logging/Logger;", "Lcom/checkout/logging/model/LoggingEvent;", "logger", "Lcom/checkout/eventlogger/CheckoutEventLogger;", "(Lcom/checkout/eventlogger/CheckoutEventLogger;)V", "needToSetup", "", "getNeedToSetup$annotations", "()V", "getNeedToSetup", "()Z", "setNeedToSetup", "(Z)V", "sentLogs", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getSentLogs$annotations", "getSentLogs", "()Ljava/util/HashSet;", "log", "", "event", "logOnce", "provideProcessorMetadata", "Lcom/checkout/eventlogger/domain/model/RemoteProcessorMetadata;", "context", "Landroid/content/Context;", "environment", "Lcom/checkout/base/model/Environment;", "identifier", "version", "resetSession", "setup", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventLogger implements Logger<LoggingEvent> {
    @NotNull
    private final CheckoutEventLogger logger;
    private boolean needToSetup = true;
    @NotNull
    private final HashSet<String> sentLogs = new HashSet<>();

    public EventLogger(@NotNull CheckoutEventLogger checkoutEventLogger) {
        Intrinsics.checkNotNullParameter(checkoutEventLogger, "logger");
        this.logger = checkoutEventLogger;
    }

    @VisibleForTesting
    public static /* synthetic */ void getNeedToSetup$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getSentLogs$annotations() {
    }

    private final RemoteProcessorMetadata provideProcessorMetadata(Context context, Environment environment, String str, String str2) {
        return RemoteProcessorMetadata.Companion.from(context, EnvironmentExtensionKt.toLoggingName(environment), str, str2);
    }

    public final boolean getNeedToSetup() {
        return this.needToSetup;
    }

    @NotNull
    public final HashSet<String> getSentLogs() {
        return this.sentLogs;
    }

    public void resetSession() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.logger.addMetadata(CheckoutEventLoggerKt.METADATA_CORRELATION_ID, uuid);
        this.sentLogs.clear();
    }

    public final void setNeedToSetup(boolean z11) {
        this.needToSetup = z11;
    }

    public void setup(@NotNull Context context, @NotNull Environment environment, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(environment, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(str, Constants.IDENTIFIER);
        Intrinsics.checkNotNullParameter(str2, "version");
        if (this.needToSetup) {
            this.logger.enableRemoteProcessor(EnvironmentExtensionKt.toLoggingEnvironment(environment), provideProcessorMetadata(context, environment, str, str2));
            resetSession();
            this.needToSetup = false;
        }
    }

    public void log(@NotNull LoggingEvent loggingEvent) {
        Intrinsics.checkNotNullParameter(loggingEvent, "event");
        this.logger.logEvent(loggingEvent);
    }

    public void logOnce(@NotNull LoggingEvent loggingEvent) {
        Intrinsics.checkNotNullParameter(loggingEvent, "event");
        if (this.sentLogs.add(loggingEvent.getEventType$checkout_release().getEventId())) {
            log(loggingEvent);
        }
    }
}
