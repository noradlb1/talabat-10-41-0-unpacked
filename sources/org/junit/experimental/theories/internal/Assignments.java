package org.junit.experimental.theories.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.TestClass;

public class Assignments {
    private final List<PotentialAssignment> assigned;
    private final TestClass clazz;
    private final List<ParameterSignature> unassigned;

    private Assignments(List<PotentialAssignment> list, List<ParameterSignature> list2, TestClass testClass) {
        this.unassigned = list2;
        this.assigned = list;
        this.clazz = testClass;
    }

    public static Assignments allUnassigned(Method method, TestClass testClass) {
        List<ParameterSignature> signatures = ParameterSignature.signatures(testClass.getOnlyConstructor());
        signatures.addAll(ParameterSignature.signatures(method));
        return new Assignments(new ArrayList(), signatures, testClass);
    }

    private ParameterSupplier buildParameterSupplierFromClass(Class<? extends ParameterSupplier> cls) throws Exception {
        Constructor[] constructors = cls.getConstructors();
        int length = constructors.length;
        int i11 = 0;
        while (i11 < length) {
            Constructor constructor = constructors[i11];
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length != 1 || !parameterTypes[0].equals(TestClass.class)) {
                i11++;
            } else {
                return (ParameterSupplier) constructor.newInstance(new Object[]{this.clazz});
            }
        }
        return (ParameterSupplier) cls.newInstance();
    }

    private List<PotentialAssignment> generateAssignmentsFromTypeAlone(ParameterSignature parameterSignature) {
        Class<?> type = parameterSignature.getType();
        if (type.isEnum()) {
            return new EnumSupplier(type).getValueSources(parameterSignature);
        }
        if (type.equals(Boolean.class) || type.equals(Boolean.TYPE)) {
            return new BooleanSupplier().getValueSources(parameterSignature);
        }
        return Collections.emptyList();
    }

    private int getConstructorParameterCount() {
        return ParameterSignature.signatures(this.clazz.getOnlyConstructor()).size();
    }

    private ParameterSupplier getSupplier(ParameterSignature parameterSignature) throws Exception {
        ParametersSuppliedBy parametersSuppliedBy = (ParametersSuppliedBy) parameterSignature.findDeepAnnotation(ParametersSuppliedBy.class);
        if (parametersSuppliedBy != null) {
            return buildParameterSupplierFromClass(parametersSuppliedBy.value());
        }
        return new AllMembersSupplier(this.clazz);
    }

    public Assignments assignNext(PotentialAssignment potentialAssignment) {
        ArrayList arrayList = new ArrayList(this.assigned);
        arrayList.add(potentialAssignment);
        List<ParameterSignature> list = this.unassigned;
        return new Assignments(arrayList, list.subList(1, list.size()), this.clazz);
    }

    public Object[] getActualValues(int i11, int i12) throws PotentialAssignment.CouldNotGenerateValueException {
        Object[] objArr = new Object[(i12 - i11)];
        for (int i13 = i11; i13 < i12; i13++) {
            objArr[i13 - i11] = this.assigned.get(i13).getValue();
        }
        return objArr;
    }

    public Object[] getAllArguments() throws PotentialAssignment.CouldNotGenerateValueException {
        return getActualValues(0, this.assigned.size());
    }

    public Object[] getArgumentStrings(boolean z11) throws PotentialAssignment.CouldNotGenerateValueException {
        int size = this.assigned.size();
        Object[] objArr = new Object[size];
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i11] = this.assigned.get(i11).getDescription();
        }
        return objArr;
    }

    public Object[] getConstructorArguments() throws PotentialAssignment.CouldNotGenerateValueException {
        return getActualValues(0, getConstructorParameterCount());
    }

    public Object[] getMethodArguments() throws PotentialAssignment.CouldNotGenerateValueException {
        return getActualValues(getConstructorParameterCount(), this.assigned.size());
    }

    public boolean isComplete() {
        return this.unassigned.size() == 0;
    }

    public ParameterSignature nextUnassigned() {
        return this.unassigned.get(0);
    }

    public List<PotentialAssignment> potentialsForNextUnassigned() throws Throwable {
        ParameterSignature nextUnassigned = nextUnassigned();
        List<PotentialAssignment> valueSources = getSupplier(nextUnassigned).getValueSources(nextUnassigned);
        if (valueSources.size() == 0) {
            return generateAssignmentsFromTypeAlone(nextUnassigned);
        }
        return valueSources;
    }
}
