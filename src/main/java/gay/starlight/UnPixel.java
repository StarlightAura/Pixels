package gay.starlight;

import java.util.ArrayList;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)

public class UnPixel {
    @NonNull
    @EqualsAndHashCode.Include
    public String date;
    public String type;
    public int[] scores;
    public String notes;
    public ArrayList<Tag> tags;




}
