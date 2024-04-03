package com.talabat.mapper;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

class Mapping {

    /* renamed from: a  reason: collision with root package name */
    public final Field f61060a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f61061b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f61062c;

    /* renamed from: d  reason: collision with root package name */
    public final ModelMapper f61063d;

    public Mapping(Field field, String[] strArr, boolean z11, ModelMapper modelMapper) {
        this.f61060a = field;
        this.f61061b = Arrays.asList(strArr);
        this.f61062c = z11;
        this.f61063d = modelMapper;
    }
}
