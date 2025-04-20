package com.sdlg.job;

import com.sdlg.mapper.TSetmealMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UpdataOrdersJob {

    @Resource
    private TSetmealMapper tSetmealMapper;

    //更新到期的订单状态为已完成
    //cron = "0 0 0 * * ?"表示每天执行一次，演示中可以用cron = "0/10 * * * * ?"每10s一次
    @Scheduled(cron = "0/10 * * * * ?")
    public void updateOrders(){
        tSetmealMapper.updateOrders();
    }

    //删除超时未支付的订单
    @Scheduled(cron = "0/10 * * * * ?")
    public void deleteOuttimeOrders(){
        tSetmealMapper.deleteOuttimeOrders();
    }

    //定时同步订单销量到ordersetting
    @Scheduled(cron = "0/10 * * * * ?")
    public void updateOrdersetting(){
        tSetmealMapper.updateOrdersetting();
    }
}