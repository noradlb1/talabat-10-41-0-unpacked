package com.instabug.apm.util;

import com.instabug.library.transform.TransformationClass;
import com.instabug.library.transform.TransformationMethod;
import org.jetbrains.annotations.NotNull;

@TransformationClass
public interface WithInstabugName {
    @NotNull
    @TransformationMethod
    String getInstabugName();
}
