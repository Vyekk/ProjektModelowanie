package ekomp.Helpers;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public abstract class ObjectPlus implements Serializable {
    private static Map<Class, List<ObjectPlus>> allExtents = new Hashtable<>();
    public ObjectPlus() {
        List<ObjectPlus> extent = null;
        Class theClass = this.getClass();

        if (allExtents.containsKey(theClass)) {
            extent = allExtents.get(theClass);
        } else {
            extent = new ArrayList<>();
            allExtents.put(theClass,extent);
            extent.add(this);
        }
    }

    public static <T> Iterable <T> getExtent(Class<T> type) throws ClassNotFoundException {
        if(allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }
        throw new ClassNotFoundException(String.format("%s. Stored extents: %s", type.toString(),allExtents.keySet()));
    }

    public static void showExtent(Class theClass) throws Exception {
        List<ObjectPlus> extent = null;

        if(allExtents.containsKey(theClass)) {
            extent = allExtents.get(theClass);
        } else {
            throw new Exception("Nieznana klasa");
        }
        for (Object obj: extent) {
            System.out.println(obj.toString());
        }
    }

    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }

    public static void readExtents(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (Hashtable) stream.readObject();
    }
}
