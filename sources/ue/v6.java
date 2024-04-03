package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.GroceryDetailsViewScreen;

public final /* synthetic */ class v6 implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f57794b;

    public /* synthetic */ v6(GroceryDetailsViewScreen groceryDetailsViewScreen) {
        this.f57794b = groceryDetailsViewScreen;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return GroceryDetailsViewScreen.m9429setRecyclerView$lambda4(this.f57794b, textView, i11, keyEvent);
    }
}
