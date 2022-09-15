package com.grpc.demoGRPC.demoGRPC.client;

import com.grpc.demoGRPC.demoGRPC.grpc.stub.Greeting;
import com.grpc.demoGRPC.demoGRPC.grpc.stub.HelloWorldServiceGrpc;
import com.grpc.demoGRPC.demoGRPC.grpc.stub.Person;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldClient {

    ManagedChannel managedChannel= ManagedChannelBuilder
            .forAddress("localhost",6565)
            .usePlaintext()
            .build();

    HelloWorldServiceGrpc.HelloWorldServiceBlockingStub helloWorldServiceBlockingStub=HelloWorldServiceGrpc
            .newBlockingStub(managedChannel);

    public String sayHello(String firstName, String lastName) {
        Person person = Person.newBuilder().setFirstName(firstName)
                .setLastName(lastName).build();
        Greeting greeting =
                helloWorldServiceBlockingStub.sayHello(person);

        return greeting.getMessage();
    }
}
