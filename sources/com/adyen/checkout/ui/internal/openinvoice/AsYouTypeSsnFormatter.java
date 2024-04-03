package com.adyen.checkout.ui.internal.openinvoice;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AsYouTypeSsnFormatter implements TextWatcher {
    public static final int MAX_SIZE = 13;
    @NonNull
    public static final String SEPARATOR = " ";
    private static final Set<Integer> SPACING_INDEXES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{2, 5, 8})));
    private SsnInputCompleteCallback mCallback;
    private int mDeletePos;
    private boolean mIsTransforming;

    public interface SsnInputCompleteCallback {
        void onSsnInputFinished(@NonNull String str);
    }

    public AsYouTypeSsnFormatter(@Nullable SsnInputCompleteCallback ssnInputCompleteCallback) {
        this.mCallback = ssnInputCompleteCallback;
    }

    private boolean isSpacingIndex(int i11) {
        return SPACING_INDEXES.contains(Integer.valueOf(i11));
    }

    private void notifyListener(@NonNull String str) {
        SsnInputCompleteCallback ssnInputCompleteCallback = this.mCallback;
        if (ssnInputCompleteCallback != null) {
            ssnInputCompleteCallback.onSsnInputFinished(str.replace(" ", ""));
        }
    }

    public void afterTextChanged(@NonNull Editable editable) {
        if (!this.mIsTransforming) {
            StringBuilder sb2 = new StringBuilder(editable.toString());
            int i11 = this.mDeletePos;
            if (i11 > 0) {
                sb2.replace(i11 - 1, i11, "");
            }
            int i12 = 0;
            while (i12 < sb2.length()) {
                int i13 = i12 + 1;
                boolean equals = " ".equals(sb2.substring(i12, i13));
                if (equals && !isSpacingIndex(i12)) {
                    sb2.deleteCharAt(i12);
                } else if (isSpacingIndex(i12) && !equals) {
                    sb2.insert(i12, " ");
                }
                i12 = i13;
            }
            if (sb2.length() > 13) {
                sb2.delete(13, sb2.length());
            }
            if (!sb2.toString().equals(editable.toString())) {
                this.mIsTransforming = true;
                editable.replace(0, editable.length(), sb2.toString());
            }
            if (editable.length() == 13) {
                notifyListener(editable.toString());
            }
            this.mIsTransforming = false;
        }
    }

    public void beforeTextChanged(@NonNull CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(@NonNull CharSequence charSequence, int i11, int i12, int i13) {
        if (!this.mIsTransforming) {
            this.mDeletePos = -1;
            if (i13 == 0 && i12 == 1 && isSpacingIndex(i11 - 1)) {
                this.mDeletePos = i11;
            }
        }
    }
}
