public class ReverseString {
    public static String reverseusingStringbuiler(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public static void main(String[]args){
        String input="hello";
        String reversed=reverseusingStringbuiler(input);
        System.out.println("origunal:  "+input);
        System.out.println("reversed string:  "+reversed);
    }
}
