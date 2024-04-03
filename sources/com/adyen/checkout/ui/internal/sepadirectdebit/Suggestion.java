package com.adyen.checkout.ui.internal.sepadirectdebit;

import androidx.annotation.NonNull;
import com.adyen.checkout.ui.internal.common.util.recyclerview.SimpleDiffCallback;

public class Suggestion implements SimpleDiffCallback.Comparable<Suggestion> {
    private String mName;
    private int mTargetIndex;
    private String mValue;

    public Suggestion(@NonNull String str, @NonNull String str2, int i11) {
        this.mName = str;
        this.mValue = str2;
        this.mTargetIndex = i11;
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    public int getTargetIndex() {
        return this.mTargetIndex;
    }

    @NonNull
    public String getValue() {
        return this.mValue;
    }

    public boolean isSameContent(@NonNull Suggestion suggestion) {
        return true;
    }

    public boolean isSameItem(@NonNull Suggestion suggestion) {
        return this.mName.equals(suggestion.mName);
    }
}
