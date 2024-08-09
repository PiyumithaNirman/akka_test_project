package org.example.akka;

public class Messages {

    public static class ParentMessageToChild2 {
        public final String content;

        public ParentMessageToChild2(String content) {
            this.content = content;
        }
    }

    public static class Child2ForwardMessageToParent {
        public final String content;

        public Child2ForwardMessageToParent(String content) {
            this.content = content;
        }
    }


    public static class ForwardMessageParent {

        public final String content;

        public ForwardMessageParent(String content) {
            this.content = content;
        }
    }

    public static class ParentForwardToChild1 {

        public final String content;

        public ParentForwardToChild1(String content) {
            this.content = content;
        }
    }

    public static class ForwardResponseMessageToParent {

        public final String content;

        public ForwardResponseMessageToParent(String content) {
            this.content = content;
        }
    }

    public static class ForwardParentResponseMessage {

        public final String content;

        public ForwardParentResponseMessage(String content) {
            this.content = content;
        }
    }

//    public static class Child1SendToParent {
//
//        public final String content;
//
//        public Child1SendToParent(String content) {
//            this.content = content;
//        }
//    }

    public static class Child1MessageToParent {

        public final String content;

        public Child1MessageToParent(String content) {
            this.content = content;
        }
    }
}

