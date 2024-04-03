package n30;

import j$.util.function.Supplier;
import java.io.File;

public final /* synthetic */ class c implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ File f26899a;

    public /* synthetic */ c(File file) {
        this.f26899a = file;
    }

    public final Object get() {
        return String.format("The supplied java.io.File [%s] must represent an existing directory", new Object[]{this.f26899a});
    }
}
