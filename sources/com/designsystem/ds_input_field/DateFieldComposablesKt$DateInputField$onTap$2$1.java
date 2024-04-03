package com.designsystem.ds_input_field;

import androidx.compose.runtime.MutableState;
import androidx.fragment.app.FragmentManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DateFieldComposablesKt$DateInputField$onTap$2$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f31560g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f31561h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f31562i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f31563j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableState<Long> f31564k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<Long, Unit> f31565l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableState<SimpleDateFormat> f31566m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f31567n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DateFieldComposablesKt$DateInputField$onTap$2$1(FragmentManager fragmentManager, long j11, long j12, MutableState<Boolean> mutableState, MutableState<Long> mutableState2, Function1<? super Long, Unit> function1, MutableState<SimpleDateFormat> mutableState3, MutableState<String> mutableState4) {
        super(0);
        this.f31560g = fragmentManager;
        this.f31561h = j11;
        this.f31562i = j12;
        this.f31563j = mutableState;
        this.f31564k = mutableState2;
        this.f31565l = function1;
        this.f31566m = mutableState3;
        this.f31567n = mutableState4;
    }

    public final void invoke() {
        if (!DateFieldComposablesKt.m8395DateInputField$lambda5(this.f31563j)) {
            Long r12 = DateFieldComposablesKt.m8390DateInputField$lambda1(this.f31564k);
            FragmentManager fragmentManager = this.f31560g;
            final Function1<Long, Unit> function1 = this.f31565l;
            final MutableState<Long> mutableState = this.f31564k;
            final MutableState<SimpleDateFormat> mutableState2 = this.f31566m;
            final MutableState<String> mutableState3 = this.f31567n;
            AnonymousClass1 r32 = new Function1<Long, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j11) {
                    DateFieldComposablesKt.m8394DateInputField$lambda2(mutableState, Long.valueOf(j11));
                    DateFieldComposablesKt.m8392DateInputField$lambda12(mutableState3, DateFieldComposablesKt.m8397DateInputField$lambda8(mutableState2).format(new Date(j11)));
                    Function1<Long, Unit> function1 = function1;
                    if (function1 != null) {
                        function1.invoke(Long.valueOf(j11));
                    }
                }
            };
            final MutableState<Boolean> mutableState4 = this.f31563j;
            AnonymousClass2 r42 = new Function0<Unit>() {
                public final void invoke() {
                    DateFieldComposablesKt.m8396DateInputField$lambda6(mutableState4, false);
                }
            };
            final MutableState<Boolean> mutableState5 = this.f31563j;
            DateFieldComposablesKt.showMaterialDatePicker(r12, fragmentManager, r32, r42, new Function0<Unit>() {
                public final void invoke() {
                    DateFieldComposablesKt.m8396DateInputField$lambda6(mutableState5, true);
                }
            }, this.f31561h, this.f31562i);
        }
    }
}
