package com.instabug.commons.session;

import com.instabug.commons.models.Incident;

public abstract /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f46334a;

    static {
        int[] iArr = new int[Incident.Type.values().length];
        iArr[Incident.Type.NonFatalCrash.ordinal()] = 1;
        iArr[Incident.Type.ANR.ordinal()] = 2;
        iArr[Incident.Type.FatalHang.ordinal()] = 3;
        f46334a = iArr;
    }
}
