package HW0911;

class LinkedList {

    private Node head;

    public Node getHead(){
        return head;
    }

    public Node getNext(){
        return head.getNext();
    }

    public int getData(){
        return head.getData();
    }

    public void setHead(){
        head = head.getNext();
    }


    public LinkedList(){
        head = null;
    }

    public LinkedList(int[] arr){
        for(int item : arr){
            head = null;
            addLast(item);
        }
    }

    public void addFirst(int num){
        head = new Node(num, head);
    }

    public void addLast(int num){
        if(head == null)
            addFirst(num);
        else{
            Node tmp = head;
            while(tmp.link != null)
                tmp = tmp.link;
            tmp.link = new Node(num, null);
        }
    }

    private class Node{
        private int data;
        private Node link;

        public Node(int num, Node n){
            data = num;
            link = n;
        }

        public Node getNext(){
            return this.link;
        }

        public int getData(){
            return this.data;
        }
    }


}
