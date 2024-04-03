package com.talabat.helpers;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.exoplayer2.C;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.helpers.GlobalConstants;
import com.talabat.splash.presentation.ui.SplashActivity;
import java.util.ArrayList;
import tracking.AppTracker;
import tracking.ScreenNames;

@Instrumented
public class NoNetworkActivity extends Activity implements TraceFieldInterface {
    private static final int DURATION = 5000;
    public Trace _nr_trace;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60799b;
    private Handler mHandler = new Handler();
    private TextView mNoNetworkDescription;
    private TextView mNoNetworkTitle;
    private Button mReTry;
    private Toolbar mToolbar;
    private String screenName = "";
    private int serverErrorCode;
    private String trackingType = "";

    public static Intent callingIntent(Context context) {
        return new Intent(context, NoNetworkActivity.class);
    }

    /* access modifiers changed from: private */
    public void foundDevice() {
        ObjectAnimator.ofFloat(this.f60799b, "translationX", new float[]{0.0f, 25.0f, -25.0f, 25.0f, -25.0f, 15.0f, -15.0f, 6.0f, -6.0f, 0.0f}).setDuration(400).start();
    }

    /* access modifiers changed from: private */
    public void redirectFromNoNetworkToSplash() {
        AppTracker.connectionLostClosed(this, GlobalConstants.networkConnectionType);
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    public final boolean isInternetOn() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
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

    public void onCreate(Bundle bundle) {
        String str;
        TraceMachine.startTracing("NoNetworkActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "NoNetworkActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "NoNetworkActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.no_network_fragment_ui);
        this.mNoNetworkTitle = (TextView) findViewById(R.id.no_network_header_txt);
        this.mNoNetworkDescription = (TextView) findViewById(R.id.no_network_description_txt);
        this.serverErrorCode = getIntent().getIntExtra("errorCode", 100);
        if (!(getIntent() == null || getIntent().getStringExtra("screenName") == null)) {
            this.screenName = getIntent().getStringExtra("screenName");
        }
        if (!TalabatUtils.isNullOrEmpty(this.screenName)) {
            str = this.screenName;
        } else {
            str = ScreenNames.CONNECTION_ERROR_SCREEN;
        }
        this.screenName = str;
        this.mReTry = (Button) findViewById(R.id.retry);
        NoNetworkWaveAnimation noNetworkWaveAnimation = (NoNetworkWaveAnimation) findViewById(R.id.content);
        final Handler handler = new Handler();
        this.mToolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mNoNetworkTitle = (TextView) findViewById(R.id.no_network_header_txt);
        this.mNoNetworkDescription = (TextView) findViewById(R.id.no_network_description_txt);
        int i11 = this.serverErrorCode;
        if (i11 == GlobalConstants.serverErrorCode.NO_INTERNET_CONNECTION_CODE) {
            this.mNoNetworkTitle.setText(getString(R.string.no_network_heading));
            this.trackingType = getString(R.string.no_network_heading);
            this.mNoNetworkDescription.setText(getResources().getString(R.string.no_net_reasontxt));
        } else if (i11 == GlobalConstants.serverErrorCode.GEO_BLOCK_ERROR_CODE) {
            this.mNoNetworkTitle.setText(getString(R.string.geo_block_error_title));
            this.mNoNetworkDescription.setText(getResources().getString(R.string.geo_block_error_msg));
            this.trackingType = getResources().getString(R.string.geo_block_error_msg);
        } else if (i11 == GlobalConstants.serverErrorCode.NOT_RESPONDING_ERROR_CODE) {
            this.mNoNetworkTitle.setText(getString(R.string.server_error_title));
            this.mNoNetworkDescription.setText(getResources().getString(R.string.too_many_request_error_title));
            this.trackingType = getResources().getString(R.string.too_many_request_error_title);
        } else if (i11 == GlobalConstants.serverErrorCode.CONNECTION_TIMED_OUT_CODE) {
            this.mNoNetworkTitle.setText(getString(R.string.time_out_error_title));
            this.mNoNetworkDescription.setText(getResources().getString(R.string.server_error_msg));
            this.trackingType = getResources().getString(R.string.server_error_msg);
        } else {
            this.mNoNetworkTitle.setText(getString(R.string.server_error_title));
            this.mNoNetworkDescription.setText(getResources().getString(R.string.server_error_msg));
        }
        this.mReTry = (Button) findViewById(R.id.retry);
        this.f60799b = (ImageView) findViewById(R.id.no_netwrk_img);
        this.mReTry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppTracker.retryConnectClicked(NoNetworkActivity.this);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        NoNetworkActivity.this.foundDevice();
                    }
                }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                if (NoNetworkActivity.this.isInternetOn()) {
                    NoNetworkActivity.this.redirectFromNoNetworkToSplash();
                }
            }
        });
        try {
            AppTracker.connectionLostShown(this, this.trackingType, this.screenName);
        } catch (Exception unused2) {
        }
        TraceMachine.exitMethod();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
