package com.instabug.survey.ui.survey.mcq;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.survey.R;
import com.instabug.survey.models.b;
import com.instabug.survey.ui.survey.c;
import com.instabug.survey.ui.survey.n;
import org.jetbrains.annotations.NotNull;

public abstract class a extends c implements d {
    @VisibleForTesting
    @Nullable
    public f N;
    @Nullable
    public GridView O;

    public static a a(boolean z11, b bVar, n nVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("question", bVar);
        bundle.putBoolean("should_change_container_height", z11);
        b bVar2 = new b();
        bVar2.setArguments(bundle);
        bVar2.a(nVar);
        return bVar2;
    }

    public void a(View view, String str) {
        b bVar = this.G;
        if (bVar != null) {
            bVar.a(str);
            n nVar = this.H;
            if (nVar != null) {
                nVar.a(this.G);
            }
        }
    }

    public void a(b bVar) {
        if (bVar != null && getActivity() != null && this.I != null) {
            if (bVar.e() != null) {
                this.I.setText(bVar.e());
            }
            g gVar = new g(getActivity(), bVar, this);
            this.N = gVar;
            GridView gridView = this.O;
            if (gridView != null) {
                gridView.setAdapter(gVar);
            }
            this.N.a(bVar.a());
        }
    }

    @Nullable
    public String f() {
        f fVar = this.N;
        if (fVar != null && fVar.a() != null) {
            return this.N.a();
        }
        if (getContext() == null) {
            return null;
        }
        Toast.makeText(getContext(), getLocalizedString(R.string.instabug_str_error_survey_without_answer), 0).show();
        return null;
    }

    public int i0() {
        return R.layout.instabug_dialog_mcq_survey;
    }

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        super.j0(view, bundle);
        this.I = (TextView) view.findViewById(R.id.instabug_text_view_question);
        this.O = (GridView) view.findViewById(R.id.instabug_survey_mcq_grid_view);
        g();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getArguments() != null) {
            this.G = (b) getArguments().getSerializable("question");
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        b bVar = this.G;
        if (bVar != null) {
            a(bVar);
        }
    }
}
