package Authentications;

public class Payload {

    public static String book(){
    return "{\n" +
            "      \"book\":[  \n" +
            "         {  \n" +
            "            \"author\":\"Nigel Rees\",\n" +
            "            \"category\":\"reference\",\n" +
            "            \"price\":8.95,\n" +
            "            \"title\":\"Sayings of the Century\"\n" +
            "         },\n" +
            "         {  \n" +
            "            \"author\":\"Evelyn Waugh\",\n" +
            "            \"category\":\"fiction\",\n" +
            "            \"price\":12.99,\n" +
            "            \"title\":\"Sword of Honour\"\n" +
            "         },\n" +
            "         {  \n" +
            "            \"author\":\"Herman Melville\",\n" +
            "            \"category\":\"fiction\",\n" +
            "            \"isbn\":\"0-553-21311-3\",\n" +
            "            \"price\":8.99,\n" +
            "            \"title\":\"Moby Dick\"\n" +
            "         },\n" +
            "         {  \n" +
            "            \"author\":\"J. R. R. Tolkien\",\n" +
            "            \"category\":\"fiction\",\n" +
            "            \"isbn\":\"0-395-19395-8\",\n" +
            "            \"price\":22.99,\n" +
            "            \"title\":\"The Lord of the Rings\"\n" +
            "         }\n" +
            "      ]  \n" +
            "}";
    }
}
