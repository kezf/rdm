package org.miser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author Barry
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("org.miser.**.mapper")
public class RdmApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RdmApplication.class, args);
        System.out.println(
                "  ______  ____  __  __   ____ _____  _    ____ _______\n" +
                        " / /  _ \\|  _ \\|  \\/  | / ___|_   _|/ \\  |  _ \\_   _\\ \\\n" +
                        "/ /| |_) | | | | |\\/| | \\___ \\ | | / _ \\ | |_) || |  \\ \\\n" +
                        "\\ \\|  _ <| |_| | |  | |  ___) || |/ ___ \\|  _ < | |  / /\n" +
                        " \\_\\_| \\_\\____/|_|  |_| |____/ |_/_/   \\_\\_| \\_\\|_| /_/\n");
    }
}