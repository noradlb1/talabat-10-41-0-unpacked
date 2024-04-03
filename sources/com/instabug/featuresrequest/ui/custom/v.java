package com.instabug.featuresrequest.ui.custom;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.google.android.exoplayer2.C;
import com.instabug.featuresrequest.R;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class v extends DialogFragment implements TraceFieldInterface {
    public Trace _nr_trace;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private TextView f46731a;

    public static v a() {
        return new v();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "v#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "v#onCreateView", (ArrayList<String>) null);
        }
        if (!(getDialog() == null || getDialog().getWindow() == null)) {
            getDialog().getWindow().requestFeature(1);
        }
        View inflate = layoutInflater.inflate(R.layout.ib_fr_thanks_dialog, viewGroup);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE", "STARVATION"})
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.feature_request_add_feature_thanks_msg);
        this.f46731a = textView;
        if (textView != null) {
            textView.setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.FEATURES_REQUEST_ADD_FEATURE_THANKS_MESSAGE, LocaleUtils.getLocaleStringResource(Instabug.getLocale(getContext()), R.string.feature_request_str_thanks_msg, getContext())));
            ImageView imageView = (ImageView) view.findViewById(R.id.instabug_img_thanks);
            if (imageView != null) {
                imageView.setColorFilter(SettingsManager.getInstance().getPrimaryColor());
                new Handler().postDelayed(new u(this), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            }
        }
    }
}
