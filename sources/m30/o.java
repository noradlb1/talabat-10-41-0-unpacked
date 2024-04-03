package m30;

import j$.lang.Iterable;
import j$.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class o {
    public static void a(TestDescriptor testDescriptor, TestDescriptor.Visitor visitor) {
        Preconditions.notNull(visitor, "Visitor must not be null");
        visitor.visit(testDescriptor);
        Iterable.EL.forEach(new LinkedHashSet(testDescriptor.getChildren()), new m(visitor));
    }

    public static Set b(TestDescriptor testDescriptor) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(testDescriptor.getChildren());
        for (TestDescriptor descendants : testDescriptor.getChildren()) {
            linkedHashSet.addAll(descendants.getDescendants());
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public static String c(TestDescriptor testDescriptor) {
        return testDescriptor.getDisplayName();
    }

    public static boolean d(TestDescriptor testDescriptor) {
        return testDescriptor.getType().isContainer();
    }

    public static boolean e(TestDescriptor testDescriptor) {
        return !testDescriptor.getParent().isPresent();
    }

    public static boolean f(TestDescriptor testDescriptor) {
        return testDescriptor.getType().isTest();
    }

    public static boolean g(TestDescriptor testDescriptor) {
        return false;
    }

    public static void h(TestDescriptor testDescriptor) {
        if (!testDescriptor.isRoot() && !i(testDescriptor)) {
            testDescriptor.removeFromHierarchy();
        }
    }

    public static boolean i(TestDescriptor testDescriptor) {
        Preconditions.notNull(testDescriptor, "TestDescriptor must not be null");
        if (testDescriptor.isTest() || testDescriptor.mayRegisterTests() || Collection.EL.stream(testDescriptor.getChildren()).anyMatch(new n())) {
            return true;
        }
        return false;
    }
}
