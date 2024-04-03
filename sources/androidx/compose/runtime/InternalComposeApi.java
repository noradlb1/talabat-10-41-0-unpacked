package androidx.compose.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/compose/runtime/InternalComposeApi;", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RequiresOptIn(level = RequiresOptIn.Level.ERROR, message = "This is internal API for Compose modules that may change frequently and without warning.")
@Retention(RetentionPolicy.RUNTIME)
public @interface InternalComposeApi {
}
