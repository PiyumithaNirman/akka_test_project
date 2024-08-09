package org.example.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class ChildActor1 extends AbstractActor {

    public static Props props() {
        return Props.create(ChildActor1.class);
    }

    @Override
    public void preStart() {

        String message = "Hello Actors";
        System.out.println("ChildActor1 send message to ParentActor: "+ message);
        getContext().getParent().tell(new Messages.Child1MessageToParent(message),getSelf());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Messages.ParentForwardToChild1.class, this::handleParentForwardToChild1)
                .build();
    }


    private void handleParentForwardToChild1(Messages.ParentForwardToChild1 parentForwardToChild1) {

        System.out.println("ChildActor1 received response from ParentActor: " + parentForwardToChild1.content);

    }

}

