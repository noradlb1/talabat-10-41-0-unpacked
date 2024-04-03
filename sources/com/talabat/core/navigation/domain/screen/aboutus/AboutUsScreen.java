package com.talabat.core.navigation.domain.screen.aboutus;

import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/aboutus/AboutUsScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "", "()V", "data", "getData", "()Ljava/lang/Void;", "link", "", "getLink", "()Ljava/lang/String;", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AboutUsScreen implements Screen {
    @Nullable
    private final Void data;
    @NotNull
    private final String link = "talabat.action.aboutUsScreen";

    @NotNull
    public String getLink() {
        return this.link;
    }

    @Nullable
    public Void getData() {
        return this.data;
    }
}
