package com.JavaTechmaster.app;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static final String WARNING = "WARNING";
    public static final String ERROR = "ERROR";
    public static final String INFO = "INFO";
    ColoredPrinter coloredPrinter = new ColoredPrinter.Builder(1, false)
            .foreground(Ansi.FColor.WHITE).background(Ansi.BColor.BLUE)
            .build();
    private static Logger instance;
    //private constructor để tránh gọi từ bên ngoài
    private Logger(){
        System.out.println("Initializing Logger object");
    }
    //Ko có setter !
    public static Logger getInstance(){
        //Kiểu "lazy" = "Khi nào gọi đến mới khởi tạo"
        //synchronized: tại 1 thời điểm chỉ có 1 thread
        synchronized (Logger.class) {
            if(instance == null){
                instance = new Logger();
            }
        }
        return instance;
    }
    //instance method
    public void show(String content, String loggerType) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String strDate = dtf.format(now);
        switch (loggerType) {
            case WARNING:
                //Print log with color ?
                coloredPrinter.print("\n"+strDate+content,
                        Ansi.Attribute.BOLD,
                        Ansi.FColor.YELLOW,
                        Ansi.BColor.BLACK);
            case ERROR:
                coloredPrinter.print("\n"+strDate+content,
                        Ansi.Attribute.BOLD,
                        Ansi.FColor.RED,
                        Ansi.BColor.BLACK);
                break;
            case INFO:
                coloredPrinter.print("\n"+strDate+content,
                        Ansi.Attribute.NONE,
                        Ansi.FColor.GREEN,
                        Ansi.BColor.BLACK);
                break;
            default:
                coloredPrinter.print("\n"+strDate+content,
                        Ansi.Attribute.NONE,
                        Ansi.FColor.GREEN, Ansi.BColor.BLACK);
                break;

        }
    }
}
