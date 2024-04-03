package org.junit.runners.parameterized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.runners.model.TestClass;

public class TestWithParameters {

    /* renamed from: name  reason: collision with root package name */
    private final String f62635name;
    private final List<Object> parameters;
    private final TestClass testClass;

    public TestWithParameters(String str, TestClass testClass2, List<Object> list) {
        notNull(str, "The name is missing.");
        notNull(testClass2, "The test class is missing.");
        notNull(list, "The parameters are missing.");
        this.f62635name = str;
        this.testClass = testClass2;
        this.parameters = Collections.unmodifiableList(new ArrayList(list));
    }

    private static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TestWithParameters testWithParameters = (TestWithParameters) obj;
        if (!this.f62635name.equals(testWithParameters.f62635name) || !this.parameters.equals(testWithParameters.parameters) || !this.testClass.equals(testWithParameters.testClass)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.f62635name;
    }

    public List<Object> getParameters() {
        return this.parameters;
    }

    public TestClass getTestClass() {
        return this.testClass;
    }

    public int hashCode() {
        return ((((this.f62635name.hashCode() + 14747) * 14747) + this.testClass.hashCode()) * 14747) + this.parameters.hashCode();
    }

    public String toString() {
        return this.testClass.getName() + " '" + this.f62635name + "' with parameters " + this.parameters;
    }
}
