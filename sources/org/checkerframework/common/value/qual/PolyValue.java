package org.checkerframework.common.value.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.PolymorphicQualifier;

@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@PolymorphicQualifier(UnknownVal.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface PolyValue {
}
