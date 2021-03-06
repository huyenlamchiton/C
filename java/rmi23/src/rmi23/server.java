package rmi23;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;


public class server {
  private static final int PORT = 1095;
  private static Registry registry;
  public static ArrayList<sinhVienClass> svList=new ArrayList<sinhVienClass>();
  public static void startRegistry() throws RemoteException {

  
      registry =  LocateRegistry.createRegistry(PORT);
  }

  public static void registerObject(String name, Remote remoteObj)
          throws RemoteException, AlreadyBoundException {


      registry.bind(name, remoteObj);
      System.out.println("Registered: " + name + " -> "
              + remoteObj.getClass().getName() + "[" + remoteObj + "]");
  }

  public static void main(String[] args) throws Exception {
      System.out.println("Server starting...");
      startRegistry();
      sinhVienClass a=new sinhVienClass("ahihi", 12);
      System.out.println(a.getAge());
      svList.add(a);
      xuLi xl=new xuLi(svList);
      registerObject(xuLi.class.getSimpleName(),xl);

      System.out.println("Server started!");
  }
}
