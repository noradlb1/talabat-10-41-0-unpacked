package com.braze.ui.actions.brazeactions;

import com.braze.ui.actions.brazeactions.BrazeActionParser;
import com.braze.ui.actions.brazeactions.steps.StepData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BrazeActionParser$parse$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BrazeActionParser.ActionType f44023g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ StepData f44024h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazeActionParser$parse$1(BrazeActionParser.ActionType actionType, StepData stepData) {
        super(0);
        this.f44023g = actionType;
        this.f44024h = stepData;
    }

    @NotNull
    public final String invoke() {
        return "Performing Braze Action type " + this.f44023g + " with data " + this.f44024h;
    }
}
