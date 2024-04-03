package com.jaumard.smsautofill;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsAutoFillPlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    private static final int PHONE_HINT_REQUEST = 11012;
    private static final String channelName = "sms_autofill";
    /* access modifiers changed from: private */
    public Activity activity;
    private final PluginRegistry.ActivityResultListener activityResultListener;
    /* access modifiers changed from: private */
    public SmsBroadcastReceiver broadcastReceiver;
    private MethodChannel channel;
    /* access modifiers changed from: private */
    public MethodChannel.Result pendingHintResult;

    public static class SmsBroadcastReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<SmsAutoFillPlugin> f52694a;

        /* renamed from: b  reason: collision with root package name */
        public final String f52695b;

        public void onReceive(Context context, Intent intent) {
            Status status;
            if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction()) && this.f52694a.get() != null) {
                this.f52694a.get().activity.unregisterReceiver(this);
                Bundle extras = intent.getExtras();
                if (extras != null && (status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")) != null && status.getStatusCode() == 0) {
                    String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                    Pattern compile = Pattern.compile(this.f52695b);
                    if (str != null) {
                        Matcher matcher = compile.matcher(str);
                        if (matcher.find()) {
                            this.f52694a.get().setCode(matcher.group(0));
                        } else {
                            this.f52694a.get().setCode(str);
                        }
                    }
                }
            }
        }

        private SmsBroadcastReceiver(WeakReference<SmsAutoFillPlugin> weakReference, String str) {
            this.f52694a = weakReference;
            this.f52695b = str;
        }
    }

    public SmsAutoFillPlugin() {
        this.activityResultListener = new PluginRegistry.ActivityResultListener() {
            public boolean onActivityResult(int i11, int i12, Intent intent) {
                if (i11 != SmsAutoFillPlugin.PHONE_HINT_REQUEST || SmsAutoFillPlugin.this.pendingHintResult == null) {
                    return false;
                }
                if (i12 != -1 || intent == null) {
                    SmsAutoFillPlugin.this.pendingHintResult.success((Object) null);
                    return true;
                }
                SmsAutoFillPlugin.this.pendingHintResult.success(((Credential) intent.getParcelableExtra(Credential.EXTRA_KEY)).getId());
                return true;
            }
        };
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new SmsAutoFillPlugin(registrar);
    }

    @TargetApi(5)
    private void requestHint() {
        if (!isSimSupport()) {
            MethodChannel.Result result = this.pendingHintResult;
            if (result != null) {
                result.success((Object) null);
                return;
            }
            return;
        }
        HintRequest build = new HintRequest.Builder().setPhoneNumberIdentifierSupported(true).build();
        try {
            this.activity.startIntentSenderForResult(Auth.CredentialsApi.getHintPickerIntent(new GoogleApiClient.Builder(this.activity).addApi(Auth.CREDENTIALS_API).build(), build).getIntentSender(), PHONE_HINT_REQUEST, (Intent) null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e11) {
            e11.printStackTrace();
        }
    }

    private void setupChannel(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, channelName);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* access modifiers changed from: private */
    public void unregisterReceiver() {
        SmsBroadcastReceiver smsBroadcastReceiver = this.broadcastReceiver;
        if (smsBroadcastReceiver != null) {
            try {
                this.activity.unregisterReceiver(smsBroadcastReceiver);
            } catch (Exception unused) {
            }
            this.broadcastReceiver = null;
        }
    }

    public boolean isSimSupport() {
        if (((TelephonyManager) this.activity.getSystemService("phone")).getSimState() != 1) {
            return true;
        }
        return false;
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        this.activity = activityPluginBinding.getActivity();
        activityPluginBinding.addActivityResultListener(this.activityResultListener);
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        setupChannel(flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromActivity() {
        unregisterReceiver();
    }

    public void onDetachedFromActivityForConfigChanges() {
        unregisterReceiver();
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        unregisterReceiver();
    }

    public void onMethodCall(MethodCall methodCall, @NonNull final MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1213403505:
                if (str.equals("listenForCode")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1037975280:
                if (str.equals("unregisterListener")) {
                    c11 = 1;
                    break;
                }
                break;
            case 115451405:
                if (str.equals("getAppSignature")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1920911174:
                if (str.equals("requestPhoneHint")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                final String str2 = (String) methodCall.argument("smsCodeRegexPattern");
                Task<Void> startSmsRetriever = SmsRetriever.getClient(this.activity).startSmsRetriever();
                startSmsRetriever.addOnSuccessListener(new OnSuccessListener<Void>() {
                    public void onSuccess(Void voidR) {
                        SmsAutoFillPlugin.this.unregisterReceiver();
                        SmsBroadcastReceiver unused = SmsAutoFillPlugin.this.broadcastReceiver = new SmsBroadcastReceiver(new WeakReference(SmsAutoFillPlugin.this), str2);
                        SmsAutoFillPlugin.this.activity.registerReceiver(SmsAutoFillPlugin.this.broadcastReceiver, new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION));
                        result.success((Object) null);
                    }
                });
                startSmsRetriever.addOnFailureListener(new OnFailureListener() {
                    public void onFailure(@NonNull Exception exc) {
                        result.error("ERROR_START_SMS_RETRIEVER", "Can't start sms retriever", (Object) null);
                    }
                });
                return;
            case 1:
                unregisterReceiver();
                result.success("successfully unregister receiver");
                return;
            case 2:
                result.success(new AppSignatureHelper(this.activity.getApplicationContext()).getAppSignature());
                return;
            case 3:
                this.pendingHintResult = result;
                requestHint();
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        this.activity = activityPluginBinding.getActivity();
        activityPluginBinding.addActivityResultListener(this.activityResultListener);
    }

    public void setCode(String str) {
        this.channel.invokeMethod("smscode", str);
    }

    private SmsAutoFillPlugin(PluginRegistry.Registrar registrar) {
        AnonymousClass1 r02 = new PluginRegistry.ActivityResultListener() {
            public boolean onActivityResult(int i11, int i12, Intent intent) {
                if (i11 != SmsAutoFillPlugin.PHONE_HINT_REQUEST || SmsAutoFillPlugin.this.pendingHintResult == null) {
                    return false;
                }
                if (i12 != -1 || intent == null) {
                    SmsAutoFillPlugin.this.pendingHintResult.success((Object) null);
                    return true;
                }
                SmsAutoFillPlugin.this.pendingHintResult.success(((Credential) intent.getParcelableExtra(Credential.EXTRA_KEY)).getId());
                return true;
            }
        };
        this.activityResultListener = r02;
        this.activity = registrar.activity();
        setupChannel(registrar.messenger());
        registrar.addActivityResultListener(r02);
    }
}
