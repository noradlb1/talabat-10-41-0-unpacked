package com.talabat.core.flutter.channels.data.tpro;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.flutter.channels.domain.tpro.TProChannelCallback;
import com.talabat.core.flutter.channels.domain.tpro.TproChannelFlutterDomain;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/talabat/core/flutter/channels/data/tpro/TproMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/tpro/TproChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/tpro/TProChannelCallback;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Lcom/talabat/core/flutter/channels/domain/tpro/TProChannelCallback;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "mainCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onAttach", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "activity", "Landroid/app/Activity;", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproMethodChannel implements MethodChannel.MethodCallHandler, TproChannelFlutterDomain {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_CONFIGS = "configs";
    @NotNull
    private static final String UPDATE_PRO_STATUS = "updateProStatus";
    /* access modifiers changed from: private */
    @NotNull
    public final TProChannelCallback callback;
    @Nullable
    private MethodChannel channel;
    @NotNull
    private final CoroutineScope mainCoroutineScope;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/flutter/channels/data/tpro/TproMethodChannel$Companion;", "", "()V", "GET_CONFIGS", "", "UPDATE_PRO_STATUS", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TproMethodChannel(@NotNull TProChannelCallback tProChannelCallback, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(tProChannelCallback, "callback");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
        this.callback = tProChannelCallback;
        this.mainCoroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatchersFactory.main());
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.talabat.flutter/talabatPro");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(activity, "activity");
        onAttach(binaryMessenger);
    }

    public void onDetach() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) GET_CONFIGS)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.mainCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TproMethodChannel$onMethodCall$1(this, methodCall, result, (Continuation<? super TproMethodChannel$onMethodCall$1>) null), 3, (Object) null);
        } else if (Intrinsics.areEqual((Object) str, (Object) UPDATE_PRO_STATUS)) {
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(this.mainCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TproMethodChannel$onMethodCall$2(this, methodCall, result, (Continuation<? super TproMethodChannel$onMethodCall$2>) null), 3, (Object) null);
        } else {
            Reflection.getOrCreateKotlinClass(TproMethodChannel.class).getSimpleName();
            result.notImplemented();
        }
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
