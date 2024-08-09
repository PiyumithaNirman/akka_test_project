package org.example.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class Main {
    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("akka-demo");

        ActorRef parent = system.actorOf(org.example.akka.ParentActor.props(), "parent");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            system.terminate();
        }
    }
}




















// Send a message to parent to trigger sending messages to children
//        parent.tell("sendToChildren", ActorRef.noSender());

// Simulate a message from ChildActor1 to ChildActor2 via ParentActor
//        parent.tell(new Messages.ForwardMessage("Forwarded message from ChildActor1 to ChildActor2"), ActorRef.noSender());

//        org.example.akka.ParentActor parentActor = new org.example.akka.ParentActor();

//        child1.tell(new Messages.ParentMessage("Forward to parent", parent),ActorRef.noSender() );

// Shutdown the system after some delay to see the output










































































