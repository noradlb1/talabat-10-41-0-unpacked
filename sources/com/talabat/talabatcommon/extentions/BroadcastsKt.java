package com.talabat.talabatcommon.extentions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Q\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0001\u001a#\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002¢\u0006\u0002\u0010\u0006\u001a*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0000\u001a\u00020\u000fH\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0004H\u0007\u001aA\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2*\u0010\u0012\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150\u00140\u0013\"\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u00020\u0005*\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007\u001a4\u0010\u0017\u001a\u00020\u0005*\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¨\u0006\u001a"}, d2 = {"receiver", "com/talabat/talabatcommon/extentions/BroadcastsKt$receiver$1", "onReceive", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "(Lkotlin/jvm/functions/Function1;)Lcom/talabat/talabatcommon/extentions/BroadcastsKt$receiver$1;", "registrationObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "action", "", "registerInState", "Landroidx/lifecycle/Lifecycle$State;", "context", "Landroid/content/Context;", "Landroid/content/BroadcastReceiver;", "sendBroadcast", "intent", "extras", "", "Lkotlin/Pair;", "Ljava/io/Serializable;", "(Ljava/lang/String;[Lkotlin/Pair;)V", "registerToBroadcast", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BroadcastsKt {
    /* access modifiers changed from: private */
    public static final BroadcastsKt$receiver$1 receiver(Function1<? super Intent, Unit> function1) {
        return new BroadcastsKt$receiver$1(function1);
    }

    @BroadcastsDsl
    public static final void registerToBroadcast(@NotNull Fragment fragment, @NotNull String str, @NotNull Lifecycle.State state, @NotNull Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(state, "registerInState");
        Intrinsics.checkNotNullParameter(function1, "onReceive");
        CoroutinesKt.runHandling$default((Function1) null, new BroadcastsKt$registerToBroadcast$1(fragment, str, state, function1), 1, (Object) null);
    }

    public static /* synthetic */ void registerToBroadcast$default(Fragment fragment, String str, Lifecycle.State state, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            state = Lifecycle.State.CREATED;
        }
        registerToBroadcast(fragment, str, state, (Function1<? super Intent, Unit>) function1);
    }

    /* access modifiers changed from: private */
    public static final DefaultLifecycleObserver registrationObserver(String str, Lifecycle.State state, Context context, BroadcastReceiver broadcastReceiver) {
        return new BroadcastsKt$registrationObserver$1(state, context, broadcastReceiver, str);
    }

    @BroadcastsDsl
    public static final void sendBroadcast(@NotNull String str, @NotNull Pair<String, ? extends Serializable>... pairArr) {
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(pairArr, "extras");
        CoroutinesKt.runHandling$default((Function1) null, new BroadcastsKt$sendBroadcast$1(str, pairArr), 1, (Object) null);
    }

    @BroadcastsDsl
    public static final void registerToBroadcast(@NotNull FragmentActivity fragmentActivity, @NotNull String str, @NotNull Lifecycle.State state, @NotNull Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(state, "registerInState");
        Intrinsics.checkNotNullParameter(function1, "onReceive");
        CoroutinesKt.runHandling$default((Function1) null, new BroadcastsKt$registerToBroadcast$2(fragmentActivity, str, state, function1), 1, (Object) null);
    }

    @BroadcastsDsl
    public static final void sendBroadcast(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        CoroutinesKt.runHandling$default((Function1) null, new BroadcastsKt$sendBroadcast$2(intent), 1, (Object) null);
    }

    public static /* synthetic */ void registerToBroadcast$default(FragmentActivity fragmentActivity, String str, Lifecycle.State state, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            state = Lifecycle.State.CREATED;
        }
        registerToBroadcast(fragmentActivity, str, state, (Function1<? super Intent, Unit>) function1);
    }
}
