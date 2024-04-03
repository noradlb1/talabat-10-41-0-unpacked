package com.talabat.helpers;

import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;

@Instrumented
public class TalabatFragment extends Fragment implements Talabat, TraceFieldInterface {
    public Trace _nr_trace;
    private CustomDialog dialog;

    public void onDataError() {
    }

    public void onNetworkError() {
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                TalabatFragment.this.stopLodingPopup();
                if (volleyError instanceof ServerError) {
                    Toast.makeText(TalabatFragment.this.getActivity(), "Server Error", 1).show();
                } else if (volleyError instanceof NetworkError) {
                    Toast.makeText(TalabatFragment.this.getActivity(), "NetWork Connectivity Error", 1).show();
                } else if (volleyError instanceof AuthFailureError) {
                    Toast.makeText(TalabatFragment.this.getActivity(), "Authentication Failure", 1).show();
                } else {
                    volleyError.printStackTrace();
                }
            }
        };
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void startLodingPopup() {
        if (this.dialog == null) {
            this.dialog = new CustomDialog(getActivity());
        }
        this.dialog.show();
    }

    public void stopLodingPopup() {
        CustomDialog customDialog = this.dialog;
        if (customDialog != null) {
            customDialog.dismiss();
        }
    }
}
