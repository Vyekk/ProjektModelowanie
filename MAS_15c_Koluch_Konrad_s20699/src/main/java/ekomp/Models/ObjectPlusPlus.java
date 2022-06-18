package ekomp.Models;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public abstract class ObjectPlusPlus extends ObjectPlus{
    private Map<String,Map<Object,ObjectPlusPlus>> links = new Hashtable<>();
    private static Set<ObjectPlusPlus> allParts = new HashSet<>();

    public ObjectPlusPlus() {
        super();
    }
}
