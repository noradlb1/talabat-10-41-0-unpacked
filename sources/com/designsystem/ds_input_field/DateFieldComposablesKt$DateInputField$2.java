package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DateFieldComposablesKt$DateInputField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OuterState f31541g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31542h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31543i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Function0<Unit>> f31544j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DateFieldComposablesKt$DateInputField$2(OuterState outerState, boolean z11, int i11, MutableState<Function0<Unit>> mutableState) {
        super(2);
        this.f31541g = outerState;
        this.f31542h = z11;
        this.f31543i = i11;
        this.f31544j = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Integer valueOf = Integer.valueOf(R.drawable.ds_calendar);
            OuterState outerState = this.f31541g;
            boolean z11 = this.f31542h;
            Function0 r32 = DateFieldComposablesKt.m8393DateInputField$lambda14(this.f31544j);
            int i12 = this.f31543i;
            InputFieldCommonComposablesKt.InputFieldTrailingIconContainer(valueOf, outerState, z11, r32, true, composer, ((i12 >> 18) & 112) | CpioConstants.C_ISBLK | ((i12 >> 12) & 896), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
