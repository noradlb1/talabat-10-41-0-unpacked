package org.koin.android.scope;

import android.app.Service;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lorg/koin/android/scope/ScopeService;", "Landroid/app/Service;", "Lorg/koin/android/scope/AndroidScopeComponent;", "initialiseScope", "", "(Z)V", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "scope$delegate", "Lkotlin/Lazy;", "onCreate", "", "onDestroy", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ScopeService extends Service implements AndroidScopeComponent {
    private final boolean initialiseScope;
    @NotNull
    private final Lazy scope$delegate;

    public ScopeService() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScopeService(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11);
    }

    @NotNull
    public Scope getScope() {
        return (Scope) this.scope$delegate.getValue();
    }

    public void onCreate() {
        super.onCreate();
        if (this.initialiseScope) {
            getScope().getLogger().debug(Intrinsics.stringPlus("Open Service Scope: ", getScope()));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        getScope().getLogger().debug(Intrinsics.stringPlus("Close service scope: ", getScope()));
        if (!getScope().getClosed()) {
            getScope().close();
        }
    }

    public ScopeService(boolean z11) {
        this.initialiseScope = z11;
        this.scope$delegate = ServiceExtKt.serviceScope(this);
    }
}
