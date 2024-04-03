package com.pichillilorenzo.flutter_inappwebview.in_app_webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.MimeTypeMap;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.ViewCompat;
import com.deliveryhero.chatui.data.datasource.ImageFileProviderImpl;
import com.facebook.internal.NativeProtocol;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.in_app_browser.ActivityResultListener;
import com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate;
import com.pichillilorenzo.flutter_inappwebview.types.CreateWindowAction;
import com.pichillilorenzo.flutter_inappwebview.types.URLRequest;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class InAppWebViewChromeClient extends WebChromeClient implements PluginRegistry.ActivityResultListener, ActivityResultListener {
    protected static final FrameLayout.LayoutParams FULLSCREEN_LAYOUT_PARAMS = new FrameLayout.LayoutParams(-1, -1, 17);
    protected static final int FULLSCREEN_SYSTEM_UI_VISIBILITY = 1798;
    protected static final int FULLSCREEN_SYSTEM_UI_VISIBILITY_KITKAT = 7942;
    protected static final String LOG_TAG = "IABWebChromeClient";
    private static final int PICKER = 1;
    private static final int PICKER_LEGACY = 3;
    private static final String fileProviderAuthorityExtension = "flutter_inappwebview.fileprovider";
    private static Uri imageOutputFileUri;
    private static Uri videoOutputFileUri;
    private static int windowAutoincrementId = 0;
    public static Map<Integer, Message> windowWebViewMessages = new HashMap();
    final String DEFAULT_MIME_TYPES = "*/*";
    private final MethodChannel channel;
    private InAppBrowserDelegate inAppBrowserDelegate;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private int mOriginalOrientation;
    private int mOriginalSystemUiVisibility;
    public InAppWebViewFlutterPlugin plugin;

    public InAppWebViewChromeClient(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, MethodChannel methodChannel, InAppBrowserDelegate inAppBrowserDelegate2) {
        this.plugin = inAppWebViewFlutterPlugin;
        this.channel = methodChannel;
        this.inAppBrowserDelegate = inAppBrowserDelegate2;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.getActivityResultListeners().add(this);
        }
        PluginRegistry.Registrar registrar = inAppWebViewFlutterPlugin.registrar;
        if (registrar != null) {
            registrar.addActivityResultListener(this);
            return;
        }
        ActivityPluginBinding activityPluginBinding = inAppWebViewFlutterPlugin.activityPluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this);
        }
    }

    private Boolean acceptsAny(String[] strArr) {
        if (isArrayEmpty(strArr).booleanValue()) {
            return Boolean.TRUE;
        }
        for (String equals : strArr) {
            if (equals.equals("*/*")) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private Boolean acceptsImages(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains("image"));
    }

    private Boolean acceptsImages(String[] strArr) {
        return Boolean.valueOf(acceptsAny(strArr).booleanValue() || arrayContainsString(getAcceptedMimeType(strArr), "image").booleanValue());
    }

    private Boolean acceptsVideo(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains("video"));
    }

    private Boolean acceptsVideo(String[] strArr) {
        return Boolean.valueOf(acceptsAny(strArr).booleanValue() || arrayContainsString(getAcceptedMimeType(strArr), "video").booleanValue());
    }

    private Boolean arrayContainsString(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2 != null && str2.contains(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private String[] getAcceptedMimeType(String[] strArr) {
        if (isArrayEmpty(strArr).booleanValue()) {
            return new String[]{"*/*"};
        }
        String[] strArr2 = new String[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            String str = strArr[i11];
            if (str.matches("\\.\\w+")) {
                strArr2[i11] = getMimeTypeFromExtension(str.replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, ""));
            } else {
                strArr2[i11] = str;
            }
        }
        return strArr2;
    }

    private Activity getActivity() {
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            return inAppBrowserDelegate2.getActivity();
        }
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (inAppWebViewFlutterPlugin != null) {
            return inAppWebViewFlutterPlugin.activity;
        }
        return null;
    }

    private File getCapturedFile(String str) {
        String str2;
        String str3;
        if (str.equals("android.media.action.IMAGE_CAPTURE")) {
            String str4 = Environment.DIRECTORY_PICTURES;
            str2 = "image";
            str3 = ImageFileProviderImpl.IMAGE_SUFFIX;
        } else if (str.equals("android.media.action.VIDEO_CAPTURE")) {
            String str5 = Environment.DIRECTORY_MOVIES;
            str2 = "video";
            str3 = ".mp4";
        } else {
            str2 = "";
            str3 = str2;
        }
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return File.createTempFile(str2, str3, activity.getApplicationContext().getExternalFilesDir((String) null));
    }

    private Uri getCapturedMediaFile() {
        Uri uri = imageOutputFileUri;
        if (uri != null && isFileNotEmpty(uri)) {
            return imageOutputFileUri;
        }
        Uri uri2 = videoOutputFileUri;
        if (uri2 == null || !isFileNotEmpty(uri2)) {
            return null;
        }
        return videoOutputFileUri;
    }

    private Intent getFileChooserIntent(String str) {
        String str2 = str.isEmpty() ? "*/*" : str;
        if (str.matches("\\.\\w+")) {
            str2 = getMimeTypeFromExtension(str.replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, ""));
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str2);
        return intent;
    }

    private Intent getFileChooserIntent(String[] strArr, boolean z11) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", getAcceptedMimeType(strArr));
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z11);
        return intent;
    }

    private String getMimeTypeFromExtension(String str) {
        if (str != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        return null;
    }

    private Uri getOutputUri(String str) {
        File file;
        try {
            file = getCapturedFile(str);
        } catch (IOException e11) {
            Log.e(LOG_TAG, "Error occurred while creating the File", e11);
            e11.printStackTrace();
            file = null;
        }
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        String packageName = activity.getApplicationContext().getPackageName();
        return FileProvider.getUriForFile(activity.getApplicationContext(), packageName + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + fileProviderAuthorityExtension, file);
    }

    private Intent getPhotoIntent() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri outputUri = getOutputUri("android.media.action.IMAGE_CAPTURE");
        imageOutputFileUri = outputUri;
        intent.putExtra("output", outputUri);
        return intent;
    }

    private Uri[] getSelectedFiles(Intent intent, int i11) {
        if (intent == null || intent.getData() == null) {
            if (intent == null || intent.getClipData() == null) {
                Uri capturedMediaFile = getCapturedMediaFile();
                if (capturedMediaFile == null) {
                    return null;
                }
                return new Uri[]{capturedMediaFile};
            }
            int itemCount = intent.getClipData().getItemCount();
            Uri[] uriArr = new Uri[itemCount];
            for (int i12 = 0; i12 < itemCount; i12++) {
                uriArr[i12] = intent.getClipData().getItemAt(i12).getUri();
            }
            return uriArr;
        } else if (i11 == -1) {
            return WebChromeClient.FileChooserParams.parseResult(i11, intent);
        } else {
            return null;
        }
    }

    private Intent getVideoIntent() {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        Uri outputUri = getOutputUri("android.media.action.VIDEO_CAPTURE");
        videoOutputFileUri = outputUri;
        intent.putExtra("output", outputUri);
        return intent;
    }

    private Boolean isArrayEmpty(String[] strArr) {
        boolean z11 = true;
        if (!(strArr.length == 0 || (strArr.length == 1 && strArr[0].length() == 0))) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    private boolean isFileNotEmpty(Uri uri) {
        Activity activity = getActivity();
        if (activity == null) {
            return false;
        }
        try {
            AssetFileDescriptor openAssetFileDescriptor = activity.getContentResolver().openAssetFileDescriptor(uri, "r");
            long length = openAssetFileDescriptor.getLength();
            openAssetFileDescriptor.close();
            return length > 0;
        } catch (IOException unused) {
            return false;
        }
    }

    public void createAlertDialog(WebView webView, String str, final JsResult jsResult, String str2, String str3) {
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        AnonymousClass2 r32 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                jsResult.confirm();
                dialogInterface.dismiss();
            }
        };
        Activity activity = getActivity();
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_AppCompat_Dialog_Alert);
            builder.setMessage((CharSequence) str);
            if (str3 == null || str3.isEmpty()) {
                builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) r32);
            } else {
                builder.setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) r32);
            }
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
        }
    }

    public void createBeforeUnloadDialog(WebView webView, String str, final JsResult jsResult, String str2, String str3, String str4) {
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        AnonymousClass13 r42 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                jsResult.confirm();
                dialogInterface.dismiss();
            }
        };
        AnonymousClass14 r72 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                jsResult.cancel();
                dialogInterface.dismiss();
            }
        };
        Activity activity = getActivity();
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_AppCompat_Dialog_Alert);
            builder.setMessage((CharSequence) str);
            if (str3 == null || str3.isEmpty()) {
                builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) r42);
            } else {
                builder.setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) r42);
            }
            if (str4 == null || str4.isEmpty()) {
                builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) r72);
            } else {
                builder.setNegativeButton((CharSequence) str4, (DialogInterface.OnClickListener) r72);
            }
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
        }
    }

    public void createConfirmDialog(WebView webView, String str, final JsResult jsResult, String str2, String str3, String str4) {
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        AnonymousClass5 r42 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                jsResult.confirm();
                dialogInterface.dismiss();
            }
        };
        AnonymousClass6 r72 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                jsResult.cancel();
                dialogInterface.dismiss();
            }
        };
        Activity activity = getActivity();
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_AppCompat_Dialog_Alert);
            builder.setMessage((CharSequence) str);
            if (str3 == null || str3.isEmpty()) {
                builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) r42);
            } else {
                builder.setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) r42);
            }
            if (str4 == null || str4.isEmpty()) {
                builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) r72);
            } else {
                builder.setNegativeButton((CharSequence) str4, (DialogInterface.OnClickListener) r72);
            }
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
        }
    }

    public void createPromptDialog(WebView webView, String str, String str2, final JsPromptResult jsPromptResult, String str3, String str4, final String str5, String str6, String str7) {
        FrameLayout frameLayout = new FrameLayout(webView.getContext());
        final EditText editText = new EditText(webView.getContext());
        editText.setMaxLines(1);
        if (str4 != null && !str4.isEmpty()) {
            str2 = str4;
        }
        editText.setText(str2);
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        frameLayout.setPaddingRelative(45, 15, 45, 0);
        frameLayout.addView(editText);
        if (str3 != null && !str3.isEmpty()) {
            str = str3;
        }
        AnonymousClass9 r32 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                String obj = editText.getText().toString();
                JsPromptResult jsPromptResult = jsPromptResult;
                String str = str5;
                if (str != null) {
                    obj = str;
                }
                jsPromptResult.confirm(obj);
                dialogInterface.dismiss();
            }
        };
        AnonymousClass10 r52 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                jsPromptResult.cancel();
                dialogInterface.dismiss();
            }
        };
        Activity activity = getActivity();
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_AppCompat_Dialog_Alert);
            builder.setMessage((CharSequence) str);
            if (str7 == null || str7.isEmpty()) {
                builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) r32);
            } else {
                builder.setPositiveButton((CharSequence) str7, (DialogInterface.OnClickListener) r32);
            }
            if (str6 == null || str6.isEmpty()) {
                builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) r52);
            } else {
                builder.setNegativeButton((CharSequence) str6, (DialogInterface.OnClickListener) r52);
            }
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    jsPromptResult.cancel();
                    dialogInterface.dismiss();
                }
            });
            AlertDialog create = builder.create();
            create.setView(frameLayout);
            create.show();
        }
    }

    public void dispose() {
        ActivityPluginBinding activityPluginBinding;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (!(inAppWebViewFlutterPlugin == null || (activityPluginBinding = inAppWebViewFlutterPlugin.activityPluginBinding) == null)) {
            activityPluginBinding.removeActivityResultListener(this);
        }
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.getActivityResultListeners().clear();
            this.inAppBrowserDelegate = null;
        }
        this.plugin = null;
    }

    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
    }

    public ViewGroup getRootView() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.findViewById(16908290);
    }

    public boolean needsCameraPermission() {
        Activity activity = getActivity();
        if (activity == null) {
            return true;
        }
        try {
            return Arrays.asList(activity.getPackageManager().getPackageInfo(activity.getApplicationContext().getPackageName(), 4096).requestedPermissions).contains("android.permission.CAMERA") && ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA") != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public boolean onActivityResult(int i11, int i12, Intent intent) {
        if (InAppWebViewFlutterPlugin.filePathCallback == null && InAppWebViewFlutterPlugin.filePathCallbackLegacy == null) {
            return true;
        }
        if (i11 == 1) {
            Uri[] selectedFiles = i12 == -1 ? getSelectedFiles(intent, i12) : null;
            ValueCallback<Uri[]> valueCallback = InAppWebViewFlutterPlugin.filePathCallback;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(selectedFiles);
            }
        } else if (i11 == 3) {
            InAppWebViewFlutterPlugin.filePathCallbackLegacy.onReceiveValue(i12 == -1 ? intent != null ? intent.getData() : getCapturedMediaFile() : null);
        }
        InAppWebViewFlutterPlugin.filePathCallback = null;
        InAppWebViewFlutterPlugin.filePathCallbackLegacy = null;
        imageOutputFileUri = null;
        videoOutputFileUri = null;
        return true;
    }

    public void onCloseWindow(WebView webView) {
        this.channel.invokeMethod("onCloseWindow", new HashMap());
        super.onCloseWindow(webView);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", consoleMessage.message());
        hashMap.put("messageLevel", Integer.valueOf(consoleMessage.messageLevel().ordinal()));
        this.channel.invokeMethod("onConsoleMessage", hashMap);
        return true;
    }

    public boolean onCreateWindow(WebView webView, boolean z11, boolean z12, Message message) {
        String string;
        final int i11 = windowAutoincrementId + 1;
        windowAutoincrementId = i11;
        WebView.HitTestResult hitTestResult = webView.getHitTestResult();
        String extra = hitTestResult.getExtra();
        if (hitTestResult.getType() == 8) {
            Message obtainMessage = webView.getHandler().obtainMessage();
            webView.requestFocusNodeHref(obtainMessage);
            Bundle data = obtainMessage.getData();
            if (!(data == null || (string = data.getString("url")) == null || string.isEmpty())) {
                extra = string;
            }
        }
        CreateWindowAction createWindowAction = new CreateWindowAction(new URLRequest(extra, "GET", (byte[]) null, (Map<String, String>) null), true, z12, false, i11, z11);
        windowWebViewMessages.put(Integer.valueOf(i11), message);
        this.channel.invokeMethod("onCreateWindow", createWindowAction.toMap(), new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewChromeClient.LOG_TAG, sb2.toString());
                if (InAppWebViewChromeClient.windowWebViewMessages.containsKey(Integer.valueOf(i11))) {
                    InAppWebViewChromeClient.windowWebViewMessages.remove(Integer.valueOf(i11));
                }
            }

            public void notImplemented() {
                if (InAppWebViewChromeClient.windowWebViewMessages.containsKey(Integer.valueOf(i11))) {
                    InAppWebViewChromeClient.windowWebViewMessages.remove(Integer.valueOf(i11));
                }
            }

            public void success(Object obj) {
                if (!(obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) && InAppWebViewChromeClient.windowWebViewMessages.containsKey(Integer.valueOf(i11))) {
                    InAppWebViewChromeClient.windowWebViewMessages.remove(Integer.valueOf(i11));
                }
            }
        });
        return true;
    }

    public void onGeolocationPermissionsHidePrompt() {
        this.channel.invokeMethod("onGeolocationPermissionsHidePrompt", new HashMap());
    }

    public void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("origin", str);
        this.channel.invokeMethod("onGeolocationPermissionsShowPrompt", hashMap, new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewChromeClient.LOG_TAG, sb2.toString());
                callback.invoke(str, false, false);
            }

            public void notImplemented() {
                callback.invoke(str, false, false);
            }

            public void success(Object obj) {
                Map map = (Map) obj;
                if (map != null) {
                    callback.invoke((String) map.get("origin"), ((Boolean) map.get("allow")).booleanValue(), ((Boolean) map.get("retain")).booleanValue());
                } else {
                    callback.invoke(str, false, false);
                }
            }
        });
    }

    public void onHideCustomView() {
        ViewGroup rootView;
        Activity activity = getActivity();
        if (activity != null && (rootView = getRootView()) != null) {
            ((FrameLayout) rootView).removeView(this.mCustomView);
            this.mCustomView = null;
            rootView.setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            activity.setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
            activity.getWindow().clearFlags(512);
            this.channel.invokeMethod("onExitFullscreen", new HashMap());
        }
    }

    public boolean onJsAlert(final WebView webView, String str, final String str2, final JsResult jsResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        hashMap.put("iosIsMainFrame", (Object) null);
        this.channel.invokeMethod("onJsAlert", hashMap, new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewChromeClient.LOG_TAG, sb2.toString());
                jsResult.cancel();
            }

            public void notImplemented() {
                InAppWebViewChromeClient.this.createAlertDialog(webView, str2, jsResult, (String) null, (String) null);
            }

            public void success(Object obj) {
                String str;
                String str2;
                if (obj != null) {
                    Map map = (Map) obj;
                    String str3 = (String) map.get("message");
                    String str4 = (String) map.get("confirmButtonTitle");
                    Boolean bool = (Boolean) map.get("handledByClient");
                    if (bool == null || !bool.booleanValue()) {
                        str2 = str3;
                        str = str4;
                    } else {
                        Integer num = (Integer) map.get(NativeProtocol.WEB_DIALOG_ACTION);
                        if (Integer.valueOf(num != null ? num.intValue() : 1).intValue() != 0) {
                            jsResult.cancel();
                            return;
                        } else {
                            jsResult.confirm();
                            return;
                        }
                    }
                } else {
                    str2 = null;
                    str = null;
                }
                InAppWebViewChromeClient.this.createAlertDialog(webView, str2, jsResult, str2, str);
            }
        });
        return true;
    }

    public boolean onJsBeforeUnload(final WebView webView, String str, final String str2, final JsResult jsResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        this.channel.invokeMethod("onJsBeforeUnload", hashMap, new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewChromeClient.LOG_TAG, sb2.toString());
                jsResult.cancel();
            }

            public void notImplemented() {
                InAppWebViewChromeClient.this.createConfirmDialog(webView, str2, jsResult, (String) null, (String) null, (String) null);
            }

            public void success(Object obj) {
                String str;
                String str2;
                String str3;
                if (obj != null) {
                    Map map = (Map) obj;
                    String str4 = (String) map.get("message");
                    String str5 = (String) map.get("confirmButtonTitle");
                    String str6 = (String) map.get("cancelButtonTitle");
                    Boolean bool = (Boolean) map.get("handledByClient");
                    if (bool == null || !bool.booleanValue()) {
                        str3 = str4;
                        str2 = str5;
                        str = str6;
                    } else {
                        Integer num = (Integer) map.get(NativeProtocol.WEB_DIALOG_ACTION);
                        if (Integer.valueOf(num != null ? num.intValue() : 1).intValue() != 0) {
                            jsResult.cancel();
                            return;
                        } else {
                            jsResult.confirm();
                            return;
                        }
                    }
                } else {
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                InAppWebViewChromeClient.this.createBeforeUnloadDialog(webView, str2, jsResult, str3, str2, str);
            }
        });
        return true;
    }

    public boolean onJsConfirm(final WebView webView, String str, final String str2, final JsResult jsResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        hashMap.put("iosIsMainFrame", (Object) null);
        this.channel.invokeMethod("onJsConfirm", hashMap, new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewChromeClient.LOG_TAG, sb2.toString());
                jsResult.cancel();
            }

            public void notImplemented() {
                InAppWebViewChromeClient.this.createConfirmDialog(webView, str2, jsResult, (String) null, (String) null, (String) null);
            }

            public void success(Object obj) {
                String str;
                String str2;
                String str3;
                if (obj != null) {
                    Map map = (Map) obj;
                    String str4 = (String) map.get("message");
                    String str5 = (String) map.get("confirmButtonTitle");
                    String str6 = (String) map.get("cancelButtonTitle");
                    Boolean bool = (Boolean) map.get("handledByClient");
                    if (bool == null || !bool.booleanValue()) {
                        str3 = str4;
                        str2 = str5;
                        str = str6;
                    } else {
                        Integer num = (Integer) map.get(NativeProtocol.WEB_DIALOG_ACTION);
                        if (Integer.valueOf(num != null ? num.intValue() : 1).intValue() != 0) {
                            jsResult.cancel();
                            return;
                        } else {
                            jsResult.confirm();
                            return;
                        }
                    }
                } else {
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                InAppWebViewChromeClient.this.createConfirmDialog(webView, str2, jsResult, str3, str2, str);
            }
        });
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("message", str2);
        hashMap.put("defaultValue", str3);
        hashMap.put("iosIsMainFrame", (Object) null);
        final JsPromptResult jsPromptResult2 = jsPromptResult;
        final WebView webView2 = webView;
        final String str4 = str2;
        final String str5 = str3;
        this.channel.invokeMethod("onJsPrompt", hashMap, new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewChromeClient.LOG_TAG, sb2.toString());
                jsPromptResult2.cancel();
            }

            public void notImplemented() {
                InAppWebViewChromeClient.this.createPromptDialog(webView2, str4, str5, jsPromptResult2, (String) null, (String) null, (String) null, (String) null, (String) null);
            }

            public void success(Object obj) {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                if (obj != null) {
                    Map map = (Map) obj;
                    String str6 = (String) map.get("message");
                    String str7 = (String) map.get("defaultValue");
                    String str8 = (String) map.get("confirmButtonTitle");
                    String str9 = (String) map.get("cancelButtonTitle");
                    String str10 = (String) map.get("value");
                    Boolean bool = (Boolean) map.get("handledByClient");
                    if (bool == null || !bool.booleanValue()) {
                        str5 = str6;
                        str4 = str7;
                        str = str8;
                        str2 = str9;
                        str3 = str10;
                    } else {
                        Integer num = (Integer) map.get(NativeProtocol.WEB_DIALOG_ACTION);
                        if (Integer.valueOf(num != null ? num.intValue() : 1).intValue() != 0) {
                            jsPromptResult2.cancel();
                            return;
                        } else {
                            jsPromptResult2.confirm(str10);
                            return;
                        }
                    }
                } else {
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                InAppWebViewChromeClient.this.createPromptDialog(webView2, str4, str5, jsPromptResult2, str5, str4, str3, str2, str);
            }
        });
        return true;
    }

    public void onPermissionRequest(final PermissionRequest permissionRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("origin", permissionRequest.getOrigin().toString());
        hashMap.put("resources", Arrays.asList(permissionRequest.getResources()));
        this.channel.invokeMethod("onPermissionRequest", hashMap, new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewChromeClient.LOG_TAG, sb2.toString());
                permissionRequest.deny();
            }

            public void notImplemented() {
                permissionRequest.deny();
            }

            public void success(Object obj) {
                if (obj != null) {
                    Map map = (Map) obj;
                    Integer num = (Integer) map.get(NativeProtocol.WEB_DIALOG_ACTION);
                    List list = (List) map.get("resources");
                    if (list == null) {
                        list = new ArrayList();
                    }
                    String[] strArr = (String[]) list.toArray(new String[list.size()]);
                    if (num != null) {
                        if (num.intValue() != 1) {
                            permissionRequest.deny();
                            return;
                        } else {
                            permissionRequest.grant(strArr);
                            return;
                        }
                    }
                }
                permissionRequest.deny();
            }
        });
    }

    public void onProgressChanged(WebView webView, int i11) {
        super.onProgressChanged(webView, i11);
        InAppWebView inAppWebView = (InAppWebView) webView;
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didChangeProgress(i11);
        }
        InAppWebViewClient inAppWebViewClient = inAppWebView.inAppWebViewClient;
        if (inAppWebViewClient != null) {
            inAppWebViewClient.loadCustomJavaScriptOnPageStarted(webView);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("progress", Integer.valueOf(i11));
        this.channel.invokeMethod("onProgressChanged", hashMap);
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
            String message = e11.getMessage();
            if (message != null) {
                Log.e(LOG_TAG, message);
            }
        }
        bitmap.recycle();
        HashMap hashMap = new HashMap();
        hashMap.put("icon", byteArrayOutputStream.toByteArray());
        this.channel.invokeMethod("onReceivedIcon", hashMap);
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didChangeTitle(str);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("title", str);
        this.channel.invokeMethod("onTitleChanged", hashMap);
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z11) {
        super.onReceivedTouchIconUrl(webView, str, z11);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("precomposed", Boolean.valueOf(z11));
        this.channel.invokeMethod("onReceivedTouchIconUrl", hashMap);
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        ViewGroup rootView;
        if (this.mCustomView != null) {
            onHideCustomView();
            return;
        }
        Activity activity = getActivity();
        if (activity != null && (rootView = getRootView()) != null) {
            this.mCustomView = view;
            this.mOriginalSystemUiVisibility = rootView.getSystemUiVisibility();
            this.mOriginalOrientation = activity.getRequestedOrientation();
            this.mCustomViewCallback = customViewCallback;
            this.mCustomView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            rootView.setSystemUiVisibility(FULLSCREEN_SYSTEM_UI_VISIBILITY_KITKAT);
            activity.getWindow().setFlags(512, 512);
            ((FrameLayout) rootView).addView(this.mCustomView, FULLSCREEN_LAYOUT_PARAMS);
            this.channel.invokeMethod("onEnterFullscreen", new HashMap());
        }
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        boolean z11 = true;
        if (fileChooserParams.getMode() != 1) {
            z11 = false;
        }
        return startPickerIntent(valueCallback, acceptTypes, z11, fileChooserParams.isCaptureEnabled());
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        startPickerIntent(valueCallback, "", (String) null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        startPickerIntent(valueCallback, str, (String) null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        startPickerIntent(valueCallback, str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startPickerIntent(android.webkit.ValueCallback<android.net.Uri> r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin.filePathCallbackLegacy = r3
            java.lang.Boolean r3 = r2.acceptsImages((java.lang.String) r4)
            boolean r3 = r3.booleanValue()
            java.lang.Boolean r0 = r2.acceptsVideo((java.lang.String) r4)
            boolean r0 = r0.booleanValue()
            if (r5 == 0) goto L_0x0028
            boolean r5 = r2.needsCameraPermission()
            if (r5 != 0) goto L_0x0028
            if (r3 == 0) goto L_0x0021
            android.content.Intent r5 = r2.getPhotoIntent()
            goto L_0x0029
        L_0x0021:
            if (r0 == 0) goto L_0x0028
            android.content.Intent r5 = r2.getVideoIntent()
            goto L_0x0029
        L_0x0028:
            r5 = 0
        L_0x0029:
            if (r5 != 0) goto L_0x0060
            android.content.Intent r4 = r2.getFileChooserIntent(r4)
            java.lang.String r5 = ""
            android.content.Intent r5 = android.content.Intent.createChooser(r4, r5)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r1 = r2.needsCameraPermission()
            if (r1 != 0) goto L_0x0052
            if (r3 == 0) goto L_0x0049
            android.content.Intent r3 = r2.getPhotoIntent()
            r4.add(r3)
        L_0x0049:
            if (r0 == 0) goto L_0x0052
            android.content.Intent r3 = r2.getVideoIntent()
            r4.add(r3)
        L_0x0052:
            r3 = 0
            android.os.Parcelable[] r3 = new android.os.Parcelable[r3]
            java.lang.Object[] r3 = r4.toArray(r3)
            android.os.Parcelable[] r3 = (android.os.Parcelable[]) r3
            java.lang.String r4 = "android.intent.extra.INITIAL_INTENTS"
            r5.putExtra(r4, r3)
        L_0x0060:
            android.app.Activity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x0074
            android.content.pm.PackageManager r4 = r3.getPackageManager()
            android.content.ComponentName r4 = r5.resolveActivity(r4)
            if (r4 == 0) goto L_0x0074
            r4 = 3
            r3.startActivityForResult(r5, r4)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewChromeClient.startPickerIntent(android.webkit.ValueCallback, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean startPickerIntent(android.webkit.ValueCallback<android.net.Uri[]> r3, java.lang.String[] r4, boolean r5, boolean r6) {
        /*
            r2 = this;
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin.filePathCallback = r3
            java.lang.Boolean r3 = r2.acceptsImages((java.lang.String[]) r4)
            boolean r3 = r3.booleanValue()
            java.lang.Boolean r0 = r2.acceptsVideo((java.lang.String[]) r4)
            boolean r0 = r0.booleanValue()
            if (r6 == 0) goto L_0x0028
            boolean r6 = r2.needsCameraPermission()
            if (r6 != 0) goto L_0x0028
            if (r3 == 0) goto L_0x0021
            android.content.Intent r6 = r2.getPhotoIntent()
            goto L_0x0029
        L_0x0021:
            if (r0 == 0) goto L_0x0028
            android.content.Intent r6 = r2.getVideoIntent()
            goto L_0x0029
        L_0x0028:
            r6 = 0
        L_0x0029:
            if (r6 != 0) goto L_0x0067
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            boolean r1 = r2.needsCameraPermission()
            if (r1 != 0) goto L_0x0048
            if (r3 == 0) goto L_0x003f
            android.content.Intent r3 = r2.getPhotoIntent()
            r6.add(r3)
        L_0x003f:
            if (r0 == 0) goto L_0x0048
            android.content.Intent r3 = r2.getVideoIntent()
            r6.add(r3)
        L_0x0048:
            android.content.Intent r3 = r2.getFileChooserIntent(r4, r5)
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r5 = "android.intent.action.CHOOSER"
            r4.<init>(r5)
            java.lang.String r5 = "android.intent.extra.INTENT"
            r4.putExtra(r5, r3)
            r3 = 0
            android.os.Parcelable[] r3 = new android.os.Parcelable[r3]
            java.lang.Object[] r3 = r6.toArray(r3)
            android.os.Parcelable[] r3 = (android.os.Parcelable[]) r3
            java.lang.String r5 = "android.intent.extra.INITIAL_INTENTS"
            r4.putExtra(r5, r3)
            r6 = r4
        L_0x0067:
            android.app.Activity r3 = r2.getActivity()
            r4 = 1
            if (r3 == 0) goto L_0x007b
            android.content.pm.PackageManager r5 = r3.getPackageManager()
            android.content.ComponentName r5 = r6.resolveActivity(r5)
            if (r5 == 0) goto L_0x007b
            r3.startActivityForResult(r6, r4)
        L_0x007b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewChromeClient.startPickerIntent(android.webkit.ValueCallback, java.lang.String[], boolean, boolean):boolean");
    }
}
