class Queue {

    constructor() {
        this.queue = [];
    }

    enqueue(element) {
        this.queue.push(element);
    }

    dequeue() {
        this.queue.shift();
    }

    front() {
        console.log(this.queue[0]);
    }

    rear() {
        console.log(this.queue[this.queue.length - 1]);
    }

}

var q = new Queue();
q.enqueue(1);
q.enqueue(2);
q.enqueue(3);
q.front();
q.rear();
q.dequeue();
q.front();
q.rear();