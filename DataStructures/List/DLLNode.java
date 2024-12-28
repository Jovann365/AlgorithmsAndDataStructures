package DataStructures.List;

public class DLLNode<E> {
    public E element;
    // In original class pred and succ are made protected
    public DLLNode<E> pred;
    public DLLNode<E> succ;
    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
