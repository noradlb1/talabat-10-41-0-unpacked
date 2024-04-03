package com.materialedittext.validation;

import androidx.annotation.NonNull;
import java.util.regex.Pattern;

public class RegexpValidator extends METValidator {
    private Pattern pattern;

    public RegexpValidator(@NonNull String str, @NonNull String str2) {
        super(str);
        this.pattern = Pattern.compile(str2);
    }

    public boolean isValid(@NonNull CharSequence charSequence, boolean z11) {
        return this.pattern.matcher(charSequence).matches();
    }

    public RegexpValidator(@NonNull String str, @NonNull Pattern pattern2) {
        super(str);
        this.pattern = pattern2;
    }
}
