package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/braze/ui/actions/brazeactions/steps/RemoveFromCustomAttributeArrayStep;", "Lcom/braze/ui/actions/brazeactions/steps/BaseBrazeActionStep;", "()V", "isValid", "", "data", "Lcom/braze/ui/actions/brazeactions/steps/StepData;", "run", "", "context", "Landroid/content/Context;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RemoveFromCustomAttributeArrayStep extends BaseBrazeActionStep {
    @NotNull
    public static final RemoveFromCustomAttributeArrayStep INSTANCE = new RemoveFromCustomAttributeArrayStep();

    private RemoveFromCustomAttributeArrayStep() {
        super((DefaultConstructorMarker) null);
    }

    public boolean isValid(@NotNull StepData stepData) {
        Intrinsics.checkNotNullParameter(stepData, "data");
        if (!StepData.isArgCountInBounds$default(stepData, 2, (IntRange) null, 2, (Object) null) || !stepData.isArgString(0) || !stepData.isArgString(1)) {
            return false;
        }
        return true;
    }

    public void run(@NotNull Context context, @NotNull StepData stepData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stepData, "data");
        BaseBrazeActionStep.Companion.runOnUser$android_sdk_ui_release(Braze.Companion.getInstance(context), new RemoveFromCustomAttributeArrayStep$run$1(stepData));
    }
}
