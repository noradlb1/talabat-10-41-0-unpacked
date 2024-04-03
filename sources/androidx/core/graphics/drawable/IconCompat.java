package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final PorterDuff.Mode f11294c = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public Object f11295a;

    /* renamed from: b  reason: collision with root package name */
    public PorterDuff.Mode f11296b;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public byte[] mData;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt2;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable mParcelable;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mString1;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ColorStateList mTintList;
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mTintModeStr;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mType;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @Nullable
        public static IconCompat a(@NonNull Context context, @NonNull Icon icon) {
            int e11 = e(icon);
            if (e11 == 2) {
                String d11 = d(icon);
                try {
                    return IconCompat.createWithResource(IconCompat.b(context, d11), d11, c(icon));
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else if (e11 == 4) {
                return IconCompat.createWithContentUri(f(icon));
            } else {
                if (e11 == 6) {
                    return IconCompat.createWithAdaptiveBitmapContentUri(f(icon));
                }
                IconCompat iconCompat = new IconCompat(-1);
                iconCompat.f11295a = icon;
                return iconCompat;
            }
        }

        public static IconCompat b(@NonNull Object obj) {
            Preconditions.checkNotNull(obj);
            int e11 = e(obj);
            if (e11 == 2) {
                return IconCompat.createWithResource((Resources) null, d(obj), c(obj));
            }
            if (e11 == 4) {
                return IconCompat.createWithContentUri(f(obj));
            }
            if (e11 == 6) {
                return IconCompat.createWithAdaptiveBitmapContentUri(f(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f11295a = obj;
            return iconCompat;
        }

        @IdRes
        @DrawableRes
        public static int c(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e11) {
                Log.e(IconCompat.TAG, "Unable to get icon resource", e11);
                return 0;
            } catch (InvocationTargetException e12) {
                Log.e(IconCompat.TAG, "Unable to get icon resource", e12);
                return 0;
            } catch (NoSuchMethodException e13) {
                Log.e(IconCompat.TAG, "Unable to get icon resource", e13);
                return 0;
            }
        }

        @Nullable
        public static String d(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e11) {
                Log.e(IconCompat.TAG, "Unable to get icon package", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e(IconCompat.TAG, "Unable to get icon package", e12);
                return null;
            } catch (NoSuchMethodException e13) {
                Log.e(IconCompat.TAG, "Unable to get icon package", e13);
                return null;
            }
        }

        public static int e(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e11) {
                Log.e(IconCompat.TAG, "Unable to get icon type " + obj, e11);
                return -1;
            } catch (InvocationTargetException e12) {
                Log.e(IconCompat.TAG, "Unable to get icon type " + obj, e12);
                return -1;
            } catch (NoSuchMethodException e13) {
                Log.e(IconCompat.TAG, "Unable to get icon type " + obj, e13);
                return -1;
            }
        }

        @DoNotInline
        @Nullable
        public static Uri f(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e11) {
                Log.e(IconCompat.TAG, "Unable to get icon uri", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e(IconCompat.TAG, "Unable to get icon uri", e12);
                return null;
            } catch (NoSuchMethodException e13) {
                Log.e(IconCompat.TAG, "Unable to get icon uri", e13);
                return null;
            }
        }

        @DoNotInline
        public static Drawable g(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        @DoNotInline
        public static Icon h(IconCompat iconCompat, Context context) {
            Icon icon;
            switch (iconCompat.mType) {
                case -1:
                    return (Icon) iconCompat.f11295a;
                case 1:
                    icon = Icon.createWithBitmap((Bitmap) iconCompat.f11295a);
                    break;
                case 2:
                    icon = Icon.createWithResource(iconCompat.getResPackage(), iconCompat.mInt1);
                    break;
                case 3:
                    icon = Icon.createWithData((byte[]) iconCompat.f11295a, iconCompat.mInt1, iconCompat.mInt2);
                    break;
                case 4:
                    icon = Icon.createWithContentUri((String) iconCompat.f11295a);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT < 26) {
                        icon = Icon.createWithBitmap(IconCompat.a((Bitmap) iconCompat.f11295a, false));
                        break;
                    } else {
                        icon = Api26Impl.b((Bitmap) iconCompat.f11295a);
                        break;
                    }
                case 6:
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 >= 30) {
                        icon = Api30Impl.a(iconCompat.getUri());
                        break;
                    } else if (context != null) {
                        InputStream uriInputStream = iconCompat.getUriInputStream(context);
                        if (uriInputStream != null) {
                            if (i11 < 26) {
                                icon = Icon.createWithBitmap(IconCompat.a(BitmapFactory.decodeStream(uriInputStream), false));
                                break;
                            } else {
                                icon = Api26Impl.b(BitmapFactory.decodeStream(uriInputStream));
                                break;
                            }
                        } else {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.getUri());
                        }
                    } else {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.getUri());
                    }
                default:
                    throw new IllegalArgumentException("Unknown type");
            }
            ColorStateList colorStateList = iconCompat.mTintList;
            if (colorStateList != null) {
                icon.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f11296b;
            if (mode != IconCompat.f11294c) {
                icon.setTintMode(mode);
            }
            return icon;
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        @DoNotInline
        public static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        @DoNotInline
        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        @DoNotInline
        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        @DoNotInline
        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.f11296b = f11294c;
        this.mTintModeStr = null;
    }

    @VisibleForTesting
    public static Bitmap a(Bitmap bitmap, boolean z11) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * DEFAULT_VIEW_PORT_SCALE);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f11 = (float) min;
        float f12 = 0.5f * f11;
        float f13 = ICON_DIAMETER_FACTOR * f12;
        if (z11) {
            float f14 = BLUR_FACTOR * f11;
            paint.setColor(0);
            paint.setShadowLayer(f14, 0.0f, f11 * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
            canvas.drawCircle(f12, f12, f13, paint);
            paint.setShadowLayer(f14, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f12, f12, f13, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (-(bitmap.getWidth() - min))) / 2.0f, ((float) (-(bitmap.getHeight() - min))) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f12, f12, f13, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static Resources b(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e(TAG, String.format("Unable to find pkg=%s for icon", new Object[]{str}), e11);
            return null;
        }
    }

    @Nullable
    public static IconCompat createFromBundle(@NonNull Bundle bundle) {
        int i11 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i11);
        iconCompat.mInt1 = bundle.getInt("int1");
        iconCompat.mInt2 = bundle.getInt("int2");
        iconCompat.mString1 = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.mTintList = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f11296b = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i11) {
            case -1:
            case 1:
            case 5:
                iconCompat.f11295a = bundle.getParcelable("obj");
                break;
            case 2:
            case 4:
            case 6:
                iconCompat.f11295a = bundle.getString("obj");
                break;
            case 3:
                iconCompat.f11295a = bundle.getByteArray("obj");
                break;
            default:
                Log.w(TAG, "Unknown type " + i11);
                return null;
        }
        return iconCompat;
    }

    @RequiresApi(23)
    @Nullable
    public static IconCompat createFromIcon(@NonNull Context context, @NonNull Icon icon) {
        Preconditions.checkNotNull(icon);
        return Api23Impl.a(context, icon);
    }

    @RequiresApi(23)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIconOrNullIfZeroResId(@NonNull Icon icon) {
        if (Api23Impl.e(icon) == 2 && Api23Impl.c(icon) == 0) {
            return null;
        }
        return Api23Impl.b(icon);
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmap(@NonNull Bitmap bitmap) {
        ObjectsCompat.requireNonNull(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.f11295a = bitmap;
        return iconCompat;
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull String str) {
        ObjectsCompat.requireNonNull(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f11295a = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat createWithBitmap(@NonNull Bitmap bitmap) {
        ObjectsCompat.requireNonNull(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f11295a = bitmap;
        return iconCompat;
    }

    @NonNull
    public static IconCompat createWithContentUri(@NonNull String str) {
        ObjectsCompat.requireNonNull(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f11295a = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat createWithData(@NonNull byte[] bArr, int i11, int i12) {
        ObjectsCompat.requireNonNull(bArr);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.f11295a = bArr;
        iconCompat.mInt1 = i11;
        iconCompat.mInt2 = i12;
        return iconCompat;
    }

    @NonNull
    public static IconCompat createWithResource(@NonNull Context context, @DrawableRes int i11) {
        ObjectsCompat.requireNonNull(context);
        return createWithResource(context.getResources(), context.getPackageName(), i11);
    }

    private Drawable loadDrawableInner(Context context) {
        switch (this.mType) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.f11295a);
            case 2:
                String resPackage = getResPackage();
                if (TextUtils.isEmpty(resPackage)) {
                    resPackage = context.getPackageName();
                }
                try {
                    return ResourcesCompat.getDrawable(b(context, resPackage), this.mInt1, context.getTheme());
                } catch (RuntimeException e11) {
                    Log.e(TAG, String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.mInt1), this.f11295a}), e11);
                    break;
                }
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.f11295a, this.mInt1, this.mInt2));
            case 4:
                InputStream uriInputStream = getUriInputStream(context);
                if (uriInputStream != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(uriInputStream));
                }
                break;
            case 5:
                return new BitmapDrawable(context.getResources(), a((Bitmap) this.f11295a, false));
            case 6:
                InputStream uriInputStream2 = getUriInputStream(context);
                if (uriInputStream2 != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        return Api26Impl.a((Drawable) null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(uriInputStream2)));
                    }
                    return new BitmapDrawable(context.getResources(), a(BitmapFactory.decodeStream(uriInputStream2), false));
                }
                break;
        }
        return null;
    }

    private static String typeToString(int i11) {
        switch (i11) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addToShortcutIntent(@NonNull Intent intent, @Nullable Drawable drawable, @NonNull Context context) {
        Bitmap bitmap;
        checkResource(context);
        int i11 = this.mType;
        if (i11 == 1) {
            bitmap = (Bitmap) this.f11295a;
            if (drawable != null) {
                bitmap = bitmap.copy(bitmap.getConfig(), true);
            }
        } else if (i11 == 2) {
            try {
                Context createPackageContext = context.createPackageContext(getResPackage(), 0);
                if (drawable == null) {
                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(createPackageContext, this.mInt1));
                    return;
                }
                Drawable drawable2 = ContextCompat.getDrawable(createPackageContext, this.mInt1);
                if (drawable2.getIntrinsicWidth() > 0) {
                    if (drawable2.getIntrinsicHeight() > 0) {
                        bitmap = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                        drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        drawable2.draw(new Canvas(bitmap));
                    }
                }
                int launcherLargeIconSize = ((ActivityManager) createPackageContext.getSystemService("activity")).getLauncherLargeIconSize();
                bitmap = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                drawable2.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                drawable2.draw(new Canvas(bitmap));
            } catch (PackageManager.NameNotFoundException e11) {
                throw new IllegalArgumentException("Can't find package " + this.f11295a, e11);
            }
        } else if (i11 == 5) {
            bitmap = a((Bitmap) this.f11295a, true);
        } else {
            throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
        }
        if (drawable != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(bitmap));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void checkResource(@NonNull Context context) {
        Object obj;
        if (this.mType == 2 && (obj = this.f11295a) != null) {
            String str = (String) obj;
            if (str.contains(CertificateUtil.DELIMITER)) {
                String str2 = str.split(CertificateUtil.DELIMITER, -1)[1];
                String str3 = str2.split("/", -1)[0];
                String str4 = str2.split("/", -1)[1];
                String str5 = str.split(CertificateUtil.DELIMITER, -1)[0];
                if ("0_resource_name_obfuscated".equals(str4)) {
                    Log.i(TAG, "Found obfuscated resource, not trying to update resource id for it");
                    return;
                }
                String resPackage = getResPackage();
                int identifier = b(context, resPackage).getIdentifier(str4, str3, str5);
                if (this.mInt1 != identifier) {
                    Log.i(TAG, "Id has changed for " + resPackage + " " + str);
                    this.mInt1 = identifier;
                }
            }
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap getBitmap() {
        int i11 = this.mType;
        if (i11 == -1) {
            Object obj = this.f11295a;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i11 == 1) {
            return (Bitmap) this.f11295a;
        } else {
            if (i11 == 5) {
                return a((Bitmap) this.f11295a, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    @DrawableRes
    public int getResId() {
        int i11 = this.mType;
        if (i11 == -1) {
            return Api23Impl.c(this.f11295a);
        }
        if (i11 == 2) {
            return this.mInt1;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String getResPackage() {
        int i11 = this.mType;
        if (i11 == -1) {
            return Api23Impl.d(this.f11295a);
        }
        if (i11 == 2) {
            String str = this.mString1;
            if (str == null || TextUtils.isEmpty(str)) {
                return ((String) this.f11295a).split(CertificateUtil.DELIMITER, -1)[0];
            }
            return this.mString1;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        int i11 = this.mType;
        if (i11 == -1) {
            return Api23Impl.e(this.f11295a);
        }
        return i11;
    }

    @NonNull
    public Uri getUri() {
        int i11 = this.mType;
        if (i11 == -1) {
            return Api23Impl.f(this.f11295a);
        }
        if (i11 == 4 || i11 == 6) {
            return Uri.parse((String) this.f11295a);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InputStream getUriInputStream(@NonNull Context context) {
        Uri uri = getUri();
        String scheme = uri.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uri);
            } catch (Exception e11) {
                Log.w(TAG, "Unable to load image from URI: " + uri, e11);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f11295a));
            } catch (FileNotFoundException e12) {
                Log.w(TAG, "Unable to load image from path: " + uri, e12);
                return null;
            }
        }
    }

    @Nullable
    public Drawable loadDrawable(@NonNull Context context) {
        checkResource(context);
        return Api23Impl.g(toIcon(context), context);
    }

    public void onPostParceling() {
        this.f11296b = PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch (this.mType) {
            case -1:
                Parcelable parcelable = this.mParcelable;
                if (parcelable != null) {
                    this.f11295a = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                Parcelable parcelable2 = this.mParcelable;
                if (parcelable2 != null) {
                    this.f11295a = parcelable2;
                    return;
                }
                byte[] bArr = this.mData;
                this.f11295a = bArr;
                this.mType = 3;
                this.mInt1 = 0;
                this.mInt2 = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.mData, Charset.forName("UTF-16"));
                this.f11295a = str;
                if (this.mType == 2 && this.mString1 == null) {
                    this.mString1 = str.split(CertificateUtil.DELIMITER, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f11295a = this.mData;
                return;
            default:
                return;
        }
    }

    public void onPreParceling(boolean z11) {
        this.mTintModeStr = this.f11296b.name();
        switch (this.mType) {
            case -1:
                if (!z11) {
                    this.mParcelable = (Parcelable) this.f11295a;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 1:
            case 5:
                if (z11) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f11295a).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.mData = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.mParcelable = (Parcelable) this.f11295a;
                return;
            case 2:
                this.mData = ((String) this.f11295a).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.mData = (byte[]) this.f11295a;
                return;
            case 4:
            case 6:
                this.mData = this.f11295a.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
    }

    @NonNull
    public IconCompat setTint(@ColorInt int i11) {
        return setTintList(ColorStateList.valueOf(i11));
    }

    @NonNull
    public IconCompat setTintList(@Nullable ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        return this;
    }

    @NonNull
    public IconCompat setTintMode(@Nullable PorterDuff.Mode mode) {
        this.f11296b = mode;
        return this;
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        switch (this.mType) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f11295a);
                break;
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f11295a);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f11295a);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f11295a);
                break;
            default:
                throw new IllegalArgumentException("Invalid icon");
        }
        bundle.putInt("type", this.mType);
        bundle.putInt("int1", this.mInt1);
        bundle.putInt("int2", this.mInt2);
        bundle.putString("string1", this.mString1);
        ColorStateList colorStateList = this.mTintList;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f11296b;
        if (mode != f11294c) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    @RequiresApi(23)
    @NonNull
    @Deprecated
    public Icon toIcon() {
        return toIcon((Context) null);
    }

    @NonNull
    public String toString() {
        if (this.mType == -1) {
            return String.valueOf(this.f11295a);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(typeToString(this.mType));
        switch (this.mType) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f11295a).getWidth());
                sb2.append(Param.X);
                sb2.append(((Bitmap) this.f11295a).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.mString1);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", new Object[]{Integer.valueOf(getResId())}));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.mInt1);
                if (this.mInt2 != 0) {
                    sb2.append(" off=");
                    sb2.append(this.mInt2);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f11295a);
                break;
        }
        if (this.mTintList != null) {
            sb2.append(" tint=");
            sb2.append(this.mTintList);
        }
        if (this.f11296b != f11294c) {
            sb2.append(" mode=");
            sb2.append(this.f11296b);
        }
        sb2.append(")");
        return sb2.toString();
    }

    @RequiresApi(23)
    @NonNull
    public Icon toIcon(@Nullable Context context) {
        return Api23Impl.h(this, context);
    }

    @RequiresApi(23)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIcon(@NonNull Icon icon) {
        return Api23Impl.b(icon);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createWithResource(@Nullable Resources resources, @NonNull String str, @DrawableRes int i11) {
        ObjectsCompat.requireNonNull(str);
        if (i11 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.mInt1 = i11;
            if (resources != null) {
                try {
                    iconCompat.f11295a = resources.getResourceName(i11);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f11295a = str;
            }
            iconCompat.mString1 = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull Uri uri) {
        ObjectsCompat.requireNonNull(uri);
        return createWithAdaptiveBitmapContentUri(uri.toString());
    }

    @NonNull
    public static IconCompat createWithContentUri(@NonNull Uri uri) {
        ObjectsCompat.requireNonNull(uri);
        return createWithContentUri(uri.toString());
    }

    public IconCompat(int i11) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.f11296b = f11294c;
        this.mTintModeStr = null;
        this.mType = i11;
    }
}
