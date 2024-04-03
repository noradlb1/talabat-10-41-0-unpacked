package com.uxcam.video.screen.codec.codecs.h264.io.model;

import androidx.core.view.InputDeviceCompat;
import com.uxcam.internals.aj;
import com.uxcam.internals.ak;
import com.uxcam.internals.aq;
import com.uxcam.internals.ar;
import com.uxcam.internals.dv;

public class ScalingList {
    public int[] scalingList;
    public boolean useDefaultScalingMatrixFlag;

    public static ScalingList read(aj ajVar, int i11) {
        boolean z11;
        ScalingList scalingList2 = new ScalingList();
        scalingList2.scalingList = new int[i11];
        int i12 = 8;
        int i13 = 8;
        for (int i14 = 0; i14 < i11; i14++) {
            if (i12 != 0) {
                i12 = ((aq.a(ajVar) + i13) + 256) % 256;
                if (i14 == 0 && i12 == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                scalingList2.useDefaultScalingMatrixFlag = z11;
            }
            int[] iArr = scalingList2.scalingList;
            if (i12 != 0) {
                i13 = i12;
            }
            iArr[i14] = i13;
        }
        return scalingList2;
    }

    public void write(ak akVar) {
        int i11 = 0;
        if (this.useDefaultScalingMatrixFlag) {
            ar.a(akVar, dv.a(0));
            return;
        }
        int i12 = 8;
        while (true) {
            int[] iArr = this.scalingList;
            if (i11 < iArr.length) {
                ar.a(akVar, dv.a((iArr[i11] - i12) + InputDeviceCompat.SOURCE_ANY));
                i12 = this.scalingList[i11];
                i11++;
            } else {
                return;
            }
        }
    }
}
