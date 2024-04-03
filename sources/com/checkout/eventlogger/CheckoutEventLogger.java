package com.checkout.eventlogger;

import com.checkout.eventlogger.data.c;
import com.checkout.eventlogger.data.d;
import com.checkout.eventlogger.domain.a;
import com.checkout.eventlogger.domain.b.b;
import com.checkout.eventlogger.domain.model.Event;
import com.checkout.eventlogger.domain.model.MonitoringLevel;
import com.checkout.eventlogger.domain.model.RemoteProcessorMetadata;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.visa.checkout.Profile;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0004\u0018\u0000B\u000f\u0012\u0006\u0010 \u001a\u00020\u0001¢\u0006\u0004\b&\u0010\u001dJ\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\u00042\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001fR\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/checkout/eventlogger/CheckoutEventLogger;", "", "metadata", "value", "", "addMetadata", "(Ljava/lang/String;Ljava/lang/String;)V", "clearMetadata", "()V", "Lcom/checkout/eventlogger/domain/model/MonitoringLevel;", "monitoringLevel", "enableLocalProcessor", "(Lcom/checkout/eventlogger/domain/model/MonitoringLevel;)V", "Lcom/checkout/eventlogger/Environment;", "environment", "Lcom/checkout/eventlogger/domain/model/RemoteProcessorMetadata;", "remoteProcessorMetadata", "enableRemoteProcessor", "(Lcom/checkout/eventlogger/Environment;Lcom/checkout/eventlogger/domain/model/RemoteProcessorMetadata;)V", "", "Lcom/checkout/eventlogger/domain/LogEventProcessor;", "getProcessors", "()Ljava/util/List;", "", "Lcom/checkout/eventlogger/domain/model/Event;", "events", "logEvent", "([Lcom/checkout/eventlogger/domain/model/Event;)V", "removeMetadata", "(Ljava/lang/String;)V", "localProcessor", "Lcom/checkout/eventlogger/domain/LogEventProcessor;", "productName", "Ljava/lang/String;", "remoteProcessor", "", "transactionalEventMetadata", "Ljava/util/Map;", "<init>", "logger_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class CheckoutEventLogger {

    /* renamed from: a  reason: collision with root package name */
    public a f44199a;

    /* renamed from: b  reason: collision with root package name */
    public a f44200b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f44201c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final String f44202d;

    public CheckoutEventLogger(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ProductTrackingProvider.NAME);
        this.f44202d = str;
    }

    public final List<a> a() {
        return CollectionsKt__CollectionsKt.listOfNotNull((T[]) new a[]{this.f44199a, this.f44200b});
    }

    public final void addMetadata(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullParameter(str2, "value");
        this.f44201c.put(str, str2);
    }

    public final void clearMetadata() {
        this.f44201c.clear();
    }

    public final void enableLocalProcessor(@NotNull MonitoringLevel monitoringLevel) {
        Intrinsics.checkNotNullParameter(monitoringLevel, "monitoringLevel");
        this.f44199a = new b(this.f44202d, monitoringLevel);
    }

    public final void enableRemoteProcessor(@NotNull Environment environment, @NotNull RemoteProcessorMetadata remoteProcessorMetadata) {
        Intrinsics.checkNotNullParameter(environment, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(remoteProcessorMetadata, "remoteProcessorMetadata");
        this.f44200b = new com.checkout.eventlogger.domain.b.a(new com.checkout.eventlogger.data.a(new com.checkout.eventlogger.network.a(environment.getUrl$logger_release()), new d(this.f44202d, remoteProcessorMetadata, new c())));
    }

    public final void logEvent(@NotNull Event... eventArr) {
        Intrinsics.checkNotNullParameter(eventArr, "events");
        for (a a11 : a()) {
            a11.a(this.f44201c, (Event[]) Arrays.copyOf(eventArr, eventArr.length));
        }
    }

    public final void removeMetadata(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TtmlNode.TAG_METADATA);
        this.f44201c.remove(str);
    }
}
