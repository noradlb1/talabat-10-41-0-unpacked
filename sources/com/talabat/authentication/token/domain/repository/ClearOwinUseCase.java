package com.talabat.authentication.token.domain.repository;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0013\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H¦\u0002¨\u0006\u0006"}, d2 = {"Lcom/talabat/authentication/token/domain/repository/ClearOwinUseCase;", "", "invoke", "", "forceClean", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ClearOwinUseCase {
    @NotNull
    public static final String CLEAR_OWIN_EVENT_NAME = "clear_owin";
    @NotNull
    public static final Companion Companion = Companion.f55521a;
    @NotNull
    public static final String IS_JWT_EXISTS = "isJwtExist";
    @NotNull
    public static final String OWIN_STILL_AVAILABLE_EVENT_NAME = "owin_available";
    @NotNull
    public static final String STATE_TYPE = "stateType";
    @NotNull
    public static final String STOP_USING_OWIN = "stopUsingOwin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/token/domain/repository/ClearOwinUseCase$Companion;", "", "()V", "CLEAR_OWIN_EVENT_NAME", "", "IS_JWT_EXISTS", "OWIN_STILL_AVAILABLE_EVENT_NAME", "STATE_TYPE", "STOP_USING_OWIN", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        public static final String CLEAR_OWIN_EVENT_NAME = "clear_owin";
        @NotNull
        public static final String IS_JWT_EXISTS = "isJwtExist";
        @NotNull
        public static final String OWIN_STILL_AVAILABLE_EVENT_NAME = "owin_available";
        @NotNull
        public static final String STATE_TYPE = "stateType";
        @NotNull
        public static final String STOP_USING_OWIN = "stopUsingOwin";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f55521a = new Companion();

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean invoke$default(ClearOwinUseCase clearOwinUseCase, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    z11 = false;
                }
                return clearOwinUseCase.invoke(z11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
    }

    boolean invoke(boolean z11);
}
