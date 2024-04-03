package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public interface IListenableWorkerImpl extends IInterface {

    public static class Default implements IListenableWorkerImpl {
        public IBinder asBinder() {
            return null;
        }

        public void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IListenableWorkerImpl {
        private static final String DESCRIPTOR = "androidx.work.multiprocess.IListenableWorkerImpl";

        public static class Proxy implements IListenableWorkerImpl {
            public static IListenableWorkerImpl sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().interrupt(bArr, iWorkManagerImplCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().startWork(bArr, iWorkManagerImplCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IListenableWorkerImpl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IListenableWorkerImpl)) {
                return new Proxy(iBinder);
            }
            return (IListenableWorkerImpl) queryLocalInterface;
        }

        public static IListenableWorkerImpl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IListenableWorkerImpl iListenableWorkerImpl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iListenableWorkerImpl == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iListenableWorkerImpl;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                startWork(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                interrupt(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;
}
