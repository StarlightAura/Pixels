package gay.starlight.filters;

import gay.starlight.Tag;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class TagFilter implements BiFunction<String, ArrayList<Tag>, ArrayList<String>>{
    @Override
    public ArrayList<String> apply(String type, ArrayList<Tag> tags) {

        ArrayList<Tag> filteredTag = (ArrayList<Tag>) tags.stream().filter(tag -> tag.type.equals(type)).collect(Collectors.toList());

        if(!filteredTag.isEmpty()) return filteredTag.getFirst().entries;
        return new ArrayList<String>();

    }
}
