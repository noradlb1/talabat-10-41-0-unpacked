package com.talabat.gem.adapters.presentation;

import com.instabug.library.model.session.config.SessionsConfigParameter;
import com.talabat.gem.domain.entities.GemMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/talabat/gem/adapters/presentation/GemEntryViewData;", "", "()V", "mode", "Lcom/talabat/gem/domain/entities/GemMode;", "getMode$com_talabat_Components_gem_gem", "()Lcom/talabat/gem/domain/entities/GemMode;", "setMode$com_talabat_Components_gem_gem", "(Lcom/talabat/gem/domain/entities/GemMode;)V", "", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemEntryViewData {
    @Nullable
    private GemMode mode;

    @Nullable
    public final GemMode getMode$com_talabat_Components_gem_gem() {
        return this.mode;
    }

    @GemViewsDsl
    public final void mode(@NotNull GemMode gemMode) {
        Intrinsics.checkNotNullParameter(gemMode, SessionsConfigParameter.SYNC_MODE);
        this.mode = gemMode;
    }

    public final void setMode$com_talabat_Components_gem_gem(@Nullable GemMode gemMode) {
        this.mode = gemMode;
    }
}
