package com.instabug.survey.ui.survey.starrating;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.instabug.survey.R;
import com.instabug.survey.models.b;
import com.instabug.survey.ui.custom.g;
import com.instabug.survey.ui.custom.j;
import com.instabug.survey.ui.survey.c;
import com.instabug.survey.ui.survey.n;
import org.jetbrains.annotations.NotNull;

public abstract class a extends c implements g {
    @Nullable
    public j N;

    public static a a(boolean z11, b bVar, n nVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("question", bVar);
        bundle.putSerializable("should_change_container_height", Boolean.valueOf(z11));
        b bVar2 = new b();
        bVar2.setArguments(bundle);
        bVar2.a(nVar);
        return bVar2;
    }

    private void a(b bVar) {
        j jVar;
        if (bVar.a() != null && !bVar.a().isEmpty() && (jVar = this.N) != null) {
            jVar.a(Float.valueOf(bVar.a()).floatValue(), false);
        }
    }

    public void a(j jVar, float f11, boolean z11) {
        String str;
        b bVar = this.G;
        if (bVar != null) {
            if (f11 >= 1.0f) {
                str = ((int) f11) + "";
            } else {
                str = null;
            }
            bVar.a(str);
            n nVar = this.H;
            if (nVar != null) {
                nVar.c(this.G);
            }
        }
    }

    public void b(@Nullable b bVar) {
        if (this.I != null && bVar != null && bVar.e() != null) {
            this.I.setText(m0(bVar.e()));
            a(bVar);
        }
    }

    @Nullable
    public String f() {
        if (this.N == null) {
            return null;
        }
        return ((int) this.N.getRating()) + "";
    }

    public int i0() {
        return R.layout.instabug_star_rating_question;
    }

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        super.j0(view, bundle);
        j jVar = (j) view.findViewById(R.id.ib_ratingbar);
        this.N = jVar;
        if (jVar != null) {
            jVar.setOnRatingBarChangeListener(this);
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
        b(this.G);
    }
}
