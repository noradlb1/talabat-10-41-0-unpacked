package net.bytebuddy.asm;

import com.google.firebase.analytics.FirebaseAnalytics;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.RepeatedAnnotationPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.implementation.bytecode.Addition;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.Throw;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.implementation.bytecode.constant.LongConstant;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.constant.SerializedConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
import net.bytebuddy.utility.visitor.FramePaddingMethodVisitor;
import net.bytebuddy.utility.visitor.LineNumberPrependingMethodVisitor;
import net.bytebuddy.utility.visitor.StackAwareMethodVisitor;

@HashCodeAndEqualsPlugin.Enhance
public class Advice implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper, Implementation {
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape BACKUP_ARGUMENTS;
    private static final MethodDescription.InDefinedShape INLINE_ENTER;
    private static final MethodDescription.InDefinedShape INLINE_EXIT;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape ON_THROWABLE;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape PREPEND_LINE_NUMBER;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape REPEAT_ON;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape SKIP_ON;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape SUPPRESS_ENTER;
    /* access modifiers changed from: private */
    public static final MethodDescription.InDefinedShape SUPPRESS_EXIT;
    private static final ClassReader UNDEFINED = null;
    private final Assigner assigner;
    private final Implementation delegate;
    private final ExceptionHandler exceptionHandler;
    private final Dispatcher.Resolved.ForMethodEnter methodEnter;
    private final Dispatcher.Resolved.ForMethodExit methodExit;

    public static abstract class AdviceVisitor extends ExceptionTableSensitiveMethodVisitor implements Dispatcher.RelocationHandler.Relocation {
        private static final int THIS_VARIABLE_INDEX = 0;
        private static final String THIS_VARIABLE_NAME = "this";

        /* renamed from: d  reason: collision with root package name */
        public final MethodDescription f26977d;

        /* renamed from: e  reason: collision with root package name */
        public final Dispatcher.Bound f26978e;

        /* renamed from: f  reason: collision with root package name */
        public final ArgumentHandler.ForInstrumentedMethod f26979f;

        /* renamed from: g  reason: collision with root package name */
        public final MethodSizeHandler.ForInstrumentedMethod f26980g;

        /* renamed from: h  reason: collision with root package name */
        public final StackMapFrameHandler.ForInstrumentedMethod f26981h;
        private final Dispatcher.Bound methodEnter;
        private final Label preparationStart;

        public static abstract class WithExitAdvice extends AdviceVisitor {

            /* renamed from: i  reason: collision with root package name */
            public final Label f26982i = new Label();

            public static class WithExceptionHandling extends WithExitAdvice {
                private final Label exceptionHandler;

                /* renamed from: j  reason: collision with root package name */
                public final Label f26983j;
                private final TypeDescription throwable;

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public WithExceptionHandling(net.bytebuddy.jar.asm.MethodVisitor r14, net.bytebuddy.implementation.Implementation.Context r15, net.bytebuddy.implementation.bytecode.assign.Assigner r16, net.bytebuddy.implementation.bytecode.StackManipulation r17, net.bytebuddy.description.type.TypeDescription r18, net.bytebuddy.description.method.MethodDescription r19, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter r20, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit r21, int r22, int r23, net.bytebuddy.description.type.TypeDescription r24) {
                    /*
                        r13 = this;
                        r12 = r13
                        net.bytebuddy.description.type.TypeDescription$Generic r0 = r19.getReturnType()
                        java.lang.Class r1 = java.lang.Void.TYPE
                        boolean r0 = r0.represents(r1)
                        if (r0 == 0) goto L_0x0014
                        net.bytebuddy.description.type.TypeDescription r0 = net.bytebuddy.description.type.TypeDescription.THROWABLE
                        java.util.List r0 = java.util.Collections.singletonList(r0)
                        goto L_0x002b
                    L_0x0014:
                        r0 = 2
                        net.bytebuddy.description.type.TypeDescription[] r0 = new net.bytebuddy.description.type.TypeDescription[r0]
                        net.bytebuddy.description.type.TypeDescription$Generic r1 = r19.getReturnType()
                        net.bytebuddy.description.type.TypeDescription r1 = r1.asErasure()
                        r2 = 0
                        r0[r2] = r1
                        r1 = 1
                        net.bytebuddy.description.type.TypeDescription r2 = net.bytebuddy.description.type.TypeDescription.THROWABLE
                        r0[r1] = r2
                        java.util.List r0 = java.util.Arrays.asList(r0)
                    L_0x002b:
                        r9 = r0
                        r0 = r13
                        r1 = r14
                        r2 = r15
                        r3 = r16
                        r4 = r17
                        r5 = r18
                        r6 = r19
                        r7 = r20
                        r8 = r21
                        r10 = r22
                        r11 = r23
                        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                        r0 = r24
                        r12.throwable = r0
                        net.bytebuddy.jar.asm.Label r0 = new net.bytebuddy.jar.asm.Label
                        r0.<init>()
                        r12.exceptionHandler = r0
                        net.bytebuddy.jar.asm.Label r0 = new net.bytebuddy.jar.asm.Label
                        r0.<init>()
                        r12.f26983j = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice.WithExceptionHandling.<init>(net.bytebuddy.jar.asm.MethodVisitor, net.bytebuddy.implementation.Implementation$Context, net.bytebuddy.implementation.bytecode.assign.Assigner, net.bytebuddy.implementation.bytecode.StackManipulation, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.method.MethodDescription, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodEnter, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodExit, int, int, net.bytebuddy.description.type.TypeDescription):void");
                }

                public void r() {
                    this.f27400c.visitTryCatchBlock(this.f26983j, this.f26982i, this.exceptionHandler, this.throwable.getInternalName());
                }

                public void s() {
                    this.f27400c.visitLabel(this.f26983j);
                }

                public void t() {
                    this.f27400c.visitVarInsn(25, this.f26979f.thrown());
                    Label label = new Label();
                    this.f27400c.visitJumpInsn(Opcodes.IFNULL, label);
                    this.f27400c.visitVarInsn(25, this.f26979f.thrown());
                    this.f27400c.visitInsn(Opcodes.ATHROW);
                    this.f27400c.visitLabel(label);
                    this.f26981h.injectPostCompletionFrame(this.f27400c);
                }

                public void u() {
                    this.f26981h.injectReturnFrame(this.f27400c);
                    TypeDescription.Generic returnType = this.f26977d.getReturnType();
                    Class cls = Boolean.TYPE;
                    if (returnType.represents(cls) || this.f26977d.getReturnType().represents(Byte.TYPE) || this.f26977d.getReturnType().represents(Short.TYPE) || this.f26977d.getReturnType().represents(Character.TYPE) || this.f26977d.getReturnType().represents(Integer.TYPE)) {
                        this.f27400c.visitVarInsn(54, this.f26979f.returned());
                    } else if (this.f26977d.getReturnType().represents(Long.TYPE)) {
                        this.f27400c.visitVarInsn(55, this.f26979f.returned());
                    } else if (this.f26977d.getReturnType().represents(Float.TYPE)) {
                        this.f27400c.visitVarInsn(56, this.f26979f.returned());
                    } else if (this.f26977d.getReturnType().represents(Double.TYPE)) {
                        this.f27400c.visitVarInsn(57, this.f26979f.returned());
                    } else if (!this.f26977d.getReturnType().represents(Void.TYPE)) {
                        this.f27400c.visitVarInsn(58, this.f26979f.returned());
                    }
                    this.f27400c.visitInsn(1);
                    this.f27400c.visitVarInsn(58, this.f26979f.thrown());
                    Label label = new Label();
                    this.f27400c.visitJumpInsn(Opcodes.GOTO, label);
                    this.f27400c.visitLabel(this.exceptionHandler);
                    this.f26981h.injectExceptionFrame(this.f27400c);
                    this.f27400c.visitVarInsn(58, this.f26979f.thrown());
                    if (this.f26977d.getReturnType().represents(cls) || this.f26977d.getReturnType().represents(Byte.TYPE) || this.f26977d.getReturnType().represents(Short.TYPE) || this.f26977d.getReturnType().represents(Character.TYPE) || this.f26977d.getReturnType().represents(Integer.TYPE)) {
                        this.f27400c.visitInsn(3);
                        this.f27400c.visitVarInsn(54, this.f26979f.returned());
                    } else if (this.f26977d.getReturnType().represents(Long.TYPE)) {
                        this.f27400c.visitInsn(9);
                        this.f27400c.visitVarInsn(55, this.f26979f.returned());
                    } else if (this.f26977d.getReturnType().represents(Float.TYPE)) {
                        this.f27400c.visitInsn(11);
                        this.f27400c.visitVarInsn(56, this.f26979f.returned());
                    } else if (this.f26977d.getReturnType().represents(Double.TYPE)) {
                        this.f27400c.visitInsn(14);
                        this.f27400c.visitVarInsn(57, this.f26979f.returned());
                    } else if (!this.f26977d.getReturnType().represents(Void.TYPE)) {
                        this.f27400c.visitInsn(1);
                        this.f27400c.visitVarInsn(58, this.f26979f.returned());
                    }
                    this.f27400c.visitLabel(label);
                    this.f26980g.requireStackSize(StackSize.SINGLE.getSize());
                }
            }

            public static class WithoutExceptionHandling extends WithExitAdvice {
                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public WithoutExceptionHandling(net.bytebuddy.jar.asm.MethodVisitor r14, net.bytebuddy.implementation.Implementation.Context r15, net.bytebuddy.implementation.bytecode.assign.Assigner r16, net.bytebuddy.implementation.bytecode.StackManipulation r17, net.bytebuddy.description.type.TypeDescription r18, net.bytebuddy.description.method.MethodDescription r19, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter r20, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit r21, int r22, int r23) {
                    /*
                        r13 = this;
                        net.bytebuddy.description.type.TypeDescription$Generic r0 = r19.getReturnType()
                        java.lang.Class r1 = java.lang.Void.TYPE
                        boolean r0 = r0.represents(r1)
                        if (r0 == 0) goto L_0x0011
                        java.util.List r0 = java.util.Collections.emptyList()
                        goto L_0x001d
                    L_0x0011:
                        net.bytebuddy.description.type.TypeDescription$Generic r0 = r19.getReturnType()
                        net.bytebuddy.description.type.TypeDescription r0 = r0.asErasure()
                        java.util.List r0 = java.util.Collections.singletonList(r0)
                    L_0x001d:
                        r10 = r0
                        r1 = r13
                        r2 = r14
                        r3 = r15
                        r4 = r16
                        r5 = r17
                        r6 = r18
                        r7 = r19
                        r8 = r20
                        r9 = r21
                        r11 = r22
                        r12 = r23
                        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice.WithoutExceptionHandling.<init>(net.bytebuddy.jar.asm.MethodVisitor, net.bytebuddy.implementation.Implementation$Context, net.bytebuddy.implementation.bytecode.assign.Assigner, net.bytebuddy.implementation.bytecode.StackManipulation, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.method.MethodDescription, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodEnter, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodExit, int, int):void");
                }

                public void r() {
                }

                public void s() {
                }

                public void t() {
                }

                public void u() {
                    if (this.f26977d.getReturnType().represents(Boolean.TYPE) || this.f26977d.getReturnType().represents(Byte.TYPE) || this.f26977d.getReturnType().represents(Short.TYPE) || this.f26977d.getReturnType().represents(Character.TYPE) || this.f26977d.getReturnType().represents(Integer.TYPE)) {
                        this.f26981h.injectReturnFrame(this.f27400c);
                        this.f27400c.visitVarInsn(54, this.f26979f.returned());
                    } else if (this.f26977d.getReturnType().represents(Long.TYPE)) {
                        this.f26981h.injectReturnFrame(this.f27400c);
                        this.f27400c.visitVarInsn(55, this.f26979f.returned());
                    } else if (this.f26977d.getReturnType().represents(Float.TYPE)) {
                        this.f26981h.injectReturnFrame(this.f27400c);
                        this.f27400c.visitVarInsn(56, this.f26979f.returned());
                    } else if (this.f26977d.getReturnType().represents(Double.TYPE)) {
                        this.f26981h.injectReturnFrame(this.f27400c);
                        this.f27400c.visitVarInsn(57, this.f26979f.returned());
                    } else if (!this.f26977d.getReturnType().represents(Void.TYPE)) {
                        this.f26981h.injectReturnFrame(this.f27400c);
                        this.f27400c.visitVarInsn(58, this.f26979f.returned());
                    }
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public WithExitAdvice(net.bytebuddy.jar.asm.MethodVisitor r13, net.bytebuddy.implementation.Implementation.Context r14, net.bytebuddy.implementation.bytecode.assign.Assigner r15, net.bytebuddy.implementation.bytecode.StackManipulation r16, net.bytebuddy.description.type.TypeDescription r17, net.bytebuddy.description.method.MethodDescription r18, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter r19, net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit r20, java.util.List<? extends net.bytebuddy.description.type.TypeDescription> r21, int r22, int r23) {
                /*
                    r12 = this;
                    net.bytebuddy.utility.visitor.StackAwareMethodVisitor r1 = new net.bytebuddy.utility.visitor.StackAwareMethodVisitor
                    r0 = r13
                    r6 = r18
                    r1.<init>(r13, r6)
                    r0 = r12
                    r2 = r14
                    r3 = r15
                    r4 = r16
                    r5 = r17
                    r7 = r19
                    r8 = r20
                    r9 = r21
                    r10 = r22
                    r11 = r23
                    r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                    net.bytebuddy.jar.asm.Label r0 = new net.bytebuddy.jar.asm.Label
                    r0.<init>()
                    r1 = r12
                    r1.f26982i = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice.<init>(net.bytebuddy.jar.asm.MethodVisitor, net.bytebuddy.implementation.Implementation$Context, net.bytebuddy.implementation.bytecode.assign.Assigner, net.bytebuddy.implementation.bytecode.StackManipulation, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.method.MethodDescription, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodEnter, net.bytebuddy.asm.Advice$Dispatcher$Resolved$ForMethodExit, java.util.List, int, int):void");
            }

            public void apply(MethodVisitor methodVisitor) {
                if (this.f26977d.getReturnType().represents(Boolean.TYPE) || this.f26977d.getReturnType().represents(Byte.TYPE) || this.f26977d.getReturnType().represents(Short.TYPE) || this.f26977d.getReturnType().represents(Character.TYPE) || this.f26977d.getReturnType().represents(Integer.TYPE)) {
                    methodVisitor.visitInsn(3);
                } else if (this.f26977d.getReturnType().represents(Long.TYPE)) {
                    methodVisitor.visitInsn(9);
                } else if (this.f26977d.getReturnType().represents(Float.TYPE)) {
                    methodVisitor.visitInsn(11);
                } else if (this.f26977d.getReturnType().represents(Double.TYPE)) {
                    methodVisitor.visitInsn(14);
                } else if (!this.f26977d.getReturnType().represents(Void.TYPE)) {
                    methodVisitor.visitInsn(1);
                }
                methodVisitor.visitJumpInsn(Opcodes.GOTO, this.f26982i);
            }

            public void d(int i11) {
                switch (i11) {
                    case 172:
                        this.f26980g.requireLocalVariableLength(((StackAwareMethodVisitor) this.f27400c).drainStack(54, 21, StackSize.SINGLE));
                        break;
                    case Opcodes.LRETURN:
                        this.f26980g.requireLocalVariableLength(((StackAwareMethodVisitor) this.f27400c).drainStack(55, 22, StackSize.DOUBLE));
                        break;
                    case Opcodes.FRETURN:
                        this.f26980g.requireLocalVariableLength(((StackAwareMethodVisitor) this.f27400c).drainStack(56, 23, StackSize.SINGLE));
                        break;
                    case Opcodes.DRETURN:
                        this.f26980g.requireLocalVariableLength(((StackAwareMethodVisitor) this.f27400c).drainStack(57, 24, StackSize.DOUBLE));
                        break;
                    case Opcodes.ARETURN:
                        this.f26980g.requireLocalVariableLength(((StackAwareMethodVisitor) this.f27400c).drainStack(58, 25, StackSize.SINGLE));
                        break;
                    case Opcodes.RETURN:
                        ((StackAwareMethodVisitor) this.f27400c).drainStack();
                        break;
                    default:
                        this.f27400c.visitInsn(i11);
                        return;
                }
                this.f27400c.visitJumpInsn(Opcodes.GOTO, this.f26982i);
            }

            public void q() {
                this.f27400c.visitLabel(this.f26982i);
                u();
                this.f26981h.injectCompletionFrame(this.f27400c);
                this.f26978e.apply();
                t();
                if (this.f26977d.getReturnType().represents(Boolean.TYPE) || this.f26977d.getReturnType().represents(Byte.TYPE) || this.f26977d.getReturnType().represents(Short.TYPE) || this.f26977d.getReturnType().represents(Character.TYPE) || this.f26977d.getReturnType().represents(Integer.TYPE)) {
                    this.f27400c.visitVarInsn(21, this.f26979f.returned());
                    this.f27400c.visitInsn(172);
                } else if (this.f26977d.getReturnType().represents(Long.TYPE)) {
                    this.f27400c.visitVarInsn(22, this.f26979f.returned());
                    this.f27400c.visitInsn(Opcodes.LRETURN);
                } else if (this.f26977d.getReturnType().represents(Float.TYPE)) {
                    this.f27400c.visitVarInsn(23, this.f26979f.returned());
                    this.f27400c.visitInsn(Opcodes.FRETURN);
                } else if (this.f26977d.getReturnType().represents(Double.TYPE)) {
                    this.f27400c.visitVarInsn(24, this.f26979f.returned());
                    this.f27400c.visitInsn(Opcodes.DRETURN);
                } else if (!this.f26977d.getReturnType().represents(Void.TYPE)) {
                    this.f27400c.visitVarInsn(25, this.f26979f.returned());
                    this.f27400c.visitInsn(Opcodes.ARETURN);
                } else {
                    this.f27400c.visitInsn(Opcodes.RETURN);
                }
                this.f26980g.requireStackSize(this.f26977d.getReturnType().getStackSize().getSize());
            }

            public abstract void t();

            public abstract void u();
        }

        public static class WithoutExitAdvice extends AdviceVisitor {
            public WithoutExitAdvice(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription, MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter, int i11, int i12) {
                super(methodVisitor, context, assigner, stackManipulation, typeDescription, methodDescription, forMethodEnter, Dispatcher.Inactive.INSTANCE, Collections.emptyList(), i11, i12);
            }

            public void apply(MethodVisitor methodVisitor) {
                if (this.f26977d.getReturnType().represents(Boolean.TYPE) || this.f26977d.getReturnType().represents(Byte.TYPE) || this.f26977d.getReturnType().represents(Short.TYPE) || this.f26977d.getReturnType().represents(Character.TYPE) || this.f26977d.getReturnType().represents(Integer.TYPE)) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitInsn(172);
                } else if (this.f26977d.getReturnType().represents(Long.TYPE)) {
                    methodVisitor.visitInsn(9);
                    methodVisitor.visitInsn(Opcodes.LRETURN);
                } else if (this.f26977d.getReturnType().represents(Float.TYPE)) {
                    methodVisitor.visitInsn(11);
                    methodVisitor.visitInsn(Opcodes.FRETURN);
                } else if (this.f26977d.getReturnType().represents(Double.TYPE)) {
                    methodVisitor.visitInsn(14);
                    methodVisitor.visitInsn(Opcodes.DRETURN);
                } else if (this.f26977d.getReturnType().represents(Void.TYPE)) {
                    methodVisitor.visitInsn(Opcodes.RETURN);
                } else {
                    methodVisitor.visitInsn(1);
                    methodVisitor.visitInsn(Opcodes.ARETURN);
                }
            }

            public void q() {
            }

            public void r() {
            }

            public void s() {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdviceVisitor(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription, MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit, List<? extends TypeDescription> list, int i11, int i12) {
            super(OpenedClassReader.ASM_API, methodVisitor);
            List list2;
            List list3;
            MethodDescription methodDescription2 = methodDescription;
            this.f26977d = methodDescription2;
            Label label = new Label();
            this.preparationStart = label;
            TreeMap treeMap = new TreeMap();
            treeMap.putAll(forMethodEnter.getNamedTypes());
            treeMap.putAll(forMethodExit.getNamedTypes());
            ArgumentHandler.ForInstrumentedMethod a11 = forMethodExit.getArgumentHandlerFactory().a(methodDescription2, forMethodEnter.getAdviceType(), forMethodExit.getAdviceType(), treeMap);
            this.f26979f = a11;
            if (forMethodExit.getAdviceType().represents(Void.TYPE)) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.singletonList(forMethodExit.getAdviceType().asErasure());
            }
            List<S> of2 = CompoundList.of(list2, (List) a11.getNamedTypes());
            if (forMethodEnter.getAdviceType().represents(Void.TYPE)) {
                list3 = Collections.emptyList();
            } else {
                list3 = Collections.singletonList(forMethodEnter.getAdviceType().asErasure());
            }
            List list4 = list3;
            MethodSizeHandler.ForInstrumentedMethod a12 = MethodSizeHandler.Default.a(methodDescription, of2, list4, list, a11.isCopyingArguments(), i11);
            this.f26980g = a12;
            StackMapFrameHandler.ForInstrumentedMethod b11 = StackMapFrameHandler.Default.b(typeDescription, methodDescription, of2, list4, list, forMethodExit.isAlive(), a11.isCopyingArguments(), context.getClassFileVersion(), i11, i12);
            this.f26981h = b11;
            TypeDescription typeDescription2 = typeDescription;
            MethodDescription methodDescription3 = methodDescription;
            MethodVisitor methodVisitor2 = methodVisitor;
            Implementation.Context context2 = context;
            Assigner assigner2 = assigner;
            ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod = a11;
            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod2 = b11;
            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3 = b11;
            StackManipulation stackManipulation2 = stackManipulation;
            this.methodEnter = forMethodEnter.bind(typeDescription2, methodDescription3, methodVisitor2, context2, assigner2, forInstrumentedMethod, a12, forInstrumentedMethod2, stackManipulation2, this);
            this.f26978e = forMethodExit.bind(typeDescription2, methodDescription3, methodVisitor2, context2, assigner2, forInstrumentedMethod, a12, forInstrumentedMethod3, stackManipulation2, new Dispatcher.RelocationHandler.Relocation.ForLabel(label));
        }

        public void a() {
            this.methodEnter.prepare();
            r();
            this.f26978e.prepare();
            this.methodEnter.initialize();
            this.f26978e.initialize();
            this.f26981h.injectInitializationFrame(this.f27400c);
            this.methodEnter.apply();
            this.f27400c.visitLabel(this.preparationStart);
            this.f26980g.requireStackSize(this.f26979f.prepare(this.f27400c));
            this.f26981h.injectStartFrame(this.f27400c);
            s();
        }

        public void c(int i11, int i12) {
            this.f27400c.visitIincInsn(this.f26979f.argument(i11), i12);
        }

        public void onVisitFrame(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
            this.f26981h.translateFrame(this.f27400c, i11, i12, objArr, i13, objArr2);
        }

        public void p(int i11, int i12) {
            this.f27400c.visitVarInsn(i11, this.f26979f.argument(i12));
        }

        public abstract void q();

        public abstract void r();

        public abstract void s();

        public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i11) {
            MethodVisitor methodVisitor = this.f27400c;
            if (i11 != 0 || !"this".equals(str)) {
                i11 = this.f26979f.variable(i11);
            }
            methodVisitor.visitLocalVariable(str, str2, str3, label, label2, i11);
        }

        public AnnotationVisitor visitLocalVariableAnnotation(int i11, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z11) {
            int[] iArr2 = iArr;
            int[] iArr3 = new int[iArr2.length];
            for (int i12 = 0; i12 < iArr2.length; i12++) {
                iArr3[i12] = this.f26979f.variable(iArr2[i12]);
            }
            return this.f27400c.visitLocalVariableAnnotation(i11, typePath, labelArr, labelArr2, iArr3, str, z11);
        }

        public void visitMaxs(int i11, int i12) {
            q();
            this.f27400c.visitMaxs(this.f26980g.compoundStackSize(i11), this.f26980g.compoundLocalVariableLength(i12));
        }
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AllArguments {
        boolean nullIfEmpty() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Appender implements ByteCodeAppender {
        private final Advice advice;
        private final ByteCodeAppender delegate;
        private final Implementation.Target implementationTarget;

        public static class EmulatingMethodVisitor extends MethodVisitor {
            private final ByteCodeAppender delegate;
            private int localVariableLength;
            private int stackSize;

            public EmulatingMethodVisitor(MethodVisitor methodVisitor, ByteCodeAppender byteCodeAppender) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.delegate = byteCodeAppender;
            }

            public ByteCodeAppender.Size a(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                methodVisitor.visitCode();
                ByteCodeAppender.Size apply = this.delegate.apply(methodVisitor, context, methodDescription);
                methodVisitor.visitMaxs(apply.getOperandStackSize(), apply.getLocalVariableSize());
                methodVisitor.visitEnd();
                return new ByteCodeAppender.Size(this.stackSize, this.localVariableLength);
            }

            public void visitCode() {
            }

            public void visitEnd() {
            }

            public void visitMaxs(int i11, int i12) {
                this.stackSize = i11;
                this.localVariableLength = i12;
            }
        }

        public Appender(Advice advice2, Implementation.Target target, ByteCodeAppender byteCodeAppender) {
            this.advice = advice2;
            this.implementationTarget = target;
            this.delegate = byteCodeAppender;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            EmulatingMethodVisitor emulatingMethodVisitor = new EmulatingMethodVisitor(methodVisitor, this.delegate);
            return emulatingMethodVisitor.a(this.advice.h(this.implementationTarget.getInstrumentedType(), methodDescription, emulatingMethodVisitor, context, 0, 0), context, methodDescription);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.advice.equals(appender.advice) && this.implementationTarget.equals(appender.implementationTarget) && this.delegate.equals(appender.delegate);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.advice.hashCode()) * 31) + this.implementationTarget.hashCode()) * 31) + this.delegate.hashCode();
        }
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Argument {
        boolean optional() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        int value();
    }

    public interface ArgumentHandler {
        public static final int THIS_REFERENCE = 0;

        public enum Factory {
            SIMPLE {
                public ForInstrumentedMethod a(MethodDescription methodDescription, TypeDefinition typeDefinition, TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap) {
                    return new ForInstrumentedMethod.Default.Simple(methodDescription, typeDefinition2, sortedMap, typeDefinition);
                }
            },
            COPYING {
                public ForInstrumentedMethod a(MethodDescription methodDescription, TypeDefinition typeDefinition, TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap) {
                    return new ForInstrumentedMethod.Default.Copying(methodDescription, typeDefinition2, sortedMap, typeDefinition);
                }
            };

            public abstract ForInstrumentedMethod a(MethodDescription methodDescription, TypeDefinition typeDefinition, TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap);
        }

        public interface ForAdvice extends ArgumentHandler {

            public static abstract class Default implements ForAdvice {

                /* renamed from: a  reason: collision with root package name */
                public final MethodDescription f26984a;

                /* renamed from: b  reason: collision with root package name */
                public final MethodDescription f26985b;

                /* renamed from: c  reason: collision with root package name */
                public final TypeDefinition f26986c;

                /* renamed from: d  reason: collision with root package name */
                public final SortedMap<String, TypeDefinition> f26987d;

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForMethodEnter extends Default {
                    public ForMethodEnter(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap) {
                        super(methodDescription, methodDescription2, typeDefinition, sortedMap);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    public int mapped(int i11) {
                        return (((this.f26984a.getStackSize() + this.f26986c.getStackSize().getSize()) + StackSize.of((Collection<? extends TypeDefinition>) this.f26987d.values())) - this.f26985b.getStackSize()) + i11;
                    }

                    public int returned() {
                        throw new IllegalStateException("Cannot resolve the return value offset during enter advice");
                    }

                    public int thrown() {
                        throw new IllegalStateException("Cannot resolve the thrown value offset during enter advice");
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForMethodExit extends Default {
                    private final TypeDefinition enterType;
                    private final StackSize throwableSize;

                    public ForMethodExit(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2, StackSize stackSize) {
                        super(methodDescription, methodDescription2, typeDefinition, sortedMap);
                        this.enterType = typeDefinition2;
                        this.throwableSize = stackSize;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMethodExit forMethodExit = (ForMethodExit) obj;
                        return this.throwableSize.equals(forMethodExit.throwableSize) && this.enterType.equals(forMethodExit.enterType);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.enterType.hashCode()) * 31) + this.throwableSize.hashCode();
                    }

                    public int mapped(int i11) {
                        return ((((((this.f26984a.getStackSize() + this.f26986c.getStackSize().getSize()) + StackSize.of((Collection<? extends TypeDefinition>) this.f26987d.values())) + this.enterType.getStackSize().getSize()) + this.f26984a.getReturnType().getStackSize().getSize()) + this.throwableSize.getSize()) - this.f26985b.getStackSize()) + i11;
                    }

                    public int returned() {
                        return this.f26984a.getStackSize() + this.f26986c.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26987d.values()) + this.enterType.getStackSize().getSize();
                    }

                    public int thrown() {
                        return this.f26984a.getStackSize() + this.f26986c.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26987d.values()) + this.enterType.getStackSize().getSize() + this.f26984a.getReturnType().getStackSize().getSize();
                    }
                }

                public Default(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap) {
                    this.f26984a = methodDescription;
                    this.f26985b = methodDescription2;
                    this.f26986c = typeDefinition;
                    this.f26987d = sortedMap;
                }

                public int argument(int i11) {
                    return i11;
                }

                public int enter() {
                    return this.f26984a.getStackSize() + this.f26986c.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26987d.values());
                }

                public int exit() {
                    return this.f26984a.getStackSize();
                }

                public int named(String str) {
                    return this.f26984a.getStackSize() + this.f26986c.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26987d.headMap(str).values());
                }
            }

