package coil.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;

@MustBeDocumented
@Documented
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcoil/annotation/InternalCoilApi;", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RequiresOptIn(level = RequiresOptIn.Level.ERROR, message = "This is an internal Coil API that should not be used from outside of the `coil` package. No compatibility guarantees are provided.")
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface InternalCoilApi {
}
