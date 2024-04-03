package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    @SuppressLint({"NewApi"})
    public void setTransitionVisibility(@NonNull View view, int i11) {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, i11);
        } else if (sTryHiddenSetTransitionVisibility) {
            try {
                view.setTransitionVisibility(i11);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }
}
