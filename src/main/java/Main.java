
public class Main {
    public static final String NASAURL = "https://api.nasa.gov/planetary/apod?api_key=awoO8GTk8EPpka1e4LR3hmML3cmrdve2YvxaLQXZ";

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.get();
        byte[] input = httpClient.getContentFromURL(NASAURL);
        JsonToObjectParser json = JsonToObjectParser.get();
        NasaResponse nasaResponse = json.convert(new String(input));
        String newUrl = nasaResponse.getUrl();
        input = httpClient.getContentFromURL(newUrl);
        FileWriter fileWriter = FileWriter.get();
        fileWriter.writeFile(newUrl.substring(newUrl.lastIndexOf("/") + 1), input);

    }

}
