package androidx.datastore.preferences.core;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PreferenceDataStoreFactory$create$delegate$1 extends Lambda implements Function0<File> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<File> f35731g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreFactory$create$delegate$1(Function0<? extends File> function0) {
        super(0);
        this.f35731g = function0;
    }

    @NotNull
    public final File invoke() {
        File invoke = this.f35731g.invoke();
        String extension = FilesKt__UtilsKt.getExtension(invoke);
        PreferencesSerializer preferencesSerializer = PreferencesSerializer.INSTANCE;
        if (Intrinsics.areEqual((Object) extension, (Object) preferencesSerializer.getFileExtension())) {
            return invoke;
        }
        throw new IllegalStateException(("File extension for file: " + invoke + " does not match required extension for Preferences file: " + preferencesSerializer.getFileExtension()).toString());
    }
}
