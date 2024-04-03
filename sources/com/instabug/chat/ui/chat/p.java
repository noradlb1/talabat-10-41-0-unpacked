package com.instabug.chat.ui.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.instabug.chat.R;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.view.ScaleImageView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

@Instrumented
@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED", "ERADICATE_FIELD_NOT_NULLABLE"})
public class p extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f46236a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f46237b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ScaleImageView f46238c;

    /* renamed from: d  reason: collision with root package name */
    private float f46239d;

    /* renamed from: e  reason: collision with root package name */
    private float f46240e;

    public static p a(String str) {
        p pVar = new p();
        Bundle bundle = new Bundle();
        bundle.putString("img_url", str);
        pVar.setArguments(bundle);
        return pVar;
    }

    /* access modifiers changed from: private */
    public void a(@Nullable Bitmap bitmap) {
        if (bitmap != null) {
            this.f46238c.setImageBitmap(bitmap);
        } else if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.instabug_str_image_loading_error, 0).show();
        }
        if (this.f46237b.getVisibility() == 0) {
            this.f46237b.setVisibility(8);
        }
    }

    public float a(float f11, Context context) {
        return f11 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("p");
        try {
            TraceMachine.enterMethod(this._nr_trace, "p#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "p#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f46236a = getArguments().getString("img_url");
            TraceMachine.exitMethod();
            return;
        }
        if (bundle != null) {
            this.f46236a = bundle.getString("img_url");
        }
        TraceMachine.exitMethod();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "p#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "p#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.instabug_fragment_image_attachment_viewer, viewGroup, false);
        this.f46237b = (ProgressBar) inflate.findViewById(R.id.instabug_attachment_progress_bar);
        this.f46238c = (ScaleImageView) inflate.findViewById(R.id.instabug_img_attachment);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f46238c = null;
        this.f46237b = null;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("img_url", this.f46236a);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int a11 = (int) a(24.0f, getActivity());
            this.f46239d = (float) (displayMetrics.widthPixels - a11);
            this.f46240e = (float) (displayMetrics.heightPixels - a11);
            if (URLUtil.isValidUrl(this.f46236a)) {
                PoolProvider.postIOTask(new o(this));
            } else {
                BitmapUtils.loadBitmap(this.f46236a, this.f46238c, this.f46239d, this.f46240e);
            }
        }
    }
}
