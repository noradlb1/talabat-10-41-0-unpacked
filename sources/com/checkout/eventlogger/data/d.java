package com.checkout.eventlogger.data;

import com.checkout.eventlogger.data.e.b;
import com.checkout.eventlogger.domain.model.Event;
import com.checkout.eventlogger.domain.model.RemoteProcessorMetadata;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f44213a;

    /* renamed from: b  reason: collision with root package name */
    public final RemoteProcessorMetadata f44214b;

    /* renamed from: c  reason: collision with root package name */
    public final c f44215c;

    public d(@NotNull String str, @NotNull RemoteProcessorMetadata remoteProcessorMetadata, @NotNull c cVar) {
        Intrinsics.checkNotNullParameter(str, ProductTrackingProvider.NAME);
        Intrinsics.checkNotNullParameter(remoteProcessorMetadata, "remoteProcessorMetadata");
        Intrinsics.checkNotNullParameter(cVar, "eventIdGenerator");
        this.f44213a = str;
        this.f44214b = remoteProcessorMetadata;
        this.f44215c = cVar;
    }

    public final b a(Map<String, String> map, Event event) {
        RemoteProcessorMetadata remoteProcessorMetadata = this.f44214b;
        Map plus = MapsKt__MapsKt.plus(event.getProperties(), (Map<String, Object>) map);
        Intrinsics.checkNotNullParameter(remoteProcessorMetadata, TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullParameter(plus, "event");
        return new b(remoteProcessorMetadata.getProductVersion(), remoteProcessorMetadata.getEnvironment(), remoteProcessorMetadata.getAppPackageName(), remoteProcessorMetadata.getAppPackageVersion(), remoteProcessorMetadata.getAppInstallId(), remoteProcessorMetadata.getDeviceName(), remoteProcessorMetadata.getPlatform(), remoteProcessorMetadata.getOsVersion(), plus);
    }
}
