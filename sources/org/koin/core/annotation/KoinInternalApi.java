package org.koin.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.PROPERTY})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lorg/koin/core/annotation/KoinInternalApi;", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RequiresOptIn(level = RequiresOptIn.Level.ERROR, message = "Used to extend current API with Koin API. Shouldn't be used outside of Koin API")
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface KoinInternalApi {
}
