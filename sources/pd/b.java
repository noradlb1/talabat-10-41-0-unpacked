package pd;

import com.instabug.library.util.FileUtils;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class b implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f57169a;

    public /* synthetic */ b(String str) {
        this.f57169a = str;
    }

    public final boolean accept(File file, String str) {
        return FileUtils.lambda$getStateFiles$0(this.f57169a, file, str);
    }
}
