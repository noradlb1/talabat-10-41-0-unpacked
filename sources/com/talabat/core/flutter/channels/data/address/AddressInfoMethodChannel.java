package com.talabat.core.flutter.channels.data.address;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelFlutterDomain;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/core/flutter/channels/data/address/AddressInfoMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelFlutterDomain;", "callback", "Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "<set-?>", "Lio/flutter/plugin/common/MethodChannel;", "channel", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "mainCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "observeError", "", "reason", "", "onAttach", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "onAttachWithActivity", "arguments", "Landroid/os/Bundle;", "onDetach", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressInfoMethodChannel implements MethodChannel.MethodCallHandler, AddressInfoChannelFlutterDomain {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String METHOD_GET_ADDRESS_LIST = "getAddressList";
    @NotNull
    private static final String METHOD_GET_GUEST_ADDRESS_INFO = "getGuestAddressInfo";
    @NotNull
    private static final String METHOD_SET_ADDRESS_LIST = "setAddressList";
    @NotNull
    private static final String METHOD_SET_GUEST_ADDRESS_INFO = "setGuestAddressInfo";
    @NotNull
    private static final String METHOD_SET_SELECTED_ADDRESS = "setSelectedAddress";
    @NotNull
    private static final String METHOD_SET_SELECTED_COUNTRY = "setSelectedCountry";
    @NotNull
    private static final String METHOD_SET_SELECTED_UNSAVED_ADDRESS = "setSelectedUnsavedAddress";
    @NotNull
    private static final String METHOD_SKIP_ADDRESS_MAP = "skipAddressMap";
    @Nullable
    private WeakReference<Activity> activity;
    /* access modifiers changed from: private */
    @NotNull
    public final AddressInfoChannelCallback callback;
    @Nullable
    private MethodChannel channel;
    @NotNull
    private final CoroutineScope mainCoroutineScope;
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/data/address/AddressInfoMethodChannel$Companion;", "", "()V", "METHOD_GET_ADDRESS_LIST", "", "METHOD_GET_GUEST_ADDRESS_INFO", "METHOD_SET_ADDRESS_LIST", "METHOD_SET_GUEST_ADDRESS_INFO", "METHOD_SET_SELECTED_ADDRESS", "METHOD_SET_SELECTED_COUNTRY", "METHOD_SET_SELECTED_UNSAVED_ADDRESS", "METHOD_SKIP_ADDRESS_MAP", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AddressInfoMethodChannel(@NotNull AddressInfoChannelCallback addressInfoChannelCallback, @NotNull IObservabilityManager iObservabilityManager, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(addressInfoChannelCallback, "callback");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
        this.callback = addressInfoChannelCallback;
        this.observabilityManager = iObservabilityManager;
        this.mainCoroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatchersFactory.main());
    }

    private final void observeError(String str) {
        this.observabilityManager.track("set_address_list_failed", "ULEvents", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("reason", str)));
    }

    @VisibleForTesting
    @Nullable
    public final MethodChannel getChannel() {
        return this.channel;
    }

    public void onAttach(@NotNull BinaryMessenger binaryMessenger) {
        String str;
        Activity activity2;
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, MethodChannels.ADDRESS_INFO_CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        AddressInfoChannelCallback addressInfoChannelCallback = this.callback;
        WeakReference<Activity> weakReference = this.activity;
        if (weakReference == null || (activity2 = weakReference.get()) == null) {
            str = null;
        } else {
            str = activity2.getLocalClassName();
        }
        addressInfoChannelCallback.onAttach(str, System.identityHashCode(this));
    }

    public void onAttachWithActivity(@NotNull BinaryMessenger binaryMessenger, @NotNull Activity activity2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        onAttach(binaryMessenger);
    }

    public void onDetach() {
        String str;
        Activity activity2;
        AddressInfoChannelCallback addressInfoChannelCallback = this.callback;
        WeakReference<Activity> weakReference = this.activity;
        if (weakReference == null || (activity2 = weakReference.get()) == null) {
            str = null;
        } else {
            str = activity2.getLocalClassName();
        }
        addressInfoChannelCallback.onDetach(str, System.identityHashCode(this));
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
        this.activity = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@org.jetbrains.annotations.NotNull io.flutter.plugin.common.MethodCall r10, @org.jetbrains.annotations.NotNull io.flutter.plugin.common.MethodChannel.Result r11) {
        /*
            r9 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = r10.method
            if (r0 == 0) goto L_0x0160
            int r1 = r0.hashCode()
            r2 = 0
            java.lang.String r3 = "address"
            java.lang.String r4 = "areaId"
            switch(r1) {
                case -2017792644: goto L_0x014d;
                case -1364769021: goto L_0x012b;
                case -1255892969: goto L_0x0101;
                case -302695860: goto L_0x00bc;
                case 505438448: goto L_0x0084;
                case 849630137: goto L_0x0059;
                case 974179239: goto L_0x003f;
                case 1241032000: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0160
        L_0x001c:
            java.lang.String r1 = "getGuestAddressInfo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0026
            goto L_0x0160
        L_0x0026:
            java.lang.Object r10 = r10.argument(r4)
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 != 0) goto L_0x0030
            r10 = 0
            goto L_0x0034
        L_0x0030:
            int r10 = r10.intValue()
        L_0x0034:
            com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback r0 = r9.callback
            java.util.Map r10 = r0.getGuestAddressInfo(r10)
            r11.success(r10)
            goto L_0x0163
        L_0x003f:
            java.lang.String r10 = "skipAddressMap"
            boolean r10 = r0.equals(r10)
            if (r10 != 0) goto L_0x004a
            goto L_0x0160
        L_0x004a:
            com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback r10 = r9.callback
            boolean r10 = r10.getSkipAddressMap()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r11.success(r10)
            goto L_0x0163
        L_0x0059:
            java.lang.String r1 = "setSelectedCountry"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0063
            goto L_0x0160
        L_0x0063:
            java.lang.String r0 = "countryId"
            java.lang.Object r10 = r10.argument(r0)
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 == 0) goto L_0x007d
            kotlinx.coroutines.CoroutineScope r3 = r9.mainCoroutineScope
            r4 = 0
            r5 = 0
            com.talabat.core.flutter.channels.data.address.AddressInfoMethodChannel$onMethodCall$1 r6 = new com.talabat.core.flutter.channels.data.address.AddressInfoMethodChannel$onMethodCall$1
            r6.<init>(r9, r10, r11, r2)
            r7 = 3
            r8 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
            goto L_0x0163
        L_0x007d:
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r11.success(r10)
            goto L_0x0163
        L_0x0084:
            java.lang.String r1 = "setAddressList"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x008e
            goto L_0x0160
        L_0x008e:
            java.lang.Object r10 = r10.arguments     // Catch:{ Exception -> 0x00ad }
            boolean r0 = r10 instanceof java.util.List     // Catch:{ Exception -> 0x00ad }
            if (r0 == 0) goto L_0x0097
            r2 = r10
            java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x00ad }
        L_0x0097:
            if (r2 == 0) goto L_0x00a5
            com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback r10 = r9.callback     // Catch:{ Exception -> 0x00ad }
            r10.setAddressList(r2)     // Catch:{ Exception -> 0x00ad }
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00ad }
            r11.success(r10)     // Catch:{ Exception -> 0x00ad }
            goto L_0x0163
        L_0x00a5:
            java.lang.Exception r10 = new java.lang.Exception     // Catch:{ Exception -> 0x00ad }
            java.lang.String r0 = "Arguments is null"
            r10.<init>(r0)     // Catch:{ Exception -> 0x00ad }
            throw r10     // Catch:{ Exception -> 0x00ad }
        L_0x00ad:
            r10 = move-exception
            java.lang.String r10 = r10.toString()
            r9.observeError(r10)
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r11.success(r10)
            goto L_0x0163
        L_0x00bc:
            java.lang.String r1 = "setGuestAddressInfo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c6
            goto L_0x0160
        L_0x00c6:
            java.lang.Object r0 = r10.argument(r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            java.lang.String r1 = "firstName"
            java.lang.Object r1 = r10.argument(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "lastName"
            java.lang.Object r2 = r10.argument(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r10 = r10.argument(r3)
            java.util.Map r10 = (java.util.Map) r10
            if (r0 == 0) goto L_0x00fb
            if (r1 == 0) goto L_0x00fb
            if (r2 == 0) goto L_0x00fb
            if (r10 != 0) goto L_0x00eb
            goto L_0x00fb
        L_0x00eb:
            com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback r3 = r9.callback
            int r0 = r0.intValue()
            r3.setGuestAddressInfo(r0, r1, r2, r10)
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r11.success(r10)
            goto L_0x0163
        L_0x00fb:
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r11.success(r10)
            goto L_0x0163
        L_0x0101:
            java.lang.String r1 = "setSelectedAddress"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x010a
            goto L_0x0160
        L_0x010a:
            java.lang.String r0 = "addressId"
            java.lang.Object r0 = r10.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r10 = r10.argument(r4)
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r0 == 0) goto L_0x0125
            if (r10 == 0) goto L_0x0125
            com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback r1 = r9.callback
            int r10 = r10.intValue()
            r1.setSelectedAddress(r0, r10)
        L_0x0125:
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r11.success(r10)
            goto L_0x0163
        L_0x012b:
            java.lang.String r1 = "setSelectedUnsavedAddress"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0134
            goto L_0x0160
        L_0x0134:
            java.lang.Object r10 = r10.argument(r3)
            java.util.Map r10 = (java.util.Map) r10
            if (r10 == 0) goto L_0x0147
            com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback r0 = r9.callback
            r0.setSelectedUnsavedAddress(r10)
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r11.success(r10)
            goto L_0x0163
        L_0x0147:
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r11.success(r10)
            goto L_0x0163
        L_0x014d:
            java.lang.String r10 = "getAddressList"
            boolean r10 = r0.equals(r10)
            if (r10 != 0) goto L_0x0156
            goto L_0x0160
        L_0x0156:
            com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback r10 = r9.callback
            java.util.List r10 = r10.getAddressList()
            r11.success(r10)
            goto L_0x0163
        L_0x0160:
            r11.notImplemented()
        L_0x0163:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.data.address.AddressInfoMethodChannel.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    @VisibleForTesting
    public final void setChannel(@Nullable MethodChannel methodChannel) {
        this.channel = methodChannel;
    }
}
