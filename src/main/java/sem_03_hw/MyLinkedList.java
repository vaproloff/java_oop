package sem_03_hw;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {

    private Node<E> firstElement = null;
    private Node<E> lastElement = null;
    private int listSize = 0;

    public void add(E newElement) {
        add(listSize, newElement);
    }

    public void add(int index, E newElement) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is out of list bounds");
        } else {
            Node<E> curNode = new Node<>(newElement);
            if (listSize == 0) {
                firstElement = curNode;
                lastElement = curNode;
            } else {
                if (index == 0) {
                    curNode.setNext(firstElement);
                    firstElement.setPrevious(curNode);
                    firstElement = curNode;
                } else if (index >= listSize) {
                    curNode.setPrevious(lastElement);
                    lastElement.setNext(curNode);
                    lastElement = curNode;
                } else {
                    curNode.setNext(getNode(index));
                    curNode.setPrevious(curNode.getNext().getPrevious());
                    curNode.getPrevious().setNext(curNode);
                    curNode.getNext().setPrevious(curNode);
                }

            }
            listSize++;
        }
    }

    public void addAll(Collection<E> newElements) {
        addAll(listSize, newElements);
    }

    public void addAll(int index, Collection<E> newElements) {
        for (E newElement: newElements) {
            add(index++, newElement);
        }
    }

    public E get(int index) {
        return getNode(index).getElement();
    }

    private Node<E> getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index is out of list bounds");
        } else {
            if (index < listSize / 2) {
                Node<E> node = firstElement;
                for (int i = 1; i <= index; i++) {
                    node = node.getNext();
                }
                return node;
            } else {
                Node<E> node = lastElement;
                for (int i = listSize - 1; i > index; i--) {
                    node = node.getPrevious();
                }
                return node;
            }
        }
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index is out of list bounds");
        }
        return removeNode(index).getElement();

    }

    private Node<E> removeNode(int index) {
        Node<E> curNode;
        if (index == 0) {
            curNode = firstElement;
            curNode.getNext().setPrevious(null);
            firstElement = curNode.getNext();
        } else if (index == listSize - 1) {
            curNode = lastElement;
            curNode.getPrevious().setNext(null);
            lastElement = curNode.getPrevious();
        } else {
            curNode = getNode(index);
            curNode.getPrevious().setNext(curNode.getNext());
            curNode.getNext().setPrevious(curNode.getPrevious());
        }
        listSize--;
        return curNode;
    }

    public int size() {
        return listSize;
    }

    public E set(int index, E newElement) throws IndexOutOfBoundsException {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index is out of list bounds");
        }
        return setNode(index, newElement).getElement();
    }

    private Node<E> setNode(int index, E newElement) {
        Node<E> oldNode;
        Node<E> newNode = new Node<>(newElement);
        if (index == 0) {
            oldNode = firstElement;
            oldNode.getNext().setPrevious(newNode);
            newNode.setNext(oldNode.getNext());
            firstElement = newNode;
        } else if (index == listSize - 1) {
            oldNode = lastElement;
            oldNode.getPrevious().setNext(newNode);
            newNode.setPrevious(oldNode.getPrevious());
            lastElement = newNode;
        } else {
            oldNode = getNode(index);
            oldNode.getPrevious().setNext(newNode);
            oldNode.getNext().setPrevious(newNode);
            newNode.setNext(oldNode.getNext());
            newNode.setPrevious(oldNode.getPrevious());
        }
        return oldNode;
    }

    public int indexOf(E elementToFind) {
        int counter = 0;
        for (E element: this) {
            if (element.equals(elementToFind)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    public boolean contains(E elementToFind) {
        return indexOf(elementToFind) >= 0;
    }

    public boolean containsAll(Collection<E> elementsToFind) {
        for (E elementToFind: elementsToFind) {
            if (!contains(elementToFind)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return listSize == 0;
    }

    public void clear() {
        firstElement = null;
        lastElement = null;
        listSize = 0;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder().append("{");
        int index = 0;
        for (E element: this) {
            output.append(element);
            if (index != listSize - 1) {
                output.append(", ");
            }
            index++;
        }
        output.append("}");

        return output.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < listSize;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private class Node<E> {

        private final E element;
        private Node<E> next = null;
        private Node<E> previous = null;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
