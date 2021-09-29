package com.xiwei.demo;

import org.apache.commons.collections.functors.InvokerTransformer;

public class TestInvokerTransformer {
    public static void main(String[] args) {
        InvokerTransformer run = new InvokerTransformer("exec",
                new Class[]{String.class},
                new Object[]{"calc"});
        run.transform(Runtime.getRuntime());
    }
}
