import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;

public class FileManger {
    private Path copyDir;
    private File copyFile;
    private Path fileToCopy;

    public FileManger(Path copyDir, Path fileToCopy){
        this.copyDir = copyDir;
        String fileName =  fileToCopy.getFileName().toString().concat(" - copy");
        this.copyFile = new File(Paths.get(copyDir.toString(), fileName).toUri());
        this.fileToCopy = fileToCopy;
    }

    public void update() throws IOException {
        if(!copyFile.exists()){
            copyFile.createNewFile();
        }
        Long arrowCount = 0L;
        BufferedReader reader = Files.newBufferedReader(fileToCopy.normalize());
        BufferedWriter writer = Files.newBufferedWriter(Path.of(copyFile.getPath().replace("file:\\C:\\", "")));
        String currentLine;

        while((currentLine = reader.readLine()) != null){
            Long count =  arrowCount = (Pattern.compile(">")
                    .matcher(currentLine)
                    .results()
                    .count());

            if(currentLine.contains(">[!notes]") || currentLine.contains(">[!info]")){
                arrowCount = count;

                try {
                    writer.newLine();

                    writer.newLine();
                    writer.write(currentLine);
                    writer.flush();
                } catch (IOException e) {
                    IO.println("error");
                    throw new RuntimeException(e);
                }
            } else if(arrowCount > count) {

            }

        }
//        reader.lines().forEach(
//                line -> {
//                    if(line.toString().contains(">[!notes]") || line.contains(">[!info]")){
//                        IO.println(line.toString());
//                    }
//                    arrowCount ++;
//
////                    if(line.toString())
//
//                    try {
//                        writer.newLine();
//                        writer.write(line);
//                        writer.flush();
//                    } catch (IOException e) {
//                        IO.println("error");
//                        throw new RuntimeException(e);
//                    }
//                }
//        );
        fileToCopy.toFile();

//        Stream<String> String =
    }


    public String convertIntoDetails(String line){
        String updatedText;

        if(line.contains(">[!notes]") || line.contains(">[!info]")) {
            updatedText.
        }
        return "1";
    }

}

//public class FileManger {
//    private Path filePath;
//    private int fileLine;
//    private File file;
//    private Path copy;
//
//    private static Path copyPath;
//
//    public FileManger(Path path){
//        this.filePath = path;
//        this.file = path.toFile();
//    }
//
//    public FileManger(String path){
//        this.filePath = Paths.get(path);
//        File file = filePath.toFile();
//
//        if (!this.file.exists()){
//            throw  new RuntimeException("File does not exist");
//        }
//
//        if(!this.file.canRead()){
//            throw  new RuntimeException("Cannot read file");
//        }
//
//        Path parentFile = this.filePath.getParent();
//
//
//    }
//
//    public File getFile(){
//        return this.file;
//    }
//
//    public void updateDropdown() throws IOException {
//        String[] lines = (String[]) Files.lines(this.filePath).toArray();
//
//
//    }
//
//    public void printLineByLine() throws IOException {
//    for (String line : Files.readAllLines(Path.of(this.file.getAbsolutePath()))){
//            IO.println(line);
//        }
//    }
//
//    public void write(Dropdown dropdown, int endingLine){
//    }


