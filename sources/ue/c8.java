package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.GroceryMenuSearchActivity;

public final /* synthetic */ class c8 implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuSearchActivity f57467b;

    public /* synthetic */ c8(GroceryMenuSearchActivity groceryMenuSearchActivity) {
        this.f57467b = groceryMenuSearchActivity;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57467b.lambda$initControls$0(textView, i11, keyEvent);
    }
}
