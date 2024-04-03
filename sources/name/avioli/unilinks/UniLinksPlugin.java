package name.avioli.unilinks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public class UniLinksPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, EventChannel.StreamHandler, ActivityAware, PluginRegistry.NewIntentListener {
    private static final String EVENTS_CHANNEL = "uni_links/events";
    private static final String MESSAGES_CHANNEL = "uni_links/messages";
    private BroadcastReceiver changeReceiver;
    private Context context;
    private boolean initialIntent = true;
    private String initialLink;
    private String latestLink;

    @NonNull
    private BroadcastReceiver createChangeReceiver(final EventChannel.EventSink eventSink) {
        return new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String dataString = intent.getDataString();
                if (dataString == null) {
                    eventSink.error("UNAVAILABLE", "Link unavailable", (Object) null);
                } else {
                    eventSink.success(dataString);
                }
            }
        };
    }

    private void handleIntent(Context context2, Intent intent) {
        String action = intent.getAction();
        String dataString = intent.getDataString();
        if ("android.intent.action.VIEW".equals(action)) {
            if (this.initialIntent) {
                this.initialLink = dataString;
                this.initialIntent = false;
            }
            this.latestLink = dataString;
            BroadcastReceiver broadcastReceiver = this.changeReceiver;
            if (broadcastReceiver != null) {
                broadcastReceiver.onReceive(context2, intent);
            }
        }
    }

    private static void register(BinaryMessenger binaryMessenger, UniLinksPlugin uniLinksPlugin) {
        new MethodChannel(binaryMessenger, MESSAGES_CHANNEL).setMethodCallHandler(uniLinksPlugin);
        new EventChannel(binaryMessenger, EVENTS_CHANNEL).setStreamHandler(uniLinksPlugin);
    }

    public static void registerWith(@NonNull PluginRegistry.Registrar registrar) {
        if (registrar.activity() != null) {
            UniLinksPlugin uniLinksPlugin = new UniLinksPlugin();
            uniLinksPlugin.context = registrar.context();
            register(registrar.messenger(), uniLinksPlugin);
            uniLinksPlugin.handleIntent(registrar.context(), registrar.activity().getIntent());
            registrar.addNewIntentListener(uniLinksPlugin);
        }
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        handleIntent(this.context, activityPluginBinding.getActivity().getIntent());
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.context = flutterPluginBinding.getApplicationContext();
        register(flutterPluginBinding.getBinaryMessenger(), this);
    }

    public void onCancel(Object obj) {
        this.changeReceiver = null;
    }

    public void onDetachedFromActivity() {
    }

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.changeReceiver = createChangeReceiver(eventSink);
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("getInitialLink")) {
            result.success(this.initialLink);
        } else if (methodCall.method.equals("getLatestLink")) {
            result.success(this.latestLink);
        } else {
            result.notImplemented();
        }
    }

    public boolean onNewIntent(Intent intent) {
        handleIntent(this.context, intent);
        return false;
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        handleIntent(this.context, activityPluginBinding.getActivity().getIntent());
    }
}
