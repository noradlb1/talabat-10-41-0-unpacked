package com.adtechsdk.dh_adtech_sdk_flutter;

import com.adtechsdk.dh_adtech_sdk_flutter.viewability.ViewabilityMethodChannel;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.data.OmJsSdkDataSource;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.data.OmSdkDataSource;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.data.ViewabilityRepository;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation.AdDisplayViewFactory;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/DhAdtechSdkFlutterPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "sdkScope", "Lkotlinx/coroutines/CoroutineScope;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DhAdtechSdkFlutterPlugin implements FlutterPlugin {
    @NotNull
    private final CoroutineDispatcher ioDispatcher = Dispatchers.getIO();
    @NotNull
    private final CoroutineDispatcher mainDispatcher = Dispatchers.getMain();
    @NotNull
    private final CoroutineScope sdkScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterPluginBinding.binaryMessenger");
        flutterPluginBinding.getPlatformViewRegistry().registerViewFactory("AdDisplayView", new AdDisplayViewFactory(this.sdkScope, this.mainDispatcher, new ViewabilityMethodChannel(binaryMessenger), new ViewabilityRepository(this.mainDispatcher, new OmSdkDataSource(), new OmJsSdkDataSource(this.ioDispatcher))));
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
    }
}
