package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

public interface ObjectEncoderContext {
    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d11) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f11) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i11) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j11) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z11) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, double d11) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, int i11) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, long j11) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, boolean z11) throws IOException;

    @NonNull
    ObjectEncoderContext inline(@Nullable Object obj) throws IOException;

    @NonNull
    ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException;

    @NonNull
    ObjectEncoderContext nested(@NonNull String str) throws IOException;
}
