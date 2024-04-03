package com.talabat.sidemenu;

import com.talabat.R;
import com.talabat.configuration.country.Country;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/configuration/country/Country;", "invoke", "(Lcom/talabat/configuration/country/Country;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SideMenuResource$resourceMap$2 extends Lambda implements Function1<Country, Integer> {
    public static final SideMenuResource$resourceMap$2 INSTANCE = new SideMenuResource$resourceMap$2();

    public SideMenuResource$resourceMap$2() {
        super(1);
    }

    @NotNull
    public final Integer invoke(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "it");
        return Integer.valueOf(R.string.myaccount);
    }
}
