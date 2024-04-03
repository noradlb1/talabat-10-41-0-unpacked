package dev.fluttercommunity.plus.packageinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Ldev/fluttercommunity/plus/packageinfo/PackageInfoPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "applicationContext", "Landroid/content/Context;", "methodChannel", "Lio/flutter/plugin/common/MethodChannel;", "bytesToHex", "", "bytes", "", "getBuildSignature", "pm", "Landroid/content/pm/PackageManager;", "getLongVersionCode", "", "info", "Landroid/content/pm/PackageInfo;", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "signatureToSha1", "sig", "Companion", "package_info_plus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PackageInfoPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin {
    @NotNull
    private static final String CHANNEL_NAME = "dev.fluttercommunity.plus/package_info";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private Context applicationContext;
    @Nullable
    private MethodChannel methodChannel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ldev/fluttercommunity/plus/packageinfo/PackageInfoPlugin$Companion;", "", "()V", "CHANNEL_NAME", "", "package_info_plus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String bytesToHex(byte[] bArr) {
        char[] cArr = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int length = bArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            byte b11 = bArr[i11] & 255;
            int i12 = i11 * 2;
            cArr2[i12] = cArr[b11 >>> 4];
            cArr2[i12 + 1] = cArr[b11 & Ascii.SI];
        }
        return new String(cArr2);
    }

    private final String getBuildSignature(PackageManager packageManager) {
        String signatureToSha1;
        boolean z11;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Context context = this.applicationContext;
                Intrinsics.checkNotNull(context);
                SigningInfo a11 = packageManager.getPackageInfo(context.getPackageName(), C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                if (a11 == null) {
                    return null;
                }
                if (a11.hasMultipleSigners()) {
                    Signature[] a12 = a11.getApkContentsSigners();
                    Intrinsics.checkNotNullExpressionValue(a12, "signingInfo.apkContentsSigners");
                    byte[] byteArray = ((Signature) ArraysKt___ArraysKt.first((T[]) a12)).toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "signingInfo.apkContentsS…ers.first().toByteArray()");
                    signatureToSha1 = signatureToSha1(byteArray);
                } else {
                    Signature[] a13 = a11.getSigningCertificateHistory();
                    Intrinsics.checkNotNullExpressionValue(a13, "signingInfo.signingCertificateHistory");
                    byte[] byteArray2 = ((Signature) ArraysKt___ArraysKt.first((T[]) a13)).toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray2, "signingInfo.signingCerti…ory.first().toByteArray()");
                    signatureToSha1 = signatureToSha1(byteArray2);
                }
            } else {
                Context context2 = this.applicationContext;
                Intrinsics.checkNotNull(context2);
                Signature[] signatureArr = packageManager.getPackageInfo(context2.getPackageName(), 64).signatures;
                boolean z12 = true;
                if (signatureArr != null) {
                    if (signatureArr.length == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        z12 = false;
                    }
                }
                if (z12) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(signatureArr, "packageInfo.signatures");
                if (ArraysKt___ArraysKt.first((T[]) signatureArr) == null) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(signatureArr, "signatures");
                byte[] byteArray3 = ((Signature) ArraysKt___ArraysKt.first((T[]) signatureArr)).toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray3, "signatures.first().toByteArray()");
                signatureToSha1 = signatureToSha1(byteArray3);
            }
            return signatureToSha1;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private final long getLongVersionCode(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    private final String signatureToSha1(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        instance.update(bArr);
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "hashText");
        return bytesToHex(digest);
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.applicationContext = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel2 = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), CHANNEL_NAME);
        this.methodChannel = methodChannel2;
        Intrinsics.checkNotNull(methodChannel2);
        methodChannel2.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.applicationContext = null;
        MethodChannel methodChannel2 = this.methodChannel;
        Intrinsics.checkNotNull(methodChannel2);
        methodChannel2.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.methodChannel = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            if (Intrinsics.areEqual((Object) methodCall.method, (Object) "getAll")) {
                Context context = this.applicationContext;
                Intrinsics.checkNotNull(context);
                PackageManager packageManager = context.getPackageManager();
                Context context2 = this.applicationContext;
                Intrinsics.checkNotNull(context2);
                PackageInfo packageInfo = packageManager.getPackageInfo(context2.getPackageName(), 0);
                Intrinsics.checkNotNullExpressionValue(packageManager, "packageManager");
                String buildSignature = getBuildSignature(packageManager);
                Context context3 = this.applicationContext;
                Intrinsics.checkNotNull(context3);
                String installerPackageName = packageManager.getInstallerPackageName(context3.getPackageName());
                HashMap hashMap = new HashMap();
                hashMap.put(AnalyticsAttribute.APP_NAME_ATTRIBUTE, packageInfo.applicationInfo.loadLabel(packageManager).toString());
                Context context4 = this.applicationContext;
                Intrinsics.checkNotNull(context4);
                hashMap.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, context4.getPackageName());
                hashMap.put("version", packageInfo.versionName);
                Intrinsics.checkNotNullExpressionValue(packageInfo, CustomerInfoLocalDataSourceImpl.KEY);
                hashMap.put("buildNumber", String.valueOf(getLongVersionCode(packageInfo)));
                if (buildSignature != null) {
                    hashMap.put("buildSignature", buildSignature);
                }
                if (installerPackageName != null) {
                    hashMap.put("installerStore", installerPackageName);
                }
                result.success(hashMap);
                return;
            }
            result.notImplemented();
        } catch (PackageManager.NameNotFoundException e11) {
            result.error("Name not found", e11.getMessage(), (Object) null);
        }
    }
}
