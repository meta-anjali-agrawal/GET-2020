class Node {
    constructor(element) {
        this.previous = null;
        this.element = element;
        this.next = null;
    }
}

class DoublyLinkedList {

    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    add(element) {
        var node = new Node(element);
        var current;
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = node;
            node.previous = current;
            this.tail = node;
        }
        this.size++;
    }

    print() {
        var current = this.head;
        while (current != null) {
            console.log(current.element);
            current = current.next;
        }
    }

    remove(element) {
        var current = this.head;
        var previousNode = null;
        while (current != null) {
            if (current.element == element) {
                if (previousNode == null && current.next != null) {
                    this.head = current.next;
                } else if (current.next != null) {
                    previousNode.next = current.next;
                    current.next.previous = previousNode;
                } else {
                    current.previous = null;
                    previousNode.next = null;
                    this.tail = current.previous;
                }
            }
            previousNode = current;
            current = current.next;
        }

    }

}

var dll = new DoublyLinkedList();
dll.add(10);
dll.add(12);
dll.add(90);
dll.remove(10);