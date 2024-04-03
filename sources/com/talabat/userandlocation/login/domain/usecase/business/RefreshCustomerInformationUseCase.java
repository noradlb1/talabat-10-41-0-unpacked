package com.talabat.userandlocation.login.domain.usecase.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase;", "", "refreshCustomerInformation", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Result", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RefreshCustomerInformationUseCase {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result;", "", "()V", "Failed", "Success", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result$Success;", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result$Failed;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result$Failed;", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Failed extends Result {
            @NotNull
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result$Success;", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Success extends Result {
            @NotNull
            public static final Success INSTANCE = new Success();

            private Success() {
                super((DefaultConstructorMarker) null);
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    Object refreshCustomerInformation(@NotNull Continuation<? super Result> continuation);
}
