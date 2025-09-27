package gay.starlight;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class FilesCreator implements Consumer<Pixel>{

    @Override
    public void accept(Pixel pixel) {
        File file = new File("out/" + pixel.getDate() + ".md");
        if (!file.exists()) {
            try {
                file.createNewFile();
                writer(file, pixel);
            } catch (IOException e) {
                System.err.println("Could not create file " + file);
                throw new RuntimeException(e);
            }
        }
        if (file.exists()) {

            try {
                writer(file, pixel);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void writer(File file, Pixel pixel) throws IOException {
        System.out.println(file.getAbsolutePath());
        System.out.println("Writing pixel");
//        FileWriter fw = new FileWriter(file);
//        BufferedWriter bw = new BufferedWriter(fw);

        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        writer.write(Template.template(pixel));

    }
}
