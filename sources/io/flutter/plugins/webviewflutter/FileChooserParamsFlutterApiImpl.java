package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Arrays;

@RequiresApi(api = 21)
public class FileChooserParamsFlutterApiImpl extends GeneratedAndroidWebView.FileChooserParamsFlutterApi {
    private final InstanceManager instanceManager;

    public FileChooserParamsFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager2) {
        super(binaryMessenger);
        this.instanceManager = instanceManager2;
    }

    private static GeneratedAndroidWebView.FileChooserMode toFileChooserEnumData(int i11) {
        if (i11 == 0) {
            return GeneratedAndroidWebView.FileChooserMode.OPEN;
        }
        if (i11 == 1) {
            return GeneratedAndroidWebView.FileChooserMode.OPEN_MULTIPLE;
        }
        if (i11 == 3) {
            return GeneratedAndroidWebView.FileChooserMode.SAVE;
        }
        throw new IllegalArgumentException(String.format("Unsupported FileChooserMode: %d", new Object[]{Integer.valueOf(i11)}));
    }

    public void create(@NonNull WebChromeClient.FileChooserParams fileChooserParams, @NonNull GeneratedAndroidWebView.FileChooserParamsFlutterApi.Reply<Void> reply) {
        if (!this.instanceManager.containsInstance(fileChooserParams)) {
            create(Long.valueOf(this.instanceManager.addHostCreatedInstance(fileChooserParams)), Boolean.valueOf(fileChooserParams.isCaptureEnabled()), Arrays.asList(fileChooserParams.getAcceptTypes()), toFileChooserEnumData(fileChooserParams.getMode()), fileChooserParams.getFilenameHint(), reply);
        }
    }
}
