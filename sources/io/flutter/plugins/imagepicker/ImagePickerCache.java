package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodCall;
import java.util.HashMap;
import java.util.Map;

class ImagePickerCache {
    private static final String FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY = "flutter_image_picker_image_path";
    private static final String MAP_KEY_ERROR_CODE = "errorCode";
    private static final String MAP_KEY_ERROR_MESSAGE = "errorMessage";
    private static final String MAP_KEY_TYPE = "type";
    private static final String SHARED_PREFERENCE_ERROR_CODE_KEY = "flutter_image_picker_error_code";
    private static final String SHARED_PREFERENCE_ERROR_MESSAGE_KEY = "flutter_image_picker_error_message";
    private static final String SHARED_PREFERENCE_IMAGE_QUALITY_KEY = "flutter_image_picker_image_quality";
    private static final String SHARED_PREFERENCE_MAX_HEIGHT_KEY = "flutter_image_picker_max_height";
    private static final String SHARED_PREFERENCE_MAX_WIDTH_KEY = "flutter_image_picker_max_width";
    private static final String SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY = "flutter_image_picker_pending_image_uri";
    private static final String SHARED_PREFERENCE_TYPE_KEY = "flutter_image_picker_type";
    private SharedPreferences prefs;

    public ImagePickerCache(Context context) {
        this.prefs = context.getSharedPreferences("flutter_image_picker_shared_preference", 0);
    }

    private void setMaxDimension(Double d11, Double d12, int i11) {
        SharedPreferences.Editor edit = this.prefs.edit();
        if (d11 != null) {
            edit.putLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, Double.doubleToRawLongBits(d11.doubleValue()));
        }
        if (d12 != null) {
            edit.putLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, Double.doubleToRawLongBits(d12.doubleValue()));
        }
        if (i11 <= -1 || i11 >= 101) {
            edit.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100);
        } else {
            edit.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, i11);
        }
        edit.apply();
    }

    private void setType(String str) {
        this.prefs.edit().putString(SHARED_PREFERENCE_TYPE_KEY, str).apply();
    }

    public void a() {
        this.prefs.edit().clear().apply();
    }

    public Map<String, Object> b() {
        boolean z11;
        HashMap hashMap = new HashMap();
        boolean z12 = true;
        if (this.prefs.contains(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY)) {
            hashMap.put("path", this.prefs.getString(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, ""));
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.prefs.contains(SHARED_PREFERENCE_ERROR_CODE_KEY)) {
            hashMap.put("errorCode", this.prefs.getString(SHARED_PREFERENCE_ERROR_CODE_KEY, ""));
            if (this.prefs.contains(SHARED_PREFERENCE_ERROR_MESSAGE_KEY)) {
                hashMap.put("errorMessage", this.prefs.getString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, ""));
            }
        } else {
            z12 = z11;
        }
        if (z12) {
            if (this.prefs.contains(SHARED_PREFERENCE_TYPE_KEY)) {
                hashMap.put("type", this.prefs.getString(SHARED_PREFERENCE_TYPE_KEY, ""));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_MAX_WIDTH_KEY)) {
                hashMap.put("maxWidth", Double.valueOf(Double.longBitsToDouble(this.prefs.getLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, 0))));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_MAX_HEIGHT_KEY)) {
                hashMap.put("maxHeight", Double.valueOf(Double.longBitsToDouble(this.prefs.getLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, 0))));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_IMAGE_QUALITY_KEY)) {
                hashMap.put("imageQuality", Integer.valueOf(this.prefs.getInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100)));
            } else {
                hashMap.put("imageQuality", 100);
            }
        }
        return hashMap;
    }

    public String c() {
        return this.prefs.getString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, "");
    }

    public void d(MethodCall methodCall) {
        int i11;
        Double d11 = (Double) methodCall.argument("maxWidth");
        Double d12 = (Double) methodCall.argument("maxHeight");
        if (methodCall.argument("imageQuality") == null) {
            i11 = 100;
        } else {
            i11 = ((Integer) methodCall.argument("imageQuality")).intValue();
        }
        setMaxDimension(d11, d12, i11);
    }

    public void e(Uri uri) {
        this.prefs.edit().putString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, uri.getPath()).apply();
    }

    public void f(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        SharedPreferences.Editor edit = this.prefs.edit();
        if (str != null) {
            edit.putString(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, str);
        }
        if (str2 != null) {
            edit.putString(SHARED_PREFERENCE_ERROR_CODE_KEY, str2);
        }
        if (str3 != null) {
            edit.putString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, str3);
        }
        edit.apply();
    }

    public void g(String str) {
        if (str.equals("pickImage")) {
            setType("image");
        } else if (str.equals("pickVideo")) {
            setType("video");
        }
    }
}
