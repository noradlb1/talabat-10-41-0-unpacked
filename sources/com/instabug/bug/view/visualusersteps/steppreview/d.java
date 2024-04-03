package com.instabug.bug.view.visualusersteps.steppreview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import com.instabug.bug.R;
import com.instabug.bug.view.m;
import com.instabug.bug.view.reporting.ReportingContainerActivity;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.InstabugBaseFragment;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class d extends InstabugBaseFragment implements View.OnClickListener, c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private m f45950a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f45951b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f45952c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f45953d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private b f45954e;

    public static d a(b bVar) {
        d dVar = new d();
        dVar.setArguments(bVar.d());
        return dVar;
    }

    private void g() {
        ImageView imageView = this.f45952c;
        if (imageView != null) {
            imageView.requestFocus();
        }
    }

    public void a(boolean z11) {
        this.f45953d.setVisibility(z11 ? 0 : 4);
    }

    public void b(Bitmap bitmap) {
        this.f45952c.setVisibility(0);
        this.f45952c.setImageBitmap(bitmap);
        this.f45952c.requestFocusFromTouch();
    }

    public int i0() {
        return R.layout.ibg_bug_fragment_repro_step_preview;
    }

    public void j0(View view, @Nullable Bundle bundle) {
        if (getActivity() instanceof ReportingContainerActivity) {
            ((ReportingContainerActivity) getActivity()).c(R.string.feature_request_go_back);
        }
        view.setOnClickListener(this);
        this.f45952c = (ImageView) i(R.id.step_preview);
        this.f45953d = (ProgressBar) i(R.id.step_preview_prgressbar);
        h hVar = (h) this.C;
        ImageView imageView = this.f45952c;
        if (imageView != null) {
            imageView.setVisibility(4);
            b bVar = this.f45954e;
            if (bVar != null) {
                this.f45952c.setContentDescription(bVar.a().replace("Image", ""));
            }
        }
        b bVar2 = this.f45954e;
        if (!(bVar2 == null || hVar == null)) {
            hVar.d(bVar2.b());
        }
        this.C = hVar;
    }

    public void m() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof m) {
            try {
                this.f45950a = (m) getActivity();
            } catch (Exception unused) {
                throw new RuntimeException("Must implement BugReportingActivityCallBack");
            }
        }
    }

    public void onClick(View view) {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.C = new h(this);
        if (getArguments() != null) {
            this.f45954e = b.a(getArguments());
        }
        m mVar = this.f45950a;
        if (mVar != null) {
            this.f45951b = mVar.o();
            b bVar = this.f45954e;
            if (bVar != null) {
                this.f45950a.a(bVar.c());
            }
            this.f45950a.y();
        }
    }

    public void onDestroy() {
        if (this.f45950a != null) {
            BaseContract.Presenter presenter = this.C;
            if (presenter != null) {
                ((h) presenter).l();
            }
            String str = this.f45951b;
            if (str != null) {
                this.f45950a.a(str);
            }
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332 && getActivity() != null) {
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        super.onResume();
        g();
    }
}
