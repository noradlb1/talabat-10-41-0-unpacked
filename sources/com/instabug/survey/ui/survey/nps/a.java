package com.instabug.survey.ui.survey.nps;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.survey.R;
import com.instabug.survey.models.b;
import com.instabug.survey.ui.custom.NpsView;
import com.instabug.survey.ui.custom.d;
import com.instabug.survey.ui.survey.c;
import com.instabug.survey.ui.survey.n;
import org.jetbrains.annotations.NotNull;

public abstract class a extends c implements d {
    @Nullable
    public NpsView N;

    public static b a(boolean z11, b bVar, n nVar) {
        b bVar2 = new b();
        Bundle bundle = new Bundle();
        bundle.putBoolean("should_change_container_height", z11);
        bundle.putSerializable("question", bVar);
        bVar2.setArguments(bundle);
        bVar2.a(nVar);
        return bVar2;
    }

    public void a(@Nullable b bVar) {
        if (bVar != null) {
            if (!(this.I == null || bVar.e() == null)) {
                this.I.setText(m0(bVar.e()));
            }
            if (this.N != null && bVar.a() != null && bVar.a().length() > 0) {
                this.N.setScore(Integer.parseInt(bVar.a()));
            }
        }
    }

    public void c(int i11) {
        b bVar = this.G;
        if (bVar != null) {
            bVar.a(String.valueOf(i11));
            n nVar = this.H;
            if (nVar != null) {
                nVar.b(this.G);
            }
        }
    }

    @Nullable
    public String f() {
        b bVar = this.G;
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    public int i0() {
        return R.layout.instabug_dialog_nps_survey;
    }

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        TextView textView;
        super.j0(view, bundle);
        this.N = (NpsView) view.findViewById(R.id.instabug_survey_nps_layout);
        if (!(!AccessibilityUtils.isAccessibilityServiceEnabled() || (textView = this.I) == null || textView.getContentDescription() == null)) {
            String str = this.I.getContentDescription() + " " + getString(R.string.ibg_surveys_nps_less_likely_content_description) + ". " + getString(R.string.ibg_surveys_nps_very_likely_content_description);
            TextView textView2 = this.I;
            if (textView2 != null) {
                textView2.setContentDescription(str);
            }
        }
        NpsView npsView = this.N;
        if (npsView != null) {
            npsView.setOnSelectionListener(this);
        }
    }

    public String m0(String str) {
        return str;
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
        a(this.G);
    }
}
