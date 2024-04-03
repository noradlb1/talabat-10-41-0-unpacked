package io.flutter.plugins.webviewflutter;

import android.webkit.GeolocationPermissions;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class GeolocationPermissionsCallbackHostApiImpl implements GeneratedAndroidWebView.GeolocationPermissionsCallbackHostApi {
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public GeolocationPermissionsCallbackHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
    }

    private GeolocationPermissions.Callback getGeolocationPermissionsCallbackInstance(@NonNull Long l11) {
        GeolocationPermissions.Callback callback = (GeolocationPermissions.Callback) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(callback);
        return callback;
    }

    public void invoke(@NonNull Long l11, @NonNull String str, @NonNull Boolean bool, @NonNull Boolean bool2) {
        getGeolocationPermissionsCallbackInstance(l11).invoke(str, bool.booleanValue(), bool2.booleanValue());
    }
}
