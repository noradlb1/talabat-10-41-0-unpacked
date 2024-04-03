package com.talabat.core.flutter.channels.data.gem;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.flutter.channels.domain.gem.GemChannelCallback;
import com.talabat.core.flutter.channels.domain.gem.GemChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0011\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006!"}, d2 = {"Lcom/talabat/core/flutter/channels/data/gem/GemMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/gem/GemChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/gem/GemChannelCallback;", "(Lcom/talabat/core/flutter/channels/domain/gem/GemChannelCallback;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "gemBroadcastReceiver", "com/talabat/core/flutter/channels/data/gem/GemMethodChannel$gemBroadcastReceiver$1", "Lcom/talabat/core/flutter/channels/data/gem/GemMethodChannel$gemBroadcastReceiver$1;", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemMethodChannel implements MethodChannel.MethodCallHandler, GemChannelFlutterDomain {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String GEM_DATA = "gemData";
    @NotNull
    public static final String GEM_EXPIRATION_DIALOG_SHOWN = "gemExpirationDialogShown";
    @NotNull
    public static final String GEM_HOME_DATA = "gemHomeData";
    @NotNull
    public static final String GEM_OFFERS_STATUS_CALLBACK = "gemOffersStatusCallback";
    @NotNull
    public static final String GEM_ORGANIC_LISTING_DATA = "organicListingData";
    @NotNull
    public static final String GEM_REMAINING_TIME = "gemRemainingTimeData";
    @NotNull
    public static final String GEM_STATUS_CALLBACK = "gemStatusCallback";
    @NotNull
    public static final String NAVIGATE_TO_GEM_COLLECTION = "navigateToGemCollection";
    @NotNull
    public static final String NAVIGATE_TO_GEM_POPUP = "navigateToGEMsPopup";
    @NotNull
    public static final String SYNC_OFFERS = "syncOffers";
    @Nullable
    private WeakReference<Activity> activity;
    @NotNull
    private final GemChannelCallback callback;
    @Nullable
    private MethodChannel channel;
    @NotNull
    private final GemMethodChannel$gemBroadcastReceiver$1 gemBroadcastReceiver = new GemMethodChannel$gemBroadcastReceiver$1(this);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/flutter/channels/data/gem/GemMethodChannel$Companion;", "", "()V", "GEM_DATA", "", "GEM_EXPIRATION_DIALOG_SHOWN", "GEM_HOME_DATA", "GEM_OFFERS_STATUS_CALLBACK", "GEM_ORGANIC_LISTING_DATA", "GEM_REMAINING_TIME", "GEM_STATUS_CALLBACK", "NAVIGATE_TO_GEM_COLLECTION", "NAVIGATE_TO_GEM_POPUP", "SYNC_OFFERS", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GemMethodChannel(@NotNull GemChannelCallback gemChannelCallback) {
        Intrinsics.checkNotNullParameter(gemChannelCallback, "callback");
        this.callback = gemChannelCallback;
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Activity activity2;
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.talabat.flutter/gem");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        WeakReference<Activity> weakReference = this.activity;
        if (weakReference != null && (activity2 = weakReference.get()) != null) {
            activity2.registerReceiver(this.gemBroadcastReceiver, new IntentFilter("com.talabat.gem.domain.usecases.ACTION_GEM_STATUS"));
        }
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = new WeakReference<>(activity2);
        onAttach(binaryMessenger);
    }

    public void onDetach() {
        Activity activity2;
        WeakReference<Activity> weakReference = this.activity;
        if (!(weakReference == null || (activity2 = weakReference.get()) == null)) {
            activity2.unregisterReceiver(this.gemBroadcastReceiver);
        }
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
        this.activity = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Activity activity2;
        Activity activity3;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1770835523:
                    if (str.equals("gemOffersStatusCallback")) {
                        this.callback.getGemOffersStatus(result);
                        return;
                    }
                    break;
                case -1620170874:
                    if (str.equals("gemStatusCallback")) {
                        result.success(Boolean.valueOf(this.callback.getIsGemEnabled(methodCall.arguments)));
                        return;
                    }
                    break;
                case -82070631:
                    if (str.equals("gemData")) {
                        result.success(this.callback.getGemData());
                        return;
                    }
                    break;
                case -32861796:
                    if (str.equals("navigateToGEMsPopup")) {
                        WeakReference<Activity> weakReference = this.activity;
                        if (weakReference != null && (activity2 = weakReference.get()) != null) {
                            this.callback.navigateToGemPopup(methodCall.arguments, activity2);
                            return;
                        }
                        return;
                    }
                    break;
                case 265723038:
                    if (str.equals("gemRemainingTimeData")) {
                        result.success(this.callback.getGemRemainingTimeData());
                        return;
                    }
                    break;
                case 1358497176:
                    if (str.equals(GEM_HOME_DATA)) {
                        this.callback.getGemHomeData(result, methodCall.arguments);
                        return;
                    }
                    break;
                case 1446024291:
                    if (str.equals("organicListingData")) {
                        result.success(this.callback.getOrganicListingData());
                        return;
                    }
                    break;
                case 1630635627:
                    if (str.equals("gemExpirationDialogShown")) {
                        this.callback.setGemExpirationDialogShown();
                        result.success((Object) null);
                        return;
                    }
                    break;
                case 1975293970:
                    if (str.equals("syncOffers")) {
                        this.callback.syncOffers(result, methodCall.arguments);
                        return;
                    }
                    break;
                case 2134165217:
                    if (str.equals("navigateToGemCollection")) {
                        WeakReference<Activity> weakReference2 = this.activity;
                        if (weakReference2 != null && (activity3 = weakReference2.get()) != null) {
                            this.callback.navigateToGemCollection(activity3);
                            return;
                        }
                        return;
                    }
                    break;
            }
        }
        Reflection.getOrCreateKotlinClass(GemMethodChannel.class).getSimpleName();
        Object obj = methodCall.arguments;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Not Implemented");
        sb2.append(obj);
        result.notImplemented();
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
