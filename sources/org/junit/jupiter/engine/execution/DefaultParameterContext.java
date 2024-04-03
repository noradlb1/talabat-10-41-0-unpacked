package org.junit.jupiter.engine.execution;

import com.google.firebase.analytics.FirebaseAnalytics;
import j$.util.Optional;
import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Parameter;
import java.util.List;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;
import z20.i;

class DefaultParameterContext implements ParameterContext {
    private final int index;
    private final Parameter parameter;
    private final Optional<Object> target;

    public DefaultParameterContext(Parameter parameter2, int i11, Optional<Object> optional) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.condition(z11, "index must be greater than or equal to zero");
        this.parameter = (Parameter) Preconditions.notNull(parameter2, "parameter must not be null");
        this.index = i11;
        this.target = (Optional) Preconditions.notNull(optional, "target must not be null");
    }

    public <A extends Annotation> Optional<A> findAnnotation(Class<A> cls) {
        return AnnotationUtils.findAnnotation(this.parameter, this.index, cls);
    }

    public <A extends Annotation> List<A> findRepeatableAnnotations(Class<A> cls) {
        return AnnotationUtils.findRepeatableAnnotations(this.parameter, this.index, cls);
    }

    public /* synthetic */ Executable getDeclaringExecutable() {
        return i.a(this);
    }

    public int getIndex() {
        return this.index;
    }

    public Parameter getParameter() {
        return this.parameter;
    }

    public Optional<Object> getTarget() {
        return this.target;
    }

    public boolean isAnnotated(Class<? extends Annotation> cls) {
        return AnnotationUtils.isAnnotated(this.parameter, this.index, cls);
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("parameter", this.parameter).append(FirebaseAnalytics.Param.INDEX, Integer.valueOf(this.index)).append("target", this.target).toString();
    }
}
