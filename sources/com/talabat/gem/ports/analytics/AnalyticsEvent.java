package com.talabat.gem.ports.analytics;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.DslMarker;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.FUNCTION})
@DslMarker
@Retention(AnnotationRetention.SOURCE)
@Documented
@java.lang.annotation.Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/gem/ports/analytics/AnalyticsEvent;", "", "name", "", "supportedVersion", "", "()Ljava/lang/String;", "()I", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface AnalyticsEvent {
    String name();

    int supportedVersion() default 0;
}
