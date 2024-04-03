package com.adtechsdk.dh_adtech_sdk_flutter.viewability.presentation;

import android.content.Context;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.ViewabilityMethodChannel;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.data.ViewabilityRepository;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.Creative;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/presentation/AdDisplayViewFactory;", "Lio/flutter/plugin/platform/PlatformViewFactory;", "sdkScope", "Lkotlinx/coroutines/CoroutineScope;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "viewableMethodChannel", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/ViewabilityMethodChannel;", "adViewabilityRepository", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/ViewabilityRepository;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/ViewabilityMethodChannel;Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/ViewabilityRepository;)V", "create", "Lio/flutter/plugin/platform/PlatformView;", "context", "Landroid/content/Context;", "viewId", "", "args", "", "getCreative", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/Creative;", "jsonString", "", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AdDisplayViewFactory extends PlatformViewFactory {
    @NotNull
    private final ViewabilityRepository adViewabilityRepository;
    @NotNull
    private final CoroutineDispatcher mainDispatcher;
    @NotNull
    private final CoroutineScope sdkScope;
    @NotNull
    private final ViewabilityMethodChannel viewableMethodChannel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdDisplayViewFactory(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ViewabilityMethodChannel viewabilityMethodChannel, @NotNull ViewabilityRepository viewabilityRepository) {
        super(StandardMessageCodec.INSTANCE);
        Intrinsics.checkNotNullParameter(coroutineScope, "sdkScope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(viewabilityMethodChannel, "viewableMethodChannel");
        Intrinsics.checkNotNullParameter(viewabilityRepository, "adViewabilityRepository");
        this.sdkScope = coroutineScope;
        this.mainDispatcher = coroutineDispatcher;
        this.viewableMethodChannel = viewabilityMethodChannel;
        this.adViewabilityRepository = viewabilityRepository;
    }

    private final Creative getCreative(String str) {
        try {
            return Creative.Companion.fromJson(str);
        } catch (Exception e11) {
            ViewabilityMethodChannel viewabilityMethodChannel = this.viewableMethodChannel;
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            viewabilityMethodChannel.logError("Error Deserializing Platform Creative", message);
            return null;
        }
    }

    @NotNull
    public PlatformView create(@NotNull Context context, int i11, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AdDisplayView(context, new AdDisplaySession(context, this.sdkScope, getCreative(String.valueOf(obj)), this.mainDispatcher, this.viewableMethodChannel, this.adViewabilityRepository));
    }
}
