package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(29)
class ViewUtilsApi29 extends ViewUtilsApi23 {
    public float getTransitionAlpha(@NonNull View view) {
        return view.getTransitionAlpha();
    }

    public void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    public void setLeftTopRightBottom(@NonNull View view, int i11, int i12, int i13, int i14) {
        view.setLeftTopRightBottom(i11, i12, i13, i14);
    }

    public void setTransitionAlpha(@NonNull View view, float f11) {
        view.setTransitionAlpha(f11);
    }

    public void setTransitionVisibility(@NonNull View view, int i11) {
        view.setTransitionVisibility(i11);
    }

    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
