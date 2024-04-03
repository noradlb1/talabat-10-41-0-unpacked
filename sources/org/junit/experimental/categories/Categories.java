package org.junit.experimental.categories;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class Categories extends Suite {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExcludeCategory {
        boolean matchAny() default true;

        Class<?>[] value() default {};
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface IncludeCategory {
        boolean matchAny() default true;

        Class<?>[] value() default {};
    }

    public Categories(Class<?> cls, RunnerBuilder runnerBuilder) throws InitializationError {
        super(cls, runnerBuilder);
        try {
            filter(CategoryFilter.categoryFilter(isAnyIncluded(cls), getIncludedCategory(cls), isAnyExcluded(cls), getExcludedCategory(cls)));
            assertNoCategorizedDescendentsOfUncategorizeableParents(getDescription());
        } catch (NoTestsRemainException e11) {
            throw new InitializationError((Throwable) e11);
        }
    }

    private static void assertNoCategorizedDescendentsOfUncategorizeableParents(Description description) throws InitializationError {
        if (!canHaveCategorizedChildren(description)) {
            assertNoDescendantsHaveCategoryAnnotations(description);
        }
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            assertNoCategorizedDescendentsOfUncategorizeableParents(it.next());
        }
    }

    private static void assertNoDescendantsHaveCategoryAnnotations(Description description) throws InitializationError {
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            Description next = it.next();
            if (next.getAnnotation(Category.class) == null) {
                assertNoDescendantsHaveCategoryAnnotations(next);
            } else {
                throw new InitializationError("Category annotations on Parameterized classes are not supported on individual methods.");
            }
        }
    }

    private static boolean canHaveCategorizedChildren(Description description) {
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next().getTestClass() == null) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static Set<Class<?>> createSet(Class<?>... clsArr) {
        HashSet hashSet = new HashSet();
        if (clsArr != null) {
            Collections.addAll(hashSet, clsArr);
        }
        return hashSet;
    }

    private static Set<Class<?>> getExcludedCategory(Class<?> cls) {
        Class[] clsArr;
        ExcludeCategory excludeCategory = (ExcludeCategory) cls.getAnnotation(ExcludeCategory.class);
        if (excludeCategory == null) {
            clsArr = null;
        } else {
            clsArr = excludeCategory.value();
        }
        return createSet(clsArr);
    }

    private static Set<Class<?>> getIncludedCategory(Class<?> cls) {
        Class[] clsArr;
        IncludeCategory includeCategory = (IncludeCategory) cls.getAnnotation(IncludeCategory.class);
        if (includeCategory == null) {
            clsArr = null;
        } else {
            clsArr = includeCategory.value();
        }
        return createSet(clsArr);
    }

    /* access modifiers changed from: private */
    public static boolean hasAssignableTo(Set<Class<?>> set, Class<?> cls) {
        for (Class<?> isAssignableFrom : set) {
            if (cls.isAssignableFrom(isAssignableFrom)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAnyExcluded(Class<?> cls) {
        ExcludeCategory excludeCategory = (ExcludeCategory) cls.getAnnotation(ExcludeCategory.class);
        if (excludeCategory == null || excludeCategory.matchAny()) {
            return true;
        }
        return false;
    }

    private static boolean isAnyIncluded(Class<?> cls) {
        IncludeCategory includeCategory = (IncludeCategory) cls.getAnnotation(IncludeCategory.class);
        if (includeCategory == null || includeCategory.matchAny()) {
            return true;
        }
        return false;
    }

    public static class CategoryFilter extends Filter {
        private final Set<Class<?>> excluded;
        private final boolean excludedAny;
        private final Set<Class<?>> included;
        private final boolean includedAny;

        public CategoryFilter(boolean z11, Set<Class<?>> set, boolean z12, Set<Class<?>> set2) {
            this.includedAny = z11;
            this.excludedAny = z12;
            this.included = copyAndRefine(set);
            this.excluded = copyAndRefine(set2);
        }

        private static Set<Class<?>> categories(Description description) {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, directCategories(description));
            Collections.addAll(hashSet, directCategories(parentDescription(description)));
            return hashSet;
        }

        public static CategoryFilter categoryFilter(boolean z11, Set<Class<?>> set, boolean z12, Set<Class<?>> set2) {
            return new CategoryFilter(z11, set, z12, set2);
        }

        private static Set<Class<?>> copyAndRefine(Set<Class<?>> set) {
            HashSet hashSet = new HashSet();
            if (set != null) {
                hashSet.addAll(set);
            }
            hashSet.remove((Object) null);
            return hashSet;
        }

        private static Class<?>[] directCategories(Description description) {
            if (description == null) {
                return new Class[0];
            }
            Category category = (Category) description.getAnnotation(Category.class);
            if (category == null) {
                return new Class[0];
            }
            return category.value();
        }

        public static CategoryFilter exclude(boolean z11, Class<?>... clsArr) {
            if (!hasNull(clsArr)) {
                return categoryFilter(true, (Set<Class<?>>) null, z11, Categories.createSet(clsArr));
            }
            throw new NullPointerException("has null category");
        }

        private boolean hasCorrectCategoryAnnotation(Description description) {
            Set<Class<?>> categories = categories(description);
            if (categories.isEmpty()) {
                return this.included.isEmpty();
            }
            if (!this.excluded.isEmpty()) {
                if (this.excludedAny) {
                    if (matchesAnyParentCategories(categories, this.excluded)) {
                        return false;
                    }
                } else if (matchesAllParentCategories(categories, this.excluded)) {
                    return false;
                }
            }
            if (this.included.isEmpty()) {
                return true;
            }
            if (this.includedAny) {
                return matchesAnyParentCategories(categories, this.included);
            }
            return matchesAllParentCategories(categories, this.included);
        }

        private static boolean hasNull(Class<?>... clsArr) {
            if (clsArr == null) {
                return false;
            }
            for (Class<?> cls : clsArr) {
                if (cls == null) {
                    return true;
                }
            }
            return false;
        }

        public static CategoryFilter include(boolean z11, Class<?>... clsArr) {
            if (!hasNull(clsArr)) {
                return categoryFilter(z11, Categories.createSet(clsArr), true, (Set<Class<?>>) null);
            }
            throw new NullPointerException("has null category");
        }

        private boolean matchesAllParentCategories(Set<Class<?>> set, Set<Class<?>> set2) {
            for (Class<?> t11 : set2) {
                if (!Categories.hasAssignableTo(set, t11)) {
                    return false;
                }
            }
            return true;
        }

        private boolean matchesAnyParentCategories(Set<Class<?>> set, Set<Class<?>> set2) {
            for (Class<?> t11 : set2) {
                if (Categories.hasAssignableTo(set, t11)) {
                    return true;
                }
            }
            return false;
        }

        private static Description parentDescription(Description description) {
            Class<?> testClass = description.getTestClass();
            if (testClass == null) {
                return null;
            }
            return Description.createSuiteDescription(testClass);
        }

        public String describe() {
            return toString();
        }

        public boolean shouldRun(Description description) {
            if (hasCorrectCategoryAnnotation(description)) {
                return true;
            }
            Iterator<Description> it = description.getChildren().iterator();
            while (it.hasNext()) {
                if (shouldRun(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            Object obj;
            StringBuilder sb2 = new StringBuilder("categories ");
            if (this.included.isEmpty()) {
                obj = "[all]";
            } else {
                obj = this.included;
            }
            sb2.append(obj);
            if (!this.excluded.isEmpty()) {
                sb2.append(" - ");
                sb2.append(this.excluded);
            }
            return sb2.toString();
        }

        public static CategoryFilter exclude(Class<?> cls) {
            return exclude(true, cls);
        }

        public static CategoryFilter include(Class<?> cls) {
            return include(true, cls);
        }

        public static CategoryFilter exclude(Class<?>... clsArr) {
            return exclude(true, clsArr);
        }

        public static CategoryFilter include(Class<?>... clsArr) {
            return include(true, clsArr);
        }
    }
}
