package io.flutter.plugins.webviewflutter;

import androidx.annotation.NonNull;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlutterAssetManagerHostApiImpl implements GeneratedAndroidWebView.FlutterAssetManagerHostApi {

    /* renamed from: a  reason: collision with root package name */
    public final FlutterAssetManager f14411a;

    public FlutterAssetManagerHostApiImpl(@NonNull FlutterAssetManager flutterAssetManager) {
        this.f14411a = flutterAssetManager;
    }

    @NonNull
    public String getAssetFilePathByName(@NonNull String str) {
        return this.f14411a.getAssetFilePathByName(str);
    }

    @NonNull
    public List<String> list(@NonNull String str) {
        try {
            String[] list = this.f14411a.list(str);
            if (list == null) {
                return new ArrayList();
            }
            return Arrays.asList(list);
        } catch (IOException e11) {
            throw new RuntimeException(e11.getMessage());
        }
    }
}
