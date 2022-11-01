package Serialization_Deserialization;

public class Support_Pojo {
    private String url;
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Support_pojo{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
