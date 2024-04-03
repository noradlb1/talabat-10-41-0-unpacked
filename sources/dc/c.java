package dc;

import com.instabug.commons.caching.h;
import java.io.File;
import java.io.FileFilter;

public final /* synthetic */ class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f47085a;

    public /* synthetic */ c(h hVar) {
        this.f47085a = hVar;
    }

    public final boolean accept(File file) {
        return h.a(this.f47085a, file);
    }
}
