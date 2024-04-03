package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

interface CardViewDelegate {
    Drawable getCardBackground();

    View getCardView();

    boolean getPreventCornerOverlap();

    boolean getUseCompatPadding();

    void setCardBackground(Drawable drawable);

    void setMinWidthHeightInternal(int i11, int i12);

    void setShadowPadding(int i11, int i12, int i13, int i14);
}
