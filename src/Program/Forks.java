package Program;

import java.util.concurrent.locks.ReentrantLock;

class Forks {
private final ReentrantLock lock = new ReentrantLock();

        public void pickUp() {
                lock.lock();
        }

        public void putDown() {
                lock.unlock();
        }

}
