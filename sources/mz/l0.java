package mz;

import com.uxcam.internals.ij;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class l0 implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23978a;

    public /* synthetic */ l0(String str) {
        this.f23978a = str;
    }

    public final boolean accept(File file, String str) {
        return ij.a(this.f23978a, file, str);
    }
}
