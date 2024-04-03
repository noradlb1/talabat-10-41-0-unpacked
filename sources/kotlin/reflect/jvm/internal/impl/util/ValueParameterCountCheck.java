package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ValueParameterCountCheck implements Check {
    @NotNull
    private final String description;

    public static final class AtLeast extends ValueParameterCountCheck {

        /* renamed from: n  reason: collision with root package name */
        private final int f24979n;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public AtLeast(int r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "must have at least "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " value parameter"
                r0.append(r1)
                r1 = 1
                if (r3 <= r1) goto L_0x0018
                java.lang.String r1 = "s"
                goto L_0x001a
            L_0x0018:
                java.lang.String r1 = ""
            L_0x001a:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 0
                r2.<init>(r0, r1)
                r2.f24979n = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.AtLeast.<init>(int):void");
        }

        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            if (functionDescriptor.getValueParameters().size() >= this.f24979n) {
                return true;
            }
            return false;
        }
    }

    public static final class Equals extends ValueParameterCountCheck {

        /* renamed from: n  reason: collision with root package name */
        private final int f24980n;

        public Equals(int i11) {
            super("must have exactly " + i11 + " value parameters", (DefaultConstructorMarker) null);
            this.f24980n = i11;
        }

        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            if (functionDescriptor.getValueParameters().size() == this.f24980n) {
                return true;
            }
            return false;
        }
    }

    public static final class NoValueParameters extends ValueParameterCountCheck {
        @NotNull
        public static final NoValueParameters INSTANCE = new NoValueParameters();

        private NoValueParameters() {
            super("must have no value parameters", (DefaultConstructorMarker) null);
        }

        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().isEmpty();
        }
    }

    public static final class SingleValueParameter extends ValueParameterCountCheck {
        @NotNull
        public static final SingleValueParameter INSTANCE = new SingleValueParameter();

        private SingleValueParameter() {
            super("must have a single value parameter", (DefaultConstructorMarker) null);
        }

        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            if (functionDescriptor.getValueParameters().size() == 1) {
                return true;
            }
            return false;
        }
    }

    private ValueParameterCountCheck(String str) {
        this.description = str;
    }

    public /* synthetic */ ValueParameterCountCheck(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @NotNull
    public String getDescription() {
        return this.description;
    }

    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }
}
