package flutter.plugins.vibrate;

import android.content.Context;
import android.os.Vibrator;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

public class VibratePlugin implements FlutterPlugin {
    private MethodChannel methodChannel;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        VibrateMethodCallHandler vibrateMethodCallHandler = new VibrateMethodCallHandler((Vibrator) applicationContext.getSystemService("vibrator"));
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, "vibrate");
        this.methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(vibrateMethodCallHandler);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.methodChannel = null;
    }
}
