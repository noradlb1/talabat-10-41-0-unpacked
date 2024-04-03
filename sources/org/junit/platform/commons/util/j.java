package org.junit.platform.commons.util;

import j$.util.function.Consumer;
import java.nio.file.Path;
import java.util.List;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClasspathScanner f28008b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Path f28009c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f28010d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ClassFilter f28011e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ List f28012f;

    public /* synthetic */ j(ClasspathScanner classpathScanner, Path path, String str, ClassFilter classFilter, List list) {
        this.f28008b = classpathScanner;
        this.f28009c = path;
        this.f28010d = str;
        this.f28011e = classFilter;
        this.f28012f = list;
    }

    public final void accept(Object obj) {
        this.f28008b.lambda$findClassesForPath$3(this.f28009c, this.f28010d, this.f28011e, this.f28012f, (Path) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
