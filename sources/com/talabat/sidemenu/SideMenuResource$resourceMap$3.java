package com.talabat.sidemenu;

import com.talabat.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Z)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SideMenuResource$resourceMap$3 extends Lambda implements Function1<Boolean, Integer> {
    public static final SideMenuResource$resourceMap$3 INSTANCE = new SideMenuResource$resourceMap$3();

    public SideMenuResource$resourceMap$3() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Boolean) obj).booleanValue());
    }

    @NotNull
    public final Integer invoke(boolean z11) {
        return Integer.valueOf(R.drawable.ic_m_sidemenu_home);
    }
}
