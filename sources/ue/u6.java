package ue;

import android.view.MotionEvent;
import android.view.View;
import com.talabat.GroceryDetailsViewScreen;

public final /* synthetic */ class u6 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f57773b;

    public /* synthetic */ u6(GroceryDetailsViewScreen groceryDetailsViewScreen) {
        this.f57773b = groceryDetailsViewScreen;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return GroceryDetailsViewScreen.m9428setRecyclerView$lambda3(this.f57773b, view, motionEvent);
    }
}
