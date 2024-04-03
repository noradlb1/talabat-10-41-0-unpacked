package com.talabat.core.navigation.domain.screen.settings;

import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/settings/NotificationScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Landroid/os/Parcelable;", "data", "(Landroid/os/Parcelable;)V", "getData", "()Landroid/os/Parcelable;", "link", "", "getLink", "()Ljava/lang/String;", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NotificationScreen implements Screen<Parcelable> {
    @Nullable
    private final Parcelable data;
    @NotNull
    private final String link;

    public NotificationScreen() {
        this((Parcelable) null, 1, (DefaultConstructorMarker) null);
    }

    public NotificationScreen(@Nullable Parcelable parcelable) {
        this.data = parcelable;
        this.link = "android.settings.APP_NOTIFICATION_SETTINGS";
    }

    @Nullable
    public Parcelable getData() {
        return this.data;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotificationScreen(Parcelable parcelable, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : parcelable);
    }
}
