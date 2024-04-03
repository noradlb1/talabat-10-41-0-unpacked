package com.instabug.commons.models;

import java.util.UUID;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IncidentMetadata {
    @Nullable
    private final String uuid;

    public static final class Factory {
        @NotNull
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public static final IncidentMetadata create() {
            return create$default((String) null, 1, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public static final IncidentMetadata create(@Nullable String str) {
            return new IncidentMetadata(str, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ IncidentMetadata create$default(String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = UUID.randomUUID().toString();
            }
            return create(str);
        }
    }

    private IncidentMetadata(String str) {
        this.uuid = str;
    }

    public /* synthetic */ IncidentMetadata(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Nullable
    public final String getUuid() {
        return this.uuid;
    }
}
