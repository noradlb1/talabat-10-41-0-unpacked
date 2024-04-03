package com.checkout.eventlogger.domain.b;

import android.util.Log;
import com.checkout.eventlogger.domain.a;
import com.checkout.eventlogger.domain.model.Event;
import com.checkout.eventlogger.domain.model.MessageEvent;
import com.checkout.eventlogger.domain.model.MonitoringLevel;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f44237a;

    /* renamed from: b  reason: collision with root package name */
    public final MonitoringLevel f44238b;

    public b(@NotNull String str, @NotNull MonitoringLevel monitoringLevel) {
        Intrinsics.checkNotNullParameter(str, ProductTrackingProvider.NAME);
        Intrinsics.checkNotNullParameter(monitoringLevel, "logcatFilter");
        this.f44237a = str;
        this.f44238b = monitoringLevel;
    }

    public void a(@NotNull Map<String, String> map, @NotNull Event... eventArr) {
        String str;
        Intrinsics.checkNotNullParameter(map, "transactionalEventMetadata");
        Intrinsics.checkNotNullParameter(eventArr, "events");
        ArrayList<Event> arrayList = new ArrayList<>();
        int length = eventArr.length;
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= length) {
                break;
            }
            Event event = eventArr[i11];
            if (event.getMonitoringLevel().compareTo(this.f44238b) > 0) {
                z11 = false;
            }
            if (z11) {
                arrayList.add(event);
            }
            i11++;
        }
        for (Event event2 : arrayList) {
            if (event2 instanceof MessageEvent) {
                str = ((MessageEvent) event2).asSummary$logger_release();
            } else {
                str = event2.getTypeIdentifier();
            }
            String str2 = this.f44237a;
            int ordinal = event2.getMonitoringLevel().ordinal();
            if (ordinal == 0) {
                Log.e(str2, str);
            } else if (ordinal == 1) {
                Log.w(str2, str);
            } else if (ordinal == 2) {
                Log.i(str2, str);
            }
        }
    }
}
