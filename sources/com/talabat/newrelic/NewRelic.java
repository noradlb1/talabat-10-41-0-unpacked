package com.talabat.newrelic;

import android.content.Context;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J.\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016J\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/talabat/newrelic/NewRelic;", "", "()V", "NAME", "", "pendingEvents", "", "Lcom/talabat/newrelic/NewRelicPendingEvent;", "getPendingEvents$com_talabat_ThirdPartyLibs_NewRelic_NewRelic", "()Ljava/util/List;", "setPendingEvents$com_talabat_ThirdPartyLibs_NewRelic_NewRelic", "(Ljava/util/List;)V", "sendEventScope", "Lkotlinx/coroutines/GlobalScope;", "getSendEventScope$annotations", "getSendEventScope", "()Lkotlinx/coroutines/GlobalScope;", "addPendingEvent", "", "eventType", "eventName", "attributes", "", "initialise", "context", "Landroid/content/Context;", "recordCustomEvent", "setAttribute", "name", "value", "setUserId", "userId", "com_talabat_ThirdPartyLibs_NewRelic_NewRelic"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewRelic {
    @NotNull
    public static final NewRelic INSTANCE = new NewRelic();
    @NotNull
    private static final String NAME = "name";
    @Nullable
    private static List<NewRelicPendingEvent> pendingEvents;
    @NotNull
    private static final GlobalScope sendEventScope = GlobalScope.INSTANCE;

    private NewRelic() {
    }

    private final void addPendingEvent(String str, String str2, Map<String, String> map) {
        List<NewRelicPendingEvent> list;
        if (NewRelicKt.eventTypesCanBePending.contains(str)) {
            NewRelicPendingEvent newRelicPendingEvent = new NewRelicPendingEvent(str, str2, map);
            List<NewRelicPendingEvent> list2 = pendingEvents;
            if (list2 == null || (list = CollectionsKt___CollectionsKt.plus(list2, newRelicPendingEvent)) == null) {
                list = CollectionsKt__CollectionsJVMKt.listOf(newRelicPendingEvent);
            }
            pendingEvents = list;
        }
    }

    public static /* synthetic */ void getSendEventScope$annotations() {
    }

    public static /* synthetic */ void recordCustomEvent$default(NewRelic newRelic, String str, String str2, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        newRelic.recordCustomEvent(str, str2, map);
    }

    @Nullable
    public final List<NewRelicPendingEvent> getPendingEvents$com_talabat_ThirdPartyLibs_NewRelic_NewRelic() {
        return pendingEvents;
    }

    @NotNull
    public final GlobalScope getSendEventScope() {
        return sendEventScope;
    }

    public final void initialise(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.newrelic.agent.android.NewRelic.withApplicationToken("AA17382d0c3b2ace00cc413dc824a979bfd98070db-NRMA").start(context);
        List<NewRelicPendingEvent> list = pendingEvents;
        if (list != null) {
            for (NewRelicPendingEvent newRelicPendingEvent : new ArrayList(list)) {
                INSTANCE.recordCustomEvent(newRelicPendingEvent.getEventType(), newRelicPendingEvent.getEventName(), newRelicPendingEvent.getAttributes());
            }
            pendingEvents = null;
        }
    }

    public final void recordCustomEvent(@NotNull String str, @Nullable String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (!com.newrelic.agent.android.NewRelic.isStarted()) {
            addPendingEvent(str, str2, map);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(sendEventScope, Dispatchers.getDefault(), (CoroutineStart) null, new NewRelic$recordCustomEvent$1(map, str2, str, (Continuation<? super NewRelic$recordCustomEvent$1>) null), 2, (Object) null);
        }
    }

    public final void setAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        com.newrelic.agent.android.NewRelic.setAttribute(str, str2);
    }

    public final void setPendingEvents$com_talabat_ThirdPartyLibs_NewRelic_NewRelic(@Nullable List<NewRelicPendingEvent> list) {
        pendingEvents = list;
    }

    public final void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        com.newrelic.agent.android.NewRelic.setUserId(str);
    }
}
