package tracking.gtm.automation.utils;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Ltracking/gtm/automation/utils/FileUtils;", "", "()V", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileUtils {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u00020\n*\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Ltracking/gtm/automation/utils/FileUtils$Companion;", "", "()V", "getAbsoluteFilesPath", "Ljava/io/File;", "folder", "", "context", "Landroid/content/Context;", "writeToFileKotlin", "", "file", "data", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFile", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean deleteFile(@NotNull String str, @NotNull String str2, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(str2, "folder");
            Intrinsics.checkNotNullParameter(context, "context");
            return new File(getAbsoluteFilesPath(str2, context), str).delete();
        }

        @NotNull
        public final File getAbsoluteFilesPath(@NotNull String str, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(str, "folder");
            Intrinsics.checkNotNullParameter(context, "context");
            return new File(context.getExternalFilesDir((String) null), str);
        }

        @Nullable
        public final Object writeToFileKotlin(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Context context, @NotNull Continuation<? super Boolean> continuation) {
            return BuildersKt.withContext(Dispatchers.getIO(), new FileUtils$Companion$writeToFileKotlin$2(str3, context, str, str2, (Continuation<? super FileUtils$Companion$writeToFileKotlin$2>) null), continuation);
        }
    }
}
