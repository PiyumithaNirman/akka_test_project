package org.example.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class ChildActor2 extends AbstractActor {

    public static Props props() {
        return Props.create(ChildActor2.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Messages.ParentMessageToChild2.class, this::handleParentMessageToChild2)
                .build();
    }

    private void handleParentMessageToChild2(Messages.ParentMessageToChild2 parentMessageToChild2) {
        System.out.println("ChildActor2 forwarding message to ParentActor: " + parentMessageToChild2.content);
        getSender().tell(new Messages.Child2ForwardMessageToParent(parentMessageToChild2.content), getSelf());
    }

}

