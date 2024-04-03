package com.talabat.darkstores.feature.cart.views;

import com.talabat.darkstores.feature.cart.model.CartCampaignProgressModel;
import io.reactivex.functions.Function3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0001*\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u00042\u0006\u0010\b\u001a\u0002H\u0005H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"<anonymous>", "R", "T1", "", "T2", "T3", "t1", "t2", "t3", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "io/reactivex/rxkotlin/Observables$combineLatest$3"}, k = 3, mv = {1, 6, 0})
public final class CartProgressViewModel$special$$inlined$combineLatest$2<T1, T2, T3, R> implements Function3<T1, T2, T3, R> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartProgressViewModel f56301a;

    public CartProgressViewModel$special$$inlined$combineLatest$2(CartProgressViewModel cartProgressViewModel) {
        this.f56301a = cartProgressViewModel;
    }

    @NotNull
    public final R apply(@NotNull T1 t12, @NotNull T2 t22, @NotNull T3 t32) {
        Intrinsics.checkParameterIsNotNull(t12, "t1");
        Intrinsics.checkParameterIsNotNull(t22, "t2");
        Intrinsics.checkParameterIsNotNull(t32, "t3");
        return this.f56301a.createState(((Float) t12).floatValue(), ((Float) t22).floatValue(), (CartCampaignProgressModel) t32);
    }
}
