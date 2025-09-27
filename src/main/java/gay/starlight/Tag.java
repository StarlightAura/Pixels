package gay.starlight;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Tag {
    public String type;
    public ArrayList<String> entries;



}
