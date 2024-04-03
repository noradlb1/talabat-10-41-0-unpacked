package com.adyen.checkout.ui.internal.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.ResourcesCompat;
import com.adyen.checkout.ui.R;

public class FixedSwitchCompat extends SwitchCompat {
    public FixedSwitchCompat(@NonNull Context context) {
        super(context);
        fixFontFamily(context);
    }

    private void fixFontFamily(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.fontFamily, 16843692});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            setTypeface(ResourcesCompat.getFont(context, resourceId));
        } else if (resourceId2 != 0) {
            setTypeface(ResourcesCompat.getFont(context, resourceId2));
        }
        obtainStyledAttributes.recycle();
    }

    public FixedSwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        fixFontFamily(context);
    }

    public FixedSwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        fixFontFamily(context);
    }
}
