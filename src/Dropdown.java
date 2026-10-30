import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dropdown {
    private ArrayList<String> detail;
    private String summary;
    private int startLine;
    private int endLine;
    private int arrowOffset;


    public Dropdown(int lineStart, int offset, String summary){
            this.startLine = lineStart;
            this.arrowOffset =  offset;
            this.summary = summary;

    }

    public String getSummary(){
        return this.summary;
    }

    public ArrayList<String> getDetail(){
        return this.detail;
    }

}
