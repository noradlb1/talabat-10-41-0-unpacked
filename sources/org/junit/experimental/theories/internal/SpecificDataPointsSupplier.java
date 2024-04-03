package org.junit.experimental.theories.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public class SpecificDataPointsSupplier extends AllMembersSupplier {
    public SpecificDataPointsSupplier(TestClass testClass) {
        super(testClass);
    }

    public Collection<Field> b(ParameterSignature parameterSignature) {
        Collection<Field> b11 = super.b(parameterSignature);
        String value = ((FromDataPoints) parameterSignature.getAnnotation(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (Field next : b11) {
            if (Arrays.asList(((DataPoints) next.getAnnotation(DataPoints.class)).value()).contains(value)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Collection<FrameworkMethod> c(ParameterSignature parameterSignature) {
        Collection<FrameworkMethod> c11 = super.c(parameterSignature);
        String value = ((FromDataPoints) parameterSignature.getAnnotation(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (FrameworkMethod next : c11) {
            if (Arrays.asList(((DataPoints) next.getAnnotation(DataPoints.class)).value()).contains(value)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Collection<Field> d(ParameterSignature parameterSignature) {
        Collection<Field> d11 = super.d(parameterSignature);
        String value = ((FromDataPoints) parameterSignature.getAnnotation(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (Field next : d11) {
            if (Arrays.asList(((DataPoint) next.getAnnotation(DataPoint.class)).value()).contains(value)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Collection<FrameworkMethod> e(ParameterSignature parameterSignature) {
        Collection<FrameworkMethod> e11 = super.e(parameterSignature);
        String value = ((FromDataPoints) parameterSignature.getAnnotation(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (FrameworkMethod next : e11) {
            if (Arrays.asList(((DataPoint) next.getAnnotation(DataPoint.class)).value()).contains(value)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
