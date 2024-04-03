package net.bytebuddy.implementation.bytecode.constant;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.jar.asm.MethodVisitor;

@HashCodeAndEqualsPlugin.Enhance
public class SerializedConstant extends StackManipulation.AbstractBase {
    private static final String CHARSET = "ISO-8859-1";
    private final String serialization;

    public SerializedConstant(String str) {
        this.serialization = str;
    }

    public static StackManipulation of(Serializable serializable) {
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            return NullConstant.INSTANCE;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return new SerializedConstant(byteArrayOutputStream.toString("ISO-8859-1"));
        } catch (IOException e11) {
            throw new IllegalStateException("Cannot serialize " + serializable, e11);
        } catch (Throwable th2) {
            objectOutputStream.close();
            throw th2;
        }
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        Class<String> cls = String.class;
        Class<ByteArrayInputStream> cls2 = ByteArrayInputStream.class;
        Class<ObjectInputStream> cls3 = ObjectInputStream.class;
        try {
            Duplication duplication = Duplication.SINGLE;
            return new StackManipulation.Compound(TypeCreation.of(TypeDescription.ForLoadedType.of(cls3)), duplication, TypeCreation.of(TypeDescription.ForLoadedType.of(cls2)), duplication, new TextConstant(this.serialization), new TextConstant("ISO-8859-1"), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(cls.getMethod("getBytes", new Class[]{cls}))), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(cls2.getConstructor(new Class[]{byte[].class}))), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(cls3.getConstructor(new Class[]{InputStream.class}))), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(cls3.getMethod("readObject", new Class[0])))).apply(methodVisitor, context);
        } catch (NoSuchMethodException e11) {
            throw new IllegalStateException("Could not locate Java API method", e11);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.serialization.equals(((SerializedConstant) obj).serialization);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.serialization.hashCode();
    }
}
