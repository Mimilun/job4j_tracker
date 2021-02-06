package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

//    public static List<Attachment> filterSize(List<Attachment> list) {
//        List<Attachment> rsl = new ArrayList<>();
//        for (Attachment att : list) {
//            if (att.getSize() > 100) {
//                rsl.add(att);
//            }
//        }
//        return rsl;
//    }

//    public static List<Attachment> filterName(List<Attachment> list) {
//        List<Attachment> rsl = new ArrayList<>();
//        for (Attachment att : list) {
//            if (att.getName().contains("bug")) {
//                rsl.add(att);
//            }
//        }
//        return rsl;
//    }

    public static List<Attachment> filterSize(List<Attachment> list, int filter) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {

            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > filter;
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list, String filter) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains(filter);
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {

        List<Attachment> rsl = new ArrayList<>();
        for (Attachment attachment : list) {
            if (predicate.test(attachment)) {
                rsl.add(attachment);
            }
        }
        return rsl;
    }
}
