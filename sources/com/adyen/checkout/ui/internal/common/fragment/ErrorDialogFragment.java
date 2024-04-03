package com.adyen.checkout.ui.internal.common.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;
import com.adyen.checkout.ui.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.net.UnknownHostException;
import java.util.ArrayList;

@Instrumented
public class ErrorDialogFragment extends AppCompatDialogFragment implements TraceFieldInterface {
    private static final String ARG_MESSAGE = "ARG_MESSAGE";
    private static final String ARG_TITLE = "ARG_TITLE";
    @NonNull
    public static final String TAG = (ErrorDialogFragment.class.getName() + ".TAG");
    public Trace _nr_trace;
    private Button mDismissButton;
    private TextView mMessageTextView;
    private TextView mTitleTextView;

    @NonNull
    private static String getMessageForThrowable(@NonNull Context context, @NonNull Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        if (th2 instanceof UnknownHostException) {
            sb2.append(context.getString(R.string.checkout_error_message_default));
            sb2.append("\n\n");
            sb2.append(context.getString(R.string.checkout_error_message_network_hint));
        } else {
            sb2.append(context.getString(R.string.checkout_error_message_default));
            String localizedMessage = th2.getLocalizedMessage();
            if (TextUtils.isEmpty(localizedMessage)) {
                localizedMessage = th2.getMessage();
            }
            if (!TextUtils.isEmpty(localizedMessage)) {
                sb2.append("\n\n");
                sb2.append(localizedMessage);
            }
        }
        return sb2.toString();
    }

    @NonNull
    public static ErrorDialogFragment newInstance(@NonNull Context context, @NonNull Throwable th2) {
        return newInstance((String) null, getMessageForThrowable(context, th2));
    }

    @NonNull
    public Dialog onCreateDialog(@NonNull Bundle bundle) {
        AppCompatDialog appCompatDialog = (AppCompatDialog) super.onCreateDialog(bundle);
        appCompatDialog.supportRequestWindowFeature(1);
        return appCompatDialog;
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "ErrorDialogFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ErrorDialogFragment#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.dialog_fragment_error, viewGroup);
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.textView_title);
        this.mMessageTextView = (TextView) inflate.findViewById(R.id.textView_message);
        this.mDismissButton = (Button) inflate.findViewById(R.id.button_dismiss);
        Bundle arguments = getArguments();
        String string = arguments.getString(ARG_TITLE);
        String string2 = arguments.getString(ARG_MESSAGE);
        TextView textView = this.mTitleTextView;
        if (TextUtils.isEmpty(string)) {
            string = getString(R.string.checkout_error_dialog_title);
        }
        textView.setText(string);
        TextView textView2 = this.mMessageTextView;
        if (TextUtils.isEmpty(string2)) {
            string2 = getString(R.string.checkout_error_message_default);
        }
        textView2.setText(string2);
        this.mDismissButton.setText(R.string.checkout_ok);
        this.mDismissButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ErrorDialogFragment.this.dismiss();
            }
        });
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void showIfNotShown(@NonNull FragmentManager fragmentManager) {
        String str = TAG;
        if (fragmentManager.findFragmentByTag(str) == null) {
            show(fragmentManager, str);
        }
    }

    @NonNull
    public static ErrorDialogFragment newInstance(@Nullable String str, @Nullable String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, str);
        bundle.putString(ARG_MESSAGE, str2);
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        errorDialogFragment.setArguments(bundle);
        return errorDialogFragment;
    }
}
