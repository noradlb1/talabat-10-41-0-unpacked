package com.talabat.userandlocation.customerinfo;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011Jf\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t26\u0010\n\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\u000bH&¨\u0006\u0012"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/CustomerInfoUpdateDelegate;", "", "updateCustomerInfo", "", "firstName", "", "lastName", "dateOfBirth", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "status", "message", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CustomerInfoUpdateDelegate {
    @NotNull
    public static final Companion Companion = Companion.f12327a;
    public static final int STATUS_ERROR_KURDISH_CHARACTERS_IN_NAME = -19;
    public static final int STATUS_ERROR_UNKNOWN = -99999;
    public static final int STATUS_SUCCESS = 1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/CustomerInfoUpdateDelegate$Companion;", "", "()V", "STATUS_ERROR_KURDISH_CHARACTERS_IN_NAME", "", "STATUS_ERROR_UNKNOWN", "STATUS_SUCCESS", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public static final int STATUS_ERROR_KURDISH_CHARACTERS_IN_NAME = -19;
        public static final int STATUS_ERROR_UNKNOWN = -99999;
        public static final int STATUS_SUCCESS = 1;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f12327a = new Companion();

        private Companion() {
        }
    }

    void updateCustomerInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull Function2<? super Integer, ? super String, Unit> function2);
}
