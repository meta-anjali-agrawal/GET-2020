class Node {
    constructor(element) {
        this.element = element;
        this.next = null;
    }
}

class SinglyLinkedList {

    constructor() {
        this.head = null;
        this.size = 0;
    }

    add(element) {
        var node = new Node(element);
        var current;

        if (this.head == null) {
            this.head = node;
        } else {
            current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = node;
        }
        this.size++;
    }

    remove(element) {
        var current = this.head;
        var pervious = null;

        while (current != null) {
            if (current.element == element) {
                if (pervious == null) {
                    this.head = current.next;
                } else {
                    prev.next = current.next;
                }
                this.size--;
            }
            pervious = current;
            current = current.next;
        }

    }

    print() {
        var current = this.head;
        while (current) {
            console.log(current.element);
            current = current.next;
        }
    }

}

var sll = new SinglyLinkedList();
sll.print();
sll.add(10);
sll.remove(10);
sll.print();
sll.add(20);
sll.add(30);
sll.print();
sll.remove(10);
sll.print();