package org.mockito.internal.util.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import z30.n;

public class SuperTypesLastSorter {
    private static final Comparator<Field> compareFieldsByName = new n();

    private SuperTypesLastSorter() {
    }

    public static List<Field> sortSuperTypesLast(Collection<? extends Field> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, compareFieldsByName);
        int i11 = 0;
        while (i11 < arrayList.size() - 1) {
            Field field = (Field) arrayList.get(i11);
            Class<?> type = field.getType();
            int i12 = i11 + 1;
            int i13 = i11;
            for (int i14 = i12; i14 < arrayList.size(); i14++) {
                Class<?> type2 = ((Field) arrayList.get(i14)).getType();
                if (type != type2 && type.isAssignableFrom(type2)) {
                    i13 = i14;
                }
            }
            if (i13 == i11) {
                i11 = i12;
            } else {
                arrayList.remove(i11);
                arrayList.add(i13, field);
            }
        }
        return arrayList;
    }
}
