package com.talabat.restaurants.v2.ui.viewmodels;

import androidx.paging.PagingData;
import datamodels.RestaurantListItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorListFragmentViewModelPaged$special$$inlined$map$1 implements Flow<PagingData<RestaurantListItemModel>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f61273b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VendorListFragmentViewModelPaged f61274c;

    public VendorListFragmentViewModelPaged$special$$inlined$map$1(Flow flow, VendorListFragmentViewModelPaged vendorListFragmentViewModelPaged) {
        this.f61273b = flow;
        this.f61274c = vendorListFragmentViewModelPaged;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow flow = this.f61273b;
        final VendorListFragmentViewModelPaged vendorListFragmentViewModelPaged = this.f61274c;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$special$$inlined$map$1$2$1 r0 = (com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f61278i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f61278i = r1
                    goto L_0x0018
                L_0x0013:
                    com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$special$$inlined$map$1$2$1 r0 = new com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$special$$inlined$map$1$2$1
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.f61277h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f61278i
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x004d
                L_0x0029:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r4
                    androidx.paging.PagingData r7 = (androidx.paging.PagingData) r7
                    com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$pagedVendors$1$1 r2 = new com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$pagedVendors$1$1
                    com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged r4 = r2
                    r5 = 0
                    r2.<init>(r4, r5)
                    androidx.paging.PagingData r7 = androidx.paging.PagingDataTransforms.insertSeparators$default(r7, r5, r2, r3, r5)
                    r0.f61278i = r3
                    java.lang.Object r7 = r8.emit(r7, r0)
                    if (r7 != r1) goto L_0x004d
                    return r1
                L_0x004d:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
