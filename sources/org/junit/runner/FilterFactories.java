package org.junit.runner;

import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runner.manipulation.Filter;

class FilterFactories {
    public static FilterFactory a(Class<? extends FilterFactory> cls) throws FilterFactory.FilterNotCreatedException {
        try {
            return (FilterFactory) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e11) {
            throw new FilterFactory.FilterNotCreatedException(e11);
        }
    }

    public static FilterFactory b(String str) throws FilterFactory.FilterNotCreatedException {
        try {
            return a(Classes.getClass(str).asSubclass(FilterFactory.class));
        } catch (Exception e11) {
            throw new FilterFactory.FilterNotCreatedException(e11);
        }
    }

    public static Filter createFilter(String str, FilterFactoryParams filterFactoryParams) throws FilterFactory.FilterNotCreatedException {
        return b(str).createFilter(filterFactoryParams);
    }

    public static Filter createFilterFromFilterSpec(Request request, String str) throws FilterFactory.FilterNotCreatedException {
        String[] strArr;
        Description description = request.getRunner().getDescription();
        if (str.contains("=")) {
            strArr = str.split("=", 2);
        } else {
            strArr = new String[]{str, ""};
        }
        return createFilter(strArr[0], new FilterFactoryParams(description, strArr[1]));
    }

    public static Filter createFilter(Class<? extends FilterFactory> cls, FilterFactoryParams filterFactoryParams) throws FilterFactory.FilterNotCreatedException {
        return a(cls).createFilter(filterFactoryParams);
    }
}
