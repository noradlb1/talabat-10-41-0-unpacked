package com.designsystem;

import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/designsystem/DSConfiguration;", "", "buttonM2Enabled", "", "buttonWithPriceM2Enabled", "smallButtonM2Enabled", "brandedButtonM2Enabled", "collapsibleQuantityStepperM2Enabled", "quantityStepperM2Enabled", "(ZZZZZZ)V", "getBrandedButtonM2Enabled", "()Z", "getButtonM2Enabled", "getButtonWithPriceM2Enabled", "getCollapsibleQuantityStepperM2Enabled", "getQuantityStepperM2Enabled", "getSmallButtonM2Enabled", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSConfiguration {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static DSConfiguration INSTANCE = null;
    @NotNull
    private static final String WarningTag = "DSConfiguration";
    /* access modifiers changed from: private */
    @NotNull
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    private final boolean brandedButtonM2Enabled;
    private final boolean buttonM2Enabled;
    private final boolean buttonWithPriceM2Enabled;
    private final boolean collapsibleQuantityStepperM2Enabled;
    private final boolean quantityStepperM2Enabled;
    private final boolean smallButtonM2Enabled;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fJ\r\u0010\u0015\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/designsystem/DSConfiguration$Companion;", "", "()V", "INSTANCE", "Lcom/designsystem/DSConfiguration;", "WarningTag", "", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "instance", "getInstance", "()Lcom/designsystem/DSConfiguration;", "initialize", "", "buttonM2Enabled", "", "buttonWithPriceM2Enabled", "smallButtonM2Enabled", "brandedButtonM2Enabled", "collapsibleQuantityStepperM2Enabled", "quantityStepperM2Enabled", "reset", "reset$marshmallow_release", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void initialize$default(Companion companion, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            if ((i11 & 2) != 0) {
                z12 = false;
            }
            if ((i11 & 4) != 0) {
                z13 = false;
            }
            if ((i11 & 8) != 0) {
                z14 = false;
            }
            if ((i11 & 16) != 0) {
                z15 = false;
            }
            if ((i11 & 32) != 0) {
                z16 = false;
            }
            companion.initialize(z11, z12, z13, z14, z15, z16);
        }

        @NotNull
        public final DSConfiguration getInstance() {
            DSConfiguration.initialized.get();
            DSConfiguration access$getINSTANCE$cp = DSConfiguration.INSTANCE;
            if (access$getINSTANCE$cp != null) {
                return access$getINSTANCE$cp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
            return null;
        }

        public final void initialize(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
            if (DSConfiguration.initialized.get()) {
                Log.w(DSConfiguration.WarningTag, "DSConfiguration has already been initialized!");
            } else if (!DSConfiguration.initialized.getAndSet(true)) {
                DSConfiguration.INSTANCE = new DSConfiguration(z11, z12, z13, z14, z15, z16, (DefaultConstructorMarker) null);
            }
        }

        public final void reset$marshmallow_release() {
            DSConfiguration.initialized.set(false);
        }
    }

    private DSConfiguration(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.buttonM2Enabled = z11;
        this.buttonWithPriceM2Enabled = z12;
        this.smallButtonM2Enabled = z13;
        this.brandedButtonM2Enabled = z14;
        this.collapsibleQuantityStepperM2Enabled = z15;
        this.quantityStepperM2Enabled = z16;
    }

    public /* synthetic */ DSConfiguration(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, z12, z13, z14, z15, z16);
    }

    public final boolean getBrandedButtonM2Enabled() {
        return this.brandedButtonM2Enabled;
    }

    public final boolean getButtonM2Enabled() {
        return this.buttonM2Enabled;
    }

    public final boolean getButtonWithPriceM2Enabled() {
        return this.buttonWithPriceM2Enabled;
    }

    public final boolean getCollapsibleQuantityStepperM2Enabled() {
        return this.collapsibleQuantityStepperM2Enabled;
    }

    public final boolean getQuantityStepperM2Enabled() {
        return this.quantityStepperM2Enabled;
    }

    public final boolean getSmallButtonM2Enabled() {
        return this.smallButtonM2Enabled;
    }
}
