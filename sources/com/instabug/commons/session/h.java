package com.instabug.commons.session;

import com.instabug.commons.models.Incident;

public abstract /* synthetic */ class h {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f46340a;

    static {
        int[] iArr = new int[Incident.Type.values().length];
        iArr[Incident.Type.ANR.ordinal()] = 1;
        iArr[Incident.Type.FatalHang.ordinal()] = 2;
        iArr[Incident.Type.FatalCrash.ordinal()] = 3;
        iArr[Incident.Type.NonFatalCrash.ordinal()] = 4;
        iArr[Incident.Type.NDKCrash.ordinal()] = 5;
        iArr[Incident.Type.Termination.ordinal()] = 6;
        f46340a = iArr;
    }
}
