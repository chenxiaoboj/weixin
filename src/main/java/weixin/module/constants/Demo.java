package weixin.module.constants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author chenxiaobo 2019-06-22 17:10
 */
public class Demo {
    public static void main(String[] args) {
        Long time = System.currentTimeMillis();
        Long time3 = LocalDateTime.parse((LocalDate.now().toString() + " 07:00:00"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println(time);
        System.out.println(time3);
    }
}
