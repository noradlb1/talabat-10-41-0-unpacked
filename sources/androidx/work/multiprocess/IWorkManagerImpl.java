package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public interface IWorkManagerImpl extends IInterface {

    public static class Default implements IWorkManagerImpl {
        public IBinder asBinder() {
            return null;
        }

        public void cancelAllWork(IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void cancelAllWorkByTag(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void cancelUniqueWork(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void cancelWorkById(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void enqueueContinuation(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void enqueueWorkRequests(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void queryWorkInfo(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        public void setProgress(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImpl {
        private static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImpl";

        public static class Proxy implements IWorkManagerImpl {
            public static IWorkManagerImpl sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void cancelAllWork(IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(6, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().cancelAllWork(iWorkManagerImplCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void cancelAllWorkByTag(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(4, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().cancelAllWorkByTag(str, iWorkManagerImplCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void cancelUniqueWork(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(5, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().cancelUniqueWork(str, iWorkManagerImplCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void cancelWorkById(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iWorkManagerImplCallback != null) {
                        iBinder = iWorkManagerImplCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().cancelWorkById(str, iWorkManagerImplCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void enqueueContinuation(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
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
                        Stub.getDefaultImpl().enqueueContinuation(bArr, iWorkManagerImplCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void enqueueWorkRequests(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
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
                        Stub.getDefaultImpl().enqueueWorkRequests(bArr, iWorkManagerImplCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void queryWorkInfo(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
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
                    if (this.mRemote.transact(7, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().queryWorkInfo(bArr, iWorkManagerImplCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void setProgress(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
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
                    if (this.mRemote.transact(8, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setProgress(bArr, iWorkManagerImplCallback);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IWorkManagerImpl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWorkManagerImpl)) {
                return new Proxy(iBinder);
            }
            return (IWorkManagerImpl) queryLocalInterface;
        }

        public static IWorkManagerImpl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IWorkManagerImpl iWorkManagerImpl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iWorkManagerImpl == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iWorkManagerImpl;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 != 1598968902) {
                switch (i11) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        enqueueWorkRequests(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        enqueueContinuation(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelWorkById(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelAllWorkByTag(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelUniqueWork(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelAllWork(IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        queryWorkInfo(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        setProgress(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    default:
                        return super.onTransact(i11, parcel, parcel2, i12);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void cancelAllWork(IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void cancelAllWorkByTag(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void cancelUniqueWork(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void cancelWorkById(String str, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void enqueueContinuation(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void enqueueWorkRequests(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void queryWorkInfo(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void setProgress(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;
}
