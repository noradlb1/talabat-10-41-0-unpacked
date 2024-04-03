package kotlin.reflect.jvm.internal.impl.renderer;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public enum RenderingFormat {
    ;

    public static final class HTML extends RenderingFormat {
        public HTML(String str, int i11) {
            super(str, i11, (DefaultConstructorMarker) null);
        }

        @NotNull
        public String escape(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
        }
    }

    public static final class PLAIN extends RenderingFormat {
        public PLAIN(String str, int i11) {
            super(str, i11, (DefaultConstructorMarker) null);
        }

        @NotNull
        public String escape(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            return str;
        }
    }

    @NotNull
    public abstract String escape(@NotNull String str);
}
