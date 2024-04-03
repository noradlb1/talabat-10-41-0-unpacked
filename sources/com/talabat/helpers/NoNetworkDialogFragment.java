package com.talabat.helpers;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.google.android.exoplayer2.C;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.talabatcore.logger.LogManager;
import java.util.ArrayList;
import tracking.AppTracker;
import tracking.ScreenNames;

@Instrumented
public class NoNetworkDialogFragment extends DialogFragment implements TraceFieldInterface {
    private static final int DURATION = 5000;
    public static final String SCREEN_NAME_ARGUMENT = "screenName";
    public ImageView C;
    public Trace _nr_trace;
    private final Handler handler = new Handler();
    private TextView mNoNetworkDescription;
    private TextView mNoNetworkTitle;
    private Button mReTry;
    private Toolbar mToolbar;
    private NoInternetConnection noInternetConnection;
    private String trackScreenName = "";
    private String trackingErrorMessage = "";

    /* access modifiers changed from: private */
    public void foundDevice() {
        ObjectAnimator.ofFloat(this.C, "translationX", new float[]{0.0f, 25.0f, -25.0f, 25.0f, -25.0f, 15.0f, -15.0f, 6.0f, -6.0f, 0.0f}).setDuration(400).start();
    }

    /* access modifiers changed from: private */
    public void refresh() {
        AppTracker.retryConnectClicked(getActivity());
        if (isInternetOn() && getDialog() != null && getDialog().isShowing() && !isRemoving()) {
            AppTracker.connectionLostClosed(getActivity(), GlobalConstants.networkConnectionType);
            if ((getActivity() instanceof RestaurantsListScreenRefactor) && getActivity().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                LogManager.debug("[ALOVvl]: NoNetworkDialogFragment #1");
                ((RestaurantsListScreenRefactor) getActivity()).refreshScreen();
                dismiss();
            }
            this.noInternetConnection.onConnectionRetry();
            dismiss();
        }
        this.handler.postDelayed(new Runnable() {
            public void run() {
                NoNetworkDialogFragment.this.foundDevice();
            }
        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final boolean isInternetOn() {
        FragmentActivity activity = getActivity();
        getActivity();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) activity.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        if (activeNetworkInfo.getType() == 1) {
            GlobalConstants.networkConnectionType = "WIFI";
            return true;
        } else if (activeNetworkInfo.getType() != 0) {
            return false;
        } else {
            GlobalConstants.networkConnectionType = "Mobile Data";
            return true;
        }
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Bundle arguments = getArguments();
        String str = null;
        if (arguments != null) {
            str = arguments.getString("screenName", (String) null);
        }
        if (TalabatUtils.isNullOrEmpty(str)) {
            str = ScreenNames.CONNECTION_ERROR_SCREEN;
        }
        this.trackScreenName = str;
        this.noInternetConnection = (NoInternetConnection) context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "NoNetworkDialogFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "NoNetworkDialogFragment#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.no_network_fragment_ui, viewGroup);
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setFlags(1024, 1024);
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        NoNetworkWaveAnimation noNetworkWaveAnimation = (NoNetworkWaveAnimation) inflate.findViewById(R.id.content);
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
        this.mToolbar = toolbar;
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
        this.mNoNetworkTitle = (TextView) inflate.findViewById(R.id.no_network_header_txt);
        this.mNoNetworkDescription = (TextView) inflate.findViewById(R.id.no_network_description_txt);
        this.mReTry = (Button) inflate.findViewById(R.id.retry);
        this.C = (ImageView) inflate.findViewById(R.id.no_netwrk_img);
        this.mReTry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NoNetworkDialogFragment.this.refresh();
            }
        });
        try {
            if (!isInternetOn()) {
                this.trackingErrorMessage = getString(R.string.no_network_heading);
            } else {
                this.trackingErrorMessage = getResources().getString(R.string.server_error_msg);
            }
            AppTracker.connectionLostShown(getActivity(), this.trackingErrorMessage, this.trackScreenName);
            FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
            instance.recordException(new Exception(this.trackingErrorMessage + " in screen: " + this.trackScreenName));
        } catch (Exception unused2) {
            FirebaseCrashlytics instance2 = FirebaseCrashlytics.getInstance();
            instance2.recordException(new Exception("From Exception: " + this.trackingErrorMessage + " in screen: " + this.trackScreenName));
        }
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        GlobalConstants.isNetworkDialogShowing = false;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(-1, -1 - getStatusBarHeight());
        }
    }

    public void onStop() {
        super.onStop();
    }
}
