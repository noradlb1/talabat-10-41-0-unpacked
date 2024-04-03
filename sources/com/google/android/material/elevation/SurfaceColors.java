package com.google.android.material.elevation;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

public enum SurfaceColors {
    SURFACE_0(R.dimen.m3_sys_elevation_level0),
    SURFACE_1(R.dimen.m3_sys_elevation_level1),
    SURFACE_2(R.dimen.m3_sys_elevation_level2),
    SURFACE_3(R.dimen.m3_sys_elevation_level3),
    SURFACE_4(R.dimen.m3_sys_elevation_level4),
    SURFACE_5(R.dimen.m3_sys_elevation_level5);
    
    private final int elevationResId;

    private SurfaceColors(@DimenRes int i11) {
        this.elevationResId = i11;
    }

    @ColorInt
    public static int getColorForElevation(@NonNull Context context, @Dimension float f11) {
        return new ElevationOverlayProvider(context).compositeOverlay(MaterialColors.getColor(context, R.attr.colorSurface, 0), f11);
    }

    @ColorInt
    public int getColor(@NonNull Context context) {
        return getColorForElevation(context, context.getResources().getDimension(this.elevationResId));
    }
}
