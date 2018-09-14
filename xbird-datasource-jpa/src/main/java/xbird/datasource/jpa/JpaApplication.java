package xbird.datasource.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ, proxyTargetClass = true)
@EnableJpaRepositories({"xbird.datasource.jpa.repository"})
@EntityScan("xbird.datasource.jpa.domain") // 实体类扫描
@EnableJpaAuditing // 审计支持
public class JpaApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(JpaApplication.class, args);
  }

}
