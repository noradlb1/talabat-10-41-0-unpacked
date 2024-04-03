package com.instabug.bug.screenshot.viewhierarchy.utilities;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

public class b extends PasswordTransformationMethod {
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return new a(charSequence);
    }
}
