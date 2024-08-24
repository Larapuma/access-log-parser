package cycles;

public class UserAgent {
    private final String osType;
    private final String browser;
    public UserAgent(String str){
        this.browser ="";
        this.osType = "";
    }
    public String getOsType() {
        return osType;
    }
}
