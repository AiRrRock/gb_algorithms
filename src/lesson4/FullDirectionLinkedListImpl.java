package lesson4;

public class FullDirectionLinkedListImpl<E> extends TwoSideLinkedListImpl<E> implements FullDirectionLinkedList<E> {

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = this.lastElement;
        if (firstElement == lastElement) {
            firstElement = null;
        }
        lastElement = lastElement.previous;

        if (removedNode.previous != null) {
            removedNode.previous.next = null;
            removedNode.previous = null;
        }

        size--;
        return removedNode.item;
    }

    @Override
    public E removeFirst() {
        E result = super.removeFirst();
        if (firstElement != null) {
            firstElement.previous = null;
        }
        return result;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (firstElement.next != null) {
            firstElement.next.previous = firstElement;
        }
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null, lastElement);
        insertLastNode(newNode);
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
            current.next.previous = previous;
        }

        current.next = null;
        current.previous = null;
        size--;
        return true;
    }
}
