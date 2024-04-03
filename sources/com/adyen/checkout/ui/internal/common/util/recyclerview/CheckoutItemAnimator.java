package com.adyen.checkout.ui.internal.common.util.recyclerview;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;

public class CheckoutItemAnimator extends DefaultItemAnimator {
    public CheckoutItemAnimator(@NonNull Resources resources) {
        long integer = (long) resources.getInteger(17694720);
        setAddDuration(integer);
        setChangeDuration(integer);
        setMoveDuration(integer);
        setRemoveDuration(integer);
    }
}
