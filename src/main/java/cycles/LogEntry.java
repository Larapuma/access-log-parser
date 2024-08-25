package cycles;

import java.util.Date;
import java.util.SplittableRandom;
import java.util.Timer;

public class LogEntry {
    private final String ipAdress;
    private final String date;
    private  HttpRequests requestMethod;
    private final String requestPath;
    private final int code;
    private final int dataSize;
    private final String referer;
    private final UserAgent userAgent;

    public LogEntry(String str) {
        this.ipAdress = str.substring(0, str.indexOf(" "));

        this.date = str.substring(str.indexOf("[") + 1, str.indexOf("]"));

        str = str.substring(str.indexOf("]")+3);



        if(str.substring(0,str.indexOf(" ")).equals("GET")) {
            this.requestMethod = HttpRequests.GET;
        }
        if(str.substring(0,str.indexOf(" ")).equals("POST")) {
            this.requestMethod = HttpRequests.POST;
        }
        if(str.substring(0,str.indexOf(" ")).equals("PUT")) {
            this.requestMethod = HttpRequests.PUT;
        }
        if(str.substring(0,str.indexOf(" ")).equals("DELETE")) {
            this.requestMethod = HttpRequests.DELETE;
        }
        str = str.substring(str.indexOf("/")+1);
        this.requestPath =str.substring(0,str.indexOf("\""));
        str = str.substring(str.indexOf("\"")+2);

        this.code = Integer.parseInt(str.substring(0,str.indexOf(" ")));
        str = str.substring(str.indexOf(" ")+1);

        this.dataSize = Integer.parseInt(str.substring(0,str.indexOf(" ")));
        str = str.substring(str.indexOf("\"")+1);
        this.referer = str.substring(0,str.indexOf("\""));
        str =  str.substring(str.indexOf(" ")+2);
        int index = str.indexOf("/");


        if(index!=-1){
            this.userAgent = new UserAgent(str.substring(str.indexOf("(")+1));
        }else{
            this.userAgent = new UserAgent(str.substring(0,str.length()-1));
        }





    }
    public String getIpAdress() {
        return ipAdress;
    }

    public String getDate() {
        return date;
    }

    public HttpRequests getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public int getCode() {
        return code;
    }

    public int getDataSize() {
        return dataSize;
    }

    public String getReferer() {
        return referer;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "ipAdress='" + ipAdress + '\'' +
                ", date='" + date + '\'' +
                ", requestMethod=" + requestMethod +
                ", requestPath='" + requestPath + '\'' +
                ", code=" + code +
                ", dataSize=" + dataSize +
                ", referer='" + referer + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
