package com.checkout.eventlogger.domain.b;

import com.checkout.eventlogger.CheckoutEventLoggerKt;
import com.checkout.eventlogger.data.b;
import com.checkout.eventlogger.data.d;
import com.checkout.eventlogger.data.e.c;
import com.checkout.eventlogger.domain.model.Event;
import com.checkout.eventlogger.domain.model.MonitoringLevel;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

public final class a implements com.checkout.eventlogger.domain.a {

    /* renamed from: a  reason: collision with root package name */
    public final MonitoringLevel f44235a = MonitoringLevel.INFO;

    /* renamed from: b  reason: collision with root package name */
    public final com.checkout.eventlogger.data.a f44236b;

    public a(@NotNull com.checkout.eventlogger.data.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "loggingService");
        this.f44236b = aVar;
    }

    public void a(@NotNull Map<String, String> map, @NotNull Event... eventArr) {
        boolean z11;
        String str;
        LinkedHashMap linkedHashMap;
        Map<String, String> map2 = map;
        Event[] eventArr2 = eventArr;
        Intrinsics.checkNotNullParameter(map2, "transactionalEventMetadata");
        Intrinsics.checkNotNullParameter(eventArr2, "events");
        ArrayList arrayList = new ArrayList();
        int length = eventArr2.length;
        int i11 = 0;
        while (true) {
            z11 = true;
            if (i11 >= length) {
                break;
            }
            Event event = eventArr2[i11];
            if (event.getMonitoringLevel().compareTo(this.f44235a) > 0) {
                z11 = false;
            }
            if (z11) {
                arrayList.add(event);
            }
            i11++;
        }
        if (!arrayList.isEmpty()) {
            com.checkout.eventlogger.data.a aVar = this.f44236b;
            aVar.getClass();
            Intrinsics.checkNotNullParameter(map2, "transactionalEventMetadata");
            Intrinsics.checkNotNullParameter(arrayList, "events");
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (true) {
                c cVar = null;
                if (it.hasNext()) {
                    Event event2 = (Event) it.next();
                    d dVar = aVar.f44208d;
                    dVar.getClass();
                    Intrinsics.checkNotNullParameter(map2, "transactionalEventMetadata");
                    Intrinsics.checkNotNullParameter(event2, "event");
                    int ordinal = event2.getMonitoringLevel().ordinal();
                    if (ordinal == 0) {
                        str = "error";
                    } else if (ordinal == z11) {
                        str = "warn";
                    } else if (ordinal == 2) {
                        str = CustomerInfoLocalDataSourceImpl.KEY;
                    } else if (ordinal == 3) {
                        str = null;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (str != null) {
                        dVar.f44215c.getClass();
                        String uuid = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZ", Locale.ROOT);
                        String str2 = map2.get(CheckoutEventLoggerKt.METADATA_CORRELATION_ID);
                        if (str2 != null) {
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            for (Map.Entry next : map.entrySet()) {
                                if (Intrinsics.areEqual((Object) (String) next.getKey(), (Object) CheckoutEventLoggerKt.METADATA_CORRELATION_ID) ^ z11) {
                                    linkedHashMap2.put(next.getKey(), next.getValue());
                                    z11 = true;
                                }
                            }
                            linkedHashMap = linkedHashMap2;
                        } else {
                            linkedHashMap = map2;
                        }
                        com.checkout.eventlogger.data.e.a aVar2 = new com.checkout.eventlogger.data.e.a(str2, str);
                        String str3 = dVar.f44213a;
                        String format = simpleDateFormat.format(event2.getTime());
                        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(event.time)");
                        cVar = new c("1.0", uuid, dVar.f44214b.getProductIdentifier() + '.' + event2.getTypeIdentifier(), str3, format, dVar.a(linkedHashMap, event2), aVar2);
                    }
                    if (cVar != null) {
                        arrayList2.add(cVar);
                    }
                    z11 = true;
                } else if (arrayList2.isEmpty()) {
                    MonitoringLevel monitoringLevel = MonitoringLevel.DEBUG;
                    Intrinsics.checkNotNullParameter("No log events provided", "message");
                    Intrinsics.checkNotNullParameter("Cko-Logger", "tag");
                    Intrinsics.checkNotNullParameter(monitoringLevel, "monitoringLevel");
                    return;
                } else {
                    Job unused = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) aVar.f44205a.getValue(), (CoroutineContext) null, (CoroutineStart) null, new b(aVar, arrayList2, (Continuation) null), 3, (Object) null);
                    return;
                }
            }
        }
    }
}
