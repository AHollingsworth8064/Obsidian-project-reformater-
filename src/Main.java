import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Path originalPath = Paths.get("C:\\Users\\Dimen\\Documents\\FRC Writing\\FRC Training Manual\\FRC Training Manual");
        Path parent = originalPath.getParent();

        Path copyDirectory = null;

        if(!Files.isDirectory(parent)) return;

        DirectoryStream<Path> parentDirectory =  Files.newDirectoryStream(parent);
        Iterator<Path> parentIterator = parentDirectory.iterator();

        while (parentIterator.hasNext()) {
            Path next = parentIterator.next();
            if(next.getFileName().toString().contains("- copy")){
                copyDirectory = next;
                break;
            }
        }

        if(copyDirectory == null){
            Files.createDirectories(Path.of(originalPath.getParent().toString().replace(".md", " - copy")));
            copyDirectory = Paths.get(originalPath.getParent().toString().concat( " - copy"));
        }

//        FileManger fileManger = new FileManger(copyDirectory.toString())
        if(Files.isDirectory(originalPath.getParent()));{
            Path finalCopyDirectory = copyDirectory;

            Files.newDirectoryStream(originalPath.getParent()).forEach(path -> {
                try {
                    FileManger test = new FileManger(finalCopyDirectory,path);
                    test.update();
                } catch (IOException e) {
                    IO.println(e.getMessage());
//                    throw new RuntimeException(e);
                }
            });
        }

    }
}
