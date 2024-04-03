package com.talabat.fluttercore.channels;

import com.talabat.core.di.ApiContainer;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/talabat/fluttercore/channels/MobileServicesMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "apiContainer", "Lcom/talabat/core/di/ApiContainer;", "(Lcom/talabat/core/di/ApiContainer;)V", "gmsApi", "Lcom/talabat/core/gms/base/domain/GmsBaseCoreLibApi;", "getGmsApi", "()Lcom/talabat/core/gms/base/domain/GmsBaseCoreLibApi;", "hmsApi", "Lcom/talabat/core/hms/base/domain/HmsBaseCoreLibApi;", "getHmsApi", "()Lcom/talabat/core/hms/base/domain/HmsBaseCoreLibApi;", "onMethodCall", "", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MobileServicesMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String METHOD_IS_GMS_AVAILABLE = "isGmsAvailable";
    @NotNull
    private static final String METHOD_IS_HMS_AVAILABLE = "isHmsAvailable";
    @NotNull
    private static final String MOBILE_SERVICES_CHANNEL_NAME = "com.talabat.flutter/mobile-services";
    @NotNull
    private final GmsBaseCoreLibApi gmsApi;
    @NotNull
    private final HmsBaseCoreLibApi hmsApi;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluttercore/channels/MobileServicesMethodChannel$Companion;", "", "()V", "METHOD_IS_GMS_AVAILABLE", "", "METHOD_IS_HMS_AVAILABLE", "MOBILE_SERVICES_CHANNEL_NAME", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MobileServicesMethodChannel(@NotNull ApiContainer apiContainer) {
        Intrinsics.checkNotNullParameter(apiContainer, "apiContainer");
        this.gmsApi = (GmsBaseCoreLibApi) apiContainer.getFeature(GmsBaseCoreLibApi.class);
        this.hmsApi = (HmsBaseCoreLibApi) apiContainer.getFeature(HmsBaseCoreLibApi.class);
    }

    @NotNull
    public final GmsBaseCoreLibApi getGmsApi() {
        return this.gmsApi;
    }

    @NotNull
    public final HmsBaseCoreLibApi getHmsApi() {
        return this.hmsApi;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "methodCall");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) METHOD_IS_GMS_AVAILABLE)) {
            result.success(Boolean.valueOf(this.gmsApi.isGmsAvailable()));
        } else if (Intrinsics.areEqual((Object) str, (Object) METHOD_IS_HMS_AVAILABLE)) {
            result.success(Boolean.valueOf(this.hmsApi.isHmsAvailable()));
        } else {
            result.notImplemented();
        }
    }
}
