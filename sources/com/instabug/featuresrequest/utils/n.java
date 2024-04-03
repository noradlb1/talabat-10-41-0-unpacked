package com.instabug.featuresrequest.utils;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.settings.SettingsManager;
import com.talabat.darkstores.common.view.ExpandCollapseTextView;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class n {
    public static void a(TextView textView, String str, String str2, @NonNull String str3, boolean z11, @Nullable Runnable runnable) {
        TextView textView2 = textView;
        String str4 = str;
        if (textView.getTag() == null) {
            textView.setTag(textView.getText());
        }
        if (str.length() < 170) {
            textView.setText(str);
            return;
        }
        if (z11) {
            String str5 = str.substring(0, Opcodes.TABLESWITCH) + ExpandCollapseTextView.ELLIPSIZE + str2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str5);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SettingsManager.getInstance().getPrimaryColor()), str5.length() - str2.length(), str5.length(), 33);
            spannableStringBuilder.setSpan(new k(textView, str, str2, str3, z11, runnable), str5.length() - str2.length(), str5.length(), 33);
            textView.setText(spannableStringBuilder);
        } else {
            String str6 = str2;
            String str7 = str + " " + str3;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str7);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(SettingsManager.getInstance().getPrimaryColor()), str7.length() - str3.length(), str7.length(), 33);
            spannableStringBuilder2.setSpan(new l(textView, str, str2, str3, z11, runnable), str7.length() - str3.length(), str7.length(), 33);
            textView.setText(spannableStringBuilder2);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
