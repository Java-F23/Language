import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java. util. Scanner;

public class Main {

        public static void main(String[] args) {

            ArrayList<String> p1 = new ArrayList<>();
            p1.add("Easy");
            Language Eng = new Language("English", p1, "America", "Nice", 1);
            LanguageCategorization l = new LanguageCategorization();
            l.addLanguage(Eng);
            //Filter by pop range works
            Language [] l1 = l.filterByRegion("America");
            Language [] l2 = l.filterByProficiencyLevels(p1);
            Language [] l3 = l.filterByLanguageAndProficiency(Eng.getName(), p1.get(0));
            //System.out.println(l1[0]);
            //System.out.println(l2[0]);
            System.out.println(l3[0]);
            //Problem is in Lang Categorization, the function itself is amiss!!
        }

}