package com.instabug.apm.fragment;

import com.instabug.apm.util.WithInstabugName;
import com.instabug.library.transform.TransformationClass;
import com.instabug.library.transform.TransformationMethod;
import org.jetbrains.annotations.NotNull;

@TransformationClass
public interface InstabugSpannableFragment extends WithInstabugName {
    @NotNull
    @TransformationMethod
    /* synthetic */ String getInstabugName();
}
