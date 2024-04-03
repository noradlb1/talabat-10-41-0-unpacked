package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.junit.internal.MethodSorter;

public class TestSuite implements Test {
    private String fName;
    private Vector<Test> fTests;

    public TestSuite() {
        this.fTests = new Vector<>(10);
    }

    private void addTestMethod(Method method, List<String> list, Class<?> cls) {
        String name2 = method.getName();
        if (!list.contains(name2)) {
            if (isPublicTestMethod(method)) {
                list.add(name2);
                addTest(createTest(cls, name2));
            } else if (isTestMethod(method)) {
                addTest(warning("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
            }
        }
    }

    private void addTestsFromTestCase(Class<?> cls) {
        this.fName = cls.getName();
        try {
            getTestConstructor(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                addTest(warning("Class " + cls.getName() + " is not public"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls2 = cls; Test.class.isAssignableFrom(cls2); cls2 = cls2.getSuperclass()) {
                for (Method addTestMethod : MethodSorter.getDeclaredMethods(cls2)) {
                    addTestMethod(addTestMethod, arrayList, cls);
                }
            }
            if (this.fTests.size() == 0) {
                addTest(warning("No tests found in " + cls.getName()));
            }
        } catch (NoSuchMethodException unused) {
            addTest(warning("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        }
    }

    public static Test createTest(Class<?> cls, String str) {
        Object obj;
        try {
            Constructor<?> testConstructor = getTestConstructor(cls);
            try {
                if (testConstructor.getParameterTypes().length == 0) {
                    obj = testConstructor.newInstance(new Object[0]);
                    if (obj instanceof TestCase) {
                        ((TestCase) obj).setName(str);
                    }
                } else {
                    obj = testConstructor.newInstance(new Object[]{str});
                }
                return (Test) obj;
            } catch (InstantiationException e11) {
                return warning("Cannot instantiate test case: " + str + " (" + exceptionToString(e11) + ")");
            } catch (InvocationTargetException e12) {
                return warning("Exception in constructor: " + str + " (" + exceptionToString(e12.getTargetException()) + ")");
            } catch (IllegalAccessException e13) {
                return warning("Cannot access test case: " + str + " (" + exceptionToString(e13) + ")");
            }
        } catch (NoSuchMethodException unused) {
            return warning("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
    }

    private static String exceptionToString(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static Constructor<?> getTestConstructor(Class<?> cls) throws NoSuchMethodException {
        try {
            return cls.getConstructor(new Class[]{String.class});
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(new Class[0]);
        }
    }

    private boolean isPublicTestMethod(Method method) {
        return isTestMethod(method) && Modifier.isPublic(method.getModifiers());
    }

    private boolean isTestMethod(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE);
    }

    private Test testCaseForClass(Class<?> cls) {
        Class<TestCase> cls2 = TestCase.class;
        if (cls2.isAssignableFrom(cls)) {
            return new TestSuite((Class<?>) cls.asSubclass(cls2));
        }
        return warning(cls.getCanonicalName() + " does not extend TestCase");
    }

    public static Test warning(final String str) {
        return new TestCase("warning") {
            public void runTest() {
                TestCase.fail(str);
            }
        };
    }

    public void addTest(Test test) {
        this.fTests.add(test);
    }

    public void addTestSuite(Class<? extends TestCase> cls) {
        addTest(new TestSuite((Class<?>) cls));
    }

    public int countTestCases() {
        Iterator<Test> it = this.fTests.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 += it.next().countTestCases();
        }
        return i11;
    }

    public String getName() {
        return this.fName;
    }

    public void run(TestResult testResult) {
        Iterator<Test> it = this.fTests.iterator();
        while (it.hasNext()) {
            Test next = it.next();
            if (!testResult.shouldStop()) {
                runTest(next, testResult);
            } else {
                return;
            }
        }
    }

    public void runTest(Test test, TestResult testResult) {
        test.run(testResult);
    }

    public void setName(String str) {
        this.fName = str;
    }

    public Test testAt(int i11) {
        return this.fTests.get(i11);
    }

    public int testCount() {
        return this.fTests.size();
    }

    public Enumeration<Test> tests() {
        return this.fTests.elements();
    }

    public String toString() {
        if (getName() != null) {
            return getName();
        }
        return super.toString();
    }

    public TestSuite(Class<?> cls) {
        this.fTests = new Vector<>(10);
        addTestsFromTestCase(cls);
    }

    public TestSuite(Class<? extends TestCase> cls, String str) {
        this((Class<?>) cls);
        setName(str);
    }

    public TestSuite(String str) {
        this.fTests = new Vector<>(10);
        setName(str);
    }

    public TestSuite(Class<?>... clsArr) {
        this.fTests = new Vector<>(10);
        for (Class<?> testCaseForClass : clsArr) {
            addTest(testCaseForClass(testCaseForClass));
        }
    }

    public TestSuite(Class<? extends TestCase>[] clsArr, String str) {
        this((Class<?>[]) clsArr);
        setName(str);
    }
}
