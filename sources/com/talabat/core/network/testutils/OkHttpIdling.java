package com.talabat.core.network.testutils;

import androidx.annotation.CheckResult;
import androidx.test.espresso.IdlingResource;
import hh.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/core/network/testutils/OkHttpIdling;", "Landroidx/test/espresso/IdlingResource;", "name", "", "dispatcher", "Lokhttp3/Dispatcher;", "(Ljava/lang/String;Lokhttp3/Dispatcher;)V", "callback", "Landroidx/test/espresso/IdlingResource$ResourceCallback;", "getCallback", "()Landroidx/test/espresso/IdlingResource$ResourceCallback;", "setCallback", "(Landroidx/test/espresso/IdlingResource$ResourceCallback;)V", "getName", "isIdleNow", "", "registerIdleTransitionCallback", "", "Companion", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OkHttpIdling implements IdlingResource {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private volatile IdlingResource.ResourceCallback callback;
    @NotNull
    private final Dispatcher dispatcher;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f55958name;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/core/network/testutils/OkHttpIdling$Companion;", "", "()V", "create", "Lcom/talabat/core/network/testutils/OkHttpIdling;", "name", "", "client", "Lokhttp3/OkHttpClient;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @CheckResult
        @NotNull
        public final OkHttpIdling create(@Nullable String str, @Nullable OkHttpClient okHttpClient) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (okHttpClient != null) {
                return new OkHttpIdling(str, okHttpClient.dispatcher(), (DefaultConstructorMarker) null);
            } else {
                throw new NullPointerException("client == null");
            }
        }
    }

    private OkHttpIdling(String str, Dispatcher dispatcher2) {
        this.f55958name = str;
        this.dispatcher = dispatcher2;
        dispatcher2.setIdleCallback(new a(this));
    }

    public /* synthetic */ OkHttpIdling(String str, Dispatcher dispatcher2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, dispatcher2);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m9611_init_$lambda0(OkHttpIdling okHttpIdling) {
        Intrinsics.checkNotNullParameter(okHttpIdling, "this$0");
        IdlingResource.ResourceCallback resourceCallback = okHttpIdling.callback;
        if (resourceCallback != null) {
            resourceCallback.onTransitionToIdle();
        }
    }

    @Nullable
    public final IdlingResource.ResourceCallback getCallback() {
        return this.callback;
    }

    @NotNull
    public String getName() {
        return this.f55958name;
    }

    public boolean isIdleNow() {
        boolean z11;
        IdlingResource.ResourceCallback resourceCallback;
        if (this.dispatcher.runningCallsCount() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!(!z11 || this.callback == null || (resourceCallback = this.callback) == null)) {
            resourceCallback.onTransitionToIdle();
        }
        return z11;
    }

    public void registerIdleTransitionCallback(@NotNull IdlingResource.ResourceCallback resourceCallback) {
        Intrinsics.checkNotNullParameter(resourceCallback, "callback");
        this.callback = resourceCallback;
    }

    public final void setCallback(@Nullable IdlingResource.ResourceCallback resourceCallback) {
        this.callback = resourceCallback;
    }
}
