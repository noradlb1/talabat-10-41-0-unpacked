package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import org.apache.commons.compress.archivers.zip.UnixStat;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static CharSequence a(@NonNull EditorInfo editorInfo, int i11) {
            return editorInfo.getInitialSelectedText(i11);
        }

        public static CharSequence b(@NonNull EditorInfo editorInfo, int i11, int i12) {
            return editorInfo.getInitialTextAfterCursor(i11, i12);
        }

        public static CharSequence c(@NonNull EditorInfo editorInfo, int i11, int i12) {
            return editorInfo.getInitialTextBeforeCursor(i11, i12);
        }

        public static void d(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i11) {
            editorInfo.setInitialSurroundingSubText(charSequence, i11);
        }
    }

    public static int a(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean containsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean containsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (containsKey && containsKey2) {
            return 4;
        }
        if (containsKey) {
            return 3;
        }
        if (containsKey2) {
            return 2;
        }
        return 0;
    }

    @NonNull
    public static String[] getContentMimeTypes(@NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] a11 = editorInfo.contentMimeTypes;
            if (a11 != null) {
                return a11;
            }
            return EMPTY_STRING_ARRAY;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        if (stringArray != null) {
            return stringArray;
        }
        return EMPTY_STRING_ARRAY;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i11) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.a(editorInfo, i11);
        }
        if (editorInfo.extras == null) {
            return null;
        }
        int min = Math.min(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int max = Math.max(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int i12 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int i13 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int i14 = max - min;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i13 - i12 != i14 || (charSequence = editorInfo.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        if ((i11 & 1) != 0) {
            return charSequence.subSequence(i12, i13);
        }
        return TextUtils.substring(charSequence, i12, i13);
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i11, int i12) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.b(editorInfo, i11, i12);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i13 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int min = Math.min(i11, charSequence.length() - i13);
        if ((i12 & 1) != 0) {
            return charSequence.subSequence(i13, min + i13);
        }
        return TextUtils.substring(charSequence, i13, min + i13);
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i11, int i12) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.c(editorInfo, i11, i12);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i13 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int min = Math.min(i11, i13);
        if ((i12 & 1) != 0) {
            return charSequence.subSequence(i13 - min, i13);
        }
        return TextUtils.substring(charSequence, i13 - min, i13);
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int i11, int i12) {
        if (i12 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i11));
        }
        if (i12 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i11));
    }

    private static boolean isPasswordInputType(int i11) {
        int i12 = i11 & UnixStat.PERM_MASK;
        return i12 == 129 || i12 == 225 || i12 == 18;
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i11) {
        int i12;
        int i13;
        Preconditions.checkNotNull(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.d(editorInfo, charSequence, i11);
            return;
        }
        int i14 = editorInfo.initialSelStart;
        int i15 = editorInfo.initialSelEnd;
        if (i14 > i15) {
            i12 = i15 - i11;
        } else {
            i12 = i14 - i11;
        }
        if (i14 > i15) {
            i13 = i14 - i11;
        } else {
            i13 = i15 - i11;
        }
        int length = charSequence.length();
        if (i11 < 0 || i12 < 0 || i13 > length) {
            setSurroundingText(editorInfo, (CharSequence) null, 0, 0);
        } else if (isPasswordInputType(editorInfo.inputType)) {
            setSurroundingText(editorInfo, (CharSequence) null, 0, 0);
        } else if (length <= 2048) {
            setSurroundingText(editorInfo, charSequence, i12, i13);
        } else {
            trimLongSurroundingText(editorInfo, charSequence, i12, i13);
        }
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.d(editorInfo, charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i11, int i12) {
        SpannableStringBuilder spannableStringBuilder;
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        if (charSequence != null) {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        } else {
            spannableStringBuilder = null;
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, spannableStringBuilder);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i11);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i12);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i11, int i12) {
        int i13;
        CharSequence charSequence2;
        int i14 = i12 - i11;
        if (i14 > 1024) {
            i13 = 0;
        } else {
            i13 = i14;
        }
        int i15 = 2048 - i13;
        int min = Math.min(charSequence.length() - i12, i15 - Math.min(i11, (int) (((double) i15) * 0.8d)));
        int min2 = Math.min(i11, i15 - min);
        int i16 = i11 - min2;
        if (isCutOnSurrogate(charSequence, i16, 0)) {
            i16++;
            min2--;
        }
        if (isCutOnSurrogate(charSequence, (i12 + min) - 1, 1)) {
            min--;
        }
        int i17 = min2 + i13 + min;
        if (i13 != i14) {
            charSequence2 = TextUtils.concat(new CharSequence[]{charSequence.subSequence(i16, i16 + min2), charSequence.subSequence(i12, min + i12)});
        } else {
            charSequence2 = charSequence.subSequence(i16, i17 + i16);
        }
        int i18 = min2 + 0;
        setSurroundingText(editorInfo, charSequence2, i18, i13 + i18);
    }
}
