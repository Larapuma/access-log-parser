package cycles;

public class UserAgent {

    enum OS{
        WINDOWS,LINUX,MACOS
    }
    enum BrowserType{
        FIREFOX,CHROME,EDGE,OPERA,SAFARI

    }
    private final OS osType;
    private final BrowserType browser;


    public UserAgent(String str){ // сюда приходит строка в скобке, нужно
        // прописать варианты когда есть ; и когда нет. прописать
        // как вычленять ОС. Попробовать использовать containes
//        String strOS = str.substring(0,str.indexOf(";"));
        if(str.contains("Linux")) {
            this.osType = OS.LINUX;
        }else if(str.contains("Windows")){
            this.osType = OS.WINDOWS;
        }else  if(str.contains("Mac")){
            this.osType = OS.MACOS;
        }
        else {
            this.osType = null;
        }


        if(str.contains("Firefox")){
            this.browser = BrowserType.FIREFOX;
        }else if(str.contains("OPR")){
            this.browser = BrowserType.OPERA;

        }else if(str.contains("Chrome")){
            this.browser = BrowserType.CHROME;
        }else if(str.contains("Edg")){
            this.browser =BrowserType.EDGE;

        }else if(str.contains("Mobile")) {
            this.browser = BrowserType.SAFARI;
        }
        else{
            this.browser = null;
        }




    }
    public OS getOsType() {
        return osType;

    }
    public BrowserType getBrowser(){
        return browser;
    }

    @Override
    public String toString() {
        return "UserAgent{" +
                "osType=" + osType +
                ", browser=" + browser +
                '}';
    }
}
