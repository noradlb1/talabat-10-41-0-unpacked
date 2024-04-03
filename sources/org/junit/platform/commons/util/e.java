package org.junit.platform.commons.util;

import j$.util.function.Supplier;
import java.nio.file.Path;

public final /* synthetic */ class e implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Path f28003a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28004b;

    public /* synthetic */ e(Path path, String str) {
        this.f28003a = path;
        this.f28004b = str;
    }

    public final Object get() {
        return String.format("The java.lang.Class loaded from path [%s] has a malformed class name [%s].", new Object[]{this.f28003a.toAbsolutePath(), this.f28004b});
    }
}
