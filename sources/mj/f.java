package mj;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.feature.search.SearchFragment;

public final /* synthetic */ class f implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f57034b;

    public /* synthetic */ f(RecyclerView recyclerView) {
        this.f57034b = recyclerView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return SearchFragment.m10066setupRecyclerView$lambda12$lambda11(this.f57034b, view, motionEvent);
    }
}
