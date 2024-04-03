package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class JvmMemberSignature {

    public static final class Field extends JvmMemberSignature {
        @NotNull
        private final String desc;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f24742name;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Field(@NotNull String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "desc");
            this.f24742name = str;
            this.desc = str2;
        }

        @NotNull
        public String asString() {
            return getName() + AbstractJsonLexerKt.COLON + getDesc();
        }

        @NotNull
        public final String component1() {
            return getName();
        }

        @NotNull
        public final String component2() {
            return getDesc();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Field)) {
                return false;
            }
            Field field = (Field) obj;
            return Intrinsics.areEqual((Object) getName(), (Object) field.getName()) && Intrinsics.areEqual((Object) getDesc(), (Object) field.getDesc());
        }

        @NotNull
        public String getDesc() {
            return this.desc;
        }

        @NotNull
        public String getName() {
            return this.f24742name;
        }

        public int hashCode() {
            return (getName().hashCode() * 31) + getDesc().hashCode();
        }
    }

    public static final class Method extends JvmMemberSignature {
        @NotNull
        private final String desc;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f24743name;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Method(@NotNull String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "desc");
            this.f24743name = str;
            this.desc = str2;
        }

        @NotNull
        public String asString() {
            return getName() + getDesc();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Method)) {
                return false;
            }
            Method method = (Method) obj;
            return Intrinsics.areEqual((Object) getName(), (Object) method.getName()) && Intrinsics.areEqual((Object) getDesc(), (Object) method.getDesc());
        }

        @NotNull
        public String getDesc() {
            return this.desc;
        }

        @NotNull
        public String getName() {
            return this.f24743name;
        }

        public int hashCode() {
            return (getName().hashCode() * 31) + getDesc().hashCode();
        }
    }

    private JvmMemberSignature() {
    }

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract String asString();

    @NotNull
    public abstract String getDesc();

    @NotNull
    public abstract String getName();

    @NotNull
    public final String toString() {
        return asString();
    }
}
