package com.instabug.apm.attributes.predicates;

import androidx.annotation.NonNull;

public interface UrlPredicate {
    boolean check(@NonNull String str);
}
