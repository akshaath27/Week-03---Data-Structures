public class Concatenation {
    public static String concatenateStrings(String[] strings){
        StringBuffer result=new StringBuffer();
        for(String str:strings){
            result.append(str);
        }
        return result.toString();
    }
    public static void main(String[]args)
    {
        String[]words={"hello","","world","!","welcome","to","java"};
        String concatenated=concatenateStrings(words);
        System.out.println(concatenated);
    }
}
