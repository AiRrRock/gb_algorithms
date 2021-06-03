package lesson4;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E>, Iterable<E> {

    protected Node<E> lastElement;

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null);
        insertLastNode(newNode);
    }

    protected void insertLastNode(Node<E> newNode) {
        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }
        lastElement = newNode;
        size++;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        }

        return removedValue;
    }

    public E removeLast() {
        E removedValue = lastElement.item;
        remove(lastElement.item);
        if (isEmpty()) {
            lastElement = null;
            firstElement = null;
        }
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public E getLast() {
        return getValue(lastElement);
    }
}
