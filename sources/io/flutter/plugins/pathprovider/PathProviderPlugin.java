package io.flutter.plugins.pathprovider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import b00.a;
import b00.b;
import b00.c;
import b00.d;
import b00.e;
import b00.f;
import b00.g;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.util.PathUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PathProviderPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private MethodChannel channel;
    private Context context;
    private final Executor executor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat("path-provider-background-%d").setPriority(5).build());
    private final Executor uiThreadExecutor = new UiThreadExecutor();

    public static class UiThreadExecutor implements Executor {
        private final Handler handler;

        private UiThreadExecutor() {
            this.handler = new Handler(Looper.getMainLooper());
        }

        public void execute(Runnable runnable) {
            this.handler.post(runnable);
        }
    }

    private <T> void executeInBackground(Callable<T> callable, final MethodChannel.Result result) {
        SettableFuture create = SettableFuture.create();
        Futures.addCallback(create, new FutureCallback<T>() {
            public void onFailure(Throwable th2) {
                result.error(th2.getClass().getName(), th2.getMessage(), (Object) null);
            }

            public void onSuccess(T t11) {
                result.success(t11);
            }
        }, this.uiThreadExecutor);
        this.executor.execute(new a(create, callable));
    }

    /* access modifiers changed from: private */
    /* renamed from: getApplicationSupportDirectory */
    public String lambda$onMethodCall$6() {
        return PathUtils.getFilesDir(this.context);
    }

    /* access modifiers changed from: private */
    /* renamed from: getPathProviderApplicationDocumentsDirectory */
    public String lambda$onMethodCall$2() {
        return PathUtils.getDataDirectory(this.context);
    }

    /* access modifiers changed from: private */
    /* renamed from: getPathProviderExternalCacheDirectories */
    public List<String> lambda$onMethodCall$4() {
        ArrayList arrayList = new ArrayList();
        for (File file : this.context.getExternalCacheDirs()) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getPathProviderExternalStorageDirectories */
    public List<String> lambda$onMethodCall$5(String str) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.context.getExternalFilesDirs(str)) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getPathProviderStorageDirectory */
    public String lambda$onMethodCall$3() {
        File externalFilesDir = this.context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    /* access modifiers changed from: private */
    /* renamed from: getPathProviderTemporaryDirectory */
    public String lambda$onMethodCall$1() {
        return this.context.getCacheDir().getPath();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$executeInBackground$0(SettableFuture settableFuture, Callable callable) {
        try {
            settableFuture.set(callable.call());
        } catch (Throwable th2) {
            settableFuture.setException(th2);
        }
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        PathProviderPlugin pathProviderPlugin = new PathProviderPlugin();
        pathProviderPlugin.channel = new MethodChannel(registrar.messenger(), "plugins.flutter.io/path_provider");
        pathProviderPlugin.context = registrar.context();
        pathProviderPlugin.channel.setMethodCallHandler(pathProviderPlugin);
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "plugins.flutter.io/path_provider");
        this.context = flutterPluginBinding.getApplicationContext();
        this.channel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.channel = null;
    }

    public void onMethodCall(MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1832373352:
                if (str.equals("getApplicationSupportDirectory")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1208689078:
                if (str.equals("getExternalCacheDirectories")) {
                    c11 = 1;
                    break;
                }
                break;
            case 299667825:
                if (str.equals("getExternalStorageDirectories")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1200320591:
                if (str.equals("getApplicationDocumentsDirectory")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1252916648:
                if (str.equals("getStorageDirectory")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1711844626:
                if (str.equals("getTemporaryDirectory")) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                executeInBackground(new g(this), result);
                return;
            case 1:
                executeInBackground(new e(this), result);
                return;
            case 2:
                executeInBackground(new f(this, StorageDirectoryMapper.a((Integer) methodCall.argument("type"))), result);
                return;
            case 3:
                executeInBackground(new c(this), result);
                return;
            case 4:
                executeInBackground(new d(this), result);
                return;
            case 5:
                executeInBackground(new b(this), result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
