package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executor;

public class FontsContractCompat {
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final String PARCEL_FONT_RESULTS = "font_results";

    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final FontInfo[] mFonts;
        private final int mStatusCode;

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontFamilyResult(int i11, @Nullable FontInfo[] fontInfoArr) {
            this.mStatusCode = i11;
            this.mFonts = fontInfoArr;
        }

        public static FontFamilyResult a(int i11, @Nullable FontInfo[] fontInfoArr) {
            return new FontFamilyResult(i11, fontInfoArr);
        }

        public FontInfo[] getFonts() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }
    }

    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontInfo(@NonNull Uri uri, @IntRange(from = 0) int i11, @IntRange(from = 1, to = 1000) int i12, boolean z11, int i13) {
            this.mUri = (Uri) Preconditions.checkNotNull(uri);
            this.mTtcIndex = i11;
            this.mWeight = i12;
            this.mItalic = z11;
            this.mResultCode = i13;
        }

        public static FontInfo a(@NonNull Uri uri, @IntRange(from = 0) int i11, @IntRange(from = 1, to = 1000) int i12, boolean z11, int i13) {
            return new FontInfo(uri, i11, i12, z11, i13);
        }

        public int getResultCode() {
            return this.mResultCode;
        }

        @IntRange(from = 0)
        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        @NonNull
        public Uri getUri() {
            return this.mUri;
        }

        @IntRange(from = 1, to = 1000)
        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final int RESULT_OK = 0;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Retention(RetentionPolicy.SOURCE)
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i11) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }
    }

    private FontsContractCompat() {
    }

    @Nullable
    public static Typeface buildTypeface(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontInfo[] fontInfoArr) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    @NonNull
    public static FontFamilyResult fetchFonts(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        return FontProvider.b(context, fontRequest, cancellationSignal);
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFontSync(Context context, FontRequest fontRequest, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z11, int i11, int i12) {
        return requestFont(context, fontRequest, i12, z11, i11, ResourcesCompat.FontCallback.getHandler(handler), new TypefaceCompat.ResourcesCallbackAdapter(fontCallback));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    @Deprecated
    public static ProviderInfo getProvider(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        return FontProvider.c(packageManager, fontRequest, resources);
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fontInfoArr, cancellationSignal);
    }

    public static void requestFont(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontRequestCallback);
        FontRequestWorker.b(context.getApplicationContext(), fontRequest, 0, RequestExecutor.b(handler), callbackWithHandler);
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void resetCache() {
        FontRequestWorker.d();
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void resetTypefaceCache() {
        FontRequestWorker.d();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface requestFont(@NonNull Context context, @NonNull FontRequest fontRequest, int i11, boolean z11, @IntRange(from = 0) int i12, @NonNull Handler handler, @NonNull FontRequestCallback fontRequestCallback) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontRequestCallback, handler);
        if (z11) {
            return FontRequestWorker.c(context, fontRequest, callbackWithHandler, i11, i12);
        }
        return FontRequestWorker.b(context, fontRequest, i11, (Executor) null, callbackWithHandler);
    }
}
