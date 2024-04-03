package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0003J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\u001e\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0007J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R.\u0010\r\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000f0\u000ej\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000f`\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/devicerequests/internal/DeviceRequestsHelper;", "", "()V", "DEVICE_INFO_DEVICE", "", "DEVICE_INFO_MODEL", "DEVICE_INFO_PARAM", "DEVICE_TARGET_USER_ID", "SDK_FLAVOR", "SDK_HEADER", "SERVICE_TYPE", "TAG", "kotlin.jvm.PlatformType", "deviceRequestsListeners", "Ljava/util/HashMap;", "Landroid/net/nsd/NsdManager$RegistrationListener;", "Lkotlin/collections/HashMap;", "cleanUpAdvertisementService", "", "userCode", "cleanUpAdvertisementServiceImpl", "generateQRCode", "Landroid/graphics/Bitmap;", "url", "getDeviceInfo", "deviceInfo", "", "isAvailable", "", "startAdvertisementService", "startAdvertisementServiceImpl", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class DeviceRequestsHelper {
    @NotNull
    public static final String DEVICE_INFO_DEVICE = "device";
    @NotNull
    public static final String DEVICE_INFO_MODEL = "model";
    @NotNull
    public static final String DEVICE_INFO_PARAM = "device_info";
    @NotNull
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";
    @NotNull
    public static final DeviceRequestsHelper INSTANCE = new DeviceRequestsHelper();
    @NotNull
    public static final String SDK_FLAVOR = "android";
    @NotNull
    public static final String SDK_HEADER = "fbsdk";
    @NotNull
    public static final String SERVICE_TYPE = "_fb._tcp.";
    private static final String TAG = DeviceRequestsHelper.class.getCanonicalName();
    @NotNull
    private static final HashMap<String, NsdManager.RegistrationListener> deviceRequestsListeners = new HashMap<>();

    private DeviceRequestsHelper() {
    }

    @JvmStatic
    public static final void cleanUpAdvertisementService(@Nullable String str) {
        INSTANCE.cleanUpAdvertisementServiceImpl(str);
    }

    @TargetApi(16)
    private final void cleanUpAdvertisementServiceImpl(String str) {
        NsdManager.RegistrationListener registrationListener = deviceRequestsListeners.get(str);
        if (registrationListener != null) {
            Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
            if (systemService != null) {
                try {
                    ((NsdManager) systemService).unregisterService(registrationListener);
                } catch (IllegalArgumentException e11) {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(TAG, (Exception) e11);
                }
                deviceRequestsListeners.remove(str);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
        }
    }

    @JvmStatic
    @Nullable
    public static final Bitmap generateQRCode(@Nullable String str) {
        int i11;
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 200, 200, enumMap);
            int height = encode.getHeight();
            int width = encode.getWidth();
            int[] iArr = new int[(height * width)];
            if (height > 0) {
                int i12 = 0;
                while (true) {
                    int i13 = i12 + 1;
                    int i14 = i12 * width;
                    if (width > 0) {
                        int i15 = 0;
                        while (true) {
                            int i16 = i15 + 1;
                            int i17 = i14 + i15;
                            if (encode.get(i15, i12)) {
                                i11 = ViewCompat.MEASURED_STATE_MASK;
                            } else {
                                i11 = -1;
                            }
                            iArr[i17] = i11;
                            if (i16 >= width) {
                                break;
                            }
                            i15 = i16;
                        }
                    }
                    if (i13 >= height) {
                        break;
                    }
                    i12 = i13;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return createBitmap;
        } catch (WriterException unused) {
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getDeviceInfo(@Nullable Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        String str = Build.DEVICE;
        Intrinsics.checkNotNullExpressionValue(str, "DEVICE");
        map.put("device", str);
        String str2 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str2, "MODEL");
        map.put(DEVICE_INFO_MODEL, str2);
        String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) map));
        Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "JSONObject(deviceInfo as Map<*, *>).toString()");
        return jSONObjectInstrumentation;
    }

    @JvmStatic
    public static final boolean isAvailable() {
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null || !appSettingsWithoutQuery.getSmartLoginOptions().contains(SmartLoginOption.Enabled)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean startAdvertisementService(@Nullable String str) {
        if (isAvailable()) {
            return INSTANCE.startAdvertisementServiceImpl(str);
        }
        return false;
    }

    @TargetApi(16)
    private final boolean startAdvertisementServiceImpl(String str) {
        HashMap<String, NsdManager.RegistrationListener> hashMap = deviceRequestsListeners;
        if (hashMap.containsKey(str)) {
            return true;
        }
        String str2 = "fbsdk_" + Intrinsics.stringPlus("android-", StringsKt__StringsJVMKt.replace$default(FacebookSdk.getSdkVersion(), '.', '|', false, 4, (Object) null)) + '_' + str;
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceType(SERVICE_TYPE);
        nsdServiceInfo.setServiceName(str2);
        nsdServiceInfo.setPort(80);
        Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
        if (systemService != null) {
            DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1 deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1 = new DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1(str2, str);
            hashMap.put(str, deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1);
            ((NsdManager) systemService).registerService(nsdServiceInfo, 1, deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
    }

    @JvmStatic
    @NotNull
    public static final String getDeviceInfo() {
        return getDeviceInfo((Map<String, String>) null);
    }
}
