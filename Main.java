import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        LexicalAnalyser scanner = null;
        try {
            java.io.FileInputStream stream = new java.io.FileInputStream(args[0]);
            java.io.Reader reader = new java.io.InputStreamReader(stream, StandardCharsets.UTF_8);
            scanner = new LexicalAnalyser(reader);
        }
        catch (java.io.FileNotFoundException e) {
            System.err.println("File not found : \"" + args[0] + "\"");
        }
        catch (Exception e) {
            System.err.println("Unexpected exception:");
            e.printStackTrace();
        }

        SyntaxAnalyser syntaxAnalyser = new SyntaxAnalyser(scanner);
        syntaxAnalyser.parse();
    }

}