package com.adyen.checkout.ui.internal.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.adyen.checkout.ui.R;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;

public class NumpadView extends LinearLayout {
    private KeyListener mKeyListener;

    public final class CharNotifier implements View.OnClickListener {
        private final char mChar;

        public void onClick(View view) {
            NumpadView.this.notifyCharClicked(this.mChar);
        }

        private CharNotifier(char c11) {
            this.mChar = c11;
        }
    }

    public interface KeyListener {
        void onBackspace();

        void onCharClicked(char c11);
    }

    public NumpadView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void notifyBackspaceClicked() {
        KeyListener keyListener = this.mKeyListener;
        if (keyListener != null) {
            keyListener.onBackspace();
        }
    }

    /* access modifiers changed from: private */
    public void notifyCharClicked(char c11) {
        KeyListener keyListener = this.mKeyListener;
        if (keyListener != null) {
            keyListener.onCharClicked(c11);
        }
    }

    public void setKeyListener(@Nullable KeyListener keyListener) {
        this.mKeyListener = keyListener;
    }

    public NumpadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumpadView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        View.inflate(context, R.layout.view_numpad, this);
        setBackgroundColor(ContextCompat.getColor(context, R.color.numpad_background));
        setOrientation(1);
        findViewById(R.id.button1).setOnClickListener(new CharNotifier(ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK));
        findViewById(R.id.button2).setOnClickListener(new CharNotifier('2'));
        findViewById(R.id.button3).setOnClickListener(new CharNotifier('3'));
        findViewById(R.id.button4).setOnClickListener(new CharNotifier('4'));
        findViewById(R.id.button5).setOnClickListener(new CharNotifier('5'));
        findViewById(R.id.button6).setOnClickListener(new CharNotifier('6'));
        findViewById(R.id.button7).setOnClickListener(new CharNotifier('7'));
        findViewById(R.id.button8).setOnClickListener(new CharNotifier('8'));
        findViewById(R.id.button9).setOnClickListener(new CharNotifier('9'));
        findViewById(R.id.button0).setOnClickListener(new CharNotifier('0'));
        findViewById(R.id.button_backspace).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NumpadView.this.notifyBackspaceClicked();
            }
        });
    }
}
