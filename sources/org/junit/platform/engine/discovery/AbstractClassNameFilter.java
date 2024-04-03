package org.junit.platform.engine.discovery;

import j$.util.Collection;
import j$.util.DesugarArrays;
import j$.util.Optional;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import java.util.List;
import java.util.regex.Pattern;
import l30.s;
import org.junit.platform.commons.util.Preconditions;

abstract class AbstractClassNameFilter implements ClassNameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final List<Pattern> f28024a;

    /* renamed from: b  reason: collision with root package name */
    public final String f28025b;

    public AbstractClassNameFilter(String... strArr) {
        Preconditions.notEmpty((T[]) strArr, "patterns array must not be null or empty");
        Preconditions.containsNoNullElements((T[]) strArr, "patterns array must not contain null elements");
        this.f28024a = (List) DesugarArrays.stream((T[]) strArr).map(new s()).collect(Collectors.toList());
        this.f28025b = (String) DesugarArrays.stream((T[]) strArr).collect(Collectors.joining("' OR '", "'", "'"));
    }

    public Optional<Pattern> b(String str) {
        return Collection.EL.stream(this.f28024a).filter(new a(str)).findAny();
    }

    public abstract Predicate<String> toPredicate();
}
