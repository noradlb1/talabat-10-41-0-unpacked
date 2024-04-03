package n30;

import j$.util.function.Supplier;
import java.io.File;

public final /* synthetic */ class e implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ File f26900a;

    public /* synthetic */ e(File file) {
        this.f26900a = file;
    }

    public final Object get() {
        return String.format("The supplied java.io.File [%s] must represent an existing file", new Object[]{this.f26900a});
    }
}
