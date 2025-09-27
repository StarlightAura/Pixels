package gay.starlight;

import java.util.function.Function;

public class PixelConversor implements Function<UnPixel, Pixel> {

    @Override
    public Pixel apply(UnPixel unPixel) {

        return new Pixel(unPixel.getDate(),
                                unPixel.getType(),
                                unPixel.getScores(),
                                unPixel.getNotes(),
                                unPixel.getTags());
    }
}
