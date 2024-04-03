package com.github.rubensousa.gravitysnaphelper;

import androidx.annotation.Nullable;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

@Deprecated
public class GravityPagerSnapHelper extends GravitySnapHelper {
    public GravityPagerSnapHelper(int i11) {
        this(i11, (GravitySnapHelper.SnapListener) null);
    }

    public GravityPagerSnapHelper(int i11, @Nullable GravitySnapHelper.SnapListener snapListener) {
        super(i11, false, snapListener);
        setMaxFlingSizeFraction(1.0f);
        setScrollMsPerInch(50.0f);
    }
}
