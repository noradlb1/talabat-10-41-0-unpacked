package com.instabug.chat.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class a {
    public static Intent a(Context context) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra("chat_process", Opcodes.IF_ICMPNE);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static Intent a(Context context, @Nullable String str) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra("chat_process", Opcodes.IF_ICMPLT);
        intent.putExtra("chat_number", str);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }

    public static Intent a(Context context, String str, com.instabug.chat.model.a aVar) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra("chat_process", Opcodes.IF_ICMPLE);
        intent.putExtra("chat_number", str);
        intent.putExtra("attachment", aVar);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }
}
