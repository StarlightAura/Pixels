package gay.starlight;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        ArrayList<UnPixel> unPixels = new ArrayList<>();
        ArrayList<Pixel> pixels = new ArrayList<>();
        Gson gson = new Gson();

        try (BufferedReader fichero = new BufferedReader (new FileReader("PIXELS2.json")) )
        {

            while (fichero.ready())
            {
                Type collectionType = new TypeToken<ArrayList<UnPixel>>(){}.getType();
                unPixels = gson.fromJson(fichero, collectionType);

                unPixels.forEach(System.out::println);
            }
        }

        catch (IOException e){
            System.out.println("Error accediendo al fichero...");
        }

        PixelConversor pixelConversor = new PixelConversor();
        unPixels.forEach((p) -> pixels.add(pixelConversor.apply(p)));
        //pixels.forEach(System.out::println);

        Consumer<Pixel> filesCreator = new FilesCreator();
        pixels.forEach( filesCreator );


    }


}