            int mapped(int i11);
        }

        public interface ForInstrumentedMethod extends ArgumentHandler {

            public static abstract class Default implements ForInstrumentedMethod {

                /* renamed from: a  reason: collision with root package name */
                public final MethodDescription f26988a;

                /* renamed from: b  reason: collision with root package name */
                public final TypeDefinition f26989b;

                /* renamed from: c  reason: collision with root package name */
                public final SortedMap<String, TypeDefinition> f26990c;

                /* renamed from: d  reason: collision with root package name */
                public final TypeDefinition f26991d;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Copying extends Default {
                    public Copying(MethodDescription methodDescription, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                        super(methodDescription, typeDefinition, sortedMap, typeDefinition2);
                    }

                    public int argument(int i11) {
                        return this.f26988a.getStackSize() + this.f26989b.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26990c.values()) + this.f26991d.getStackSize().getSize() + i11;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    public boolean isCopyingArguments() {
                        return true;
                    }

                    public int prepare(MethodVisitor methodVisitor) {
                        StackSize stackSize;
                        if (!this.f26988a.isStatic()) {
                            methodVisitor.visitVarInsn(25, 0);
                            methodVisitor.visitVarInsn(58, this.f26988a.getStackSize() + this.f26989b.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26990c.values()) + this.f26991d.getStackSize().getSize());
                            stackSize = StackSize.SINGLE;
                        } else {
                            stackSize = StackSize.ZERO;
                        }
                        Iterator<E> it = this.f26988a.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            Type type = Type.getType(parameterDescription.getType().asErasure().getDescriptor());
                            methodVisitor.visitVarInsn(type.getOpcode(21), parameterDescription.getOffset());
                            methodVisitor.visitVarInsn(type.getOpcode(54), this.f26988a.getStackSize() + this.f26989b.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26990c.values()) + this.f26991d.getStackSize().getSize() + parameterDescription.getOffset());
                            stackSize = stackSize.maximum(parameterDescription.getType().getStackSize());
                        }
                        return stackSize.getSize();
                    }

                    public int variable(int i11) {
                        return (this.f26988a.isStatic() ^ true ? 1 : 0) + this.f26988a.getParameters().size() + (this.f26989b.represents(Void.TYPE) ^ true ? 1 : 0) + this.f26990c.size() + (this.f26991d.represents(Void.TYPE) ^ true ? 1 : 0) + i11;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple extends Default {
                    public Simple(MethodDescription methodDescription, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                        super(methodDescription, typeDefinition, sortedMap, typeDefinition2);
                    }

                    public int argument(int i11) {
                        if (i11 < this.f26988a.getStackSize()) {
                            return i11;
                        }
                        return i11 + this.f26989b.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26990c.values()) + this.f26991d.getStackSize().getSize();
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    public boolean isCopyingArguments() {
                        return false;
                    }

                    public int prepare(MethodVisitor methodVisitor) {
                        return 0;
                    }

                    public int variable(int i11) {
                        if (i11 < (this.f26988a.isStatic() ^ true ? 1 : 0) + this.f26988a.getParameters().size()) {
                            return i11;
                        }
                        return i11 + (this.f26989b.represents(Void.TYPE) ^ true ? 1 : 0) + this.f26990c.size() + (this.f26991d.represents(Void.TYPE) ^ true ? 1 : 0);
                    }
                }

                public Default(MethodDescription methodDescription, TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                    this.f26988a = methodDescription;
                    this.f26990c = sortedMap;
                    this.f26989b = typeDefinition;
                    this.f26991d = typeDefinition2;
                }

                public ForAdvice bindEnter(MethodDescription methodDescription) {
                    return new ForAdvice.Default.ForMethodEnter(this.f26988a, methodDescription, this.f26989b, this.f26990c);
                }

                public ForAdvice bindExit(MethodDescription methodDescription, boolean z11) {
                    return new ForAdvice.Default.ForMethodExit(this.f26988a, methodDescription, this.f26989b, this.f26990c, this.f26991d, z11 ? StackSize.ZERO : StackSize.SINGLE);
                }

                public int enter() {
                    return this.f26988a.getStackSize() + this.f26989b.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26990c.values());
                }

                public int exit() {
                    return this.f26988a.getStackSize();
                }

                public List<TypeDescription> getNamedTypes() {
                    ArrayList arrayList = new ArrayList(this.f26990c.size());
                    for (TypeDefinition asErasure : this.f26990c.values()) {
                        arrayList.add(asErasure.asErasure());
                    }
                    return arrayList;
                }

                public int named(String str) {
                    return this.f26988a.getStackSize() + this.f26989b.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26990c.headMap(str).values());
                }

                public int returned() {
                    return this.f26988a.getStackSize() + this.f26989b.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26990c.values()) + this.f26991d.getStackSize().getSize();
                }

                public int thrown() {
                    return this.f26988a.getStackSize() + this.f26989b.getStackSize().getSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f26990c.values()) + this.f26991d.getStackSize().getSize() + this.f26988a.getReturnType().getStackSize().getSize();
                }
            }

            ForAdvice bindEnter(MethodDescription methodDescription);

            ForAdvice bindExit(MethodDescription methodDescription, boolean z11);

            List<TypeDescription> getNamedTypes();

            boolean isCopyingArguments();

            int prepare(MethodVisitor methodVisitor);

            int variable(int i11);
        }

        int argument(int i11);

        int enter();

        int exit();

        int named(String str);

        int returned();

        int thrown();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class AssignReturned implements PostProcessor {
        public static final int NO_INDEX = -1;

        /* renamed from: b  reason: collision with root package name */
        public final TypeDescription.Generic f26992b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f26993c;

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface AsScalar {
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Factory implements PostProcessor.Factory {
            private final List<? extends Handler.Factory<?>> factories;

            public Factory() {
                this(Arrays.asList(new Enum[]{ToArguments.Handler.Factory.INSTANCE, ToAllArguments.Handler.Factory.INSTANCE, ToThis.Handler.Factory.INSTANCE, ToFields.Handler.Factory.INSTANCE, ToReturned.Handler.Factory.INSTANCE, ToThrown.Handler.Factory.INSTANCE}));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.factories.equals(((Factory) obj).factories);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.factories.hashCode();
            }

            public PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z11) {
                if (inDefinedShape.getReturnType().represents(Void.TYPE)) {
                    return PostProcessor.NoOp.INSTANCE;
                }
                HashMap hashMap = new HashMap();
                for (Handler.Factory factory : this.factories) {
                    if (hashMap.put(factory.getAnnotationType().getName(), factory) != null) {
                        throw new IllegalStateException("Duplicate registration of handler for " + factory.getAnnotationType());
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                boolean z12 = false;
                for (AnnotationDescription annotationDescription : inDefinedShape.getDeclaredAnnotations()) {
                    if (annotationDescription.getAnnotationType().represents(AsScalar.class)) {
                        z12 = true;
                    } else {
                        Handler.Factory factory2 = (Handler.Factory) hashMap.get(annotationDescription.getAnnotationType().getName());
                        if (!(factory2 == null || linkedHashMap.put(factory2.getAnnotationType(), factory2.make(inDefinedShape, z11, annotationDescription.prepare(factory2.getAnnotationType()))) == null)) {
                            throw new IllegalStateException("Duplicate handler registration for " + annotationDescription.getAnnotationType());
                        }
                    }
                }
                if (z12 || !inDefinedShape.getReturnType().isArray()) {
                    return new ForScalar(inDefinedShape.getReturnType(), z11, linkedHashMap.values());
                }
                return new ForArray(inDefinedShape.getReturnType(), z11, linkedHashMap.values());
            }

            public Factory with(Class<? extends Annotation> cls, Handler... handlerArr) {
                return with(cls, (List<Handler>) Arrays.asList(handlerArr));
            }

            public Factory(List<? extends Handler.Factory<?>> list) {
                this.factories = list;
            }

            public Factory with(Class<? extends Annotation> cls, List<Handler> list) {
                return with(new Handler.Factory.Simple(cls, list));
            }

            public Factory with(Handler.Factory<?> factory) {
                return new Factory(CompoundList.of(this.factories, factory));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForArray extends AssignReturned {
            private final Map<Handler, Integer> handlers = new LinkedHashMap();

            public ForArray(TypeDescription.Generic generic, boolean z11, Collection<List<Handler>> collection) {
                super(generic, z11);
                for (List<Handler> it : collection) {
                    Iterator it2 = it.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Handler handler = (Handler) it2.next();
                            int index = handler.getIndex();
                            if (index > -1) {
                                this.handlers.put(handler, Integer.valueOf(index));
                            } else {
                                throw new IllegalStateException("Handler on array requires positive index for " + handler);
                            }
                        }
                    }
                }
            }

            public Collection<Handler> a() {
                return this.handlers.keySet();
            }

            public TypeDescription.Generic b() {
                return this.f26992b.getComponentType();
            }

            public StackManipulation c(Handler handler, int i11) {
                return new StackManipulation.Compound(MethodVariableAccess.REFERENCE.loadFrom(i11), IntegerConstant.forValue(this.handlers.get(handler).intValue()), ArrayAccess.of(this.f26992b.getComponentType()).load());
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.handlers.equals(((ForArray) obj).handlers);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.handlers.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForScalar extends AssignReturned {
            private final List<Handler> handlers = new ArrayList();

            public ForScalar(TypeDescription.Generic generic, boolean z11, Collection<List<Handler>> collection) {
                super(generic, z11);
                for (List<Handler> it : collection) {
                    Iterator it2 = it.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Handler handler = (Handler) it2.next();
                            if (handler.getIndex() <= -1) {
                                this.handlers.add(handler);
                            } else {
                                throw new IllegalStateException("Handler on array requires negative index for " + handler);
                            }
                        }
                    }
                }
            }

            public Collection<Handler> a() {
                return this.handlers;
            }

            public TypeDescription.Generic b() {
                return this.f26992b;
            }

            public StackManipulation c(Handler handler, int i11) {
                return MethodVariableAccess.of(this.f26992b).loadFrom(i11);
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.handlers.equals(((ForScalar) obj).handlers);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.handlers.hashCode();
            }
        }

        public interface Handler {

            public interface Factory<T extends Annotation> {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple<S extends Annotation> implements Factory<S> {
                    private final List<Handler> handlers;
                    private final Class<S> type;

                    public Simple(Class<S> cls, List<Handler> list) {
                        this.type = cls;
                        this.handlers = list;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Simple simple = (Simple) obj;
                        return this.type.equals(simple.type) && this.handlers.equals(simple.handlers);
                    }

                    public Class<S> getAnnotationType() {
                        return this.type;
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.type.hashCode()) * 31) + this.handlers.hashCode();
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z11, AnnotationDescription.Loadable<? extends S> loadable) {
                        return this.handlers;
                    }
                }

                Class<T> getAnnotationType();

                List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z11, AnnotationDescription.Loadable<? extends T> loadable);
            }

            int getIndex();

            StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class NullCheck implements StackManipulation {
            private final int offset;
            private final StackManipulation stackManipulation;

            public NullCheck(StackManipulation stackManipulation2, int i11) {
                this.stackManipulation = stackManipulation2;
                this.offset = i11;
            }

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                Label label = new Label();
                methodVisitor.visitVarInsn(25, this.offset);
                methodVisitor.visitJumpInsn(Opcodes.IFNULL, label);
                StackManipulation.Size apply = this.stackManipulation.apply(methodVisitor, context);
                methodVisitor.visitLabel(label);
                return apply.aggregate(new StackManipulation.Size(0, 1));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NullCheck nullCheck = (NullCheck) obj;
                return this.offset == nullCheck.offset && this.stackManipulation.equals(nullCheck.stackManipulation);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.offset;
            }

            public boolean isValid() {
                return this.stackManipulation.isValid();
            }
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToAllArguments {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToAllArguments> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_ALL_ARGUMENTS_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_ALL_ARGUMENTS_TYPING = null;

                    /* access modifiers changed from: public */
                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToAllArguments.class).getDeclaredMethods();
                        TO_ALL_ARGUMENTS_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToAllArguments> getAnnotationType() {
                        return ToAllArguments.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z11, AnnotationDescription.Loadable<? extends ToAllArguments> loadable) {
                        return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_ALL_ARGUMENTS_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) loadable.getValue(TO_ALL_ARGUMENTS_TYPING).load(ToAllArguments.class.getClassLoader()).resolve(Assigner.Typing.class)));
                    }
                }

                public Handler(int i11, Assigner.Typing typing2) {
                    this.index = i11;
                    this.typing = typing2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.index) * 31) + this.typing.hashCode();
                }

                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    ArrayList arrayList = new ArrayList(methodDescription.getParameters().size());
                    if (!generic.isArray()) {
                        Class<Object[]> cls = Object[].class;
                        StackManipulation assign = assigner.assign(generic, TypeDefinition.Sort.describe(cls), this.typing);
                        if (assign.isValid()) {
                            generic = TypeDefinition.Sort.describe(cls);
                            stackManipulation = new StackManipulation.Compound(stackManipulation, assign);
                        } else {
                            throw new IllegalStateException("Cannot assign " + generic + " to " + cls);
                        }
                    }
                    Iterator<E> it = methodDescription.getParameters().iterator();
                    while (it.hasNext()) {
                        ParameterDescription parameterDescription = (ParameterDescription) it.next();
                        StackManipulation assign2 = assigner.assign(generic.getComponentType(), parameterDescription.getType(), this.typing);
                        if (assign2.isValid()) {
                            arrayList.add(new StackManipulation.Compound(assign2, MethodVariableAccess.of(parameterDescription.getType()).storeAt(argumentHandler.argument(parameterDescription.getOffset()))));
                        } else {
                            throw new IllegalStateException("Cannot assign " + generic.getComponentType() + " to " + parameterDescription);
                        }
                    }
                    return new StackManipulation.Compound(stackManipulation, ArrayAccess.of(generic.getComponentType()).forEach(arrayList), Removal.SINGLE);
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToArguments {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;
                private final int value;

                public enum Factory implements Handler.Factory<ToArguments> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_ARGUMENTS_VALUE = null;
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_TYPING = null;
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_VALUE = null;

                    /* access modifiers changed from: public */
                    static {
                        TO_ARGUMENTS_VALUE = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(ToArguments.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly();
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToArgument.class).getDeclaredMethods();
                        TO_ARGUMENT_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                        TO_ARGUMENT_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_ARGUMENT_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToArguments> getAnnotationType() {
                        return ToArguments.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z11, AnnotationDescription.Loadable<? extends ToArguments> loadable) {
                        ArrayList arrayList = new ArrayList();
                        AnnotationDescription[] annotationDescriptionArr = (AnnotationDescription[]) loadable.getValue(TO_ARGUMENTS_VALUE).resolve(AnnotationDescription[].class);
                        int length = annotationDescriptionArr.length;
                        int i11 = 0;
                        while (i11 < length) {
                            AnnotationDescription annotationDescription = annotationDescriptionArr[i11];
                            Class<Integer> cls = Integer.class;
                            int intValue = ((Integer) annotationDescription.getValue(TO_ARGUMENT_VALUE).resolve(cls)).intValue();
                            if (intValue >= 0) {
                                arrayList.add(new Handler(intValue, ((Integer) annotationDescription.getValue(TO_ARGUMENT_INDEX).resolve(cls)).intValue(), (Assigner.Typing) annotationDescription.getValue(TO_ARGUMENT_TYPING).load(ToArguments.class.getClassLoader()).resolve(Assigner.Typing.class)));
                                i11++;
                            } else {
                                throw new IllegalStateException("An argument cannot have a negative index for " + inDefinedShape);
                            }
                        }
                        return arrayList;
                    }
                }

                public Handler(int i11, int i12, Assigner.Typing typing2) {
                    this.value = i11;
                    this.index = i12;
                    this.typing = typing2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.value == handler.value && this.index == handler.index && this.typing.equals(handler.typing);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.value) * 31) + this.index) * 31) + this.typing.hashCode();
                }

                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.getParameters().size() >= this.value) {
                        StackManipulation assign = assigner.assign(generic, ((ParameterDescription) methodDescription.getParameters().get(this.value)).getType(), this.typing);
                        if (assign.isValid()) {
                            return new StackManipulation.Compound(stackManipulation, assign, MethodVariableAccess.of(((ParameterDescription) methodDescription.getParameters().get(this.value)).getType()).storeAt(argumentHandler.argument(((ParameterDescription) methodDescription.getParameters().get(this.value)).getOffset())));
                        }
                        throw new IllegalStateException("Cannot assign " + generic + " to " + ((ParameterDescription) methodDescription.getParameters().get(this.value)).getType());
                    }
                    throw new IllegalStateException(methodDescription + " declares less then " + this.value + " parameters");
                }
            }

            @Target({})
            @RepeatedAnnotationPlugin.Enhance(ToArguments.class)
            public @interface ToArgument {
                int index() default -1;

                Assigner.Typing typing() default Assigner.Typing.STATIC;

                int value();
            }

            ToArgument[] value();
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToFields {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final TypeDescription declaringType;
                private final int index;

                /* renamed from: name  reason: collision with root package name */
                private final String f26994name;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToFields> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_FIELDS_VALUE = null;
                    private static final MethodDescription.InDefinedShape TO_FIELD_DECLARING_TYPE = null;
                    private static final MethodDescription.InDefinedShape TO_FIELD_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_FIELD_TYPING = null;
                    private static final MethodDescription.InDefinedShape TO_FIELD_VALUE = null;

                    /* access modifiers changed from: public */
                    static {
                        TO_FIELDS_VALUE = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(ToFields.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly();
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToField.class).getDeclaredMethods();
                        TO_FIELD_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                        TO_FIELD_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_FIELD_DECLARING_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("declaringType"))).getOnly();
                        TO_FIELD_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToFields> getAnnotationType() {
                        return ToFields.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z11, AnnotationDescription.Loadable<? extends ToFields> loadable) {
                        ArrayList arrayList = new ArrayList();
                        for (AnnotationDescription annotationDescription : (AnnotationDescription[]) loadable.getValue(TO_FIELDS_VALUE).resolve(AnnotationDescription[].class)) {
                            arrayList.add(new Handler(((Integer) annotationDescription.getValue(TO_FIELD_INDEX).resolve(Integer.class)).intValue(), (String) annotationDescription.getValue(TO_FIELD_VALUE).resolve(String.class), (TypeDescription) annotationDescription.getValue(TO_FIELD_DECLARING_TYPE).resolve(TypeDescription.class), (Assigner.Typing) annotationDescription.getValue(TO_FIELD_TYPING).load(ToFields.class.getClassLoader()).resolve(Assigner.Typing.class)));
                        }
                        return arrayList;
                    }
                }

                public Handler(int i11, String str, TypeDescription typeDescription, Assigner.Typing typing2) {
                    this.index = i11;
                    this.f26994name = str;
                    this.declaringType = typeDescription;
                    this.typing = typing2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing) && this.f26994name.equals(handler.f26994name) && this.declaringType.equals(handler.declaringType);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((((((getClass().hashCode() * 31) + this.index) * 31) + this.f26994name.hashCode()) * 31) + this.declaringType.hashCode()) * 31) + this.typing.hashCode();
                }

                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    FieldLocator fieldLocator;
                    FieldLocator.Resolution resolution;
                    StackManipulation stackManipulation2;
                    if (this.declaringType.represents(Void.TYPE)) {
                        fieldLocator = new FieldLocator.ForClassHierarchy(typeDescription);
                    } else {
                        fieldLocator = new FieldLocator.ForExactType(this.declaringType);
                    }
                    if (this.f26994name.equals("")) {
                        resolution = OffsetMapping.ForField.Unresolved.resolveAccessor(fieldLocator, methodDescription);
                    } else {
                        resolution = fieldLocator.locate(this.f26994name);
                    }
                    if (!resolution.isResolved()) {
                        throw new IllegalStateException("Cannot resolve field " + this.f26994name + " for " + typeDescription);
                    } else if (resolution.getField().isVisibleTo(typeDescription)) {
                        if (resolution.getField().isStatic()) {
                            stackManipulation2 = StackManipulation.Trivial.INSTANCE;
                        } else if (methodDescription.isStatic()) {
                            throw new IllegalStateException("Cannot access member field " + resolution.getField() + " from static " + methodDescription);
                        } else if (typeDescription.isAssignableTo(resolution.getField().getDeclaringType().asErasure())) {
                            stackManipulation2 = MethodVariableAccess.loadThis();
                        } else {
                            throw new IllegalStateException(typeDescription + " does not define " + resolution.getField());
                        }
                        StackManipulation assign = assigner.assign(generic, resolution.getField().getType(), this.typing);
                        if (assign.isValid()) {
                            return new StackManipulation.Compound(stackManipulation2, stackManipulation, assign, FieldAccess.forField(resolution.getField()).write());
                        }
                        throw new IllegalStateException("Cannot assign " + generic + " to " + resolution.getField());
                    } else {
                        throw new IllegalStateException(resolution.getField() + " is not visible to " + typeDescription);
                    }
                }
            }

            @Target({})
            @RepeatedAnnotationPlugin.Enhance(ToFields.class)
            public @interface ToField {
                Class<?> declaringType() default void.class;

                int index() default -1;

                Assigner.Typing typing() default Assigner.Typing.STATIC;

                String value() default "";
            }

            ToField[] value();
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToReturned {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToReturned> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_RETURNED_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_RETURNED_TYPING = null;

                    /* access modifiers changed from: public */
                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToReturned.class).getDeclaredMethods();
                        TO_RETURNED_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_RETURNED_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToReturned> getAnnotationType() {
                        return ToReturned.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z11, AnnotationDescription.Loadable<? extends ToReturned> loadable) {
                        if (z11) {
                            return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_RETURNED_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) loadable.getValue(TO_RETURNED_TYPING).load(ToReturned.class.getClassLoader()).resolve(Assigner.Typing.class)));
                        }
                        throw new IllegalStateException("Cannot write returned value from enter advice " + inDefinedShape);
                    }
                }

                public Handler(int i11, Assigner.Typing typing2) {
                    this.index = i11;
                    this.typing = typing2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.index) * 31) + this.typing.hashCode();
                }

                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return StackManipulation.Trivial.INSTANCE;
                    }
                    StackManipulation assign = assigner.assign(generic, methodDescription.getReturnType(), this.typing);
                    if (assign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, assign, MethodVariableAccess.of(methodDescription.getReturnType()).storeAt(argumentHandler.returned()));
                    }
                    throw new IllegalStateException("Cannot assign " + generic + " to " + methodDescription.getReturnType());
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToThis {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final boolean exit;
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToThis> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_THIS_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_THIS_TYPING = null;

                    /* access modifiers changed from: public */
                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToThis.class).getDeclaredMethods();
                        TO_THIS_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_THIS_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToThis> getAnnotationType() {
                        return ToThis.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z11, AnnotationDescription.Loadable<? extends ToThis> loadable) {
                        return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_THIS_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) loadable.getValue(TO_THIS_TYPING).load(ToThis.class.getClassLoader()).resolve(Assigner.Typing.class), z11));
                    }
                }

                public Handler(int i11, Assigner.Typing typing2, boolean z11) {
                    this.index = i11;
                    this.typing = typing2;
                    this.exit = z11;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.exit == handler.exit && this.typing.equals(handler.typing);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.index) * 31) + this.typing.hashCode()) * 31) + (this.exit ? 1 : 0);
                }

                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.isStatic()) {
                        throw new IllegalStateException("Cannot assign this reference for static method " + methodDescription);
                    } else if (this.exit || !methodDescription.isConstructor()) {
                        StackManipulation assign = assigner.assign(generic, typeDescription.asGenericType(), this.typing);
                        if (assign.isValid()) {
                            return new StackManipulation.Compound(stackManipulation, assign, MethodVariableAccess.REFERENCE.storeAt(argumentHandler.argument(0)));
                        }
                        throw new IllegalStateException("Cannot assign " + generic + " to " + typeDescription);
                    } else {
                        throw new IllegalStateException("Cannot assign this reference in constructor prior to initialization for " + methodDescription);
                    }
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        @Documented
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToThrown {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                public enum Factory implements Handler.Factory<ToThrown> {
                    INSTANCE;
                    
                    private static final MethodDescription.InDefinedShape TO_THROWN_INDEX = null;
                    private static final MethodDescription.InDefinedShape TO_THROWN_TYPING = null;

                    /* access modifiers changed from: public */
                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(ToThrown.class).getDeclaredMethods();
                        TO_THROWN_INDEX = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named(FirebaseAnalytics.Param.INDEX))).getOnly();
                        TO_THROWN_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    }

                    public Class<ToThrown> getAnnotationType() {
                        return ToThrown.class;
                    }

                    public List<Handler> make(MethodDescription.InDefinedShape inDefinedShape, boolean z11, AnnotationDescription.Loadable<? extends ToThrown> loadable) {
                        if (!z11) {
                            throw new IllegalStateException("Cannot assign thrown value from enter advice " + inDefinedShape);
                        } else if (!((TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class)).represents(NoExceptionHandler.class)) {
                            return Collections.singletonList(new Handler(((Integer) loadable.getValue(TO_THROWN_INDEX).resolve(Integer.class)).intValue(), (Assigner.Typing) loadable.getValue(TO_THROWN_TYPING).load(ToThrown.class.getClassLoader()).resolve(Assigner.Typing.class)));
                        } else {
                            throw new IllegalStateException("Cannot assign thrown value for non-catching exit advice " + inDefinedShape);
                        }
                    }
                }

                public Handler(int i11, Assigner.Typing typing2) {
                    this.index = i11;
                    this.typing = typing2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.index) * 31) + this.typing.hashCode();
                }

                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                    if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return StackManipulation.Trivial.INSTANCE;
                    }
                    Class<Throwable> cls = Throwable.class;
                    StackManipulation assign = assigner.assign(generic, TypeDefinition.Sort.describe(cls), this.typing);
                    if (assign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, assign, MethodVariableAccess.REFERENCE.storeAt(argumentHandler.thrown()));
                    }
                    throw new IllegalStateException("Cannot assign " + generic + " to " + cls.getName());
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        public AssignReturned(TypeDescription.Generic generic, boolean z11) {
            this.f26992b = generic;
            this.f26993c = z11;
        }

        public abstract Collection<Handler> a();

        public abstract TypeDescription.Generic b();

        public abstract StackManipulation c(Handler handler, int i11);

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AssignReturned assignReturned = (AssignReturned) obj;
            return this.f26993c == assignReturned.f26993c && this.f26992b.equals(assignReturned.f26992b);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.f26992b.hashCode()) * 31) + (this.f26993c ? 1 : 0);
        }

        public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler) {
            int i11;
            int i12;
            ArrayList arrayList = new ArrayList(a().size());
            for (Handler next : a()) {
                TypeDescription.Generic b11 = b();
                if (this.f26993c) {
                    i12 = argumentHandler.exit();
                } else {
                    i12 = argumentHandler.enter();
                }
                arrayList.add(next.resolve(typeDescription, methodDescription, assigner, argumentHandler, b11, c(next, i12)));
            }
            if (this.f26992b.isPrimitive()) {
                return new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
            }
            StackManipulation.Compound compound = new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
            if (this.f26993c) {
                i11 = argumentHandler.exit();
            } else {
                i11 = argumentHandler.enter();
            }
            return new NullCheck(compound, i11);
        }
    }

    public interface Delegator {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDynamicInvocation implements Delegator {
            private final MethodDescription.InDefinedShape bootstrapMethod;

            public ForDynamicInvocation(MethodDescription.InDefinedShape inDefinedShape) {
                this.bootstrapMethod = inDefinedShape;
            }

            public static Delegator a(MethodDescription.InDefinedShape inDefinedShape) {
                if (inDefinedShape.isInvokeBootstrap()) {
                    return new ForDynamicInvocation(inDefinedShape);
                }
                throw new IllegalArgumentException("Not a suitable bootstrap target: " + inDefinedShape);
            }

            public void apply(MethodVisitor methodVisitor, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, boolean z11) {
                Object[] objArr;
                int i11;
                if (methodDescription.isTypeInitializer()) {
                    MethodDescription.InDefinedShape inDefinedShape2 = this.bootstrapMethod;
                    TypeDescription typeDescription2 = TypeDescription.STRING;
                    if (inDefinedShape2.isInvokeBootstrap(Arrays.asList(new TypeDescription[]{typeDescription2, TypeDescription.ForLoadedType.of(Integer.TYPE), TypeDescription.CLASS, typeDescription2}))) {
                        objArr = new Object[]{inDefinedShape.getDeclaringType().getName(), Integer.valueOf(z11), Type.getType(typeDescription.getDescriptor()), methodDescription.getInternalName()};
                    } else {
                        throw new IllegalArgumentException(this.bootstrapMethod + " is not accepting advice bootstrap arguments");
                    }
                } else {
                    MethodDescription.InDefinedShape inDefinedShape3 = this.bootstrapMethod;
                    TypeDescription typeDescription3 = TypeDescription.STRING;
                    if (inDefinedShape3.isInvokeBootstrap(Arrays.asList(new TypeDescription[]{typeDescription3, TypeDescription.ForLoadedType.of(Integer.TYPE), TypeDescription.CLASS, typeDescription3, JavaType.METHOD_HANDLE.getTypeStub()}))) {
                        objArr = new Object[]{inDefinedShape.getDeclaringType().getName(), Integer.valueOf(z11 ? 1 : 0), Type.getType(typeDescription.getDescriptor()), methodDescription.getInternalName(), JavaConstant.MethodHandle.of((MethodDescription.InDefinedShape) methodDescription.asDefined()).accept(JavaConstantValue.Visitor.INSTANCE)};
                    } else {
                        throw new IllegalArgumentException(this.bootstrapMethod + " is not accepting advice bootstrap arguments");
                    }
                }
                String internalName = inDefinedShape.getInternalName();
                String descriptor = inDefinedShape.getDescriptor();
                if (this.bootstrapMethod.isConstructor()) {
                    i11 = 8;
                } else {
                    i11 = 6;
                }
                MethodVisitor methodVisitor2 = methodVisitor;
                methodVisitor.visitInvokeDynamicInsn(internalName, descriptor, new Handle(i11, this.bootstrapMethod.getDeclaringType().getInternalName(), this.bootstrapMethod.getInternalName(), this.bootstrapMethod.getDescriptor(), false), objArr);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.bootstrapMethod.equals(((ForDynamicInvocation) obj).bootstrapMethod);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.bootstrapMethod.hashCode();
            }
        }

        public enum ForStaticInvocation implements Delegator {
            INSTANCE;

            public void apply(MethodVisitor methodVisitor, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, boolean z11) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, inDefinedShape.getDeclaringType().getInternalName(), inDefinedShape.getInternalName(), inDefinedShape.getDescriptor(), false);
            }
        }

        void apply(MethodVisitor methodVisitor, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, boolean z11);
    }

    public interface Dispatcher {
        public static final AnnotationVisitor IGNORE_ANNOTATION = null;
        public static final MethodVisitor IGNORE_METHOD = null;

        public interface Bound {
            void apply();

            void initialize();

            void prepare();
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Delegating implements Unresolved {

            /* renamed from: b  reason: collision with root package name */
            public final MethodDescription.InDefinedShape f26995b;

            /* renamed from: c  reason: collision with root package name */
            public final Delegator f26996c;

            public static abstract class Resolved extends Resolved.AbstractBase {

                /* renamed from: g  reason: collision with root package name */
                public final Delegator f26997g;

                public static abstract class AdviceMethodWriter implements Bound {
                    private final Assigner assigner;

                    /* renamed from: b  reason: collision with root package name */
                    public final MethodDescription.InDefinedShape f26998b;

                    /* renamed from: c  reason: collision with root package name */
                    public final MethodVisitor f26999c;

                    /* renamed from: d  reason: collision with root package name */
                    public final Implementation.Context f27000d;
                    private final Delegator delegator;

                    /* renamed from: e  reason: collision with root package name */
                    public final ArgumentHandler.ForAdvice f27001e;

                    /* renamed from: f  reason: collision with root package name */
                    public final MethodSizeHandler.ForAdvice f27002f;

                    /* renamed from: g  reason: collision with root package name */
                    public final StackMapFrameHandler.ForAdvice f27003g;
                    private final MethodDescription instrumentedMethod;
                    private final TypeDescription instrumentedType;
                    private final List<OffsetMapping.Target> offsetMappings;
                    private final PostProcessor postProcessor;
                    private final RelocationHandler.Bound relocationHandler;
                    private final SuppressionHandler.Bound suppressionHandler;

                    public static class ForMethodEnter extends AdviceMethodWriter {
                        public ForMethodEnter(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, PostProcessor postProcessor, List<OffsetMapping.Target> list, MethodVisitor methodVisitor, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, Delegator delegator) {
                            super(inDefinedShape, typeDescription, methodDescription, assigner, postProcessor, list, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, delegator);
                        }

                        public boolean a() {
                            return false;
                        }

                        public void initialize() {
                        }
                    }

                    public static class ForMethodExit extends AdviceMethodWriter {
                        public ForMethodExit(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, PostProcessor postProcessor, List<OffsetMapping.Target> list, MethodVisitor methodVisitor, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, Delegator delegator) {
                            super(inDefinedShape, typeDescription, methodDescription, assigner, postProcessor, list, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, delegator);
                        }

                        public boolean a() {
                            return true;
                        }

                        public void initialize() {
                            if (this.f26998b.getReturnType().represents(Boolean.TYPE) || this.f26998b.getReturnType().represents(Byte.TYPE) || this.f26998b.getReturnType().represents(Short.TYPE) || this.f26998b.getReturnType().represents(Character.TYPE) || this.f26998b.getReturnType().represents(Integer.TYPE)) {
                                this.f26999c.visitInsn(3);
                                this.f26999c.visitVarInsn(54, this.f27001e.exit());
                            } else if (this.f26998b.getReturnType().represents(Long.TYPE)) {
                                this.f26999c.visitInsn(9);
                                this.f26999c.visitVarInsn(55, this.f27001e.exit());
                            } else if (this.f26998b.getReturnType().represents(Float.TYPE)) {
                                this.f26999c.visitInsn(11);
                                this.f26999c.visitVarInsn(56, this.f27001e.exit());
                            } else if (this.f26998b.getReturnType().represents(Double.TYPE)) {
                                this.f26999c.visitInsn(14);
                                this.f26999c.visitVarInsn(57, this.f27001e.exit());
                            } else if (!this.f26998b.getReturnType().represents(Void.TYPE)) {
                                this.f26999c.visitInsn(1);
                                this.f26999c.visitVarInsn(58, this.f27001e.exit());
                            }
                            this.f27002f.requireStackSize(this.f26998b.getReturnType().getStackSize().getSize());
                        }
                    }

                    public AdviceMethodWriter(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner2, PostProcessor postProcessor2, List<OffsetMapping.Target> list, MethodVisitor methodVisitor, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, Delegator delegator2) {
                        this.f26998b = inDefinedShape;
                        this.instrumentedType = typeDescription;
                        this.instrumentedMethod = methodDescription;
                        this.assigner = assigner2;
                        this.postProcessor = postProcessor2;
                        this.offsetMappings = list;
                        this.f26999c = methodVisitor;
                        this.f27000d = context;
                        this.f27001e = forAdvice;
                        this.f27002f = forAdvice2;
                        this.f27003g = forAdvice3;
                        this.suppressionHandler = bound;
                        this.relocationHandler = bound2;
                        this.delegator = delegator2;
                    }

                    public abstract boolean a();

                    public void apply() {
                        int i11;
                        int i12;
                        int i13;
                        int i14;
                        int i15;
                        int i16;
                        this.suppressionHandler.onStart(this.f26999c);
                        int i17 = 0;
                        int i18 = 0;
                        int i19 = 0;
                        for (OffsetMapping.Target resolveRead : this.offsetMappings) {
                            i17 += ((ParameterDescription.InDefinedShape) this.f26998b.getParameters().get(i18)).getType().getStackSize().getSize();
                            i19 = Math.max(i19, resolveRead.resolveRead().apply(this.f26999c, this.f27000d).getMaximalSize() + i17);
                            i18++;
                        }
                        this.delegator.apply(this.f26999c, this.f26998b, this.instrumentedType, this.instrumentedMethod, a());
                        this.suppressionHandler.onEndWithSkip(this.f26999c, this.f27000d, this.f27002f, this.f27003g, this.f26998b.getReturnType());
                        if (this.f26998b.getReturnType().represents(Boolean.TYPE) || this.f26998b.getReturnType().represents(Byte.TYPE) || this.f26998b.getReturnType().represents(Short.TYPE) || this.f26998b.getReturnType().represents(Character.TYPE) || this.f26998b.getReturnType().represents(Integer.TYPE)) {
                            MethodVisitor methodVisitor = this.f26999c;
                            if (a()) {
                                i12 = this.f27001e.exit();
                            } else {
                                i12 = this.f27001e.enter();
                            }
                            methodVisitor.visitVarInsn(54, i12);
                        } else if (this.f26998b.getReturnType().represents(Long.TYPE)) {
                            MethodVisitor methodVisitor2 = this.f26999c;
                            if (a()) {
                                i16 = this.f27001e.exit();
                            } else {
                                i16 = this.f27001e.enter();
                            }
                            methodVisitor2.visitVarInsn(55, i16);
                        } else if (this.f26998b.getReturnType().represents(Float.TYPE)) {
                            MethodVisitor methodVisitor3 = this.f26999c;
                            if (a()) {
                                i15 = this.f27001e.exit();
                            } else {
                                i15 = this.f27001e.enter();
                            }
                            methodVisitor3.visitVarInsn(56, i15);
                        } else if (this.f26998b.getReturnType().represents(Double.TYPE)) {
                            MethodVisitor methodVisitor4 = this.f26999c;
                            if (a()) {
                                i14 = this.f27001e.exit();
                            } else {
                                i14 = this.f27001e.enter();
                            }
                            methodVisitor4.visitVarInsn(57, i14);
                        } else if (!this.f26998b.getReturnType().represents(Void.TYPE)) {
                            MethodVisitor methodVisitor5 = this.f26999c;
                            if (a()) {
                                i13 = this.f27001e.exit();
                            } else {
                                i13 = this.f27001e.enter();
                            }
                            methodVisitor5.visitVarInsn(58, i13);
                        }
                        this.f27002f.requireStackSize(this.postProcessor.resolve(this.instrumentedType, this.instrumentedMethod, this.assigner, this.f27001e).apply(this.f26999c, this.f27000d).getMaximalSize());
                        MethodSizeHandler.ForAdvice forAdvice = this.f27002f;
                        RelocationHandler.Bound bound = this.relocationHandler;
                        MethodVisitor methodVisitor6 = this.f26999c;
                        if (a()) {
                            i11 = this.f27001e.exit();
                        } else {
                            i11 = this.f27001e.enter();
                        }
                        forAdvice.requireStackSize(bound.apply(methodVisitor6, i11));
                        this.f27003g.injectCompletionFrame(this.f26999c);
                        this.f27002f.requireStackSize(Math.max(i19, this.f26998b.getReturnType().getStackSize().getSize()));
                        this.f27002f.requireLocalVariableLength(this.instrumentedMethod.getStackSize() + this.f26998b.getReturnType().getStackSize().getSize());
                    }

                    public void prepare() {
                        this.suppressionHandler.onPrepare(this.f26999c);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodEnter extends Resolved implements Resolved.ForMethodEnter {
                    private final boolean prependLineNumber;

                    public static class WithDiscardedEnterType extends ForMethodEnter {
                        public WithDiscardedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                        }

                        public Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2) {
                            forAdvice2.requireLocalVariableLengthPadding(this.f27032b.getReturnType().getStackSize().getSize());
                            return super.doResolve(typeDescription, methodDescription, methodVisitor, context, assigner, forAdvice, forAdvice2, forAdvice3, bound, bound2);
                        }

                        public TypeDefinition getAdviceType() {
                            return TypeDescription.VOID;
                        }
                    }

                    public static class WithRetainedEnterType extends ForMethodEnter {
                        public WithRetainedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                        }

                        public TypeDefinition getAdviceType() {
                            return this.f27032b.getReturnType();
                        }
                    }

                    /* JADX WARNING: Illegal instructions before constructor call */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public ForMethodEnter(net.bytebuddy.description.method.MethodDescription.InDefinedShape r8, net.bytebuddy.asm.Advice.PostProcessor r9, java.util.List<? extends net.bytebuddy.asm.Advice.OffsetMapping.Factory<?>> r10, net.bytebuddy.description.type.TypeDefinition r11, net.bytebuddy.asm.Advice.Delegator r12) {
                        /*
                            r7 = this;
                            r0 = 12
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory[] r0 = new net.bytebuddy.asm.Advice.OffsetMapping.Factory[r0]
                            r1 = 0
                            net.bytebuddy.asm.Advice$OffsetMapping$ForArgument$Unresolved$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForAllArguments$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 2
                            net.bytebuddy.asm.Advice$OffsetMapping$ForThisReference$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 3
                            net.bytebuddy.asm.Advice$OffsetMapping$ForField$Unresolved$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 4
                            net.bytebuddy.asm.Advice$OffsetMapping$ForOrigin$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 5
                            net.bytebuddy.asm.Advice$OffsetMapping$ForUnusedValue$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 6
                            net.bytebuddy.asm.Advice$OffsetMapping$ForStubValue r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForStubValue.INSTANCE
                            r0[r1] = r2
                            r1 = 7
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r11 = net.bytebuddy.asm.Advice.OffsetMapping.ForExitValue.Factory.c(r11)
                            r0[r1] = r11
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r11 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Thrown> r1 = net.bytebuddy.asm.Advice.Thrown.class
                            r11.<init>(r1)
                            r1 = 8
                            r0[r1] = r11
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r11 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Enter> r1 = net.bytebuddy.asm.Advice.Enter.class
                            r11.<init>(r1)
                            r1 = 9
                            r0[r1] = r11
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r11 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Local> r1 = net.bytebuddy.asm.Advice.Local.class
                            r11.<init>(r1)
                            r1 = 10
                            r0[r1] = r11
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r11 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Return> r1 = net.bytebuddy.asm.Advice.Return.class
                            r11.<init>(r1)
                            r1 = 11
                            r0[r1] = r11
                            java.util.List r11 = java.util.Arrays.asList(r0)
                            java.util.List r3 = net.bytebuddy.utility.CompoundList.of(r11, r10)
                            net.bytebuddy.description.annotation.AnnotationList r10 = r8.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodEnter> r11 = net.bytebuddy.asm.Advice.OnMethodEnter.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r10 = r10.ofType(r11)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.SUPPRESS_ENTER
                            net.bytebuddy.description.annotation.AnnotationValue r10 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r0 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r10 = r10.resolve(r0)
                            r4 = r10
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            net.bytebuddy.description.annotation.AnnotationList r10 = r8.getDeclaredAnnotations()
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r10 = r10.ofType(r11)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.SKIP_ON
                            net.bytebuddy.description.annotation.AnnotationValue r10 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                            java.lang.Object r10 = r10.resolve(r0)
                            r5 = r10
                            net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5
                            r0 = r7
                            r1 = r8
                            r2 = r9
                            r6 = r12
                            r0.<init>(r1, r2, r3, r4, r5, r6)
                            net.bytebuddy.description.annotation.AnnotationList r8 = r8.getDeclaredAnnotations()
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r8 = r8.ofType(r11)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r9 = net.bytebuddy.asm.Advice.PREPEND_LINE_NUMBER
                            net.bytebuddy.description.annotation.AnnotationValue r8 = r8.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r9)
                            java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
                            java.lang.Object r8 = r8.resolve(r9)
                            java.lang.Boolean r8 = (java.lang.Boolean) r8
                            boolean r8 = r8.booleanValue()
                            r7.prependLineNumber = r8
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.ForMethodEnter.<init>(net.bytebuddy.description.method.MethodDescription$InDefinedShape, net.bytebuddy.asm.Advice$PostProcessor, java.util.List, net.bytebuddy.description.type.TypeDefinition, net.bytebuddy.asm.Advice$Delegator):void");
                    }

                    public static Resolved.ForMethodEnter b(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Delegator delegator, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, boolean z11) {
                        return z11 ? new WithRetainedEnterType(inDefinedShape, postProcessor, list, typeDefinition, delegator) : new WithDiscardedEnterType(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                    }

                    public Bound a(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        return doResolve(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod.bindEnter(this.f27032b), forInstrumentedMethod2.bindEnter(this.f27032b), forInstrumentedMethod3.bindEnter(this.f27032b), this.f27035e.bind(stackManipulation), this.f27036f.bind(methodDescription, relocation));
                    }

                    public Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2) {
                        ArrayList arrayList = new ArrayList(this.f27034d.size());
                        for (OffsetMapping resolve : this.f27034d.values()) {
                            arrayList.add(resolve.resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.ENTER));
                        }
                        return new AdviceMethodWriter.ForMethodEnter(this.f27032b, typeDescription, methodDescription, assigner, this.f27033c, arrayList, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, this.f26997g);
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.prependLineNumber == ((ForMethodEnter) obj).prependLineNumber;
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + (this.prependLineNumber ? 1 : 0);
                    }

                    public boolean isPrependLineNumber() {
                        return this.prependLineNumber;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodExit extends Resolved implements Resolved.ForMethodExit {
                    private final boolean backupArguments;

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class WithExceptionHandler extends ForMethodExit {
                        private final TypeDescription throwable;

                        public WithExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, TypeDescription typeDescription, Delegator delegator) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, delegator);
                            this.throwable = typeDescription;
                        }

                        public boolean equals(Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.throwable.equals(((WithExceptionHandler) obj).throwable);
                        }

                        public TypeDescription getThrowable() {
                            return this.throwable;
                        }

                        public int hashCode() {
                            return (super.hashCode() * 31) + this.throwable.hashCode();
                        }
                    }

                    public static class WithoutExceptionHandler extends ForMethodExit {
                        public WithoutExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, delegator);
                        }

                        public TypeDescription getThrowable() {
                            return NoExceptionHandler.DESCRIPTION;
                        }
                    }

                    /* JADX WARNING: Illegal instructions before constructor call */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public ForMethodExit(net.bytebuddy.description.method.MethodDescription.InDefinedShape r8, net.bytebuddy.asm.Advice.PostProcessor r9, java.util.Map<java.lang.String, net.bytebuddy.description.type.TypeDefinition> r10, java.util.List<? extends net.bytebuddy.asm.Advice.OffsetMapping.Factory<?>> r11, net.bytebuddy.description.type.TypeDefinition r12, net.bytebuddy.asm.Advice.Delegator r13) {
                        /*
                            r7 = this;
                            r0 = 12
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory[] r0 = new net.bytebuddy.asm.Advice.OffsetMapping.Factory[r0]
                            r1 = 0
                            net.bytebuddy.asm.Advice$OffsetMapping$ForArgument$Unresolved$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForAllArguments$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 2
                            net.bytebuddy.asm.Advice$OffsetMapping$ForThisReference$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 3
                            net.bytebuddy.asm.Advice$OffsetMapping$ForField$Unresolved$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 4
                            net.bytebuddy.asm.Advice$OffsetMapping$ForOrigin$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 5
                            net.bytebuddy.asm.Advice$OffsetMapping$ForUnusedValue$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 6
                            net.bytebuddy.asm.Advice$OffsetMapping$ForStubValue r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForStubValue.INSTANCE
                            r0[r1] = r2
                            r1 = 7
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r12 = net.bytebuddy.asm.Advice.OffsetMapping.ForEnterValue.Factory.c(r12)
                            r0[r1] = r12
                            net.bytebuddy.description.type.TypeDescription$Generic r12 = r8.getReturnType()
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r12 = net.bytebuddy.asm.Advice.OffsetMapping.ForExitValue.Factory.c(r12)
                            r1 = 8
                            r0[r1] = r12
                            net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory r12 = new net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory
                            r12.<init>(r10)
                            r10 = 9
                            r0[r10] = r12
                            r10 = 10
                            net.bytebuddy.asm.Advice$OffsetMapping$ForReturnValue$Factory r12 = net.bytebuddy.asm.Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE
                            r0[r10] = r12
                            r10 = 11
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r12 = net.bytebuddy.asm.Advice.OffsetMapping.ForThrowable.Factory.c(r8)
                            r0[r10] = r12
                            java.util.List r10 = java.util.Arrays.asList(r0)
                            java.util.List r3 = net.bytebuddy.utility.CompoundList.of(r10, r11)
                            net.bytebuddy.description.annotation.AnnotationList r10 = r8.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodExit> r11 = net.bytebuddy.asm.Advice.OnMethodExit.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r10 = r10.ofType(r11)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r12 = net.bytebuddy.asm.Advice.SUPPRESS_EXIT
                            net.bytebuddy.description.annotation.AnnotationValue r10 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r12)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r12 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r10 = r10.resolve(r12)
                            r4 = r10
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            net.bytebuddy.description.annotation.AnnotationList r10 = r8.getDeclaredAnnotations()
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r10 = r10.ofType(r11)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.REPEAT_ON
                            net.bytebuddy.description.annotation.AnnotationValue r10 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                            java.lang.Object r10 = r10.resolve(r12)
                            r5 = r10
                            net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5
                            r0 = r7
                            r1 = r8
                            r2 = r9
                            r6 = r13
                            r0.<init>(r1, r2, r3, r4, r5, r6)
                            net.bytebuddy.description.annotation.AnnotationList r8 = r8.getDeclaredAnnotations()
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r8 = r8.ofType(r11)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r9 = net.bytebuddy.asm.Advice.BACKUP_ARGUMENTS
                            net.bytebuddy.description.annotation.AnnotationValue r8 = r8.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r9)
                            java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
                            java.lang.Object r8 = r8.resolve(r9)
                            java.lang.Boolean r8 = (java.lang.Boolean) r8
                            boolean r8 = r8.booleanValue()
                            r7.backupArguments = r8
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.ForMethodExit.<init>(net.bytebuddy.description.method.MethodDescription$InDefinedShape, net.bytebuddy.asm.Advice$PostProcessor, java.util.Map, java.util.List, net.bytebuddy.description.type.TypeDefinition, net.bytebuddy.asm.Advice$Delegator):void");
                    }

                    public static Resolved.ForMethodExit b(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Delegator delegator, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition) {
                        TypeDescription typeDescription = (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class);
                        if (typeDescription.represents(NoExceptionHandler.class)) {
                            return new WithoutExceptionHandler(inDefinedShape, postProcessor, map, list, typeDefinition, delegator);
                        }
                        return new WithExceptionHandler(inDefinedShape, postProcessor, map, list, typeDefinition, typeDescription, delegator);
                    }

                    private Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2) {
                        ArrayList arrayList = new ArrayList(this.f27034d.size());
                        for (OffsetMapping resolve : this.f27034d.values()) {
                            arrayList.add(resolve.resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.EXIT));
                        }
                        return new AdviceMethodWriter.ForMethodExit(this.f27032b, typeDescription, methodDescription, assigner, this.f27033c, arrayList, methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2, this.f26997g);
                    }

                    public Bound a(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        return doResolve(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod.bindExit(this.f27032b, getThrowable().represents(NoExceptionHandler.class)), forInstrumentedMethod2.bindExit(this.f27032b), forInstrumentedMethod3.bindExit(this.f27032b), this.f27035e.bind(stackManipulation), this.f27036f.bind(methodDescription, relocation));
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.backupArguments == ((ForMethodExit) obj).backupArguments;
                    }

                    public TypeDefinition getAdviceType() {
                        return this.f27032b.getReturnType();
                    }

                    public ArgumentHandler.Factory getArgumentHandlerFactory() {
                        return this.backupArguments ? ArgumentHandler.Factory.COPYING : ArgumentHandler.Factory.SIMPLE;
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + (this.backupArguments ? 1 : 0);
                    }
                }

                public Resolved(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription, TypeDescription typeDescription2, Delegator delegator) {
                    super(inDefinedShape, postProcessor, list, typeDescription, typeDescription2, OffsetMapping.Factory.AdviceType.DELEGATION);
                    this.f26997g = delegator;
                }

                public abstract Bound a(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation);

                public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                    if (this.f27032b.isVisibleTo(typeDescription)) {
                        return a(typeDescription, methodDescription, methodVisitor, context, assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3, stackManipulation, relocation);
                    }
                    throw new IllegalStateException(this.f27032b + " is not visible to " + methodDescription.getDeclaringType());
                }

                public Map<String, TypeDefinition> getNamedTypes() {
                    return Collections.emptyMap();
                }
            }

            public Delegating(MethodDescription.InDefinedShape inDefinedShape, Delegator delegator) {
                this.f26995b = inDefinedShape;
                this.f26996c = delegator;
            }

            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                MethodDescription.InDefinedShape inDefinedShape = this.f26995b;
                return Resolved.ForMethodEnter.b(inDefinedShape, factory.make(inDefinedShape, false), this.f26996c, list, unresolved.getAdviceType(), unresolved.isAlive());
            }

            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                Map<String, TypeDefinition> namedTypes = unresolved.getNamedTypes();
                Class cls = Local.class;
                for (ParameterDescription parameterDescription : (ParameterList) this.f26995b.getParameters().filter(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) cls))) {
                    String str = (String) parameterDescription.getDeclaredAnnotations().ofType(cls).getValue(OffsetMapping.ForLocalValue.Factory.f27048b).resolve(String.class);
                    TypeDefinition typeDefinition = namedTypes.get(str);
                    if (typeDefinition == null) {
                        throw new IllegalStateException(this.f26995b + " attempts use of undeclared local variable " + str);
                    } else if (!typeDefinition.equals(parameterDescription.getType())) {
                        throw new IllegalStateException(this.f26995b + " does not read variable " + str + " as " + typeDefinition);
                    }
                }
                MethodDescription.InDefinedShape inDefinedShape = this.f26995b;
                return Resolved.ForMethodExit.b(inDefinedShape, factory.make(inDefinedShape, true), this.f26996c, namedTypes, list, unresolved.getAdviceType());
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Delegating delegating = (Delegating) obj;
                return this.f26995b.equals(delegating.f26995b) && this.f26996c.equals(delegating.f26996c);
            }

            public Map<String, TypeDefinition> getNamedTypes() {
                return Collections.emptyMap();
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.f26995b.hashCode()) * 31) + this.f26996c.hashCode();
            }

            public boolean isAlive() {
                return true;
            }

            public boolean isBinary() {
                return false;
            }

            public TypeDescription getAdviceType() {
                return this.f26995b.getReturnType().asErasure();
            }
        }

        public enum Inactive implements Unresolved, Resolved.ForMethodEnter, Resolved.ForMethodExit, Bound {
            INSTANCE;

            public void apply() {
            }

            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                return this;
            }

            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                return this;
            }

            public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                return this;
            }

            public ArgumentHandler.Factory getArgumentHandlerFactory() {
                return ArgumentHandler.Factory.SIMPLE;
            }

            public Map<String, TypeDefinition> getNamedTypes() {
                return Collections.emptyMap();
            }

            public TypeDescription getThrowable() {
                return NoExceptionHandler.DESCRIPTION;
            }

            public void initialize() {
            }

            public boolean isAlive() {
                return false;
            }

            public boolean isBinary() {
                return false;
            }

            public boolean isPrependLineNumber() {
                return false;
            }

            public void prepare() {
            }

            public TypeDescription getAdviceType() {
                return TypeDescription.VOID;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Inlining implements Unresolved {

            /* renamed from: b  reason: collision with root package name */
            public final MethodDescription.InDefinedShape f27004b;
            private final Map<String, TypeDefinition> namedTypes = new HashMap();

            public static class CodeTranslationVisitor extends MethodVisitor {
                private final Assigner assigner;

                /* renamed from: d  reason: collision with root package name */
                public final MethodVisitor f27005d;

                /* renamed from: e  reason: collision with root package name */
                public final Implementation.Context f27006e;
                private final boolean exit;

                /* renamed from: f  reason: collision with root package name */
                public final ArgumentHandler.ForAdvice f27007f;

                /* renamed from: g  reason: collision with root package name */
                public final MethodSizeHandler.ForAdvice f27008g;

                /* renamed from: h  reason: collision with root package name */
                public final StackMapFrameHandler.ForAdvice f27009h;

                /* renamed from: i  reason: collision with root package name */
                public final MethodDescription.InDefinedShape f27010i;
                private final MethodDescription instrumentedMethod;
                private final TypeDescription instrumentedType;

                /* renamed from: j  reason: collision with root package name */
                public final Label f27011j = new Label();
                private final Map<Integer, OffsetMapping.Target> offsetMappings;
                private final PostProcessor postProcessor;
                private final RelocationHandler.Bound relocationHandler;
                private final SuppressionHandler.Bound suppressionHandler;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public CodeTranslationVisitor(MethodVisitor methodVisitor, Implementation.Context context, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner2, MethodDescription.InDefinedShape inDefinedShape, Map<Integer, OffsetMapping.Target> map, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, PostProcessor postProcessor2, boolean z11) {
                    super(OpenedClassReader.ASM_API, new StackAwareMethodVisitor(methodVisitor, methodDescription));
                    this.f27005d = methodVisitor;
                    this.f27006e = context;
                    this.f27007f = forAdvice;
                    this.f27008g = forAdvice2;
                    this.f27009h = forAdvice3;
                    this.instrumentedType = typeDescription;
                    this.instrumentedMethod = methodDescription;
                    this.assigner = assigner2;
                    this.f27010i = inDefinedShape;
                    this.offsetMappings = map;
                    this.suppressionHandler = bound;
                    this.relocationHandler = bound2;
                    this.postProcessor = postProcessor2;
                    this.exit = z11;
                }

                public void a(Label label) {
                    ((StackAwareMethodVisitor) this.f27400c).register(label, Collections.singletonList(StackSize.SINGLE));
                }

                public void visitAnnotableParameterCount(int i11, boolean z11) {
                }

                public AnnotationVisitor visitAnnotation(String str, boolean z11) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                public AnnotationVisitor visitAnnotationDefault() {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                public void visitAttribute(Attribute attribute) {
                }

                public void visitCode() {
                    this.suppressionHandler.onStart(this.f27005d);
                }

                public void visitEnd() {
                    int i11;
                    int i12;
                    int i13;
                    int i14;
                    int i15;
                    int i16;
                    this.suppressionHandler.onEnd(this.f27005d, this.f27006e, this.f27008g, this.f27009h, this.f27010i.getReturnType());
                    this.f27005d.visitLabel(this.f27011j);
                    if (this.f27010i.getReturnType().represents(Boolean.TYPE) || this.f27010i.getReturnType().represents(Byte.TYPE) || this.f27010i.getReturnType().represents(Short.TYPE) || this.f27010i.getReturnType().represents(Character.TYPE) || this.f27010i.getReturnType().represents(Integer.TYPE)) {
                        this.f27009h.injectReturnFrame(this.f27005d);
                        MethodVisitor methodVisitor = this.f27005d;
                        if (this.exit) {
                            i12 = this.f27007f.exit();
                        } else {
                            i12 = this.f27007f.enter();
                        }
                        methodVisitor.visitVarInsn(54, i12);
                    } else if (this.f27010i.getReturnType().represents(Long.TYPE)) {
                        this.f27009h.injectReturnFrame(this.f27005d);
                        MethodVisitor methodVisitor2 = this.f27005d;
                        if (this.exit) {
                            i16 = this.f27007f.exit();
                        } else {
                            i16 = this.f27007f.enter();
                        }
                        methodVisitor2.visitVarInsn(55, i16);
                    } else if (this.f27010i.getReturnType().represents(Float.TYPE)) {
                        this.f27009h.injectReturnFrame(this.f27005d);
                        MethodVisitor methodVisitor3 = this.f27005d;
                        if (this.exit) {
                            i15 = this.f27007f.exit();
                        } else {
                            i15 = this.f27007f.enter();
                        }
                        methodVisitor3.visitVarInsn(56, i15);
                    } else if (this.f27010i.getReturnType().represents(Double.TYPE)) {
                        this.f27009h.injectReturnFrame(this.f27005d);
                        MethodVisitor methodVisitor4 = this.f27005d;
                        if (this.exit) {
                            i14 = this.f27007f.exit();
                        } else {
                            i14 = this.f27007f.enter();
                        }
                        methodVisitor4.visitVarInsn(57, i14);
                    } else if (!this.f27010i.getReturnType().represents(Void.TYPE)) {
                        this.f27009h.injectReturnFrame(this.f27005d);
                        MethodVisitor methodVisitor5 = this.f27005d;
                        if (this.exit) {
                            i13 = this.f27007f.exit();
                        } else {
                            i13 = this.f27007f.enter();
                        }
                        methodVisitor5.visitVarInsn(58, i13);
                    }
                    this.f27008g.requireStackSize(this.postProcessor.resolve(this.instrumentedType, this.instrumentedMethod, this.assigner, this.f27007f).apply(this.f27005d, this.f27006e).getMaximalSize());
                    MethodSizeHandler.ForAdvice forAdvice = this.f27008g;
                    RelocationHandler.Bound bound = this.relocationHandler;
                    MethodVisitor methodVisitor6 = this.f27005d;
                    if (this.exit) {
                        i11 = this.f27007f.exit();
                    } else {
                        i11 = this.f27007f.enter();
                    }
                    forAdvice.requireStackSize(bound.apply(methodVisitor6, i11));
                    this.f27009h.injectCompletionFrame(this.f27005d);
                }

                public void visitFrame(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
                    this.f27009h.translateFrame(this.f27005d, i11, i12, objArr, i13, objArr2);
                }

                public void visitIincInsn(int i11, int i12) {
                    OffsetMapping.Target target = this.offsetMappings.get(Integer.valueOf(i11));
                    if (target != null) {
                        this.f27008g.requireStackSizePadding(target.resolveIncrement(i12).apply(this.f27400c, this.f27006e).getMaximalSize());
                    } else {
                        this.f27400c.visitIincInsn(this.f27007f.mapped(i11), i12);
                    }
                }

                public void visitInsn(int i11) {
                    switch (i11) {
                        case 172:
                            this.f27008g.requireLocalVariableLength(((StackAwareMethodVisitor) this.f27400c).drainStack(54, 21, StackSize.SINGLE));
                            break;
                        case Opcodes.LRETURN:
                            this.f27008g.requireLocalVariableLength(((StackAwareMethodVisitor) this.f27400c).drainStack(55, 22, StackSize.DOUBLE));
                            break;
                        case Opcodes.FRETURN:
                            this.f27008g.requireLocalVariableLength(((StackAwareMethodVisitor) this.f27400c).drainStack(56, 23, StackSize.SINGLE));
                            break;
                        case Opcodes.DRETURN:
                            this.f27008g.requireLocalVariableLength(((StackAwareMethodVisitor) this.f27400c).drainStack(57, 24, StackSize.DOUBLE));
                            break;
                        case Opcodes.ARETURN:
                            this.f27008g.requireLocalVariableLength(((StackAwareMethodVisitor) this.f27400c).drainStack(58, 25, StackSize.SINGLE));
                            break;
                        case Opcodes.RETURN:
                            ((StackAwareMethodVisitor) this.f27400c).drainStack();
                            break;
                        default:
                            this.f27400c.visitInsn(i11);
                            return;
                    }
                    this.f27400c.visitJumpInsn(Opcodes.GOTO, this.f27011j);
                }

                public void visitMaxs(int i11, int i12) {
                    this.f27008g.recordMaxima(i11, i12);
                }

                public void visitParameter(String str, int i11) {
                }

                public AnnotationVisitor visitParameterAnnotation(int i11, String str, boolean z11) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                public void visitVarInsn(int i11, int i12) {
                    StackSize stackSize;
                    StackManipulation stackManipulation;
                    OffsetMapping.Target target = this.offsetMappings.get(Integer.valueOf(i12));
                    if (target != null) {
                        switch (i11) {
                            case 21:
                            case 23:
                            case 25:
                                stackManipulation = target.resolveRead();
                                stackSize = StackSize.SINGLE;
                                break;
                            case 22:
                            case 24:
                                stackManipulation = target.resolveRead();
                                stackSize = StackSize.DOUBLE;
                                break;
                            default:
                                switch (i11) {
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57:
                                    case 58:
                                        stackManipulation = target.resolveWrite();
                                        stackSize = StackSize.ZERO;
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected opcode: " + i11);
                                }
                        }
                        this.f27008g.requireStackSizePadding(stackManipulation.apply(this.f27400c, this.f27006e).getMaximalSize() - stackSize.getSize());
                        return;
                    }
                    this.f27400c.visitVarInsn(i11, this.f27007f.mapped(i12));
                }
            }

            public static abstract class Resolved extends Resolved.AbstractBase {

                /* renamed from: g  reason: collision with root package name */
                public final ClassReader f27012g;

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodEnter extends Resolved implements Resolved.ForMethodEnter {
                    private final Map<String, TypeDefinition> namedTypes;
                    private final boolean prependLineNumber;

                    public static class WithDiscardedEnterType extends ForMethodEnter {
                        public WithDiscardedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, ClassReader classReader) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, classReader);
                        }

                        public MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2) {
                            forAdvice2.requireLocalVariableLengthPadding(this.f27032b.getReturnType().getStackSize().getSize());
                            return super.doApply(methodVisitor, context, assigner, forAdvice, forAdvice2, forAdvice3, typeDescription, methodDescription, bound, bound2);
                        }

                        public TypeDefinition getAdviceType() {
                            return TypeDescription.VOID;
                        }
                    }

                    public static class WithRetainedEnterType extends ForMethodEnter {
                        public WithRetainedEnterType(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, ClassReader classReader) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, classReader);
                        }

                        public TypeDefinition getAdviceType() {
                            return this.f27032b.getReturnType();
                        }
                    }

                    /* JADX WARNING: Illegal instructions before constructor call */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public ForMethodEnter(net.bytebuddy.description.method.MethodDescription.InDefinedShape r8, net.bytebuddy.asm.Advice.PostProcessor r9, java.util.Map<java.lang.String, net.bytebuddy.description.type.TypeDefinition> r10, java.util.List<? extends net.bytebuddy.asm.Advice.OffsetMapping.Factory<?>> r11, net.bytebuddy.description.type.TypeDefinition r12, net.bytebuddy.jar.asm.ClassReader r13) {
                        /*
                            r7 = this;
                            r0 = 13
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory[] r0 = new net.bytebuddy.asm.Advice.OffsetMapping.Factory[r0]
                            r1 = 0
                            net.bytebuddy.asm.Advice$OffsetMapping$ForArgument$Unresolved$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForAllArguments$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 2
                            net.bytebuddy.asm.Advice$OffsetMapping$ForThisReference$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 3
                            net.bytebuddy.asm.Advice$OffsetMapping$ForField$Unresolved$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 4
                            net.bytebuddy.asm.Advice$OffsetMapping$ForOrigin$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 5
                            net.bytebuddy.asm.Advice$OffsetMapping$ForUnusedValue$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 6
                            net.bytebuddy.asm.Advice$OffsetMapping$ForStubValue r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForStubValue.INSTANCE
                            r0[r1] = r2
                            r1 = 7
                            net.bytebuddy.asm.Advice$OffsetMapping$ForThrowable$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForThrowable.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 8
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r12 = net.bytebuddy.asm.Advice.OffsetMapping.ForExitValue.Factory.c(r12)
                            r0[r1] = r12
                            net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory r12 = new net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory
                            r12.<init>(r10)
                            r1 = 9
                            r0[r1] = r12
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r12 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Thrown> r1 = net.bytebuddy.asm.Advice.Thrown.class
                            r12.<init>(r1)
                            r1 = 10
                            r0[r1] = r12
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r12 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Enter> r1 = net.bytebuddy.asm.Advice.Enter.class
                            r12.<init>(r1)
                            r1 = 11
                            r0[r1] = r12
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal r12 = new net.bytebuddy.asm.Advice$OffsetMapping$Factory$Illegal
                            java.lang.Class<net.bytebuddy.asm.Advice$Return> r1 = net.bytebuddy.asm.Advice.Return.class
                            r12.<init>(r1)
                            r1 = 12
                            r0[r1] = r12
                            java.util.List r12 = java.util.Arrays.asList(r0)
                            java.util.List r3 = net.bytebuddy.utility.CompoundList.of(r12, r11)
                            net.bytebuddy.description.annotation.AnnotationList r11 = r8.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodEnter> r12 = net.bytebuddy.asm.Advice.OnMethodEnter.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.SUPPRESS_ENTER
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r0 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r11 = r11.resolve(r0)
                            r4 = r11
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            net.bytebuddy.description.annotation.AnnotationList r11 = r8.getDeclaredAnnotations()
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r11 = r11.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.SKIP_ON
                            net.bytebuddy.description.annotation.AnnotationValue r11 = r11.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                            java.lang.Object r11 = r11.resolve(r0)
                            r5 = r11
                            net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5
                            r0 = r7
                            r1 = r8
                            r2 = r9
                            r6 = r13
                            r0.<init>(r1, r2, r3, r4, r5, r6)
                            r7.namedTypes = r10
                            net.bytebuddy.description.annotation.AnnotationList r8 = r8.getDeclaredAnnotations()
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r8 = r8.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r9 = net.bytebuddy.asm.Advice.PREPEND_LINE_NUMBER
                            net.bytebuddy.description.annotation.AnnotationValue r8 = r8.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r9)
                            java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
                            java.lang.Object r8 = r8.resolve(r9)
                            java.lang.Boolean r8 = (java.lang.Boolean) r8
                            boolean r8 = r8.booleanValue()
                            r7.prependLineNumber = r8
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved.ForMethodEnter.<init>(net.bytebuddy.description.method.MethodDescription$InDefinedShape, net.bytebuddy.asm.Advice$PostProcessor, java.util.Map, java.util.List, net.bytebuddy.description.type.TypeDefinition, net.bytebuddy.jar.asm.ClassReader):void");
                    }

                    public static Resolved.ForMethodEnter c(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, ClassReader classReader, boolean z11) {
                        return z11 ? new WithRetainedEnterType(inDefinedShape, postProcessor, map, list, typeDefinition, classReader) : new WithDiscardedEnterType(inDefinedShape, postProcessor, map, list, typeDefinition, classReader);
                    }

                    public MethodVisitor a(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2) {
                        return doApply(methodVisitor, context, assigner, forInstrumentedMethod.bindEnter(this.f27032b), forInstrumentedMethod2.bindEnter(this.f27032b), forInstrumentedMethod3.bindEnter(this.f27032b), typeDescription, methodDescription, bound, bound2);
                    }

                    public Map<Integer, TypeDefinition> b(ArgumentHandler argumentHandler) {
                        TreeMap treeMap = new TreeMap();
                        for (Map.Entry next : this.namedTypes.entrySet()) {
                            treeMap.put(Integer.valueOf(argumentHandler.named((String) next.getKey())), next.getValue());
                        }
                        return treeMap;
                    }

                    public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        MethodDescription methodDescription2 = methodDescription;
                        return new AdviceMethodInliner(typeDescription, methodDescription2, methodVisitor, context, assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3, this.f27035e.bind(stackManipulation), this.f27036f.bind(methodDescription2, relocation), this.f27012g);
                    }

                    public MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2) {
                        HashMap hashMap = new HashMap();
                        for (Map.Entry next : this.f27034d.entrySet()) {
                            hashMap.put(next.getKey(), ((OffsetMapping) next.getValue()).resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.ENTER));
                        }
                        return new CodeTranslationVisitor(methodVisitor, context, forAdvice, forAdvice2, forAdvice3, typeDescription, methodDescription, assigner, this.f27032b, hashMap, bound, bound2, this.f27033c, false);
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMethodEnter forMethodEnter = (ForMethodEnter) obj;
                        return this.prependLineNumber == forMethodEnter.prependLineNumber && this.namedTypes.equals(forMethodEnter.namedTypes);
                    }

                    public Map<String, TypeDefinition> getNamedTypes() {
                        return this.namedTypes;
                    }

                    public int hashCode() {
                        return (((super.hashCode() * 31) + this.namedTypes.hashCode()) * 31) + (this.prependLineNumber ? 1 : 0);
                    }

                    public boolean isPrependLineNumber() {
                        return this.prependLineNumber;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodExit extends Resolved implements Resolved.ForMethodExit {
                    private final boolean backupArguments;
                    private final Map<String, TypeDefinition> uninitializedNamedTypes;

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class WithExceptionHandler extends ForMethodExit {
                        private final TypeDescription throwable;

                        public WithExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, TypeDefinition typeDefinition, TypeDescription typeDescription) {
                            super(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition);
                            this.throwable = typeDescription;
                        }

                        public boolean equals(Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.throwable.equals(((WithExceptionHandler) obj).throwable);
                        }

                        public TypeDescription getThrowable() {
                            return this.throwable;
                        }

                        public int hashCode() {
                            return (super.hashCode() * 31) + this.throwable.hashCode();
                        }
                    }

                    public static class WithoutExceptionHandler extends ForMethodExit {
                        public WithoutExceptionHandler(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, TypeDefinition typeDefinition) {
                            super(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition);
                        }

                        public TypeDescription getThrowable() {
                            return NoExceptionHandler.DESCRIPTION;
                        }
                    }

                    /* JADX WARNING: Illegal instructions before constructor call */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public ForMethodExit(net.bytebuddy.description.method.MethodDescription.InDefinedShape r8, net.bytebuddy.asm.Advice.PostProcessor r9, java.util.Map<java.lang.String, net.bytebuddy.description.type.TypeDefinition> r10, java.util.Map<java.lang.String, net.bytebuddy.description.type.TypeDefinition> r11, java.util.List<? extends net.bytebuddy.asm.Advice.OffsetMapping.Factory<?>> r12, net.bytebuddy.jar.asm.ClassReader r13, net.bytebuddy.description.type.TypeDefinition r14) {
                        /*
                            r7 = this;
                            r0 = 12
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory[] r0 = new net.bytebuddy.asm.Advice.OffsetMapping.Factory[r0]
                            r1 = 0
                            net.bytebuddy.asm.Advice$OffsetMapping$ForArgument$Unresolved$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 1
                            net.bytebuddy.asm.Advice$OffsetMapping$ForAllArguments$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 2
                            net.bytebuddy.asm.Advice$OffsetMapping$ForThisReference$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 3
                            net.bytebuddy.asm.Advice$OffsetMapping$ForField$Unresolved$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 4
                            net.bytebuddy.asm.Advice$OffsetMapping$ForOrigin$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 5
                            net.bytebuddy.asm.Advice$OffsetMapping$ForUnusedValue$Factory r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForUnusedValue.Factory.INSTANCE
                            r0[r1] = r2
                            r1 = 6
                            net.bytebuddy.asm.Advice$OffsetMapping$ForStubValue r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForStubValue.INSTANCE
                            r0[r1] = r2
                            r1 = 7
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r14 = net.bytebuddy.asm.Advice.OffsetMapping.ForEnterValue.Factory.c(r14)
                            r0[r1] = r14
                            net.bytebuddy.description.type.TypeDescription$Generic r14 = r8.getReturnType()
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r14 = net.bytebuddy.asm.Advice.OffsetMapping.ForExitValue.Factory.c(r14)
                            r1 = 8
                            r0[r1] = r14
                            net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory r14 = new net.bytebuddy.asm.Advice$OffsetMapping$ForLocalValue$Factory
                            r14.<init>(r10)
                            r10 = 9
                            r0[r10] = r14
                            r10 = 10
                            net.bytebuddy.asm.Advice$OffsetMapping$ForReturnValue$Factory r14 = net.bytebuddy.asm.Advice.OffsetMapping.ForReturnValue.Factory.INSTANCE
                            r0[r10] = r14
                            r10 = 11
                            net.bytebuddy.asm.Advice$OffsetMapping$Factory r14 = net.bytebuddy.asm.Advice.OffsetMapping.ForThrowable.Factory.c(r8)
                            r0[r10] = r14
                            java.util.List r10 = java.util.Arrays.asList(r0)
                            java.util.List r3 = net.bytebuddy.utility.CompoundList.of(r10, r12)
                            net.bytebuddy.description.annotation.AnnotationList r10 = r8.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.asm.Advice$OnMethodExit> r12 = net.bytebuddy.asm.Advice.OnMethodExit.class
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r10 = r10.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r14 = net.bytebuddy.asm.Advice.SUPPRESS_EXIT
                            net.bytebuddy.description.annotation.AnnotationValue r10 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r14)
                            java.lang.Class<net.bytebuddy.description.type.TypeDescription> r14 = net.bytebuddy.description.type.TypeDescription.class
                            java.lang.Object r10 = r10.resolve(r14)
                            r4 = r10
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            net.bytebuddy.description.annotation.AnnotationList r10 = r8.getDeclaredAnnotations()
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r10 = r10.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.REPEAT_ON
                            net.bytebuddy.description.annotation.AnnotationValue r10 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                            java.lang.Object r10 = r10.resolve(r14)
                            r5 = r10
                            net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5
                            r0 = r7
                            r1 = r8
                            r2 = r9
                            r6 = r13
                            r0.<init>(r1, r2, r3, r4, r5, r6)
                            r7.uninitializedNamedTypes = r11
                            net.bytebuddy.description.annotation.AnnotationList r8 = r8.getDeclaredAnnotations()
                            net.bytebuddy.description.annotation.AnnotationDescription$Loadable r8 = r8.ofType(r12)
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r9 = net.bytebuddy.asm.Advice.BACKUP_ARGUMENTS
                            net.bytebuddy.description.annotation.AnnotationValue r8 = r8.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r9)
                            java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
                            java.lang.Object r8 = r8.resolve(r9)
                            java.lang.Boolean r8 = (java.lang.Boolean) r8
                            boolean r8 = r8.booleanValue()
                            r7.backupArguments = r8
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved.ForMethodExit.<init>(net.bytebuddy.description.method.MethodDescription$InDefinedShape, net.bytebuddy.asm.Advice$PostProcessor, java.util.Map, java.util.Map, java.util.List, net.bytebuddy.jar.asm.ClassReader, net.bytebuddy.description.type.TypeDefinition):void");
                    }

                    public static Resolved.ForMethodExit c(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, TypeDefinition typeDefinition) {
                        TypeDescription typeDescription = (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class);
                        if (typeDescription.represents(NoExceptionHandler.class)) {
                            return new WithoutExceptionHandler(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition);
                        }
                        return new WithExceptionHandler(inDefinedShape, postProcessor, map, map2, list, classReader, typeDefinition, typeDescription);
                    }

                    private MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2) {
                        HashMap hashMap = new HashMap();
                        for (Map.Entry next : this.f27034d.entrySet()) {
                            hashMap.put(next.getKey(), ((OffsetMapping) next.getValue()).resolve(typeDescription, methodDescription, assigner, forAdvice, OffsetMapping.Sort.EXIT));
                        }
                        return new CodeTranslationVisitor(methodVisitor, context, forAdvice, forAdvice2, forAdvice3, typeDescription, methodDescription, assigner, this.f27032b, hashMap, bound, bound2, this.f27033c, true);
                    }

                    public MethodVisitor a(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2) {
                        return doApply(methodVisitor, context, assigner, forInstrumentedMethod.bindExit(this.f27032b, getThrowable().represents(NoExceptionHandler.class)), forInstrumentedMethod2.bindExit(this.f27032b), forInstrumentedMethod3.bindExit(this.f27032b), typeDescription, methodDescription, bound, bound2);
                    }

                    public Map<Integer, TypeDefinition> b(ArgumentHandler argumentHandler) {
                        TreeMap treeMap = new TreeMap();
                        for (Map.Entry next : this.uninitializedNamedTypes.entrySet()) {
                            treeMap.put(Integer.valueOf(argumentHandler.named((String) next.getKey())), next.getValue());
                        }
                        if (!this.f27032b.getReturnType().represents(Void.TYPE)) {
                            treeMap.put(Integer.valueOf(argumentHandler.exit()), this.f27032b.getReturnType());
                        }
                        return treeMap;
                    }

                    public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        MethodDescription methodDescription2 = methodDescription;
                        return new AdviceMethodInliner(typeDescription, methodDescription2, methodVisitor, context, assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3, this.f27035e.bind(stackManipulation), this.f27036f.bind(methodDescription2, relocation), this.f27012g);
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMethodExit forMethodExit = (ForMethodExit) obj;
                        return this.backupArguments == forMethodExit.backupArguments && this.uninitializedNamedTypes.equals(forMethodExit.uninitializedNamedTypes);
                    }

                    public TypeDefinition getAdviceType() {
                        return this.f27032b.getReturnType();
                    }

                    public ArgumentHandler.Factory getArgumentHandlerFactory() {
                        return this.backupArguments ? ArgumentHandler.Factory.COPYING : ArgumentHandler.Factory.SIMPLE;
                    }

                    public Map<String, TypeDefinition> getNamedTypes() {
                        return this.uninitializedNamedTypes;
                    }

                    public int hashCode() {
                        return (((super.hashCode() * 31) + this.uninitializedNamedTypes.hashCode()) * 31) + (this.backupArguments ? 1 : 0);
                    }
                }

                public Resolved(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription, TypeDescription typeDescription2, ClassReader classReader) {
                    super(inDefinedShape, postProcessor, list, typeDescription, typeDescription2, OffsetMapping.Factory.AdviceType.INLINING);
                    this.f27012g = classReader;
                }

                public abstract MethodVisitor a(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, TypeDescription typeDescription, MethodDescription methodDescription, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2);

                public abstract Map<Integer, TypeDefinition> b(ArgumentHandler argumentHandler);

                public class AdviceMethodInliner extends ClassVisitor implements Bound {

                    /* renamed from: d  reason: collision with root package name */
                    public final TypeDescription f27013d;

                    /* renamed from: e  reason: collision with root package name */
                    public final MethodDescription f27014e;

                    /* renamed from: f  reason: collision with root package name */
                    public final MethodVisitor f27015f;

                    /* renamed from: g  reason: collision with root package name */
                    public final Implementation.Context f27016g;

                    /* renamed from: h  reason: collision with root package name */
                    public final Assigner f27017h;

                    /* renamed from: i  reason: collision with root package name */
                    public final ArgumentHandler.ForInstrumentedMethod f27018i;

                    /* renamed from: j  reason: collision with root package name */
                    public final MethodSizeHandler.ForInstrumentedMethod f27019j;

                    /* renamed from: k  reason: collision with root package name */
                    public final StackMapFrameHandler.ForInstrumentedMethod f27020k;

                    /* renamed from: l  reason: collision with root package name */
                    public final SuppressionHandler.Bound f27021l;

                    /* renamed from: m  reason: collision with root package name */
                    public final RelocationHandler.Bound f27022m;

                    /* renamed from: n  reason: collision with root package name */
                    public final ClassReader f27023n;

                    /* renamed from: o  reason: collision with root package name */
                    public final List<Label> f27024o = new ArrayList();

                    public class ExceptionTableCollector extends MethodVisitor {
                        private final MethodVisitor methodVisitor;

                        public ExceptionTableCollector(MethodVisitor methodVisitor2) {
                            super(OpenedClassReader.ASM_API);
                            this.methodVisitor = methodVisitor2;
                        }

                        public AnnotationVisitor visitTryCatchAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                            return this.methodVisitor.visitTryCatchAnnotation(i11, typePath, str, z11);
                        }

                        public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
                            this.methodVisitor.visitTryCatchBlock(label, label2, label3, str);
                            AdviceMethodInliner.this.f27024o.addAll(Arrays.asList(new Label[]{label, label2, label3}));
                        }
                    }

                    public class ExceptionTableExtractor extends ClassVisitor {
                        public ExceptionTableExtractor() {
                            super(OpenedClassReader.ASM_API);
                        }

                        public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
                            if (!Resolved.this.f27032b.getInternalName().equals(str) || !Resolved.this.f27032b.getDescriptor().equals(str2)) {
                                return Dispatcher.IGNORE_METHOD;
                            }
                            AdviceMethodInliner adviceMethodInliner = AdviceMethodInliner.this;
                            return new ExceptionTableCollector(adviceMethodInliner.f27015f);
                        }
                    }

                    public AdviceMethodInliner(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, SuppressionHandler.Bound bound, RelocationHandler.Bound bound2, ClassReader classReader) {
                        super(OpenedClassReader.ASM_API);
                        this.f27013d = typeDescription;
                        this.f27014e = methodDescription;
                        this.f27015f = methodVisitor;
                        this.f27016g = context;
                        this.f27017h = assigner;
                        this.f27018i = forInstrumentedMethod;
                        this.f27019j = forInstrumentedMethod2;
                        this.f27020k = forInstrumentedMethod3;
                        this.f27021l = bound;
                        this.f27023n = classReader;
                        this.f27022m = bound2;
                    }

                    public void apply() {
                        this.f27023n.accept(this, this.f27020k.getReaderHint() | 2);
                    }

                    public void initialize() {
                        for (Map.Entry next : Resolved.this.b(this.f27018i).entrySet()) {
                            if (((TypeDefinition) next.getValue()).represents(Boolean.TYPE) || ((TypeDefinition) next.getValue()).represents(Byte.TYPE) || ((TypeDefinition) next.getValue()).represents(Short.TYPE) || ((TypeDefinition) next.getValue()).represents(Character.TYPE) || ((TypeDefinition) next.getValue()).represents(Integer.TYPE)) {
                                this.f27015f.visitInsn(3);
                                this.f27015f.visitVarInsn(54, ((Integer) next.getKey()).intValue());
                            } else if (((TypeDefinition) next.getValue()).represents(Long.TYPE)) {
                                this.f27015f.visitInsn(9);
                                this.f27015f.visitVarInsn(55, ((Integer) next.getKey()).intValue());
                            } else if (((TypeDefinition) next.getValue()).represents(Float.TYPE)) {
                                this.f27015f.visitInsn(11);
                                this.f27015f.visitVarInsn(56, ((Integer) next.getKey()).intValue());
                            } else if (((TypeDefinition) next.getValue()).represents(Double.TYPE)) {
                                this.f27015f.visitInsn(14);
                                this.f27015f.visitVarInsn(57, ((Integer) next.getKey()).intValue());
                            } else {
                                this.f27015f.visitInsn(1);
                                this.f27015f.visitVarInsn(58, ((Integer) next.getKey()).intValue());
                            }
                            this.f27019j.requireStackSize(((TypeDefinition) next.getValue()).getStackSize().getSize());
                        }
                    }

                    public void prepare() {
                        this.f27023n.accept(new ExceptionTableExtractor(), 6);
                        this.f27021l.onPrepare(this.f27015f);
                    }

                    public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
                        String str4 = str;
                        if (!Resolved.this.f27032b.getInternalName().equals(str) || !Resolved.this.f27032b.getDescriptor().equals(str2)) {
                            return Dispatcher.IGNORE_METHOD;
                        }
                        return new ExceptionTableSubstitutor(Resolved.this.a(this.f27015f, this.f27016g, this.f27017h, this.f27018i, this.f27019j, this.f27020k, this.f27013d, this.f27014e, this.f27021l, this.f27022m));
                    }

                    public class ExceptionTableSubstitutor extends MethodVisitor {
                        private int index;
                        private final Map<Label, Label> substitutions = new IdentityHashMap();

                        public ExceptionTableSubstitutor(MethodVisitor methodVisitor) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                        }

                        private Label[] resolve(Label[] labelArr) {
                            Label[] labelArr2 = new Label[labelArr.length];
                            int length = labelArr.length;
                            int i11 = 0;
                            int i12 = 0;
                            while (i11 < length) {
                                labelArr2[i12] = resolve(labelArr[i11]);
                                i11++;
                                i12++;
                            }
                            return labelArr2;
                        }

                        public void visitJumpInsn(int i11, Label label) {
                            super.visitJumpInsn(i11, resolve(label));
                        }

                        public void visitLabel(Label label) {
                            super.visitLabel(resolve(label));
                        }

                        public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
                            super.visitLookupSwitchInsn(resolve(label), iArr, resolve(labelArr));
                        }

                        public void visitTableSwitchInsn(int i11, int i12, Label label, Label... labelArr) {
                            super.visitTableSwitchInsn(i11, i12, label, resolve(labelArr));
                        }

                        public AnnotationVisitor visitTryCatchAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                            return Dispatcher.IGNORE_ANNOTATION;
                        }

                        public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
                            Map<Label, Label> map = this.substitutions;
                            List<Label> list = AdviceMethodInliner.this.f27024o;
                            int i11 = this.index;
                            this.index = i11 + 1;
                            map.put(label, list.get(i11));
                            Map<Label, Label> map2 = this.substitutions;
                            List<Label> list2 = AdviceMethodInliner.this.f27024o;
                            int i12 = this.index;
                            this.index = i12 + 1;
                            map2.put(label2, list2.get(i12));
                            List<Label> list3 = AdviceMethodInliner.this.f27024o;
                            int i13 = this.index;
                            this.index = i13 + 1;
                            Label label4 = list3.get(i13);
                            this.substitutions.put(label3, label4);
                            ((CodeTranslationVisitor) this.f27400c).a(label4);
                        }

                        private Label resolve(Label label) {
                            Label label2 = this.substitutions.get(label);
                            return label2 == null ? label : label2;
                        }
                    }
                }
            }

            public Inlining(MethodDescription.InDefinedShape inDefinedShape) {
                this.f27004b = inDefinedShape;
                Class cls = Local.class;
                for (ParameterDescription parameterDescription : (ParameterList) inDefinedShape.getParameters().filter(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) cls))) {
                    String str = (String) parameterDescription.getDeclaredAnnotations().ofType(cls).getValue(OffsetMapping.ForLocalValue.Factory.f27048b).resolve(String.class);
                    TypeDefinition put = this.namedTypes.put(str, parameterDescription.getType());
                    if (put != null && !put.equals(parameterDescription.getType())) {
                        throw new IllegalStateException("Local variable for " + str + " is defined with inconsistent types");
                    }
                }
            }

            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                MethodDescription.InDefinedShape inDefinedShape = this.f27004b;
                return Resolved.ForMethodEnter.c(inDefinedShape, factory.make(inDefinedShape, false), this.namedTypes, list, unresolved.getAdviceType(), classReader, unresolved.isAlive());
            }

            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory) {
                HashMap hashMap = new HashMap(unresolved.getNamedTypes());
                HashMap hashMap2 = new HashMap();
                for (Map.Entry next : this.namedTypes.entrySet()) {
                    TypeDefinition typeDefinition = (TypeDefinition) hashMap.get(next.getKey());
                    TypeDefinition typeDefinition2 = (TypeDefinition) hashMap2.get(next.getKey());
                    if (typeDefinition == null && typeDefinition2 == null) {
                        hashMap.put(next.getKey(), next.getValue());
                        hashMap2.put(next.getKey(), next.getValue());
                    } else {
                        if (typeDefinition == null) {
                            typeDefinition = typeDefinition2;
                        }
                        if (!typeDefinition.equals(next.getValue())) {
                            throw new IllegalStateException("Local variable for " + ((String) next.getKey()) + " is defined with inconsistent types");
                        }
                    }
                }
                MethodDescription.InDefinedShape inDefinedShape = this.f27004b;
                return Resolved.ForMethodExit.c(inDefinedShape, factory.make(inDefinedShape, true), hashMap, hashMap2, list, classReader, unresolved.getAdviceType());
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Inlining inlining = (Inlining) obj;
                return this.f27004b.equals(inlining.f27004b) && this.namedTypes.equals(inlining.namedTypes);
            }

            public Map<String, TypeDefinition> getNamedTypes() {
                return this.namedTypes;
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.f27004b.hashCode()) * 31) + this.namedTypes.hashCode();
            }

            public boolean isAlive() {
                return true;
            }

            public boolean isBinary() {
                return true;
            }

            public TypeDescription getAdviceType() {
                return this.f27004b.getReturnType().asErasure();
            }
        }

        public interface RelocationHandler {

            public interface Bound {
                public static final int NO_REQUIRED_SIZE = 0;

                int apply(MethodVisitor methodVisitor, int i11);
            }

            public enum Disabled implements RelocationHandler, Bound {
                INSTANCE;

                public int apply(MethodVisitor methodVisitor, int i11) {
                    return 0;
                }

                public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                    return this;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForType implements RelocationHandler {
                /* access modifiers changed from: private */
                public final TypeDescription typeDescription;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class Bound implements Bound {
                    private final MethodDescription instrumentedMethod;
                    private final Relocation relocation;

                    public Bound(MethodDescription methodDescription, Relocation relocation2) {
                        this.instrumentedMethod = methodDescription;
                        this.relocation = relocation2;
                    }

                    public int apply(MethodVisitor methodVisitor, int i11) {
                        if (!this.instrumentedMethod.isConstructor()) {
                            methodVisitor.visitVarInsn(25, i11);
                            methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, ForType.this.typeDescription.getInternalName());
                            Label label = new Label();
                            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
                            this.relocation.apply(methodVisitor);
                            methodVisitor.visitLabel(label);
                            return 0;
                        }
                        throw new IllegalStateException("Cannot skip code execution from constructor: " + this.instrumentedMethod);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Bound bound = (Bound) obj;
                        return this.instrumentedMethod.equals(bound.instrumentedMethod) && this.relocation.equals(bound.relocation) && ForType.this.equals(ForType.this);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.instrumentedMethod.hashCode()) * 31) + this.relocation.hashCode()) * 31) + ForType.this.hashCode();
                    }
                }

                public ForType(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public static RelocationHandler b(TypeDescription typeDescription2, TypeDefinition typeDefinition) {
                    if (typeDescription2.represents(Void.TYPE)) {
                        return Disabled.INSTANCE;
                    }
                    if (typeDescription2.represents(OnDefaultValue.class)) {
                        return ForValue.f(typeDefinition, false);
                    }
                    if (typeDescription2.represents(OnNonDefaultValue.class)) {
                        return ForValue.f(typeDefinition, true);
                    }
                    if (!typeDescription2.isPrimitive() && !typeDefinition.isPrimitive()) {
                        return new ForType(typeDescription2);
                    }
                    throw new IllegalStateException("Cannot skip method by instance type for primitive return type " + typeDefinition);
                }

                public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                    return new Bound(methodDescription, relocation);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForType) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }
            }

            public enum ForValue implements RelocationHandler {
                INTEGER(21, Opcodes.IFNE, Opcodes.IFEQ, 0) {
                    public void e(MethodVisitor methodVisitor) {
                    }
                },
                LONG(22, Opcodes.IFNE, Opcodes.IFEQ, 0) {
                    public void e(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(Opcodes.L2I);
                    }
                },
                FLOAT(23, Opcodes.IFNE, Opcodes.IFEQ, 2) {
                    public void e(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(11);
                        methodVisitor.visitInsn(Opcodes.FCMPL);
                    }
                },
                DOUBLE(24, Opcodes.IFNE, Opcodes.IFEQ, 4) {
                    public void e(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(14);
                        methodVisitor.visitInsn(Opcodes.DCMPL);
                    }
                },
                REFERENCE(25, Opcodes.IFNONNULL, Opcodes.IFNULL, 0) {
                    public void e(MethodVisitor methodVisitor) {
                    }
                };
                
                /* access modifiers changed from: private */
                public final int defaultJump;
                /* access modifiers changed from: private */
                public final int load;
                /* access modifiers changed from: private */
                public final int nonDefaultJump;
                /* access modifiers changed from: private */
                public final int requiredSize;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class Bound implements Bound {
                    private final MethodDescription instrumentedMethod;
                    private final boolean inverted;
                    private final Relocation relocation;

                    public Bound(MethodDescription methodDescription, Relocation relocation2, boolean z11) {
                        this.instrumentedMethod = methodDescription;
                        this.relocation = relocation2;
                        this.inverted = z11;
                    }

                    public int apply(MethodVisitor methodVisitor, int i11) {
                        int i12;
                        if (!this.instrumentedMethod.isConstructor()) {
                            methodVisitor.visitVarInsn(ForValue.this.load, i11);
                            ForValue.this.e(methodVisitor);
                            Label label = new Label();
                            if (this.inverted) {
                                i12 = ForValue.this.nonDefaultJump;
                            } else {
                                i12 = ForValue.this.defaultJump;
                            }
                            methodVisitor.visitJumpInsn(i12, label);
                            this.relocation.apply(methodVisitor);
                            methodVisitor.visitLabel(label);
                            return ForValue.this.requiredSize;
                        }
                        throw new IllegalStateException("Cannot skip code execution from constructor: " + this.instrumentedMethod);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Bound bound = (Bound) obj;
                        return this.inverted == bound.inverted && ForValue.this.equals(ForValue.this) && this.instrumentedMethod.equals(bound.instrumentedMethod) && this.relocation.equals(bound.relocation);
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.instrumentedMethod.hashCode()) * 31) + this.relocation.hashCode()) * 31) + (this.inverted ? 1 : 0)) * 31) + ForValue.this.hashCode();
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class Inverted implements RelocationHandler {
                    public Inverted() {
                    }

                    public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                        return new Bound(methodDescription, relocation, true);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && ForValue.this.equals(ForValue.this);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + ForValue.this.hashCode();
                    }
                }

                public static RelocationHandler f(TypeDefinition typeDefinition, boolean z11) {
                    ForValue forValue;
                    if (typeDefinition.represents(Long.TYPE)) {
                        forValue = LONG;
                    } else if (typeDefinition.represents(Float.TYPE)) {
                        forValue = FLOAT;
                    } else if (typeDefinition.represents(Double.TYPE)) {
                        forValue = DOUBLE;
                    } else if (typeDefinition.represents(Void.TYPE)) {
                        throw new IllegalStateException("Cannot skip on default value for void return type");
                    } else if (typeDefinition.isPrimitive()) {
                        forValue = INTEGER;
                    } else {
                        forValue = REFERENCE;
                    }
                    if (!z11) {
                        return forValue;
                    }
                    forValue.getClass();
                    return new Inverted();
                }

                public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                    return new Bound(methodDescription, relocation, false);
                }

                public abstract void e(MethodVisitor methodVisitor);

                private ForValue(int i11, int i12, int i13, int i14) {
                    this.load = i11;
                    this.defaultJump = i12;
                    this.nonDefaultJump = i13;
                    this.requiredSize = i14;
                }
            }

            public interface Relocation {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForLabel implements Relocation {
                    private final Label label;

                    public ForLabel(Label label2) {
                        this.label = label2;
                    }

                    public void apply(MethodVisitor methodVisitor) {
                        methodVisitor.visitJumpInsn(Opcodes.GOTO, this.label);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.label.equals(((ForLabel) obj).label);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.label.hashCode();
                    }
                }

                void apply(MethodVisitor methodVisitor);
            }

            Bound bind(MethodDescription methodDescription, Relocation relocation);
        }

        public interface Resolved extends Dispatcher {

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class AbstractBase implements Resolved {

                /* renamed from: b  reason: collision with root package name */
                public final MethodDescription.InDefinedShape f27032b;

                /* renamed from: c  reason: collision with root package name */
                public final PostProcessor f27033c;

                /* renamed from: d  reason: collision with root package name */
                public final Map<Integer, OffsetMapping> f27034d;

                /* renamed from: e  reason: collision with root package name */
                public final SuppressionHandler f27035e;

                /* renamed from: f  reason: collision with root package name */
                public final RelocationHandler f27036f;

                public AbstractBase(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription, TypeDescription typeDescription2, OffsetMapping.Factory.AdviceType adviceType) {
                    this.f27032b = inDefinedShape;
                    this.f27033c = postProcessor;
                    HashMap hashMap = new HashMap();
                    for (OffsetMapping.Factory factory : list) {
                        hashMap.put(TypeDescription.ForLoadedType.of(factory.getAnnotationType()), factory);
                    }
                    this.f27034d = new LinkedHashMap();
                    for (ParameterDescription.InDefinedShape inDefinedShape2 : inDefinedShape.getParameters()) {
                        OffsetMapping offsetMapping = null;
                        for (AnnotationDescription annotationDescription : inDefinedShape2.getDeclaredAnnotations()) {
                            OffsetMapping.Factory factory2 = (OffsetMapping.Factory) hashMap.get(annotationDescription.getAnnotationType());
                            if (factory2 != null) {
                                OffsetMapping make = factory2.make(inDefinedShape2, annotationDescription.prepare(factory2.getAnnotationType()), adviceType);
                                if (offsetMapping == null) {
                                    offsetMapping = make;
                                } else {
                                    throw new IllegalStateException(inDefinedShape2 + " is bound to both " + make + " and " + offsetMapping);
                                }
                            }
                        }
                        Map<Integer, OffsetMapping> map = this.f27034d;
                        Integer valueOf = Integer.valueOf(inDefinedShape2.getOffset());
                        if (offsetMapping == null) {
                            offsetMapping = new OffsetMapping.ForArgument.Unresolved(inDefinedShape2);
                        }
                        map.put(valueOf, offsetMapping);
                    }
                    this.f27035e = SuppressionHandler.Suppressing.a(typeDescription);
                    this.f27036f = RelocationHandler.ForType.b(typeDescription2, inDefinedShape.getReturnType());
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AbstractBase abstractBase = (AbstractBase) obj;
                    return this.f27032b.equals(abstractBase.f27032b) && this.f27033c.equals(abstractBase.f27033c) && this.f27034d.equals(abstractBase.f27034d) && this.f27035e.equals(abstractBase.f27035e) && this.f27036f.equals(abstractBase.f27036f);
                }

                public int hashCode() {
                    return (((((((((getClass().hashCode() * 31) + this.f27032b.hashCode()) * 31) + this.f27033c.hashCode()) * 31) + this.f27034d.hashCode()) * 31) + this.f27035e.hashCode()) * 31) + this.f27036f.hashCode();
                }

                public boolean isAlive() {
                    return true;
                }
            }

            public interface ForMethodEnter extends Resolved {
                boolean isPrependLineNumber();
            }

            public interface ForMethodExit extends Resolved {
                ArgumentHandler.Factory getArgumentHandlerFactory();

                TypeDescription getThrowable();
            }

            Bound bind(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod, MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2, StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3, StackManipulation stackManipulation, RelocationHandler.Relocation relocation);

            Map<String, TypeDefinition> getNamedTypes();
        }

        public interface SuppressionHandler {

            public interface Bound {
                void onEnd(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition);

                void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition);

                void onPrepare(MethodVisitor methodVisitor);

                void onStart(MethodVisitor methodVisitor);
            }

            public enum NoOp implements SuppressionHandler, Bound {
                INSTANCE;

                public Bound bind(StackManipulation stackManipulation) {
                    return this;
                }

                public void onEnd(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                }

                public void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                }

                public void onPrepare(MethodVisitor methodVisitor) {
                }

                public void onStart(MethodVisitor methodVisitor) {
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Suppressing implements SuppressionHandler {
                private final TypeDescription suppressedType;

                public static class Bound implements Bound {
                    private final Label endOfMethod = new Label();
                    private final StackManipulation exceptionHandler;
                    private final Label startOfMethod = new Label();
                    private final TypeDescription suppressedType;

                    public Bound(TypeDescription typeDescription, StackManipulation stackManipulation) {
                        this.suppressedType = typeDescription;
                        this.exceptionHandler = stackManipulation;
                    }

                    public void onEnd(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                        methodVisitor.visitLabel(this.endOfMethod);
                        forAdvice2.injectExceptionFrame(methodVisitor);
                        forAdvice.requireStackSize(this.exceptionHandler.apply(methodVisitor, context).getMaximalSize() + 1);
                        if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) {
                            methodVisitor.visitInsn(3);
                        } else if (typeDefinition.represents(Long.TYPE)) {
                            methodVisitor.visitInsn(9);
                        } else if (typeDefinition.represents(Float.TYPE)) {
                            methodVisitor.visitInsn(11);
                        } else if (typeDefinition.represents(Double.TYPE)) {
                            methodVisitor.visitInsn(14);
                        } else if (!typeDefinition.represents(Void.TYPE)) {
                            methodVisitor.visitInsn(1);
                        }
                    }

                    public void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context, MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2, TypeDefinition typeDefinition) {
                        Label label = new Label();
                        methodVisitor.visitJumpInsn(Opcodes.GOTO, label);
                        onEnd(methodVisitor, context, forAdvice, forAdvice2, typeDefinition);
                        methodVisitor.visitLabel(label);
                        forAdvice2.injectReturnFrame(methodVisitor);
                    }

                    public void onPrepare(MethodVisitor methodVisitor) {
                        Label label = this.startOfMethod;
                        Label label2 = this.endOfMethod;
                        methodVisitor.visitTryCatchBlock(label, label2, label2, this.suppressedType.getInternalName());
                    }

                    public void onStart(MethodVisitor methodVisitor) {
                        methodVisitor.visitLabel(this.startOfMethod);
                    }
                }

                public Suppressing(TypeDescription typeDescription) {
                    this.suppressedType = typeDescription;
                }

                public static SuppressionHandler a(TypeDescription typeDescription) {
                    return typeDescription.represents(NoExceptionHandler.class) ? NoOp.INSTANCE : new Suppressing(typeDescription);
                }

                public Bound bind(StackManipulation stackManipulation) {
                    return new Bound(this.suppressedType, stackManipulation);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.suppressedType.equals(((Suppressing) obj).suppressedType);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.suppressedType.hashCode();
                }
            }

            Bound bind(StackManipulation stackManipulation);
        }

        public interface Unresolved extends Dispatcher {
            Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory);

            Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list, ClassReader classReader, Unresolved unresolved, PostProcessor.Factory factory);

            Map<String, TypeDefinition> getNamedTypes();

            boolean isBinary();
        }

        TypeDefinition getAdviceType();

        boolean isAlive();
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enter {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    public interface ExceptionHandler {

        public enum Default implements ExceptionHandler {
            SUPPRESSING {
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    return Removal.SINGLE;
                }
            },
            PRINTING {
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    try {
                        return MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(Throwable.class.getMethod("printStackTrace", new Class[0])));
                    } catch (NoSuchMethodException unused) {
                        throw new IllegalStateException("Cannot locate Throwable::printStackTrace");
                    }
                }
            },
            RETHROWING {
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    return Throw.INSTANCE;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements ExceptionHandler {
            private final StackManipulation stackManipulation;

            public Simple(StackManipulation stackManipulation2) {
                this.stackManipulation = stackManipulation2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.stackManipulation.equals(((Simple) obj).stackManipulation);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.stackManipulation.hashCode();
            }

            public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                return this.stackManipulation;
            }
        }

        StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription);
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Exit {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldValue {
        Class<?> declaringType() default void.class;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        String value() default "";
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Local {
        String value();
    }

    public interface MethodSizeHandler {
        public static final int UNDEFINED_SIZE = 32767;

        public static abstract class Default implements ForInstrumentedMethod {

            /* renamed from: b  reason: collision with root package name */
            public final MethodDescription f27037b;

            /* renamed from: c  reason: collision with root package name */
            public final List<? extends TypeDescription> f27038c;

            /* renamed from: d  reason: collision with root package name */
            public final List<? extends TypeDescription> f27039d;

            /* renamed from: e  reason: collision with root package name */
            public final List<? extends TypeDescription> f27040e;

            /* renamed from: f  reason: collision with root package name */
            public int f27041f;

            /* renamed from: g  reason: collision with root package name */
            public int f27042g;

            public class ForAdvice implements ForAdvice {
                private final MethodDescription.InDefinedShape adviceMethod;
                private final int baseLocalVariableLength;
                private int localVariableLengthPadding;
                private int stackSizePadding;

                public ForAdvice(MethodDescription.InDefinedShape inDefinedShape, int i11) {
                    this.adviceMethod = inDefinedShape;
                    this.baseLocalVariableLength = i11;
                }

                public void recordMaxima(int i11, int i12) {
                    Default.this.requireStackSize(i11 + this.stackSizePadding);
                    Default.this.requireLocalVariableLength((i12 - this.adviceMethod.getStackSize()) + this.baseLocalVariableLength + this.localVariableLengthPadding);
                }

                public void requireLocalVariableLength(int i11) {
                    Default.this.requireLocalVariableLength(i11);
                }

                public void requireLocalVariableLengthPadding(int i11) {
                    this.localVariableLengthPadding = Math.max(this.localVariableLengthPadding, i11);
                }

                public void requireStackSize(int i11) {
                    Default.this.requireStackSize(i11);
                }

                public void requireStackSizePadding(int i11) {
                    this.stackSizePadding = Math.max(this.stackSizePadding, i11);
                }
            }

            public static class WithCopiedArguments extends Default {
                public WithCopiedArguments(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                    super(methodDescription, list, list2, list3);
                }

                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForAdvice(inDefinedShape, (this.f27037b.getStackSize() * 2) + StackSize.of((Collection<? extends TypeDefinition>) this.f27038c) + StackSize.of((Collection<? extends TypeDefinition>) this.f27039d) + StackSize.of((Collection<? extends TypeDefinition>) this.f27040e));
                }

                public int compoundLocalVariableLength(int i11) {
                    return Math.max(this.f27042g, i11 + this.f27037b.getStackSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f27040e) + StackSize.of((Collection<? extends TypeDefinition>) this.f27038c) + StackSize.of((Collection<? extends TypeDefinition>) this.f27039d));
                }
            }

            public static class WithRetainedArguments extends Default {
                public WithRetainedArguments(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                    super(methodDescription, list, list2, list3);
                }

                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForAdvice(inDefinedShape, this.f27037b.getStackSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f27040e) + StackSize.of((Collection<? extends TypeDefinition>) this.f27038c) + StackSize.of((Collection<? extends TypeDefinition>) this.f27039d));
                }

                public int compoundLocalVariableLength(int i11) {
                    return Math.max(this.f27042g, i11 + StackSize.of((Collection<? extends TypeDefinition>) this.f27040e) + StackSize.of((Collection<? extends TypeDefinition>) this.f27038c) + StackSize.of((Collection<? extends TypeDefinition>) this.f27039d));
                }
            }

            public Default(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                this.f27037b = methodDescription;
                this.f27038c = list;
                this.f27039d = list2;
                this.f27040e = list3;
            }

            public static ForInstrumentedMethod a(MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, boolean z11, int i11) {
                if ((i11 & 3) != 0) {
                    return NoOp.INSTANCE;
                }
                if (z11) {
                    return new WithCopiedArguments(methodDescription, list, list2, list3);
                }
                return new WithRetainedArguments(methodDescription, list, list2, list3);
            }

            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return new ForAdvice(inDefinedShape, this.f27037b.getStackSize() + StackSize.of((Collection<? extends TypeDefinition>) this.f27038c));
            }

            public int compoundLocalVariableLength(int i11) {
                return Math.max(this.f27042g, i11 + StackSize.of((Collection<? extends TypeDefinition>) this.f27040e) + StackSize.of((Collection<? extends TypeDefinition>) this.f27038c) + StackSize.of((Collection<? extends TypeDefinition>) this.f27039d));
            }

            public int compoundStackSize(int i11) {
                return Math.max(this.f27041f, i11);
            }

            public void requireLocalVariableLength(int i11) {
                this.f27042g = Math.max(this.f27042g, i11);
            }

            public void requireStackSize(int i11) {
                this.f27041f = Math.max(this.f27041f, i11);
            }
        }

        public interface ForAdvice extends MethodSizeHandler {
            void recordMaxima(int i11, int i12);

            void requireLocalVariableLengthPadding(int i11);

            void requireStackSizePadding(int i11);
        }

        public interface ForInstrumentedMethod extends MethodSizeHandler {
            ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape);

            ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape);

            int compoundLocalVariableLength(int i11);

            int compoundStackSize(int i11);
        }

        public enum NoOp implements ForInstrumentedMethod, ForAdvice {
            INSTANCE;

            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            public int compoundLocalVariableLength(int i11) {
                return MethodSizeHandler.UNDEFINED_SIZE;
            }

            public int compoundStackSize(int i11) {
                return MethodSizeHandler.UNDEFINED_SIZE;
            }

            public void recordMaxima(int i11, int i12) {
            }

            public void requireLocalVariableLength(int i11) {
            }

            public void requireLocalVariableLengthPadding(int i11) {
            }

            public void requireStackSize(int i11) {
            }

            public void requireStackSizePadding(int i11) {
            }
        }

        void requireLocalVariableLength(int i11);

        void requireStackSize(int i11);
    }

    public static class NoExceptionHandler extends Throwable {
        /* access modifiers changed from: private */
        public static final TypeDescription DESCRIPTION = TypeDescription.ForLoadedType.of(NoExceptionHandler.class);
        private static final long serialVersionUID = 1;

        private NoExceptionHandler() {
            throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
        }
    }

    public interface OffsetMapping {

        public interface Factory<T extends Annotation> {

            public enum AdviceType {
                DELEGATION(true),
                INLINING(false);
                
                private final boolean delegation;

                private AdviceType(boolean z11) {
                    this.delegation = z11;
                }

                public boolean isDelegation() {
                    return this.delegation;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Illegal<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;

                public Illegal(Class<T> cls) {
                    this.annotationType = cls;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((Illegal) obj).annotationType);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.annotationType.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, AdviceType adviceType) {
                    throw new IllegalStateException("Usage of " + this.annotationType + " is not allowed on " + inDefinedShape);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Simple<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final OffsetMapping offsetMapping;

                public Simple(Class<T> cls, OffsetMapping offsetMapping2) {
                    this.annotationType = cls;
                    this.offsetMapping = offsetMapping2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Simple simple = (Simple) obj;
                    return this.annotationType.equals(simple.annotationType) && this.offsetMapping.equals(simple.offsetMapping);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.offsetMapping.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, AdviceType adviceType) {
                    return this.offsetMapping;
                }
            }

            Class<T> getAnnotationType();

            OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, AdviceType adviceType);
        }

        public enum ForInstrumentedMethod implements OffsetMapping {
            METHOD {
                public boolean a(MethodDescription methodDescription) {
                    return methodDescription.isMethod();
                }
            },
            CONSTRUCTOR {
                public boolean a(MethodDescription methodDescription) {
                    return methodDescription.isConstructor();
                }
            },
            EXECUTABLE {
                public boolean a(MethodDescription methodDescription) {
                    return true;
                }
            };

            public abstract boolean a(MethodDescription methodDescription);

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (a(methodDescription)) {
                    return Target.ForStackManipulation.of((MethodDescription.InDefinedShape) methodDescription.asDefined());
                }
                throw new IllegalStateException("Cannot represent " + methodDescription + " as given method constant");
            }
        }

        public enum ForInstrumentedType implements OffsetMapping {
            INSTANCE;

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return Target.ForStackManipulation.of(typeDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForLocalValue implements OffsetMapping {
            private final TypeDescription.Generic localType;

            /* renamed from: name  reason: collision with root package name */
            private final String f27047name;
            private final TypeDescription.Generic target;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory<Local> {

                /* renamed from: b  reason: collision with root package name */
                public static final MethodDescription.InDefinedShape f27048b = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Local.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());
                private final Map<String, TypeDefinition> namedTypes;

                public Factory(Map<String, TypeDefinition> map) {
                    this.namedTypes = map;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.namedTypes.equals(((Factory) obj).namedTypes);
                }

                public Class<Local> getAnnotationType() {
                    return Local.class;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.namedTypes.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Local> loadable, Factory.AdviceType adviceType) {
                    String str = (String) loadable.getValue(f27048b).resolve(String.class);
                    TypeDefinition typeDefinition = this.namedTypes.get(str);
                    if (typeDefinition != null) {
                        return new ForLocalValue(inDefinedShape.getType(), typeDefinition.asGenericType(), str);
                    }
                    throw new IllegalStateException("Named local variable is unknown: " + str);
                }
            }

            public ForLocalValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, String str) {
                this.target = generic;
                this.localType = generic2;
                this.f27047name = str;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForLocalValue forLocalValue = (ForLocalValue) obj;
                return this.f27047name.equals(forLocalValue.f27047name) && this.target.equals(forLocalValue.target) && this.localType.equals(forLocalValue.localType);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.localType.hashCode()) * 31) + this.f27047name.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                TypeDescription.Generic generic = this.localType;
                TypeDescription.Generic generic2 = this.target;
                Assigner.Typing typing = Assigner.Typing.STATIC;
                StackManipulation assign = assigner.assign(generic, generic2, typing);
                StackManipulation assign2 = assigner.assign(this.target, this.localType, typing);
                if (assign.isValid() && assign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(this.target, argumentHandler.named(this.f27047name), assign, assign2);
                }
                throw new IllegalStateException("Cannot assign " + this.localType + " to " + this.target);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForOrigin implements OffsetMapping {
            private static final char DELIMITER = '#';
            private static final char ESCAPE = '\\';
            private final List<Renderer> renderers;

            public enum Factory implements Factory<Origin> {
                INSTANCE;
                
                private static final MethodDescription.InDefinedShape ORIGIN_VALUE = null;

                /* access modifiers changed from: public */
                static {
                    ORIGIN_VALUE = (MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Origin.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly();
                }

                public Class<Origin> getAnnotationType() {
                    return Origin.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Origin> loadable, Factory.AdviceType adviceType) {
                    if (inDefinedShape.getType().asErasure().represents(Class.class)) {
                        return ForInstrumentedType.INSTANCE;
                    }
                    if (inDefinedShape.getType().asErasure().represents(Method.class)) {
                        return ForInstrumentedMethod.METHOD;
                    }
                    if (inDefinedShape.getType().asErasure().represents(Constructor.class)) {
                        return ForInstrumentedMethod.CONSTRUCTOR;
                    }
                    if (JavaType.EXECUTABLE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                        return ForInstrumentedMethod.EXECUTABLE;
                    }
                    Class<String> cls = String.class;
                    if (inDefinedShape.getType().asErasure().isAssignableFrom((Class<?>) cls)) {
                        return ForOrigin.parse((String) loadable.getValue(ORIGIN_VALUE).resolve(cls));
                    }
                    throw new IllegalStateException("Non-supported type " + inDefinedShape.getType() + " for @Origin annotation");
                }
            }

            public interface Renderer {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForConstantValue implements Renderer {
                    private final String value;

                    public ForConstantValue(String str) {
                        this.value = str;
                    }

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this.value;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.value.equals(((ForConstantValue) obj).value);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.value.hashCode();
                    }
                }

                public enum ForDescriptor implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 'd';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getDescriptor();
                    }
                }

                public enum ForJavaSignature implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 's';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        StringBuilder sb2 = new StringBuilder("(");
                        boolean z11 = false;
                        for (TypeDescription typeDescription2 : methodDescription.getParameters().asTypeList().asErasures()) {
                            if (z11) {
                                sb2.append(AbstractJsonLexerKt.COMMA);
                            } else {
                                z11 = true;
                            }
                            sb2.append(typeDescription2.getName());
                        }
                        sb2.append(')');
                        return sb2.toString();
                    }
                }

                public enum ForMethodName implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 'm';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getInternalName();
                    }
                }

                public enum ForPropertyName implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 'p';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return FieldAccessor.FieldNameExtractor.ForBeanProperty.INSTANCE.resolve(methodDescription);
                    }
                }

                public enum ForReturnTypeName implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 'r';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getReturnType().asErasure().getName();
                    }
                }

                public enum ForStringRepresentation implements Renderer {
                    INSTANCE;

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.toString();
                    }
                }

                public enum ForTypeName implements Renderer {
                    INSTANCE;
                    
                    public static final char SYMBOL = 't';

                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return typeDescription.getName();
                    }
                }

                String apply(TypeDescription typeDescription, MethodDescription methodDescription);
            }

            public ForOrigin(List<Renderer> list) {
                this.renderers = list;
            }

            public static OffsetMapping parse(String str) {
                int i11;
                if (str.equals("")) {
                    return new ForOrigin(Collections.singletonList(Renderer.ForStringRepresentation.INSTANCE));
                }
                ArrayList arrayList = new ArrayList(str.length());
                int indexOf = str.indexOf(35);
                int i12 = 0;
                while (indexOf != -1) {
                    if (indexOf != 0) {
                        int i13 = indexOf - 1;
                        if (str.charAt(i13) == '\\' && (indexOf == 1 || str.charAt(indexOf - 2) != '\\')) {
                            arrayList.add(new Renderer.ForConstantValue(str.substring(i12, Math.max(0, i13)) + DELIMITER));
                            i11 = indexOf + 1;
                            i12 = i11;
                            indexOf = str.indexOf(35, i12);
                        }
                    }
                    int i14 = indexOf + 1;
                    if (str.length() != i14) {
                        arrayList.add(new Renderer.ForConstantValue(str.substring(i12, indexOf).replace("\\\\", "\\")));
                        char charAt = str.charAt(i14);
                        if (charAt == 'd') {
                            arrayList.add(Renderer.ForDescriptor.INSTANCE);
                        } else if (charAt == 'm') {
                            arrayList.add(Renderer.ForMethodName.INSTANCE);
                        } else if (charAt != 'p') {
                            switch (charAt) {
                                case 'r':
                                    arrayList.add(Renderer.ForReturnTypeName.INSTANCE);
                                    break;
                                case 's':
                                    arrayList.add(Renderer.ForJavaSignature.INSTANCE);
                                    break;
                                case 't':
                                    arrayList.add(Renderer.ForTypeName.INSTANCE);
                                    break;
                                default:
                                    throw new IllegalStateException("Illegal sort descriptor " + str.charAt(i14) + " for " + str);
                            }
                        } else {
                            arrayList.add(Renderer.ForPropertyName.INSTANCE);
                        }
                        i11 = indexOf + 2;
                        i12 = i11;
                        indexOf = str.indexOf(35, i12);
                    } else {
                        throw new IllegalStateException("Missing sort descriptor for " + str + " at index " + indexOf);
                    }
                }
                arrayList.add(new Renderer.ForConstantValue(str.substring(i12)));
                return new ForOrigin(arrayList);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.renderers.equals(((ForOrigin) obj).renderers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.renderers.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StringBuilder sb2 = new StringBuilder();
                for (Renderer apply : this.renderers) {
                    sb2.append(apply.apply(typeDescription, methodDescription));
                }
                return Target.ForStackManipulation.of((Object) sb2.toString());
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForSerializedValue implements OffsetMapping {
            private final StackManipulation deserialization;
            private final TypeDescription.Generic target;
            private final TypeDescription typeDescription;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final StackManipulation deserialization;
                private final TypeDescription typeDescription;

                public Factory(Class<T> cls, TypeDescription typeDescription2, StackManipulation stackManipulation) {
                    this.annotationType = cls;
                    this.typeDescription = typeDescription2;
                    this.deserialization = stackManipulation;
                }

                public static <S extends Annotation> Factory<S> of(Class<S> cls, Serializable serializable, Class<?> cls2) {
                    if (cls2.isInstance(serializable)) {
                        return new Factory(cls, TypeDescription.ForLoadedType.of(cls2), SerializedConstant.of(serializable));
                    }
                    throw new IllegalArgumentException(serializable + " is no instance of " + cls2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.annotationType.equals(factory.annotationType) && this.typeDescription.equals(factory.typeDescription) && this.deserialization.equals(factory.deserialization);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.typeDescription.hashCode()) * 31) + this.deserialization.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForSerializedValue(inDefinedShape.getType(), this.typeDescription, this.deserialization);
                }
            }

            public ForSerializedValue(TypeDescription.Generic generic, TypeDescription typeDescription2, StackManipulation stackManipulation) {
                this.target = generic;
                this.typeDescription = typeDescription2;
                this.deserialization = stackManipulation;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForSerializedValue forSerializedValue = (ForSerializedValue) obj;
                return this.target.equals(forSerializedValue.target) && this.typeDescription.equals(forSerializedValue.typeDescription) && this.deserialization.equals(forSerializedValue.deserialization);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.typeDescription.hashCode()) * 31) + this.deserialization.hashCode();
            }

            public Target resolve(TypeDescription typeDescription2, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(this.typeDescription.asGenericType(), this.target, Assigner.Typing.DYNAMIC);
                if (assign.isValid()) {
                    return new Target.ForStackManipulation(new StackManipulation.Compound(this.deserialization, assign));
                }
                throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.target);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForStackManipulation implements OffsetMapping {
            private final StackManipulation stackManipulation;
            private final TypeDescription.Generic targetType;
            private final TypeDescription.Generic typeDescription;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final StackManipulation stackManipulation;
                private final TypeDescription.Generic typeDescription;

                public Factory(Class<T> cls, TypeDescription typeDescription2) {
                    this(cls, ClassConstant.of(typeDescription2), TypeDescription.CLASS.asGenericType());
                }

                public static <S extends Annotation> Factory<S> of(Class<S> cls, Object obj) {
                    StackManipulation stackManipulation2;
                    TypeDescription typeDescription2;
                    StackManipulation javaConstantValue;
                    TypeDescription typeDescription3;
                    if (obj == null) {
                        return new OfDefaultValue(cls);
                    }
                    if (obj instanceof Boolean) {
                        stackManipulation2 = IntegerConstant.forValue(((Boolean) obj).booleanValue());
                        typeDescription2 = TypeDescription.ForLoadedType.of(Boolean.TYPE);
                    } else if (obj instanceof Byte) {
                        stackManipulation2 = IntegerConstant.forValue((int) ((Byte) obj).byteValue());
                        typeDescription2 = TypeDescription.ForLoadedType.of(Byte.TYPE);
                    } else if (obj instanceof Short) {
                        stackManipulation2 = IntegerConstant.forValue((int) ((Short) obj).shortValue());
                        typeDescription2 = TypeDescription.ForLoadedType.of(Short.TYPE);
                    } else if (obj instanceof Character) {
                        stackManipulation2 = IntegerConstant.forValue((int) ((Character) obj).charValue());
                        typeDescription2 = TypeDescription.ForLoadedType.of(Character.TYPE);
                    } else if (obj instanceof Integer) {
                        stackManipulation2 = IntegerConstant.forValue(((Integer) obj).intValue());
                        typeDescription2 = TypeDescription.ForLoadedType.of(Integer.TYPE);
                    } else if (obj instanceof Long) {
                        stackManipulation2 = LongConstant.forValue(((Long) obj).longValue());
                        typeDescription2 = TypeDescription.ForLoadedType.of(Long.TYPE);
                    } else if (obj instanceof Float) {
                        stackManipulation2 = FloatConstant.forValue(((Float) obj).floatValue());
                        typeDescription2 = TypeDescription.ForLoadedType.of(Float.TYPE);
                    } else if (obj instanceof Double) {
                        stackManipulation2 = DoubleConstant.forValue(((Double) obj).doubleValue());
                        typeDescription2 = TypeDescription.ForLoadedType.of(Double.TYPE);
                    } else {
                        if (obj instanceof String) {
                            javaConstantValue = new TextConstant((String) obj);
                            typeDescription3 = TypeDescription.STRING;
                        } else if (obj instanceof Class) {
                            stackManipulation2 = ClassConstant.of(TypeDescription.ForLoadedType.of((Class) obj));
                            typeDescription2 = TypeDescription.CLASS;
                        } else if (obj instanceof TypeDescription) {
                            stackManipulation2 = ClassConstant.of((TypeDescription) obj);
                            typeDescription2 = TypeDescription.CLASS;
                        } else if (obj instanceof Enum) {
                            Enum enumR = (Enum) obj;
                            javaConstantValue = FieldAccess.forEnumeration(new EnumerationDescription.ForLoadedEnumeration(enumR));
                            typeDescription3 = TypeDescription.ForLoadedType.of(enumR.getDeclaringClass());
                        } else if (obj instanceof EnumerationDescription) {
                            EnumerationDescription enumerationDescription = (EnumerationDescription) obj;
                            javaConstantValue = FieldAccess.forEnumeration(enumerationDescription);
                            typeDescription3 = enumerationDescription.getEnumerationType();
                        } else if (JavaType.METHOD_HANDLE.isInstance(obj)) {
                            JavaConstant.MethodHandle ofLoaded = JavaConstant.MethodHandle.ofLoaded(obj);
                            javaConstantValue = new JavaConstantValue(ofLoaded);
                            typeDescription3 = ofLoaded.getTypeDescription();
                        } else if (JavaType.METHOD_TYPE.isInstance(obj)) {
                            JavaConstant.MethodType ofLoaded2 = JavaConstant.MethodType.ofLoaded(obj);
                            javaConstantValue = new JavaConstantValue(ofLoaded2);
                            typeDescription3 = ofLoaded2.getTypeDescription();
                        } else if (obj instanceof JavaConstant) {
                            JavaConstant javaConstant = (JavaConstant) obj;
                            javaConstantValue = new JavaConstantValue(javaConstant);
                            typeDescription3 = javaConstant.getTypeDescription();
                        } else {
                            throw new IllegalStateException("Not a constant value: " + obj);
                        }
                        StackManipulation stackManipulation3 = javaConstantValue;
                        typeDescription2 = typeDescription3;
                        stackManipulation2 = stackManipulation3;
                    }
                    return new Factory(cls, stackManipulation2, typeDescription2.asGenericType());
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.annotationType.equals(factory.annotationType) && this.stackManipulation.equals(factory.stackManipulation) && this.typeDescription.equals(factory.typeDescription);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDescription.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForStackManipulation(this.stackManipulation, this.typeDescription, inDefinedShape.getType(), Assigner.Typing.STATIC);
                }

                public Factory(Class<T> cls, EnumerationDescription enumerationDescription) {
                    this(cls, FieldAccess.forEnumeration(enumerationDescription), enumerationDescription.getEnumerationType().asGenericType());
                }

                public Factory(Class<T> cls, StackManipulation stackManipulation2, TypeDescription.Generic generic) {
                    this.annotationType = cls;
                    this.stackManipulation = stackManipulation2;
                    this.typeDescription = generic;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfAnnotationProperty<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final MethodDescription.InDefinedShape property;

                public OfAnnotationProperty(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape) {
                    this.annotationType = cls;
                    this.property = inDefinedShape;
                }

                public static <S extends Annotation> Factory<S> of(Class<S> cls, String str) {
                    if (cls.isAnnotation()) {
                        try {
                            return new OfAnnotationProperty(cls, new MethodDescription.ForLoadedMethod(cls.getMethod(str, new Class[0])));
                        } catch (NoSuchMethodException e11) {
                            throw new IllegalArgumentException("Cannot find a property " + str + " on " + cls, e11);
                        }
                    } else {
                        throw new IllegalArgumentException("Not an annotation type: " + cls);
                    }
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfAnnotationProperty ofAnnotationProperty = (OfAnnotationProperty) obj;
                    return this.annotationType.equals(ofAnnotationProperty.annotationType) && this.property.equals(ofAnnotationProperty.property);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.property.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    Factory<S> factory;
                    Object resolve = loadable.getValue(this.property).resolve();
                    if (resolve instanceof TypeDescription) {
                        factory = new Factory<>(this.annotationType, (TypeDescription) resolve);
                    } else if (resolve instanceof EnumerationDescription) {
                        factory = new Factory<>(this.annotationType, (EnumerationDescription) resolve);
                    } else if (!(resolve instanceof AnnotationDescription)) {
                        factory = Factory.of(this.annotationType, resolve);
                    } else {
                        throw new IllegalStateException("Cannot bind annotation as fixed value for " + this.property);
                    }
                    return factory.make(inDefinedShape, loadable, adviceType);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfDefaultValue<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;

                public OfDefaultValue(Class<T> cls) {
                    this.annotationType = cls;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((OfDefaultValue) obj).annotationType);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.annotationType.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForStackManipulation(DefaultValue.of(inDefinedShape.getType()), inDefinedShape.getType(), inDefinedShape.getType(), Assigner.Typing.STATIC);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfDynamicInvocation<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final List<? extends JavaConstant> arguments;
                private final MethodDescription.InDefinedShape bootstrapMethod;

                public OfDynamicInvocation(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list) {
                    this.annotationType = cls;
                    this.bootstrapMethod = inDefinedShape;
                    this.arguments = list;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfDynamicInvocation ofDynamicInvocation = (OfDynamicInvocation) obj;
                    return this.annotationType.equals(ofDynamicInvocation.annotationType) && this.bootstrapMethod.equals(ofDynamicInvocation.bootstrapMethod) && this.arguments.equals(ofDynamicInvocation.arguments);
                }

                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.bootstrapMethod.hashCode()) * 31) + this.arguments.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    if (!inDefinedShape.getType().isInterface()) {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " is not an interface");
                    } else if (!inDefinedShape.getType().getInterfaces().isEmpty()) {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " must not extend other interfaces");
                    } else if (inDefinedShape.getType().isPublic()) {
                        MethodList methodList = (MethodList) inDefinedShape.getType().getDeclaredMethods().filter(ElementMatchers.isAbstract());
                        if (methodList.size() == 1) {
                            return new ForStackManipulation(MethodInvocation.invoke(this.bootstrapMethod).dynamic(((MethodDescription) methodList.getOnly()).getInternalName(), inDefinedShape.getType().asErasure(), ((MethodDescription) methodList.getOnly()).getParameters().asTypeList().asErasures(), this.arguments), inDefinedShape.getType(), inDefinedShape.getType(), Assigner.Typing.STATIC);
                        }
                        throw new IllegalArgumentException(inDefinedShape.getType() + " must declare exactly one abstract method");
                    } else {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " is mot public");
                    }
                }
            }

            public ForStackManipulation(StackManipulation stackManipulation2, TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing2) {
                this.stackManipulation = stackManipulation2;
                this.typeDescription = generic;
                this.targetType = generic2;
                this.typing = typing2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForStackManipulation forStackManipulation = (ForStackManipulation) obj;
                return this.typing.equals(forStackManipulation.typing) && this.stackManipulation.equals(forStackManipulation.stackManipulation) && this.typeDescription.equals(forStackManipulation.typeDescription) && this.targetType.equals(forStackManipulation.targetType);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.stackManipulation.hashCode()) * 31) + this.typeDescription.hashCode()) * 31) + this.targetType.hashCode()) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription2, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(this.typeDescription, this.targetType, this.typing);
                if (assign.isValid()) {
                    return new Target.ForStackManipulation(new StackManipulation.Compound(this.stackManipulation, assign));
                }
                throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.targetType);
            }
        }

        public enum ForStubValue implements OffsetMapping, Factory<StubValue> {
            INSTANCE;

            public Class<StubValue> getAnnotationType() {
                return StubValue.class;
            }

            public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<StubValue> loadable, Factory.AdviceType adviceType) {
                if (inDefinedShape.getType().represents(Object.class)) {
                    return this;
                }
                throw new IllegalStateException("Cannot use StubValue on non-Object parameter type " + inDefinedShape);
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return new Target.ForDefaultValue.ReadOnly(methodDescription.getReturnType(), assigner.assign(methodDescription.getReturnType(), TypeDescription.Generic.OBJECT, Assigner.Typing.DYNAMIC));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForUnusedValue implements OffsetMapping {
            private final TypeDefinition target;

            public enum Factory implements Factory<Unused> {
                INSTANCE;

                public Class<Unused> getAnnotationType() {
                    return Unused.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Unused> loadable, Factory.AdviceType adviceType) {
                    return new ForUnusedValue(inDefinedShape.getType());
                }
            }

            public ForUnusedValue(TypeDefinition typeDefinition) {
                this.target = typeDefinition;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForUnusedValue) obj).target);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.target.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return new Target.ForDefaultValue.ReadWrite(this.target);
            }
        }

        public enum Sort {
            ENTER {
                public boolean isPremature(MethodDescription methodDescription) {
                    return methodDescription.isConstructor();
                }
            },
            EXIT {
                public boolean isPremature(MethodDescription methodDescription) {
                    return false;
                }
            };

            public abstract boolean isPremature(MethodDescription methodDescription);
        }

        public interface Target {

            public static abstract class AbstractReadOnlyAdapter implements Target {
                public StackManipulation resolveIncrement(int i11) {
                    throw new IllegalStateException("Cannot write to read-only value");
                }

                public StackManipulation resolveWrite() {
                    throw new IllegalStateException("Cannot write to read-only value");
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForArray implements Target {

                /* renamed from: a  reason: collision with root package name */
                public final TypeDescription.Generic f27049a;

                /* renamed from: b  reason: collision with root package name */
                public final List<? extends StackManipulation> f27050b;

                public static class ReadOnly extends ForArray {
                    public ReadOnly(TypeDescription.Generic generic, List<? extends StackManipulation> list) {
                        super(generic, list);
                    }

                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only array value");
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForArray {
                    private final List<? extends StackManipulation> valueWrites;

                    public ReadWrite(TypeDescription.Generic generic, List<? extends StackManipulation> list, List<? extends StackManipulation> list2) {
                        super(generic, list);
                        this.valueWrites = list2;
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.valueWrites.equals(((ReadWrite) obj).valueWrites);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.valueWrites.hashCode();
                    }

                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(ArrayAccess.of(this.f27049a).forEach(this.valueWrites), Removal.SINGLE);
                    }
                }

                public ForArray(TypeDescription.Generic generic, List<? extends StackManipulation> list) {
                    this.f27049a = generic;
                    this.f27050b = list;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForArray forArray = (ForArray) obj;
                    return this.f27049a.equals(forArray.f27049a) && this.f27050b.equals(forArray.f27050b);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.f27049a.hashCode()) * 31) + this.f27050b.hashCode();
                }

                public StackManipulation resolveIncrement(int i11) {
                    throw new IllegalStateException("Cannot increment read-only array value");
                }

                public StackManipulation resolveRead() {
                    return ArrayFactory.forType(this.f27049a).withValues(this.f27050b);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForDefaultValue implements Target {

                /* renamed from: a  reason: collision with root package name */
                public final TypeDefinition f27051a;

                /* renamed from: b  reason: collision with root package name */
                public final StackManipulation f27052b;

                public static class ReadOnly extends ForDefaultValue {
                    public ReadOnly(TypeDefinition typeDefinition) {
                        this(typeDefinition, StackManipulation.Trivial.INSTANCE);
                    }

                    public StackManipulation resolveIncrement(int i11) {
                        throw new IllegalStateException("Cannot write to read-only default value");
                    }

                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only default value");
                    }

                    public ReadOnly(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                        super(typeDefinition, stackManipulation);
                    }
                }

                public static class ReadWrite extends ForDefaultValue {
                    public ReadWrite(TypeDefinition typeDefinition) {
                        this(typeDefinition, StackManipulation.Trivial.INSTANCE);
                    }

                    public StackManipulation resolveIncrement(int i11) {
                        return StackManipulation.Trivial.INSTANCE;
                    }

                    public StackManipulation resolveWrite() {
                        return Removal.of(this.f27051a);
                    }

                    public ReadWrite(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                        super(typeDefinition, stackManipulation);
                    }
                }

                public ForDefaultValue(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                    this.f27051a = typeDefinition;
                    this.f27052b = stackManipulation;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForDefaultValue forDefaultValue = (ForDefaultValue) obj;
                    return this.f27051a.equals(forDefaultValue.f27051a) && this.f27052b.equals(forDefaultValue.f27052b);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.f27051a.hashCode()) * 31) + this.f27052b.hashCode();
                }

                public StackManipulation resolveRead() {
                    return new StackManipulation.Compound(DefaultValue.of(this.f27051a), this.f27052b);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForField implements Target {

                /* renamed from: a  reason: collision with root package name */
                public final FieldDescription f27053a;

                /* renamed from: b  reason: collision with root package name */
                public final StackManipulation f27054b;

                public static class ReadOnly extends ForField {
                    public ReadOnly(FieldDescription fieldDescription) {
                        this(fieldDescription, StackManipulation.Trivial.INSTANCE);
                    }

                    public StackManipulation resolveIncrement(int i11) {
                        throw new IllegalStateException("Cannot write to read-only field value");
                    }

                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only field value");
                    }

                    public ReadOnly(FieldDescription fieldDescription, StackManipulation stackManipulation) {
                        super(fieldDescription, stackManipulation);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForField {
                    private final StackManipulation writeAssignment;

                    /* JADX WARNING: Illegal instructions before constructor call */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public ReadWrite(net.bytebuddy.description.field.FieldDescription r2) {
                        /*
                            r1 = this;
                            net.bytebuddy.implementation.bytecode.StackManipulation$Trivial r0 = net.bytebuddy.implementation.bytecode.StackManipulation.Trivial.INSTANCE
                            r1.<init>(r2, r0, r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.Target.ForField.ReadWrite.<init>(net.bytebuddy.description.field.FieldDescription):void");
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.writeAssignment.equals(((ReadWrite) obj).writeAssignment);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.writeAssignment.hashCode();
                    }

                    public StackManipulation resolveIncrement(int i11) {
                        return new StackManipulation.Compound(resolveRead(), IntegerConstant.forValue(i11), Addition.INTEGER, resolveWrite());
                    }

                    public StackManipulation resolveWrite() {
                        StackManipulation stackManipulation;
                        if (this.f27053a.isStatic()) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = new StackManipulation.Compound(MethodVariableAccess.loadThis(), Duplication.SINGLE.flipOver(this.f27053a.getType()), Removal.SINGLE);
                        }
                        return new StackManipulation.Compound(this.writeAssignment, stackManipulation, FieldAccess.forField(this.f27053a).write());
                    }

                    public ReadWrite(FieldDescription fieldDescription, StackManipulation stackManipulation, StackManipulation stackManipulation2) {
                        super(fieldDescription, stackManipulation);
                        this.writeAssignment = stackManipulation2;
                    }
                }

                public ForField(FieldDescription fieldDescription, StackManipulation stackManipulation) {
                    this.f27053a = fieldDescription;
                    this.f27054b = stackManipulation;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForField forField = (ForField) obj;
                    return this.f27053a.equals(forField.f27053a) && this.f27054b.equals(forField.f27054b);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.f27053a.hashCode()) * 31) + this.f27054b.hashCode();
                }

                public StackManipulation resolveRead() {
                    StackManipulation stackManipulation;
                    StackManipulation[] stackManipulationArr = new StackManipulation[3];
                    if (this.f27053a.isStatic()) {
                        stackManipulation = StackManipulation.Trivial.INSTANCE;
                    } else {
                        stackManipulation = MethodVariableAccess.loadThis();
                    }
                    stackManipulationArr[0] = stackManipulation;
                    stackManipulationArr[1] = FieldAccess.forField(this.f27053a).read();
                    stackManipulationArr[2] = this.f27054b;
                    return new StackManipulation.Compound(stackManipulationArr);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForStackManipulation implements Target {
                private final StackManipulation stackManipulation;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Writable implements Target {
                    private final StackManipulation read;
                    private final StackManipulation write;

                    public Writable(StackManipulation stackManipulation, StackManipulation stackManipulation2) {
                        this.read = stackManipulation;
                        this.write = stackManipulation2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Writable writable = (Writable) obj;
                        return this.read.equals(writable.read) && this.write.equals(writable.write);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.read.hashCode()) * 31) + this.write.hashCode();
                    }

                    public StackManipulation resolveIncrement(int i11) {
                        throw new IllegalStateException("Cannot increment mutable constant value: " + this.write);
                    }

                    public StackManipulation resolveRead() {
                        return this.read;
                    }

                    public StackManipulation resolveWrite() {
                        return this.write;
                    }
                }

                public ForStackManipulation(StackManipulation stackManipulation2) {
                    this.stackManipulation = stackManipulation2;
                }

                public static Target of(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForStackManipulation(MethodConstant.of(inDefinedShape));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.stackManipulation.equals(((ForStackManipulation) obj).stackManipulation);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.stackManipulation.hashCode();
                }

                public StackManipulation resolveIncrement(int i11) {
                    throw new IllegalStateException("Cannot write to constant value: " + this.stackManipulation);
                }

                public StackManipulation resolveRead() {
                    return this.stackManipulation;
                }

                public StackManipulation resolveWrite() {
                    throw new IllegalStateException("Cannot write to constant value: " + this.stackManipulation);
                }

                public static Target of(TypeDescription typeDescription) {
                    return new ForStackManipulation(ClassConstant.of(typeDescription));
                }

                public static Target of(Object obj) {
                    if (obj == null) {
                        return new ForStackManipulation(NullConstant.INSTANCE);
                    }
                    if (obj instanceof Boolean) {
                        return new ForStackManipulation(IntegerConstant.forValue(((Boolean) obj).booleanValue()));
                    }
                    if (obj instanceof Byte) {
                        return new ForStackManipulation(IntegerConstant.forValue((int) ((Byte) obj).byteValue()));
                    }
                    if (obj instanceof Short) {
                        return new ForStackManipulation(IntegerConstant.forValue((int) ((Short) obj).shortValue()));
                    }
                    if (obj instanceof Character) {
                        return new ForStackManipulation(IntegerConstant.forValue((int) ((Character) obj).charValue()));
                    }
                    if (obj instanceof Integer) {
                        return new ForStackManipulation(IntegerConstant.forValue(((Integer) obj).intValue()));
                    }
                    if (obj instanceof Long) {
                        return new ForStackManipulation(LongConstant.forValue(((Long) obj).longValue()));
                    }
                    if (obj instanceof Float) {
                        return new ForStackManipulation(FloatConstant.forValue(((Float) obj).floatValue()));
                    }
                    if (obj instanceof Double) {
                        return new ForStackManipulation(DoubleConstant.forValue(((Double) obj).doubleValue()));
                    }
                    if (obj instanceof String) {
                        return new ForStackManipulation(new TextConstant((String) obj));
                    }
                    if (obj instanceof Enum) {
                        return new ForStackManipulation(FieldAccess.forEnumeration(new EnumerationDescription.ForLoadedEnumeration((Enum) obj)));
                    }
                    if (obj instanceof EnumerationDescription) {
                        return new ForStackManipulation(FieldAccess.forEnumeration((EnumerationDescription) obj));
                    }
                    if (obj instanceof Class) {
                        return new ForStackManipulation(ClassConstant.of(TypeDescription.ForLoadedType.of((Class) obj)));
                    }
                    if (obj instanceof TypeDescription) {
                        return new ForStackManipulation(ClassConstant.of((TypeDescription) obj));
                    }
                    if (JavaType.METHOD_HANDLE.isInstance(obj)) {
                        return new ForStackManipulation(new JavaConstantValue(JavaConstant.MethodHandle.ofLoaded(obj)));
                    }
                    if (JavaType.METHOD_TYPE.isInstance(obj)) {
                        return new ForStackManipulation(new JavaConstantValue(JavaConstant.MethodType.ofLoaded(obj)));
                    }
                    if (obj instanceof JavaConstant) {
                        return new ForStackManipulation(new JavaConstantValue((JavaConstant) obj));
                    }
                    throw new IllegalArgumentException("Not a constant value: " + obj);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForVariable implements Target {

                /* renamed from: a  reason: collision with root package name */
                public final TypeDefinition f27055a;

                /* renamed from: b  reason: collision with root package name */
                public final int f27056b;

                /* renamed from: c  reason: collision with root package name */
                public final StackManipulation f27057c;

                public static class ReadOnly extends ForVariable {
                    public ReadOnly(TypeDefinition typeDefinition, int i11) {
                        this(typeDefinition, i11, StackManipulation.Trivial.INSTANCE);
                    }

                    public StackManipulation resolveIncrement(int i11) {
                        throw new IllegalStateException("Cannot write to read-only variable " + this.f27055a + " at " + this.f27056b);
                    }

                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only parameter " + this.f27055a + " at " + this.f27056b);
                    }

                    public ReadOnly(TypeDefinition typeDefinition, int i11, StackManipulation stackManipulation) {
                        super(typeDefinition, i11, stackManipulation);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForVariable {
                    private final StackManipulation writeAssignment;

                    /* JADX WARNING: Illegal instructions before constructor call */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public ReadWrite(net.bytebuddy.description.type.TypeDefinition r2, int r3) {
                        /*
                            r1 = this;
                            net.bytebuddy.implementation.bytecode.StackManipulation$Trivial r0 = net.bytebuddy.implementation.bytecode.StackManipulation.Trivial.INSTANCE
                            r1.<init>(r2, r3, r0, r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.Target.ForVariable.ReadWrite.<init>(net.bytebuddy.description.type.TypeDefinition, int):void");
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.writeAssignment.equals(((ReadWrite) obj).writeAssignment);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.writeAssignment.hashCode();
                    }

                    public StackManipulation resolveIncrement(int i11) {
                        if (this.f27055a.represents(Integer.TYPE)) {
                            return MethodVariableAccess.of(this.f27055a).increment(this.f27056b, i11);
                        }
                        return new StackManipulation.Compound(resolveRead(), IntegerConstant.forValue(1), Addition.INTEGER, resolveWrite());
                    }

                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(this.writeAssignment, MethodVariableAccess.of(this.f27055a).storeAt(this.f27056b));
                    }

                    public ReadWrite(TypeDefinition typeDefinition, int i11, StackManipulation stackManipulation, StackManipulation stackManipulation2) {
                        super(typeDefinition, i11, stackManipulation);
                        this.writeAssignment = stackManipulation2;
                    }
                }

                public ForVariable(TypeDefinition typeDefinition, int i11, StackManipulation stackManipulation) {
                    this.f27055a = typeDefinition;
                    this.f27056b = i11;
                    this.f27057c = stackManipulation;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForVariable forVariable = (ForVariable) obj;
                    return this.f27056b == forVariable.f27056b && this.f27055a.equals(forVariable.f27055a) && this.f27057c.equals(forVariable.f27057c);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.f27055a.hashCode()) * 31) + this.f27056b) * 31) + this.f27057c.hashCode();
                }

                public StackManipulation resolveRead() {
                    return new StackManipulation.Compound(MethodVariableAccess.of(this.f27055a).loadFrom(this.f27056b), this.f27057c);
                }
            }

            StackManipulation resolveIncrement(int i11);

            StackManipulation resolveRead();

            StackManipulation resolveWrite();
        }

        Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort);

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForField implements OffsetMapping {
            /* access modifiers changed from: private */
            public static final MethodDescription.InDefinedShape DECLARING_TYPE;
            /* access modifiers changed from: private */
            public static final MethodDescription.InDefinedShape READ_ONLY;
            /* access modifiers changed from: private */
            public static final MethodDescription.InDefinedShape TYPING;
            /* access modifiers changed from: private */
            public static final MethodDescription.InDefinedShape VALUE;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved extends ForField {
                private final FieldDescription fieldDescription;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory<T extends Annotation> implements Factory<T> {
                    private final Class<T> annotationType;
                    private final FieldDescription fieldDescription;
                    private final boolean readOnly;
                    private final Assigner.Typing typing;

                    public Factory(Class<T> cls, FieldDescription fieldDescription2) {
                        this(cls, fieldDescription2, true, Assigner.Typing.STATIC);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Factory factory = (Factory) obj;
                        return this.readOnly == factory.readOnly && this.typing.equals(factory.typing) && this.annotationType.equals(factory.annotationType) && this.fieldDescription.equals(factory.fieldDescription);
                    }

                    public Class<T> getAnnotationType() {
                        return this.annotationType;
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.fieldDescription.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                        return new Resolved(inDefinedShape.getType(), this.readOnly, this.typing, this.fieldDescription);
                    }

                    public Factory(Class<T> cls, FieldDescription fieldDescription2, boolean z11, Assigner.Typing typing2) {
                        this.annotationType = cls;
                        this.fieldDescription = fieldDescription2;
                        this.readOnly = z11;
                        this.typing = typing2;
                    }
                }

                public Resolved(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing, FieldDescription fieldDescription2) {
                    super(generic, z11, typing);
                    this.fieldDescription = fieldDescription2;
                }

                public FieldDescription e(TypeDescription typeDescription, MethodDescription methodDescription) {
                    if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
                        throw new IllegalStateException(this.fieldDescription + " is no member of " + typeDescription);
                    } else if (this.fieldDescription.isAccessibleTo(typeDescription)) {
                        return this.fieldDescription;
                    } else {
                        throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                    }
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Resolved) obj).fieldDescription);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.fieldDescription.hashCode();
                }
            }

            static {
                MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldValue.class).getDeclaredMethods();
                VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                DECLARING_TYPE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("declaringType"))).getOnly();
                READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
            }

            public ForField(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing2) {
                this.target = generic;
                this.readOnly = z11;
                this.typing = typing2;
            }

            public abstract FieldDescription e(TypeDescription typeDescription, MethodDescription methodDescription);

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForField forField = (ForField) obj;
                return this.readOnly == forField.readOnly && this.typing.equals(forField.typing) && this.target.equals(forField.target);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                FieldDescription e11 = e(typeDescription, methodDescription);
                if (!e11.isStatic() && methodDescription.isStatic()) {
                    throw new IllegalStateException("Cannot read non-static field " + e11 + " from static method " + methodDescription);
                } else if (!sort.isPremature(methodDescription) || e11.isStatic()) {
                    StackManipulation assign = assigner.assign(e11.getType(), this.target, this.typing);
                    if (!assign.isValid()) {
                        throw new IllegalStateException("Cannot assign " + e11 + " to " + this.target);
                    } else if (this.readOnly) {
                        return new Target.ForField.ReadOnly(e11, assign);
                    } else {
                        StackManipulation assign2 = assigner.assign(this.target, e11.getType(), this.typing);
                        if (assign2.isValid()) {
                            return new Target.ForField.ReadWrite((FieldDescription) e11.asDefined(), assign, assign2);
                        }
                        throw new IllegalStateException("Cannot assign " + this.target + " to " + e11);
                    }
                } else {
                    throw new IllegalStateException("Cannot access non-static field before calling constructor: " + methodDescription);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Unresolved extends ForField {

                /* renamed from: name  reason: collision with root package name */
                private final String f27046name;

                public enum Factory implements Factory<FieldValue> {
                    INSTANCE;

                    public Class<FieldValue> getAnnotationType() {
                        return FieldValue.class;
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldValue> loadable, Factory.AdviceType adviceType) {
                        if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ForField.READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                            TypeDescription typeDescription = (TypeDescription) loadable.getValue(ForField.DECLARING_TYPE).resolve(TypeDescription.class);
                            if (typeDescription.represents(Void.TYPE)) {
                                return new WithImplicitType(inDefinedShape.getType(), loadable);
                            }
                            return new WithExplicitType(inDefinedShape.getType(), loadable, typeDescription);
                        }
                        throw new IllegalStateException("Cannot write to field for " + inDefinedShape + " in read-only context");
                    }
                }

                public Unresolved(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing, String str) {
                    super(generic, z11, typing);
                    this.f27046name = str;
                }

                /* access modifiers changed from: private */
                public static FieldLocator.Resolution resolveAccessor(FieldLocator fieldLocator, MethodDescription methodDescription) {
                    String str;
                    int i11 = 3;
                    if (ElementMatchers.isSetter().matches(methodDescription)) {
                        str = methodDescription.getInternalName().substring(3);
                    } else if (!ElementMatchers.isGetter().matches(methodDescription)) {
                        return FieldLocator.Resolution.Illegal.INSTANCE;
                    } else {
                        String internalName = methodDescription.getInternalName();
                        if (methodDescription.getInternalName().startsWith("is")) {
                            i11 = 2;
                        }
                        str = internalName.substring(i11);
                    }
                    return fieldLocator.locate(Character.toLowerCase(str.charAt(0)) + str.substring(1));
                }

                public FieldDescription e(TypeDescription typeDescription, MethodDescription methodDescription) {
                    FieldLocator.Resolution resolution;
                    FieldLocator g11 = g(typeDescription);
                    if (this.f27046name.equals("")) {
                        resolution = resolveAccessor(g11, methodDescription);
                    } else {
                        resolution = g11.locate(this.f27046name);
                    }
                    if (resolution.isResolved()) {
                        return resolution.getField();
                    }
                    throw new IllegalStateException("Cannot locate field named " + this.f27046name + " for " + typeDescription);
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.f27046name.equals(((Unresolved) obj).f27046name);
                }

                public abstract FieldLocator g(TypeDescription typeDescription);

                public int hashCode() {
                    return (super.hashCode() * 31) + this.f27046name.hashCode();
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithExplicitType extends Unresolved {
                    private final TypeDescription declaringType;

                    /* JADX WARNING: Illegal instructions before constructor call */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public WithExplicitType(net.bytebuddy.description.type.TypeDescription.Generic r8, net.bytebuddy.description.annotation.AnnotationDescription.Loadable<net.bytebuddy.asm.Advice.FieldValue> r9, net.bytebuddy.description.type.TypeDescription r10) {
                        /*
                            r7 = this;
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.READ_ONLY
                            net.bytebuddy.description.annotation.AnnotationValue r0 = r9.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
                            java.lang.Object r0 = r0.resolve(r1)
                            java.lang.Boolean r0 = (java.lang.Boolean) r0
                            boolean r3 = r0.booleanValue()
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.TYPING
                            net.bytebuddy.description.annotation.AnnotationValue r0 = r9.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                            java.lang.Class<net.bytebuddy.implementation.bytecode.assign.Assigner$Typing> r1 = net.bytebuddy.implementation.bytecode.assign.Assigner.Typing.class
                            java.lang.ClassLoader r2 = r1.getClassLoader()
                            net.bytebuddy.description.annotation.AnnotationValue$Loaded r0 = r0.load(r2)
                            java.lang.Object r0 = r0.resolve(r1)
                            r4 = r0
                            net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r4 = (net.bytebuddy.implementation.bytecode.assign.Assigner.Typing) r4
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.VALUE
                            net.bytebuddy.description.annotation.AnnotationValue r9 = r9.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                            java.lang.Class<java.lang.String> r0 = java.lang.String.class
                            java.lang.Object r9 = r9.resolve(r0)
                            r5 = r9
                            java.lang.String r5 = (java.lang.String) r5
                            r1 = r7
                            r2 = r8
                            r6 = r10
                            r1.<init>(r2, r3, r4, r5, r6)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved.WithExplicitType.<init>(net.bytebuddy.description.type.TypeDescription$Generic, net.bytebuddy.description.annotation.AnnotationDescription$Loadable, net.bytebuddy.description.type.TypeDescription):void");
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.declaringType.equals(((WithExplicitType) obj).declaringType);
                    }

                    public FieldLocator g(TypeDescription typeDescription) {
                        if (this.declaringType.represents(TargetType.class) || typeDescription.isAssignableTo(this.declaringType)) {
                            return new FieldLocator.ForExactType(TargetType.resolve(this.declaringType, typeDescription));
                        }
                        throw new IllegalStateException(this.declaringType + " is no super type of " + typeDescription);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.declaringType.hashCode();
                    }

                    public WithExplicitType(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing, String str, TypeDescription typeDescription) {
                        super(generic, z11, typing, str);
                        this.declaringType = typeDescription;
                    }
                }

                public static class WithImplicitType extends Unresolved {
                    /* JADX WARNING: Illegal instructions before constructor call */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public WithImplicitType(net.bytebuddy.description.type.TypeDescription.Generic r5, net.bytebuddy.description.annotation.AnnotationDescription.Loadable<net.bytebuddy.asm.Advice.FieldValue> r6) {
                        /*
                            r4 = this;
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.READ_ONLY
                            net.bytebuddy.description.annotation.AnnotationValue r0 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
                            java.lang.Object r0 = r0.resolve(r1)
                            java.lang.Boolean r0 = (java.lang.Boolean) r0
                            boolean r0 = r0.booleanValue()
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r1 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.TYPING
                            net.bytebuddy.description.annotation.AnnotationValue r1 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r1)
                            java.lang.Class<net.bytebuddy.implementation.bytecode.assign.Assigner$Typing> r2 = net.bytebuddy.implementation.bytecode.assign.Assigner.Typing.class
                            java.lang.ClassLoader r3 = r2.getClassLoader()
                            net.bytebuddy.description.annotation.AnnotationValue$Loaded r1 = r1.load(r3)
                            java.lang.Object r1 = r1.resolve(r2)
                            net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r1 = (net.bytebuddy.implementation.bytecode.assign.Assigner.Typing) r1
                            net.bytebuddy.description.method.MethodDescription$InDefinedShape r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForField.VALUE
                            net.bytebuddy.description.annotation.AnnotationValue r6 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r2)
                            java.lang.Class<java.lang.String> r2 = java.lang.String.class
                            java.lang.Object r6 = r6.resolve(r2)
                            java.lang.String r6 = (java.lang.String) r6
                            r4.<init>(r5, r0, r1, r6)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved.WithImplicitType.<init>(net.bytebuddy.description.type.TypeDescription$Generic, net.bytebuddy.description.annotation.AnnotationDescription$Loadable):void");
                    }

                    public FieldLocator g(TypeDescription typeDescription) {
                        return new FieldLocator.ForClassHierarchy(typeDescription);
                    }

                    public WithImplicitType(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing, String str) {
                        super(generic, z11, typing, str);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForEnterValue implements OffsetMapping {
            private final TypeDescription.Generic enterType;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory<Enter> {
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ENTER_READ_ONLY;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ENTER_TYPING;
                private final TypeDefinition enterType;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Enter.class).getDeclaredMethods();
                    ENTER_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    ENTER_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                }

                public Factory(TypeDefinition typeDefinition) {
                    this.enterType = typeDefinition;
                }

                public static Factory<Enter> c(TypeDefinition typeDefinition) {
                    return typeDefinition.represents(Void.TYPE) ? new Factory.Illegal(Enter.class) : new Factory(typeDefinition);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.enterType.equals(((Factory) obj).enterType);
                }

                public Class<Enter> getAnnotationType() {
                    return Enter.class;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.enterType.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Enter> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ENTER_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForEnterValue(inDefinedShape.getType(), this.enterType.asGenericType(), loadable);
                    }
                    throw new IllegalStateException("Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            public ForEnterValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, AnnotationDescription.Loadable<Enter> loadable) {
                this(generic, generic2, ((Boolean) loadable.getValue(Factory.ENTER_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) loadable.getValue(Factory.ENTER_TYPING).load(Enter.class.getClassLoader()).resolve(Assigner.Typing.class));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForEnterValue forEnterValue = (ForEnterValue) obj;
                return this.readOnly == forEnterValue.readOnly && this.typing.equals(forEnterValue.typing) && this.target.equals(forEnterValue.target) && this.enterType.equals(forEnterValue.enterType);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.enterType.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(this.enterType, this.target, this.typing);
                if (!assign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + this.enterType + " to " + this.target);
                } else if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(this.target, argumentHandler.enter(), assign);
                } else {
                    StackManipulation assign2 = assigner.assign(this.target, this.enterType, this.typing);
                    if (assign2.isValid()) {
                        return new Target.ForVariable.ReadWrite(this.target, argumentHandler.enter(), assign, assign2);
                    }
                    throw new IllegalStateException("Cannot assign " + this.target + " to " + this.enterType);
                }
            }

            public ForEnterValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, boolean z11, Assigner.Typing typing2) {
                this.target = generic;
                this.enterType = generic2;
                this.readOnly = z11;
                this.typing = typing2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForExitValue implements OffsetMapping {
            private final TypeDescription.Generic exitType;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory<Exit> {
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape EXIT_READ_ONLY;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape EXIT_TYPING;
                private final TypeDefinition exitType;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Exit.class).getDeclaredMethods();
                    EXIT_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    EXIT_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                }

                public Factory(TypeDefinition typeDefinition) {
                    this.exitType = typeDefinition;
                }

                public static Factory<Exit> c(TypeDefinition typeDefinition) {
                    return typeDefinition.represents(Void.TYPE) ? new Factory.Illegal(Exit.class) : new Factory(typeDefinition);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.exitType.equals(((Factory) obj).exitType);
                }

                public Class<Exit> getAnnotationType() {
                    return Exit.class;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.exitType.hashCode();
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Exit> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(EXIT_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForExitValue(inDefinedShape.getType(), this.exitType.asGenericType(), loadable);
                    }
                    throw new IllegalStateException("Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            public ForExitValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, AnnotationDescription.Loadable<Exit> loadable) {
                this(generic, generic2, ((Boolean) loadable.getValue(Factory.EXIT_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) loadable.getValue(Factory.EXIT_TYPING).load(Exit.class.getClassLoader()).resolve(Assigner.Typing.class));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForExitValue forExitValue = (ForExitValue) obj;
                return this.readOnly == forExitValue.readOnly && this.typing.equals(forExitValue.typing) && this.target.equals(forExitValue.target) && this.exitType.equals(forExitValue.exitType);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.exitType.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(this.exitType, this.target, this.typing);
                if (!assign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + this.exitType + " to " + this.target);
                } else if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(this.target, argumentHandler.exit(), assign);
                } else {
                    StackManipulation assign2 = assigner.assign(this.target, this.exitType, this.typing);
                    if (assign2.isValid()) {
                        return new Target.ForVariable.ReadWrite(this.target, argumentHandler.exit(), assign, assign2);
                    }
                    throw new IllegalStateException("Cannot assign " + this.target + " to " + this.exitType);
                }
            }

            public ForExitValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, boolean z11, Assigner.Typing typing2) {
                this.target = generic;
                this.exitType = generic2;
                this.readOnly = z11;
                this.typing = typing2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForReturnValue implements OffsetMapping {
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            public enum Factory implements Factory<Return> {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape RETURN_READ_ONLY = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape RETURN_TYPING = null;

                /* access modifiers changed from: public */
                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Return.class).getDeclaredMethods();
                    RETURN_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    RETURN_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                }

                public Class<Return> getAnnotationType() {
                    return Return.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Return> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(RETURN_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForReturnValue(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException("Cannot write return value for " + inDefinedShape + " in read-only context");
                }
            }

            public ForReturnValue(TypeDescription.Generic generic, AnnotationDescription.Loadable<Return> loadable) {
                this(generic, ((Boolean) loadable.getValue(Factory.RETURN_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) loadable.getValue(Factory.RETURN_TYPING).load(Return.class.getClassLoader()).resolve(Assigner.Typing.class));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForReturnValue forReturnValue = (ForReturnValue) obj;
                return this.readOnly == forReturnValue.readOnly && this.typing.equals(forReturnValue.typing) && this.target.equals(forReturnValue.target);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation assign = assigner.assign(methodDescription.getReturnType(), this.target, this.typing);
                if (!assign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + methodDescription.getReturnType() + " to " + this.target);
                } else if (!this.readOnly) {
                    StackManipulation assign2 = assigner.assign(this.target, methodDescription.getReturnType(), this.typing);
                    if (!assign2.isValid()) {
                        throw new IllegalStateException("Cannot assign " + this.target + " to " + methodDescription.getReturnType());
                    } else if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return new Target.ForDefaultValue.ReadWrite(this.target);
                    } else {
                        return new Target.ForVariable.ReadWrite(methodDescription.getReturnType(), argumentHandler.returned(), assign, assign2);
                    }
                } else if (methodDescription.getReturnType().represents(Void.TYPE)) {
                    return new Target.ForDefaultValue.ReadOnly(this.target);
                } else {
                    return new Target.ForVariable.ReadOnly(methodDescription.getReturnType(), argumentHandler.returned(), assign);
                }
            }

            public ForReturnValue(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing2) {
                this.target = generic;
                this.readOnly = z11;
                this.typing = typing2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForThrowable implements OffsetMapping {
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            public enum Factory implements Factory<Thrown> {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape THROWN_READ_ONLY = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape THROWN_TYPING = null;

                /* access modifiers changed from: public */
                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Thrown.class).getDeclaredMethods();
                    THROWN_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    THROWN_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                }

                public static Factory<?> c(MethodDescription.InDefinedShape inDefinedShape) {
                    if (((TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class)).represents(NoExceptionHandler.class)) {
                        return new Factory.Illegal(Thrown.class);
                    }
                    return INSTANCE;
                }

                public Class<Thrown> getAnnotationType() {
                    return Thrown.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Thrown> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(THROWN_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForThrowable(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException("Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            public ForThrowable(TypeDescription.Generic generic, AnnotationDescription.Loadable<Thrown> loadable) {
                this(generic, ((Boolean) loadable.getValue(Factory.THROWN_READ_ONLY).resolve(Boolean.class)).booleanValue(), (Assigner.Typing) loadable.getValue(Factory.THROWN_TYPING).load(Thrown.class.getClassLoader()).resolve(Assigner.Typing.class));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForThrowable forThrowable = (ForThrowable) obj;
                return this.readOnly == forThrowable.readOnly && this.typing.equals(forThrowable.typing) && this.target.equals(forThrowable.target);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                TypeDescription typeDescription2 = TypeDescription.THROWABLE;
                StackManipulation assign = assigner.assign(typeDescription2.asGenericType(), this.target, this.typing);
                if (!assign.isValid()) {
                    throw new IllegalStateException("Cannot assign Throwable to " + this.target);
                } else if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(typeDescription2, argumentHandler.thrown(), assign);
                } else {
                    StackManipulation assign2 = assigner.assign(this.target, typeDescription2.asGenericType(), this.typing);
                    if (assign2.isValid()) {
                        return new Target.ForVariable.ReadWrite(typeDescription2, argumentHandler.thrown(), assign, assign2);
                    }
                    throw new IllegalStateException("Cannot assign " + this.target + " to Throwable");
                }
            }

            public ForThrowable(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing2) {
                this.target = generic;
                this.readOnly = z11;
                this.typing = typing2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForAllArguments implements OffsetMapping {
            private final boolean nullIfEmpty;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            public enum Factory implements Factory<AllArguments> {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ALL_ARGUMENTS_NULL_IF_EMPTY = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ALL_ARGUMENTS_READ_ONLY = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape ALL_ARGUMENTS_TYPING = null;

                /* access modifiers changed from: public */
                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(AllArguments.class).getDeclaredMethods();
                    ALL_ARGUMENTS_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    ALL_ARGUMENTS_NULL_IF_EMPTY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("nullIfEmpty"))).getOnly();
                }

                public Class<AllArguments> getAnnotationType() {
                    return AllArguments.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<AllArguments> loadable, Factory.AdviceType adviceType) {
                    TypeDescription.Generic generic;
                    Class<Object> cls = Object.class;
                    if (!inDefinedShape.getType().represents(cls) && !inDefinedShape.getType().isArray()) {
                        throw new IllegalStateException("Cannot use AllArguments annotation on a non-array type");
                    } else if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ALL_ARGUMENTS_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        if (inDefinedShape.getType().represents(cls)) {
                            generic = TypeDescription.Generic.OBJECT;
                        } else {
                            generic = inDefinedShape.getType().getComponentType();
                        }
                        return new ForAllArguments(generic, loadable);
                    } else {
                        throw new IllegalStateException("Cannot define writable field access for " + inDefinedShape);
                    }
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public ForAllArguments(net.bytebuddy.description.type.TypeDescription.Generic r5, net.bytebuddy.description.annotation.AnnotationDescription.Loadable<net.bytebuddy.asm.Advice.AllArguments> r6) {
                /*
                    r4 = this;
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.ALL_ARGUMENTS_READ_ONLY
                    net.bytebuddy.description.annotation.AnnotationValue r0 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                    java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
                    java.lang.Object r0 = r0.resolve(r1)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.ALL_ARGUMENTS_TYPING
                    net.bytebuddy.description.annotation.AnnotationValue r2 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r2)
                    java.lang.Class<net.bytebuddy.asm.Advice$AllArguments> r3 = net.bytebuddy.asm.Advice.AllArguments.class
                    java.lang.ClassLoader r3 = r3.getClassLoader()
                    net.bytebuddy.description.annotation.AnnotationValue$Loaded r2 = r2.load(r3)
                    java.lang.Class<net.bytebuddy.implementation.bytecode.assign.Assigner$Typing> r3 = net.bytebuddy.implementation.bytecode.assign.Assigner.Typing.class
                    java.lang.Object r2 = r2.resolve(r3)
                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = (net.bytebuddy.implementation.bytecode.assign.Assigner.Typing) r2
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r3 = net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.Factory.ALL_ARGUMENTS_NULL_IF_EMPTY
                    net.bytebuddy.description.annotation.AnnotationValue r6 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r3)
                    java.lang.Object r6 = r6.resolve(r1)
                    java.lang.Boolean r6 = (java.lang.Boolean) r6
                    boolean r6 = r6.booleanValue()
                    r4.<init>(r5, r0, r2, r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments.<init>(net.bytebuddy.description.type.TypeDescription$Generic, net.bytebuddy.description.annotation.AnnotationDescription$Loadable):void");
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForAllArguments forAllArguments = (ForAllArguments) obj;
                return this.readOnly == forAllArguments.readOnly && this.nullIfEmpty == forAllArguments.nullIfEmpty && this.typing.equals(forAllArguments.typing) && this.target.equals(forAllArguments.target);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode()) * 31) + (this.nullIfEmpty ? 1 : 0);
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (!this.nullIfEmpty || !methodDescription.getParameters().isEmpty()) {
                    ArrayList arrayList = new ArrayList(methodDescription.getParameters().size());
                    Iterator<E> it = methodDescription.getParameters().iterator();
                    while (it.hasNext()) {
                        ParameterDescription parameterDescription = (ParameterDescription) it.next();
                        StackManipulation assign = assigner.assign(parameterDescription.getType(), this.target, this.typing);
                        if (assign.isValid()) {
                            arrayList.add(new StackManipulation.Compound(MethodVariableAccess.of(parameterDescription.getType()).loadFrom(argumentHandler.argument(parameterDescription.getOffset())), assign));
                        } else {
                            throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + this.target);
                        }
                    }
                    if (this.readOnly) {
                        return new Target.ForArray.ReadOnly(this.target, arrayList);
                    }
                    ArrayList arrayList2 = new ArrayList(methodDescription.getParameters().size());
                    Iterator<E> it2 = methodDescription.getParameters().iterator();
                    while (it2.hasNext()) {
                        ParameterDescription parameterDescription2 = (ParameterDescription) it2.next();
                        StackManipulation assign2 = assigner.assign(this.target, parameterDescription2.getType(), this.typing);
                        if (assign2.isValid()) {
                            arrayList2.add(new StackManipulation.Compound(assign2, MethodVariableAccess.of(parameterDescription2.getType()).storeAt(argumentHandler.argument(parameterDescription2.getOffset()))));
                        } else {
                            throw new IllegalStateException("Cannot assign " + this.target + " to " + parameterDescription2);
                        }
                    }
                    return new Target.ForArray.ReadWrite(this.target, arrayList, arrayList2);
                } else if (this.readOnly) {
                    return new Target.ForStackManipulation(NullConstant.INSTANCE);
                } else {
                    return new Target.ForStackManipulation.Writable(NullConstant.INSTANCE, Removal.SINGLE);
                }
            }

            public ForAllArguments(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing2, boolean z12) {
                this.target = generic;
                this.readOnly = z11;
                this.typing = typing2;
                this.nullIfEmpty = z12;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForArgument implements OffsetMapping {

            /* renamed from: b  reason: collision with root package name */
            public final TypeDescription.Generic f27044b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f27045c;
            private final Assigner.Typing typing;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved extends ForArgument {
                private final ParameterDescription parameterDescription;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory<T extends Annotation> implements Factory<T> {
                    private final Class<T> annotationType;
                    private final ParameterDescription parameterDescription;
                    private final boolean readOnly;
                    private final Assigner.Typing typing;

                    public Factory(Class<T> cls, ParameterDescription parameterDescription2) {
                        this(cls, parameterDescription2, true, Assigner.Typing.STATIC);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Factory factory = (Factory) obj;
                        return this.readOnly == factory.readOnly && this.typing.equals(factory.typing) && this.annotationType.equals(factory.annotationType) && this.parameterDescription.equals(factory.parameterDescription);
                    }

                    public Class<T> getAnnotationType() {
                        return this.annotationType;
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.parameterDescription.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode();
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                        return new Resolved(inDefinedShape.getType(), this.readOnly, this.typing, this.parameterDescription);
                    }

                    public Factory(Class<T> cls, ParameterDescription parameterDescription2, boolean z11, Assigner.Typing typing2) {
                        this.annotationType = cls;
                        this.parameterDescription = parameterDescription2;
                        this.readOnly = z11;
                        this.typing = typing2;
                    }
                }

                public Resolved(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing, ParameterDescription parameterDescription2) {
                    super(generic, z11, typing);
                    this.parameterDescription = parameterDescription2;
                }

                public ParameterDescription a(MethodDescription methodDescription) {
                    if (this.parameterDescription.getDeclaringMethod().equals(methodDescription)) {
                        return this.parameterDescription;
                    }
                    throw new IllegalStateException(this.parameterDescription + " is not a parameter of " + methodDescription);
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.parameterDescription.equals(((Resolved) obj).parameterDescription);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.parameterDescription.hashCode();
                }
            }

            public ForArgument(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing2) {
                this.f27044b = generic;
                this.f27045c = z11;
                this.typing = typing2;
            }

            public abstract ParameterDescription a(MethodDescription methodDescription);

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForArgument forArgument = (ForArgument) obj;
                return this.f27045c == forArgument.f27045c && this.typing.equals(forArgument.typing) && this.f27044b.equals(forArgument.f27044b);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.f27044b.hashCode()) * 31) + (this.f27045c ? 1 : 0)) * 31) + this.typing.hashCode();
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                ParameterDescription a11 = a(methodDescription);
                StackManipulation assign = assigner.assign(a11.getType(), this.f27044b, this.typing);
                if (!assign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + a11 + " to " + this.f27044b);
                } else if (this.f27045c) {
                    return new Target.ForVariable.ReadOnly(a11.getType(), argumentHandler.argument(a11.getOffset()), assign);
                } else {
                    StackManipulation assign2 = assigner.assign(this.f27044b, a11.getType(), this.typing);
                    if (assign2.isValid()) {
                        return new Target.ForVariable.ReadWrite(a11.getType(), argumentHandler.argument(a11.getOffset()), assign, assign2);
                    }
                    throw new IllegalStateException("Cannot assign " + a11 + " to " + this.f27044b);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unresolved extends ForArgument {
                private final int index;
                private final boolean optional;

                public enum Factory implements Factory<Argument> {
                    INSTANCE;
                    
                    /* access modifiers changed from: private */
                    public static final MethodDescription.InDefinedShape ARGUMENT_OPTIONAL = null;
                    /* access modifiers changed from: private */
                    public static final MethodDescription.InDefinedShape ARGUMENT_READ_ONLY = null;
                    /* access modifiers changed from: private */
                    public static final MethodDescription.InDefinedShape ARGUMENT_TYPING = null;
                    /* access modifiers changed from: private */
                    public static final MethodDescription.InDefinedShape ARGUMENT_VALUE = null;

                    /* access modifiers changed from: public */
                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Argument.class).getDeclaredMethods();
                        ARGUMENT_VALUE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("value"))).getOnly();
                        ARGUMENT_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                        ARGUMENT_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                        ARGUMENT_OPTIONAL = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("optional"))).getOnly();
                    }

                    public Class<Argument> getAnnotationType() {
                        return Argument.class;
                    }

                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Argument> loadable, Factory.AdviceType adviceType) {
                        if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(ARGUMENT_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                            return new Unresolved(inDefinedShape.getType(), loadable);
                        }
                        throw new IllegalStateException("Cannot define writable field access for " + inDefinedShape + " when using delegation");
                    }
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public Unresolved(net.bytebuddy.description.type.TypeDescription.Generic r9, net.bytebuddy.description.annotation.AnnotationDescription.Loadable<net.bytebuddy.asm.Advice.Argument> r10) {
                    /*
                        r8 = this;
                        net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.ARGUMENT_READ_ONLY
                        net.bytebuddy.description.annotation.AnnotationValue r0 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                        java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
                        java.lang.Object r0 = r0.resolve(r1)
                        java.lang.Boolean r0 = (java.lang.Boolean) r0
                        boolean r4 = r0.booleanValue()
                        net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.ARGUMENT_TYPING
                        net.bytebuddy.description.annotation.AnnotationValue r0 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                        java.lang.Class<net.bytebuddy.asm.Advice$Argument> r2 = net.bytebuddy.asm.Advice.Argument.class
                        java.lang.ClassLoader r2 = r2.getClassLoader()
                        net.bytebuddy.description.annotation.AnnotationValue$Loaded r0 = r0.load(r2)
                        java.lang.Class<net.bytebuddy.implementation.bytecode.assign.Assigner$Typing> r2 = net.bytebuddy.implementation.bytecode.assign.Assigner.Typing.class
                        java.lang.Object r0 = r0.resolve(r2)
                        r5 = r0
                        net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r5 = (net.bytebuddy.implementation.bytecode.assign.Assigner.Typing) r5
                        net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.ARGUMENT_VALUE
                        net.bytebuddy.description.annotation.AnnotationValue r0 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                        java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
                        java.lang.Object r0 = r0.resolve(r2)
                        java.lang.Integer r0 = (java.lang.Integer) r0
                        int r6 = r0.intValue()
                        net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.Factory.ARGUMENT_OPTIONAL
                        net.bytebuddy.description.annotation.AnnotationValue r10 = r10.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                        java.lang.Object r10 = r10.resolve(r1)
                        java.lang.Boolean r10 = (java.lang.Boolean) r10
                        boolean r7 = r10.booleanValue()
                        r2 = r8
                        r3 = r9
                        r2.<init>(r3, r4, r5, r6, r7)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.ForArgument.Unresolved.<init>(net.bytebuddy.description.type.TypeDescription$Generic, net.bytebuddy.description.annotation.AnnotationDescription$Loadable):void");
                }

                public ParameterDescription a(MethodDescription methodDescription) {
                    ParameterList<?> parameters = methodDescription.getParameters();
                    int size = parameters.size();
                    int i11 = this.index;
                    if (size > i11) {
                        return (ParameterDescription) parameters.get(i11);
                    }
                    throw new IllegalStateException(methodDescription + " does not define an index " + this.index);
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Unresolved unresolved = (Unresolved) obj;
                    return this.index == unresolved.index && this.optional == unresolved.optional;
                }

                public int hashCode() {
                    return (((super.hashCode() * 31) + this.index) * 31) + (this.optional ? 1 : 0);
                }

                public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                    if (!this.optional || methodDescription.getParameters().size() > this.index) {
                        return super.resolve(typeDescription, methodDescription, assigner, argumentHandler, sort);
                    }
                    if (this.f27045c) {
                        return new Target.ForDefaultValue.ReadOnly(this.f27044b);
                    }
                    return new Target.ForDefaultValue.ReadWrite(this.f27044b);
                }

                public Unresolved(ParameterDescription parameterDescription) {
                    this(parameterDescription.getType(), true, Assigner.Typing.STATIC, parameterDescription.getIndex());
                }

                public Unresolved(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing, int i11) {
                    this(generic, z11, typing, i11, false);
                }

                public Unresolved(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing, int i11, boolean z12) {
                    super(generic, z11, typing);
                    this.index = i11;
                    this.optional = z12;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForThisReference implements OffsetMapping {
            private final boolean optional;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            public enum Factory implements Factory<This> {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape THIS_OPTIONAL = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape THIS_READ_ONLY = null;
                /* access modifiers changed from: private */
                public static final MethodDescription.InDefinedShape THIS_TYPING = null;

                /* access modifiers changed from: public */
                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(This.class).getDeclaredMethods();
                    THIS_READ_ONLY = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("readOnly"))).getOnly();
                    THIS_TYPING = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("typing"))).getOnly();
                    THIS_OPTIONAL = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("optional"))).getOnly();
                }

                public Class<This> getAnnotationType() {
                    return This.class;
                }

                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<This> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation() || ((Boolean) loadable.getValue(THIS_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForThisReference(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException("Cannot write to this reference for " + inDefinedShape + " in read-only context");
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public ForThisReference(net.bytebuddy.description.type.TypeDescription.Generic r5, net.bytebuddy.description.annotation.AnnotationDescription.Loadable<net.bytebuddy.asm.Advice.This> r6) {
                /*
                    r4 = this;
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.THIS_READ_ONLY
                    net.bytebuddy.description.annotation.AnnotationValue r0 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r0)
                    java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
                    java.lang.Object r0 = r0.resolve(r1)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r2 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.THIS_TYPING
                    net.bytebuddy.description.annotation.AnnotationValue r2 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r2)
                    java.lang.Class<net.bytebuddy.asm.Advice$This> r3 = net.bytebuddy.asm.Advice.This.class
                    java.lang.ClassLoader r3 = r3.getClassLoader()
                    net.bytebuddy.description.annotation.AnnotationValue$Loaded r2 = r2.load(r3)
                    java.lang.Class<net.bytebuddy.implementation.bytecode.assign.Assigner$Typing> r3 = net.bytebuddy.implementation.bytecode.assign.Assigner.Typing.class
                    java.lang.Object r2 = r2.resolve(r3)
                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = (net.bytebuddy.implementation.bytecode.assign.Assigner.Typing) r2
                    net.bytebuddy.description.method.MethodDescription$InDefinedShape r3 = net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.Factory.THIS_OPTIONAL
                    net.bytebuddy.description.annotation.AnnotationValue r6 = r6.getValue((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r3)
                    java.lang.Object r6 = r6.resolve(r1)
                    java.lang.Boolean r6 = (java.lang.Boolean) r6
                    boolean r6 = r6.booleanValue()
                    r4.<init>(r5, r0, r2, r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.OffsetMapping.ForThisReference.<init>(net.bytebuddy.description.type.TypeDescription$Generic, net.bytebuddy.description.annotation.AnnotationDescription$Loadable):void");
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForThisReference forThisReference = (ForThisReference) obj;
                return this.readOnly == forThisReference.readOnly && this.optional == forThisReference.optional && this.typing.equals(forThisReference.typing) && this.target.equals(forThisReference.target);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + (this.readOnly ? 1 : 0)) * 31) + this.typing.hashCode()) * 31) + (this.optional ? 1 : 0);
            }

            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (!methodDescription.isStatic() && !sort.isPremature(methodDescription)) {
                    StackManipulation assign = assigner.assign(typeDescription.asGenericType(), this.target, this.typing);
                    if (!assign.isValid()) {
                        throw new IllegalStateException("Cannot assign " + typeDescription + " to " + this.target);
                    } else if (this.readOnly) {
                        return new Target.ForVariable.ReadOnly(typeDescription.asGenericType(), argumentHandler.argument(0), assign);
                    } else {
                        StackManipulation assign2 = assigner.assign(this.target, typeDescription.asGenericType(), this.typing);
                        if (assign2.isValid()) {
                            return new Target.ForVariable.ReadWrite(typeDescription.asGenericType(), argumentHandler.argument(0), assign, assign2);
                        }
                        throw new IllegalStateException("Cannot assign " + this.target + " to " + typeDescription);
                    }
                } else if (!this.optional) {
                    throw new IllegalStateException("Cannot map this reference for static method or constructor start: " + methodDescription);
                } else if (this.readOnly) {
                    return new Target.ForDefaultValue.ReadOnly(typeDescription);
                } else {
                    return new Target.ForDefaultValue.ReadWrite(typeDescription);
                }
            }

            public ForThisReference(TypeDescription.Generic generic, boolean z11, Assigner.Typing typing2, boolean z12) {
                this.target = generic;
                this.readOnly = z11;
                this.typing = typing2;
                this.optional = z12;
            }
        }
    }

    public static final class OnDefaultValue {
        private OnDefaultValue() {
            throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
        }
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OnMethodEnter {
        boolean inline() default true;

        boolean prependLineNumber() default true;

        Class<?> skipOn() default void.class;

        Class<? extends Throwable> suppress() default NoExceptionHandler.class;
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OnMethodExit {
        boolean backupArguments() default true;

        boolean inline() default true;

        Class<? extends Throwable> onThrowable() default NoExceptionHandler.class;

        Class<?> repeatOn() default void.class;

        Class<? extends Throwable> suppress() default NoExceptionHandler.class;
    }

    public static final class OnNonDefaultValue {
        private OnNonDefaultValue() {
            throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
        }
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Origin {
        public static final String DEFAULT = "";

        String value() default "";
    }

    public interface PostProcessor {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements PostProcessor {
            private final List<PostProcessor> postProcessors;

            public Compound(List<PostProcessor> list) {
                this.postProcessors = list;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.postProcessors.equals(((Compound) obj).postProcessors);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.postProcessors.hashCode();
            }

            public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler) {
                ArrayList arrayList = new ArrayList(this.postProcessors.size());
                for (PostProcessor resolve : this.postProcessors) {
                    arrayList.add(resolve.resolve(typeDescription, methodDescription, assigner, argumentHandler));
                }
                return new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
            }
        }

        public interface Factory {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Factory {
                private final List<Factory> factories;

                public Compound(Factory... factoryArr) {
                    this((List<? extends Factory>) Arrays.asList(factoryArr));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.factories.equals(((Compound) obj).factories);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.factories.hashCode();
                }

                public PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z11) {
                    ArrayList arrayList = new ArrayList(this.factories.size());
                    for (Factory make : this.factories) {
                        arrayList.add(make.make(inDefinedShape, z11));
                    }
                    return new Compound(arrayList);
                }

                public Compound(List<? extends Factory> list) {
                    this.factories = new ArrayList();
                    for (Factory factory : list) {
                        if (factory instanceof Compound) {
                            this.factories.addAll(((Compound) factory).factories);
                        } else if (!(factory instanceof NoOp)) {
                            this.factories.add(factory);
                        }
                    }
                }
            }

            PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z11);
        }

        public enum NoOp implements PostProcessor, Factory {
            INSTANCE;

            public PostProcessor make(MethodDescription.InDefinedShape inDefinedShape, boolean z11) {
                return this;
            }

            public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler) {
                return StackManipulation.Trivial.INSTANCE;
            }
        }

        StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, ArgumentHandler argumentHandler);
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Return {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    public interface StackMapFrameHandler {

        public static abstract class Default implements ForInstrumentedMethod {

            /* renamed from: i  reason: collision with root package name */
            public static final Object[] f27058i = new Object[0];

            /* renamed from: b  reason: collision with root package name */
            public final TypeDescription f27059b;

            /* renamed from: c  reason: collision with root package name */
            public final MethodDescription f27060c;

            /* renamed from: d  reason: collision with root package name */
            public final List<? extends TypeDescription> f27061d;

            /* renamed from: e  reason: collision with root package name */
            public final List<? extends TypeDescription> f27062e;

            /* renamed from: f  reason: collision with root package name */
            public final List<? extends TypeDescription> f27063f;

            /* renamed from: g  reason: collision with root package name */
            public final boolean f27064g;

            /* renamed from: h  reason: collision with root package name */
            public int f27065h;

            public class ForAdvice implements ForAdvice {

                /* renamed from: b  reason: collision with root package name */
                public final MethodDescription.InDefinedShape f27066b;

                /* renamed from: c  reason: collision with root package name */
                public final List<? extends TypeDescription> f27067c;

                /* renamed from: d  reason: collision with root package name */
                public final List<? extends TypeDescription> f27068d;

                /* renamed from: e  reason: collision with root package name */
                public final TranslationMode f27069e;
                private final Initialization initialization;

                public ForAdvice(MethodDescription.InDefinedShape inDefinedShape, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, TranslationMode translationMode, Initialization initialization2) {
                    this.f27066b = inDefinedShape;
                    this.f27067c = list;
                    this.f27068d = list2;
                    this.f27069e = translationMode;
                    this.initialization = initialization2;
                }

                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    Default defaultR = Default.this;
                    if (defaultR.f27064g) {
                        defaultR.a(methodVisitor, this.initialization, CompoundList.of(this.f27067c, this.f27068d), Collections.emptyList());
                    } else if (defaultR.f27065h != 0 || this.f27068d.size() >= 4) {
                        if (Default.this.f27065h >= 3 || !this.f27068d.isEmpty()) {
                            Default.this.a(methodVisitor, this.initialization, CompoundList.of(this.f27067c, this.f27068d), Collections.emptyList());
                            return;
                        }
                        int i11 = Default.this.f27065h;
                        Object[] objArr = Default.f27058i;
                        methodVisitor.visitFrame(2, i11, objArr, objArr.length, objArr);
                    } else if (this.f27068d.isEmpty()) {
                        Object[] objArr2 = Default.f27058i;
                        methodVisitor.visitFrame(3, objArr2.length, objArr2, objArr2.length, objArr2);
                    } else {
                        int size = this.f27068d.size();
                        Object[] objArr3 = new Object[size];
                        int i12 = 0;
                        for (TypeDescription a11 : this.f27068d) {
                            objArr3[i12] = Initialization.INITIALIZED.a(a11);
                            i12++;
                        }
                        Object[] objArr4 = Default.f27058i;
                        methodVisitor.visitFrame(1, size, objArr3, objArr4.length, objArr4);
                    }
                }

                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    Default defaultR = Default.this;
                    if (defaultR.f27064g || defaultR.f27065h != 0) {
                        defaultR.a(methodVisitor, this.initialization, this.f27067c, Collections.singletonList(TypeDescription.THROWABLE));
                        return;
                    }
                    Object[] objArr = Default.f27058i;
                    methodVisitor.visitFrame(4, objArr.length, objArr, 1, new Object[]{Type.getInternalName(Throwable.class)});
                }

                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    List list;
                    Default defaultR = Default.this;
                    if (defaultR.f27064g || defaultR.f27065h != 0) {
                        Initialization initialization2 = this.initialization;
                        List<? extends TypeDescription> list2 = this.f27067c;
                        if (this.f27066b.getReturnType().represents(Void.TYPE)) {
                            list = Collections.emptyList();
                        } else {
                            list = Collections.singletonList(this.f27066b.getReturnType().asErasure());
                        }
                        defaultR.a(methodVisitor, initialization2, list2, list);
                    } else if (this.f27066b.getReturnType().represents(Void.TYPE)) {
                        Object[] objArr = Default.f27058i;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    } else {
                        Object[] objArr2 = Default.f27058i;
                        methodVisitor.visitFrame(4, objArr2.length, objArr2, 1, new Object[]{Initialization.INITIALIZED.a(this.f27066b.getReturnType().asErasure())});
                    }
                }

                public void translateFrame(MethodVisitor methodVisitor, int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
                    Default.this.c(methodVisitor, this.f27069e, this.f27066b, this.f27067c, i11, i12, objArr, i13, objArr2);
                }
            }

            public enum Initialization {
                UNITIALIZED {
                    public Object a(TypeDescription typeDescription) {
                        return Opcodes.UNINITIALIZED_THIS;
                    }
                },
                INITIALIZED {
                    public Object a(TypeDescription typeDescription) {
                        if (typeDescription.represents(Boolean.TYPE) || typeDescription.represents(Byte.TYPE) || typeDescription.represents(Short.TYPE) || typeDescription.represents(Character.TYPE) || typeDescription.represents(Integer.TYPE)) {
                            return Opcodes.INTEGER;
                        }
                        if (typeDescription.represents(Long.TYPE)) {
                            return Opcodes.LONG;
                        }
                        if (typeDescription.represents(Float.TYPE)) {
                            return Opcodes.FLOAT;
                        }
                        if (typeDescription.represents(Double.TYPE)) {
                            return Opcodes.DOUBLE;
                        }
                        return typeDescription.getInternalName();
                    }
                };

                public abstract Object a(TypeDescription typeDescription);
            }

            public enum TranslationMode {
                COPY {
                    public int a(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2) {
                        int size = methodDescription.getParameters().size() + (methodDescription.isStatic() ^ true ? 1 : 0);
                        System.arraycopy(objArr, 0, objArr2, 0, size);
                        return size;
                    }

                    public boolean b(TypeDescription typeDescription, MethodDescription methodDescription, Object obj) {
                        return (methodDescription.isConstructor() && Opcodes.UNINITIALIZED_THIS.equals(obj)) || Initialization.INITIALIZED.a(typeDescription).equals(obj);
                    }
                },
                ENTER {
                    public int a(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2) {
                        Object obj;
                        int i11 = 0;
                        if (!methodDescription.isStatic()) {
                            if (methodDescription.isConstructor()) {
                                obj = Opcodes.UNINITIALIZED_THIS;
                            } else {
                                obj = Initialization.INITIALIZED.a(typeDescription);
                            }
                            objArr2[0] = obj;
                            i11 = 1;
                        }
                        for (TypeDescription a11 : methodDescription.getParameters().asTypeList().asErasures()) {
                            objArr2[i11] = Initialization.INITIALIZED.a(a11);
                            i11++;
                        }
                        return i11;
                    }

                    public boolean b(TypeDescription typeDescription, MethodDescription methodDescription, Object obj) {
                        if (methodDescription.isConstructor()) {
                            return Opcodes.UNINITIALIZED_THIS.equals(obj);
                        }
                        return Initialization.INITIALIZED.a(typeDescription).equals(obj);
                    }
                },
                EXIT {
                    public int a(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2) {
                        int i11 = 0;
                        if (!methodDescription.isStatic()) {
                            objArr2[0] = Initialization.INITIALIZED.a(typeDescription);
                            i11 = 1;
                        }
                        for (TypeDescription a11 : methodDescription.getParameters().asTypeList().asErasures()) {
                            objArr2[i11] = Initialization.INITIALIZED.a(a11);
                            i11++;
                        }
                        return i11;
                    }

                    public boolean b(TypeDescription typeDescription, MethodDescription methodDescription, Object obj) {
                        return Initialization.INITIALIZED.a(typeDescription).equals(obj);
                    }
                };

                public abstract int a(TypeDescription typeDescription, MethodDescription methodDescription, MethodDescription methodDescription2, Object[] objArr, Object[] objArr2);

                public abstract boolean b(TypeDescription typeDescription, MethodDescription methodDescription, Object obj);
            }

            public static class Trivial extends Default {
                public Trivial(TypeDescription typeDescription, MethodDescription methodDescription, boolean z11) {
                    super(typeDescription, methodDescription, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), z11);
                }

                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    throw new IllegalStateException("Did not expect exit advice " + inDefinedShape + " for " + this.f27060c);
                }

                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect completion frame for " + this.f27060c);
                }

                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect exception frame for " + this.f27060c);
                }

                public void injectInitializationFrame(MethodVisitor methodVisitor) {
                }

                public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect post completion frame for " + this.f27060c);
                }

                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect return frame for " + this.f27060c);
                }

                public void injectStartFrame(MethodVisitor methodVisitor) {
                }

                public void translateFrame(MethodVisitor methodVisitor, int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
                    methodVisitor.visitFrame(i11, i12, objArr, i13, objArr2);
                }
            }

            public static abstract class WithPreservedArguments extends Default {

                /* renamed from: j  reason: collision with root package name */
                public boolean f27071j;

                public static class WithArgumentCopy extends WithPreservedArguments {
                    public WithArgumentCopy(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, boolean z11) {
                        super(typeDescription, methodDescription, list, list2, list3, z11, true);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:18:0x007d A[LOOP:0: B:16:0x0077->B:18:0x007d, LOOP_END] */
                    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc A[LOOP:1: B:33:0x00f6->B:35:0x00fc, LOOP_END] */
                    /* JADX WARNING: Removed duplicated region for block: B:39:0x011a A[LOOP:2: B:37:0x0114->B:39:0x011a, LOOP_END] */
                    /* JADX WARNING: Removed duplicated region for block: B:43:0x0138 A[LOOP:3: B:41:0x0132->B:43:0x0138, LOOP_END] */
                    /* JADX WARNING: Removed duplicated region for block: B:46:0x0152  */
                    /* JADX WARNING: Removed duplicated region for block: B:48:0x015a  */
                    /* JADX WARNING: Removed duplicated region for block: B:54:0x0187 A[LOOP:4: B:52:0x0181->B:54:0x0187, LOOP_END] */
                    /* JADX WARNING: Removed duplicated region for block: B:57:0x019d  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void injectStartFrame(net.bytebuddy.jar.asm.MethodVisitor r11) {
                        /*
                            r10 = this;
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            boolean r0 = r0.isStatic()
                            r1 = 1
                            if (r0 == 0) goto L_0x0015
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            net.bytebuddy.description.method.ParameterList r0 = r0.getParameters()
                            boolean r0 = r0.isEmpty()
                            if (r0 != 0) goto L_0x01a6
                        L_0x0015:
                            boolean r0 = r10.f27064g
                            r2 = 0
                            if (r0 != 0) goto L_0x0099
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            boolean r0 = r0.isStatic()
                            r0 = r0 ^ r1
                            net.bytebuddy.description.method.MethodDescription r3 = r10.f27060c
                            net.bytebuddy.description.method.ParameterList r3 = r3.getParameters()
                            int r3 = r3.size()
                            int r0 = r0 + r3
                            r3 = 4
                            if (r0 >= r3) goto L_0x0099
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            boolean r0 = r0.isStatic()
                            r0 = r0 ^ r1
                            net.bytebuddy.description.method.MethodDescription r3 = r10.f27060c
                            net.bytebuddy.description.method.ParameterList r3 = r3.getParameters()
                            int r3 = r3.size()
                            int r6 = r0 + r3
                            java.lang.Object[] r7 = new java.lang.Object[r6]
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            boolean r0 = r0.isConstructor()
                            if (r0 == 0) goto L_0x0052
                            java.lang.Integer r0 = net.bytebuddy.jar.asm.Opcodes.UNINITIALIZED_THIS
                            r7[r2] = r0
                        L_0x0050:
                            r2 = r1
                            goto L_0x0065
                        L_0x0052:
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            boolean r0 = r0.isStatic()
                            if (r0 != 0) goto L_0x0065
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r0 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            net.bytebuddy.description.type.TypeDescription r3 = r10.f27059b
                            java.lang.Object r0 = r0.a(r3)
                            r7[r2] = r0
                            goto L_0x0050
                        L_0x0065:
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            net.bytebuddy.description.method.ParameterList r0 = r0.getParameters()
                            net.bytebuddy.description.type.TypeList$Generic r0 = r0.asTypeList()
                            net.bytebuddy.description.type.TypeList r0 = r0.asErasures()
                            java.util.Iterator r0 = r0.iterator()
                        L_0x0077:
                            boolean r3 = r0.hasNext()
                            if (r3 == 0) goto L_0x008f
                            java.lang.Object r3 = r0.next()
                            net.bytebuddy.description.type.TypeDescription r3 = (net.bytebuddy.description.type.TypeDescription) r3
                            int r4 = r2 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r5 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            java.lang.Object r3 = r5.a(r3)
                            r7[r2] = r3
                            r2 = r4
                            goto L_0x0077
                        L_0x008f:
                            r5 = 1
                            java.lang.Object[] r9 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.f27058i
                            int r8 = r9.length
                            r4 = r11
                            r4.visitFrame(r5, r6, r7, r8, r9)
                            goto L_0x01a6
                        L_0x0099:
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            boolean r0 = r0.isStatic()
                            r3 = 2
                            if (r0 == 0) goto L_0x00a4
                            r0 = r2
                            goto L_0x00a5
                        L_0x00a4:
                            r0 = r3
                        L_0x00a5:
                            net.bytebuddy.description.method.MethodDescription r4 = r10.f27060c
                            net.bytebuddy.description.method.ParameterList r4 = r4.getParameters()
                            int r4 = r4.size()
                            int r4 = r4 * r3
                            int r0 = r0 + r4
                            java.util.List<? extends net.bytebuddy.description.type.TypeDescription> r3 = r10.f27061d
                            int r3 = r3.size()
                            int r0 = r0 + r3
                            java.util.List<? extends net.bytebuddy.description.type.TypeDescription> r3 = r10.f27062e
                            int r3 = r3.size()
                            int r6 = r0 + r3
                            java.lang.Object[] r7 = new java.lang.Object[r6]
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            boolean r0 = r0.isConstructor()
                            if (r0 == 0) goto L_0x00d0
                            java.lang.Integer r0 = net.bytebuddy.jar.asm.Opcodes.UNINITIALIZED_THIS
                            r7[r2] = r0
                        L_0x00ce:
                            r0 = r1
                            goto L_0x00e4
                        L_0x00d0:
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            boolean r0 = r0.isStatic()
                            if (r0 != 0) goto L_0x00e3
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r0 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            net.bytebuddy.description.type.TypeDescription r3 = r10.f27059b
                            java.lang.Object r0 = r0.a(r3)
                            r7[r2] = r0
                            goto L_0x00ce
                        L_0x00e3:
                            r0 = r2
                        L_0x00e4:
                            net.bytebuddy.description.method.MethodDescription r3 = r10.f27060c
                            net.bytebuddy.description.method.ParameterList r3 = r3.getParameters()
                            net.bytebuddy.description.type.TypeList$Generic r3 = r3.asTypeList()
                            net.bytebuddy.description.type.TypeList r3 = r3.asErasures()
                            java.util.Iterator r3 = r3.iterator()
                        L_0x00f6:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x010e
                            java.lang.Object r4 = r3.next()
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            int r5 = r0 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r8 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            java.lang.Object r4 = r8.a(r4)
                            r7[r0] = r4
                            r0 = r5
                            goto L_0x00f6
                        L_0x010e:
                            java.util.List<? extends net.bytebuddy.description.type.TypeDescription> r3 = r10.f27061d
                            java.util.Iterator r3 = r3.iterator()
                        L_0x0114:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x012c
                            java.lang.Object r4 = r3.next()
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            int r5 = r0 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r8 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            java.lang.Object r4 = r8.a(r4)
                            r7[r0] = r4
                            r0 = r5
                            goto L_0x0114
                        L_0x012c:
                            java.util.List<? extends net.bytebuddy.description.type.TypeDescription> r3 = r10.f27062e
                            java.util.Iterator r3 = r3.iterator()
                        L_0x0132:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x014a
                            java.lang.Object r4 = r3.next()
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            int r5 = r0 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r8 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            java.lang.Object r4 = r8.a(r4)
                            r7[r0] = r4
                            r0 = r5
                            goto L_0x0132
                        L_0x014a:
                            net.bytebuddy.description.method.MethodDescription r3 = r10.f27060c
                            boolean r3 = r3.isConstructor()
                            if (r3 == 0) goto L_0x015a
                            int r3 = r0 + 1
                            java.lang.Integer r4 = net.bytebuddy.jar.asm.Opcodes.UNINITIALIZED_THIS
                            r7[r0] = r4
                        L_0x0158:
                            r0 = r3
                            goto L_0x016f
                        L_0x015a:
                            net.bytebuddy.description.method.MethodDescription r3 = r10.f27060c
                            boolean r3 = r3.isStatic()
                            if (r3 != 0) goto L_0x016f
                            int r3 = r0 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r4 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            net.bytebuddy.description.type.TypeDescription r5 = r10.f27059b
                            java.lang.Object r4 = r4.a(r5)
                            r7[r0] = r4
                            goto L_0x0158
                        L_0x016f:
                            net.bytebuddy.description.method.MethodDescription r3 = r10.f27060c
                            net.bytebuddy.description.method.ParameterList r3 = r3.getParameters()
                            net.bytebuddy.description.type.TypeList$Generic r3 = r3.asTypeList()
                            net.bytebuddy.description.type.TypeList r3 = r3.asErasures()
                            java.util.Iterator r3 = r3.iterator()
                        L_0x0181:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x0199
                            java.lang.Object r4 = r3.next()
                            net.bytebuddy.description.type.TypeDescription r4 = (net.bytebuddy.description.type.TypeDescription) r4
                            int r5 = r0 + 1
                            net.bytebuddy.asm.Advice$StackMapFrameHandler$Default$Initialization r8 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.INITIALIZED
                            java.lang.Object r4 = r8.a(r4)
                            r7[r0] = r4
                            r0 = r5
                            goto L_0x0181
                        L_0x0199:
                            boolean r0 = r10.f27064g
                            if (r0 == 0) goto L_0x019e
                            r2 = -1
                        L_0x019e:
                            r5 = r2
                            java.lang.Object[] r9 = net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.f27058i
                            int r8 = r9.length
                            r4 = r11
                            r4.visitFrame(r5, r6, r7, r8, r9)
                        L_0x01a6:
                            net.bytebuddy.description.method.MethodDescription r11 = r10.f27060c
                            boolean r11 = r11.isStatic()
                            r11 = r11 ^ r1
                            net.bytebuddy.description.method.MethodDescription r0 = r10.f27060c
                            net.bytebuddy.description.method.ParameterList r0 = r0.getParameters()
                            int r0 = r0.size()
                            int r11 = r11 + r0
                            r10.f27065h = r11
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.WithPreservedArguments.WithArgumentCopy.injectStartFrame(net.bytebuddy.jar.asm.MethodVisitor):void");
                    }

                    @SuppressFBWarnings(justification = "Reference equality is required by ASM", value = {"RC_REF_COMPARISON_BAD_PRACTICE"})
                    public void translateFrame(MethodVisitor methodVisitor, int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
                        Object[] objArr3;
                        int i14;
                        int i15 = i11;
                        int i16 = i12;
                        Object[] objArr4 = objArr;
                        int i17 = 1;
                        if (i15 == -1 || i15 == 0) {
                            int size = (this.f27060c.isStatic() ^ true ? 1 : 0) + i16 + this.f27060c.getParameters().size() + this.f27061d.size() + this.f27062e.size();
                            Object[] objArr5 = new Object[size];
                            if (this.f27060c.isConstructor()) {
                                Initialization initialization = Initialization.INITIALIZED;
                                int i18 = 0;
                                while (true) {
                                    if (i18 >= i16) {
                                        break;
                                    } else if (objArr4[i18] == Opcodes.UNINITIALIZED_THIS) {
                                        initialization = Initialization.UNITIALIZED;
                                        break;
                                    } else {
                                        i18++;
                                    }
                                }
                                objArr5[0] = initialization.a(this.f27059b);
                            } else if (!this.f27060c.isStatic()) {
                                objArr5[0] = Initialization.INITIALIZED.a(this.f27059b);
                            } else {
                                i17 = 0;
                            }
                            for (TypeDescription a11 : this.f27060c.getParameters().asTypeList().asErasures()) {
                                objArr5[i17] = Initialization.INITIALIZED.a(a11);
                                i17++;
                            }
                            for (TypeDescription a12 : this.f27061d) {
                                objArr5[i17] = Initialization.INITIALIZED.a(a12);
                                i17++;
                            }
                            for (TypeDescription a13 : this.f27062e) {
                                objArr5[i17] = Initialization.INITIALIZED.a(a13);
                                i17++;
                            }
                            if (i16 > 0) {
                                System.arraycopy(objArr4, 0, objArr5, i17, i12);
                            }
                            this.f27065h = size;
                            i14 = size;
                            objArr3 = objArr5;
                        } else {
                            if (i15 == 1) {
                                this.f27065h += i16;
                            } else if (i15 == 2) {
                                this.f27065h -= i16;
                            } else if (!(i15 == 3 || i15 == 4)) {
                                throw new IllegalArgumentException("Unexpected frame type: " + i11);
                            }
                            objArr3 = objArr4;
                            i14 = i16;
                        }
                        methodVisitor.visitFrame(i11, i14, objArr3, i13, objArr2);
                    }
                }

                public static class WithoutArgumentCopy extends WithPreservedArguments {
                    public WithoutArgumentCopy(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, boolean z11, boolean z12) {
                        super(typeDescription, methodDescription, list, list2, list3, z11, z12);
                    }

                    public void injectStartFrame(MethodVisitor methodVisitor) {
                    }

                    public void translateFrame(MethodVisitor methodVisitor, int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
                        c(methodVisitor, TranslationMode.COPY, this.f27060c, CompoundList.of(this.f27061d, this.f27062e), i11, i12, objArr, i13, objArr2);
                    }
                }

                public WithPreservedArguments(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, boolean z11, boolean z12) {
                    super(typeDescription, methodDescription, list, list2, list3, z11);
                    this.f27071j = z12;
                }

                public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForAdvice(inDefinedShape, CompoundList.of(this.f27061d, this.f27062e, this.f27063f), Collections.emptyList(), TranslationMode.EXIT, Initialization.INITIALIZED);
                }

                @SuppressFBWarnings(justification = "ASM models frames by reference comparison.", value = {"RC_REF_COMPARISON_BAD_PRACTICE"})
                public void c(MethodVisitor methodVisitor, TranslationMode translationMode, MethodDescription methodDescription, List<? extends TypeDescription> list, int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
                    if (i11 == 0 && i12 > 0 && objArr[0] != Opcodes.UNINITIALIZED_THIS) {
                        this.f27071j = true;
                    }
                    super.c(methodVisitor, translationMode, methodDescription, list, i11, i12, objArr, i13, objArr2);
                }

                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    if (!this.f27071j || this.f27064g || this.f27065h != 0 || this.f27063f.size() >= 4) {
                        a(methodVisitor, Initialization.INITIALIZED, CompoundList.of(this.f27061d, this.f27062e, this.f27063f), Collections.emptyList());
                    } else if (this.f27063f.isEmpty()) {
                        Object[] objArr = Default.f27058i;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    } else {
                        int size = this.f27063f.size();
                        Object[] objArr2 = new Object[size];
                        int i11 = 0;
                        for (TypeDescription a11 : this.f27063f) {
                            objArr2[i11] = Initialization.INITIALIZED.a(a11);
                            i11++;
                        }
                        Object[] objArr3 = Default.f27058i;
                        methodVisitor.visitFrame(1, size, objArr2, objArr3.length, objArr3);
                    }
                }

                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    if (this.f27064g || this.f27065h != 0) {
                        a(methodVisitor, Initialization.INITIALIZED, CompoundList.of(this.f27061d, this.f27062e), Collections.singletonList(TypeDescription.THROWABLE));
                        return;
                    }
                    Object[] objArr = Default.f27058i;
                    methodVisitor.visitFrame(4, objArr.length, objArr, 1, new Object[]{Type.getInternalName(Throwable.class)});
                }

                public void injectInitializationFrame(MethodVisitor methodVisitor) {
                    if (!this.f27061d.isEmpty()) {
                        int i11 = 0;
                        if (this.f27064g || this.f27061d.size() >= 4) {
                            int i12 = 1;
                            int size = (this.f27060c.isStatic() ^ true ? 1 : 0) + this.f27060c.getParameters().size() + this.f27061d.size();
                            Object[] objArr = new Object[size];
                            if (this.f27060c.isConstructor()) {
                                objArr[0] = Opcodes.UNINITIALIZED_THIS;
                            } else if (!this.f27060c.isStatic()) {
                                objArr[0] = Initialization.INITIALIZED.a(this.f27059b);
                            } else {
                                i12 = 0;
                            }
                            for (TypeDescription a11 : this.f27060c.getParameters().asTypeList().asErasures()) {
                                objArr[i12] = Initialization.INITIALIZED.a(a11);
                                i12++;
                            }
                            for (TypeDescription a12 : this.f27061d) {
                                objArr[i12] = Initialization.INITIALIZED.a(a12);
                                i12++;
                            }
                            if (this.f27064g) {
                                i11 = -1;
                            }
                            Object[] objArr2 = Default.f27058i;
                            methodVisitor.visitFrame(i11, size, objArr, objArr2.length, objArr2);
                            return;
                        }
                        int size2 = this.f27061d.size();
                        Object[] objArr3 = new Object[size2];
                        for (TypeDescription a13 : this.f27061d) {
                            objArr3[i11] = Initialization.INITIALIZED.a(a13);
                            i11++;
                        }
                        Object[] objArr4 = Default.f27058i;
                        methodVisitor.visitFrame(1, size2, objArr3, objArr4.length, objArr4);
                    }
                }

                public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
                    if (this.f27064g || this.f27065h != 0) {
                        a(methodVisitor, Initialization.INITIALIZED, CompoundList.of(this.f27061d, this.f27062e, this.f27063f), Collections.emptyList());
                        return;
                    }
                    Object[] objArr = Default.f27058i;
                    methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                }

                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    List list;
                    if (this.f27064g || this.f27065h != 0) {
                        Initialization initialization = Initialization.INITIALIZED;
                        List<S> of2 = CompoundList.of(this.f27061d, this.f27062e);
                        if (this.f27060c.getReturnType().represents(Void.TYPE)) {
                            list = Collections.emptyList();
                        } else {
                            list = Collections.singletonList(this.f27060c.getReturnType().asErasure());
                        }
                        a(methodVisitor, initialization, of2, list);
                    } else if (this.f27060c.getReturnType().represents(Void.TYPE)) {
                        Object[] objArr = Default.f27058i;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    } else {
                        Object[] objArr2 = Default.f27058i;
                        methodVisitor.visitFrame(4, objArr2.length, objArr2, 1, new Object[]{Initialization.INITIALIZED.a(this.f27060c.getReturnType().asErasure())});
                    }
                }
            }

            public Default(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, boolean z11) {
                this.f27059b = typeDescription;
                this.f27060c = methodDescription;
                this.f27061d = list;
                this.f27062e = list2;
                this.f27063f = list3;
                this.f27064g = z11;
            }

            public static ForInstrumentedMethod b(TypeDescription typeDescription, MethodDescription methodDescription, List<? extends TypeDescription> list, List<? extends TypeDescription> list2, List<? extends TypeDescription> list3, boolean z11, boolean z12, ClassFileVersion classFileVersion, int i11, int i12) {
                boolean z13;
                boolean z14;
                if ((i11 & 2) == 0) {
                    if (!classFileVersion.isLessThan(ClassFileVersion.JAVA_V6)) {
                        boolean z15 = false;
                        if (z11 || !list.isEmpty()) {
                            TypeDescription typeDescription2 = typeDescription;
                            MethodDescription methodDescription2 = methodDescription;
                            if (z12) {
                                if ((i12 & 8) != 0) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                return new WithPreservedArguments.WithArgumentCopy(typeDescription, methodDescription, list, list2, list3, z14);
                            }
                            if ((i12 & 8) != 0) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            return new WithPreservedArguments.WithoutArgumentCopy(typeDescription, methodDescription, list, list2, list3, z13, !methodDescription.isConstructor());
                        }
                        TypeDescription typeDescription3 = typeDescription;
                        MethodDescription methodDescription3 = methodDescription;
                        if ((i12 & 8) != 0) {
                            z15 = true;
                        }
                        return new Trivial(typeDescription, methodDescription, z15);
                    }
                }
                return NoOp.INSTANCE;
            }

            public void a(MethodVisitor methodVisitor, Initialization initialization, List<? extends TypeDescription> list, List<? extends TypeDescription> list2) {
                int i11;
                int i12 = 1;
                int size = this.f27060c.getParameters().size() + (this.f27060c.isStatic() ^ true ? 1 : 0) + list.size();
                Object[] objArr = new Object[size];
                if (!this.f27060c.isStatic()) {
                    objArr[0] = initialization.a(this.f27059b);
                } else {
                    i12 = 0;
                }
                for (TypeDescription a11 : this.f27060c.getParameters().asTypeList().asErasures()) {
                    objArr[i12] = Initialization.INITIALIZED.a(a11);
                    i12++;
                }
                for (TypeDescription a12 : list) {
                    objArr[i12] = Initialization.INITIALIZED.a(a12);
                    i12++;
                }
                int size2 = list2.size();
                Object[] objArr2 = new Object[size2];
                int i13 = 0;
                for (TypeDescription a13 : list2) {
                    objArr2[i13] = Initialization.INITIALIZED.a(a13);
                    i13++;
                }
                if (this.f27064g) {
                    i11 = -1;
                } else {
                    i11 = 0;
                }
                methodVisitor.visitFrame(i11, size, objArr, size2, objArr2);
                this.f27065h = 0;
            }

            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return new ForAdvice(inDefinedShape, this.f27061d, this.f27062e, TranslationMode.ENTER, this.f27060c.isConstructor() ? Initialization.UNITIALIZED : Initialization.INITIALIZED);
            }

            public void c(MethodVisitor methodVisitor, TranslationMode translationMode, MethodDescription methodDescription, List<? extends TypeDescription> list, int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
                Object[] objArr3;
                int i14;
                int i15;
                MethodDescription methodDescription2 = methodDescription;
                int i16 = i11;
                int i17 = i12;
                Object[] objArr4 = objArr;
                if (i16 != -1 && i16 != 0) {
                    if (i16 == 1) {
                        this.f27065h += i17;
                    } else if (i16 == 2) {
                        int i18 = this.f27065h - i17;
                        this.f27065h = i18;
                        if (i18 < 0) {
                            throw new IllegalStateException(methodDescription2 + " dropped " + Math.abs(this.f27065h) + " implicit frames");
                        }
                    } else if (!(i16 == 3 || i16 == 4)) {
                        throw new IllegalArgumentException("Unexpected frame type: " + i16);
                    }
                    i14 = i17;
                    objArr3 = objArr4;
                } else if (methodDescription.getParameters().size() + (methodDescription.isStatic() ^ true ? 1 : 0) <= i17) {
                    int i19 = 0;
                    if (methodDescription.isStatic()) {
                        TranslationMode translationMode2 = translationMode;
                        i15 = 0;
                    } else {
                        if (translationMode.b(this.f27059b, this.f27060c, objArr4[0])) {
                            i15 = 1;
                        } else {
                            throw new IllegalStateException(methodDescription2 + " is inconsistent for 'this' reference: " + objArr4[0]);
                        }
                    }
                    while (i19 < methodDescription.getParameters().size()) {
                        int i21 = i19 + i15;
                        if (Initialization.INITIALIZED.a(((ParameterDescription) methodDescription.getParameters().get(i19)).getType().asErasure()).equals(objArr4[i21])) {
                            i19++;
                        } else {
                            throw new IllegalStateException(methodDescription2 + " is inconsistent at " + i19 + ": " + objArr4[i21]);
                        }
                    }
                    int size = ((i17 - (methodDescription.isStatic() ^ true ? 1 : 0)) - methodDescription.getParameters().size()) + (this.f27060c.isStatic() ^ true ? 1 : 0) + this.f27060c.getParameters().size() + list.size();
                    Object[] objArr5 = new Object[size];
                    int a11 = translationMode.a(this.f27059b, this.f27060c, methodDescription, objArr, objArr5);
                    for (TypeDescription a12 : list) {
                        objArr5[a11] = Initialization.INITIALIZED.a(a12);
                        a11++;
                    }
                    int i22 = size - a11;
                    System.arraycopy(objArr4, methodDescription.getParameters().size() + (methodDescription.isStatic() ^ true ? 1 : 0), objArr5, a11, i22);
                    this.f27065h = i22;
                    i14 = size;
                    objArr3 = objArr5;
                } else {
                    throw new IllegalStateException("Inconsistent frame length for " + methodDescription2 + ": " + i17);
                }
                methodVisitor.visitFrame(i11, i14, objArr3, i13, objArr2);
            }

            public int getReaderHint() {
                return this.f27064g ? 8 : 0;
            }
        }

        public interface ForAdvice extends StackMapFrameHandler {
        }

        public interface ForInstrumentedMethod extends StackMapFrameHandler {
            ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape);

            ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape);

            int getReaderHint();

            void injectInitializationFrame(MethodVisitor methodVisitor);

            void injectPostCompletionFrame(MethodVisitor methodVisitor);

            void injectStartFrame(MethodVisitor methodVisitor);
        }

        public enum NoOp implements ForInstrumentedMethod, ForAdvice {
            INSTANCE;

            public ForAdvice bindEnter(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            public ForAdvice bindExit(MethodDescription.InDefinedShape inDefinedShape) {
                return this;
            }

            public int getReaderHint() {
                return 4;
            }

            public void injectCompletionFrame(MethodVisitor methodVisitor) {
            }

            public void injectExceptionFrame(MethodVisitor methodVisitor) {
            }

            public void injectInitializationFrame(MethodVisitor methodVisitor) {
            }

            public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
            }

            public void injectReturnFrame(MethodVisitor methodVisitor) {
            }

            public void injectStartFrame(MethodVisitor methodVisitor) {
            }

            public void translateFrame(MethodVisitor methodVisitor, int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
            }
        }

        void injectCompletionFrame(MethodVisitor methodVisitor);

        void injectExceptionFrame(MethodVisitor methodVisitor);

        void injectReturnFrame(MethodVisitor methodVisitor);

        void translateFrame(MethodVisitor methodVisitor, int i11, int i12, Object[] objArr, int i13, Object[] objArr2);
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface StubValue {
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface This {
        boolean optional() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Thrown {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.DYNAMIC;
    }

    @Documented
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Unused {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class WithCustomMapping {
        private final Delegator delegator;
        private final Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> offsetMappings;
        private final PostProcessor.Factory postProcessorFactory;

        public WithCustomMapping() {
            this(PostProcessor.NoOp.INSTANCE, Collections.emptyMap(), Delegator.ForStaticInvocation.INSTANCE);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Object obj) {
            return bind(OffsetMapping.ForStackManipulation.Factory.of(cls, obj));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, Object... objArr) {
            return bindDynamic(cls, method, (List<?>) Arrays.asList(objArr));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor, Class<?> cls2) {
            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), TypeDescription.ForLoadedType.of(cls2));
        }

        public <T extends Annotation> WithCustomMapping bindProperty(Class<T> cls, String str) {
            return bind(OffsetMapping.ForStackManipulation.OfAnnotationProperty.of(cls, str));
        }

        public <T extends Annotation> WithCustomMapping bindSerialized(Class<T> cls, Serializable serializable) {
            return bindSerialized(cls, serializable, serializable.getClass());
        }

        public WithCustomMapping bootstrap(Constructor<?> constructor) {
            return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WithCustomMapping withCustomMapping = (WithCustomMapping) obj;
            return this.postProcessorFactory.equals(withCustomMapping.postProcessorFactory) && this.delegator.equals(withCustomMapping.delegator) && this.offsetMappings.equals(withCustomMapping.offsetMappings);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.postProcessorFactory.hashCode()) * 31) + this.delegator.hashCode()) * 31) + this.offsetMappings.hashCode();
        }

        public Advice to(Class<?> cls) {
            return to(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
        }

        public WithCustomMapping with(PostProcessor.Factory factory) {
            return new WithCustomMapping(new PostProcessor.Factory.Compound(this.postProcessorFactory, factory), this.offsetMappings, this.delegator);
        }

        public WithCustomMapping(PostProcessor.Factory factory, Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> map, Delegator delegator2) {
            this.postProcessorFactory = factory;
            this.offsetMappings = map;
            this.delegator = delegator2;
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Field field) {
            return bind(cls, (FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, List<?> list) {
            return bindDynamic(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), list);
        }

        public <T extends Annotation, S extends Serializable> WithCustomMapping bindSerialized(Class<T> cls, S s11, Class<? super S> cls2) {
            return bind(OffsetMapping.ForSerializedValue.Factory.of(cls, s11, cls2));
        }

        public WithCustomMapping bootstrap(Method method) {
            return bootstrap((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method));
        }

        public Advice to(Class<?> cls, ClassFileLocator classFileLocator) {
            return to(TypeDescription.ForLoadedType.of(cls), classFileLocator);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, FieldDescription fieldDescription) {
            return bind(new OffsetMapping.ForField.Resolved.Factory(cls, fieldDescription));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor, Object... objArr) {
            return bindDynamic(cls, constructor, (List<?>) Arrays.asList(objArr));
        }

        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape) {
            return new WithCustomMapping(this.postProcessorFactory, this.offsetMappings, Delegator.ForDynamicInvocation.a(inDefinedShape));
        }

        public Advice to(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
            return Advice.i(typeDescription, this.postProcessorFactory, classFileLocator, new ArrayList(this.offsetMappings.values()), this.delegator);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Method method, int i11) {
            if (i11 < 0) {
                throw new IllegalArgumentException("A parameter cannot be negative: " + i11);
            } else if (method.getParameterTypes().length > i11) {
                return bind(cls, (ParameterDescription) new MethodDescription.ForLoadedMethod(method).getParameters().get(i11));
            } else {
                throw new IllegalArgumentException(method + " does not declare a parameter with index " + i11);
            }
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor, List<?> list) {
            return bindDynamic(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), list);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor, Class<?> cls2, MethodGraph.Compiler compiler) {
            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), TypeDescription.ForLoadedType.of(cls2), compiler);
        }

        public Advice to(Class<?> cls, Class<?> cls2) {
            ClassFileLocator classFileLocator;
            ClassLoader classLoader = cls.getClassLoader();
            ClassLoader classLoader2 = cls2.getClassLoader();
            if (classLoader == classLoader2) {
                classFileLocator = ClassFileLocator.ForClassLoader.of(classLoader);
            } else {
                classFileLocator = new ClassFileLocator.Compound(ClassFileLocator.ForClassLoader.of(classLoader), ClassFileLocator.ForClassLoader.of(classLoader2));
            }
            return to(cls, cls2, classFileLocator);
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
            return bindDynamic(cls, inDefinedShape, (List<?>) Arrays.asList(objArr));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, List<?> list) {
            List<JavaConstant> wrap = JavaConstant.Simple.wrap(list);
            if (inDefinedShape.isInvokeBootstrap(TypeList.Explicit.of(wrap))) {
                return bind(new OffsetMapping.ForStackManipulation.OfDynamicInvocation(cls, inDefinedShape, wrap));
            }
            throw new IllegalArgumentException("Not a valid bootstrap method " + inDefinedShape + " for " + wrap);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2) {
            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls2));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Constructor<?> constructor, int i11) {
            if (i11 < 0) {
                throw new IllegalArgumentException("A parameter cannot be negative: " + i11);
            } else if (constructor.getParameterTypes().length > i11) {
                return bind(cls, (ParameterDescription) new MethodDescription.ForLoadedConstructor(constructor).getParameters().get(i11));
            } else {
                throw new IllegalArgumentException(constructor + " does not declare a parameter with index " + i11);
            }
        }

        public Advice to(Class<?> cls, Class<?> cls2, ClassFileLocator classFileLocator) {
            return to(TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(cls2), classFileLocator);
        }

        public Advice to(TypeDescription typeDescription, TypeDescription typeDescription2) {
            return to(typeDescription, typeDescription2, (ClassFileLocator) ClassFileLocator.NoOp.INSTANCE);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2, MethodGraph.Compiler compiler) {
            return bindLambda(cls, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls2), compiler);
        }

        public Advice to(TypeDescription typeDescription, TypeDescription typeDescription2, ClassFileLocator classFileLocator) {
            return Advice.j(typeDescription, typeDescription2, this.postProcessorFactory, classFileLocator, new ArrayList(this.offsetMappings.values()), this.delegator);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, ParameterDescription parameterDescription) {
            return bind(new OffsetMapping.ForArgument.Resolved.Factory(cls, parameterDescription));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Class<?> cls2) {
            return bind(cls, TypeDescription.ForLoadedType.of(cls2));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
            return bindLambda(cls, inDefinedShape, typeDescription, MethodGraph.Compiler.DEFAULT);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, TypeDescription typeDescription) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, typeDescription));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodGraph.Compiler compiler) {
            TypeDescription typeDescription2 = typeDescription;
            if (typeDescription.isInterface()) {
                MethodList methodList = (MethodList) compiler.compile((TypeDefinition) typeDescription2).listNodes().asMethodList().filter(ElementMatchers.isAbstract());
                if (methodList.size() == 1) {
                    TypeDescription.Latent latent = new TypeDescription.Latent("java.lang.invoke.LambdaMetafactory", 1, TypeDescription.Generic.OBJECT, new TypeDescription.Generic[0]);
                    List emptyList = Collections.emptyList();
                    TypeDescription.Generic asGenericType = JavaType.CALL_SITE.getTypeStub().asGenericType();
                    JavaType javaType = JavaType.METHOD_TYPE;
                    return bindDynamic(cls, (MethodDescription.InDefinedShape) new MethodDescription.Latent(latent, "metafactory", 9, emptyList, asGenericType, Arrays.asList(new ParameterDescription.Token[]{new ParameterDescription.Token(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType()), new ParameterDescription.Token(TypeDescription.STRING.asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_HANDLE.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType())}), Collections.emptyList(), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED), JavaConstant.MethodType.of((MethodDescription) methodList.asDefined().getOnly()), JavaConstant.MethodHandle.of(inDefinedShape), JavaConstant.MethodType.of((MethodDescription) methodList.asDefined().getOnly()));
                }
                throw new IllegalArgumentException(typeDescription2 + " does not define exactly one abstract method: " + methodList);
            }
            throw new IllegalArgumentException(typeDescription2 + " is not an interface type");
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Enum<?> enumR) {
            return bind(cls, (EnumerationDescription) new EnumerationDescription.ForLoadedEnumeration(enumR));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, EnumerationDescription enumerationDescription) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, enumerationDescription));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, JavaConstant javaConstant) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, new JavaConstantValue(javaConstant), javaConstant.getTypeDescription().asGenericType()));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation, java.lang.reflect.Type type) {
            return bind(cls, stackManipulation, TypeDefinition.Sort.describe(type));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation, TypeDescription.Generic generic) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, stackManipulation, generic));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, OffsetMapping offsetMapping) {
            return bind(new OffsetMapping.Factory.Simple(cls, offsetMapping));
        }

        public WithCustomMapping bind(OffsetMapping.Factory<?> factory) {
            HashMap hashMap = new HashMap(this.offsetMappings);
            if (!factory.getAnnotationType().isAnnotation()) {
                throw new IllegalArgumentException("Not an annotation type: " + factory.getAnnotationType());
            } else if (hashMap.put(factory.getAnnotationType(), factory) == null) {
                return new WithCustomMapping(this.postProcessorFactory, hashMap, this.delegator);
            } else {
                throw new IllegalArgumentException("Annotation type already mapped: " + factory.getAnnotationType());
            }
        }
    }

    static {
        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(OnMethodEnter.class).getDeclaredMethods();
        SKIP_ON = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("skipOn"))).getOnly();
        PREPEND_LINE_NUMBER = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("prependLineNumber"))).getOnly();
        INLINE_ENTER = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("inline"))).getOnly();
        SUPPRESS_ENTER = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods.filter(ElementMatchers.named("suppress"))).getOnly();
        MethodList<MethodDescription.InDefinedShape> declaredMethods2 = TypeDescription.ForLoadedType.of(OnMethodExit.class).getDeclaredMethods();
        REPEAT_ON = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("repeatOn"))).getOnly();
        ON_THROWABLE = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("onThrowable"))).getOnly();
        BACKUP_ARGUMENTS = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("backupArguments"))).getOnly();
        INLINE_EXIT = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("inline"))).getOnly();
        SUPPRESS_EXIT = (MethodDescription.InDefinedShape) ((MethodList) declaredMethods2.filter(ElementMatchers.named("suppress"))).getOnly();
    }

    public Advice(Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit) {
        this(forMethodEnter, forMethodExit, Assigner.DEFAULT, ExceptionHandler.Default.SUPPRESSING, SuperMethodCall.INSTANCE);
    }

    public static Advice i(TypeDescription typeDescription, PostProcessor.Factory factory, ClassFileLocator classFileLocator, List<? extends OffsetMapping.Factory<?>> list, Delegator delegator) {
        ClassReader classReader;
        Dispatcher.Unresolved unresolved = Dispatcher.Inactive.INSTANCE;
        Dispatcher.Unresolved unresolved2 = unresolved;
        for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods()) {
            unresolved = locate(OnMethodEnter.class, INLINE_ENTER, unresolved, inDefinedShape, delegator);
            unresolved2 = locate(OnMethodExit.class, INLINE_EXIT, unresolved2, inDefinedShape, delegator);
        }
        if (unresolved.isAlive() || unresolved2.isAlive()) {
            try {
                if (!unresolved.isBinary()) {
                    if (!unresolved2.isBinary()) {
                        classReader = UNDEFINED;
                        return new Advice(unresolved.asMethodEnter(list, classReader, unresolved2, factory), unresolved2.asMethodExit(list, classReader, unresolved, factory));
                    }
                }
                classReader = OpenedClassReader.of(classFileLocator.locate(typeDescription.getName()).resolve());
                return new Advice(unresolved.asMethodEnter(list, classReader, unresolved2, factory), unresolved2.asMethodExit(list, classReader, unresolved, factory));
            } catch (IOException e11) {
                throw new IllegalStateException("Error reading class file of " + typeDescription, e11);
            }
        } else {
            throw new IllegalArgumentException("No advice defined by " + typeDescription);
        }
    }

    public static Advice j(TypeDescription typeDescription, TypeDescription typeDescription2, PostProcessor.Factory factory, ClassFileLocator classFileLocator, List<? extends OffsetMapping.Factory<?>> list, Delegator delegator) {
        ClassReader classReader;
        ClassReader classReader2;
        Dispatcher.Unresolved unresolved = Dispatcher.Inactive.INSTANCE;
        Dispatcher.Unresolved unresolved2 = unresolved;
        for (MethodDescription.InDefinedShape locate : typeDescription.getDeclaredMethods()) {
            unresolved2 = locate(OnMethodEnter.class, INLINE_ENTER, unresolved2, locate, delegator);
        }
        if (unresolved2.isAlive()) {
            for (MethodDescription.InDefinedShape locate2 : typeDescription2.getDeclaredMethods()) {
                unresolved = locate(OnMethodExit.class, INLINE_EXIT, unresolved, locate2, delegator);
            }
            if (unresolved.isAlive()) {
                try {
                    if (unresolved2.isBinary()) {
                        classReader = OpenedClassReader.of(classFileLocator.locate(typeDescription.getName()).resolve());
                    } else {
                        classReader = UNDEFINED;
                    }
                    Dispatcher.Resolved.ForMethodEnter asMethodEnter = unresolved2.asMethodEnter(list, classReader, unresolved, factory);
                    if (unresolved.isBinary()) {
                        classReader2 = OpenedClassReader.of(classFileLocator.locate(typeDescription2.getName()).resolve());
                    } else {
                        classReader2 = UNDEFINED;
                    }
                    return new Advice(asMethodEnter, unresolved.asMethodExit(list, classReader2, unresolved2, factory));
                } catch (IOException e11) {
                    throw new IllegalStateException("Error reading class file of " + typeDescription + " or " + typeDescription2, e11);
                }
            } else {
                throw new IllegalArgumentException("No exit advice defined by " + typeDescription2);
            }
        } else {
            throw new IllegalArgumentException("No enter advice defined by " + typeDescription);
        }
    }

    private static Dispatcher.Unresolved locate(Class<? extends Annotation> cls, MethodDescription.InDefinedShape inDefinedShape, Dispatcher.Unresolved unresolved, MethodDescription.InDefinedShape inDefinedShape2, Delegator delegator) {
        AnnotationDescription.Loadable<? extends Annotation> ofType = inDefinedShape2.getDeclaredAnnotations().ofType(cls);
        if (ofType == null) {
            return unresolved;
        }
        if (unresolved.isAlive()) {
            throw new IllegalStateException("Duplicate advice for " + unresolved + " and " + inDefinedShape2);
        } else if (!inDefinedShape2.isStatic()) {
            throw new IllegalStateException("Advice for " + inDefinedShape2 + " is not static");
        } else if (((Boolean) ofType.getValue(inDefinedShape).resolve(Boolean.class)).booleanValue()) {
            return new Dispatcher.Inlining(inDefinedShape2);
        } else {
            return new Dispatcher.Delegating(inDefinedShape2, delegator);
        }
    }

    public static Advice to(Class<?> cls) {
        return to(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public static WithCustomMapping withCustomMapping() {
        return new WithCustomMapping();
    }

    public ByteCodeAppender appender(Implementation.Target target) {
        return new Appender(this, target, this.delegate.appender(target));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Advice advice = (Advice) obj;
        return this.methodEnter.equals(advice.methodEnter) && this.methodExit.equals(advice.methodExit) && this.assigner.equals(advice.assigner) && this.exceptionHandler.equals(advice.exceptionHandler) && this.delegate.equals(advice.delegate);
    }

    public MethodVisitor h(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, int i11, int i12) {
        MethodVisitor methodVisitor2;
        TypeDescription typeDescription2 = typeDescription;
        MethodDescription methodDescription2 = methodDescription;
        if (this.methodEnter.isPrependLineNumber()) {
            methodVisitor2 = new LineNumberPrependingMethodVisitor(methodVisitor);
        } else {
            methodVisitor2 = methodVisitor;
        }
        FramePaddingMethodVisitor framePaddingMethodVisitor = new FramePaddingMethodVisitor(methodVisitor2);
        if (!this.methodExit.isAlive()) {
            return new AdviceVisitor.WithoutExitAdvice(framePaddingMethodVisitor, context, this.assigner, this.exceptionHandler.resolve(methodDescription2, typeDescription), typeDescription, methodDescription, this.methodEnter, i11, i12);
        } else if (this.methodExit.getThrowable().represents(NoExceptionHandler.class)) {
            return new AdviceVisitor.WithExitAdvice.WithoutExceptionHandling(framePaddingMethodVisitor, context, this.assigner, this.exceptionHandler.resolve(methodDescription2, typeDescription), typeDescription, methodDescription, this.methodEnter, this.methodExit, i11, i12);
        } else if (!methodDescription.isConstructor()) {
            Assigner assigner2 = this.assigner;
            StackManipulation resolve = this.exceptionHandler.resolve(methodDescription2, typeDescription);
            Dispatcher.Resolved.ForMethodEnter forMethodEnter = this.methodEnter;
            Dispatcher.Resolved.ForMethodExit forMethodExit = this.methodExit;
            return new AdviceVisitor.WithExitAdvice.WithExceptionHandling(framePaddingMethodVisitor, context, assigner2, resolve, typeDescription, methodDescription, forMethodEnter, forMethodExit, i11, i12, forMethodExit.getThrowable());
        } else {
            throw new IllegalStateException("Cannot catch exception during constructor call for " + methodDescription2);
        }
    }

    public int hashCode() {
        return (((((((((getClass().hashCode() * 31) + this.methodEnter.hashCode()) * 31) + this.methodExit.hashCode()) * 31) + this.assigner.hashCode()) * 31) + this.exceptionHandler.hashCode()) * 31) + this.delegate.hashCode();
    }

    public AsmVisitorWrapper.ForDeclaredMethods on(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new AsmVisitorWrapper.ForDeclaredMethods().invokable(elementMatcher, this);
    }

    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return this.delegate.prepare(instrumentedType);
    }

    public Advice withAssigner(Assigner assigner2) {
        return new Advice(this.methodEnter, this.methodExit, assigner2, this.exceptionHandler, this.delegate);
    }

    public Advice withExceptionHandler(StackManipulation stackManipulation) {
        return withExceptionHandler((ExceptionHandler) new ExceptionHandler.Simple(stackManipulation));
    }

    public Advice withExceptionPrinting() {
        return withExceptionHandler((ExceptionHandler) ExceptionHandler.Default.PRINTING);
    }

    public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i11, int i12) {
        return (methodDescription.isAbstract() || methodDescription.isNative()) ? methodVisitor : h(typeDescription, methodDescription, methodVisitor, context, i11, i12);
    }

    private Advice(Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit, Assigner assigner2, ExceptionHandler exceptionHandler2, Implementation implementation) {
        this.methodEnter = forMethodEnter;
        this.methodExit = forMethodExit;
        this.assigner = assigner2;
        this.exceptionHandler = exceptionHandler2;
        this.delegate = implementation;
    }

    public static Advice to(Class<?> cls, ClassFileLocator classFileLocator) {
        return to(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public Advice withExceptionHandler(ExceptionHandler exceptionHandler2) {
        return new Advice(this.methodEnter, this.methodExit, this.assigner, exceptionHandler2, this.delegate);
    }

    public static Advice to(TypeDescription typeDescription) {
        return to(typeDescription, (ClassFileLocator) ClassFileLocator.NoOp.INSTANCE);
    }

    public Implementation wrap(Implementation implementation) {
        return new Advice(this.methodEnter, this.methodExit, this.assigner, this.exceptionHandler, implementation);
    }

    public static Advice to(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return i(typeDescription, PostProcessor.NoOp.INSTANCE, classFileLocator, Collections.emptyList(), Delegator.ForStaticInvocation.INSTANCE);
    }

    public static Advice to(Class<?> cls, Class<?> cls2) {
        ClassFileLocator classFileLocator;
        ClassLoader classLoader = cls.getClassLoader();
        ClassLoader classLoader2 = cls2.getClassLoader();
        if (classLoader == classLoader2) {
            classFileLocator = ClassFileLocator.ForClassLoader.of(classLoader);
        } else {
            classFileLocator = new ClassFileLocator.Compound(ClassFileLocator.ForClassLoader.of(classLoader), ClassFileLocator.ForClassLoader.of(classLoader2));
        }
        return to(cls, cls2, classFileLocator);
    }

    public static Advice to(Class<?> cls, Class<?> cls2, ClassFileLocator classFileLocator) {
        return to(TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(cls2), classFileLocator);
    }

    public static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2) {
        return to(typeDescription, typeDescription2, (ClassFileLocator) ClassFileLocator.NoOp.INSTANCE);
    }

    public static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2, ClassFileLocator classFileLocator) {
        return j(typeDescription, typeDescription2, PostProcessor.NoOp.INSTANCE, classFileLocator, Collections.emptyList(), Delegator.ForStaticInvocation.INSTANCE);
    }
}
