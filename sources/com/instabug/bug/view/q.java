package com.instabug.bug.view;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.instabug.bug.R;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.DrawableUtils;
import com.instabug.library.util.InstabugAppData;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

@Instrumented
public class q extends DialogFragment implements TraceFieldInterface {
    public Trace _nr_trace;

    public static q b() {
        q qVar = new q();
        qVar.setArguments(new Bundle());
        return qVar;
    }

    @VisibleForTesting
    public void a(View view) {
        InstabugCore.handlePbiFooter(view);
    }

    @VisibleForTesting
    public String i0() {
        String str;
        if (getActivity() != null) {
            str = new InstabugAppData(getActivity().getApplicationContext()).getAppName();
            if (str == null) {
                InstabugSDKLogger.w("IBG-BR", "It seems app:name isn't defined in your manifest. Using a generic name instead");
            }
        } else {
            str = null;
        }
        Locale locale = InstabugCore.getLocale(getContext());
        int i11 = R.string.instabug_str_success_note;
        Context context = getContext();
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "App";
        }
        objArr[0] = str;
        return LocaleUtils.getLocaleStringResource(locale, i11, context, objArr);
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog.getWindow() != null) {
            onCreateDialog.getWindow().requestFeature(1);
        }
        return onCreateDialog;
    }

    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "q#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "q#onCreateView", (ArrayList<String>) null);
        }
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        new Handler().postDelayed(new o(this), 4000);
        if (getDialog() != null) {
            getDialog().setTitle(R.string.instabug_str_empty);
        }
        View inflate = layoutInflater.inflate(R.layout.ibg_bug_lyt_thanks, viewGroup);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setWindowAnimations(R.style.InstabugDialogAnimation);
            }
            if (getView() != null && AccessibilityUtils.isAccessibilityServiceEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(16384);
                if (getContext() != null) {
                    obtain.setClassName(getContext().getClass().getName());
                    obtain.setPackageName(getContext().getPackageName());
                }
                obtain.getText().add(LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(getContext()), R.string.ibg_bug_report_thanks_title_content_description, getContext()));
                TextView textView = (TextView) getView().findViewById(R.id.instabug_fragment_title);
                if (textView != null) {
                    obtain.getText().add(textView.getText());
                }
                TextView textView2 = (TextView) getView().findViewById(R.id.text_view_pb);
                if (textView2 != null) {
                    obtain.getText().add(textView2.getText());
                }
                if (getContext() != null) {
                    ((AccessibilityManager) getContext().getSystemService("accessibility")).sendAccessibilityEvent(obtain);
                }
            }
        }
    }

    public void onStop() {
        super.onStop();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Drawable drawable;
        int color;
        View findViewById;
        super.onViewCreated(view, bundle);
        if (!(getContext() == null || (findViewById = view.findViewById(R.id.ib_success_layout)) == null)) {
            DrawableUtils.setColor(findViewById, AttrResolver.getColor(getContext(), R.attr.instabug_background_color));
        }
        String placeHolder = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REPORT_SUCCESSFULLY_SENT, i0());
        TextView textView = (TextView) view.findViewById(R.id.instabug_txt_success_note);
        if (textView != null) {
            textView.setText(placeHolder);
        }
        a(view);
        TextView textView2 = (TextView) view.findViewById(com.instabug.library.R.id.instabug_fragment_title);
        if (textView2 != null) {
            textView2.setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.SUCCESS_DIALOG_HEADER, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(getContext()), R.string.instabug_str_thank_you, getContext())));
            if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                color = InstabugCore.getPrimaryColor();
            } else if (getContext() != null) {
                color = ContextCompat.getColor(getContext(), 17170443);
            }
            textView2.setTextColor(color);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.instabug_img_thanks);
        if (imageView != null) {
            imageView.setColorFilter(InstabugCore.getPrimaryColor());
            if (!(getContext() == null || (drawable = ContextCompat.getDrawable(getContext(), R.drawable.ibg_bug_shape_thanks_background)) == null)) {
                imageView.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(drawable));
            }
        }
        view.setOnClickListener(new p(this));
    }
}
