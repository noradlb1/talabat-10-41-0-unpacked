package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.experimental.categories.Categories;
import org.junit.runner.manipulation.Filter;

public final class IncludeCategories extends CategoryFilterFactory {

    public static class IncludesAny extends Categories.CategoryFilter {
        public IncludesAny(List<Class<?>> list) {
            this((Set<Class<?>>) new HashSet(list));
        }

        public String describe() {
            return "includes " + super.describe();
        }

        public IncludesAny(Set<Class<?>> set) {
            super(true, set, true, (Set<Class<?>>) null);
        }
    }

    public Filter a(List<Class<?>> list) {
        return new IncludesAny(list);
    }
}
