import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Node starter = loadNode(new Node((char)0));
        Node currentNode = starter;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Finished Loading");
        String wordSoFar = "";
        char c = '!';
        ArrayList<String> words = new ArrayList<>();
        while(c!=' '){
            c = (char)br.readLine().charAt(0);
            currentNode = currentNode.getNode(c);

            words.clear();

            if (currentNode==null) words.add("No Suggestions");
            else {
                currentNode.toEnd(wordSoFar, words);
            }
            for(int i = 0; i <10; i++) System.out.println();
            for(String word: words){
                System.out.println(word);
            }
            wordSoFar = wordSoFar+c;
            System.out.print(wordSoFar);
        }
    }








    public static Node loadNode(Node starter) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("src/most_common_words.txt")));
        String word;
        while((word = br.readLine()) != null){
            Node currentNode = starter.getAddNode(word.charAt(0));
            if(word.length()==1) currentNode.addFrequency();

            for(int i = 1; i <word.length(); i++){
                currentNode = currentNode.getAddNode(word.charAt(i));
                if(i==word.length()-1) currentNode.addFrequency();
            }
        }
        return starter;
    }
}
