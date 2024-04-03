package com.talabat.fluttercore.presentation;

import com.talabat.core.navigation.domain.Navigator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/navigation/domain/Navigator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatFlutterFragmentActivity$navigator$2 extends Lambda implements Function0<Navigator> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatFlutterFragmentActivity f59788g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatFlutterFragmentActivity$navigator$2(TalabatFlutterFragmentActivity talabatFlutterFragmentActivity) {
        super(0);
        this.f59788g = talabatFlutterFragmentActivity;
    }

    @NotNull
    public final Navigator invoke() {
        return this.f59788g.getNavigationCoreLibApi().getNavigator();
    }
}
