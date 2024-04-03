package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class KeyMappingKt$defaultKeyMapping$1 extends PropertyReference1Impl {
    public static final KeyMappingKt$defaultKeyMapping$1 INSTANCE = new KeyMappingKt$defaultKeyMapping$1();

    public KeyMappingKt$defaultKeyMapping$1() {
        super(KeyEvent_androidKt.class, "isCtrlPressed", "isCtrlPressed-ZmokQxo(Landroid/view/KeyEvent;)Z", 1);
    }

    @Nullable
    public Object get(@Nullable Object obj) {
        return Boolean.valueOf(KeyEvent_androidKt.m4187isCtrlPressedZmokQxo(((KeyEvent) obj).m4172unboximpl()));
    }
}
