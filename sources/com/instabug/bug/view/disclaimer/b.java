package com.instabug.bug.view.disclaimer;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.instabug.library.R;
import com.instabug.library.core.ui.InstabugBaseFragment;

public class b extends InstabugBaseFragment {
    @Nullable
    public a G;
    @Nullable
    public TextView H;

    public static b a(a aVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("disclaimer", aVar);
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    public int i0() {
        return R.layout.instabug_lyt_disclaimer_details;
    }

    public void j0(View view, @Nullable Bundle bundle) {
        TextView textView;
        this.H = (TextView) i(R.id.instabug_disclaimer_details);
        if (getArguments() != null) {
            a aVar = (a) getArguments().getSerializable("disclaimer");
            this.G = aVar;
            if (aVar != null && (textView = this.H) != null) {
                textView.setText(String.valueOf(aVar.b()));
            }
        }
    }
}
