package com.grpc.demoGRPC.demoGRPC.grpc.service;

import com.grpc.demoGRPC.demoGRPC.grpc.stub.Greeting;
import com.grpc.demoGRPC.demoGRPC.grpc.stub.HelloWorldServiceGrpc;
import com.grpc.demoGRPC.demoGRPC.grpc.stub.Person;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void sayHello(Person request, StreamObserver<Greeting> responseObserver) {
        String message = "Hello " + request.getFirstName() + " "
                + request.getLastName() + ". This is a response from the server";

        Greeting greeting= Greeting.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(greeting);
        responseObserver.onCompleted();
    }
}
