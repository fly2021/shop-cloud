package com.youlai.mall.oms;


import com.youlai.mall.pms.api.app.InventoryFeignService;
import com.youlai.mall.ums.api.app.MemberFeignService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = { MemberFeignService.class, InventoryFeignService.class})
@MapperScan({ "com.youlai.mall.oms.mapper","com.youlai.mall.oms.dao"})
@EnableRabbit
public class OmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmsApplication.class);
    }

}
