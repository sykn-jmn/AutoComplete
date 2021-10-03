import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Node{
    char character;
    int frequency=0;

    ArrayList<Node> neighbors;

    public void toEnd (String passed, ArrayList<String> words){
        if(words.size()>=10){
            return;
        }
        passed = passed + character;
        if(frequency != 0){
            words.add(passed);
        }
        for(Node node: neighbors){
            node.toEnd(passed, words);
        }
    }

    public Node(char character) {
        this.character = character;
        neighbors = new ArrayList<>();
    }

    public void print(){
        System.out.println("Size: "+neighbors.size());
        for(Node node: neighbors){
            System.out.println(node.character + " : "+ node.neighbors.size());
        }
    }

    public Node getAddNode(char c){
        for(Node node: neighbors){
            if(node.character == c) return node;
        }
        return addNode(c);
    }

    public Node getNode(char c){
        for(Node node: neighbors){
            if(node.character == c) return node;
        }
        return null;
    }

    public Node addNode(char c){
        Node node = new Node(c);
        neighbors.add(node);
        return node;
    }

    public void addFrequency(){
        frequency++;
    }
    public void addNeighbor(Node node){
        neighbors.add(node);
    }
}
