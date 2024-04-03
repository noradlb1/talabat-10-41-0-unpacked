package com.instabug.library.ui.custom;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.AccessibilityUtils;
import nd.b;

public class InstabugAlertDialog {

    public static class Builder {
        @NonNull
        private final Activity activity;
        private boolean isCancellable = true;
        @Nullable
        private String message;
        @Nullable
        private String negativeButtonAccessibilityContentDescription;
        @Nullable
        private String negativeButtonText;
        @Nullable
        private DialogInterface.OnClickListener onNegativeClickListener;
        @Nullable
        private DialogInterface.OnClickListener onPositiveClickListener;
        @Nullable
        private String positiveButtonAccessibilityContentDescription;
        @Nullable
        private String positiveButtonText;
        @Nullable
        private String title;

        public Builder(@NonNull Activity activity2) {
            this.activity = activity2;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$show$2(AlertDialog alertDialog, DialogInterface dialogInterface) {
            alertDialog.getButton(-1).setTextColor(InstabugCore.getPrimaryColor());
            alertDialog.getButton(-2).setTextColor(InstabugCore.getPrimaryColor());
            if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
                alertDialog.getButton(-1).setContentDescription(this.positiveButtonAccessibilityContentDescription);
                alertDialog.getButton(-2).setContentDescription(this.negativeButtonAccessibilityContentDescription);
                TextView textView = (TextView) alertDialog.findViewById(R.id.alertTitle);
                if (textView != null && Build.VERSION.SDK_INT >= 28) {
                    textView.setImportantForAccessibility(1);
                    textView.setScreenReaderFocusable(true);
                }
            }
        }

        public Builder setCancellable(boolean z11) {
            this.isCancellable = z11;
            return this;
        }

        public Builder setMessage(@Nullable String str) {
            this.message = str;
            return this;
        }

        public Builder setNegativeButton(@Nullable String str, @Nullable DialogInterface.OnClickListener onClickListener) {
            this.negativeButtonText = str;
            this.onNegativeClickListener = onClickListener;
            return this;
        }

        public Builder setNegativeButtonAccessibilityContentDescription(@Nullable String str) {
            this.negativeButtonAccessibilityContentDescription = str;
            return this;
        }

        public Builder setPositiveButton(@Nullable String str, @Nullable DialogInterface.OnClickListener onClickListener) {
            this.positiveButtonText = str;
            this.onPositiveClickListener = onClickListener;
            return this;
        }

        public Builder setPositiveButtonAccessibilityContentDescription(@Nullable String str) {
            this.positiveButtonAccessibilityContentDescription = str;
            return this;
        }

        public Builder setTitle(@Nullable String str) {
            this.title = str;
            return this;
        }

        public AlertDialog show() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.activity, R.style.InstabugDialogStyle);
            builder.setTitle((CharSequence) this.title).setMessage((CharSequence) this.message).setCancelable(this.isCancellable);
            if (this.positiveButtonText != null) {
                DialogInterface.OnClickListener onClickListener = this.onPositiveClickListener;
                if (onClickListener == null) {
                    new b
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: CONSTRUCTOR  (r1v16 ? I:nd.b) =  call: nd.b.<init>():void type: CONSTRUCTOR in method: com.instabug.library.ui.custom.InstabugAlertDialog.Builder.show():androidx.appcompat.app.AlertDialog, dex: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v16 ?
                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	... 54 more
                        */
                    /*
                        this = this;
                        androidx.appcompat.app.AlertDialog$Builder r0 = new androidx.appcompat.app.AlertDialog$Builder
                        android.app.Activity r1 = r3.activity
                        int r2 = com.instabug.library.R.style.InstabugDialogStyle
                        r0.<init>(r1, r2)
                        java.lang.String r1 = r3.title
                        androidx.appcompat.app.AlertDialog$Builder r1 = r0.setTitle((java.lang.CharSequence) r1)
                        java.lang.String r2 = r3.message
                        androidx.appcompat.app.AlertDialog$Builder r1 = r1.setMessage((java.lang.CharSequence) r2)
                        boolean r2 = r3.isCancellable
                        r1.setCancelable(r2)
                        java.lang.String r1 = r3.positiveButtonText
                        if (r1 == 0) goto L_0x002c
                        android.content.DialogInterface$OnClickListener r1 = r3.onPositiveClickListener
                        if (r1 != 0) goto L_0x0027
                        nd.b r1 = new nd.b
                        r1.<init>()
                    L_0x0027:
                        java.lang.String r2 = r3.positiveButtonText
                        r0.setPositiveButton((java.lang.CharSequence) r2, (android.content.DialogInterface.OnClickListener) r1)
                    L_0x002c:
                        java.lang.String r1 = r3.negativeButtonText
                        if (r1 == 0) goto L_0x003e
                        android.content.DialogInterface$OnClickListener r1 = r3.onNegativeClickListener
                        if (r1 != 0) goto L_0x0039
                        nd.c r1 = new nd.c
                        r1.<init>()
                    L_0x0039:
                        java.lang.String r2 = r3.negativeButtonText
                        r0.setNegativeButton((java.lang.CharSequence) r2, (android.content.DialogInterface.OnClickListener) r1)
                    L_0x003e:
                        androidx.appcompat.app.AlertDialog r0 = r0.create()
                        nd.d r1 = new nd.d
                        r1.<init>(r3, r0)
                        r0.setOnShowListener(r1)
                        android.app.Activity r1 = r3.activity
                        boolean r1 = r1.isFinishing()
                        if (r1 != 0) goto L_0x005d
                        android.app.Activity r1 = r3.activity
                        boolean r1 = r1.isDestroyed()
                        if (r1 != 0) goto L_0x005d
                        r0.show()
                    L_0x005d:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.ui.custom.InstabugAlertDialog.Builder.show():androidx.appcompat.app.AlertDialog");
                }
            }
        }
