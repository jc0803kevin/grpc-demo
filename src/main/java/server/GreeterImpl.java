package server;

import grpc.GreeterGrpc;
import grpc.GreeterMessage;
import io.grpc.stub.StreamObserver;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(GreeterMessage.GreeterHelloRequest request, StreamObserver<GreeterMessage.GreeterHelloReply> responseObserver) {
        System.out.println("************sayHello******************" + request.getName());

        GreeterMessage.GreeterHelloReply reply = GreeterMessage.GreeterHelloReply.newBuilder()
                .setMessage("I am " + request.getName())
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }


    @Override
    public void sayHelloAgain(GreeterMessage.GreeterHelloRequest request, StreamObserver<GreeterMessage.GreeterHelloReply> responseObserver) {
        System.out.println("************sayHelloAgain******************" + request.getName());

        GreeterMessage.GreeterHelloReply reply = GreeterMessage.GreeterHelloReply.newBuilder()
                .setMessage("Again, I am " + request.getName())
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }
}
