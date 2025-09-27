package gay.starlight;

import gay.starlight.filters.TagFilter;
import java.util.Arrays;

public class Template {

    public static final String TEMPLATE =   """
                        ---
                        date: %tF
                        tags:
                          - Daily
                        cssclasses:
                          - daily
                          - %s
                        ---
                        # DAILY NOTE
                        ## %tA, %tB %td, %tY
                        ***
                        ### Mood Board
                        #### %s
                        ***
                        ### Mood Tracker
                        - Emotions: %s
                        - Gender: %s
                        - Hygiene: %s
                        ***
                        ### Journal
                        #### TIME
                        
                        ***
                        ### Summary
                        %s
                        ***
                        """;




    public static String template(Pixel pixel) {

        TagFilter tagFilter = new TagFilter();

        return TEMPLATE.formatted(
                pixel.getDate(), //date for the properties
                getTheFuckingWeekday(pixel), //weekday for the css style
                pixel.getDate(), pixel.getDate(),  pixel.getDate(), pixel.getDate(), //weekday, month numberday, year
                Arrays.toString(pixel.getScores()), //moodboard, it's not exact but it worksTM
                Arrays.toString(tagFilter.apply("Emotions", pixel.tags).toArray()), //this abomination filters the emotions tag
                Arrays.toString(tagFilter.apply("Gender Stuff", pixel.tags).toArray()), //this same abomination filters the gender tag
                Arrays.toString(tagFilter.apply("Hygiene", pixel.tags).toArray()), //this other abomination filters the hygiene tag
                pixel.getNotes()

        );
    }

    public static String getTheFuckingWeekday(Pixel pixel) {
        return pixel.getDate().getDayOfWeek().toString().toLowerCase();

    }
}
