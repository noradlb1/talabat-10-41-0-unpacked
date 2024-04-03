package com.newrelic.agent.android.instrumentation;

public @interface ShadowMethod {
    boolean isStatic() default false;

    String scope() default "";
}
