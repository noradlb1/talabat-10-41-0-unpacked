package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthReminderData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthReminderDisplayMapper", f = "TMartGrowthReminderDisplayMapper.kt", i = {0, 1, 1}, l = {19, 26, 30}, m = "toDisplayModel", n = {"$this$toDisplayModel_u24lambda_u2d0", "this", "$this$toDisplayModel_u24lambda_u2d0"}, s = {"L$0", "L$0", "L$1"})
public final class TMartGrowthReminderDisplayMapper$toDisplayModel$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59190h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59191i;

    /* renamed from: j  reason: collision with root package name */
    public Object f59192j;

    /* renamed from: k  reason: collision with root package name */
    public Object f59193k;

    /* renamed from: l  reason: collision with root package name */
    public Object f59194l;

    /* renamed from: m  reason: collision with root package name */
    public Object f59195m;

    /* renamed from: n  reason: collision with root package name */
    public /* synthetic */ Object f59196n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthReminderDisplayMapper f59197o;

    /* renamed from: p  reason: collision with root package name */
    public int f59198p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthReminderDisplayMapper$toDisplayModel$1(TMartGrowthReminderDisplayMapper tMartGrowthReminderDisplayMapper, Continuation<? super TMartGrowthReminderDisplayMapper$toDisplayModel$1> continuation) {
        super(continuation);
        this.f59197o = tMartGrowthReminderDisplayMapper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59196n = obj;
        this.f59198p |= Integer.MIN_VALUE;
        return this.f59197o.toDisplayModel((TMartGrowthReminderData) null, this);
    }
}
