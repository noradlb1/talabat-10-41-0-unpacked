package com.talabat.core.di;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/di/ApiContainer;", "", "getFeature", "T", "key", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "com_talabat_core_di_di"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ApiContainer {
    <T> T getFeature(@NotNull Class<T> cls);
}
