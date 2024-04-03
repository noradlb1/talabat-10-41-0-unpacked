package com.deliveryhero.chatui.view.chatroom.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.deliveryhero.customerchat.commons.SDKUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&J\b\u0010\u0007\u001a\u00020\u0004H&R\u001a\u0010\t\u001a\u00020\b8\u0004X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u00038DX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\u0016\u0001\u0002 !¨\u0006\""}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/connectivity/ConnectivityMonitor;", "", "Lkotlin/Function1;", "", "", "callback", "startListening", "stopListening", "Landroid/net/ConnectivityManager;", "connectivityManager", "Landroid/net/ConnectivityManager;", "b", "()Landroid/net/ConnectivityManager;", "callbackFunction", "Lkotlin/jvm/functions/Function1;", "a", "()Lkotlin/jvm/functions/Function1;", "e", "(Lkotlin/jvm/functions/Function1;)V", "isNetworkAvailable", "Z", "c", "()Z", "f", "(Z)V", "d", "isNetworkConnected$annotations", "()V", "isNetworkConnected", "<init>", "(Landroid/net/ConnectivityManager;)V", "Companion", "Lcom/deliveryhero/chatui/view/chatroom/connectivity/LegacyConnectivityMonitor;", "Lcom/deliveryhero/chatui/view/chatroom/connectivity/NougatConnectivityMonitor;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0})
public abstract class ConnectivityMonitor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private Function1<? super Boolean, Unit> callbackFunction;
    @NotNull
    private final ConnectivityManager connectivityManager;
    private boolean isNetworkAvailable;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/connectivity/ConnectivityMonitor$Companion;", "", "()V", "getInstance", "Lcom/deliveryhero/chatui/view/chatroom/connectivity/ConnectivityMonitor;", "context", "Landroid/content/Context;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConnectivityMonitor getInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                if (SDKUtil.INSTANCE.getSDKVersion() >= 24) {
                    return new NougatConnectivityMonitor(connectivityManager);
                }
                return new LegacyConnectivityMonitor(context, connectivityManager);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }

    private ConnectivityMonitor(ConnectivityManager connectivityManager2) {
        this.connectivityManager = connectivityManager2;
        this.callbackFunction = ConnectivityMonitor$callbackFunction$1.INSTANCE;
    }

    public /* synthetic */ ConnectivityMonitor(ConnectivityManager connectivityManager2, DefaultConstructorMarker defaultConstructorMarker) {
        this(connectivityManager2);
    }

    @NotNull
    public final Function1<Boolean, Unit> a() {
        return this.callbackFunction;
    }

    @NotNull
    public final ConnectivityManager b() {
        return this.connectivityManager;
    }

    public final boolean c() {
        return this.isNetworkAvailable;
    }

    public final boolean d() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void e(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.callbackFunction = function1;
    }

    public final void f(boolean z11) {
        this.isNetworkAvailable = z11;
    }

    public abstract void startListening(@NotNull Function1<? super Boolean, Unit> function1);

    public abstract void stopListening();
}
