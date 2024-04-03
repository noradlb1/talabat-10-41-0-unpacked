package com.google.ads.mediation.customevent;

import androidx.annotation.RecentlyNonNull;
import com.google.ads.mediation.MediationServerParameters;

public final class CustomEventServerParameters extends MediationServerParameters {
    @RecentlyNonNull
    @MediationServerParameters.Parameter(name = "class_name", required = true)
    public String className;
    @RecentlyNonNull
    @MediationServerParameters.Parameter(name = "label", required = true)
    public String label;
    @RecentlyNonNull
    @MediationServerParameters.Parameter(name = "parameter", required = false)
    public String parameter = null;
}
