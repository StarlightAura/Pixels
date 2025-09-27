package gay.starlight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)

public class Pixel {
    @NonNull
    @EqualsAndHashCode.Include
    public LocalDate date;
    public String type;
    public int[] scores;
    public String notes;
    public ArrayList<Tag> tags;


    public Pixel(String dateString, String type, int[] scores, String notes, ArrayList<Tag> tags) {
        setDate(dateString);
        this.type = type;
        this.scores = scores;
        this.notes = notes;
        this.tags = tags;
    }


    public void setDate(@NonNull String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("u-M-d");
        this.date = LocalDate.parse(date, formatter);
    }
}
