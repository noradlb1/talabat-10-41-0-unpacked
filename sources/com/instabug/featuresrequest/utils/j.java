package com.instabug.featuresrequest.utils;

import android.content.res.ColorStateList;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.android.material.textfield.TextInputLayout;
import com.instabug.featuresrequest.R;
import com.instabug.library.Instabug;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class j {
    public static void a(TextInputLayout textInputLayout, int i11) {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mErrorView");
            declaredField.setAccessible(true);
            Field declaredField2 = TextView.class.getDeclaredField("mCurTextColor");
            declaredField2.setAccessible(true);
            declaredField2.set((TextView) declaredField.get(textInputLayout), Integer.valueOf(i11));
        } catch (Exception unused) {
        }
    }

    public static void b(@Nullable TextInputLayout textInputLayout, int i11) {
        if (textInputLayout != null) {
            try {
                Field declaredField = textInputLayout.getClass().getDeclaredField("mFocusedTextColor");
                declaredField.setAccessible(true);
                declaredField.set(textInputLayout, new ColorStateList(new int[][]{new int[0]}, new int[]{i11}));
                Method declaredMethod = textInputLayout.getClass().getDeclaredMethod("updateLabelState", new Class[]{Boolean.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(textInputLayout, new Object[]{Boolean.TRUE});
                if (Instabug.getApplicationContext() != null) {
                    a(textInputLayout, ContextCompat.getColor(Instabug.getApplicationContext(), R.color.ib_fr_add_comment_error));
                }
            } catch (Exception unused) {
            }
        }
    }
}
