package com.instabug.bug.view.visualusersteps.visitedscreens;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.instabug.bug.R;
import com.instabug.bug.model.f;
import com.instabug.bug.view.m;
import com.instabug.bug.view.reporting.ReportingContainerActivity;
import com.instabug.bug.view.visualusersteps.steppreview.b;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.ArrayList;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class e extends InstabugBaseFragment implements d {
    @VisibleForTesting
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f45970a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private m f45971b;

    /* renamed from: c  reason: collision with root package name */
    private String f45972c = "";

    /* renamed from: d  reason: collision with root package name */
    private c f45973d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f45974e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f45975f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f45976g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressDialog f45977h;

    public static e a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }

    private String g() {
        return PlaceHolderUtils.getPlaceHolder(getContext(), InstabugCustomTextPlaceHolder.Key.REPRO_STEPS_LIST_DESCRIPTION, R.string.IBGReproStepsListHeader);
    }

    private String l() {
        return PlaceHolderUtils.getPlaceHolder(getContext(), InstabugCustomTextPlaceHolder.Key.REPRO_STEPS_LIST_EMPTY_STATE_DESCRIPTION, R.string.IBGReproStepsListEmptyStateLabel);
    }

    private String o() {
        return PlaceHolderUtils.getPlaceHolder(getContext(), InstabugCustomTextPlaceHolder.Key.REPRO_STEPS_PROGRESS_DIALOG_BODY, R.string.instabug_str_dialog_message_preparing);
    }

    private void w() {
        if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            this.f45975f.setBackgroundDrawable(getResources().getDrawable(R.drawable.ibg_bug_vus_empty_view_background_light));
            return;
        }
        this.f45975f.setBackgroundDrawable(getResources().getDrawable(R.drawable.ibg_bug_vus_empty_view_background_dark));
        ((ViewGroup.MarginLayoutParams) this.f45975f.getLayoutParams()).setMargins(0, 0, 0, 0);
    }

    public void a() {
        ProgressDialog progressDialog;
        if (getActivity() != null && !getActivity().isFinishing() && (progressDialog = this.f45977h) != null && progressDialog.isShowing()) {
            this.f45977h.dismiss();
        }
    }

    public void a(int i11, f fVar) {
        i iVar = (i) this.C;
        if (!(iVar == null || getContext() == null)) {
            iVar.a(getContext(), i11, fVar);
        }
        this.C = iVar;
    }

    public void a(ArrayList arrayList) {
        LinearLayout linearLayout = this.f45976g;
        if (linearLayout != null && this.f45974e != null && this.f45975f != null && this.f45973d != null) {
            linearLayout.setVisibility(0);
            if (arrayList.isEmpty()) {
                this.f45974e.setVisibility(8);
                this.f45975f.setVisibility(0);
                this.f45975f.setText(l());
                w();
                return;
            }
            this.f45974e.setVisibility(0);
            this.f45975f.setVisibility(8);
            this.f45973d.b(arrayList);
        }
    }

    public void b() {
        ProgressDialog progressDialog = this.f45977h;
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                return;
            }
        } else if (getActivity() != null) {
            ProgressDialog progressDialog2 = new ProgressDialog(getActivity());
            this.f45977h = progressDialog2;
            progressDialog2.setCancelable(false);
            this.f45977h.setMessage(o());
        } else {
            return;
        }
        this.f45977h.show();
    }

    public void b(@NonNull b bVar) {
        m mVar;
        if (DiskUtils.isFileExist(bVar.b().replace(FileUtils.FLAG_ENCRYPTED, "")) && (mVar = this.f45971b) != null) {
            mVar.a(bVar);
        }
    }

    public int i0() {
        return R.layout.ibg_bug_fragment_repro_steps_list;
    }

    public void j0(View view, @Nullable Bundle bundle) {
        TextView textView = (TextView) i(R.id.instabug_vus_list_header);
        if (textView != null) {
            textView.setText(g());
        }
        if (getActivity() instanceof ReportingContainerActivity) {
            ((ReportingContainerActivity) getActivity()).c(R.string.ibg_bug_visited_screen_back_btn_content_description);
        }
        this.f45975f = (TextView) i(R.id.instabug_vus_empty_label);
        this.f45974e = (RecyclerView) i(R.id.instabug_vus_list);
        LinearLayout linearLayout = (LinearLayout) i(R.id.instabug_vus_list_container);
        this.f45976g = linearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        this.f45973d = new c(this);
        if (getContext() != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            RecyclerView recyclerView = this.f45974e;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(linearLayoutManager);
                this.f45974e.setAdapter(this.f45973d);
                this.f45974e.addItemDecoration(new DividerItemDecoration(this.f45974e.getContext(), linearLayoutManager.getOrientation()));
                BaseContract.Presenter presenter = this.C;
                if (presenter != null) {
                    ((i) presenter).b(getContext());
                }
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof m) {
            try {
                this.f45971b = (m) getActivity();
            } catch (Exception unused) {
                throw new RuntimeException("Must implement BugReportingActivityCallBack");
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(2);
        }
        this.f45970a = getArguments() == null ? "" : getArguments().getString("title");
        m mVar = this.f45971b;
        if (mVar != null) {
            this.f45972c = mVar.o();
            String str = this.f45970a;
            if (str != null) {
                this.f45971b.a(str);
            }
            this.f45971b.y();
        }
        this.C = new i(this);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.clear();
    }

    public void onDestroy() {
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((i) presenter).l();
        }
        m mVar = this.f45971b;
        if (mVar != null) {
            mVar.g();
            this.f45971b.a(this.f45972c);
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        ProgressDialog progressDialog;
        super.onDestroyView();
        if (getActivity() != null && !getActivity().isFinishing() && (progressDialog = this.f45977h) != null && progressDialog.isShowing()) {
            this.f45977h.dismiss();
        }
        this.f45977h = null;
        this.f45974e = null;
        this.f45976g = null;
        this.f45975f = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332 && getActivity() != null) {
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
