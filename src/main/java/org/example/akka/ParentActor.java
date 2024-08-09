package org.example.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class ParentActor extends AbstractActor {
    private ActorRef child1;
    private ActorRef child2;

    @Override
    public void preStart() {

        // Perform initialization or setup tasks here
        child1 = getContext().actorOf(org.example.akka.ChildActor1.props(), "child1");
        System.out.println("child1 is starting");
        child2 = getContext().actorOf(org.example.akka.ChildActor2.props(), "child2");
        System.out.println("child2 is starting");
    }

    public static Props props() {
        return Props.create(ParentActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Messages.Child1MessageToParent.class, this::handleChild1SendToParent)
                .match(Messages.Child2ForwardMessageToParent.class, this::handleChild2ForwardMessageToParent)
                .build();
    }

    private void handleChild1SendToParent(Messages.Child1MessageToParent child1SendToParent) {

        System.out.println("ParentActor send message to ChildActor2: " + child1SendToParent.content);
        child2.tell(new Messages.ParentMessageToChild2(child1SendToParent.content), getSelf());
    }

    private void handleChild2ForwardMessageToParent(Messages.Child2ForwardMessageToParent child2ForwardMessageToParent) {

        System.out.println("ParentActor forwarding message to ChildActor1: " + child2ForwardMessageToParent.content);
        child1.tell(new Messages.ParentForwardToChild1(child2ForwardMessageToParent.content), getSelf());
    }

}

