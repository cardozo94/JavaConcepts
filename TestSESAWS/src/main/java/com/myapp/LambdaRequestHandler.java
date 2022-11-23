package com.myapp;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaRequestHandler  implements RequestHandler<Object, Object> {

    public LambdaRequestHandler(){
    }
    @Override
    public Object handleRequest(Object s, Context context) {
        App.process();
        System.out.println("Hello Lambdas' world");
        return "OK";
    }
}
