package io.flutter.embedding.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.ArrayList;
import java.util.List;

public class FlutterEngineGroup {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final List<FlutterEngine> f14169a;

    public static class Options {
        private boolean automaticallyRegisterPlugins = true;
        @NonNull
        private Context context;
        @Nullable
        private DartExecutor.DartEntrypoint dartEntrypoint;
        @Nullable
        private List<String> dartEntrypointArgs;
        @Nullable
        private String initialRoute;
        @NonNull
        private PlatformViewsController platformViewsController;
        private boolean waitForRestorationData = false;

        public Options(@NonNull Context context2) {
            this.context = context2;
        }

        public boolean getAutomaticallyRegisterPlugins() {
            return this.automaticallyRegisterPlugins;
        }

        public Context getContext() {
            return this.context;
        }

        public DartExecutor.DartEntrypoint getDartEntrypoint() {
            return this.dartEntrypoint;
        }

        public List<String> getDartEntrypointArgs() {
            return this.dartEntrypointArgs;
        }

        public String getInitialRoute() {
            return this.initialRoute;
        }

        public PlatformViewsController getPlatformViewsController() {
            return this.platformViewsController;
        }

        public boolean getWaitForRestorationData() {
            return this.waitForRestorationData;
        }

        public Options setAutomaticallyRegisterPlugins(boolean z11) {
            this.automaticallyRegisterPlugins = z11;
            return this;
        }

        public Options setDartEntrypoint(DartExecutor.DartEntrypoint dartEntrypoint2) {
            this.dartEntrypoint = dartEntrypoint2;
            return this;
        }

        public Options setDartEntrypointArgs(List<String> list) {
            this.dartEntrypointArgs = list;
            return this;
        }

        public Options setInitialRoute(String str) {
            this.initialRoute = str;
            return this;
        }

        public Options setPlatformViewsController(@NonNull PlatformViewsController platformViewsController2) {
            this.platformViewsController = platformViewsController2;
            return this;
        }

        public Options setWaitForRestorationData(boolean z11) {
            this.waitForRestorationData = z11;
            return this;
        }
    }

    public FlutterEngineGroup(@NonNull Context context) {
        this(context, (String[]) null);
    }

    @VisibleForTesting
    public FlutterEngine a(Context context, @NonNull PlatformViewsController platformViewsController, boolean z11, boolean z12) {
        return new FlutterEngine(context, (FlutterLoader) null, (FlutterJNI) null, platformViewsController, (String[]) null, z11, z12);
    }

    public FlutterEngine createAndRunDefaultEngine(@NonNull Context context) {
        return createAndRunEngine(context, (DartExecutor.DartEntrypoint) null);
    }

    public FlutterEngine createAndRunEngine(@NonNull Context context, @Nullable DartExecutor.DartEntrypoint dartEntrypoint) {
        return createAndRunEngine(context, dartEntrypoint, (String) null);
    }

    public FlutterEngineGroup(@NonNull Context context, @Nullable String[] strArr) {
        this.f14169a = new ArrayList();
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        if (!flutterLoader.initialized()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context.getApplicationContext(), strArr);
        }
    }

    public FlutterEngine createAndRunEngine(@NonNull Context context, @Nullable DartExecutor.DartEntrypoint dartEntrypoint, @Nullable String str) {
        return createAndRunEngine(new Options(context).setDartEntrypoint(dartEntrypoint).setInitialRoute(str));
    }

    public FlutterEngine createAndRunEngine(@NonNull Options options) {
        final FlutterEngine flutterEngine;
        Context context = options.getContext();
        DartExecutor.DartEntrypoint dartEntrypoint = options.getDartEntrypoint();
        String initialRoute = options.getInitialRoute();
        List<String> dartEntrypointArgs = options.getDartEntrypointArgs();
        PlatformViewsController platformViewsController = options.getPlatformViewsController();
        if (platformViewsController == null) {
            platformViewsController = new PlatformViewsController();
        }
        PlatformViewsController platformViewsController2 = platformViewsController;
        boolean automaticallyRegisterPlugins = options.getAutomaticallyRegisterPlugins();
        boolean waitForRestorationData = options.getWaitForRestorationData();
        DartExecutor.DartEntrypoint createDefault = dartEntrypoint == null ? DartExecutor.DartEntrypoint.createDefault() : dartEntrypoint;
        if (this.f14169a.size() == 0) {
            flutterEngine = a(context, platformViewsController2, automaticallyRegisterPlugins, waitForRestorationData);
            if (initialRoute != null) {
                flutterEngine.getNavigationChannel().setInitialRoute(initialRoute);
            }
            flutterEngine.getDartExecutor().executeDartEntrypoint(createDefault, dartEntrypointArgs);
        } else {
            flutterEngine = this.f14169a.get(0).d(context, createDefault, initialRoute, dartEntrypointArgs, platformViewsController2, automaticallyRegisterPlugins, waitForRestorationData);
        }
        this.f14169a.add(flutterEngine);
        flutterEngine.addEngineLifecycleListener(new FlutterEngine.EngineLifecycleListener() {
            public void onEngineWillDestroy() {
                FlutterEngineGroup.this.f14169a.remove(flutterEngine);
            }

            public void onPreEngineRestart() {
            }
        });
        return flutterEngine;
    }
}
