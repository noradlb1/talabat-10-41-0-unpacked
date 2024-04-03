package com.talabat.observability.localTracer;

import android.os.Environment;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/observability/localTracer/FileOperator;", "", "()V", "Companion", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileOperator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/talabat/observability/localTracer/FileOperator$Companion;", "", "()V", "isExternalStorageWritable", "", "()Z", "saveToFile", "string", "", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isExternalStorageWritable() {
            return Intrinsics.areEqual((Object) "mounted", (Object) Environment.getExternalStorageState());
        }

        public final boolean saveToFile(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            if (!isExternalStorageWritable()) {
                return false;
            }
            FilesKt__FileReadWriteKt.writeText$default(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "traces.json"), str, (Charset) null, 2, (Object) null);
            return true;
        }
    }

    private FileOperator() {
    }
}
