package org.junit.experimental.categories;

import java.util.ArrayList;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runner.FilterFactoryParams;
import org.junit.runner.manipulation.Filter;

abstract class CategoryFilterFactory implements FilterFactory {
    private List<Class<?>> parseCategories(String str) throws ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(",")) {
            arrayList.add(Classes.getClass(str2));
        }
        return arrayList;
    }

    public abstract Filter a(List<Class<?>> list);

    public Filter createFilter(FilterFactoryParams filterFactoryParams) throws FilterFactory.FilterNotCreatedException {
        try {
            return a(parseCategories(filterFactoryParams.getArgs()));
        } catch (ClassNotFoundException e11) {
            throw new FilterFactory.FilterNotCreatedException(e11);
        }
    }
}
