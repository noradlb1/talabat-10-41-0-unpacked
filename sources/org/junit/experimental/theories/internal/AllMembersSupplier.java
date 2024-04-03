package org.junit.experimental.theories.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public class AllMembersSupplier extends ParameterSupplier {
    private final TestClass clazz;

    public static class MethodParameterValue extends PotentialAssignment {
        private final FrameworkMethod method;

        public String getDescription() throws PotentialAssignment.CouldNotGenerateValueException {
            return this.method.getName();
        }

        public Object getValue() throws PotentialAssignment.CouldNotGenerateValueException {
            boolean z11 = false;
            try {
                return this.method.invokeExplosively((Object) null, new Object[0]);
            } catch (IllegalArgumentException unused) {
                throw new RuntimeException("unexpected: argument length is checked");
            } catch (IllegalAccessException unused2) {
                throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
            } catch (Throwable th2) {
                DataPoint dataPoint = (DataPoint) this.method.getAnnotation(DataPoint.class);
                if (dataPoint == null || !AllMembersSupplier.isAssignableToAnyOf(dataPoint.ignoredExceptions(), th2)) {
                    z11 = true;
                }
                Assume.assumeTrue(z11);
                throw new PotentialAssignment.CouldNotGenerateValueException(th2);
            }
        }

        private MethodParameterValue(FrameworkMethod frameworkMethod) {
            this.method = frameworkMethod;
        }
    }

    public AllMembersSupplier(TestClass testClass) {
        this.clazz = testClass;
    }

    private void addArrayValues(ParameterSignature parameterSignature, String str, List<PotentialAssignment> list, Object obj) {
        for (int i11 = 0; i11 < Array.getLength(obj); i11++) {
            Object obj2 = Array.get(obj, i11);
            if (parameterSignature.canAcceptValue(obj2)) {
                list.add(PotentialAssignment.forValue(str + "[" + i11 + "]", obj2));
            }
        }
    }

    private void addDataPointsValues(Class<?> cls, ParameterSignature parameterSignature, String str, List<PotentialAssignment> list, Object obj) {
        if (cls.isArray()) {
            addArrayValues(parameterSignature, str, list, obj);
        } else if (Iterable.class.isAssignableFrom(cls)) {
            addIterableValues(parameterSignature, str, list, (Iterable) obj);
        }
    }

    private void addIterableValues(ParameterSignature parameterSignature, String str, List<PotentialAssignment> list, Iterable<?> iterable) {
        int i11 = 0;
        for (Object next : iterable) {
            if (parameterSignature.canAcceptValue(next)) {
                list.add(PotentialAssignment.forValue(str + "[" + i11 + "]", next));
            }
            i11++;
        }
    }

    private void addMultiPointFields(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (Field next : b(parameterSignature)) {
            addDataPointsValues(next.getType(), parameterSignature, next.getName(), list, getStaticFieldValue(next));
        }
    }

    private void addMultiPointMethods(ParameterSignature parameterSignature, List<PotentialAssignment> list) throws Throwable {
        for (FrameworkMethod next : c(parameterSignature)) {
            Class<?> returnType = next.getReturnType();
            if ((returnType.isArray() && parameterSignature.canPotentiallyAcceptType(returnType.getComponentType())) || Iterable.class.isAssignableFrom(returnType)) {
                try {
                    addDataPointsValues(returnType, parameterSignature, next.getName(), list, next.invokeExplosively((Object) null, new Object[0]));
                } catch (Throwable th2) {
                    DataPoints dataPoints = (DataPoints) next.getAnnotation(DataPoints.class);
                    if (dataPoints == null || !isAssignableToAnyOf(dataPoints.ignoredExceptions(), th2)) {
                        throw th2;
                    }
                    return;
                }
            }
        }
    }

    private void addSinglePointFields(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (Field next : d(parameterSignature)) {
            Object staticFieldValue = getStaticFieldValue(next);
            if (parameterSignature.canAcceptValue(staticFieldValue)) {
                list.add(PotentialAssignment.forValue(next.getName(), staticFieldValue));
            }
        }
    }

    private void addSinglePointMethods(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (FrameworkMethod next : e(parameterSignature)) {
            if (parameterSignature.canAcceptType(next.getType())) {
                list.add(new MethodParameterValue(next));
            }
        }
    }

    private Object getStaticFieldValue(Field field) {
        try {
            return field.get((Object) null);
        } catch (IllegalArgumentException unused) {
            throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("unexpected: getFields returned an inaccessible field");
        }
    }

    /* access modifiers changed from: private */
    public static boolean isAssignableToAnyOf(Class<?>[] clsArr, Object obj) {
        for (Class<?> isAssignableFrom : clsArr) {
            if (isAssignableFrom.isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    public Collection<Field> b(ParameterSignature parameterSignature) {
        List<FrameworkField> annotatedFields = this.clazz.getAnnotatedFields(DataPoints.class);
        ArrayList arrayList = new ArrayList();
        for (FrameworkField field : annotatedFields) {
            arrayList.add(field.getField());
        }
        return arrayList;
    }

    public Collection<FrameworkMethod> c(ParameterSignature parameterSignature) {
        return this.clazz.getAnnotatedMethods(DataPoints.class);
    }

    public Collection<Field> d(ParameterSignature parameterSignature) {
        List<FrameworkField> annotatedFields = this.clazz.getAnnotatedFields(DataPoint.class);
        ArrayList arrayList = new ArrayList();
        for (FrameworkField field : annotatedFields) {
            arrayList.add(field.getField());
        }
        return arrayList;
    }

    public Collection<FrameworkMethod> e(ParameterSignature parameterSignature) {
        return this.clazz.getAnnotatedMethods(DataPoint.class);
    }

    public List<PotentialAssignment> getValueSources(ParameterSignature parameterSignature) throws Throwable {
        ArrayList arrayList = new ArrayList();
        addSinglePointFields(parameterSignature, arrayList);
        addMultiPointFields(parameterSignature, arrayList);
        addSinglePointMethods(parameterSignature, arrayList);
        addMultiPointMethods(parameterSignature, arrayList);
        return arrayList;
    }
}
