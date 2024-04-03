package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltInsResourceLoader {
    @Nullable
    public final InputStream loadResource(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        ClassLoader classLoader = BuiltInsResourceLoader.class.getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemResourceAsStream(str);
        }
        URL resource = classLoader.getResource(str);
        if (resource == null) {
            return null;
        }
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(resource.openConnection());
        uRLConnection.setUseCaches(false);
        return uRLConnection.getInputStream();
    }
}
