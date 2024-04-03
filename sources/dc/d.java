package dc;

import com.instabug.commons.caching.h;
import java.io.File;
import java.io.FileFilter;

public final /* synthetic */ class d implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f47086a;

    public /* synthetic */ d(h hVar) {
        this.f47086a = hVar;
    }

    public final boolean accept(File file) {
        return h.b(this.f47086a, file);
    }
}
