package com.instabug.featuresrequest.ui.featuresmain.mainallfeatures;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.instabug.featuresrequest.ui.base.featureslist.h;
import com.instabug.featuresrequest.ui.base.featureslist.n;

public class b extends h {
    public static b c(boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("sort_by_top_voted", z11);
        bundle.putBoolean("my_posts", false);
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    @NonNull
    public n K() {
        return new c(this, new com.instabug.featuresrequest.ui.base.b(a.e()));
    }
}
