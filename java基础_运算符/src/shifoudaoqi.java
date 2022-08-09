import java.time.*;

public class shifoudaoqi {
    public static void main(String[] args) {
        //计算是否定期到期
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2015,5,3);
        System.out.println(date2.isAfter(date1) ? "到期" : "没到期");
    }
}
