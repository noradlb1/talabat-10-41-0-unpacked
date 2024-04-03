package com.talabat.darkstores.feature.main;

import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/navigation/NavController;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresMainActivity$navController$2 extends Lambda implements Function0<NavController> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56448g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresMainActivity$navController$2(DarkstoresMainActivity darkstoresMainActivity) {
        super(0);
        this.f56448g = darkstoresMainActivity;
    }

    @NotNull
    public final NavController invoke() {
        return this.f56448g.setupNavController();
    }
}
