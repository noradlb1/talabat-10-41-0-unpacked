package com.instabug.bug.view.disclaimer;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.Nullable;
import com.instabug.bug.view.m;
import com.instabug.library.R;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.util.SystemServiceUtils;

public class d extends InstabugBaseFragment {
    @Nullable
    public m G;
    @Nullable
    public h H;
    @Nullable
    public ListView I;
    @Nullable
    public a J;
    public CharSequence K = "";

    public interface a {
        void a(a aVar);
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        a aVar2 = this.J;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public static d g() {
        return new d();
    }

    public int i0() {
        return R.layout.instabug_lyt_disclaimer;
    }

    public void j0(View view, @Nullable Bundle bundle) {
        h hVar;
        if (getActivity() != null) {
            SystemServiceUtils.hideInputMethod(getActivity());
        }
        if (getContext() != null) {
            this.H = new h(getContext(), e.a());
        }
        ListView listView = (ListView) i(R.id.instabug_disclaimer_list);
        this.I = listView;
        if (!(listView == null || (hVar = this.H) == null)) {
            listView.setAdapter(hVar);
            this.I.setOnItemClickListener(new c(this));
        }
        m mVar = this.G;
        if (mVar != null) {
            this.K = mVar.o();
            this.G.a(getLocalizedString(R.string.ib_str_report_data));
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof m) {
            try {
                this.J = (a) context;
                this.G = (m) getContext();
            } catch (ClassCastException unused) {
                throw new ClassCastException(context.toString() + " must implement DisclaimerFragment.Callbacks");
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public void onDestroy() {
        super.onDestroy();
        m mVar = this.G;
        if (mVar != null) {
            mVar.a(String.valueOf(this.K));
        }
    }

    public void onDetach() {
        super.onDetach();
        this.G = null;
    }
}
