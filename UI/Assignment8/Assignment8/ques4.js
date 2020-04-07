class Stack {

    constructor() {
        this.stack = [];
    }

    push(element) {
        this.stack.unshift(element);
    }

    pop() {
        this.stack.shift();
    }

    peep(value) {
        console.log(this.stack[value - 1]);
    }

}

var s = new Stack();
s.push(4);
s.push(5);
s.push(6);
s.peep(1);
s.peep(2);
s.peep(3);
s.pop();
s.peep(1);
s.peep(2);