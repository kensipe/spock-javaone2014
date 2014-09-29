package com.publisher

/**
 *
 * @author ksipe
 */
class Publisher {

    def subscribers = []

    def add(Subscriber subscriber) {
        subscribers << subscriber
    }

    def fire(String s) {

//        try {
//            subscribers.each {
//                // todo:  error handling :)
//                it.receive(s)
//            }
//        } catch (Exception e) {
//            // is this try/catch in the correct location?
//        }

        subscribers.each {
            try {
                it.receive(s)
            } catch (Exception e) {
            }
        }

    }
}
