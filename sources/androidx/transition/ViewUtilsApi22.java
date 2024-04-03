package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(@NonNull View view, int i11, int i12, int i13, int i14) {
        if (sTryHiddenSetLeftTopRightBottom) {
            try {
                view.setLeftTopRightBottom(i11, i12, i13, i14);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }
}
