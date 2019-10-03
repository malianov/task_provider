package hire.me;

public class Splitter {
    public static char rowType(String string) {
        return string.charAt(0);
    }

    public static String[] rowSplitter(String string) {
        return string.split(" ");
    }

    public static String[] serviceSplitter(String[] string) {
        String[] serviceSplitted = new String[2];
        if(string[1].contains("\\.")) {
            serviceSplitted[0] = string[1];
        } else {
            serviceSplitted = string[1].split("\\.");
        }
        return serviceSplitted;
    }

    public static String[] questionSplitter(String[] string) {
        String[] questionSplitted = new String[3];

        if(string[2].contains("\\.")) {
            questionSplitted[0] = string[2];
        } else {
            questionSplitted = string[2].split("\\.");
        }
        return questionSplitted;
    }

    public static String[] dateSplitter(String string) {
        String[] dateSplitted = new String[2];
        if(string.contains("-")) {
            dateSplitted = string.split("-");
        } else {
            dateSplitted[0] = string;
            dateSplitted[1] = dateSplitted[0];
        }
        if(dateSplitted[0].length() == 9)
            dateSplitted[0] = staffing(dateSplitted[0]);
        if(dateSplitted[1].length() == 9)
            dateSplitted[1] = staffing(dateSplitted[1]);
        return dateSplitted;
    }

    private static String staffing(String date) {
        date =  "0" + date;
        return date;
    }
}
