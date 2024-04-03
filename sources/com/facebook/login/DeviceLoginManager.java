package com.facebook.login;

import android.net.Uri;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.LoginClient;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/DeviceLoginManager;", "Lcom/facebook/login/LoginManager;", "()V", "deviceAuthTargetUserId", "", "getDeviceAuthTargetUserId", "()Ljava/lang/String;", "setDeviceAuthTargetUserId", "(Ljava/lang/String;)V", "deviceRedirectUri", "Landroid/net/Uri;", "getDeviceRedirectUri", "()Landroid/net/Uri;", "setDeviceRedirectUri", "(Landroid/net/Uri;)V", "createLoginRequest", "Lcom/facebook/login/LoginClient$Request;", "permissions", "", "Companion", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class DeviceLoginManager extends LoginManager {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<DeviceLoginManager> instance$delegate = LazyKt__LazyJVMKt.lazy(DeviceLoginManager$Companion$instance$2.INSTANCE);
    @Nullable
    private String deviceAuthTargetUserId;
    @Nullable
    private Uri deviceRedirectUri;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/login/DeviceLoginManager$Companion;", "", "()V", "instance", "Lcom/facebook/login/DeviceLoginManager;", "getInstance", "()Lcom/facebook/login/DeviceLoginManager;", "instance$delegate", "Lkotlin/Lazy;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "instance", "getInstance()Lcom/facebook/login/DeviceLoginManager;"))};

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DeviceLoginManager getInstance() {
            return (DeviceLoginManager) DeviceLoginManager.instance$delegate.getValue();
        }
    }

    @NotNull
    public LoginClient.Request createLoginRequest(@Nullable Collection<String> collection) {
        LoginClient.Request createLoginRequest = super.createLoginRequest(collection);
        Uri uri = this.deviceRedirectUri;
        if (uri != null) {
            createLoginRequest.setDeviceRedirectUriString(uri.toString());
        }
        String str = this.deviceAuthTargetUserId;
        if (str != null) {
            createLoginRequest.setDeviceAuthTargetUserId(str);
        }
        return createLoginRequest;
    }

    @Nullable
    public final String getDeviceAuthTargetUserId() {
        return this.deviceAuthTargetUserId;
    }

    @Nullable
    public final Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    public final void setDeviceAuthTargetUserId(@Nullable String str) {
        this.deviceAuthTargetUserId = str;
    }

    public final void setDeviceRedirectUri(@Nullable Uri uri) {
        this.deviceRedirectUri = uri;
    }
}
