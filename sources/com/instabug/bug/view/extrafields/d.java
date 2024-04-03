package com.instabug.bug.view.extrafields;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.instabug.bug.R;
import com.instabug.bug.model.e;
import com.instabug.bug.n;
import com.instabug.bug.view.m;
import com.instabug.bug.view.reporting.ReportingContainerActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.DrawableUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.KeyboardUtils;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.SimpleTextWatcher;
import java.lang.ref.WeakReference;
import java.util.List;

public class d extends InstabugBaseFragment implements a {
    @VisibleForTesting
    @Nullable
    public String G;
    @Nullable
    public List H;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f45829c;

    /* renamed from: d  reason: collision with root package name */
    private long f45830d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f45831e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private m f45832f;

    /* renamed from: g  reason: collision with root package name */
    private String f45833g = "";

    public class a extends SimpleTextWatcher {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f45834a;

        public a(EditText editText) {
            this.f45834a = new WeakReference(editText);
        }

        public void afterTextChanged(Editable editable) {
            List list;
            super.afterTextChanged(editable);
            EditText editText = (EditText) this.f45834a.get();
            if (editText != null && (list = d.this.H) != null) {
                ((e) list.get(editText.getId())).a(editable.toString());
            }
        }
    }

    public static d a(@Nullable String str) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    private void g() {
        CharSequence charSequence;
        EditText a11;
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            List l11 = ((g) presenter).l();
            if (!(l11 == null || getContext() == null)) {
                this.f45829c = (LinearLayout) i(R.id.linearLayout);
                for (int i11 = 0; i11 < l11.size(); i11++) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ibg_bug_item_edittext, this.f45829c, false);
                    linearLayout.setId(i11);
                    e eVar = new e(linearLayout);
                    if (eVar.a() != null) {
                        EditText a12 = eVar.a();
                        if (((e) l11.get(i11)).f()) {
                            charSequence = ((e) l11.get(i11)).b() + " *";
                        } else {
                            charSequence = ((e) l11.get(i11)).b();
                        }
                        a12.setHint(charSequence);
                        if (((e) l11.get(i11)).e() != null) {
                            eVar.a().setText(((e) l11.get(i11)).e());
                        }
                        eVar.a().setId(i11);
                        eVar.a().addTextChangedListener(new a(eVar.a()));
                        eVar.a().setImeOptions(6);
                        if (AccessibilityUtils.isAccessibilityServiceEnabled() && (a11 = eVar.a()) != null) {
                            ViewCompat.setAccessibilityDelegate(a11, new b(this, l11, i11));
                        }
                    }
                    LinearLayout linearLayout2 = this.f45829c;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(linearLayout);
                    }
                }
            }
            this.H = l11;
        }
    }

    public void a(int i11) {
        new e(i(i11)).b();
    }

    public void b(int i11) {
        List list = this.H;
        if (list != null) {
            String localizedString = getLocalizedString(R.string.instabug_err_invalid_extra_field, ((e) list.get(i11)).b());
            e eVar = new e(i(i11));
            if (eVar.a() != null) {
                eVar.a().requestFocus();
            }
            eVar.a(localizedString);
        }
    }

    public int i0() {
        return R.layout.ibg_bug_lyt_extra_fields;
    }

    public void j0(View view, @Nullable Bundle bundle) {
        g();
    }

    public void l() {
        BaseContract.Presenter presenter = this.C;
        if (presenter != null && ((g) presenter).n()) {
            List list = this.H;
            if (list != null) {
                ((g) this.C).a(list);
            }
            this.f45831e = true;
            if (getContext() != null) {
                n.e().a();
            } else {
                InstabugSDKLogger.e("IBG-BR", "Couldn't commit the Bug due to Null context");
            }
            z();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof m) {
            try {
                this.f45832f = (m) getActivity();
            } catch (Exception unused) {
                throw new RuntimeException("Must implement BugReportingActivityCallback");
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(2);
        }
        if (getArguments() != null) {
            this.G = getArguments().getString("title");
        }
        this.C = new g(this);
        m mVar = this.f45832f;
        if (mVar != null) {
            this.f45833g = mVar.o();
            String str = this.G;
            if (str != null) {
                this.f45832f.a(str);
            }
            this.f45832f.y();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        MenuItem findItem;
        menuInflater.inflate(R.menu.ibg_bug_menu_extended_reporting, menu);
        int i11 = R.id.instabug_bugreporting_send;
        MenuItem findItem2 = menu.findItem(i11);
        MenuItem findItem3 = menu.findItem(R.id.instabug_bugreporting_next);
        if (findItem3 != null) {
            findItem3.setVisible(false);
        }
        if (findItem2 != null) {
            findItem2.setVisible(true);
            findItem2.setTitle(getLocalizedString(R.string.ibg_report_send_content_description));
        }
        if (getContext() != null && LocaleUtils.isRTL(InstabugCore.getLocale(getContext())) && (findItem = menu.findItem(i11)) != null) {
            menu.findItem(i11).setIcon(DrawableUtils.getRotateDrawable(findItem.getIcon(), 180.0f));
        }
    }

    public void onDestroy() {
        m mVar = this.f45832f;
        if (mVar != null) {
            mVar.g();
            this.f45832f.a(this.f45833g);
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        LinearLayout linearLayout = this.f45829c;
        if (linearLayout != null) {
            linearLayout.clearFocus();
            this.f45829c.removeAllViews();
        }
        this.f45829c = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f45831e || SystemClock.elapsedRealtime() - this.f45830d < 1000) {
            return false;
        }
        this.f45830d = SystemClock.elapsedRealtime();
        if (menuItem.getItemId() == R.id.instabug_bugreporting_send) {
            l();
            return true;
        }
        if (menuItem.getItemId() == 16908332 && getActivity() != null) {
            getActivity().onBackPressed();
        }
        return false;
    }

    public void onStart() {
        super.onStart();
        if (getActivity() instanceof ReportingContainerActivity) {
            ((ReportingContainerActivity) getActivity()).c(R.string.ibg_core_extended_report_ic_close_content_description);
        }
    }

    public void z() {
        if (getActivity() != null) {
            KeyboardUtils.hide(getActivity());
        }
        new Handler().postDelayed(new c(this), 200);
    }
}
