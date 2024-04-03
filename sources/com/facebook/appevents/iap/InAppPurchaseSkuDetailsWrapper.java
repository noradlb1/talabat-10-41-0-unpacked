package com.facebook.appevents.iap;

import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B=\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ$\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0011R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "", "skuDetailsParamsClazz", "Ljava/lang/Class;", "builderClazz", "newBuilderMethod", "Ljava/lang/reflect/Method;", "setTypeMethod", "setSkusListMethod", "buildMethod", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getSkuDetailsParamsClazz", "()Ljava/lang/Class;", "getSkuDetailsParams", "skuType", "", "skuIDs", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class InAppPurchaseSkuDetailsWrapper {
    @NotNull
    private static final String CLASSNAME_SKU_DETAILS_PARAMS = "com.android.billingclient.api.SkuDetailsParams";
    @NotNull
    private static final String CLASSNAME_SKU_DETAILS_PARAMS_BUILDER = "com.android.billingclient.api.SkuDetailsParams$Builder";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String METHOD_BUILD = "build";
    @NotNull
    private static final String METHOD_NEW_BUILDER = "newBuilder";
    @NotNull
    private static final String METHOD_SET_SKU_LIST = "setSkusList";
    @NotNull
    private static final String METHOD_SET_TYPE = "setType";
    /* access modifiers changed from: private */
    @NotNull
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    @Nullable
    public static InAppPurchaseSkuDetailsWrapper instance;
    @NotNull
    private final Method buildMethod;
    @NotNull
    private final Class<?> builderClazz;
    @NotNull
    private final Method newBuilderMethod;
    @NotNull
    private final Method setSkusListMethod;
    @NotNull
    private final Method setTypeMethod;
    @NotNull
    private final Class<?> skuDetailsParamsClazz;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper$Companion;", "", "()V", "CLASSNAME_SKU_DETAILS_PARAMS", "", "CLASSNAME_SKU_DETAILS_PARAMS_BUILDER", "METHOD_BUILD", "METHOD_NEW_BUILDER", "METHOD_SET_SKU_LIST", "METHOD_SET_TYPE", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "createInstance", "", "getOrCreateInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void createInstance() {
            Class<?> cls = InAppPurchaseUtils.getClass(InAppPurchaseSkuDetailsWrapper.CLASSNAME_SKU_DETAILS_PARAMS);
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseSkuDetailsWrapper.CLASSNAME_SKU_DETAILS_PARAMS_BUILDER);
            if (cls != null && cls2 != null) {
                Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseSkuDetailsWrapper.METHOD_NEW_BUILDER, new Class[0]);
                Method method2 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseSkuDetailsWrapper.METHOD_SET_TYPE, String.class);
                Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseSkuDetailsWrapper.METHOD_SET_SKU_LIST, List.class);
                Method method4 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseSkuDetailsWrapper.METHOD_BUILD, new Class[0]);
                if (method != null && method2 != null && method3 != null && method4 != null) {
                    InAppPurchaseSkuDetailsWrapper.instance = new InAppPurchaseSkuDetailsWrapper(cls, cls2, method, method2, method3, method4);
                }
            }
        }

        @JvmStatic
        @Nullable
        public final InAppPurchaseSkuDetailsWrapper getOrCreateInstance() {
            if (InAppPurchaseSkuDetailsWrapper.initialized.get()) {
                return InAppPurchaseSkuDetailsWrapper.instance;
            }
            createInstance();
            InAppPurchaseSkuDetailsWrapper.initialized.set(true);
            return InAppPurchaseSkuDetailsWrapper.instance;
        }
    }

    public InAppPurchaseSkuDetailsWrapper(@NotNull Class<?> cls, @NotNull Class<?> cls2, @NotNull Method method, @NotNull Method method2, @NotNull Method method3, @NotNull Method method4) {
        Intrinsics.checkNotNullParameter(cls, "skuDetailsParamsClazz");
        Intrinsics.checkNotNullParameter(cls2, "builderClazz");
        Intrinsics.checkNotNullParameter(method, "newBuilderMethod");
        Intrinsics.checkNotNullParameter(method2, "setTypeMethod");
        Intrinsics.checkNotNullParameter(method3, "setSkusListMethod");
        Intrinsics.checkNotNullParameter(method4, "buildMethod");
        this.skuDetailsParamsClazz = cls;
        this.builderClazz = cls2;
        this.newBuilderMethod = method;
        this.setTypeMethod = method2;
        this.setSkusListMethod = method3;
        this.buildMethod = method4;
    }

    @JvmStatic
    @Nullable
    public static final InAppPurchaseSkuDetailsWrapper getOrCreateInstance() {
        return Companion.getOrCreateInstance();
    }

    @Nullable
    public final Object getSkuDetailsParams(@Nullable String str, @Nullable List<String> list) {
        Object invokeMethod;
        Object invokeMethod2;
        InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
        Object invokeMethod3 = InAppPurchaseUtils.invokeMethod(this.skuDetailsParamsClazz, this.newBuilderMethod, (Object) null, new Object[0]);
        if (invokeMethod3 == null || (invokeMethod = InAppPurchaseUtils.invokeMethod(this.builderClazz, this.setTypeMethod, invokeMethod3, str)) == null || (invokeMethod2 = InAppPurchaseUtils.invokeMethod(this.builderClazz, this.setSkusListMethod, invokeMethod, list)) == null) {
            return null;
        }
        return InAppPurchaseUtils.invokeMethod(this.builderClazz, this.buildMethod, invokeMethod2, new Object[0]);
    }

    @NotNull
    public final Class<?> getSkuDetailsParamsClazz() {
        return this.skuDetailsParamsClazz;
    }
}
